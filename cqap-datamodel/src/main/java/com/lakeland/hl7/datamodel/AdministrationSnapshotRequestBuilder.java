package com.lakeland.hl7.datamodel;


import java.util.*;
import com.lakeland.ris.datamodel.*;


public class AdministrationSnapshotRequestBuilder extends TimedMessageBuilder<AdministrationSnapshotRequest, AdministrationSnapshotRequestBuilder>
{
    private String userId;

    public AdministrationSnapshotRequestBuilder(Date timestamp,
                                                String userId)
    {
        super(timestamp);

        this.userId = userId;
    }



    @Override
    public AdministrationSnapshotRequestBuilder setTimestamp(Date timestamp)
    {
        super.setTimestamp(timestamp);

        return self();
    }


    public AdministrationSnapshotRequestBuilder setUserId(String userId)
    {
        this.userId = userId;

        return self();
    }


    protected String getUserId()
    {
        return userId;
    }

    @Override

    public AdministrationSnapshotRequest build()
    {
        return new AdministrationSnapshotRequest(getTimestamp(),
                                                 getUserId());
    }


    @Override

    protected AdministrationSnapshotRequestBuilder self()
    {
        return this;
    }
}