package com.lakeland.ris.ui.datamodel;

import org.codehaus.jackson.annotate.*;
import org.jetbrains.annotations.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;
import java.util.*;

public class OrderReportDataRequest
{
    @NotNull private Date start;
    @NotNull private Date end;
    @NotNull private Collection<String> radiologists;
    @NotNull private Collection<String> institutions;
    @NotNull private Collection<OrderPriority> priorities;

    public OrderReportDataRequest()
    {
        // empty
    }

    @JsonCreator
    public OrderReportDataRequest(@NotNull Date start,
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
    public Date getStart()
    {
        return start;
    }

    @NotNull
    public Date getEnd()
    {
        return end;
    }

    @NotNull
    public Collection<String> getRadiologists()
    {
        return radiologists;
    }

    @NotNull
    public Collection<String> getInstitutions()
    {
        return institutions;
    }

    @NotNull
    public Collection<OrderPriority> getPriorities()
    {
        return priorities;
    }
    public void setStart(@NotNull Date start)
    {
        this.start = start;
    }

    public void setEnd(@NotNull Date end)
    {
        this.end = end;
    }

    public void setRadiologists(@NotNull Collection<String> radiologists)
    {
        this.radiologists = radiologists;
    }

    public void setInstitutions(@NotNull Collection<String> institutions)
    {
        this.institutions = institutions;
    }

    public void setPriorities(@NotNull Collection<OrderPriority> priorities)
    {
        this.priorities = priorities;
    }

    @NotNull
    public String toString()
    {
        return "OrderReportDataRequest(" +
            " start: " + getStart() +
            " end: " + getEnd() +
            " radiologists: " + getRadiologists() +
            " institutions: " + getInstitutions() +
            " priorities: " + getPriorities() + ")";
    }

    @NotNull
    public OrderReportDataRequestBuilder toBuilder()
    {
        return new OrderReportDataRequestBuilder(getStart(),
                                                 getEnd(),
                                                 getRadiologists(),
                                                 getInstitutions(),
                                                 getPriorities());
    }
}