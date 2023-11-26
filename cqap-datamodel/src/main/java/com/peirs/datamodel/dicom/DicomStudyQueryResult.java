package com.peirs.datamodel.dicom;

import com.peirs.datamodel.ticket.*;

import java.util.*;

public class DicomStudyQueryResult
{
    private DicomStudy theStudy;
    private List<String> theTickets;
    private List<TicketType> theTicketTypes;

    public DicomStudyQueryResult()
    {
        theTickets = new ArrayList<>();
        theTicketTypes = new ArrayList<>();
    }

    public DicomStudyQueryResult(DicomStudy aStudy,
                                 List<String> aTickets,
                                 List<TicketType> aTicketTypes)
    {
        theStudy = aStudy;
        theTickets = aTickets;
        theTicketTypes = aTicketTypes;
    }

    public DicomStudy getStudy()
    {
        return theStudy;
    }

    public void setStudy(DicomStudy aStudy)
    {
        theStudy = aStudy;
    }

    public List<String> getTickets()
    {
        return theTickets;
    }

    public void setTickets(List<String> aTickets)
    {
        theTickets = aTickets;
    }

    public List<TicketType> getTicketTypes()
    {
        return theTicketTypes;
    }

    public void setTicketTypes(List<TicketType> aTicketTypes)
    {
        theTicketTypes = aTicketTypes;
    }
}
