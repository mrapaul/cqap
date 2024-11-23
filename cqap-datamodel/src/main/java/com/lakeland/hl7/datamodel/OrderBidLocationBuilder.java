package com.lakeland.hl7.datamodel;


import java.util.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;


public class OrderBidLocationBuilder extends OrderActivityBuilder<OrderBidLocation, OrderBidLocationBuilder>
{
    private String location;
    private int orderCount;

    public OrderBidLocationBuilder(Date timestamp,
                                   String orderId,
                                   String userId,
                                   String location)
    {
        super(timestamp,
              orderId,
              userId);

        this.location = location;
    }



    @Override
    public OrderBidLocationBuilder setTimestamp(Date timestamp)
    {
        super.setTimestamp(timestamp);

        return self();
    }


    @Override
    public OrderBidLocationBuilder setOrderId(String orderId)
    {
        super.setOrderId(orderId);

        return self();
    }


    @Override
    public OrderBidLocationBuilder setUserId(String userId)
    {
        super.setUserId(userId);

        return self();
    }


    public OrderBidLocationBuilder setLocation(String location)
    {
        this.location = location;

        return self();
    }


    public OrderBidLocationBuilder setOrderCount(int orderCount)
    {
        this.orderCount = orderCount;

        return self();
    }


    protected String getLocation()
    {
        return location;
    }

    protected int getOrderCount()
    {
        return orderCount;
    }

    @Override

    public OrderBidLocation build()
    {
        return new OrderBidLocation(getTimestamp(),
                                    getOrderId(),
                                    getUserId(),
                                    getLocation(),
                                    getOrderCount());
    }


    @Override

    protected OrderBidLocationBuilder self()
    {
        return this;
    }
}