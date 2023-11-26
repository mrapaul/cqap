package com.lakeland.ris.ui.datamodel;

import org.jetbrains.annotations.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;


public class OrderChangeBuilder
{
    @NotNull private Date timestamp;
    @NotNull private String userId;
    @NotNull private OrderStatus status;

    public OrderChangeBuilder(@NotNull Date timestamp,
                              @NotNull String userId,
                              @NotNull OrderStatus status)
    {
        super();

        this.timestamp = timestamp;
        this.userId = userId;
        this.status = status;
    }


    @NotNull
    public OrderChangeBuilder setTimestamp(@NotNull Date timestamp)
    {
        this.timestamp = timestamp;

        return self();
    }

    @NotNull
    public OrderChangeBuilder setUserId(@NotNull String userId)
    {
        this.userId = userId;

        return self();
    }

    @NotNull
    public OrderChangeBuilder setStatus(@NotNull OrderStatus status)
    {
        this.status = status;

        return self();
    }

    @NotNull
    protected Date getTimestamp()
    {
        return timestamp;
    }

    @NotNull
    protected String getUserId()
    {
        return userId;
    }

    @NotNull
    protected OrderStatus getStatus()
    {
        return status;
    }

    @NotNull
    public OrderChange build()
    {
        return new OrderChange(getTimestamp(),
                               getUserId(),
                               getStatus());
    }


    @NotNull
    protected OrderChangeBuilder self()
    {
        return this;
    }
}