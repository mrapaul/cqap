package com.lakeland.ris.ui.datamodel;


import java.util.*;
import com.lakeland.ris.datamodel.*;
import java.util.*;

public class OrderReportDataRequestBuilder
{
    private Date start;
    private Date end;
    private Collection<String> radiologists;
    private Collection<String> institutions;
    private Collection<OrderPriority> priorities;

    public OrderReportDataRequestBuilder(Date start,
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


    
    public OrderReportDataRequestBuilder setStart(Date start)
    {
        this.start = start;

        return self();
    }

    
    public OrderReportDataRequestBuilder setEnd(Date end)
    {
        this.end = end;

        return self();
    }

    
    public OrderReportDataRequestBuilder setRadiologists(Collection<String> radiologists)
    {
        this.radiologists = radiologists;

        return self();
    }

    
    public OrderReportDataRequestBuilder setInstitutions(Collection<String> institutions)
    {
        this.institutions = institutions;

        return self();
    }

    
    public OrderReportDataRequestBuilder setPriorities(Collection<OrderPriority> priorities)
    {
        this.priorities = priorities;

        return self();
    }

    
    protected Date getStart()
    {
        return start;
    }

    
    protected Date getEnd()
    {
        return end;
    }

    
    protected Collection<String> getRadiologists()
    {
        return radiologists;
    }

    
    protected Collection<String> getInstitutions()
    {
        return institutions;
    }

    
    protected Collection<OrderPriority> getPriorities()
    {
        return priorities;
    }

    
    public OrderReportDataRequest build()
    {
        return new OrderReportDataRequest(getStart(),
                                          getEnd(),
                                          getRadiologists(),
                                          getInstitutions(),
                                          getPriorities());
    }


    
    protected OrderReportDataRequestBuilder self()
    {
        return this;
    }
}