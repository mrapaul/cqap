package com.peirs.datamodel.ticket;

import com.peirs.datamodel.*;

import java.util.*;

public class TicketQueryResult
{
    private String theTicketId;
    private String theViewId;
    private TicketType theType;
    private TicketPriority thePriority;
    private TicketStatus theStatus;
    private long theSubmittedTime;
    private String theStudyDate;
    private String thePatientName;
    private String thePatientID;
    private String thePatientBirthDate;
    private String theAccessionNumber;
    private String theStudyDescription;
    private String theModality;
    private String theInstitutionName;
    private Collection<String> theInstitutions;
    private Institution theInstitution;
    private int theERPCategory;
    private String theERP;
    private int theCMOCategory;
    private String theCMO;
    private int theCategory;

    public String getTicketId()
    {
        return theTicketId;
    }

    public void setTicketId(String aTicketId)
    {
        theTicketId = aTicketId;
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

    public TicketPriority getPriority()
    {
        return thePriority;
    }

    public void setPriority(TicketPriority aPriority)
    {
        thePriority = aPriority;
    }

    public TicketStatus getStatus()
    {
        return theStatus;
    }

    public void setStatus(TicketStatus aStatus)
    {
        theStatus = aStatus;
    }

    public long getSubmittedTime()
    {
        return theSubmittedTime;
    }

    public void setSubmittedTime(long aSubmittedTime)
    {
        theSubmittedTime = aSubmittedTime;
    }

    public String getStudyDate()
    {
        return theStudyDate;
    }

    public void setStudyDate(String aStudyDate)
    {
        theStudyDate = aStudyDate;
    }

    public String getPatientName()
    {
        return thePatientName;
    }

    public void setPatientName(String aPatientName)
    {
        thePatientName = aPatientName;
    }

    public String getPatientID()
    {
        return thePatientID;
    }

    public void setPatientID(String aPatientID)
    {
        thePatientID = aPatientID;
    }

    public String getPatientBirthDate()
    {
        return thePatientBirthDate;
    }

    public void setPatientBirthDate(String aPatientBirthDate)
    {
        thePatientBirthDate = aPatientBirthDate;
    }

    public String getAccessionNumber()
    {
        return theAccessionNumber;
    }

    public void setAccessionNumber(String aAccessionNumber)
    {
        theAccessionNumber = aAccessionNumber;
    }

    public String getStudyDescription()
    {
        return theStudyDescription;
    }

    public void setStudyDescription(String aStudyDescription)
    {
        theStudyDescription = aStudyDescription;
    }

    public String getModality()
    {
        return theModality;
    }

    public void setModality(String aModality)
    {
        theModality = aModality;
    }

    public String getInstitutionName()
    {
        return theInstitutionName;
    }

    public void setInstitutionName(String aInstitutionName)
    {
        theInstitutionName = aInstitutionName;
    }

    public Collection<String> getInstitutions()
    {
        return theInstitutions;
    }

    public void setInstitutions(Collection<String> aInstitutions)
    {
        theInstitutions = aInstitutions;
    }

    public Institution getInstitution()
    {
        return theInstitution;
    }

    public void setInstitution(Institution aInstitution)
    {
        theInstitution = aInstitution;
    }

    public int getERPCategory()
    {
        return theERPCategory;
    }

    public void setERPCategory(int aERPCategory)
    {
        theERPCategory = aERPCategory;
    }

    public int getCMOCategory()
    {
        return theCMOCategory;
    }

    public void setCMOCategory(int aCMOCategory)
    {
        theCMOCategory = aCMOCategory;
    }

    public String getERP()
    {
        return theERP;
    }

    public void setERP(String aERP)
    {
        theERP = aERP;
    }

    public String getCMO()
    {
        return theCMO;
    }

    public void setCMO(String aCMO)
    {
        theCMO = aCMO;
    }

    public int getCategory()
    {
        return theCategory;
    }

    public void setCategory(int aCategory)
    {
        theCategory = aCategory;
    }
}
