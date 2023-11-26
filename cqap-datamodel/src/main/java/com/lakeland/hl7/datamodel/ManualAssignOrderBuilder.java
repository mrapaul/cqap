package com.lakeland.hl7.datamodel;

import org.jetbrains.annotations.*;
import java.util.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;
import java.util.*;

public class ManualAssignOrderBuilder extends OrderActivityBuilder<ManualAssignOrder, ManualAssignOrderBuilder>
{
    @NotNull private Collection<String> orders;
    @NotNull private String assignUserId;

    public ManualAssignOrderBuilder(@NotNull Date timestamp,
                                    @NotNull String orderId,
                                    @NotNull String userId,
                                    @NotNull Collection<String> orders,
                                    @NotNull String assignUserId)
    {
        super(timestamp,
              orderId,
              userId);

        this.orders = orders;
        this.assignUserId = assignUserId;
    }


    @NotNull
    @Override
    public ManualAssignOrderBuilder setTimestamp(@NotNull Date timestamp)
    {
        super.setTimestamp(timestamp);

        return self();
    }

    @NotNull
    @Override
    public ManualAssignOrderBuilder setOrderId(@NotNull String orderId)
    {
        super.setOrderId(orderId);

        return self();
    }

    @NotNull
    @Override
    public ManualAssignOrderBuilder setUserId(@NotNull String userId)
    {
        super.setUserId(userId);

        return self();
    }

    @NotNull
    public ManualAssignOrderBuilder setOrders(@NotNull Collection<String> orders)
    {
        this.orders = orders;

        return self();
    }

    @NotNull
    public ManualAssignOrderBuilder setAssignUserId(@NotNull String assignUserId)
    {
        this.assignUserId = assignUserId;

        return self();
    }

    @NotNull
    protected Collection<String> getOrders()
    {
        return orders;
    }

    @NotNull
    protected String getAssignUserId()
    {
        return assignUserId;
    }

    @Override
    @NotNull
    public ManualAssignOrder build()
    {
        return new ManualAssignOrder(getTimestamp(),
                                     getOrderId(),
                                     getUserId(),
                                     getOrders(),
                                     getAssignUserId());
    }


    @Override
    @NotNull
    protected ManualAssignOrderBuilder self()
    {
        return this;
    }
}