package web;

import com.peirs.datamodel.attachments.*;
import com.peirs.datamodel.ticket.*;
import org.jetbrains.annotations.*;

import java.io.*;
import java.util.*;

public interface PRTicketListener extends ExamReportAttachListener
{
    void saveTicket(@NotNull ProfessionalTicket ticket);

    void deleteTicket(@NotNull ProfessionalTicket ticket);

    String complete(@NotNull ProfessionalTicket ticket);

    String pending(@NotNull ProfessionalTicket ticket);

    String createPRReview(@NotNull ProfessionalTicket ticket);

    @NotNull
    Collection<Attachment> uploadFile(@NotNull ProfessionalTicket ticket, @NotNull File file);

    @NotNull
    InputStream openAttachment(@NotNull Attachment attachment) throws IOException;

    void openTicket(String caption);

    @NotNull
    Collection<Attachment> deleteAttachment(@NotNull ProfessionalTicket ticket, @NotNull Attachment attachment);

    void openImages(@NotNull ProfessionalTicket ticket);

    void resendReports(@NotNull ProfessionalTicket ticket,
                       @NotNull String addresses,
                       boolean erpReport,
                       boolean erpSiteCallReport,
                       boolean cmoReport,
                       boolean cmoSiteCallReport,
                       boolean techReport);
}
