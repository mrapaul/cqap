package web;

import com.google.common.collect.*;
import com.lakeland.ris.ui.datamodel.*;
import com.peirs.datamodel.*;
import com.peirs.datamodel.dicom.*;
import com.peirs.datamodel.ticket.*;
import com.vaadin.data.*;
import com.vaadin.data.util.*;
import com.vaadin.navigator.*;
import com.vaadin.server.*;
import com.vaadin.shared.ui.*;
import com.vaadin.ui.*;

import org.joda.time.*;
import org.tepi.filtertable.*;
import org.vaadin.addon.borderlayout.*;

import java.text.*;
import java.util.*;

import static org.apache.commons.lang3.StringUtils.*;

public class NewTicketViewImpl extends VerticalLayout implements NewTicketView
{
    private static final DateFormat STUDY_DATE_FORMAT = new SimpleDateFormat("yyyyMMdd");
    private final User user;
    private final ComboBox groupField;
    private final ComboBox institutionField;
    private final TextField lastNameField;
    private final TextField firstNameField;
    private final TextField patientMRNField;
    private final ComboBox modalityField;
    private final TextField studyDescriptionField;
    private final TextField accessionField;
    private final DateField studyDateBeginField;
    private final DateField studyDateEndField;
    private final Button searchButton;
    private final Button clearButton;
    private final Button uploadButton;
    private final Button submitButton;
    private final FilterTable searchResultsTable;
    private final CheckBox submittedVarianceField;
    private final OptionGroup typeField;
    private final OptionGroup priorityField;
    private final TabSheet tabsheet;
    private final ExternalImagesView externalImagesView;
    private NewTicketView.Listener listener;

    public NewTicketViewImpl(User user)
    {
        this.user = user;
        groupField = new ComboBox("Group");
        institutionField = new ComboBox("Institution");
        lastNameField = new TextField("Patient Last Name");
        firstNameField = new TextField("Patient First Name");
        patientMRNField = new TextField("Patient MRN");
        modalityField = new ComboBox("Modality", Arrays.asList(Modality.values()));
        studyDescriptionField = new TextField("Study Description");
        accessionField = new TextField("Accession Number");
        studyDateBeginField = new DateField("Exam Date Begin");
        studyDateEndField = new DateField("Exam Date End");
        searchButton = new Button();
        clearButton = new Button();
        uploadButton = new Button();
        submitButton = new Button();
        searchResultsTable = new FilterTable("Available Exams");
        submittedVarianceField = new CheckBox("Submitted Variance");
        typeField = new OptionGroup("Review Type", Sets.newLinkedHashSet(Arrays.asList(TicketType.values())));
        priorityField = new OptionGroup("Priority", Sets.newLinkedHashSet(Arrays.asList(TicketPriority.values())));
        tabsheet = new TabSheet();
        externalImagesView = new ExternalImagesView();

        initLayout();
        initListeners();
        resetFields();
    }

    @Override public void enter(ViewChangeListener.ViewChangeEvent aViewChangeEvent)
    {
        // empty
    }

    @Override public void setListener(NewTicketView.Listener listener)
    {
        this.listener = listener;
        externalImagesView.setListener(listener);
    }

    @Override public void setContainers(Container queryResults,
                                        Container groups,
                                        Container institutions,
                                        Container pirs,
                                        Container sts,
                                        Container pacsContainer,
                                        Container externalImagesContainer,
                                        Container internalImagesContainer)
    {
        groupField.setContainerDataSource(groups);
        institutionField.setContainerDataSource(institutions);
        searchResultsTable.setContainerDataSource(queryResults);
        searchResultsTable.setVisibleColumns("study.studyDate",
                "study.patientName",
                "study.patientID",
                "study.accessionNumber",
                "study.modality",
                "study.studyDescription",
                "study.imageCount",
                "study.studyInstitution",
                "tickets");
        searchResultsTable.setColumnHeader("study.studyId", "Id");
        searchResultsTable.setColumnHeader("study.studyDate", "Date");
        searchResultsTable.setColumnHeader("study.patientName", "Patient Name");
        searchResultsTable.setColumnHeader("study.patientID", "Patient MRN");
        searchResultsTable.setColumnHeader("study.accessionNumber", "Accession");
        searchResultsTable.setColumnHeader("study.modality", "Modality");
        searchResultsTable.setColumnHeader("study.studyDescription", "Exam Description");
        searchResultsTable.setColumnHeader("study.imageCount", "Images");
        searchResultsTable.setColumnHeader("study.studyInstitution", "Institution");
        searchResultsTable.setColumnHeader("tickets", "Previous Tickets");
        searchResultsTable.setImmediate(true);
        searchResultsTable.setFilterBarVisible(true);
        searchResultsTable.addGeneratedColumn("Edit", new CustomTable.ColumnGenerator()
        {
            @Override public Object generateCell(final CustomTable source, final Object itemId, Object columnId)
            {
                Button editButton = new Button("Edit");
                editButton.addStyleName("fq");
                editButton.addClickListener(new Button.ClickListener()
                {
                    @Override public void buttonClick(Button.ClickEvent aClickEvent)
                    {
                        final
                        DicomStudyQueryResult
                                study =
                                ((BeanItem<DicomStudyQueryResult>) source.getContainerDataSource()
                                        .getItem(itemId)).getBean();

                        if (listener != null)
                        {
                            listener.editStudy(study);
                        }
                    }
                });

                return editButton;
            }
        });
        externalImagesView.setContainers(pacsContainer, externalImagesContainer, internalImagesContainer);
    }

