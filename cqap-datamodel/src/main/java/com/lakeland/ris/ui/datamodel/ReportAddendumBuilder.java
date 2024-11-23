package com.lakeland.ris.ui.datamodel;


import java.util.*;
import com.lakeland.ris.datamodel.*;


public class ReportAddendumBuilder
{
    private Date timestamp;
    private String userId;
    private String addendum;

    public ReportAddendumBuilder(Date timestamp,
                                 String userId,
                                 String addendum)
    {
        super();

        this.timestamp = timestamp;
        this.userId = userId;
        this.addendum = addendum;
    }


    
    public ReportAddendumBuilder setTimestamp(Date timestamp)
    {
        this.timestamp = timestamp;

        return self();
    }

    
    public ReportAddendumBuilder setUserId(String userId)
    {
        this.userId = userId;

        return self();
    }

    
    public ReportAddendumBuilder setAddendum(String addendum)
    {
        this.addendum = addendum;

        return self();
    }

    
    protected Date getTimestamp()
    {
        return timestamp;
    }

    
    protected String getUserId()
    {
        return userId;
    }

    
    protected String getAddendum()
    {
        return addendum;
    }

    
    public ReportAddendum build()
    {
        return new ReportAddendum(getTimestamp(),
                                  getUserId(),
                                  getAddendum());
    }


    
    protected ReportAddendumBuilder self()
    {
        return this;
    }
}