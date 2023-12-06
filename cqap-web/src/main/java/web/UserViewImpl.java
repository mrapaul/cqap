package web;

import com.google.common.collect.*;
import com.peirs.datamodel.*;
import com.vaadin.data.*;
import com.vaadin.data.util.*;
import com.vaadin.navigator.*;
import com.vaadin.server.*;
import com.vaadin.ui.*;
import org.jetbrains.annotations.*;
import org.tepi.filtertable.*;
import org.vaadin.maddon.layouts.*;

import java.util.*;

import static ch.lambdaj.Lambda.*;
import static ch.lambdaj.collection.LambdaCollections.*;
import static web.ComponentFactory.*;

public class UserViewImpl extends VerticalLayout implements UserView
{
    private static final String FNAME = "name";
    @NotNull private final FilterTable table;
    @NotNull private final Button addButton;
    @NotNull private final Button removeButton;
    @NotNull private final Button saveButton;
    @NotNull private final Button resetPasswordButton;
    @NotNull private final VerticalLayout editorLayout;
    @NotNull private final TextField nameField;
    @NotNull private final TextField usernameField;
    @NotNull private final TextField aliasField;
    @NotNull private final TextField positionField;
    @NotNull private final ComboBox roleField;
    @NotNull private final OptionGroup institutionField;
    @NotNull private final TextField addressField;
    @NotNull private final TextField address1Field;
    @NotNull private final TextField cityField;
    @NotNull private final TextField stateField;
    @NotNull private final TextField zipcodeField;
    @NotNull private final ComboBox countryField;
    @NotNull private final ComboBox timezoneField;
    @NotNull private final TextField phoneField;
    @NotNull private final TextField faxField;
    @NotNull private final TextField cellPhoneField;
    @NotNull private final TextField emailAddressField;
    @NotNull private final TextField osirixHostField;
    @NotNull private final TextField osirixPortField;
    @NotNull private final TextField osirixServerField;
    @NotNull private final OptionGroup secondaryCPTCodes;
    @NotNull private final OptionGroup primaryCPTCodes;
    @Nullable private UserViewListener listener;

    public UserViewImpl()
    {
        table = new FilterTable();
        addButton = new Button();
        removeButton = new Button();
        saveButton = new Button();
        resetPasswordButton = new Button();
        editorLayout = new VerticalLayout();
        nameField = createFormTextField("Name");
        usernameField = createFormTextField("Username");
        aliasField = createFormTextField("Alias(es)");
        positionField = createFormTextField("Position");
        roleField = createFormComboBoxField("Role", Arrays.asList(Role.values()));
        institutionField = new OptionGroup("Institution");
        addressField = createFormTextField("Address");
        address1Field = createFormTextField("Address 1");
        cityField = createFormTextField("City");
        stateField = createFormTextField("State");
        zipcodeField = createFormTextField("Zipcode");
        countryField = createFormComboBoxField("Country");
        timezoneField = createFormComboBoxField("Timezone");
        phoneField = createFormTextField("Phone");
        faxField = createFormTextField("Fax");
        cellPhoneField = createFormTextField("Cell Phone");
        emailAddressField = createFormTextField("Email");
        osirixHostField = createFormTextField("Osirix Host");
        osirixPortField = createFormTextField("Osirix Port");
        osirixServerField = createFormTextField("Osirix Server");
        primaryCPTCodes = new OptionGroup("Primary Subspecialties");
        secondaryCPTCodes = new OptionGroup("Secondary Subspecialities");

        initLayout();
        initEditor();
        initAddRemoveButtons();
    }

