package web;

import com.peirs.datamodel.*;
import com.peirs.datamodel.dicom.*;
import com.peirs.datamodel.ticket.*;
import com.vaadin.data.util.*;
import com.vaadin.ui.*;

import java.text.*;
import java.util.*;

import static web.ComponentFactory.*;

public class SiteCallView extends VerticalLayout
{
    private final User user;
    private final TextField physicianName;
    private final TextField dateTimeCall;
    private final TextArea callNotes;
    private final TextField communicatedBy;

    public SiteCallView(User user)
    {
        this.user = user;
        physicianName = createFormTextField("Physician Taking Call");
        dateTimeCall = createFormTextField("Date & Time Of Call");
        callNotes = createFormTextArea("Call Notes");
        communicatedBy = createFormTextField("Additional Findings Communicated By");

        initLayout();
    }

    private void initLayout()
    {
        setSizeFull();
        setMargin(true);
        setSpacing(true);

        callNotes.setSizeFull();
        callNotes.addStyleName("report");
        physicianName.setNullRepresentation("");
        dateTimeCall.setNullRepresentation("");
        callNotes.setNullRepresentation("");
        communicatedBy.setNullRepresentation("");

        addComponent(physicianName);
        addComponent(dateTimeCall);
        addComponent(callNotes);
        addComponent(communicatedBy);
    }

    public void displayERPReport(ProfessionalTicket ticket, boolean editable)
    {
        if (ticket.getERPReport() != null && ticket.getERPReport().getSiteCallReport() == null)
        {
            ticket.getERPReport().setSiteCallReport(createNewSiteCallReport(ticket));
        }
        physicianName.setPropertyDataSource(new NestedMethodProperty(ticket, "ERPReport.SiteCallReport.CallPhysician"));
        dateTimeCall.setPropertyDataSource(new NestedMethodProperty(ticket, "ERPReport.SiteCallReport.CallDate"));
        callNotes.setPropertyDataSource(new NestedMethodProperty(ticket, "ERPReport.SiteCallReport.CallNotes"));
        communicatedBy.setPropertyDataSource(new NestedMethodProperty(ticket, "ERPReport.SiteCallReport.Caller"));

        setEditable(editable);
    }

    public void displayCMOReport(ProfessionalTicket ticket, boolean editable)
    {
        if (ticket.getCMOReport() != null && ticket.getCMOReport().getSiteCallReport() == null)
        {
            ticket.getCMOReport().setSiteCallReport(createNewSiteCallReport(ticket));
        }
        physicianName.setPropertyDataSource(new NestedMethodProperty(ticket, "CMOReport.SiteCallReport.CallPhysician"));
        dateTimeCall.setPropertyDataSource(new NestedMethodProperty(ticket, "CMOReport.SiteCallReport.CallDate"));
        callNotes.setPropertyDataSource(new NestedMethodProperty(ticket, "CMOReport.SiteCallReport.CallNotes"));
        communicatedBy.setPropertyDataSource(new NestedMethodProperty(ticket, "CMOReport.SiteCallReport.Caller"));

        setEditable(editable);
    }

    private SiteCallReport createNewSiteCallReport(ProfessionalTicket ticket)
    {
        SiteCallReport siteCallReport = new SiteCallReport();
        siteCallReport.setCaller(user.getName() + (user.getPosition() != null ? (", " + user.getPosition()) : ""));
        siteCallReport.setCallDate(getCallDate(ticket));
        return siteCallReport;
    }

    private String getCallDate(ProfessionalTicket ticket)
    {
        String myTimeZone = getTimeZone(ticket);
        TimeZone myZone = TimeZone.getTimeZone(myTimeZone);
        java.util.Calendar myCalendar = new GregorianCalendar(myZone);
        DateFormat myFormatter = new SimpleDateFormat("dd MMM yyyy HH:mm:ss z");
        myFormatter.setTimeZone(myZone);

        return myFormatter.format(myCalendar.getTime());
    }

    private String getTimeZone(ProfessionalTicket ticket)
    {
        DicomStudy myStudy = ticket.getStudy();
        return (myStudy.getStudyInstitution() != null && myStudy.getStudyInstitution().getAddress() != null &&
                myStudy.getStudyInstitution().getAddress().getTimeZone() != null) ?
                myStudy.getStudyInstitution().getAddress().getTimeZone() :
                java.util.Calendar.getInstance().getTimeZone().getDisplayName();
    }

    private void setEditable(boolean editable)
    {
        physicianName.setReadOnly(!editable);
        dateTimeCall.setReadOnly(!editable);
        callNotes.setReadOnly(!editable);
        communicatedBy.setReadOnly(!editable);
    }
}
