package com.lakeland.ris.ui.datamodel;


import java.util.*;
import com.lakeland.ris.datamodel.*;
import java.util.*;

public class OrdersPerUserBuilder
{
    private Collection<UserOrderCount> counts;

    public OrdersPerUserBuilder(Collection<UserOrderCount> counts)
    {
        super();

        this.counts = counts;
    }


    
    public OrdersPerUserBuilder setCounts(Collection<UserOrderCount> counts)
    {
        this.counts = counts;

        return self();
    }

    
    protected Collection<UserOrderCount> getCounts()
    {
        return counts;
    }

    
    public OrdersPerUser build()
    {
        return new OrdersPerUser(getCounts());
    }


    
    protected OrdersPerUserBuilder self()
    {
        return this;
    }
}