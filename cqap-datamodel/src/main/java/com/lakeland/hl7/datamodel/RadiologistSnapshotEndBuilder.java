package com.lakeland.hl7.datamodel;


import java.util.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;


public class RadiologistSnapshotEndBuilder extends TimedMessageBuilder<RadiologistSnapshotEnd, RadiologistSnapshotEndBuilder>
{
    private String userId;

    public RadiologistSnapshotEndBuilder(Date timestamp,
                                         String userId)
    {
        super(timestamp);

        this.userId = userId;
    }



    @Override
    public RadiologistSnapshotEndBuilder setTimestamp(Date timestamp)
    {
        super.setTimestamp(timestamp);

        return self();
    }


    public RadiologistSnapshotEndBuilder setUserId(String userId)
    {
        this.userId = userId;

        return self();
    }


    protected String getUserId()
    {
        return userId;
    }

    @Override

    public RadiologistSnapshotEnd build()
    {
        return new RadiologistSnapshotEnd(getTimestamp(),
                                          getUserId());
    }


    @Override

    protected RadiologistSnapshotEndBuilder self()
    {
        return this;
    }
}