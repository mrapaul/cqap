package com.lakeland.hl7.datamodel;


import java.util.*;
import com.lakeland.ris.datamodel.*;
import java.util.*;

public class OrderActivitiesBuilder
{
    private Collection<? extends OrderActivity> activity;

    public OrderActivitiesBuilder(Collection<? extends OrderActivity> activity)
    {
        super();

        this.activity = activity;
    }


    
    public OrderActivitiesBuilder setActivity(Collection<? extends OrderActivity> activity)
    {
        this.activity = activity;

        return self();
    }

    
    protected Collection<? extends OrderActivity> getActivity()
    {
        return activity;
    }

    
    public OrderActivities build()
    {
        return new OrderActivities(getActivity());
    }


    
    protected OrderActivitiesBuilder self()
    {
        return this;
    }
}