    private void initLayout()
    {
        setSizeFull();
        setMargin(true);

        addButton.addStyleName("fq");
        removeButton.addStyleName("fq");
        saveButton.addStyleName("fq");
        resetPasswordButton.addStyleName("fq");
        addButton.setIcon(FontAwesome.PLUS);
        removeButton.setIcon(FontAwesome.MINUS);
        saveButton.setIcon(FontAwesome.SAVE);
        resetPasswordButton.setIcon(FontAwesome.UNLOCK);

        Label pageLabel = new Label("Users");
        pageLabel.addStyleName("h1");
        MHorizontalLayout
                buttonGroup =
                new MHorizontalLayout(addButton, saveButton, removeButton, resetPasswordButton).withSpacing(true);
        HorizontalLayout topLayout = new HorizontalLayout(pageLabel, buttonGroup);
        topLayout.setWidth("100%");
        topLayout.setMargin(true);
        topLayout.setComponentAlignment(buttonGroup, Alignment.BOTTOM_RIGHT);

        primaryCPTCodes.setMultiSelect(true);
        secondaryCPTCodes.setMultiSelect(true);
        institutionField.setMultiSelect(true);

        HorizontalSplitPanel splitPanel = new HorizontalSplitPanel(table, editorLayout);
        splitPanel.setSplitPosition(25, Unit.PERCENTAGE);
        splitPanel.setSizeFull();
        addComponent(topLayout);
        addComponent(splitPanel);
        setExpandRatio(splitPanel, 1f);
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent)
    {
        if (listener != null)
        {
            listener.viewEntered();
        }
    }

    @Override public void setContainers(@NotNull Container userContainer,
                                        @NotNull Container institutionContainer,
                                        @NotNull Container primaryCPTCodesContainer,
                                        @NotNull Container secondaryCPTCodesContainer,
                                        @NotNull Container countriesContainer,
                                        @NotNull Container timezonesContainer)
    {
        initContactList(userContainer);
        institutionField.setContainerDataSource(institutionContainer);
        countryField.setContainerDataSource(countriesContainer);
        timezoneField.setContainerDataSource(timezonesContainer);
        primaryCPTCodes.setContainerDataSource(primaryCPTCodesContainer);
        secondaryCPTCodes.setContainerDataSource(secondaryCPTCodesContainer);
    }

    @Override public void setListener(@NotNull UserViewListener listener)
    {
        this.listener = listener;
    }

    private void initEditor()
    {
        editorLayout.setMargin(true);
        editorLayout.setSpacing(true);
        editorLayout.setVisible(false);

        Panel userPanel = new Panel("User Details", new MVerticalLayout(nameField,
                usernameField,
                aliasField,
                positionField,
                roleField,
                institutionField).withSpacing(true).withMargin(true));
        Panel addressPanel = new Panel("Address", new MVerticalLayout(addressField,
                address1Field,
                cityField,
                stateField,
                zipcodeField,
                countryField,
                timezoneField).withSpacing(true).withMargin(true));
        Panel phonePanel = new Panel("Phone Numbers", new MVerticalLayout(phoneField, faxField, cellPhoneField)
                .withSpacing(true).withMargin(true));
        Panel emailPanel = new Panel("Email", new MVerticalLayout(emailAddressField)
                .withSpacing(true).withMargin(true));
        Panel osirixPanel = new Panel("OsiriX Settings", new MVerticalLayout(osirixHostField,
                osirixPortField,
                osirixServerField).withSpacing(true).withMargin(true));
        Panel
                cptCodesPanel =
                new Panel("CPT Code Preferences", new MHorizontalLayout(primaryCPTCodes, secondaryCPTCodes)
                        .withSpacing(true).withMargin(true));
        Panel institutionsPanel = new Panel("Institutions", new MHorizontalLayout(institutionField)
                .withSpacing(true).withMargin(true));


        userPanel.setSizeFull();
        addressPanel.setSizeFull();
        phonePanel.setSizeFull();
        emailPanel.setSizeFull();
        osirixPanel.setSizeFull();
        cptCodesPanel.setSizeFull();

        editorLayout.addComponent(new MHorizontalLayout(userPanel, addressPanel).withFullHeight()
                .withFullWidth()
                .withSpacing(true)
                .withMargin(true));
        editorLayout.addComponent(new MHorizontalLayout(phonePanel, emailPanel, osirixPanel).withFullHeight()
                .withFullWidth()
                .withSpacing(true)
                .withMargin(true));
        editorLayout.addComponent(new MHorizontalLayout(cptCodesPanel, institutionsPanel).withFullHeight()
                .withFullWidth()
                .withSpacing(true)
                .withMargin(true));
    }

