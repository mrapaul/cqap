package com.peirs.datamodel.ticket;

import com.peirs.datamodel.*;

import java.util.*;

public final class TicketQuery
{
    private String theTicketId;
    private String theTicketType;
    private String theTicketPriority;
    private String theTicketStatus;
    private Group theGroup;
    private Institution theInstitution;
    private String thePatientLastName;
    private String thePatientFirstName;
    private String thePatientID;
    private List<String> theModalities;
    private String theStudyDescription;
    private String theAccessionNumber;
    private String theCPTCode;
    private String theStudyDate;
    private String theIIR;
    private String theSiteTechnologist;
    private String theSubmittedBy;
    private long theDateSubmittedFrom;
    private long theDateSubmittedTo;
    private String theERP;
    private Integer theCategory;
    private Boolean theDeleted;
    private User theUser;

    public TicketQuery(String aTicketId,
                       String aTicketType,
                       String aTicketPriority,
                       String aTicketStatus,
                       Group aGroup,
                       Institution aInstitution,
                       String aPatientLastName,
                       String aPatientFirstName,
                       String aPatientID,
                       List<String> aModalities,
                       String aStudyDescription,
                       String aAccessionNumber,
                       String aCPTCode,
                       String aStudyDate,
                       String aIIR,
                       String aSiteTechnologist,
                       String aSubmittedBy,
                       long aDateSubmittedFrom,
                       long aDateSubmittedTo,
                       String aERP,
                       Integer aCategory,
                       Boolean aDeleted,
                       User aUser)
    {
        theTicketId = aTicketId;
        theTicketType = aTicketType;
        theTicketPriority = aTicketPriority;
        theTicketStatus = aTicketStatus;
        theGroup = aGroup;
        theInstitution = aInstitution;
        thePatientLastName = aPatientLastName;
        thePatientFirstName = aPatientFirstName;
        thePatientID = aPatientID;
        theModalities = aModalities;
        theStudyDescription = aStudyDescription;
        theAccessionNumber = aAccessionNumber;
        theCPTCode = aCPTCode;
        theStudyDate = aStudyDate;
        theIIR = aIIR;
        theSiteTechnologist = aSiteTechnologist;
        theSubmittedBy = aSubmittedBy;
        theDateSubmittedFrom = aDateSubmittedFrom;
        theDateSubmittedTo = aDateSubmittedTo;
        theERP = aERP;
        theCategory = aCategory;
        theDeleted = aDeleted;
        theUser = aUser;
    }

    public TicketQuery()
    {
        // empty
    }

    public String getTicketId()
    {
        return theTicketId;
    }

    public void setTicketId(String aTicketId)
    {
        theTicketId = aTicketId;
    }

    public String getTicketType()
    {
        return theTicketType;
    }

    public void setTicketType(String aTicketType)
    {
        theTicketType = aTicketType;
    }

    public String getTicketPriority()
    {
        return theTicketPriority;
    }

    public void setTicketPriority(String aTicketPriority)
    {
        theTicketPriority = aTicketPriority;
    }

    public String getTicketStatus()
    {
        return theTicketStatus;
    }

    public void setTicketStatus(String aTicketStatus)
    {
        theTicketStatus = aTicketStatus;
    }

    public Group getGroup()
    {
        return theGroup;
    }

    public void setGroup(Group aGroup)
    {
        theGroup = aGroup;
    }

    public Institution getInstitution()
    {
        return theInstitution;
    }

    public void setInstitution(Institution aInstitution)
    {
        theInstitution = aInstitution;
    }

    public String getPatientLastName()
    {
        return thePatientLastName;
    }

    public void setPatientLastName(String aPatientLastName)
    {
        thePatientLastName = aPatientLastName;
    }

    public String getPatientFirstName()
    {
        return thePatientFirstName;
    }

    public void setPatientFirstName(String aPatientFirstName)
    {
        thePatientFirstName = aPatientFirstName;
    }

    public String getPatientID()
    {
        return thePatientID;
    }

    public void setPatientID(String aPatientID)
    {
        thePatientID = aPatientID;
    }

    public List<String> getModalities()
    {
        return theModalities;
    }

    public void setModalities(List<String> aModalities)
    {
        theModalities = aModalities;
    }

    public String getStudyDescription()
    {
        return theStudyDescription;
    }

    public void setStudyDescription(String aStudyDescription)
    {
        theStudyDescription = aStudyDescription;
    }

    public String getAccessionNumber()
    {
        return theAccessionNumber;
    }

    public void setAccessionNumber(String aAccessionNumber)
    {
        theAccessionNumber = aAccessionNumber;
    }

    public String getCPTCode()
    {
        return theCPTCode;
    }

    public void setCPTCode(String aCPTCode)
    {
        theCPTCode = aCPTCode;
    }

    public String getStudyDate()
    {
        return theStudyDate;
    }

    public void setStudyDate(String aStudyDate)
    {
        theStudyDate = aStudyDate;
    }

    public String getIIR()
    {
        return theIIR;
    }

    public void setIIR(String aIIR)
    {
        theIIR = aIIR;
    }

    public String getSiteTechnologist()
    {
        return theSiteTechnologist;
    }

    public void setSiteTechnologist(String aSiteTechnologist)
    {
        theSiteTechnologist = aSiteTechnologist;
    }

    public String getSubmittedBy()
    {
        return theSubmittedBy;
    }

    public void setSubmittedBy(String aSubmittedBy)
    {
        theSubmittedBy = aSubmittedBy;
    }

    public long getDateSubmittedFrom()
    {
        return theDateSubmittedFrom;
    }

    public void setDateSubmittedFrom(long aDateSubmittedFrom)
    {
        theDateSubmittedFrom = aDateSubmittedFrom;
    }

    public long getDateSubmittedTo()
    {
        return theDateSubmittedTo;
    }

    public void setDateSubmittedTo(long aDateSubmittedTo)
    {
        theDateSubmittedTo = aDateSubmittedTo;
    }

    public String getERP()
    {
        return theERP;
    }

    public void setERP(String aERP)
    {
        theERP = aERP;
    }

    public Integer getCategory()
    {
        return theCategory;
    }

    public void setCategory(Integer aCategory)
    {
        theCategory = aCategory;
    }

    public Boolean isDeleted()
    {
        return theDeleted;
    }

    public void setDeleted(Boolean aDeleted)
    {
        theDeleted = aDeleted;
    }

    public User getUser()
    {
        return theUser;
    }

    public void setUser(User aUser)
    {
        theUser = aUser;
    }
}
