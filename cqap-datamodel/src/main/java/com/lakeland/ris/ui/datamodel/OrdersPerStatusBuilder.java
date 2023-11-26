package com.lakeland.ris.ui.datamodel;

import org.jetbrains.annotations.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;
import java.util.*;

public class OrdersPerStatusBuilder
{
    @NotNull private Collection<StatusOrderCount> counts;

    public OrdersPerStatusBuilder(@NotNull Collection<StatusOrderCount> counts)
    {
        super();

        this.counts = counts;
    }


    @NotNull
    public OrdersPerStatusBuilder setCounts(@NotNull Collection<StatusOrderCount> counts)
    {
        this.counts = counts;

        return self();
    }

    @NotNull
    protected Collection<StatusOrderCount> getCounts()
    {
        return counts;
    }

    @NotNull
    public OrdersPerStatus build()
    {
        return new OrdersPerStatus(getCounts());
    }


    @NotNull
    protected OrdersPerStatusBuilder self()
    {
        return this;
    }
}