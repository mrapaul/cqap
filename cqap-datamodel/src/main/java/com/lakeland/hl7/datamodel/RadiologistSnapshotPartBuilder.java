package com.lakeland.hl7.datamodel;


import java.util.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;


public class RadiologistSnapshotPartBuilder extends TimedMessageBuilder<RadiologistSnapshotPart, RadiologistSnapshotPartBuilder>
{
    private String userId;
    private String order;

    public RadiologistSnapshotPartBuilder(Date timestamp,
                                          String userId,
                                          String order)
    {
        super(timestamp);

        this.userId = userId;
        this.order = order;
    }



    @Override
    public RadiologistSnapshotPartBuilder setTimestamp(Date timestamp)
    {
        super.setTimestamp(timestamp);

        return self();
    }


    public RadiologistSnapshotPartBuilder setUserId(String userId)
    {
        this.userId = userId;

        return self();
    }


    public RadiologistSnapshotPartBuilder setOrder(String order)
    {
        this.order = order;

        return self();
    }


    protected String getUserId()
    {
        return userId;
    }


    protected String getOrder()
    {
        return order;
    }

    @Override

    public RadiologistSnapshotPart build()
    {
        return new RadiologistSnapshotPart(getTimestamp(),
                                           getUserId(),
                                           getOrder());
    }


    @Override

    protected RadiologistSnapshotPartBuilder self()
    {
        return this;
    }
}