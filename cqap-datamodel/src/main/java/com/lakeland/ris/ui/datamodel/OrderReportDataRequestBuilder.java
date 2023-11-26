package com.lakeland.ris.ui.datamodel;

import org.jetbrains.annotations.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;
import java.util.*;

public class OrderReportDataRequestBuilder
{
    @NotNull private Date start;
    @NotNull private Date end;
    @NotNull private Collection<String> radiologists;
    @NotNull private Collection<String> institutions;
    @NotNull private Collection<OrderPriority> priorities;

    public OrderReportDataRequestBuilder(@NotNull Date start,
                                         @NotNull Date end,
                                         @NotNull Collection<String> radiologists,
                                         @NotNull Collection<String> institutions,
                                         @NotNull Collection<OrderPriority> priorities)
    {
        super();

        this.start = start;
        this.end = end;
        this.radiologists = radiologists;
        this.institutions = institutions;
        this.priorities = priorities;
    }


    @NotNull
    public OrderReportDataRequestBuilder setStart(@NotNull Date start)
    {
        this.start = start;

        return self();
    }

    @NotNull
    public OrderReportDataRequestBuilder setEnd(@NotNull Date end)
    {
        this.end = end;

        return self();
    }

    @NotNull
    public OrderReportDataRequestBuilder setRadiologists(@NotNull Collection<String> radiologists)
    {
        this.radiologists = radiologists;

        return self();
    }

    @NotNull
    public OrderReportDataRequestBuilder setInstitutions(@NotNull Collection<String> institutions)
    {
        this.institutions = institutions;

        return self();
    }

    @NotNull
    public OrderReportDataRequestBuilder setPriorities(@NotNull Collection<OrderPriority> priorities)
    {
        this.priorities = priorities;

        return self();
    }

    @NotNull
    protected Date getStart()
    {
        return start;
    }

    @NotNull
    protected Date getEnd()
    {
        return end;
    }

    @NotNull
    protected Collection<String> getRadiologists()
    {
        return radiologists;
    }

    @NotNull
    protected Collection<String> getInstitutions()
    {
        return institutions;
    }

    @NotNull
    protected Collection<OrderPriority> getPriorities()
    {
        return priorities;
    }

    @NotNull
    public OrderReportDataRequest build()
    {
        return new OrderReportDataRequest(getStart(),
                                          getEnd(),
                                          getRadiologists(),
                                          getInstitutions(),
                                          getPriorities());
    }


    @NotNull
    protected OrderReportDataRequestBuilder self()
    {
        return this;
    }
}