    @Override public void displayCreateResult(String result)
    {
        if (result == null)
        {
            Notification.show("Error creating tickets", Notification.Type.ERROR_MESSAGE);
        }
        else
        {
            Notification.show("Created " + result);
            typeField.select(null);
            priorityField.select(null);
            submittedVarianceField.setValue(false);
            if (listener != null)
            {
                query();
            }
        }
    }

    @Override public void displayStudy(DicomStudy study,
                                       Collection<DicomStudy> relatedExams,
                                       NewTicketView.Listener listener)
    {
        if (!isAlreadyDisplayed(tabsheet, study))
        {
            EditExamView editStudyView = new EditExamView(user,
                    tabsheet,
                    (BeanContainer<String, Institution>) institutionField.getContainerDataSource());
            editStudyView.setListener(listener);
            editStudyView.setDetails(study, relatedExams);
            tabsheet.addTab(editStudyView, getCaption(study)).setClosable(true);
            tabsheet.setSelectedTab(editStudyView);
        }
    }

    private String getCaption(DicomStudy study)
    {
        return study.getPatientName() + "|" + study.getAccessionNumber();
    }

    public boolean isAlreadyDisplayed(TabSheet container, DicomStudy study)
    {
        return check(container, getCaption(study));
    }

    private boolean check(TabSheet container, String caption)
    {
        int componentCount = container.getComponentCount();
        for (int i = 0; i < componentCount; i++)
        {
            TabSheet.Tab tab = container.getTab(i);
            if (tab.getCaption().equals(caption))
            {
                container.setSelectedTab(tab);

                return true;
            }
        }

        return false;
    }

