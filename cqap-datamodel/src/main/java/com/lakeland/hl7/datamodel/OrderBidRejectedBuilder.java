package com.lakeland.hl7.datamodel;


import java.util.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;


public class OrderBidRejectedBuilder extends OrderActivityBuilder<OrderBidRejected, OrderBidRejectedBuilder>
{

    public OrderBidRejectedBuilder(Date timestamp,
                                   String orderId,
                                   String userId)
    {
        super(timestamp,
              orderId,
              userId);

    }



    @Override
    public OrderBidRejectedBuilder setTimestamp(Date timestamp)
    {
        super.setTimestamp(timestamp);

        return self();
    }


    @Override
    public OrderBidRejectedBuilder setOrderId(String orderId)
    {
        super.setOrderId(orderId);

        return self();
    }


    @Override
    public OrderBidRejectedBuilder setUserId(String userId)
    {
        super.setUserId(userId);

        return self();
    }



    @Override

    public OrderBidRejected build()
    {
        return new OrderBidRejected(getTimestamp(),
                                    getOrderId(),
                                    getUserId());
    }


    @Override

    protected OrderBidRejectedBuilder self()
    {
        return this;
    }
}