package web;

import com.lakeland.ris.ui.datamodel.*;
import com.peirs.datamodel.*;
import com.peirs.datamodel.dicom.*;
import com.vaadin.data.*;
import com.vaadin.data.util.*;
import com.vaadin.event.*;
import com.vaadin.server.*;
import com.vaadin.shared.ui.label.*;
import com.vaadin.ui.*;
import org.jetbrains.annotations.*;
import org.slf4j.*;
import org.vaadin.maddon.layouts.*;

import java.util.*;

import static org.apache.commons.lang3.StringUtils.*;
import static web.ComponentFactory.*;

public final class ExternalImagesView extends VerticalLayout
{
    private static final Logger LOGGER = LoggerFactory.getLogger(ExternalImagesView.class);
    @NotNull private final Table pacsTable;
    @NotNull private final Button addPacsButton;
    @NotNull private final Button savePacsButton;
    @NotNull private final Button deletePacsButton;
    @NotNull private final Button refreshPacsButton;
    @NotNull private final TextField pacsHostField;
    @NotNull private final TextField pacsPortField;
    @NotNull private final TextField pacsAETField;
    @NotNull private final TextField pacsDescriptionField;
    @NotNull private final Table externalImagesTable;
    @NotNull private final Table internalImagesTable;
    @NotNull private final DateField studyDateField;
    @NotNull private final Button searchButton;
    @NotNull private final Button clearButton;
    @NotNull private final Button importStudyButton;
    @NotNull private final Label imageDetailsLabel;
    @NotNull private final TextField filterField;
    @Nullable private NewTicketView.Listener listener;
    private FormLayout pacsEditor;

    public ExternalImagesView()
    {
        pacsTable = new Table();
        addPacsButton = new Button();
        savePacsButton = new Button();
        deletePacsButton = new Button();
        refreshPacsButton = new Button();
        externalImagesTable = new Table();
        internalImagesTable = new Table();
        pacsHostField = createFormTextField("Host");
        pacsPortField = createFormTextField("Port");
        pacsAETField = createFormTextField("AE Title");
        pacsDescriptionField = createFormTextField("Description");
        studyDateField = createFormDateField("Study Date");
        searchButton = new Button();
        clearButton = new Button();
        importStudyButton = createFormButton("Import Image");
        imageDetailsLabel = new Label();
        filterField = createFormTextField("Filter");
    }

    public void initialize()
    {
        initLayout();
        initListeners();
    }

    private void initLayout()
    {
        addStyleName("worklist-view");
        setSizeFull();
        setImmediate(true);

        searchButton.setIcon(FontAwesome.SEARCH);
        clearButton.setIcon(FontAwesome.ERASER);
        externalImagesTable.setImmediate(true);
        externalImagesTable.setSizeFull();
        externalImagesTable.addStyleName("plain");
        internalImagesTable.setImmediate(true);
        internalImagesTable.setSizeFull();
        internalImagesTable.addStyleName("plain");
        studyDateField.setDateFormat("yyyy-MM-dd");
        studyDateField.setValue(new Date());


        Component pacsPanel = createPACSPanel();
        addComponent(pacsPanel);
        setExpandRatio(pacsPanel, 1f);

        Component horizontalLayout = createTopLayout();
        addComponent(horizontalLayout);
        setComponentAlignment(horizontalLayout, Alignment.MIDDLE_LEFT);

        Component workflowPanel = createCenterLayout();
        addComponent(workflowPanel);
        setExpandRatio(workflowPanel, 2.0f);

        addComponent(createBottomLayout());
    }

    private Component createBottomLayout()
    {
        HorizontalLayout bottomLayout = new HorizontalLayout(importStudyButton);
        bottomLayout.setComponentAlignment(importStudyButton, Alignment.BOTTOM_CENTER);
        bottomLayout.setWidth("100%");
        bottomLayout.setMargin(true);
        return bottomLayout;
    }

