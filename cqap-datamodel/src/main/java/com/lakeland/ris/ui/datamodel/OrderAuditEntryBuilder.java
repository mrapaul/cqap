package com.lakeland.ris.ui.datamodel;


import java.util.*;
import com.lakeland.ris.datamodel.*;


public class OrderAuditEntryBuilder
{
    private String id;
    private Date date;
    private String userId;
    private String orderId;
    private String field;
     private Object oldValue;
    private Object newValue;

    public OrderAuditEntryBuilder(String id,
                                  Date date,
                                  String userId,
                                  String orderId,
                                  String field,
                                  Object newValue)
    {
        super();

        this.id = id;
        this.date = date;
        this.userId = userId;
        this.orderId = orderId;
        this.field = field;
        this.newValue = newValue;
    }



    public OrderAuditEntryBuilder setId(String id)
    {
        this.id = id;

        return self();
    }


    public OrderAuditEntryBuilder setDate(Date date)
    {
        this.date = date;

        return self();
    }


    public OrderAuditEntryBuilder setUserId(String userId)
    {
        this.userId = userId;

        return self();
    }


    public OrderAuditEntryBuilder setOrderId(String orderId)
    {
        this.orderId = orderId;

        return self();
    }


    public OrderAuditEntryBuilder setField(String field)
    {
        this.field = field;

        return self();
    }


    public OrderAuditEntryBuilder setOldValue( Object oldValue)
    {
        this.oldValue = oldValue;

        return self();
    }


    public OrderAuditEntryBuilder setNewValue(Object newValue)
    {
        this.newValue = newValue;

        return self();
    }


    protected String getId()
    {
        return id;
    }


    protected Date getDate()
    {
        return date;
    }


    protected String getUserId()
    {
        return userId;
    }


    protected String getOrderId()
    {
        return orderId;
    }


    protected String getField()
    {
        return field;
    }

    
    protected Object getOldValue()
    {
        return oldValue;
    }


    protected Object getNewValue()
    {
        return newValue;
    }


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



    protected OrderAuditEntryBuilder self()
    {
        return this;
    }
}