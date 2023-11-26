package com.lakeland.ris.ui.datamodel;

import org.codehaus.jackson.annotate.*;
import org.jetbrains.annotations.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;


public class OrderChange
{
    @NotNull private Date timestamp;
    @NotNull private String userId;
    @NotNull private OrderStatus status;

    public OrderChange()
    {
        // empty
    }

    @JsonCreator
    public OrderChange(@NotNull Date timestamp,
                       @NotNull String userId,
                       @NotNull OrderStatus status)
    {
        super();

        this.timestamp = timestamp;
        this.userId = userId;
        this.status = status;
    }

    @NotNull
    public Date getTimestamp()
    {
        return timestamp;
    }

    @NotNull
    public String getUserId()
    {
        return userId;
    }

    @NotNull
    public OrderStatus getStatus()
    {
        return status;
    }
    public void setTimestamp(@NotNull Date timestamp)
    {
        this.timestamp = timestamp;
    }

    public void setUserId(@NotNull String userId)
    {
        this.userId = userId;
    }

    public void setStatus(@NotNull OrderStatus status)
    {
        this.status = status;
    }

    @NotNull
    public String toString()
    {
        return "OrderChange(" +
            " timestamp: " + getTimestamp() +
            " userId: " + getUserId() +
            " status: " + getStatus() + ")";
    }

    @NotNull
    public OrderChangeBuilder toBuilder()
    {
        return new OrderChangeBuilder(getTimestamp(),
                                      getUserId(),
                                      getStatus());
    }
}