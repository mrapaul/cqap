package com.peirs.datamodel.ticket;

import java.util.*;

public class CreateTicketRequest
{
    private String theStudyId;
    private TicketPriority thePriority;
    private List<TicketType> theRequestedTypes;
    private boolean theSubmittedVariance;
    private List<String> theExistingTicketIds;
    private List<TicketType> theExistingTicketTypes;

    public CreateTicketRequest()
    {
        theExistingTicketIds = new ArrayList<>();
        theExistingTicketTypes = new ArrayList<>();
    }

    public CreateTicketRequest(String aStudyId,
                               TicketPriority aPriority,
                               List<TicketType> aRequestedTypes,
                               boolean aSubmittedVariance,
                               List<String> aExistingTicketIds,
                               List<TicketType> aExistingTicketTypes)
    {
        theStudyId = aStudyId;
        thePriority = aPriority;
        theRequestedTypes = aRequestedTypes;
        theSubmittedVariance = aSubmittedVariance;
        theExistingTicketIds = aExistingTicketIds;
        theExistingTicketTypes = aExistingTicketTypes;
    }

    public String getStudyId()
    {
        return theStudyId;
    }

    public void setStudyId(String aStudyId)
    {
        theStudyId = aStudyId;
    }

    public TicketPriority getPriority()
    {
        return thePriority;
    }

    public void setPriority(TicketPriority aPriority)
    {
        thePriority = aPriority;
    }

    public List<TicketType> getRequestedTypes()
    {
        return theRequestedTypes;
    }

    public void setRequestedTypes(List<TicketType> aRequestedTypes)
    {
        theRequestedTypes = aRequestedTypes;
    }

    public boolean isSubmittedVariance()
    {
        return theSubmittedVariance;
    }

    public void setSubmittedVariance(boolean aSubmittedVariance)
    {
        theSubmittedVariance = aSubmittedVariance;
    }

    public List<String> getExistingTicketIds()
    {
        return theExistingTicketIds;
    }

    public void setExistingTicketIds(List<String> aExistingTicketIds)
    {
        theExistingTicketIds = aExistingTicketIds;
    }

    public List<TicketType> getExistingTicketTypes()
    {
        return theExistingTicketTypes;
    }

    public void setExistingTicketTypes(List<TicketType> aExistingTicketTypes)
    {
        theExistingTicketTypes = aExistingTicketTypes;
    }
}
