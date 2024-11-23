package com.lakeland.ris.ui.datamodel;

import org.codehaus.jackson.annotate.*;

import java.util.*;
import com.lakeland.ris.datamodel.*;


public class OrderAuditEntry
{
    private String id;
    private Date date;
    private String userId;
    private String orderId;
    private String field;
     private Object oldValue;
    private Object newValue;

    public OrderAuditEntry()
    {
        // empty
    }

    @JsonCreator
    public OrderAuditEntry(String id,
                           Date date,
                           String userId,
                           String orderId,
                           String field,
                            Object oldValue,
                           Object newValue)
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


    public String getId()
    {
        return id;
    }


    public Date getDate()
    {
        return date;
    }


    public String getUserId()
    {
        return userId;
    }


    public String getOrderId()
    {
        return orderId;
    }


    public String getField()
    {
        return field;
    }

    
    public Object getOldValue()
    {
        return oldValue;
    }


    public Object getNewValue()
    {
        return newValue;
    }
    public void setId(String id)
    {
        this.id = id;
    }

    public void setDate(Date date)
    {
        this.date = date;
    }

    public void setUserId(String userId)
    {
        this.userId = userId;
    }

    public void setOrderId(String orderId)
    {
        this.orderId = orderId;
    }

    public void setField(String field)
    {
        this.field = field;
    }

    public void setOldValue( Object oldValue)
    {
        this.oldValue = oldValue;
    }

    public void setNewValue(Object newValue)
    {
        this.newValue = newValue;
    }


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