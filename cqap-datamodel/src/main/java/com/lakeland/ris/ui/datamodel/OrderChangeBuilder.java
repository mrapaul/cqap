package com.lakeland.ris.ui.datamodel;


import java.util.*;
import com.lakeland.ris.datamodel.*;


public class OrderChangeBuilder
{
    private Date timestamp;
    private String userId;
    private OrderStatus status;

    public OrderChangeBuilder(Date timestamp,
                              String userId,
                              OrderStatus status)
    {
        super();

        this.timestamp = timestamp;
        this.userId = userId;
        this.status = status;
    }


    
    public OrderChangeBuilder setTimestamp(Date timestamp)
    {
        this.timestamp = timestamp;

        return self();
    }

    
    public OrderChangeBuilder setUserId(String userId)
    {
        this.userId = userId;

        return self();
    }

    
    public OrderChangeBuilder setStatus(OrderStatus status)
    {
        this.status = status;

        return self();
    }

    
    protected Date getTimestamp()
    {
        return timestamp;
    }

    
    protected String getUserId()
    {
        return userId;
    }

    
    protected OrderStatus getStatus()
    {
        return status;
    }

    
    public OrderChange build()
    {
        return new OrderChange(getTimestamp(),
                               getUserId(),
                               getStatus());
    }


    
    protected OrderChangeBuilder self()
    {
        return this;
    }
}