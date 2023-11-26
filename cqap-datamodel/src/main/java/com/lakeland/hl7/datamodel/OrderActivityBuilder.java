package com.lakeland.hl7.datamodel;

import org.jetbrains.annotations.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;


public abstract class OrderActivityBuilder<M, B extends OrderActivityBuilder<M, B>> extends TimedMessageBuilder<M, B> 
{
    @NotNull private String orderId;
    @NotNull private String userId;

    public OrderActivityBuilder(@NotNull Date timestamp,
                                @NotNull String orderId,
                                @NotNull String userId)
    {
        super(timestamp);

        this.orderId = orderId;
        this.userId = userId;
    }


    @NotNull
    public B setOrderId(@NotNull String orderId)
    {
        this.orderId = orderId;

        return self();
    }

    @NotNull
    public B setUserId(@NotNull String userId)
    {
        this.userId = userId;

        return self();
    }

    @NotNull
    protected String getOrderId()
    {
        return orderId;
    }

    @NotNull
    protected String getUserId()
    {
        return userId;
    }

    @NotNull
    public abstract M build();


    @Override
    @NotNull
    protected B self()
    {
        return (B) this;
    }
}