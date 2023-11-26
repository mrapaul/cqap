package com.lakeland.ris.ui.datamodel;

import org.codehaus.jackson.annotate.*;
import org.jetbrains.annotations.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;
import java.util.*;

public class OrderReport
{
    @NotNull private String id;
    @NotNull private String orderId;
    @NotNull private Date timestamp;
    @NotNull private String userId;
    @NotNull private String report;
    @NotNull private String location;
    @NotNull private Collection<ReportAddendum> addenda;

    public OrderReport()
    {
        // empty
    }

    @JsonCreator
    public OrderReport(@NotNull String id,
                       @NotNull String orderId,
                       @NotNull Date timestamp,
                       @NotNull String userId,
                       @NotNull String report,
                       @NotNull String location,
                       @NotNull Collection<ReportAddendum> addenda)
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

    @NotNull
    public String getId()
    {
        return id;
    }

    @NotNull
    public String getOrderId()
    {
        return orderId;
    }

    @NotNull
    public Date getTimestamp()
    {
        return timestamp;
    }

    @NotNull
    public String getUserId()
    {
        return userId;
    }

    @NotNull
    public String getReport()
    {
        return report;
    }

    @NotNull
    public String getLocation()
    {
        return location;
    }

    @NotNull
    public Collection<ReportAddendum> getAddenda()
    {
        return addenda;
    }
    public void setId(@NotNull String id)
    {
        this.id = id;
    }

    public void setOrderId(@NotNull String orderId)
    {
        this.orderId = orderId;
    }

    public void setTimestamp(@NotNull Date timestamp)
    {
        this.timestamp = timestamp;
    }

    public void setUserId(@NotNull String userId)
    {
        this.userId = userId;
    }

    public void setReport(@NotNull String report)
    {
        this.report = report;
    }

    public void setLocation(@NotNull String location)
    {
        this.location = location;
    }

    public void setAddenda(@NotNull Collection<ReportAddendum> addenda)
    {
        this.addenda = addenda;
    }

    @NotNull
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

    @NotNull
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