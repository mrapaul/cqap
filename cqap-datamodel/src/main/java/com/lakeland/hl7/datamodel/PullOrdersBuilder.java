package com.lakeland.hl7.datamodel;

import org.jetbrains.annotations.*;
import java.util.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;
import java.util.*;

public class PullOrdersBuilder extends OrderActivityBuilder<PullOrders, PullOrdersBuilder>
{
    @NotNull private Collection<String> orders;

    public PullOrdersBuilder(@NotNull Date timestamp,
                             @NotNull String orderId,
                             @NotNull String userId,
                             @NotNull Collection<String> orders)
    {
        super(timestamp,
              orderId,
              userId);

        this.orders = orders;
    }


    @NotNull
    @Override
    public PullOrdersBuilder setTimestamp(@NotNull Date timestamp)
    {
        super.setTimestamp(timestamp);

        return self();
    }

    @NotNull
    @Override
    public PullOrdersBuilder setOrderId(@NotNull String orderId)
    {
        super.setOrderId(orderId);

        return self();
    }

    @NotNull
    @Override
    public PullOrdersBuilder setUserId(@NotNull String userId)
    {
        super.setUserId(userId);

        return self();
    }

    @NotNull
    public PullOrdersBuilder setOrders(@NotNull Collection<String> orders)
    {
        this.orders = orders;

        return self();
    }

    @NotNull
    protected Collection<String> getOrders()
    {
        return orders;
    }

    @Override
    @NotNull
    public PullOrders build()
    {
        return new PullOrders(getTimestamp(),
                              getOrderId(),
                              getUserId(),
                              getOrders());
    }


    @Override
    @NotNull
    protected PullOrdersBuilder self()
    {
        return this;
    }
}