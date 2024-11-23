package com.lakeland.hl7.datamodel;


import java.util.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;


public class AdministrationSnapshotPartBuilder extends TimedMessageBuilder<AdministrationSnapshotPart, AdministrationSnapshotPartBuilder>
{
    private String userId;
    private String order;

    public AdministrationSnapshotPartBuilder(Date timestamp,
                                             String userId,
                                             String order)
    {
        super(timestamp);

        this.userId = userId;
        this.order = order;
    }


    
    @Override
    public AdministrationSnapshotPartBuilder setTimestamp(Date timestamp)
    {
        super.setTimestamp(timestamp);

        return self();
    }

    
    public AdministrationSnapshotPartBuilder setUserId(String userId)
    {
        this.userId = userId;

        return self();
    }

    
    public AdministrationSnapshotPartBuilder setOrder(String order)
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
    
    public AdministrationSnapshotPart build()
    {
        return new AdministrationSnapshotPart(getTimestamp(),
                                              getUserId(),
                                              getOrder());
    }


    @Override
    
    protected AdministrationSnapshotPartBuilder self()
    {
        return this;
    }
}