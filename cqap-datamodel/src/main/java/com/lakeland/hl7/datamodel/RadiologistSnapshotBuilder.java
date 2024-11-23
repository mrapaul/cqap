package com.lakeland.hl7.datamodel;


import java.util.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;
import java.util.*;

public class RadiologistSnapshotBuilder extends TimedMessageBuilder<RadiologistSnapshot, RadiologistSnapshotBuilder>
{
    private String userId;
    private Collection<HL7Order> orders;

    public RadiologistSnapshotBuilder(Date timestamp,
                                      String userId,
                                      Collection<HL7Order> orders)
    {
        super(timestamp);

        this.userId = userId;
        this.orders = orders;
    }


    
    @Override
    public RadiologistSnapshotBuilder setTimestamp(Date timestamp)
    {
        super.setTimestamp(timestamp);

        return self();
    }

    
    public RadiologistSnapshotBuilder setUserId(String userId)
    {
        this.userId = userId;

        return self();
    }

    
    public RadiologistSnapshotBuilder setOrders(Collection<HL7Order> orders)
    {
        this.orders = orders;

        return self();
    }

    
    protected String getUserId()
    {
        return userId;
    }

    
    protected Collection<HL7Order> getOrders()
    {
        return orders;
    }

    @Override
    
    public RadiologistSnapshot build()
    {
        return new RadiologistSnapshot(getTimestamp(),
                                       getUserId(),
                                       getOrders());
    }


    @Override
    
    protected RadiologistSnapshotBuilder self()
    {
        return this;
    }
}