package com.lakeland.hl7.datamodel;


import java.util.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;


public class OrderBidTeleradBuilder extends OrderActivityBuilder<OrderBidTelerad, OrderBidTeleradBuilder>
{
    private int orderCount;

    public OrderBidTeleradBuilder(Date timestamp,
                                  String orderId,
                                  String userId)
    {
        super(timestamp,
              orderId,
              userId);

    }


    
    @Override
    public OrderBidTeleradBuilder setTimestamp(Date timestamp)
    {
        super.setTimestamp(timestamp);

        return self();
    }

    
    @Override
    public OrderBidTeleradBuilder setOrderId(String orderId)
    {
        super.setOrderId(orderId);

        return self();
    }

    
    @Override
    public OrderBidTeleradBuilder setUserId(String userId)
    {
        super.setUserId(userId);

        return self();
    }

    
    public OrderBidTeleradBuilder setOrderCount(int orderCount)
    {
        this.orderCount = orderCount;

        return self();
    }

    protected int getOrderCount()
    {
        return orderCount;
    }

    @Override
    
    public OrderBidTelerad build()
    {
        return new OrderBidTelerad(getTimestamp(),
                                   getOrderId(),
                                   getUserId(),
                                   getOrderCount());
    }


    @Override
    
    protected OrderBidTeleradBuilder self()
    {
        return this;
    }
}