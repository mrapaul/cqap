package com.lakeland.ris.ui.datamodel;


import java.util.*;
import com.lakeland.ris.datamodel.*;


public class OrderTagBuilder
{
    private Date timestamp;
    private String orderId;
    private String userId;
    private String tag;
    private boolean userPrivate;

    public OrderTagBuilder(Date timestamp,
                           String orderId,
                           String userId,
                           String tag)
    {
        super();

        this.timestamp = timestamp;
        this.orderId = orderId;
        this.userId = userId;
        this.tag = tag;
    }


    
    public OrderTagBuilder setTimestamp(Date timestamp)
    {
        this.timestamp = timestamp;

        return self();
    }

    
    public OrderTagBuilder setOrderId(String orderId)
    {
        this.orderId = orderId;

        return self();
    }

    
    public OrderTagBuilder setUserId(String userId)
    {
        this.userId = userId;

        return self();
    }

    
    public OrderTagBuilder setTag(String tag)
    {
        this.tag = tag;

        return self();
    }

    
    public OrderTagBuilder setUserPrivate(boolean userPrivate)
    {
        this.userPrivate = userPrivate;

        return self();
    }

    
    protected Date getTimestamp()
    {
        return timestamp;
    }

    
    protected String getOrderId()
    {
        return orderId;
    }

    
    protected String getUserId()
    {
        return userId;
    }

    
    protected String getTag()
    {
        return tag;
    }

    protected boolean isUserPrivate()
    {
        return userPrivate;
    }

    
    public OrderTag build()
    {
        return new OrderTag(getTimestamp(),
                            getOrderId(),
                            getUserId(),
                            getTag(),
                            isUserPrivate());
    }


    
    protected OrderTagBuilder self()
    {
        return this;
    }
}