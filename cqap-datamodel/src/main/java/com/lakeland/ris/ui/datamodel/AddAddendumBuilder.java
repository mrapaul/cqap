package com.lakeland.ris.ui.datamodel;


import java.util.*;
import com.lakeland.ris.datamodel.*;


public class AddAddendumBuilder
{
    private String orderId;
    private Date timestamp;
    private String userId;
    private String addendum;

    public AddAddendumBuilder(String orderId,
                              Date timestamp,
                              String userId,
                              String addendum)
    {
        super();

        this.orderId = orderId;
        this.timestamp = timestamp;
        this.userId = userId;
        this.addendum = addendum;
    }


    
    public AddAddendumBuilder setOrderId(String orderId)
    {
        this.orderId = orderId;

        return self();
    }

    
    public AddAddendumBuilder setTimestamp(Date timestamp)
    {
        this.timestamp = timestamp;

        return self();
    }

    
    public AddAddendumBuilder setUserId(String userId)
    {
        this.userId = userId;

        return self();
    }

    
    public AddAddendumBuilder setAddendum(String addendum)
    {
        this.addendum = addendum;

        return self();
    }

    
    protected String getOrderId()
    {
        return orderId;
    }

    
    protected Date getTimestamp()
    {
        return timestamp;
    }

    
    protected String getUserId()
    {
        return userId;
    }

    
    protected String getAddendum()
    {
        return addendum;
    }

    
    public AddAddendum build()
    {
        return new AddAddendum(getOrderId(),
                               getTimestamp(),
                               getUserId(),
                               getAddendum());
    }


    
    protected AddAddendumBuilder self()
    {
        return this;
    }
}