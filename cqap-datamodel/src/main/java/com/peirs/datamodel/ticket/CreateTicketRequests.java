package com.peirs.datamodel.ticket;

import com.peirs.datamodel.*;
import com.peirs.datamodel.dicom.*;

import java.util.*;

public class CreateTicketRequests
{
    private List<CreateTicketRequest> theRequests;
    private User theUser;

    public CreateTicketRequests()
    {
        theRequests = new ArrayList<>();
    }

    public CreateTicketRequests(List<CreateTicketRequest> aRequests, User aUser)
    {
        theRequests = aRequests;
        theUser = aUser;
    }

    public List<CreateTicketRequest> getRequests()
    {
        return theRequests;
    }

    public void setRequests(List<CreateTicketRequest> aRequests)
    {
        theRequests = aRequests;
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
