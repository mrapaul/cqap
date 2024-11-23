package com.lakeland.ris.ui.datamodel;


import java.util.*;
import com.lakeland.ris.datamodel.*;
import java.util.*;

public class DisplayOrdersBuilder
{
    private Collection<DisplayOrder> orders;

    public DisplayOrdersBuilder(Collection<DisplayOrder> orders)
    {
        super();

        this.orders = orders;
    }


    
    public DisplayOrdersBuilder setOrders(Collection<DisplayOrder> orders)
    {
        this.orders = orders;

        return self();
    }

    
    protected Collection<DisplayOrder> getOrders()
    {
        return orders;
    }

    
    public DisplayOrders build()
    {
        return new DisplayOrders(getOrders());
    }


    
    protected DisplayOrdersBuilder self()
    {
        return this;
    }
}