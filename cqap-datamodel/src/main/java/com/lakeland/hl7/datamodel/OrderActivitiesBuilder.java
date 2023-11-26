package com.lakeland.hl7.datamodel;

import org.jetbrains.annotations.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;
import java.util.*;

public class OrderActivitiesBuilder
{
    @NotNull private Collection<? extends OrderActivity> activity;

    public OrderActivitiesBuilder(@NotNull Collection<? extends OrderActivity> activity)
    {
        super();

        this.activity = activity;
    }


    @NotNull
    public OrderActivitiesBuilder setActivity(@NotNull Collection<? extends OrderActivity> activity)
    {
        this.activity = activity;

        return self();
    }

    @NotNull
    protected Collection<? extends OrderActivity> getActivity()
    {
        return activity;
    }

    @NotNull
    public OrderActivities build()
    {
        return new OrderActivities(getActivity());
    }


    @NotNull
    protected OrderActivitiesBuilder self()
    {
        return this;
    }
}