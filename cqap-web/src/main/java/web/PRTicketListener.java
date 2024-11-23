package web;

import com.peirs.datamodel.attachments.*;
import com.peirs.datamodel.ticket.*;


import java.io.*;
import java.util.*;

public interface PRTicketListener extends ExamReportAttachListener
{
    void saveTicket(ProfessionalTicket ticket);

    void deleteTicket(ProfessionalTicket ticket);

    String complete(ProfessionalTicket ticket);

    String pending(ProfessionalTicket ticket);

    String createPRReview(ProfessionalTicket ticket);

    
    Collection<Attachment> uploadFile(ProfessionalTicket ticket, File file);

    
    InputStream openAttachment(Attachment attachment) throws IOException;

    void openTicket(String caption);

    
    Collection<Attachment> deleteAttachment(ProfessionalTicket ticket, Attachment attachment);

    void openImages(ProfessionalTicket ticket);

    void resendReports(ProfessionalTicket ticket,
                       String addresses,
                       boolean erpReport,
                       boolean erpSiteCallReport,
                       boolean cmoReport,
                       boolean cmoSiteCallReport,
                       boolean techReport);
}
