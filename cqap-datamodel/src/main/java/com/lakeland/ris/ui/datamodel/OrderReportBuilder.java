package com.lakeland.ris.ui.datamodel;


import java.util.*;
import com.lakeland.ris.datamodel.*;
import java.util.*;

public class OrderReportBuilder
{
    private String id;
    private String orderId;
    private Date timestamp;
    private String userId;
    private String report;
    private String location;
    private Collection<ReportAddendum> addenda;

    public OrderReportBuilder(String id,
                              String orderId,
                              Date timestamp,
                              String userId,
                              String report,
                              String location,
                              Collection<ReportAddendum> addenda)
    {
        super();

        this.id = id;
        this.orderId = orderId;
        this.timestamp = timestamp;
        this.userId = userId;
        this.report = report;
        this.location = location;
        this.addenda = addenda;
    }


    
    public OrderReportBuilder setId(String id)
    {
        this.id = id;

        return self();
    }

    
    public OrderReportBuilder setOrderId(String orderId)
    {
        this.orderId = orderId;

        return self();
    }

    
    public OrderReportBuilder setTimestamp(Date timestamp)
    {
        this.timestamp = timestamp;

        return self();
    }

    
    public OrderReportBuilder setUserId(String userId)
    {
        this.userId = userId;

        return self();
    }

    
    public OrderReportBuilder setReport(String report)
    {
        this.report = report;

        return self();
    }

    
    public OrderReportBuilder setLocation(String location)
    {
        this.location = location;

        return self();
    }

    
    public OrderReportBuilder setAddenda(Collection<ReportAddendum> addenda)
    {
        this.addenda = addenda;

        return self();
    }

    
    protected String getId()
    {
        return id;
    }

    
    protected String getOrderId()
    {
        return orderId;
    }

    
    protected Date getTimestamp()
    {
        return timestamp;
    }

    
    protected String getUserId()
    {
        return userId;
    }

    
    protected String getReport()
    {
        return report;
    }

    
    protected String getLocation()
    {
        return location;
    }

    
    protected Collection<ReportAddendum> getAddenda()
    {
        return addenda;
    }

    
    public OrderReport build()
    {
        return new OrderReport(getId(),
                               getOrderId(),
                               getTimestamp(),
                               getUserId(),
                               getReport(),
                               getLocation(),
                               getAddenda());
    }


    
    protected OrderReportBuilder self()
    {
        return this;
    }
}