    private void setDataSources(@NotNull final User user)
    {
        if (user.getCPTPrimarySpecialities() == null)
        {
            user.setCPTPrimarySpecialities(Sets.<String>newHashSet());
        }
        if (user.getCPTSecondarySpecialities() == null)
        {
            user.setCPTSecondarySpecialities(Sets.<String>newHashSet());
        }
        if (user.getAddress() == null)
        {
            user.setAddress(new Address());
        }
        if (user.getPhoneNumber() == null)
        {
            user.setPhoneNumber(new Phone());
        }
        if (user.getCellPhoneNumber() == null)
        {
            user.setCellPhoneNumber(new Phone());
        }
        if (user.getFaxNumber() == null)
        {
            user.setFaxNumber(new Phone());
        }
        if (user.getEmail() == null)
        {
            user.setEmail(new Email());
        }
        if (user.getOsirixConfiguration() == null)
        {
            user.setOsirixConfiguration(new OsirixConfiguration());
        }

        final BeanItem<User> userBean = new BeanItem<User>(user);
        final BeanItem<Address> addressBean = new BeanItem<Address>(user.getAddress());
        BeanItem<Phone> phoneBean = new BeanItem<Phone>(user.getPhoneNumber());
        BeanItem<Phone> faxBean = new BeanItem<Phone>(user.getFaxNumber());
        BeanItem<Phone> cellPhoneBean = new BeanItem<Phone>(user.getCellPhoneNumber());
        BeanItem<Email> emailBean = new BeanItem<Email>(user.getEmail());
        BeanItem<OsirixConfiguration> osirixBean = new BeanItem<OsirixConfiguration>(user.getOsirixConfiguration());

        nameField.setPropertyDataSource(userBean.getItemProperty("name"));
        usernameField.setPropertyDataSource(userBean.getItemProperty("username"));
        aliasField.setPropertyDataSource(userBean.getItemProperty("alias"));
        positionField.setPropertyDataSource(userBean.getItemProperty("position"));
        roleField.setPropertyDataSource(userBean.getItemProperty("role"));
        addressField.setPropertyDataSource(addressBean.getItemProperty("address"));
        address1Field.setPropertyDataSource(addressBean.getItemProperty("address1"));
        cityField.setPropertyDataSource(addressBean.getItemProperty("city"));
        stateField.setPropertyDataSource(addressBean.getItemProperty("state"));
        zipcodeField.setPropertyDataSource(addressBean.getItemProperty("zipcode"));
        timezoneField.setPropertyDataSource(addressBean.getItemProperty("timeZone"));
        phoneField.setPropertyDataSource(phoneBean.getItemProperty("number"));
        faxField.setPropertyDataSource(faxBean.getItemProperty("number"));
        cellPhoneField.setPropertyDataSource(cellPhoneBean.getItemProperty("number"));
        emailAddressField.setPropertyDataSource(emailBean.getItemProperty("address"));
        osirixHostField.setPropertyDataSource(osirixBean.getItemProperty("host"));
        osirixPortField.setPropertyDataSource(osirixBean.getItemProperty("port"));
        osirixServerField.setPropertyDataSource(osirixBean.getItemProperty("server"));
        primaryCPTCodes.setPropertyDataSource(userBean.getItemProperty("CPTPrimarySpecialities"));
        secondaryCPTCodes.setPropertyDataSource(userBean.getItemProperty("CPTSecondarySpecialities"));
        if (user.getAddress() != null && user.getAddress().getCountry() != null)
        {
            Country country = user.getAddress().getCountry();
            countryField.select(country.getName());
            if (listener != null)
            {
                listener.countrySelected(country);
            }
        }
        countryField.addValueChangeListener(new Property.ValueChangeListener()
        {
            @Override public void valueChange(Property.ValueChangeEvent event)
            {
                Country country = ((BeanItem<Country>) countryField.getContainerDataSource()
                        .getItem(countryField.getValue())).getBean();
                addressBean.getBean().setCountry(country);
                if (listener != null)
                {
                    listener.countrySelected(country);
                }
            }
        });
        institutionField.setValue(Sets.newHashSet(with(user.getInstitutions()).extract(on(Institution.class).getName())));

        nameField.setNullRepresentation("");
        usernameField.setNullRepresentation("");
        aliasField.setNullRepresentation("");
        positionField.setNullRepresentation("");
        addressField.setNullRepresentation("");
        address1Field.setNullRepresentation("");
        cityField.setNullRepresentation("");
        stateField.setNullRepresentation("");
        zipcodeField.setNullRepresentation("");
        phoneField.setNullRepresentation("");
        faxField.setNullRepresentation("");
        cellPhoneField.setNullRepresentation("");
        emailAddressField.setNullRepresentation("");
        osirixHostField.setNullRepresentation("");
        osirixPortField.setNullRepresentation("");
        osirixServerField.setNullRepresentation("");
    }

