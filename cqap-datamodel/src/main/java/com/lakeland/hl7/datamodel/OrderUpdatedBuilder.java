package com.lakeland.hl7.datamodel;

import org.jetbrains.annotations.*;
import java.util.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;


public class OrderUpdatedBuilder extends OrderActivityBuilder<OrderUpdated, OrderUpdatedBuilder>
{

    public OrderUpdatedBuilder(@NotNull Date timestamp,
                               @NotNull String orderId,
                               @NotNull String userId)
    {
        super(timestamp,
              orderId,
              userId);

    }


    @NotNull
    @Override
    public OrderUpdatedBuilder setTimestamp(@NotNull Date timestamp)
    {
        super.setTimestamp(timestamp);

        return self();
    }

    @NotNull
    @Override
    public OrderUpdatedBuilder setOrderId(@NotNull String orderId)
    {
        super.setOrderId(orderId);

        return self();
    }

    @NotNull
    @Override
    public OrderUpdatedBuilder setUserId(@NotNull String userId)
    {
        super.setUserId(userId);

        return self();
    }



    @Override
    @NotNull
    public OrderUpdated build()
    {
        return new OrderUpdated(getTimestamp(),
                                getOrderId(),
                                getUserId());
    }


    @Override
    @NotNull
    protected OrderUpdatedBuilder self()
    {
        return this;
    }
}