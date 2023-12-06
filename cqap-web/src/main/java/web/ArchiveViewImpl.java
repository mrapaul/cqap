package web;

import com.google.common.collect.*;
import com.peirs.datamodel.*;
import com.peirs.datamodel.attachments.*;
import com.peirs.datamodel.dicom.*;
import com.peirs.datamodel.ticket.*;
import com.vaadin.data.*;
import com.vaadin.data.util.*;
import com.vaadin.event.*;
import com.vaadin.navigator.*;
import com.vaadin.server.*;
import com.vaadin.shared.ui.*;
import com.vaadin.ui.*;
import org.jetbrains.annotations.*;
import org.joda.time.*;
import org.tepi.filtertable.*;

import java.text.*;
import java.util.*;

import static org.apache.commons.lang3.StringUtils.*;
import static web.ComponentFactory.*;

public class ArchiveViewImpl extends CssLayout implements ArchiveView
{
    private static final DateFormat STUDY_DATE_FORMAT = new SimpleDateFormat("yyyyMMdd");
    private static final DateFormat SUBMITTED_DATE_FORMAT = new SimpleDateFormat("MMM dd yyyy");
    @NotNull private final User user;
    @NotNull private final TextField ticketIdField;
    @NotNull private final ComboBox reviewTypeField;
    @NotNull private final ComboBox priorityField;
    @NotNull private final ComboBox statusField;
    @NotNull private final TextField patientLastNameField;
    @NotNull private final TextField patientFirstNameField;
    @NotNull private final TextField patientMRNField;
    @NotNull private final ComboBox groupField;
    @NotNull private final ComboBox institutionField;
    @NotNull private final ComboBox pirField;
    @NotNull private final ComboBox modalityField;
    @NotNull private final TextField studyDescriptionField;
    @NotNull private final TextField accessionField;
    @NotNull private final TextField cptCodeField;
    @NotNull private final DateField studyDateField;
    @NotNull private final DateField submittedFromField;
    @NotNull private final DateField submittedToField;
    @NotNull private final TextField submittedByField;
    @NotNull private final TextField erpField;
    @NotNull private final ComboBox confirmedCategoryField;
    @NotNull private final Button searchButton;
    @NotNull private final Button resetButton;
    @NotNull private final FilterTable searchResultsTable;
    @NotNull private final TabSheet tabSheet;
    private ArchiveView.Listener listener;

    public ArchiveViewImpl(@NotNull User user)
    {
        this.user = user;
        ticketIdField = createFormTextField("Ticket Id");
        reviewTypeField = createFormComboBoxField("Review Type", Arrays.asList(TicketType.values()));
        priorityField = createFormComboBoxField("Ticket Priority", Arrays.asList(TicketPriority.values()));
        statusField =
                createFormComboBoxField("Ticket Status",
                        Arrays.asList(EnumSet.of(TicketStatus.COMPLETED, TicketStatus.TECH_COMPLETED)));
        patientLastNameField = createFormTextField("Patient Last Name");
        patientFirstNameField = createFormTextField("Patient First Name");
        patientMRNField = createFormTextField("Patient MRN");
        groupField = createFormComboBoxField("Group");
        institutionField = createFormComboBoxField("Institution");
        pirField = createFormComboBoxField("PIR");
        modalityField = createFormComboBoxField("Modality", Arrays.asList(Modality.values()));
        studyDescriptionField = createFormTextField("Study Description");
        accessionField = createFormTextField("Accession Number");
        cptCodeField = createFormTextField("CPT Code");
        studyDateField = createFormDateField("Study Date");
        submittedFromField = createFormDateField("Date Submitted From");
        submittedToField = createFormDateField("Date Submitted To");
        submittedByField = createFormTextField("Submitted By");
        erpField = createFormTextField("ERP");
        confirmedCategoryField = createFormComboBoxField("Confirmed Category", Arrays.asList(1, 2, 3, 4, 5));
        searchButton = new Button();
        resetButton = new Button();
        searchResultsTable = new FilterTable("Tickets");
        tabSheet = new TabSheet();

        initLayout();
        initListeners();
        resetSearchFields();
    }

