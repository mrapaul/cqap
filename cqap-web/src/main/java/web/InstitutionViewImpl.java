package web;

import com.peirs.datamodel.*;
import com.vaadin.data.*;
import com.vaadin.data.util.*;
import com.vaadin.navigator.*;
import com.vaadin.server.*;
import com.vaadin.ui.*;
import org.jetbrains.annotations.*;
import org.tepi.filtertable.*;
import org.vaadin.maddon.layouts.*;

import static web.ComponentFactory.*;

public class InstitutionViewImpl extends VerticalLayout implements InstitutionView
{
    private static final String FNAME = "name";
    @NotNull private final FilterTable table;
    @NotNull private final Button addButton;
    @NotNull private final Button removeButton;
    @NotNull private final Button saveButton;
    @NotNull private final VerticalLayout editorLayout;
    @NotNull private final TextField nameField;
    @NotNull private final TextField aliasField;
    @NotNull private final TextField codeField;
    @NotNull private final TextField websiteField;
    @NotNull private final TextField notesField;
    @NotNull private final TextField addressField;
    @NotNull private final TextField address1Field;
    @NotNull private final TextField cityField;
    @NotNull private final TextField stateField;
    @NotNull private final TextField zipcodeField;
    @NotNull private final ComboBox countryField;
    @NotNull private final ComboBox timezoneField;
    @NotNull private final TextField phoneField;
    @NotNull private final TextField faxField;
    @NotNull private final TextField emailAddressField;
    @NotNull private final TextField contactField;
    @NotNull private final OptionGroup radiologists;
    @Nullable private InstitutionViewListener listener;

    public InstitutionViewImpl()
    {
        table = new FilterTable();
        addButton = new Button();
        removeButton = new Button();
        saveButton = new Button();
        editorLayout = new VerticalLayout();
        nameField = createFormTextField("Name");
        aliasField = createFormTextField("Alias(es)");
        codeField = createFormTextField("Code");
        websiteField = createFormTextField("Website");
        notesField = createFormTextField("Notes");
        addressField = createFormTextField("Address");
        address1Field = createFormTextField("Address 1");
        cityField = createFormTextField("City");
        stateField = createFormTextField("State");
        zipcodeField = createFormTextField("Zipcode");
        countryField = createFormComboBoxField("Country");
        timezoneField = createFormComboBoxField("Timezone");
        phoneField = createFormTextField("QA Phone");
        faxField = createFormTextField("QA Fax");
        emailAddressField = createFormTextField("QA Email");
        contactField = createFormTextField("QA Contact");
        radiologists = new OptionGroup();

        initLayout();
        initEditor();
        initAddRemoveButtons();
    }

    @Override public void setListener(@NotNull InstitutionViewListener listener)
    {
        this.listener = listener;
    }

    @Override public void setContainers(@NotNull Container institutionContainer,
                                        @NotNull Container userContainer,
                                        @NotNull Container countriesContainer,
                                        @NotNull Container timezonesContainer)
    {
        radiologists.removeAllItems();
        table.setContainerDataSource(institutionContainer);
        radiologists.setContainerDataSource(userContainer);
        countryField.setContainerDataSource(countriesContainer);
        timezoneField.setContainerDataSource(timezonesContainer);
        initTable();
    }

