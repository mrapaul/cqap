package com.lakeland.hl7.datamodel;


import java.util.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;


public class OrderBidConfirmBuilder extends OrderActivityBuilder<OrderBidConfirm, OrderBidConfirmBuilder>
{

    public OrderBidConfirmBuilder(Date timestamp,
                                  String orderId,
                                  String userId)
    {
        super(timestamp,
              orderId,
              userId);

    }


    
    @Override
    public OrderBidConfirmBuilder setTimestamp(Date timestamp)
    {
        super.setTimestamp(timestamp);

        return self();
    }

    
    @Override
    public OrderBidConfirmBuilder setOrderId(String orderId)
    {
        super.setOrderId(orderId);

        return self();
    }

    
    @Override
    public OrderBidConfirmBuilder setUserId(String userId)
    {
        super.setUserId(userId);

        return self();
    }



    @Override
    
    public OrderBidConfirm build()
    {
        return new OrderBidConfirm(getTimestamp(),
                                   getOrderId(),
                                   getUserId());
    }


    @Override
    
    protected OrderBidConfirmBuilder self()
    {
        return this;
    }
}