package com.lakeland.ris.ui.datamodel;

import org.codehaus.jackson.annotate.*;

import java.util.*;
import com.lakeland.ris.datamodel.*;
import java.util.*;

public class OrderReport
{
    private String id;
    private String orderId;
    private Date timestamp;
    private String userId;
    private String report;
    private String location;
    private Collection<ReportAddendum> addenda;

    public OrderReport()
    {
        // empty
    }

    @JsonCreator
    public OrderReport(String id,
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

    
    public String getId()
    {
        return id;
    }

    
    public String getOrderId()
    {
        return orderId;
    }

    
    public Date getTimestamp()
    {
        return timestamp;
    }

    
    public String getUserId()
    {
        return userId;
    }

    
    public String getReport()
    {
        return report;
    }

    
    public String getLocation()
    {
        return location;
    }

    
    public Collection<ReportAddendum> getAddenda()
    {
        return addenda;
    }
    public void setId(String id)
    {
        this.id = id;
    }

    public void setOrderId(String orderId)
    {
        this.orderId = orderId;
    }

    public void setTimestamp(Date timestamp)
    {
        this.timestamp = timestamp;
    }

    public void setUserId(String userId)
    {
        this.userId = userId;
    }

    public void setReport(String report)
    {
        this.report = report;
    }

    public void setLocation(String location)
    {
        this.location = location;
    }

    public void setAddenda(Collection<ReportAddendum> addenda)
    {
        this.addenda = addenda;
    }

    
    public String toString()
    {
        return "OrderReport(" +
            " id: " + getId() +
            " orderId: " + getOrderId() +
            " timestamp: " + getTimestamp() +
            " userId: " + getUserId() +
            " report: " + getReport() +
            " location: " + getLocation() +
            " addenda: " + getAddenda() + ")";
    }

    
    public OrderReportBuilder toBuilder()
    {
        return new OrderReportBuilder(getId(),
                                      getOrderId(),
                                      getTimestamp(),
                                      getUserId(),
                                      getReport(),
                                      getLocation(),
                                      getAddenda());
    }
}