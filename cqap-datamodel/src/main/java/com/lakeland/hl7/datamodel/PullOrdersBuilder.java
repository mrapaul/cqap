package com.lakeland.hl7.datamodel;


import java.util.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;
import java.util.*;

public class PullOrdersBuilder extends OrderActivityBuilder<PullOrders, PullOrdersBuilder>
{
    private Collection<String> orders;

    public PullOrdersBuilder(Date timestamp,
                             String orderId,
                             String userId,
                             Collection<String> orders)
    {
        super(timestamp,
              orderId,
              userId);

        this.orders = orders;
    }


    
    @Override
    public PullOrdersBuilder setTimestamp(Date timestamp)
    {
        super.setTimestamp(timestamp);

        return self();
    }

    
    @Override
    public PullOrdersBuilder setOrderId(String orderId)
    {
        super.setOrderId(orderId);

        return self();
    }

    
    @Override
    public PullOrdersBuilder setUserId(String userId)
    {
        super.setUserId(userId);

        return self();
    }

    
    public PullOrdersBuilder setOrders(Collection<String> orders)
    {
        this.orders = orders;

        return self();
    }

    
    protected Collection<String> getOrders()
    {
        return orders;
    }

    @Override
    
    public PullOrders build()
    {
        return new PullOrders(getTimestamp(),
                              getOrderId(),
                              getUserId(),
                              getOrders());
    }


    @Override
    
    protected PullOrdersBuilder self()
    {
        return this;
    }
}