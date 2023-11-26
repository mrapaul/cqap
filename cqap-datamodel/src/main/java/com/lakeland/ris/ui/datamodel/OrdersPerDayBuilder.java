package com.lakeland.ris.ui.datamodel;

import org.jetbrains.annotations.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;
import java.util.*;

public class OrdersPerDayBuilder
{
    @NotNull private Collection<DayOrderCount> counts;

    public OrdersPerDayBuilder(@NotNull Collection<DayOrderCount> counts)
    {
        super();

        this.counts = counts;
    }


    @NotNull
    public OrdersPerDayBuilder setCounts(@NotNull Collection<DayOrderCount> counts)
    {
        this.counts = counts;

        return self();
    }

    @NotNull
    protected Collection<DayOrderCount> getCounts()
    {
        return counts;
    }

    @NotNull
    public OrdersPerDay build()
    {
        return new OrdersPerDay(getCounts());
    }


    @NotNull
    protected OrdersPerDayBuilder self()
    {
        return this;
    }
}