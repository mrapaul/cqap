package com.peirs.datamodel.ticket;

import com.peirs.datamodel.*;

public class TicketQueryBuilder
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
    private String theModality;
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

    public TicketQueryBuilder()
    {
        // empty
    }

    public TicketQueryBuilder setTicketId(String aTicketId)
    {
        theTicketId = aTicketId;
        return this;
    }

    public TicketQueryBuilder setTicketType(String aTicketType)
    {
        theTicketType = aTicketType;
        return this;
    }

    public TicketQueryBuilder setTicketPriority(String aTicketPriority)
    {
        theTicketPriority = aTicketPriority;
        return this;
    }

    public TicketQueryBuilder setTicketStatus(String aTicketStatus)
    {
        theTicketStatus = aTicketStatus;
        return this;
    }

    public TicketQueryBuilder setGroup(Group aGroup)
    {
        theGroup = aGroup;
        return this;
    }

    public TicketQueryBuilder setInstitution(Institution aInstitution)
    {
        theInstitution = aInstitution;
        return this;
    }

    public TicketQueryBuilder setPatientLastName(String aPatientLastName)
    {
        thePatientLastName = aPatientLastName;
        return this;
    }

    public TicketQueryBuilder setPatientFirstName(String aPatientFirstName)
    {
        thePatientFirstName = aPatientFirstName;
        return this;
    }

    public TicketQueryBuilder setPatientID(String aPatientID)
    {
        thePatientID = aPatientID;
        return this;
    }

    public TicketQueryBuilder setModality(String aModality)
    {
        theModality = aModality;
        return this;
    }

    public TicketQueryBuilder setStudyDescription(String aStudyDescription)
    {
        theStudyDescription = aStudyDescription;
        return this;
    }

    public TicketQueryBuilder setAccessionNumber(String aAccessionNumber)
    {
        theAccessionNumber = aAccessionNumber;
        return this;
    }

    public TicketQueryBuilder setCPTCode(String aCPTCode)
    {
        theCPTCode = aCPTCode;
        return this;
    }

    public TicketQueryBuilder setStudyDate(String aStudyDate)
    {
        theStudyDate = aStudyDate;
        return this;
    }

    public TicketQueryBuilder setIIR(String aIIR)
    {
        theIIR = aIIR;
        return this;
    }

    public TicketQueryBuilder setSiteTechnologist(String aSiteTechnologist)
    {
        theSiteTechnologist = aSiteTechnologist;
        return this;
    }

    public TicketQueryBuilder setSubmittedBy(String aSubmittedBy)
    {
        theSubmittedBy = aSubmittedBy;
        return this;
    }

    public TicketQueryBuilder setDateSubmittedFrom(long aDateSubmittedFrom)
    {
        theDateSubmittedFrom = aDateSubmittedFrom;
        return this;
    }

    public TicketQueryBuilder setDateSubmittedTo(long aDateSubmittedTo)
    {
        theDateSubmittedTo = aDateSubmittedTo;
        return this;
    }

    public TicketQueryBuilder setERP(String aERP)
    {
        theERP = aERP;
        return this;
    }

    public TicketQueryBuilder setCategory(Integer aCategory)
    {
        theCategory = aCategory;
        return this;
    }

    public TicketQueryBuilder setDeleted(Boolean aDeleted)
    {
        theDeleted = aDeleted;
        return this;
    }

    public TicketQueryBuilder setUser(User aUser)
    {
        theUser = aUser;
        return this;
    }

    public TicketQuery build()
    {
        return new TicketQuery(theTicketId,
                theTicketType,
                theTicketPriority,
                theTicketStatus,
                theGroup,
                theInstitution,
                thePatientLastName,
                thePatientFirstName,
                thePatientID,
                theModality,
                theStudyDescription,
                theAccessionNumber,
                theCPTCode,
                theStudyDate,
                theIIR,
                theSiteTechnologist,
                theSubmittedBy,
                theDateSubmittedFrom,
                theDateSubmittedTo,
                theERP,
                theCategory,
                theDeleted,
                theUser);
    }
}