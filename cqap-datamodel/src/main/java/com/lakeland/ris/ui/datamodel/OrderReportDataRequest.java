package com.lakeland.ris.ui.datamodel;

import org.codehaus.jackson.annotate.*;

import java.util.*;
import com.lakeland.ris.datamodel.*;
import java.util.*;

public class OrderReportDataRequest
{
    private Date start;
    private Date end;
    private Collection<String> radiologists;
    private Collection<String> institutions;
    private Collection<OrderPriority> priorities;

    public OrderReportDataRequest()
    {
        // empty
    }

    @JsonCreator
    public OrderReportDataRequest(Date start,
                                  Date end,
                                  Collection<String> radiologists,
                                  Collection<String> institutions,
                                  Collection<OrderPriority> priorities)
    {
        super();

        this.start = start;
        this.end = end;
        this.radiologists = radiologists;
        this.institutions = institutions;
        this.priorities = priorities;
    }

    
    public Date getStart()
    {
        return start;
    }

    
    public Date getEnd()
    {
        return end;
    }

    
    public Collection<String> getRadiologists()
    {
        return radiologists;
    }

    
    public Collection<String> getInstitutions()
    {
        return institutions;
    }

    
    public Collection<OrderPriority> getPriorities()
    {
        return priorities;
    }
    public void setStart(Date start)
    {
        this.start = start;
    }

    public void setEnd(Date end)
    {
        this.end = end;
    }

    public void setRadiologists(Collection<String> radiologists)
    {
        this.radiologists = radiologists;
    }

    public void setInstitutions(Collection<String> institutions)
    {
        this.institutions = institutions;
    }

    public void setPriorities(Collection<OrderPriority> priorities)
    {
        this.priorities = priorities;
    }

    
    public String toString()
    {
        return "OrderReportDataRequest(" +
            " start: " + getStart() +
            " end: " + getEnd() +
            " radiologists: " + getRadiologists() +
            " institutions: " + getInstitutions() +
            " priorities: " + getPriorities() + ")";
    }

    
    public OrderReportDataRequestBuilder toBuilder()
    {
        return new OrderReportDataRequestBuilder(getStart(),
                                                 getEnd(),
                                                 getRadiologists(),
                                                 getInstitutions(),
                                                 getPriorities());
    }
}