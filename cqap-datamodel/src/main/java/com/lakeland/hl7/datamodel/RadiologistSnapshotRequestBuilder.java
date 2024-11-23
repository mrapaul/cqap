package com.lakeland.hl7.datamodel;


import java.util.*;
import com.lakeland.ris.datamodel.*;


public class RadiologistSnapshotRequestBuilder extends TimedMessageBuilder<RadiologistSnapshotRequest, RadiologistSnapshotRequestBuilder>
{
    private String userId;

    public RadiologistSnapshotRequestBuilder(Date timestamp,
                                             String userId)
    {
        super(timestamp);

        this.userId = userId;
    }


    
    @Override
    public RadiologistSnapshotRequestBuilder setTimestamp(Date timestamp)
    {
        super.setTimestamp(timestamp);

        return self();
    }

    
    public RadiologistSnapshotRequestBuilder setUserId(String userId)
    {
        this.userId = userId;

        return self();
    }

    
    protected String getUserId()
    {
        return userId;
    }

    @Override
    
    public RadiologistSnapshotRequest build()
    {
        return new RadiologistSnapshotRequest(getTimestamp(),
                                              getUserId());
    }


    @Override
    
    protected RadiologistSnapshotRequestBuilder self()
    {
        return this;
    }
}