package web;

import com.peirs.datamodel.attachments.*;
import com.peirs.datamodel.dicom.*;
import com.peirs.datamodel.ticket.*;
import com.vaadin.data.*;
import com.vaadin.navigator.*;
import org.jetbrains.annotations.*;

import java.util.*;

public interface WorklistView extends View
{
    void displayTicket(@NotNull ProfessionalTicket ticket,
                       @NotNull Collection<DicomStudy> relatedExams,
                       @NotNull Container institutions,
                       @NotNull Collection<Attachment> attachments);

    void setListener(@NotNull Listener listener);

    void setContainers(@NotNull Container queryResults);

    interface Listener extends PRTicketListener
    {
        void query();

        void reset();

        void ticketSelected(@NotNull TicketQueryResult queryResult);
    }
}
