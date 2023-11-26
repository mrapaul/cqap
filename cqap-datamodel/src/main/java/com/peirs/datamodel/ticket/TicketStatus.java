package com.peirs.datamodel.ticket;

public enum TicketStatus
{
    OPEN_ERP_REVIEW("OPEN, ERP Review", TicketType.PR),
    TECH_OPEN_ERP_REVIEW("TECH OPEN, ERP Review", TicketType.TR),
    OPEN_CMO_REVIEW("OPEN, CMO Review", TicketType.PR),
    TECH_OPEN_CMO_REVIEW("TECH OPEN, CMO Review", TicketType.TR),
    OPEN_PIR_REVIEW("OPEN, PIR Review", TicketType.PR),
    OPEN_SITE_CALL_REQUIRED("OPEN, Site Call", TicketType.PR),
    PENDING("Pending", TicketType.PR),
    TECH_PENDING("TECH Pending", TicketType.TR),
    COMPLETED("Completed", TicketType.PR),
    TECH_COMPLETED("TECH Completed", TicketType.TR);

    private final String theDescription;
    private TicketType theTicketType;

    TicketStatus(String aDescription, TicketType aTicketType)
    {
        theDescription = aDescription;
        theTicketType = aTicketType;
    }

    public String getDescription()
    {
        return theDescription;
    }

    public TicketType getTicketType()
    {
        return theTicketType;
    }
}
