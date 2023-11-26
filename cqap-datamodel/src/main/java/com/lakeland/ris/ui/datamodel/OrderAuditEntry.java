package com.lakeland.ris.ui.datamodel;

import org.codehaus.jackson.annotate.*;
import org.jetbrains.annotations.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;


public class OrderAuditEntry
{
    @NotNull private String id;
    @NotNull private Date date;
    @NotNull private String userId;
    @NotNull private String orderId;
    @NotNull private String field;
    @Nullable private Object oldValue;
    @NotNull private Object newValue;

    public OrderAuditEntry()
    {
        // empty
    }

    @JsonCreator
    public OrderAuditEntry(@NotNull String id,
                           @NotNull Date date,
                           @NotNull String userId,
                           @NotNull String orderId,
                           @NotNull String field,
                           @Nullable Object oldValue,
                           @NotNull Object newValue)
    {
        super();

        this.id = id;
        this.date = date;
        this.userId = userId;
        this.orderId = orderId;
        this.field = field;
        this.oldValue = oldValue;
        this.newValue = newValue;
    }

    @NotNull
    public String getId()
    {
        return id;
    }

    @NotNull
    public Date getDate()
    {
        return date;
    }

    @NotNull
    public String getUserId()
    {
        return userId;
    }

    @NotNull
    public String getOrderId()
    {
        return orderId;
    }

    @NotNull
    public String getField()
    {
        return field;
    }

    @Nullable
    public Object getOldValue()
    {
        return oldValue;
    }

    @NotNull
    public Object getNewValue()
    {
        return newValue;
    }
    public void setId(@NotNull String id)
    {
        this.id = id;
    }

    public void setDate(@NotNull Date date)
    {
        this.date = date;
    }

    public void setUserId(@NotNull String userId)
    {
        this.userId = userId;
    }

    public void setOrderId(@NotNull String orderId)
    {
        this.orderId = orderId;
    }

    public void setField(@NotNull String field)
    {
        this.field = field;
    }

    public void setOldValue(@Nullable Object oldValue)
    {
        this.oldValue = oldValue;
    }

    public void setNewValue(@NotNull Object newValue)
    {
        this.newValue = newValue;
    }

    @NotNull
    public String toString()
    {
        return "OrderAuditEntry(" +
            " id: " + getId() +
            " date: " + getDate() +
            " userId: " + getUserId() +
            " orderId: " + getOrderId() +
            " field: " + getField() +
            " oldValue: " + getOldValue() +
            " newValue: " + getNewValue() + ")";
    }

    @NotNull
    public OrderAuditEntryBuilder toBuilder()
    {
        return new OrderAuditEntryBuilder(getId(),
                                          getDate(),
                                          getUserId(),
                                          getOrderId(),
                                          getField(),
                                          getNewValue()).setOldValue(getOldValue())
    ;
    }
}