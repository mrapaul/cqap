package com.lakeland.hl7.datamodel;

import org.jetbrains.annotations.*;
import java.util.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;


public class OrderBidRejectedBuilder extends OrderActivityBuilder<OrderBidRejected, OrderBidRejectedBuilder>
{

    public OrderBidRejectedBuilder(@NotNull Date timestamp,
                                   @NotNull String orderId,
                                   @NotNull String userId)
    {
        super(timestamp,
              orderId,
              userId);

    }


    @NotNull
    @Override
    public OrderBidRejectedBuilder setTimestamp(@NotNull Date timestamp)
    {
        super.setTimestamp(timestamp);

        return self();
    }

    @NotNull
    @Override
    public OrderBidRejectedBuilder setOrderId(@NotNull String orderId)
    {
        super.setOrderId(orderId);

        return self();
    }

    @NotNull
    @Override
    public OrderBidRejectedBuilder setUserId(@NotNull String userId)
    {
        super.setUserId(userId);

        return self();
    }



    @Override
    @NotNull
    public OrderBidRejected build()
    {
        return new OrderBidRejected(getTimestamp(),
                                    getOrderId(),
                                    getUserId());
    }


    @Override
    @NotNull
    protected OrderBidRejectedBuilder self()
    {
        return this;
    }
}