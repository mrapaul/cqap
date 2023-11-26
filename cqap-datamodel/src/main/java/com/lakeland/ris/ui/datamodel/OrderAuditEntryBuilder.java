package com.lakeland.ris.ui.datamodel;

import org.jetbrains.annotations.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;


public class OrderAuditEntryBuilder
{
    @NotNull private String id;
    @NotNull private Date date;
    @NotNull private String userId;
    @NotNull private String orderId;
    @NotNull private String field;
    @Nullable private Object oldValue;
    @NotNull private Object newValue;

    public OrderAuditEntryBuilder(@NotNull String id,
                                  @NotNull Date date,
                                  @NotNull String userId,
                                  @NotNull String orderId,
                                  @NotNull String field,
                                  @NotNull Object newValue)
    {
        super();

        this.id = id;
        this.date = date;
        this.userId = userId;
        this.orderId = orderId;
        this.field = field;
        this.newValue = newValue;
    }


    @NotNull
    public OrderAuditEntryBuilder setId(@NotNull String id)
    {
        this.id = id;

        return self();
    }

    @NotNull
    public OrderAuditEntryBuilder setDate(@NotNull Date date)
    {
        this.date = date;

        return self();
    }

    @NotNull
    public OrderAuditEntryBuilder setUserId(@NotNull String userId)
    {
        this.userId = userId;

        return self();
    }

    @NotNull
    public OrderAuditEntryBuilder setOrderId(@NotNull String orderId)
    {
        this.orderId = orderId;

        return self();
    }

    @NotNull
    public OrderAuditEntryBuilder setField(@NotNull String field)
    {
        this.field = field;

        return self();
    }

    @NotNull
    public OrderAuditEntryBuilder setOldValue(@Nullable Object oldValue)
    {
        this.oldValue = oldValue;

        return self();
    }

    @NotNull
    public OrderAuditEntryBuilder setNewValue(@NotNull Object newValue)
    {
        this.newValue = newValue;

        return self();
    }

    @NotNull
    protected String getId()
    {
        return id;
    }

    @NotNull
    protected Date getDate()
    {
        return date;
    }

    @NotNull
    protected String getUserId()
    {
        return userId;
    }

    @NotNull
    protected String getOrderId()
    {
        return orderId;
    }

    @NotNull
    protected String getField()
    {
        return field;
    }

    @Nullable
    protected Object getOldValue()
    {
        return oldValue;
    }

    @NotNull
    protected Object getNewValue()
    {
        return newValue;
    }

    @NotNull
    public OrderAuditEntry build()
    {
        return new OrderAuditEntry(getId(),
                                   getDate(),
                                   getUserId(),
                                   getOrderId(),
                                   getField(),
                                   getOldValue(),
                                   getNewValue());
    }


    @NotNull
    protected OrderAuditEntryBuilder self()
    {
        return this;
    }
}