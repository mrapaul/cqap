package web;

import com.peirs.datamodel.attachments.*;
import com.peirs.datamodel.dicom.*;
import com.peirs.datamodel.ticket.*;
import com.vaadin.data.*;
import com.vaadin.ui.*;


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

    @Override public void saveTicket(ProfessionalTicket ticket)
    {
        model.saveTicket(ticket);
    }

    @Override public void deleteTicket(ProfessionalTicket ticket)
    {
        model.deleteTicket(ticket);
    }

    
    @Override public Collection<Attachment> uploadFile(ProfessionalTicket ticket, File file)
    {
        model.uploadFile(ticket, file);

        return model.getAttachments(ticket);
    }

    @Override public InputStream openAttachment(Attachment attachment) throws IOException
    {
        return model.openAttachment(attachment);
    }

    
    @Override public Collection<Attachment> deleteAttachment(ProfessionalTicket ticket,
                                                             Attachment attachment)
    {
        model.deleteAttachment(attachment);

        return model.getAttachments(ticket);
    }

    @Override public String complete(ProfessionalTicket ticket)
    {
        // empty
        return null;
    }

    @Override public String pending(ProfessionalTicket ticket)
    {
        // empty
        return null;
    }

    @Override public String createPRReview(ProfessionalTicket ticket)
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

    @Override public void openImages(ProfessionalTicket ticket)
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

    @Override public String uploadPatientReport(DicomStudy study, File report)
    {
        return null;
    }

    @Override public void resendReports(ProfessionalTicket ticket,
                                        String addresses,
                                        boolean erpReport,
                                        boolean erpSiteCallReport,
                                        boolean cmoReport,
                                        boolean cmoSiteCallReport,
                                        boolean techReport)
    {
        model.resendReports(ticket, addresses, erpReport, erpSiteCallReport, cmoReport, cmoSiteCallReport, techReport);
    }
}
