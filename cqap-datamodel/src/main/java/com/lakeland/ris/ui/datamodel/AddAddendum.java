package com.lakeland.ris.ui.datamodel;

import org.codehaus.jackson.annotate.*;

import java.util.*;
import com.lakeland.ris.datamodel.*;


public class AddAddendum
{
    private String orderId;
    private Date timestamp;
    private String userId;
    private String addendum;

    public AddAddendum()
    {
        // empty
    }

    @JsonCreator
    public AddAddendum(String orderId,
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

    
    public String getOrderId()
    {
        return orderId;
    }

    
    public Date getTimestamp()
    {
        return timestamp;
    }

    
    public String getUserId()
    {
        return userId;
    }

    
    public String getAddendum()
    {
        return addendum;
    }
    public void setOrderId(String orderId)
    {
        this.orderId = orderId;
    }

    public void setTimestamp(Date timestamp)
    {
        this.timestamp = timestamp;
    }

    public void setUserId(String userId)
    {
        this.userId = userId;
    }

    public void setAddendum(String addendum)
    {
        this.addendum = addendum;
    }

    
    public String toString()
    {
        return "AddAddendum(" +
            " orderId: " + getOrderId() +
            " timestamp: " + getTimestamp() +
            " userId: " + getUserId() +
            " addendum: " + getAddendum() + ")";
    }

    
    public AddAddendumBuilder toBuilder()
    {
        return new AddAddendumBuilder(getOrderId(),
                                      getTimestamp(),
                                      getUserId(),
                                      getAddendum());
    }
}