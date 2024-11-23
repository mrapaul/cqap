package com.lakeland.hl7.datamodel;

import org.codehaus.jackson.annotate.*;

import java.util.*;
import com.lakeland.ris.datamodel.*;
import java.util.*;

public class OrderActivities implements HL7Visitable
{
    public static final byte TYPE = 20;
    private Collection<? extends OrderActivity> activity;

    public OrderActivities()
    {
        // empty
    }

    @JsonCreator
    public OrderActivities(Collection<? extends OrderActivity> activity)
    {
        super();

        this.activity = activity;
    }


    public Collection<? extends OrderActivity> getActivity()
    {
        return activity;
    }
    public void setActivity(Collection<? extends OrderActivity> activity)
    {
        this.activity = activity;
    }

    public void accept(HL7Visitor aVisitor)
    {
        aVisitor.visit(this);
    }


    public String toString()
    {
        return "OrderActivities(" +
            " activity: " + getActivity() + ")";
    }


    public OrderActivitiesBuilder toBuilder()
    {
        return new OrderActivitiesBuilder(getActivity());
    }
}