    @Override public void setListener(ArchiveView.Listener listener)
    {
        this.listener = listener;
    }

    @Override public void enter(ViewChangeListener.ViewChangeEvent aViewChangeEvent)
    {
        // empty
    }

    @Override public void setContainers(Container queryResults,
                                        Container groups,
                                        Container institutions,
                                        Container pirs)
    {
        groupField.setContainerDataSource(groups);
        institutionField.setContainerDataSource(institutions);
        pirField.setContainerDataSource(pirs);
        searchResultsTable.setFilterBarVisible(true);
        searchResultsTable.setContainerDataSource(queryResults);
        searchResultsTable.setVisibleColumns("submittedDate",
                "viewId",
                "type",
                "priority",
                "status",
                "category",
                "studyDate",
                "patientName",
                "institution",
                "accessionNumber",
                "modality",
                "studyDescription",
                "ERP");
        searchResultsTable.setColumnHeader("submittedDate", "Submitted Date");
        searchResultsTable.setColumnHeader("viewId", "Ticket #");
        searchResultsTable.setColumnHeader("type", "Type");
        searchResultsTable.setColumnHeader("priority", "Priority");
        searchResultsTable.setColumnHeader("status", "Status");
        searchResultsTable.setColumnHeader("category", "Confirmed Category");
        searchResultsTable.setColumnHeader("studyDate", "Exam Date");
        searchResultsTable.setColumnHeader("patientName", "Patient Name");
        searchResultsTable.setColumnHeader("institution", "Institution");
        searchResultsTable.setColumnHeader("accessionNumber", "Accession");
        searchResultsTable.setColumnHeader("modality", "Modality");
        searchResultsTable.setColumnHeader("studyDescription", "Exam Description");
    }

    private void initLayout()
    {
        setSizeFull();

        Label pageLabel = new Label("Completed Tickets");
        pageLabel.addStyleName("h1");
        HorizontalLayout topLayout = new HorizontalLayout(pageLabel);
        topLayout.setWidth("100%");
        topLayout.setMargin(true);

        searchResultsTable.setImmediate(true);
        searchResultsTable.setSizeFull();
        searchResultsTable.addStyleName("plain");
        searchResultsTable.setSelectable(true);

        CssLayout column0 = new CssLayout(submittedFromField, submittedToField, submittedByField);
        HorizontalLayout column1 = fullWidthHorizontalLayout(new CssLayout(ticketIdField,
                reviewTypeField,
                priorityField),
                new CssLayout(statusField, erpField, confirmedCategoryField));
        column1.setMargin(new MarginInfo(false, true, false, true));
        column1.setSpacing(true);
        CssLayout column2 = new CssLayout(patientFirstNameField, patientLastNameField, patientMRNField);
        CssLayout column3 = new CssLayout(groupField, institutionField, pirField);
        HorizontalLayout column4 =
                fullWidthHorizontalLayout(new CssLayout(modalityField, studyDescriptionField, accessionField),
                        new CssLayout(cptCodeField, studyDateField));
        column4.setSpacing(true);
        column4.setMargin(new MarginInfo(false, true, false, true));
        Panel panel0 = new Panel("Submission Details", column0);
        Panel panel1 = new Panel("Ticket Details", column1);
        Panel panel2 = new Panel("Patient Details", column2);
        Panel panel3 = new Panel("Institution Details", column3);
        Panel panel4 = new Panel("Study Details", column4);
        HorizontalLayout row0 = fullWidthHorizontalLayout(panel0,
                panel1,
                panel2,
                panel3,
                panel4);
        row0.setExpandRatio(panel0, 1f);
        row0.setExpandRatio(panel1, 2f);
        row0.setExpandRatio(panel2, 1f);
        row0.setExpandRatio(panel3, 1f);
        row0.setExpandRatio(panel4, 2f);
        row0.addStyleName("search");
        row0.setMargin(true);
        row0.setSpacing(true);

        searchButton.addStyleName("fq");
        resetButton.addStyleName("fq");
        searchButton.setIcon(FontAwesome.SEARCH);
        resetButton.setIcon(FontAwesome.ERASER);

        HorizontalLayout innerLayout = new HorizontalLayout(searchButton, resetButton);
        innerLayout.setSpacing(true);
        innerLayout.setMargin(true);
        HorizontalLayout row1 = new HorizontalLayout(innerLayout);
        row1.setWidth("100%");
        row1.setComponentAlignment(innerLayout, Alignment.BOTTOM_CENTER);

        CssLayout mainLayout = new CssLayout(topLayout, new Panel(row0), row1, searchResultsTable);
        mainLayout.setSizeFull();
        tabSheet.setSizeFull();
        tabSheet.addTab(mainLayout, "Tickets");
        addComponent(tabSheet);
    }

