package com.lakeland.hl7.datamodel;


import java.util.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;
import java.util.*;

public class DeleteOrdersBuilder extends OrderActivityBuilder<DeleteOrders, DeleteOrdersBuilder>
{
    private Collection<String> orders;

    public DeleteOrdersBuilder(Date timestamp,
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
    public DeleteOrdersBuilder setTimestamp(Date timestamp)
    {
        super.setTimestamp(timestamp);

        return self();
    }

    
    @Override
    public DeleteOrdersBuilder setOrderId(String orderId)
    {
        super.setOrderId(orderId);

        return self();
    }

    
    @Override
    public DeleteOrdersBuilder setUserId(String userId)
    {
        super.setUserId(userId);

        return self();
    }

    
    public DeleteOrdersBuilder setOrders(Collection<String> orders)
    {
        this.orders = orders;

        return self();
    }

    
    protected Collection<String> getOrders()
    {
        return orders;
    }

    @Override
    
    public DeleteOrders build()
    {
        return new DeleteOrders(getTimestamp(),
                                getOrderId(),
                                getUserId(),
                                getOrders());
    }


    @Override
    
    protected DeleteOrdersBuilder self()
    {
        return this;
    }
}