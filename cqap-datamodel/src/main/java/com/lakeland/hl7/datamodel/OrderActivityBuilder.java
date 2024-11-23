package com.lakeland.hl7.datamodel;


import java.util.*;
import com.lakeland.ris.datamodel.*;


public abstract class OrderActivityBuilder<M, B extends OrderActivityBuilder<M, B>> extends TimedMessageBuilder<M, B> 
{
    private String orderId;
    private String userId;

    public OrderActivityBuilder(Date timestamp,
                                String orderId,
                                String userId)
    {
        super(timestamp);

        this.orderId = orderId;
        this.userId = userId;
    }



    public B setOrderId(String orderId)
    {
        this.orderId = orderId;

        return self();
    }


    public B setUserId(String userId)
    {
        this.userId = userId;

        return self();
    }


    protected String getOrderId()
    {
        return orderId;
    }


    protected String getUserId()
    {
        return userId;
    }


    public abstract M build();


    @Override

    protected B self()
    {
        return (B) this;
    }
}