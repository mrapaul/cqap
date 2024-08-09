package com.peirs.datamodel;

import java.util.*;

public class Contract
{
    private long theStartDate;
    private long theEndDate;
    private boolean thePRContract;
    private boolean theTRContract;
    private TicketPriorities thePriorities;

    public long getStartDate()
    {
        return theStartDate;
    }

    public void setStartDate(long aStartDate)
    {
        theStartDate = aStartDate;
    }

    public long getEndDate()
    {
        return theEndDate;
    }

    public void setEndDate(long aEndDate)
    {
        theEndDate = aEndDate;
    }

    public boolean isPRContract()
    {
        return thePRContract;
    }

    public void setPRContract(boolean aPRContract)
    {
        thePRContract = aPRContract;
    }

    public boolean isTRContract()
    {
        return theTRContract;
    }

    public void setTRContract(boolean aTRContract)
    {
        theTRContract = aTRContract;
    }

    public TicketPriorities getPriorities()
    {
        return thePriorities;
    }

    public void setPriorities(TicketPriorities aPriorities)
    {
        thePriorities = aPriorities;
    }
}
