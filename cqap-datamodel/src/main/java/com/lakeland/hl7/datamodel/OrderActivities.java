package com.lakeland.hl7.datamodel;

import org.codehaus.jackson.annotate.*;
import org.jetbrains.annotations.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;
import java.util.*;

public class OrderActivities implements HL7Visitable
{
    public static final byte TYPE = 20;
    @NotNull private Collection<? extends OrderActivity> activity;

    public OrderActivities()
    {
        // empty
    }

    @JsonCreator
    public OrderActivities(@NotNull Collection<? extends OrderActivity> activity)
    {
        super();

        this.activity = activity;
    }

    @NotNull
    public Collection<? extends OrderActivity> getActivity()
    {
        return activity;
    }
    public void setActivity(@NotNull Collection<? extends OrderActivity> activity)
    {
        this.activity = activity;
    }

    public void accept(@NotNull HL7Visitor aVisitor)
    {
        aVisitor.visit(this);
    }

    @NotNull
    public String toString()
    {
        return "OrderActivities(" +
            " activity: " + getActivity() + ")";
    }

    @NotNull
    public OrderActivitiesBuilder toBuilder()
    {
        return new OrderActivitiesBuilder(getActivity());
    }
}