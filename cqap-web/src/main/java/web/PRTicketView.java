package web;

import com.google.common.collect.*;
import com.peirs.datamodel.*;
import com.peirs.datamodel.attachments.*;
import com.peirs.datamodel.dicom.*;
import com.peirs.datamodel.ticket.*;
import com.vaadin.data.*;
import com.vaadin.data.util.*;
import com.vaadin.server.*;
import com.vaadin.shared.ui.*;
import com.vaadin.ui.*;

import org.vaadin.maddon.layouts.*;
import web.event.*;

import java.io.*;
import java.util.*;

public class PRTicketView extends VerticalLayout implements NotesListener, AttachmentListener
{
    private final User user;
    private final TabSheet tabsheet;
    private final PRTicketListener listener;
    private final ProfessionalTicket ticket;
    private final StudyDetailsView studyDetailsView;
    private final DicomTagsView dicomTagsView;
    private final ExamReportView examReportView;
    private final RelatedExamsView relatedExamsView;
    private final NotesView notesView;
    private final AttachmentsView attachmentsView;
    private final ComboBox statusField;
    private final ComboBox priorityField;
    private final Button saveButton;
    private final Button closeButton;
    private final Button pendingButton;
    private final Button completeButton;
    private final Button createPRReview;
    private final Button deleteButton;
    private final Component reviewLayout;
    private final Button correspondingTicket;
    private final Button viewImagesButton;
    private final Button resendReportButton;

    public PRTicketView(User user,
                        TabSheet tabsheet,
                         Container institutions,
                        PRTicketListener listener,
                        ProfessionalTicket ticket,
                        Collection<DicomStudy> relatedExams,
                        Collection<com.peirs.datamodel.attachments.Attachment> attachments)
    {
        this.user = user;
        this.tabsheet = tabsheet;
        this.listener = listener;
        studyDetailsView = new StudyDetailsView(this.user, institutions);
        this.ticket = ticket;
        dicomTagsView = new DicomTagsView();
        examReportView = new ExamReportView(user);
        relatedExamsView = new RelatedExamsView();
        notesView = new NotesView(this);
        attachmentsView = new AttachmentsView(this);
        statusField = new ComboBox("Status", getStatuses());
        priorityField = new ComboBox("Priority", Arrays.asList(TicketPriority.values()));
        saveButton = new Button();
        closeButton = new Button();
        pendingButton = new Button();
        completeButton = new Button();
        createPRReview = new Button();
        deleteButton = new Button();
        reviewLayout = ReviewLayoutFactory.getLayout(ticket, user);
        correspondingTicket = new Button();
        viewImagesButton = new Button();
        resendReportButton = new Button();
        if (ticket.getCorrespondingReviewViewId() != null)
        {
            correspondingTicket.setCaption(ticket.getCorrespondingReviewViewId());
        }
        else
        {
            correspondingTicket.setVisible(false);
        }
        examReportView.setListener(listener);

        initLayout();
        initListeners();
        displayTicket(relatedExams, attachments);
    }

    private List<TicketStatus> getStatuses()
    {
        return ticket.getType() == TicketType.PR ?
                Lists.newArrayList(EnumSet.complementOf(getTRStatuses())) :
                Lists.newArrayList(getTRStatuses());
    }

    private EnumSet<TicketStatus> getTRStatuses()
    {
        return EnumSet.of(TicketStatus.TECH_COMPLETED,
                TicketStatus.TECH_OPEN_CMO_REVIEW,
                TicketStatus.TECH_OPEN_ERP_REVIEW,
                TicketStatus.TECH_PENDING);
    }

