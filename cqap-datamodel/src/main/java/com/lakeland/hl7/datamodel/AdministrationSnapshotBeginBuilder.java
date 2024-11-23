package com.lakeland.hl7.datamodel;


import java.util.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;


public class AdministrationSnapshotBeginBuilder extends TimedMessageBuilder<AdministrationSnapshotBegin, AdministrationSnapshotBeginBuilder>
{
    private String userId;

    public AdministrationSnapshotBeginBuilder(Date timestamp,
                                              String userId)
    {
        super(timestamp);

        this.userId = userId;
    }


    
    @Override
    public AdministrationSnapshotBeginBuilder setTimestamp(Date timestamp)
    {
        super.setTimestamp(timestamp);

        return self();
    }

    
    public AdministrationSnapshotBeginBuilder setUserId(String userId)
    {
        this.userId = userId;

        return self();
    }

    
    protected String getUserId()
    {
        return userId;
    }

    @Override
    
    public AdministrationSnapshotBegin build()
    {
        return new AdministrationSnapshotBegin(getTimestamp(),
                                               getUserId());
    }


    @Override
    
    protected AdministrationSnapshotBeginBuilder self()
    {
        return this;
    }
}