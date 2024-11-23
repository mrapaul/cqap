package com.lakeland.hl7.datamodel;


import java.util.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;
import java.util.*;

public class ManualAssignOrderBuilder extends OrderActivityBuilder<ManualAssignOrder, ManualAssignOrderBuilder>
{
    private Collection<String> orders;
    private String assignUserId;

    public ManualAssignOrderBuilder(Date timestamp,
                                    String orderId,
                                    String userId,
                                    Collection<String> orders,
                                    String assignUserId)
    {
        super(timestamp,
              orderId,
              userId);

        this.orders = orders;
        this.assignUserId = assignUserId;
    }



    @Override
    public ManualAssignOrderBuilder setTimestamp(Date timestamp)
    {
        super.setTimestamp(timestamp);

        return self();
    }


    @Override
    public ManualAssignOrderBuilder setOrderId(String orderId)
    {
        super.setOrderId(orderId);

        return self();
    }


    @Override
    public ManualAssignOrderBuilder setUserId(String userId)
    {
        super.setUserId(userId);

        return self();
    }


    public ManualAssignOrderBuilder setOrders(Collection<String> orders)
    {
        this.orders = orders;

        return self();
    }


    public ManualAssignOrderBuilder setAssignUserId(String assignUserId)
    {
        this.assignUserId = assignUserId;

        return self();
    }


    protected Collection<String> getOrders()
    {
        return orders;
    }


    protected String getAssignUserId()
    {
        return assignUserId;
    }

    @Override

    public ManualAssignOrder build()
    {
        return new ManualAssignOrder(getTimestamp(),
                                     getOrderId(),
                                     getUserId(),
                                     getOrders(),
                                     getAssignUserId());
    }


    @Override

    protected ManualAssignOrderBuilder self()
    {
        return this;
    }
}