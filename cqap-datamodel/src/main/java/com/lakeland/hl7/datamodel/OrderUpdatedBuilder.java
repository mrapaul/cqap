package com.lakeland.hl7.datamodel;


import java.util.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;


public class OrderUpdatedBuilder extends OrderActivityBuilder<OrderUpdated, OrderUpdatedBuilder>
{

    public OrderUpdatedBuilder(Date timestamp,
                               String orderId,
                               String userId)
    {
        super(timestamp,
              orderId,
              userId);

    }



    @Override
    public OrderUpdatedBuilder setTimestamp(Date timestamp)
    {
        super.setTimestamp(timestamp);

        return self();
    }


    @Override
    public OrderUpdatedBuilder setOrderId(String orderId)
    {
        super.setOrderId(orderId);

        return self();
    }


    @Override
    public OrderUpdatedBuilder setUserId(String userId)
    {
        super.setUserId(userId);

        return self();
    }



    @Override

    public OrderUpdated build()
    {
        return new OrderUpdated(getTimestamp(),
                                getOrderId(),
                                getUserId());
    }


    @Override

    protected OrderUpdatedBuilder self()
    {
        return this;
    }
}