package com.peirs.datamodel.ticket;

import java.util.*;

public class ProfessionalTickets
{
    private List<ProfessionalTicket> theTickets;

    public ProfessionalTickets()
    {
        theTickets = new ArrayList<>();
    }

    public ProfessionalTickets(List<ProfessionalTicket> aTickets)
    {
        theTickets = aTickets;
    }

    public List<ProfessionalTicket> getTickets()
    {
        return theTickets;
    }

    public void setTickets(List<ProfessionalTicket> aTickets)
    {
        theTickets = aTickets;
    }
}
