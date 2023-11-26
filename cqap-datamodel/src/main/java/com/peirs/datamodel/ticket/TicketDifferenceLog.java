package com.peirs.datamodel.ticket;

import org.springframework.data.annotation.*;
import org.springframework.data.mongodb.core.index.*;
import org.springframework.data.mongodb.core.mapping.*;

import java.util.*;

@Document(collection = "TicketDifferenceLogs")
public class TicketDifferenceLog
{
    @Id private String theId;
    @Indexed private String theViewId;
    private Date theDiffDate;
    private String theDifference;

    public TicketDifferenceLog(String aViewId, Date aDiffDate, String aDifference)
    {
        theViewId = aViewId;
        theDiffDate = aDiffDate;
        theDifference = aDifference;
    }

    public TicketDifferenceLog()
    {
        // empty
    }

    public String getViewId()
    {
        return theViewId;
    }

    public void setViewId(String aViewId)
    {
        theViewId = aViewId;
    }

    public Date getDiffDate()
    {
        return theDiffDate;
    }

    public void setDiffDate(Date aDiffDate)
    {
        theDiffDate = aDiffDate;
    }

    public String getDifference()
    {
        return theDifference;
    }

    public void setDifference(String aDifference)
    {
        theDifference = aDifference;
    }
}
