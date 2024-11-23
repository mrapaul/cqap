package com.lakeland.ris.ui.datamodel;

import org.codehaus.jackson.annotate.*;

import java.util.*;
import com.lakeland.ris.datamodel.*;


public class OrderNote
{
    private Date timestamp;
    private String orderId;
    private String userId;
    private String note;

    public OrderNote()
    {
        // empty
    }

    @JsonCreator
    public OrderNote(Date timestamp,
                     String orderId,
                     String userId,
                     String note)
    {
        super();

        this.timestamp = timestamp;
        this.orderId = orderId;
        this.userId = userId;
        this.note = note;
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

    
    public String getNote()
    {
        return note;
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

    public void setNote(String note)
    {
        this.note = note;
    }

    
    public String toString()
    {
        return "OrderNote(" +
            " timestamp: " + getTimestamp() +
            " orderId: " + getOrderId() +
            " userId: " + getUserId() +
            " note: " + getNote() + ")";
    }

    
    public OrderNoteBuilder toBuilder()
    {
        return new OrderNoteBuilder(getTimestamp(),
                                    getOrderId(),
                                    getUserId(),
                                    getNote());
    }
}