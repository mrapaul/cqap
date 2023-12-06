package web;

import com.peirs.datamodel.attachments.*;
import com.peirs.datamodel.dicom.*;
import com.peirs.datamodel.ticket.*;
import com.vaadin.data.*;
import com.vaadin.ui.*;
import org.jetbrains.annotations.*;

import java.io.*;
import java.util.*;

import static org.apache.commons.lang3.StringUtils.isNotEmpty;

public class WorklistPresenter implements WorklistView.Listener
{
    @NotNull private final WorklistModel model;
    @NotNull private final WorklistView view;

    public WorklistPresenter(@NotNull WorklistModel model, @NotNull WorklistView view)
    {
        this.model = model;
        this.view = view;

        view.setListener(this);
        view.setContainers(model.getResultsContainer());
    }

    @Override public void query()
    {
        model.search();
    }

    @Override public void reset()
    {
        model.reset();
    }

    @Override public void ticketSelected(@NotNull TicketQueryResult queryResult)
    {
        ProfessionalTicket ticket = model.getTicket(queryResult);
        if (ticket != null)
        {
            displayTicket(ticket);
        }
    }

    private void displayTicket(@NotNull ProfessionalTicket ticket)
    {
        Collection<DicomStudy> relatedExams = model.getRelatedStudies(ticket.getStudy());
        Container institutions = model.getInstitutions();
        Collection<Attachment> attachments = model.getAttachments(ticket);
        view.displayTicket(ticket, relatedExams, institutions, attachments);
    }

    @Override public void saveTicket(@NotNull ProfessionalTicket ticket)
    {
        model.saveTicket(ticket);
    }

    @Override public void deleteTicket(@NotNull ProfessionalTicket ticket)
    {
        model.deleteTicket(ticket);
    }

    @Override public String complete(@NotNull ProfessionalTicket ticket)
    {
        return model.complete(ticket);
    }

    @Override public String pending(@NotNull ProfessionalTicket ticket)
    {
        return model.pending(ticket);
    }

    @Override public String createPRReview(@NotNull ProfessionalTicket ticket)
    {
        String error = model.completeTechReview(ticket);
        if (error == null)
        {
            ProfessionalTicket correspondingTicket = model.createCorrespondingTicket(ticket);
            if (correspondingTicket != null)
            {
                displayTicket(correspondingTicket);
            }
        }

        return error;
    }

    @Override public void openTicket(String ticketId)
    {
        List<TicketQueryResult> myQueryResults =  model.getTicket(ticketId);
        if (!myQueryResults.isEmpty())
        {
            ticketSelected(myQueryResults.iterator().next());
        }
    }

    @NotNull
    @Override public Collection<Attachment> uploadFile(@NotNull ProfessionalTicket ticket, @NotNull File file)
    {
        model.uploadFile(ticket, file);

        return model.getAttachments(ticket);
    }

    @NotNull
    @Override public Collection<Attachment> deleteAttachment(@NotNull ProfessionalTicket ticket,
                                                             @NotNull Attachment attachment)
    {
        model.deleteAttachment(attachment);

        return model.getAttachments(ticket);
    }

    @NotNull @Override public InputStream openAttachment(@NotNull Attachment attachment) throws IOException
    {
        return model.openAttachment(attachment);
    }

    @Override public void openImages(@NotNull ProfessionalTicket ticket)
    {
        try
        {
            DicomStudy study = ticket.getStudy();
            String studyInstanceUID = study.getStudyInstanceUID();
            if (isNotEmpty(studyInstanceUID))
            {
//                LocalOsirix.closeWindows();
                LocalOsirix.downloadImages(studyInstanceUID);
//                LocalOsirix.openImageWithStudyInstanceUID(studyInstanceUID);
            }
        }
        catch (Exception e)
        {
            Notification.show("Error opening images [" + e.getMessage() + "]", Notification.Type.ERROR_MESSAGE);
        }
    }

    @Override public String uploadPatientReport(@NotNull DicomStudy study, @NotNull File report)
    {
        return model.uploadPatientReport(study, report);
    }

    @Override public void resendReports(@NotNull ProfessionalTicket ticket,
                                        @NotNull String addresses,
                                        boolean erpReport,
                                        boolean erpSiteCallReport,
                                        boolean cmoReport,
                                        boolean cmoSiteCallReport,
                                        boolean techReport)
    {
        model.resendReports(ticket, addresses, erpReport, erpSiteCallReport, cmoReport, cmoSiteCallReport, techReport);
    }
}
