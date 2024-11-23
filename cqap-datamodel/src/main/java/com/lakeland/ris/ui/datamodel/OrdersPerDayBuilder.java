package com.lakeland.ris.ui.datamodel;


import java.util.*;
import com.lakeland.ris.datamodel.*;
import java.util.*;

public class OrdersPerDayBuilder
{
    private Collection<DayOrderCount> counts;

    public OrdersPerDayBuilder(Collection<DayOrderCount> counts)
    {
        super();

        this.counts = counts;
    }



    public OrdersPerDayBuilder setCounts(Collection<DayOrderCount> counts)
    {
        this.counts = counts;

        return self();
    }


    protected Collection<DayOrderCount> getCounts()
    {
        return counts;
    }


    public OrdersPerDay build()
    {
        return new OrdersPerDay(getCounts());
    }



    protected OrdersPerDayBuilder self()
    {
        return this;
    }
}