    private void initLayout()
    {
        setSizeFull();
        setMargin(new MarginInfo(true, false, true, false));
        Label title = new Label(ticket.getViewId());
        title.addStyleName("h1");
        correspondingTicket.addStyleName("fq");
        HorizontalLayout enclosure = new MHorizontalLayout(statusField, priorityField).withSpacing(true);
        HorizontalLayout
                topLayout =
                new MHorizontalLayout(title, correspondingTicket, enclosure).withFullWidth()
                        .withMargin(true)
                        .withSpacing(true)
                        .withAlign(enclosure, Alignment.TOP_RIGHT)
                        .withAlign(enclosure, Alignment.TOP_RIGHT)
                        .withAlign(correspondingTicket, Alignment.BOTTOM_CENTER);
        topLayout.addStyleName("sidebar-" + ticket.getPriority().name().toLowerCase());

        TabSheet accordion = new TabSheet();
        accordion.addTab(examReportView, "Exam Report");
        accordion.addTab(dicomTagsView, "Additional Exam Details");
        accordion.addTab(relatedExamsView, "Related Exams");
        accordion.addTab(notesView, "Internal Notes");
        accordion.addTab(attachmentsView, "Attachments");
        accordion.setSizeFull();


        HorizontalSplitPanel splitPanel = new HorizontalSplitPanel(reviewLayout, accordion);
        splitPanel.setSizeFull();
        splitPanel.setSplitPosition(60, Unit.PERCENTAGE);

        VerticalSplitPanel verticalSplitPanel = new VerticalSplitPanel(studyDetailsView, splitPanel);
        verticalSplitPanel.setSplitPosition(45, Unit.PERCENTAGE);
        verticalSplitPanel.setSizeFull();
        saveButton.addStyleName("fq");
        closeButton.addStyleName("fq");
        saveButton.setIcon(FontAwesome.SAVE);
        closeButton.setIcon(FQIcons.CLOSE);
        pendingButton.setIcon(FontAwesome.EXCLAMATION_TRIANGLE);
        completeButton.setIcon(FontAwesome.CHECK);
        deleteButton.setIcon(FontAwesome.TRASH_O);
        createPRReview.setIcon(FontAwesome.COPY);
        viewImagesButton.setIcon(FontAwesome.EYE);
        resendReportButton.setIcon(FontAwesome.SEND);

        saveButton.setDescription("Save");
        closeButton.setDescription("Cancel");
        pendingButton.setDescription("Pending");
        deleteButton.setDescription("Delete");
        createPRReview.setDescription("Create PR Review Ticket");
        completeButton.setDescription(ticket.getStatus() != TicketStatus.PENDING ? "Complete" : "Review");
        viewImagesButton.setDescription("View Images");
        resendReportButton.setDescription("Resend Reports");

        MHorizontalLayout innerButtonLayout1 = new MHorizontalLayout(resendReportButton,
                viewImagesButton,
                createPRReview,
                saveButton,
                completeButton,
                closeButton).withSpacing(true);
        MHorizontalLayout innerButtonLayout2 = new MHorizontalLayout(deleteButton,
                pendingButton).withSpacing(true);
        HorizontalLayout
                bottomLayout =
                new MHorizontalLayout(innerButtonLayout2, innerButtonLayout1).withSpacing(true).withMargin(true)
                        .withFullWidth()
                        .withAlign(innerButtonLayout1, Alignment.BOTTOM_RIGHT)
                        .withAlign(innerButtonLayout2, Alignment.BOTTOM_LEFT);
        addComponent(topLayout);
        addComponent(verticalSplitPanel);
        addComponent(bottomLayout);
        setExpandRatio(verticalSplitPanel, 1f);

        setEditable();
        setVisibleButtons();
    }

    private void setVisibleButtons()
    {
        if (user.getRole() != Role.QAD)
        {
            deleteButton.setVisible(false);
            resendReportButton.setVisible(false);
        }

        if (user.getOsirixConfiguration() != null)
        {
            viewImagesButton.setVisible(true);
        }

        switch (ticket.getStatus())
        {
            case OPEN_ERP_REVIEW:
            {
                createPRReview.setVisible(false);

                break;
            }
            case OPEN_PIR_REVIEW:
            {
                createPRReview.setVisible(false);

                break;
            }
            case OPEN_CMO_REVIEW:
            {
                createPRReview.setVisible(false);

                break;
            }
            case OPEN_SITE_CALL_REQUIRED:
            case PENDING:
            case TECH_PENDING:
            {
                createPRReview.setVisible(false);
                pendingButton.setVisible(false);

                break;
            }
            case TECH_OPEN_ERP_REVIEW:
            {
                createPRReview.setVisible(true);

                break;
            }
            case TECH_OPEN_CMO_REVIEW:
            {
                createPRReview.setVisible(true);

                break;
            }
            case COMPLETED:
            case TECH_COMPLETED:
            {
                createPRReview.setVisible(false);
                pendingButton.setVisible(false);
                completeButton.setVisible(false);
                deleteButton.setVisible(false);

                break;
            }
        }
    }

