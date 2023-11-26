package com.lakeland.hl7.datamodel;

import org.jetbrains.annotations.*;
import java.util.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;


public class OrderBidLocationBuilder extends OrderActivityBuilder<OrderBidLocation, OrderBidLocationBuilder>
{
    @NotNull private String location;
    private int orderCount;

    public OrderBidLocationBuilder(@NotNull Date timestamp,
                                   @NotNull String orderId,
                                   @NotNull String userId,
                                   @NotNull String location)
    {
        super(timestamp,
              orderId,
              userId);

        this.location = location;
    }


    @NotNull
    @Override
    public OrderBidLocationBuilder setTimestamp(@NotNull Date timestamp)
    {
        super.setTimestamp(timestamp);

        return self();
    }

    @NotNull
    @Override
    public OrderBidLocationBuilder setOrderId(@NotNull String orderId)
    {
        super.setOrderId(orderId);

        return self();
    }

    @NotNull
    @Override
    public OrderBidLocationBuilder setUserId(@NotNull String userId)
    {
        super.setUserId(userId);

        return self();
    }

    @NotNull
    public OrderBidLocationBuilder setLocation(@NotNull String location)
    {
        this.location = location;

        return self();
    }

    @NotNull
    public OrderBidLocationBuilder setOrderCount(int orderCount)
    {
        this.orderCount = orderCount;

        return self();
    }

    @NotNull
    protected String getLocation()
    {
        return location;
    }

    protected int getOrderCount()
    {
        return orderCount;
    }

    @Override
    @NotNull
    public OrderBidLocation build()
    {
        return new OrderBidLocation(getTimestamp(),
                                    getOrderId(),
                                    getUserId(),
                                    getLocation(),
                                    getOrderCount());
    }


    @Override
    @NotNull
    protected OrderBidLocationBuilder self()
    {
        return this;
    }
}