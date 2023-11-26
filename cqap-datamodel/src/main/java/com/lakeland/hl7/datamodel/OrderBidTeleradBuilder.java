package com.lakeland.hl7.datamodel;

import org.jetbrains.annotations.*;
import java.util.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;


public class OrderBidTeleradBuilder extends OrderActivityBuilder<OrderBidTelerad, OrderBidTeleradBuilder>
{
    private int orderCount;

    public OrderBidTeleradBuilder(@NotNull Date timestamp,
                                  @NotNull String orderId,
                                  @NotNull String userId)
    {
        super(timestamp,
              orderId,
              userId);

    }


    @NotNull
    @Override
    public OrderBidTeleradBuilder setTimestamp(@NotNull Date timestamp)
    {
        super.setTimestamp(timestamp);

        return self();
    }

    @NotNull
    @Override
    public OrderBidTeleradBuilder setOrderId(@NotNull String orderId)
    {
        super.setOrderId(orderId);

        return self();
    }

    @NotNull
    @Override
    public OrderBidTeleradBuilder setUserId(@NotNull String userId)
    {
        super.setUserId(userId);

        return self();
    }

    @NotNull
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
    @NotNull
    public OrderBidTelerad build()
    {
        return new OrderBidTelerad(getTimestamp(),
                                   getOrderId(),
                                   getUserId(),
                                   getOrderCount());
    }


    @Override
    @NotNull
    protected OrderBidTeleradBuilder self()
    {
        return this;
    }
}