package com.lakeland.ris.ui.datamodel;

import org.codehaus.jackson.annotate.*;
import org.jetbrains.annotations.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;


public class OrderTag
{
    @NotNull private Date timestamp;
    @NotNull private String orderId;
    @NotNull private String userId;
    @NotNull private String tag;
    private boolean userPrivate;

    public OrderTag()
    {
        // empty
    }

    @JsonCreator
    public OrderTag(@NotNull Date timestamp,
                    @NotNull String orderId,
                    @NotNull String userId,
                    @NotNull String tag,
                    boolean userPrivate)
    {
        super();

        this.timestamp = timestamp;
        this.orderId = orderId;
        this.userId = userId;
        this.tag = tag;
        this.userPrivate = userPrivate;
    }

    @NotNull
    public Date getTimestamp()
    {
        return timestamp;
    }

    @NotNull
    public String getOrderId()
    {
        return orderId;
    }

    @NotNull
    public String getUserId()
    {
        return userId;
    }

    @NotNull
    public String getTag()
    {
        return tag;
    }

    public boolean isUserPrivate()
    {
        return userPrivate;
    }
    public void setTimestamp(@NotNull Date timestamp)
    {
        this.timestamp = timestamp;
    }

    public void setOrderId(@NotNull String orderId)
    {
        this.orderId = orderId;
    }

    public void setUserId(@NotNull String userId)
    {
        this.userId = userId;
    }

    public void setTag(@NotNull String tag)
    {
        this.tag = tag;
    }

    public void setUserPrivate(boolean userPrivate)
    {
        this.userPrivate = userPrivate;
    }

    @NotNull
    public String toString()
    {
        return "OrderTag(" +
            " timestamp: " + getTimestamp() +
            " orderId: " + getOrderId() +
            " userId: " + getUserId() +
            " tag: " + getTag() +
            " userPrivate: " + isUserPrivate() + ")";
    }

    @NotNull
    public OrderTagBuilder toBuilder()
    {
        return new OrderTagBuilder(getTimestamp(),
                                   getOrderId(),
                                   getUserId(),
                                   getTag()).setUserPrivate(isUserPrivate());
    }
}