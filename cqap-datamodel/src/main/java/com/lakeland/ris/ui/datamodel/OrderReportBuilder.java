package com.lakeland.ris.ui.datamodel;

import org.jetbrains.annotations.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;
import java.util.*;

public class OrderReportBuilder
{
    @NotNull private String id;
    @NotNull private String orderId;
    @NotNull private Date timestamp;
    @NotNull private String userId;
    @NotNull private String report;
    @NotNull private String location;
    @NotNull private Collection<ReportAddendum> addenda;

    public OrderReportBuilder(@NotNull String id,
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
    public OrderReportBuilder setId(@NotNull String id)
    {
        this.id = id;

        return self();
    }

    @NotNull
    public OrderReportBuilder setOrderId(@NotNull String orderId)
    {
        this.orderId = orderId;

        return self();
    }

    @NotNull
    public OrderReportBuilder setTimestamp(@NotNull Date timestamp)
    {
        this.timestamp = timestamp;

        return self();
    }

    @NotNull
    public OrderReportBuilder setUserId(@NotNull String userId)
    {
        this.userId = userId;

        return self();
    }

    @NotNull
    public OrderReportBuilder setReport(@NotNull String report)
    {
        this.report = report;

        return self();
    }

    @NotNull
    public OrderReportBuilder setLocation(@NotNull String location)
    {
        this.location = location;

        return self();
    }

    @NotNull
    public OrderReportBuilder setAddenda(@NotNull Collection<ReportAddendum> addenda)
    {
        this.addenda = addenda;

        return self();
    }

    @NotNull
    protected String getId()
    {
        return id;
    }

    @NotNull
    protected String getOrderId()
    {
        return orderId;
    }

    @NotNull
    protected Date getTimestamp()
    {
        return timestamp;
    }

    @NotNull
    protected String getUserId()
    {
        return userId;
    }

    @NotNull
    protected String getReport()
    {
        return report;
    }

    @NotNull
    protected String getLocation()
    {
        return location;
    }

    @NotNull
    protected Collection<ReportAddendum> getAddenda()
    {
        return addenda;
    }

    @NotNull
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


    @NotNull
    protected OrderReportBuilder self()
    {
        return this;
    }
}