    private void initLayout()
    {
        setSizeFull();

        uploadButton.setIcon(FontAwesome.UPLOAD);
        searchButton.setIcon(FontAwesome.SEARCH);
        clearButton.setIcon(FontAwesome.ERASER);
        submitButton.setIcon(FontAwesome.SAVE);
        firstNameField.setNullRepresentation("");
        lastNameField.setNullRepresentation("");
        studyDescriptionField.setNullRepresentation("");
        accessionField.setNullRepresentation("");
        patientMRNField.setNullRepresentation("");
        studyDateBeginField.setDateFormat("yyyy-MM-dd");
        studyDateEndField.setDateFormat("yyyy-MM-dd");
        institutionField.setNullSelectionAllowed(true);
        groupField.setNullSelectionAllowed(true);
        modalityField.setNullSelectionAllowed(true);

        searchButton.addStyleName("fq");
        clearButton.addStyleName("fq");
        uploadButton.addStyleName("fq");
        submitButton.addStyleName("fq");
        searchResultsTable.addStyleName("plain");

        groupField.setWidth("90%");
        institutionField.setWidth("90%");
        lastNameField.setWidth("90%");
        firstNameField.setWidth("90%");
        patientMRNField.setWidth("90%");
        accessionField.setWidth("90%");
        modalityField.setWidth("90%");
        studyDescriptionField.setWidth("90%");
        accessionField.setWidth("90%");
        studyDateBeginField.setWidth("90%");
        studyDateEndField.setWidth("90%");

        searchResultsTable.setImmediate(true);
        searchResultsTable.setSizeFull();
        searchResultsTable.addStyleName("plain");
        searchResultsTable.setSelectable(true);
        searchResultsTable.setMultiSelect(true);
        searchResultsTable.setMultiSelectMode(MultiSelectMode.SIMPLE);

        HorizontalLayout
                patientSearchLayout =
                new HorizontalLayout(new CssLayout(lastNameField, firstNameField),
                        new CssLayout(patientMRNField, accessionField));
        HorizontalLayout
                searchCritera =
                new HorizontalLayout(new Panel("Exam dates", new CssLayout(studyDateBeginField, studyDateEndField)),
                        new Panel("Institution", new CssLayout(institutionField, groupField)),
                        new Panel("Patient Name", patientSearchLayout),
                        new Panel("Study Details", new CssLayout(modalityField, studyDescriptionField)),
                        new Panel("Additional", new CssLayout(patientMRNField, accessionField)));
        HorizontalLayout innerButtonBar = new HorizontalLayout(searchButton, clearButton);
        HorizontalLayout buttonBar = new HorizontalLayout(uploadButton, innerButtonBar);
        buttonBar.setMargin(true);
        buttonBar.setWidth("100%");
        innerButtonBar.setSpacing(true);
        buttonBar.setComponentAlignment(uploadButton, Alignment.BOTTOM_LEFT);
        buttonBar.setComponentAlignment(innerButtonBar, Alignment.BOTTOM_RIGHT);
        VerticalLayout searchLayout = new VerticalLayout(searchCritera, buttonBar);
        searchCritera.setSpacing(true);
        searchLayout.setMargin(true);
        searchCritera.setMargin(new MarginInfo(false, true, false, true));
        searchCritera.setWidth("100%");
        searchLayout.setWidth("100%");

        typeField.addStyleName("horizontal");
        typeField.setMultiSelect(true);
        priorityField.addStyleName("horizontal");

        Label optionsLabel = new Label("Ticket Options");
        optionsLabel.addStyleName("h2");
        HorizontalLayout innerTicketDetails = new HorizontalLayout(typeField, priorityField, submittedVarianceField);
        HorizontalLayout lowerButtonBar = new HorizontalLayout(optionsLabel, innerTicketDetails, submitButton);
        innerTicketDetails.setSpacing(true);
        innerTicketDetails.setMargin(true);
        lowerButtonBar.setMargin(true);
        lowerButtonBar.setWidth("100%");
        innerTicketDetails.setComponentAlignment(submittedVarianceField, Alignment.BOTTOM_RIGHT);
        lowerButtonBar.setComponentAlignment(optionsLabel, Alignment.BOTTOM_LEFT);
        lowerButtonBar.setComponentAlignment(innerTicketDetails, Alignment.MIDDLE_CENTER);
        lowerButtonBar.setComponentAlignment(submitButton, Alignment.BOTTOM_RIGHT);

        Label label = new Label("New Ticket");
        label.addStyleName("h1");
        HorizontalLayout topButtonBar = new HorizontalLayout(label);
        topButtonBar.setWidth("100%");
        topButtonBar.setMargin(true);
        topButtonBar.setComponentAlignment(label, Alignment.TOP_LEFT);
        CssLayout topLayout = new CssLayout(topButtonBar, searchLayout);
        topLayout.setWidth("100%");

        BorderLayout layout = new BorderLayout();
        layout.setMinimumNorthHeight("270px");
        layout.setMinimumSouthHeight("70px");
        layout.setMargin(true);
        layout.setSpacing(true);
        layout.addComponent(topLayout, BorderLayout.Constraint.NORTH);
        layout.addComponent(searchResultsTable, BorderLayout.Constraint.CENTER);
        layout.addComponent(lowerButtonBar, BorderLayout.Constraint.SOUTH);
        layout.setSizeFull();

        externalImagesView.initialize();
        tabsheet.setSizeFull();
        VerticalLayout mainLayout = new VerticalLayout(tabsheet);
        mainLayout.setSizeFull();
        tabsheet.addTab(layout, "Search Internal Exams");
        tabsheet.addTab(externalImagesView, "Search External Exams");
        addComponent(mainLayout);
    }

