package com.lakeland.ris.ui.datamodel;

import org.codehaus.jackson.annotate.*;

import java.util.*;
import com.lakeland.ris.datamodel.*;
import java.util.*;

public class OrdersPerDay
{
    private Collection<DayOrderCount> counts;

    public OrdersPerDay()
    {
        // empty
    }

    @JsonCreator
    public OrdersPerDay(Collection<DayOrderCount> counts)
    {
        super();

        this.counts = counts;
    }

    
    public Collection<DayOrderCount> getCounts()
    {
        return counts;
    }
    public void setCounts(Collection<DayOrderCount> counts)
    {
        this.counts = counts;
    }

    
    public String toString()
    {
        return "OrdersPerDay(" +
            " counts: " + getCounts() + ")";
    }

    
    public OrdersPerDayBuilder toBuilder()
    {
        return new OrdersPerDayBuilder(getCounts());
    }
}