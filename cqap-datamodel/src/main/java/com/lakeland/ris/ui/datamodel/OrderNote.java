package com.lakeland.ris.ui.datamodel;

import org.codehaus.jackson.annotate.*;
import org.jetbrains.annotations.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;


public class OrderNote
{
    @NotNull private Date timestamp;
    @NotNull private String orderId;
    @NotNull private String userId;
    @NotNull private String note;

    public OrderNote()
    {
        // empty
    }

    @JsonCreator
    public OrderNote(@NotNull Date timestamp,
                     @NotNull String orderId,
                     @NotNull String userId,
                     @NotNull String note)
    {
        super();

        this.timestamp = timestamp;
        this.orderId = orderId;
        this.userId = userId;
        this.note = note;
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
    public String getNote()
    {
        return note;
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

    public void setNote(@NotNull String note)
    {
        this.note = note;
    }

    @NotNull
    public String toString()
    {
        return "OrderNote(" +
            " timestamp: " + getTimestamp() +
            " orderId: " + getOrderId() +
            " userId: " + getUserId() +
            " note: " + getNote() + ")";
    }

    @NotNull
    public OrderNoteBuilder toBuilder()
    {
        return new OrderNoteBuilder(getTimestamp(),
                                    getOrderId(),
                                    getUserId(),
                                    getNote());
    }
}