    private Component createCenterLayout()
    {
        imageDetailsLabel.addStyleName("h2");
        VerticalLayout internalLayout = new VerticalLayout(internalImagesTable);
        internalLayout.setSizeFull();
        HorizontalLayout centerLayout = new HorizontalLayout(externalImagesTable, internalLayout, imageDetailsLabel);
        centerLayout.setMargin(true);
        centerLayout.setSpacing(true);
        centerLayout.setSizeFull();
        Panel workflowPanel = new Panel(centerLayout);
        workflowPanel.setSizeFull();
        return workflowPanel;
    }

    private Component createTopLayout()
    {
        Label label = new Label("External Images");
        label.setStyleName("h1");
        HorizontalLayout searchLayout = new HorizontalLayout(studyDateField, searchButton, clearButton);
        searchLayout.setSpacing(true);
        HorizontalLayout horizontalLayout = new HorizontalLayout(label, filterField, searchLayout);
        horizontalLayout.setWidth("100%");
        horizontalLayout.setMargin(true);
        horizontalLayout.setComponentAlignment(filterField, Alignment.MIDDLE_CENTER);
        horizontalLayout.setComponentAlignment(searchLayout, Alignment.MIDDLE_RIGHT);
        return horizontalLayout;
    }

    private Component createPACSPanel()
    {
        addPacsButton.setIcon(FontAwesome.PLUS);
        savePacsButton.setIcon(FontAwesome.SAVE);
        deletePacsButton.setIcon(FontAwesome.TRASH_O);
        refreshPacsButton.setIcon(FontAwesome.REFRESH);
        addPacsButton.addStyleName("fq");
        savePacsButton.addStyleName("fq");
        deletePacsButton.addStyleName("fq");
        refreshPacsButton.addStyleName("fq");
        pacsTable.setImmediate(true);
        pacsTable.setSizeFull();
        pacsTable.addStyleName("plain");
        pacsTable.setSelectable(true);
        pacsHostField.setNullRepresentation("");
        pacsPortField.setNullRepresentation("0");
        pacsAETField.setNullRepresentation("");
        pacsDescriptionField.setNullRepresentation("");

        MVerticalLayout
                pacsToolbar =
                new MVerticalLayout(addPacsButton,
                        savePacsButton,
                        deletePacsButton,
                        refreshPacsButton).withSpacing(true).withFullHeight();
        pacsEditor = new FormLayout(pacsHostField,
                pacsPortField,
                pacsAETField,
                pacsDescriptionField);
        pacsEditor.setSizeFull();
        pacsEditor.setSpacing(true);
        MHorizontalLayout pacsEditorLayout = new MHorizontalLayout(pacsEditor, pacsToolbar)
                .withSpacing(true)
                .withMargin(true)
                .withFullHeight()
                .withFullWidth();
        Panel panel = new Panel("PACS Editor", pacsEditorLayout);
        panel.setSizeFull();
        CssLayout tableLayout = new CssLayout(pacsTable);
        tableLayout.setSizeFull();
        Panel pacsLocationsPanel = new Panel("PACS Locations", tableLayout);
        pacsEditor.setVisible(false);

        return new MHorizontalLayout(pacsLocationsPanel, panel).withMargin(true).withFullHeight().withFullWidth();
    }

