package com.lakeland.hl7.datamodel;

import org.jetbrains.annotations.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;


public class RadiologistSnapshotRequestBuilder extends TimedMessageBuilder<RadiologistSnapshotRequest, RadiologistSnapshotRequestBuilder>
{
    @NotNull private String userId;

    public RadiologistSnapshotRequestBuilder(@NotNull Date timestamp,
                                             @NotNull String userId)
    {
        super(timestamp);

        this.userId = userId;
    }


    @NotNull
    @Override
    public RadiologistSnapshotRequestBuilder setTimestamp(@NotNull Date timestamp)
    {
        super.setTimestamp(timestamp);

        return self();
    }

    @NotNull
    public RadiologistSnapshotRequestBuilder setUserId(@NotNull String userId)
    {
        this.userId = userId;

        return self();
    }

    @NotNull
    protected String getUserId()
    {
        return userId;
    }

    @Override
    @NotNull
    public RadiologistSnapshotRequest build()
    {
        return new RadiologistSnapshotRequest(getTimestamp(),
                                              getUserId());
    }


    @Override
    @NotNull
    protected RadiologistSnapshotRequestBuilder self()
    {
        return this;
    }
}