package com.lakeland.ris.ui.datamodel;


import java.util.*;
import com.lakeland.ris.datamodel.*;
import java.util.*;

public class OrdersPerStatusBuilder
{
    private Collection<StatusOrderCount> counts;

    public OrdersPerStatusBuilder(Collection<StatusOrderCount> counts)
    {
        super();

        this.counts = counts;
    }



    public OrdersPerStatusBuilder setCounts(Collection<StatusOrderCount> counts)
    {
        this.counts = counts;

        return self();
    }


    protected Collection<StatusOrderCount> getCounts()
    {
        return counts;
    }


    public OrdersPerStatus build()
    {
        return new OrdersPerStatus(getCounts());
    }



    protected OrdersPerStatusBuilder self()
    {
        return this;
    }
}