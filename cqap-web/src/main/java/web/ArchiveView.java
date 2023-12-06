package web;

import com.peirs.datamodel.attachments.*;
import com.peirs.datamodel.dicom.*;
import com.peirs.datamodel.ticket.*;
import com.vaadin.data.*;
import com.vaadin.navigator.*;
import org.jetbrains.annotations.*;

import java.util.*;

public interface ArchiveView extends View
{
    void displayTicket(@NotNull ProfessionalTicket ticket,
                       @NotNull Collection<DicomStudy> relatedExams,
                       @NotNull Container institutions,
                       @NotNull Collection<Attachment> attachments);

    void setListener(Listener listener);

    void setContainers(Container queryResults, Container groups, Container institutions, Container pirs);

    interface Listener extends PRTicketListener
    {
        void query(TicketQuery query);

        void reset();

        void ticketSelected(TicketQueryResult queryResult);
    }
}