    private void initListeners()
    {
        submittedByField.setNullRepresentation("");
        ticketIdField.setNullRepresentation("");
        erpField.setNullRepresentation("");
        patientFirstNameField.setNullRepresentation("");
        patientLastNameField.setNullRepresentation("");
        patientMRNField.setNullRepresentation("");
        studyDescriptionField.setNullRepresentation("");
        accessionField.setNullRepresentation("");
        cptCodeField.setNullRepresentation("");
        submittedFromField.setDateFormat("yyyy-MM-dd");
        submittedToField.setDateFormat("yyyy-MM-dd");
        studyDateField.setDateFormat("yyyy-MM-dd");
        institutionField.setNullSelectionAllowed(true);
        groupField.setNullSelectionAllowed(true);
        reviewTypeField.setNullSelectionAllowed(true);
        statusField.setNullSelectionAllowed(true);
        pirField.setNullSelectionAllowed(true);
        modalityField.setNullSelectionAllowed(true);
        confirmedCategoryField.setNullSelectionAllowed(true);

        searchButton.addClickListener(new Button.ClickListener()
        {
            @Override public void buttonClick(Button.ClickEvent aClickEvent)
            {
                if (listener != null)
                {
                    Date submittedFrom = submittedFromField.getValue();
                    Date submittedTo = submittedToField.getValue();
                    Date studyDate = studyDateField.getValue();
                    Object reviewType = reviewTypeField.getValue();
                    Object priority = priorityField.getValue();
                    Object ticketStatus = statusField.getValue();
                    String ticketId = ticketIdField.getValue();
                    Object groupValue = groupField.getValue();
                    Object institutionValue = institutionField.getValue();
                    String patientLastName = patientLastNameField.getValue();
                    String patientFirstName = patientFirstNameField.getValue();
                    String patientMRN = patientMRNField.getValue();
                    String studyDescription = studyDescriptionField.getValue();
                    String accessionNumber = accessionField.getValue();
                    String cptCode = cptCodeField.getValue();
                    Object pir = pirField.getValue();
                    String submittedBy = submittedByField.getValue();
                    String erp = erpField.getValue();
                    Object category = confirmedCategoryField.getValue();
                    Object modalityValue = modalityField.getValue();


                    TicketQueryBuilder queryBuilder = new TicketQueryBuilder();

                    if (institutionValue != null)
                    {
                        Institution institution = ((BeanItem<Institution>) institutionField.getContainerDataSource()
                                .getItem(institutionValue)).getBean();
                        queryBuilder.setInstitution(institution);
                    }
                    if (groupValue != null)
                    {
                        Group
                                group =
                                ((BeanItem<Group>) groupField.getContainerDataSource().getItem(groupValue)).getBean();
                        queryBuilder.setGroup(group);
                    }
                    if (reviewType != null)
                    {
                        queryBuilder.setTicketType(((TicketType) reviewType).name());
                    }
                    if (priority != null)
                    {
                        queryBuilder.setTicketPriority(((TicketPriority) priority).name());
                    }
                    if (ticketStatus != null)
                    {
                        queryBuilder.setTicketStatuses(Lists.newArrayList(((TicketStatus) ticketStatus).name()));
                    }
                    else
                    {
                        queryBuilder.setTicketStatuses(Lists.newArrayList(TicketStatus.COMPLETED.name(),
                                TicketStatus.TECH_COMPLETED.name()));
                    }
                    if (isNotEmpty(ticketId))
                    {
                        queryBuilder.setTicketId(ticketId);
                    }
                    if (isNotEmpty(patientLastName))
                    {
                        queryBuilder.setPatientLastName(patientLastName);
                    }
                    if (isNotEmpty(patientFirstName))
                    {
                        queryBuilder.setPatientFirstName(patientFirstName);
                    }
                    if (isNotEmpty(patientMRN))
                    {
                        queryBuilder.setPatientID(patientMRN);
                    }
                    if (modalityValue != null)
                    {
                        queryBuilder.setModality(((Modality) modalityValue).name());
                    }
                    if (isNotEmpty(studyDescription))
                    {
                        queryBuilder.setStudyDescription(studyDescription);
                    }
                    if (isNotEmpty(accessionNumber))
                    {
                        queryBuilder.setAccessionNumber(accessionNumber);
                    }
                    if (isNotEmpty(cptCode))
                    {
                        queryBuilder.setCPTCode(cptCode);
                    }
                    if (isNotEmpty(submittedBy))
                    {
                        queryBuilder.setSubmittedBy(submittedBy);
                    }
                    if (pir != null)
                    {
                        queryBuilder.setIIR((String) pir);
                    }
                    if (isNotEmpty(erp))
                    {
                        queryBuilder.setERP(erp);
                    }
                    if (category != null)
                    {
                        queryBuilder.setCategory((Integer) category);
                    }
                    if (studyDate != null)
                    {
                        queryBuilder.setStudyDate(STUDY_DATE_FORMAT.format(studyDate));
                    }
                    if (submittedFrom != null)
                    {
                        queryBuilder.setDateSubmittedFrom(submittedFrom.getTime());
                    }
                    if (submittedTo != null)
                    {
                        queryBuilder.setDateSubmittedTo(submittedTo.getTime());
                    }


                    listener.query(queryBuilder.build());
                }
            }
        });

        resetButton.addClickListener(new Button.ClickListener()
        {
            @Override public void buttonClick(Button.ClickEvent aClickEvent)
            {
                resetSearchFields();
            }
        });
        searchResultsTable.addItemClickListener(new ItemClickEvent.ItemClickListener()
        {
            @Override public void itemClick(ItemClickEvent event)
            {
                if (event.isDoubleClick())
                {
                    Object itemId = event.getItemId();
                    if (itemId != null && listener != null)
                    {
                        Item item = searchResultsTable.getContainerDataSource().getItem(itemId);
                        if (item != null)
                        {
                            listener.ticketSelected(((BeanItem<TicketQueryResult>) item).getBean());
                        }
                    }
                }
            }
        });
    }

