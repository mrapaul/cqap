package com.capstone.fx.model;

import com.peirs.datamodel.*;
import com.peirs.datamodel.ticket.*;
import javafx.collections.*;

import java.util.*;

public class EntityCache
{
    private final ObservableList<String> thePIRs;
    private final ObservableList<String> theSTs;
    private final ObservableList<Group> theGroups;
    private final ObservableList<Institution> theInstitutions;
    private final ObservableList<Country> theCountries;
    private final ObservableList<TicketQueryResult> theTickets;
    private TicketQueryResult theSelectedTicket;

    public EntityCache()
    {
        thePIRs = FXCollections.observableArrayList();
        theSTs = FXCollections.observableArrayList();
        theGroups = FXCollections.observableArrayList();
        theInstitutions = FXCollections.observableArrayList();
        theCountries = FXCollections.observableArrayList();
        theTickets = FXCollections.observableArrayList();
    }

    public ObservableList<String> getPIRs()
    {
        return thePIRs;
    }

    public ObservableList<String> getSTs()
    {
        return theSTs;
    }

    public ObservableList<Group> getGroups()
    {
        return theGroups;
    }

    public ObservableList<Institution> getInstitutions()
    {
        return theInstitutions;
    }

    public void setPIRs(List<String> aPIRs)
    {
        thePIRs.addAll(aPIRs);
    }

    public void setSTs(List<String> aSTs)
    {
        theSTs.addAll(aSTs);
    }

    public void setGroups(List<Group> aGroups)
    {
        theGroups.clear();
        theGroups.addAll(aGroups);
    }

    public void setInstitutions(List<Institution> aInstitutions)
    {
        theInstitutions.clear();
        theInstitutions.addAll(aInstitutions);
    }

    public void setCountries(List<Country> aCountries)
    {
        theCountries.clear();
        theCountries.addAll(aCountries);
    }

    public List<Country> getCountries()
    {
        return theCountries;
    }

    public ObservableList<TicketQueryResult> getTickets()
    {
        return theTickets;
    }

    public void setSelectedTicket(TicketQueryResult aSelectedTicket)
    {
        theSelectedTicket = aSelectedTicket;
    }

    public TicketQueryResult getSelectedTicket()
    {
        return theSelectedTicket;
    }
}