    private void initListeners()
    {
        clearButton.addClickListener(new Button.ClickListener()
        {
            @Override public void buttonClick(Button.ClickEvent event)
            {
                studyDateField.setValue(null);
            }
        });
        searchButton.addClickListener(new Button.ClickListener()
        {
            @Override public void buttonClick(Button.ClickEvent event)
            {
                Object itemId = pacsTable.getValue();
                if (listener != null && itemId != null)
                {
                    BeanItem<PACS> item = ((BeanContainer<String, PACS>) pacsTable.getContainerDataSource())
                            .getItem(itemId);
                    if (item != null)
                    {
                        listener.refreshExternalImages(item.getBean(), studyDateField.getValue());
                    }
                    else
                    {
                        Notification.show("Please select a PACS location", Notification.Type.ERROR_MESSAGE);
                    }
                }
                else
                {
                    Notification.show("Please select a PACS location", Notification.Type.ERROR_MESSAGE);
                }
            }
        });
        importStudyButton.addClickListener(new Button.ClickListener()
        {
            @Override public void buttonClick(Button.ClickEvent event)
            {
                try
                {
                    Object externalImageItemId = externalImagesTable.getValue();
                    BeanContainer<String, ExternalDicomStudy>
                            externalImagesTableContainerDataSource
                            = (BeanContainer<String, ExternalDicomStudy>) externalImagesTable.getContainerDataSource();
                    BeanContainer<String, DicomStudyQueryResult>
                            internalImagesTableContainerDataSource
                            = (BeanContainer<String, DicomStudyQueryResult>) internalImagesTable.getContainerDataSource();

                    if (externalImageItemId == null)
                    {
                        Notification.show("Please select an external image.", Notification.Type.WARNING_MESSAGE);

                        return;
                    }

                    Object internalImageItemId = internalImagesTable.getValue();

                    if (internalImageItemId == null && internalImagesTableContainerDataSource.size() > 0)
                    {
                        Notification.show("Please select an internal image.", Notification.Type.WARNING_MESSAGE);

                        return;
                    }

                    if (internalImagesTableContainerDataSource.size() == 0)
                    {
                        ExternalDicomStudy externalDicomStudy = externalImagesTableContainerDataSource.getItem(
                                externalImageItemId).getBean();

                        if (listener != null && externalDicomStudy != null)
                        {
                            Object itemId = pacsTable.getValue();
                            if (itemId != null)
                            {
                                PACS pacs = ((BeanContainer<String, PACS>) pacsTable.getContainerDataSource())
                                        .getItem(itemId)
                                        .getBean();

                                listener.importImage(pacs, externalDicomStudy);

                                Notification.show("External image imported");

                                listener.searchForInternalImagesForExternalImage(externalDicomStudy);
                            }
                        }
                        else
                        {
                            Notification.show("External study is null");
                        }
                    }
                }
                catch (Exception e)
                {
                    LOGGER.error("Error importing image", e);
                }
            }
        });
        filterField.addTextChangeListener(new FieldEvents.TextChangeListener()
        {
            @Override public void textChange(FieldEvents.TextChangeEvent event)
            {
                if (listener != null)
                {
                    listener.filter(event.getText());
                }
            }
        });

        addPacsButton.addClickListener(new Button.ClickListener()
        {
            @Override public void buttonClick(Button.ClickEvent event)
            {
                if (listener != null)
                {
                    listener.addPACS();
                }
            }
        });
        savePacsButton.addClickListener(new Button.ClickListener()
        {
            @Override public void buttonClick(Button.ClickEvent event)
            {
                Object itemId = pacsTable.getValue();

                if (itemId != null)
                {
                    BeanItem<PACS> item = (BeanItem<PACS>) pacsTable.getItem(itemId);
                    if (item != null)
                    {
                        PACS pacs = item.getBean();
                        if (isEmpty(pacs.getHost()) ||
                                pacs.getPort() == 0 ||
                                isEmpty(pacs.getAeTitle()) ||
                                isEmpty(pacs.getDescription()))
                        {
                            Notification.show("Please enter all fields for the PACS location");

                            return;
                        }

                        if (listener != null)
                        {
                            if (pacs.getId().equals("unassigned"))
                            {
                                pacs.setId(null);
                            }
                            listener.savePACS(pacs);
                            Notification.show("PACS location saved");
                        }
                    }
                }
            }
        });
        deletePacsButton.addClickListener(new Button.ClickListener()
        {
            @Override public void buttonClick(Button.ClickEvent event)
            {
                Object itemId = pacsTable.getValue();
                PACS user = ((BeanItem<PACS>) pacsTable.getItem(itemId)).getBean();
                if (listener != null)
                {
                    listener.deletePACS(user);
                    listener.newPACSSelected();
                    imageDetailsLabel.setValue("");
                    pacsEditor.setVisible(false);
                }
            }
        });
        refreshPacsButton.addClickListener(new Button.ClickListener()
        {
            @Override public void buttonClick(Button.ClickEvent event)
            {
                if (listener != null)
                {
                    listener.refreshPACS();
                    listener.newPACSSelected();
                    imageDetailsLabel.setValue("");
                    pacsEditor.setVisible(false);
                }
            }
        });
    }