    private void setEditable()
    {
        boolean editable = QADAndNotCompleted();
        priorityField.setReadOnly(!editable);
        statusField.setReadOnly(!editable);
    }

    private boolean QADAndNotCompleted()
    {
        return user.getRole() == Role.QAD &&
                (ticket.getStatus() != TicketStatus.COMPLETED && ticket.getStatus() != TicketStatus.TECH_COMPLETED);
    }

    private void initListeners()
    {
        saveButton.addClickListener(new Button.ClickListener()
        {
            @Override public void buttonClick(Button.ClickEvent event)
            {
                listener.saveTicket(ticket);
                closeEditor();
            }
        });
        closeButton.addClickListener(new Button.ClickListener()
        {
            @Override public void buttonClick(Button.ClickEvent event)
            {
                closeEditor();
            }
        });
        deleteButton.addClickListener(new Button.ClickListener()
        {
            @Override public void buttonClick(Button.ClickEvent event)
            {
                listener.deleteTicket(ticket);
                closeEditor();
            }
        });
        completeButton.addClickListener(new Button.ClickListener()
        {
            @Override public void buttonClick(Button.ClickEvent event)
            {
                checkForErrors(listener.complete(ticket));
            }
        });
        pendingButton.addClickListener(new Button.ClickListener()
        {
            @Override public void buttonClick(Button.ClickEvent event)
            {
                UI.getCurrent().addWindow(new PendingNotePanel(PRTicketView.this));
            }
        });
        createPRReview.addClickListener(new Button.ClickListener()
        {
            @Override public void buttonClick(Button.ClickEvent event)
            {
                checkForErrors(listener.createPRReview(ticket));
            }
        });
        correspondingTicket.addClickListener(new Button.ClickListener()
        {
            @Override public void buttonClick(Button.ClickEvent event)
            {
                listener.openTicket(correspondingTicket.getCaption());
            }
        });
        viewImagesButton.addClickListener(new Button.ClickListener()
        {
            @Override public void buttonClick(Button.ClickEvent event)
            {
                listener.openImages(ticket);
            }
        });
        resendReportButton.addClickListener(new Button.ClickListener()
        {
            @Override public void buttonClick(Button.ClickEvent event)
            {
                UI.getCurrent().addWindow(new ResendReportPanel(ticket, PRTicketView.this));
            }
        });
    }

    private void checkForErrors( String result)
    {
        if (result != null)
        {
            Notification.show(result, Notification.Type.ERROR_MESSAGE);
        }
        else
        {
            closeEditor();
        }
    }

    void pendingNoteEntered()
    {
        checkForErrors(listener.pending(ticket));
    }

    private void displayTicket(Collection<DicomStudy> relatedExams,
                               Collection<com.peirs.datamodel.attachments.Attachment> attachments)
    {
        statusField.setPropertyDataSource(new MethodProperty(ticket, "status"));
        priorityField.setPropertyDataSource(new MethodProperty(ticket, "priority"));
        DicomStudy study = ticket.getStudy();
        studyDetailsView.setDetails(study, ticket);
        dicomTagsView.setDetails(study);
        examReportView.setDetails(study, QADAndNotCompleted());
        relatedExamsView.display(relatedExams);
        notesView.displayNotes(ticket.getNotes());
        attachmentsView.displayAttachments(attachments);
    }

    private void closeEditor()
    {
        tabsheet.removeComponent(this);
    }

    @Override public void addNote(String note)
    {
        ticket.addNote(new InternalNote(note, new Date(), user));
        notesView.displayNotes(ticket.getNotes());
    }

    @Override public void uploadAttachment(File file)
    {
        attachmentsView.displayAttachments(listener.uploadFile(ticket, file));
    }

    @Override public void deleteAttachment(Attachment attachment)
    {
        attachmentsView.displayAttachments(listener.deleteAttachment(ticket, attachment));
    }

    @Override public InputStream openAttachment(com.peirs.datamodel.attachments.Attachment attachment) throws IOException
    {
        return listener.openAttachment(attachment);
    }

    public void resendReports(String addresses,
                              boolean erpReport,
                              boolean erpSiteCallReport,
                              boolean cmoReport,
                              boolean cmoSiteCallReport,
                              boolean techReport)
    {
        listener.resendReports(ticket,
                addresses,
                erpReport,
                erpSiteCallReport,
                cmoReport,
                cmoSiteCallReport,
                techReport);
    }
}
