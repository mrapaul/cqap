package web;

import com.peirs.datamodel.attachments.*;
import com.peirs.datamodel.dicom.*;
import com.peirs.datamodel.ticket.*;
import com.vaadin.data.*;
import com.vaadin.navigator.*;


import java.util.*;

public interface WorklistView extends View
{
    void displayTicket(ProfessionalTicket ticket,
                       Collection<DicomStudy> relatedExams,
                       Container institutions,
                       Collection<Attachment> attachments);

    void setListener(Listener listener);

    void setContainers(Container queryResults);

    interface Listener extends PRTicketListener
    {
        void query();

        void reset();

        void ticketSelected(TicketQueryResult queryResult);
    }
}