    private void initLayout()
    {
        setSizeFull();
        setMargin(true);

        radiologists.setMultiSelect(true);
        radiologists.setNullSelectionAllowed(false);

        addButton.addStyleName("fq");
        removeButton.addStyleName("fq");
        saveButton.addStyleName("fq");
        addButton.setIcon(FontAwesome.PLUS);
        removeButton.setIcon(FontAwesome.MINUS);
        saveButton.setIcon(FontAwesome.SAVE);

        Label pageLabel = new Label("Institutions");
        pageLabel.addStyleName("h1");
        MHorizontalLayout buttonGroup = new MHorizontalLayout(addButton, saveButton, removeButton).withSpacing(true);
        HorizontalLayout topLayout = new HorizontalLayout(pageLabel, buttonGroup);
        topLayout.setWidth("100%");
        topLayout.setMargin(true);
        topLayout.setComponentAlignment(buttonGroup, Alignment.BOTTOM_RIGHT);

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

    private void initEditor()
    {
        editorLayout.setMargin(true);
        editorLayout.setSpacing(true);
        editorLayout.setVisible(false);

        nameField.setNullRepresentation("");
        aliasField.setNullRepresentation("");
        codeField.setNullRepresentation("");
        websiteField.setNullRepresentation("");
        notesField.setNullRepresentation("");
        addressField.setNullRepresentation("");
        address1Field.setNullRepresentation("");
        cityField.setNullRepresentation("");
        stateField.setNullRepresentation("");
        zipcodeField.setNullRepresentation("");
        phoneField.setNullRepresentation("");
        faxField.setNullRepresentation("");
        emailAddressField.setNullRepresentation("");
        contactField.setNullRepresentation("");

        Panel insPanel = new Panel("Institution Details", new MVerticalLayout(nameField,
                aliasField,
                codeField,
                websiteField,
                notesField,
                contactField).withMargin(true).withSpacing(true));
        Panel addressPanel = new Panel("Address", new MVerticalLayout(addressField,
                address1Field,
                cityField,
                stateField,
                zipcodeField,
                countryField,
                timezoneField).withMargin(true).withSpacing(true));
        Panel phonePanel = new Panel("Phone Numbers", new MVerticalLayout(phoneField, faxField)
                .withMargin(true).withSpacing(true));
        Panel emailPanel = new Panel("Email", new MVerticalLayout(emailAddressField)
                .withMargin(true).withSpacing(true));
        Panel radiologistsPanel = new Panel("Radiologists", new MVerticalLayout(radiologists)
                .withMargin(true).withSpacing(true));
        insPanel.setSizeFull();
        addressPanel.setSizeFull();
        phonePanel.setSizeFull();
        emailPanel.setSizeFull();
        radiologistsPanel.setSizeFull();

        editorLayout.addComponent(new MHorizontalLayout(insPanel, addressPanel)
                .withFullHeight()
                .withFullWidth()
                .withSpacing(true));
        editorLayout.addComponent(new MHorizontalLayout(phonePanel, emailPanel)
                .withFullHeight()
                .withFullWidth()
                .withSpacing(true));
        editorLayout.addComponent(radiologistsPanel);
    }

    private void setDataSources(@NotNull Institution institution)
    {

        if (institution.getAddress() == null)
        {
            institution.setAddress(new Address());
        }
        if (institution.getBillingPhone() == null)
        {
            institution.setBillingPhone(new Phone());
        }
        if (institution.getBillingFax() == null)
        {
            institution.setBillingFax(new Phone());
        }
        if (institution.getBillingEmail() == null)
        {
            institution.setBillingEmail(new Email());
        }
        if (institution.getOutgoingReportConfiguration() == null)
        {
            institution.setOutgoingReportConfiguration(new HL7OutgoingConfiguration());
        }

        BeanItem<Institution> institutionBean = new BeanItem<Institution>(institution);
        final BeanItem<Address> addressBean = new BeanItem<Address>(institution.getAddress());
        BeanItem<Phone> phoneBean = new BeanItem<Phone>(institution.getBillingPhone());
        BeanItem<Phone> faxBean = new BeanItem<Phone>(institution.getBillingFax());
        BeanItem<Email> emailBean = new BeanItem<Email>(institution.getBillingEmail());
        BeanItem<HL7OutgoingConfiguration> osirixBean =
                new BeanItem<HL7OutgoingConfiguration>(institution.getOutgoingReportConfiguration());

        nameField.setPropertyDataSource(institutionBean.getItemProperty("name"));
        aliasField.setPropertyDataSource(institutionBean.getItemProperty("alias"));
        codeField.setPropertyDataSource(institutionBean.getItemProperty("code"));
        websiteField.setPropertyDataSource(institutionBean.getItemProperty("website"));
        notesField.setPropertyDataSource(institutionBean.getItemProperty("notes"));
        addressField.setPropertyDataSource(addressBean.getItemProperty("address"));
        address1Field.setPropertyDataSource(addressBean.getItemProperty("address1"));
        cityField.setPropertyDataSource(addressBean.getItemProperty("city"));
        stateField.setPropertyDataSource(addressBean.getItemProperty("state"));
        zipcodeField.setPropertyDataSource(addressBean.getItemProperty("zipcode"));
        timezoneField.setPropertyDataSource(addressBean.getItemProperty("timeZone"));
        phoneField.setPropertyDataSource(phoneBean.getItemProperty("number"));
        faxField.setPropertyDataSource(faxBean.getItemProperty("number"));
        emailAddressField.setPropertyDataSource(emailBean.getItemProperty("address"));
        contactField.setPropertyDataSource(institutionBean.getItemProperty("billingContactName"));
        radiologists.setPropertyDataSource(institutionBean.getItemProperty("radiologists"));
        if (institution.getAddress() != null && institution.getAddress().getCountry() != null)
        {
            Country country = institution.getAddress().getCountry();
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
    }

    private void initAddRemoveButtons()
    {
        addButton.addClickListener(new Button.ClickListener()
        {
            public void buttonClick(Button.ClickEvent event)
            {
                if (listener != null)
                {
                    listener.addInstitution();
                }
            }
        });

        saveButton.addClickListener(new Button.ClickListener()
        {
            @Override public void buttonClick(Button.ClickEvent event)
            {

                Object name = table.getValue();
                Institution institution = ((BeanItem<Institution>) table.getItem(name)).getBean();
                if (institution.getId().equals("unassigned"))
                {
                    institution.setId(null);
                }
                if (listener != null)
                {
                    listener.createOrUpdate(institution);
                    Notification.show("Institution created/updated");
                }
            }
        });

        removeButton.addClickListener(new Button.ClickListener()
        {
            public void buttonClick(Button.ClickEvent event)
            {
                Object id = table.getValue();
                Institution institution = ((BeanItem<Institution>) table.getItem(id)).getBean();
                editorLayout.setVisible(false);
                if (listener != null)
                {
                    listener.delete(institution);
                }
            }
        });
    }

    private void initTable()
    {
        table.setSizeFull();
        table.setFilterBarVisible(true);
        table.addStyleName("plain");
        table.setVisibleColumns(new String[]{FNAME});
        table.setColumnHeader(FNAME, "Institution Name");
        table.setSelectable(true);
        table.setImmediate(true);
        table.addValueChangeListener(new Property.ValueChangeListener()
        {
            public void valueChange(Property.ValueChangeEvent event)
            {
                Object id = table.getValue();
                BeanItem<Institution> item = (BeanItem<Institution>) table.getItem(id);
                if (item != null)
                {
                    Institution institution = item.getBean();
                    editorLayout.setVisible(id != null);
                    setDataSources(institution);
                }
            }
        });
    }

    @Override public void editNewInstitution(@NotNull String newItemId)
    {
        table.select(newItemId);
        BeanItem<Institution> item = (BeanItem<Institution>) table.getItem(newItemId);
        if (item != null)
        {
            Institution institution = item.getBean();
            editorLayout.setVisible(true);
            setDataSources(institution);
            nameField.focus();
        }
    }
}
