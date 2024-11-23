package com.lakeland.ris.ui.datamodel;


import java.util.*;
import com.lakeland.ris.datamodel.*;


public class OrderNoteBuilder
{
    private Date timestamp;
    private String orderId;
    private String userId;
    private String note;

    public OrderNoteBuilder(Date timestamp,
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



    public OrderNoteBuilder setTimestamp(Date timestamp)
    {
        this.timestamp = timestamp;

        return self();
    }


    public OrderNoteBuilder setOrderId(String orderId)
    {
        this.orderId = orderId;

        return self();
    }


    public OrderNoteBuilder setUserId(String userId)
    {
        this.userId = userId;

        return self();
    }


    public OrderNoteBuilder setNote(String note)
    {
        this.note = note;

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


    protected String getNote()
    {
        return note;
    }


    public OrderNote build()
    {
        return new OrderNote(getTimestamp(),
                             getOrderId(),
                             getUserId(),
                             getNote());
    }



    protected OrderNoteBuilder self()
    {
        return this;
    }
}