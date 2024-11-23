package com.lakeland.hl7.datamodel;


import java.util.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;


public class OrderStatusChangeBuilder extends OrderActivityBuilder<OrderStatusChange, OrderStatusChangeBuilder>
{
    private OrderStatus status;
     private String assignedTo;

    public OrderStatusChangeBuilder(Date timestamp,
                                    String orderId,
                                    String userId,
                                    OrderStatus status)
    {
        super(timestamp,
              orderId,
              userId);

        this.status = status;
    }


    
    @Override
    public OrderStatusChangeBuilder setTimestamp(Date timestamp)
    {
        super.setTimestamp(timestamp);

        return self();
    }

    
    @Override
    public OrderStatusChangeBuilder setOrderId(String orderId)
    {
        super.setOrderId(orderId);

        return self();
    }

    
    @Override
    public OrderStatusChangeBuilder setUserId(String userId)
    {
        super.setUserId(userId);

        return self();
    }

    
    public OrderStatusChangeBuilder setStatus(OrderStatus status)
    {
        this.status = status;

        return self();
    }

    
    public OrderStatusChangeBuilder setAssignedTo( String assignedTo)
    {
        this.assignedTo = assignedTo;

        return self();
    }

    
    protected OrderStatus getStatus()
    {
        return status;
    }

    
    protected String getAssignedTo()
    {
        return assignedTo;
    }

    @Override
    
    public OrderStatusChange build()
    {
        return new OrderStatusChange(getTimestamp(),
                                     getOrderId(),
                                     getUserId(),
                                     getStatus(),
                                     getAssignedTo());
    }


    @Override
    
    protected OrderStatusChangeBuilder self()
    {
        return this;
    }
}