    private void resetSearchFields()
    {
        LocalDate date = new LocalDate();
        submittedFromField.setValue(date.minusDays(7).toDate());
        submittedToField.setValue(date.plusDays(1).toDate());
        studyDateField.setValue(null);
        institutionField.setValue(null);
        groupField.setValue(null);
        reviewTypeField.setValue(null);
        statusField.setValue(null);
        pirField.setValue(null);
        modalityField.setValue(null);
        confirmedCategoryField.setValue(null);
        ticketIdField.setValue(null);
        patientFirstNameField.setValue(null);
        patientLastNameField.setValue(null);
        patientMRNField.setValue(null);
        studyDescriptionField.setValue(null);
        accessionField.setValue(null);
        cptCodeField.setValue(null);
        submittedByField.setValue(null);
        erpField.setValue(null);
    }

    @Override public void displayTicket(@NotNull ProfessionalTicket ticket,
                                        @NotNull Collection<DicomStudy> relatedExams,
                                        @NotNull Container institutions,
                                        @NotNull Collection<Attachment> attachments)
    {
        if (listener != null)
        {
            String caption = ticket.getViewId();
            if (!isAlreadyDisplayed(tabSheet, caption))
            {
                PRTicketView
                        view =
                        new PRTicketView(user, tabSheet, institutions, listener, ticket, relatedExams, attachments);
                TabSheet.Tab tab = tabSheet.addTab(view, caption);
                tab.setClosable(true);
                tabSheet.setSelectedTab(tab);
            }
        }
    }

    public boolean isAlreadyDisplayed(@NotNull TabSheet container, String caption)
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
}
