package com.lakeland.hl7.datamodel;


import java.util.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;


public class RadiologistSnapshotBeginBuilder extends TimedMessageBuilder<RadiologistSnapshotBegin, RadiologistSnapshotBeginBuilder>
{
    private String userId;

    public RadiologistSnapshotBeginBuilder(Date timestamp,
                                           String userId)
    {
        super(timestamp);

        this.userId = userId;
    }


    
    @Override
    public RadiologistSnapshotBeginBuilder setTimestamp(Date timestamp)
    {
        super.setTimestamp(timestamp);

        return self();
    }

    
    public RadiologistSnapshotBeginBuilder setUserId(String userId)
    {
        this.userId = userId;

        return self();
    }

    
    protected String getUserId()
    {
        return userId;
    }

    @Override
    
    public RadiologistSnapshotBegin build()
    {
        return new RadiologistSnapshotBegin(getTimestamp(),
                                            getUserId());
    }


    @Override
    
    protected RadiologistSnapshotBeginBuilder self()
    {
        return this;
    }
}