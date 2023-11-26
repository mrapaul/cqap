package com.lakeland.ris.ui.datamodel;

import org.codehaus.jackson.annotate.*;
import org.jetbrains.annotations.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;
import java.util.*;

public class OrdersPerStatus
{
    @NotNull private Collection<StatusOrderCount> counts;

    public OrdersPerStatus()
    {
        // empty
    }

    @JsonCreator
    public OrdersPerStatus(@NotNull Collection<StatusOrderCount> counts)
    {
        super();

        this.counts = counts;
    }

    @NotNull
    public Collection<StatusOrderCount> getCounts()
    {
        return counts;
    }
    public void setCounts(@NotNull Collection<StatusOrderCount> counts)
    {
        this.counts = counts;
    }

    @NotNull
    public String toString()
    {
        return "OrdersPerStatus(" +
            " counts: " + getCounts() + ")";
    }

    @NotNull
    public OrdersPerStatusBuilder toBuilder()
    {
        return new OrdersPerStatusBuilder(getCounts());
    }
}