    private void initAddRemoveButtons()
    {
        addButton.addClickListener(new Button.ClickListener()
        {
            public void buttonClick(Button.ClickEvent event)
            {
                if (listener != null)
                {
                    listener.addUser();
                }
            }
        });

        saveButton.addClickListener(new Button.ClickListener()
        {
            @Override public void buttonClick(Button.ClickEvent event)
            {
                Object username = table.getValue();

                User user = ((BeanItem<User>) table.getItem(username)).getBean();
                if (user.getId().equals("unassigned"))
                {
                    user.setId(null);
                }
                if (listener != null)
                {
                    Set<String> institutionValues = (Set<String>) institutionField.getValue();
                    List<Institution> institutions = Lists.newArrayList();
                    for (String institutionValue : institutionValues)
                    {
                        BeanItem<Institution>
                                item =
                                (BeanItem<Institution>) institutionField.getContainerDataSource()
                                        .getItem(institutionValue);
                        if (item != null)
                        {
                            institutions.add(item.getBean());
                        }
                    }
                    user.setInstitutions(institutions);
                    listener.createOrUpdate(user);
                    Notification.show("User created/updated");
                }
            }
        });

        removeButton.addClickListener(new Button.ClickListener()
        {
            public void buttonClick(Button.ClickEvent event)
            {
                Object contactId = table.getValue();
                User user = ((BeanItem<User>) table.getItem(contactId)).getBean();
                editorLayout.setVisible(false);
                if (listener != null)
                {
                    listener.delete(user);
                }
            }
        });
    }

    private void initContactList(@NotNull Container userContainer)
    {
        table.setSizeFull();
        table.setFilterBarVisible(true);
        table.addStyleName("plain");
        table.setContainerDataSource(userContainer);
        table.setVisibleColumns(new String[]{FNAME});
        table.setColumnHeader(FNAME, "Name");
        table.setSelectable(true);
        table.setImmediate(true);
        table.addValueChangeListener(new Property.ValueChangeListener()
        {
            public void valueChange(Property.ValueChangeEvent event)
            {
                Object contactId = table.getValue();
                BeanItem<User> item = (BeanItem<User>) table.getItem(contactId);
                if (item != null)
                {
                    User user = item.getBean();
                    editorLayout.setVisible(contactId != null);
                    setDataSources(user);
                }
            }
        });
    }

    @Override public void editNewUser(@NotNull String newItemId)
    {
        table.select(newItemId);
        BeanItem<User> item = (BeanItem<User>) table.getItem(newItemId);
        if (item != null)
        {
            User user = item.getBean();
            editorLayout.setVisible(true);
            setDataSources(user);
            nameField.focus();
        }
    }
}
