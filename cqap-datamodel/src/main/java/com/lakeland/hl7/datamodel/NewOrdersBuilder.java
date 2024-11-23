package com.lakeland.hl7.datamodel;


import java.util.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;
import java.util.*;

public class NewOrdersBuilder extends TimedMessageBuilder<NewOrders, NewOrdersBuilder>
{
    private Collection<NewOrder> orderId;

    public NewOrdersBuilder(Date timestamp,
                            Collection<NewOrder> orderId)
    {
        super(timestamp);

        this.orderId = orderId;
    }



    @Override
    public NewOrdersBuilder setTimestamp(Date timestamp)
    {
        super.setTimestamp(timestamp);

        return self();
    }


    public NewOrdersBuilder setOrderId(Collection<NewOrder> orderId)
    {
        this.orderId = orderId;

        return self();
    }


    protected Collection<NewOrder> getOrderId()
    {
        return orderId;
    }

    @Override

    public NewOrders build()
    {
        return new NewOrders(getTimestamp(),
                             getOrderId());
    }


    @Override

    protected NewOrdersBuilder self()
    {
        return this;
    }
}