package com.lakeland.hl7.datamodel;

import org.codehaus.jackson.annotate.*;

import java.util.*;
import com.lakeland.ris.datamodel.*;


public abstract class OrderActivity extends TimedMessage implements HL7Visitable
{
    public static final byte TYPE = 6;
    private String orderId;
    private String userId;

    public OrderActivity()
    {
        // empty
    }

    @JsonCreator
    public OrderActivity(Date timestamp,
                         String orderId,
                         String userId)
    {
        super(timestamp);

        this.orderId = orderId;
        this.userId = userId;
    }

    
    public String getOrderId()
    {
        return orderId;
    }

    
    public String getUserId()
    {
        return userId;
    }
    public void setOrderId(String orderId)
    {
        this.orderId = orderId;
    }

    public void setUserId(String userId)
    {
        this.userId = userId;
    }

    
    public String toString()
    {
        return "OrderActivity(" +
            super.toString() +
            " orderId: " + getOrderId() +
            " userId: " + getUserId() + ")";
    }

}