    private void initListeners()
    {
        searchButton.addClickListener(new Button.ClickListener()
        {
            @Override public void buttonClick(Button.ClickEvent aClickEvent)
            {
                if (listener != null)
                {
                    query();
                }
            }
        });
        clearButton.addClickListener(new Button.ClickListener()
        {
            @Override public void buttonClick(Button.ClickEvent aClickEvent)
            {
                resetFields();
            }
        });
        submitButton.addClickListener(new Button.ClickListener()
        {
            @Override public void buttonClick(Button.ClickEvent aClickEvent)
            {
                Container container = searchResultsTable.getContainerDataSource();
                Set<DicomStudyQueryResult> selected = Sets.newHashSet();
                Set<String> itemIds = (Set<String>) searchResultsTable.getValue();
                for (Object itemId : itemIds)
                {
                    selected.add(((BeanItem<DicomStudyQueryResult>) container.getItem(itemId)).getBean());
                }

                Set<TicketType> types = (Set<TicketType>) typeField.getValue();
                TicketPriority priority = (TicketPriority) priorityField.getValue();
                Boolean submittedVariance = submittedVarianceField.getValue();

                if (priority == null || (types == null || types.isEmpty()) || selected.isEmpty())
                {
                    String ticketTypeMessage = (types == null || types.isEmpty()) ? "NONE" : types.toString();
                    String priorityMessage = priority == null ? "NONE" : priority.toString();
                    Notification.show("Please select image(s) [" +
                            selected.size() +
                            "], ticket type(s) [" +
                            ticketTypeMessage +
                            "] and priority + [" + priorityMessage + "]",
                            Notification.Type.ERROR_MESSAGE);

                    return;
                }

                if (listener != null)
                {
                    listener.createTickets(selected,
                            types,
                            priority,
                            submittedVariance);
                }
            }
        });
        uploadButton.addClickListener(new Button.ClickListener()
        {
            @Override public void buttonClick(Button.ClickEvent event)
            {
                new DicomUploadView(listener);
            }
        });
    }

    private void query()
    {
        Object institutionValue = institutionField.getValue();
        Object groupValue = groupField.getValue();
        String firstName = firstNameField.getValue();
        String lastName = lastNameField.getValue();
        String patientMRN = patientMRNField.getValue();
        Date studyDateBegin = studyDateBeginField.getValue();
        Date studyDateEnd = studyDateEndField.getValue();
        Object modalityValue = modalityField.getValue();
        String studyDescription = studyDescriptionField.getValue();
        String accession = accessionField.getValue();

        DicomStudyQueryBuilder queryBuilder = new DicomStudyQueryBuilder();
        if (institutionValue != null)
        {
            Institution institution = ((BeanItem<Institution>) institutionField.getContainerDataSource()
                    .getItem(institutionValue)).getBean();
            queryBuilder.setInstitution(institution);
        }
        if (groupValue != null)
        {
            Group group = ((BeanItem<Group>) groupField.getContainerDataSource().getItem(groupValue)).getBean();
            queryBuilder.setGroup(group);
        }
        if (isNotEmpty(lastName))
        {
            queryBuilder.setPatientLastName(lastName);
        }
        if (isNotEmpty(firstName))
        {
            queryBuilder.setPatientFirstName(firstName);
        }
        if (isNotEmpty(patientMRN))
        {
            queryBuilder.setPatientID(patientMRN);
        }
        if (modalityValue != null)
        {
            queryBuilder.setModalities(Arrays.<String>asList(((Modality) modalityValue).name()));
        }
        if (isNotEmpty(studyDescription))
        {
            queryBuilder.setStudyDescription(studyDescription);
        }
        if (isNotEmpty(accession))
        {
            queryBuilder.setAccessionNumber(accession);
        }

        if (studyDateBegin != null)
        {
            queryBuilder.setStudyBeginDate(STUDY_DATE_FORMAT.format(studyDateBegin));
        }

        if (studyDateEnd != null)
        {
            queryBuilder.setStudyEndDate(STUDY_DATE_FORMAT.format(studyDateEnd));
        }

        listener.query(queryBuilder.build());
    }

    private void resetFields()
    {
        firstNameField.setValue(null);
        lastNameField.setValue(null);
        patientMRNField.setValue(null);
        studyDateBeginField.setValue(null);
        institutionField.setValue(null);
        groupField.setValue(null);
        modalityField.setValue(null);
        studyDescriptionField.setValue(null);
        accessionField.setValue(null);

        if (listener != null)
        {
            listener.reset();
        }
        studyDateBeginField.setValue(null);
        studyDateEndField.setValue(null);
    }

    @Override public void editNewPACS(String pacsId)
    {
        externalImagesView.editNewPACS(pacsId);
    }
}
