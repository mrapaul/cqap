package com.lakeland.hl7.datamodel;


import java.util.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;


public class NewOrderBuilder extends TimedMessageBuilder<NewOrder, NewOrderBuilder>
{
    private String orderId;

    public NewOrderBuilder(Date timestamp,
                           String orderId)
    {
        super(timestamp);

        this.orderId = orderId;
    }


    
    @Override
    public NewOrderBuilder setTimestamp(Date timestamp)
    {
        super.setTimestamp(timestamp);

        return self();
    }

    
    public NewOrderBuilder setOrderId(String orderId)
    {
        this.orderId = orderId;

        return self();
    }

    
    protected String getOrderId()
    {
        return orderId;
    }

    @Override
    
    public NewOrder build()
    {
        return new NewOrder(getTimestamp(),
                            getOrderId());
    }


    @Override
    
    protected NewOrderBuilder self()
    {
        return this;
    }
}