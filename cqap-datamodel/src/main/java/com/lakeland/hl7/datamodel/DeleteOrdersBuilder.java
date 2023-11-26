package com.lakeland.hl7.datamodel;

import org.jetbrains.annotations.*;
import java.util.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;
import java.util.*;

public class DeleteOrdersBuilder extends OrderActivityBuilder<DeleteOrders, DeleteOrdersBuilder>
{
    @NotNull private Collection<String> orders;

    public DeleteOrdersBuilder(@NotNull Date timestamp,
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
    public DeleteOrdersBuilder setTimestamp(@NotNull Date timestamp)
    {
        super.setTimestamp(timestamp);

        return self();
    }

    @NotNull
    @Override
    public DeleteOrdersBuilder setOrderId(@NotNull String orderId)
    {
        super.setOrderId(orderId);

        return self();
    }

    @NotNull
    @Override
    public DeleteOrdersBuilder setUserId(@NotNull String userId)
    {
        super.setUserId(userId);

        return self();
    }

    @NotNull
    public DeleteOrdersBuilder setOrders(@NotNull Collection<String> orders)
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
    public DeleteOrders build()
    {
        return new DeleteOrders(getTimestamp(),
                                getOrderId(),
                                getUserId(),
                                getOrders());
    }


    @Override
    @NotNull
    protected DeleteOrdersBuilder self()
    {
        return this;
    }
}