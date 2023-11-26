package com.lakeland.ris.ui.datamodel;

import org.jetbrains.annotations.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;


public class OrderNoteBuilder
{
    @NotNull private Date timestamp;
    @NotNull private String orderId;
    @NotNull private String userId;
    @NotNull private String note;

    public OrderNoteBuilder(@NotNull Date timestamp,
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
    public OrderNoteBuilder setTimestamp(@NotNull Date timestamp)
    {
        this.timestamp = timestamp;

        return self();
    }

    @NotNull
    public OrderNoteBuilder setOrderId(@NotNull String orderId)
    {
        this.orderId = orderId;

        return self();
    }

    @NotNull
    public OrderNoteBuilder setUserId(@NotNull String userId)
    {
        this.userId = userId;

        return self();
    }

    @NotNull
    public OrderNoteBuilder setNote(@NotNull String note)
    {
        this.note = note;

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
    protected String getNote()
    {
        return note;
    }

    @NotNull
    public OrderNote build()
    {
        return new OrderNote(getTimestamp(),
                             getOrderId(),
                             getUserId(),
                             getNote());
    }


    @NotNull
    protected OrderNoteBuilder self()
    {
        return this;
    }
}