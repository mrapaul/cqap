package web;

import com.peirs.datamodel.attachments.*;
import com.peirs.datamodel.dicom.*;
import com.peirs.datamodel.ticket.*;
import com.vaadin.data.*;
import com.vaadin.ui.*;
import org.jetbrains.annotations.*;

import java.io.*;
import java.util.*;

import static org.apache.commons.lang3.StringUtils.*;

public class ArchivePresenter implements ArchiveView.Listener
{
    private final ArchiveModel model;
    private final ArchiveView view;

    public ArchivePresenter(ArchiveModel model, ArchiveView view)
    {
        this.model = model;
        this.view = view;

        view.setListener(this);
        view.setContainers(model.getResultsContainer(),
                model.getGroups(),
                model.getInstitutions(),
                model.getPirs());
    }

    @Override public void query(TicketQuery query)
    {
        model.search(query);
    }

    @Override public void reset()
    {
        model.reset();
    }

    @Override public void ticketSelected(TicketQueryResult queryResult)
    {
        ProfessionalTicket ticket = model.getTicket(queryResult);
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

    @NotNull
    @Override public Collection<Attachment> uploadFile(@NotNull ProfessionalTicket ticket, @NotNull File file)
    {
        model.uploadFile(ticket, file);

        return model.getAttachments(ticket);
    }

    @NotNull @Override public InputStream openAttachment(@NotNull Attachment attachment) throws IOException
    {
        return model.openAttachment(attachment);
    }

    @NotNull
    @Override public Collection<Attachment> deleteAttachment(@NotNull ProfessionalTicket ticket,
                                                             @NotNull Attachment attachment)
    {
        model.deleteAttachment(attachment);

        return model.getAttachments(ticket);
    }

    @Override public String complete(@NotNull ProfessionalTicket ticket)
    {
        // empty
        return null;
    }

    @Override public String pending(@NotNull ProfessionalTicket ticket)
    {
        // empty
        return null;
    }

    @Override public String createPRReview(@NotNull ProfessionalTicket ticket)
    {
        // empty
        return null;
    }

    @Override public void openTicket(String ticketId)
    {
        List<TicketQueryResult> myQueryResults =  model.getTicket(ticketId);
        if (!myQueryResults.isEmpty())
        {
            ticketSelected(myQueryResults.iterator().next());
        }
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
//                LocalOsirix.openImageWithStudyInstanceUID(studyInstanceUID);;
            }
        }
        catch (Exception e)
        {
            Notification.show("Error opening images [" + e.getMessage() + "]", Notification.Type.ERROR_MESSAGE);
        }
    }

    @Override public String uploadPatientReport(@NotNull DicomStudy study, @NotNull File report)
    {
        return null;
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
