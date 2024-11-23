package com.lakeland.ris.ui.datamodel;

import org.codehaus.jackson.annotate.*;

import java.util.*;
import com.lakeland.ris.datamodel.*;


public class ReportAddendum
{
    private Date timestamp;
    private String userId;
    private String addendum;

    public ReportAddendum()
    {
        // empty
    }

    @JsonCreator
    public ReportAddendum(Date timestamp,
                          String userId,
                          String addendum)
    {
        super();

        this.timestamp = timestamp;
        this.userId = userId;
        this.addendum = addendum;
    }


    public Date getTimestamp()
    {
        return timestamp;
    }


    public String getUserId()
    {
        return userId;
    }


    public String getAddendum()
    {
        return addendum;
    }
    public void setTimestamp(Date timestamp)
    {
        this.timestamp = timestamp;
    }

    public void setUserId(String userId)
    {
        this.userId = userId;
    }

    public void setAddendum(String addendum)
    {
        this.addendum = addendum;
    }


    public String toString()
    {
        return "ReportAddendum(" +
            " timestamp: " + getTimestamp() +
            " userId: " + getUserId() +
            " addendum: " + getAddendum() + ")";
    }


    public ReportAddendumBuilder toBuilder()
    {
        return new ReportAddendumBuilder(getTimestamp(),
                                         getUserId(),
                                         getAddendum());
    }
}