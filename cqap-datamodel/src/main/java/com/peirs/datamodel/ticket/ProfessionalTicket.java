package com.peirs.datamodel.ticket;

import com.peirs.datamodel.*;
import com.peirs.datamodel.dicom.*;
import com.peirs.datamodel.hl7.*;
import org.springframework.data.annotation.*;
import org.springframework.data.mongodb.core.index.*;
import org.springframework.data.mongodb.core.mapping.*;

import java.util.*;

@Document(collection = "PRTickets")
public class ProfessionalTicket extends BaseObject
{
    @Id private String theId;
    @Indexed private String theViewId;
    @Indexed private TicketType theType;
    @DBRef private DicomStudy theStudy;
    @Indexed private long theSubmittedTime;
    private ERPReport theERPReport;
    private IIRReport theIIRReport;
    private CMOReport theCMOReport;
    private TechReport theTechReport;
    @Indexed private TicketPriority thePriority;
    @Indexed private TicketStatus thePreviousStatus;
    @Indexed private TicketStatus theStatus;
    @DBRef private User theSubmittedUser;
    private List<InternalNote> theNotes;
    private List<String> theAttachments;
    private List<HL7> theHL7Messages;
    @DBRef private Institution theInstitution;
    @Indexed private boolean theSubmittedVariance;
    @Indexed private String theCorrespondingReviewViewId;

    public ProfessionalTicket()
    {
        theNotes = new ArrayList<>();
        theAttachments = new ArrayList<>();
        theHL7Messages = new ArrayList<>();
        theType = TicketType.PR;
    }

    public IIRReport getIIRReport()
    {
        return theIIRReport;
    }

    public void setIIRReport(IIRReport aIIRReport)
    {
        theIIRReport = aIIRReport;
    }

    public CMOReport getCMOReport()
    {
        return theCMOReport;
    }

    public void setCMOReport(CMOReport aCMOReport)
    {
        theCMOReport = aCMOReport;
    }

    public String getId()
    {
        return theId;
    }

    public void setId(String aId)
    {
        theId = aId;
    }

    public String getViewId()
    {
        return theViewId;
    }

    public void setViewId(String aViewId)
    {
        theViewId = aViewId;
    }

    public TicketType getType()
    {
        return theType;
    }

    public void setType(TicketType aType)
    {
        theType = aType;
    }

    public DicomStudy getStudy()
    {
        return theStudy;
    }

    public void setStudy(DicomStudy aStudy)
    {
        theStudy = aStudy;
    }

    public long getSubmittedTime()
    {
        return theSubmittedTime;
    }

    public void setSubmittedTime(long aSubmittedTime)
    {
        theSubmittedTime = aSubmittedTime;
    }

    public ERPReport getERPReport()
    {
        return theERPReport;
    }

    public void setERPReport(ERPReport aERPReport)
    {
        theERPReport = aERPReport;
    }

    public TicketPriority getPriority()
    {
        return thePriority;
    }

    public void setPriority(TicketPriority aPriority)
    {
        thePriority = aPriority;
    }

    public TicketStatus getPreviousStatus()
    {
        return thePreviousStatus;
    }

    public void setPreviousStatus(TicketStatus aPreviousStatus)
    {
        thePreviousStatus = aPreviousStatus;
    }

    public TicketStatus getStatus()
    {
        return theStatus;
    }

    public void setStatus(TicketStatus aStatus)
    {
        theStatus = aStatus;
    }

    public User getSubmittedUser()
    {
        return theSubmittedUser;
    }

    public void setSubmittedUser(User aSubmittedUser)
    {
        theSubmittedUser = aSubmittedUser;
    }

    public List<InternalNote> getNotes()
    {
        return theNotes;
    }

    public void setNotes(List<InternalNote> aNotes)
    {
        theNotes = aNotes;
    }

    public List<String> getAttachments()
    {
        return theAttachments;
    }

    public void setAttachments(List<String> aAttachments)
    {
        theAttachments = aAttachments;
    }

    public List<HL7> getHL7Messages()
    {
        return theHL7Messages;
    }

    public void setHL7Messages(List<HL7> aHL7Messages)
    {
        theHL7Messages = aHL7Messages;
    }

    public Institution getInstitution()
    {
        return theInstitution;
    }

    public void setInstitution(Institution aInstitution)
    {
        theInstitution = aInstitution;
    }

    public boolean isSubmittedVariance()
    {
        return theSubmittedVariance;
    }

    public void setSubmittedVariance(boolean aSubmittedVariance)
    {
        theSubmittedVariance = aSubmittedVariance;
    }

    public void addNote(InternalNote aNote)
    {
        theNotes.add(aNote);
    }

    public void addAttachment(String aFilename)
    {
        theAttachments.add(aFilename);
    }

    public TechReport getTechReport()
    {
        return theTechReport;
    }

    public void setTechReport(TechReport aTechReport)
    {
        theTechReport = aTechReport;
    }

    public String getCorrespondingReviewViewId()
    {
        return theCorrespondingReviewViewId;
    }

    public void setCorrespondingReviewViewId(String aCorrespondingReviewViewId)
    {
        theCorrespondingReviewViewId = aCorrespondingReviewViewId;
    }
}
