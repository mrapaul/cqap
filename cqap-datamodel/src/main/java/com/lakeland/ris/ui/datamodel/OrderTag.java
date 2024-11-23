package com.lakeland.ris.ui.datamodel;

import org.codehaus.jackson.annotate.*;

import java.util.*;
import com.lakeland.ris.datamodel.*;


public class OrderTag
{
    private Date timestamp;
    private String orderId;
    private String userId;
    private String tag;
    private boolean userPrivate;

    public OrderTag()
    {
        // empty
    }

    @JsonCreator
    public OrderTag(Date timestamp,
                    String orderId,
                    String userId,
                    String tag,
                    boolean userPrivate)
    {
        super();

        this.timestamp = timestamp;
        this.orderId = orderId;
        this.userId = userId;
        this.tag = tag;
        this.userPrivate = userPrivate;
    }

    
    public Date getTimestamp()
    {
        return timestamp;
    }

    
    public String getOrderId()
    {
        return orderId;
    }

    
    public String getUserId()
    {
        return userId;
    }

    
    public String getTag()
    {
        return tag;
    }

    public boolean isUserPrivate()
    {
        return userPrivate;
    }
    public void setTimestamp(Date timestamp)
    {
        this.timestamp = timestamp;
    }

    public void setOrderId(String orderId)
    {
        this.orderId = orderId;
    }

    public void setUserId(String userId)
    {
        this.userId = userId;
    }

    public void setTag(String tag)
    {
        this.tag = tag;
    }

    public void setUserPrivate(boolean userPrivate)
    {
        this.userPrivate = userPrivate;
    }

    
    public String toString()
    {
        return "OrderTag(" +
            " timestamp: " + getTimestamp() +
            " orderId: " + getOrderId() +
            " userId: " + getUserId() +
            " tag: " + getTag() +
            " userPrivate: " + isUserPrivate() + ")";
    }

    
    public OrderTagBuilder toBuilder()
    {
        return new OrderTagBuilder(getTimestamp(),
                                   getOrderId(),
                                   getUserId(),
                                   getTag()).setUserPrivate(isUserPrivate());
    }
}