    public void setContainers(@NotNull Container pacsContainer,
                              @NotNull Container externalImagesContainer,
                              @NotNull Container internalImagesContainer)
    {
        pacsTable.setContainerDataSource(pacsContainer);
        externalImagesTable.setContainerDataSource(externalImagesContainer);
        internalImagesTable.setContainerDataSource(internalImagesContainer);
        pacsTable.addValueChangeListener(new Property.ValueChangeListener()
        {
            @Override public void valueChange(Property.ValueChangeEvent event)
            {
                Object itemId = pacsTable.getValue();
                if (listener != null && itemId != null)
                {
                    BeanItem<PACS>
                            pacs
                            = ((PACSContainer) pacsTable.getContainerDataSource())
                            .getItem(itemId);
                    setPACSDataSources(pacs);
                    pacsEditor.setVisible(true);
                    listener.newPACSSelected();
                }
            }
        });
        externalImagesTable.addGeneratedColumn("External Images", new Table.ColumnGenerator()
        {
            @Override public Object generateCell(Table source, Object itemId, Object columnId)
            {
                ExternalDicomStudy study = ((BeanContainer<String, ExternalDicomStudy>) source.getContainerDataSource())
                        .getItem(itemId)
                        .getBean();

                Label label = new Label(study.getStudyDate() + " " + study.getStudyTime() +
                        "\n" +
                        study.getPatientName() +
                        "\n" +
                        study.getAccessionNumber() +
                        "\n" +
                        study.getStudyDescription() +
                        "\n" +
                        "Image count : " + study.getImageCount(), ContentMode.PREFORMATTED);
                label.setId(study.getStudyId());
                label.addStyleName("external-study-label");

                return label;
            }
        });
        externalImagesTable.addItemClickListener(new ItemClickEvent.ItemClickListener()
        {
            @Override public void itemClick(ItemClickEvent event)
            {
                try
                {
                    ExternalDicomStudy
                            study
                            = ((BeanContainer<String, ExternalDicomStudy>) externalImagesTable.getContainerDataSource())
                            .getItem(event.getItemId())
                            .getBean();
                    if (listener != null)
                    {
                        Object itemId = pacsTable.getValue();
                        if (itemId != null)
                        {
                            PACS pacs = ((BeanContainer<String, PACS>) pacsTable.getContainerDataSource())
                                    .getItem(itemId)
                                    .getBean();
                            listener.searchForInternalImagesForExternalImage(study);
                        }
                        else
                        {
                            Notification.show("Please select a PACS location", Notification.Type.ERROR_MESSAGE);
                        }
                    }
                    imageDetailsLabel.setValue("");
                    internalImagesTable.setValue(null);
                }
                catch (Exception e)
                {
                    LOGGER.error("Error loading external image details");
                }
            }
        });
        externalImagesTable.setVisibleColumns("External Images");
        externalImagesTable.setSelectable(true);

        internalImagesTable.addGeneratedColumn("Internal Images", new Table.ColumnGenerator()
        {
            @Override public Object generateCell(Table source, Object itemId, Object columnId)
            {
                DicomStudyQueryResult queryResult = ((BeanContainer<String, DicomStudyQueryResult>) source.getContainerDataSource()).getItem(itemId)
                        .getBean();

                DicomStudy study = queryResult.getStudy();
                Label label = new Label(study.getStudyDate() +
                        "\n" +
                        study.getPatientName() +
                        "\n" +
                        study.getInstitutions() +
                        "\n" +
                        study.getAccessionNumber() +
                        "\n" +
                        study.getStudyDescription() +
                        "\n" +
                        "Image count : " + study.getImageCount() +
                        "\n\n" +
                        "Tickets : " +
                        queryResult.getTickets(), ContentMode.PREFORMATTED);
                label.setId(study.getStudyId());
                label.addStyleName("study-label");

                return label;
            }
        });
        internalImagesTable.addItemClickListener(new ItemClickEvent.ItemClickListener()
        {
            @Override public void itemClick(ItemClickEvent event)
            {
                try
                {
                    DicomStudyQueryResult
                            internalDicomStudy
                            =
                            ((BeanContainer<String, DicomStudyQueryResult>) internalImagesTable.getContainerDataSource()).getItem(
                                    event.getItemId()).getBean();
                    Object value = externalImagesTable.getValue();
                    ExternalDicomStudy
                            externalDicomStudy
                            = ((BeanContainer<String, ExternalDicomStudy>) externalImagesTable.getContainerDataSource())
                            .getItem(value)
                            .getBean();

                    displayDifferencesIfAny(externalDicomStudy, internalDicomStudy.getStudy());
                }
                catch (Exception e)
                {
                    LOGGER.error("Error loading internal image details");
                }
            }
        });
        internalImagesTable.setVisibleColumns("Internal Images");
        internalImagesTable.setSelectable(true);
        pacsTable.setVisibleColumns("host", "port", "aeTitle", "description");
        pacsTable.setColumnHeader("host", "Host");
        pacsTable.setColumnHeader("port", "Port");
        pacsTable.setColumnHeader("aeTitle", "AET");
        pacsTable.setColumnHeader("description", "Description");
    }

