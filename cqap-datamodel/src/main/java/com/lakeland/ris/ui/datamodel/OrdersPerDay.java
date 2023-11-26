package com.lakeland.ris.ui.datamodel;

import org.codehaus.jackson.annotate.*;
import org.jetbrains.annotations.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;
import java.util.*;

public class OrdersPerDay
{
    @NotNull private Collection<DayOrderCount> counts;

    public OrdersPerDay()
    {
        // empty
    }

    @JsonCreator
    public OrdersPerDay(@NotNull Collection<DayOrderCount> counts)
    {
        super();

        this.counts = counts;
    }

    @NotNull
    public Collection<DayOrderCount> getCounts()
    {
        return counts;
    }
    public void setCounts(@NotNull Collection<DayOrderCount> counts)
    {
        this.counts = counts;
    }

    @NotNull
    public String toString()
    {
        return "OrdersPerDay(" +
            " counts: " + getCounts() + ")";
    }

    @NotNull
    public OrdersPerDayBuilder toBuilder()
    {
        return new OrdersPerDayBuilder(getCounts());
    }
}