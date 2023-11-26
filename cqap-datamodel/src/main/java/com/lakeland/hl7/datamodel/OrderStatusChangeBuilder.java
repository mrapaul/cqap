package com.lakeland.hl7.datamodel;

import org.jetbrains.annotations.*;
import java.util.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;


public class OrderStatusChangeBuilder extends OrderActivityBuilder<OrderStatusChange, OrderStatusChangeBuilder>
{
    @NotNull private OrderStatus status;
    @Nullable private String assignedTo;

    public OrderStatusChangeBuilder(@NotNull Date timestamp,
                                    @NotNull String orderId,
                                    @NotNull String userId,
                                    @NotNull OrderStatus status)
    {
        super(timestamp,
              orderId,
              userId);

        this.status = status;
    }


    @NotNull
    @Override
    public OrderStatusChangeBuilder setTimestamp(@NotNull Date timestamp)
    {
        super.setTimestamp(timestamp);

        return self();
    }

    @NotNull
    @Override
    public OrderStatusChangeBuilder setOrderId(@NotNull String orderId)
    {
        super.setOrderId(orderId);

        return self();
    }

    @NotNull
    @Override
    public OrderStatusChangeBuilder setUserId(@NotNull String userId)
    {
        super.setUserId(userId);

        return self();
    }

    @NotNull
    public OrderStatusChangeBuilder setStatus(@NotNull OrderStatus status)
    {
        this.status = status;

        return self();
    }

    @NotNull
    public OrderStatusChangeBuilder setAssignedTo(@Nullable String assignedTo)
    {
        this.assignedTo = assignedTo;

        return self();
    }

    @NotNull
    protected OrderStatus getStatus()
    {
        return status;
    }

    @Nullable
    protected String getAssignedTo()
    {
        return assignedTo;
    }

    @Override
    @NotNull
    public OrderStatusChange build()
    {
        return new OrderStatusChange(getTimestamp(),
                                     getOrderId(),
                                     getUserId(),
                                     getStatus(),
                                     getAssignedTo());
    }


    @Override
    @NotNull
    protected OrderStatusChangeBuilder self()
    {
        return this;
    }
}