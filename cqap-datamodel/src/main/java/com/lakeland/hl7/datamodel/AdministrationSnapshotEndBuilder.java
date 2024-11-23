package com.lakeland.hl7.datamodel;


import java.util.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;


public class AdministrationSnapshotEndBuilder extends TimedMessageBuilder<AdministrationSnapshotEnd, AdministrationSnapshotEndBuilder>
{
    private String userId;

    public AdministrationSnapshotEndBuilder(Date timestamp,
                                            String userId)
    {
        super(timestamp);

        this.userId = userId;
    }



    @Override
    public AdministrationSnapshotEndBuilder setTimestamp(Date timestamp)
    {
        super.setTimestamp(timestamp);

        return self();
    }


    public AdministrationSnapshotEndBuilder setUserId(String userId)
    {
        this.userId = userId;

        return self();
    }


    protected String getUserId()
    {
        return userId;
    }

    @Override

    public AdministrationSnapshotEnd build()
    {
        return new AdministrationSnapshotEnd(getTimestamp(),
                                             getUserId());
    }


    @Override

    protected AdministrationSnapshotEndBuilder self()
    {
        return this;
    }
}