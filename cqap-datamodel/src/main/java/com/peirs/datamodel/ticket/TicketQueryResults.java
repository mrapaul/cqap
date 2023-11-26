package com.peirs.datamodel.ticket;

import java.util.*;

public class TicketQueryResults
{
    private List<TicketQueryResult> theResults;

    public TicketQueryResults()
    {
        theResults = new ArrayList<>();
    }

    public TicketQueryResults(List<TicketQueryResult> aTickets)
    {
        theResults = aTickets;
    }

    public List<TicketQueryResult> getTickets()
    {
        return theResults;
    }

    public void setTickets(List<TicketQueryResult> aTickets)
    {
        theResults = aTickets;
    }
}