    private void displayDifferencesIfAny(ExternalDicomStudy externalDicomStudy, DicomStudy internalDicomStudy)
    {
        boolean difference = false;
        StringBuilder builder = new StringBuilder("\n\n");
        String eStudyInstanceUID = externalDicomStudy.getStudyInstanceUID();
        String iStudyInstanceUID = internalDicomStudy.getStudyInstanceUID();
        if (eStudyInstanceUID != null && iStudyInstanceUID != null && !eStudyInstanceUID.equals(iStudyInstanceUID))
        {
            builder.append("External Study Instance UID [")
                    .append(eStudyInstanceUID)
                    .append("]")
                    .append("\n")
                    .append("does not match")
                    .append("\n")
                    .append("Internal Study Instance UID [")
                    .append(iStudyInstanceUID)
                    .append("]")
                    .append("\n\n");
            difference = true;
        }

        String eAccessionNumber = externalDicomStudy.getAccessionNumber();
        String iAccessionNumber = internalDicomStudy.getAccessionNumber();

        if (eAccessionNumber != null && iAccessionNumber != null && !iAccessionNumber.equals(iAccessionNumber))
        {
            builder.append("External Accession Number [")
                    .append(eAccessionNumber)
                    .append("]")
                    .append("\n")
                    .append("does not match")
                    .append("\n")
                    .append("Internal Accession Number [")
                    .append(iAccessionNumber)
                    .append("]")
                    .append("\n");

            difference = true;
        }

        if (!difference)
        {
            builder.append("No differences in \nExternal & Internal Images");
        }

        imageDetailsLabel.setContentMode(ContentMode.PREFORMATTED);
        imageDetailsLabel.setValue(builder.toString());
    }

    public void setListener(@Nullable NewTicketView.Listener listener)
    {
        this.listener = listener;

        this.listener.refreshPACS();
    }

    public void dispose()
    {
        externalImagesTable.removeAllItems();
        internalImagesTable.removeAllItems();
    }

    public void editNewPACS(String pacsId)
    {
        pacsTable.select(pacsId);
        BeanItem<PACS> item = (BeanItem<PACS>) pacsTable.getItem(pacsId);
        if (item != null)
        {
            setPACSDataSources(item);
            pacsEditor.setVisible(true);
            pacsHostField.focus();
        }
    }

    private void setPACSDataSources(BeanItem<PACS> pacs)
    {
        pacsHostField.setPropertyDataSource(pacs.getItemProperty("host"));
        pacsPortField.setPropertyDataSource(pacs.getItemProperty("port"));
        pacsAETField.setPropertyDataSource(pacs.getItemProperty("aeTitle"));
        pacsDescriptionField.setPropertyDataSource(pacs.getItemProperty("description"));
    }
}
