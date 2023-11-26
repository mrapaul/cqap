package com.lakeland.hl7.datamodel;

import org.jetbrains.annotations.*;
import java.util.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;


public class OrderBidConfirmBuilder extends OrderActivityBuilder<OrderBidConfirm, OrderBidConfirmBuilder>
{

    public OrderBidConfirmBuilder(@NotNull Date timestamp,
                                  @NotNull String orderId,
                                  @NotNull String userId)
    {
        super(timestamp,
              orderId,
              userId);

    }


    @NotNull
    @Override
    public OrderBidConfirmBuilder setTimestamp(@NotNull Date timestamp)
    {
        super.setTimestamp(timestamp);

        return self();
    }

    @NotNull
    @Override
    public OrderBidConfirmBuilder setOrderId(@NotNull String orderId)
    {
        super.setOrderId(orderId);

        return self();
    }

    @NotNull
    @Override
    public OrderBidConfirmBuilder setUserId(@NotNull String userId)
    {
        super.setUserId(userId);

        return self();
    }



    @Override
    @NotNull
    public OrderBidConfirm build()
    {
        return new OrderBidConfirm(getTimestamp(),
                                   getOrderId(),
                                   getUserId());
    }


    @Override
    @NotNull
    protected OrderBidConfirmBuilder self()
    {
        return this;
    }
}