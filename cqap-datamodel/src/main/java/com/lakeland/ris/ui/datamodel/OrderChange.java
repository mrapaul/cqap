package com.lakeland.ris.ui.datamodel;

import org.codehaus.jackson.annotate.*;

import java.util.*;
import com.lakeland.ris.datamodel.*;


public class OrderChange
{
    private Date timestamp;
    private String userId;
    private OrderStatus status;

    public OrderChange()
    {
        // empty
    }

    @JsonCreator
    public OrderChange(Date timestamp,
                       String userId,
                       OrderStatus status)
    {
        super();

        this.timestamp = timestamp;
        this.userId = userId;
        this.status = status;
    }

    
    public Date getTimestamp()
    {
        return timestamp;
    }

    
    public String getUserId()
    {
        return userId;
    }

    
    public OrderStatus getStatus()
    {
        return status;
    }
    public void setTimestamp(Date timestamp)
    {
        this.timestamp = timestamp;
    }

    public void setUserId(String userId)
    {
        this.userId = userId;
    }

    public void setStatus(OrderStatus status)
    {
        this.status = status;
    }

    
    public String toString()
    {
        return "OrderChange(" +
            " timestamp: " + getTimestamp() +
            " userId: " + getUserId() +
            " status: " + getStatus() + ")";
    }

    
    public OrderChangeBuilder toBuilder()
    {
        return new OrderChangeBuilder(getTimestamp(),
                                      getUserId(),
                                      getStatus());
    }
}