package com.lakeland.ris.ui.datamodel;

import org.jetbrains.annotations.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;


public class OrderTagBuilder
{
    @NotNull private Date timestamp;
    @NotNull private String orderId;
    @NotNull private String userId;
    @NotNull private String tag;
    private boolean userPrivate;

    public OrderTagBuilder(@NotNull Date timestamp,
                           @NotNull String orderId,
                           @NotNull String userId,
                           @NotNull String tag)
    {
        super();

        this.timestamp = timestamp;
        this.orderId = orderId;
        this.userId = userId;
        this.tag = tag;
    }


    @NotNull
    public OrderTagBuilder setTimestamp(@NotNull Date timestamp)
    {
        this.timestamp = timestamp;

        return self();
    }

    @NotNull
    public OrderTagBuilder setOrderId(@NotNull String orderId)
    {
        this.orderId = orderId;

        return self();
    }

    @NotNull
    public OrderTagBuilder setUserId(@NotNull String userId)
    {
        this.userId = userId;

        return self();
    }

    @NotNull
    public OrderTagBuilder setTag(@NotNull String tag)
    {
        this.tag = tag;

        return self();
    }

    @NotNull
    public OrderTagBuilder setUserPrivate(boolean userPrivate)
    {
        this.userPrivate = userPrivate;

        return self();
    }

    @NotNull
    protected Date getTimestamp()
    {
        return timestamp;
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
    protected String getTag()
    {
        return tag;
    }

    protected boolean isUserPrivate()
    {
        return userPrivate;
    }

    @NotNull
    public OrderTag build()
    {
        return new OrderTag(getTimestamp(),
                            getOrderId(),
                            getUserId(),
                            getTag(),
                            isUserPrivate());
    }


    @NotNull
    protected OrderTagBuilder self()
    {
        return this;
    }
}