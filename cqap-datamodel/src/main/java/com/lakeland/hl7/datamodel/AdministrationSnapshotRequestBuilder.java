package com.lakeland.hl7.datamodel;

import org.jetbrains.annotations.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;


public class AdministrationSnapshotRequestBuilder extends TimedMessageBuilder<AdministrationSnapshotRequest, AdministrationSnapshotRequestBuilder>
{
    @NotNull private String userId;

    public AdministrationSnapshotRequestBuilder(@NotNull Date timestamp,
                                                @NotNull String userId)
    {
        super(timestamp);

        this.userId = userId;
    }


    @NotNull
    @Override
    public AdministrationSnapshotRequestBuilder setTimestamp(@NotNull Date timestamp)
    {
        super.setTimestamp(timestamp);

        return self();
    }

    @NotNull
    public AdministrationSnapshotRequestBuilder setUserId(@NotNull String userId)
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
    public AdministrationSnapshotRequest build()
    {
        return new AdministrationSnapshotRequest(getTimestamp(),
                                                 getUserId());
    }


    @Override
    @NotNull
    protected AdministrationSnapshotRequestBuilder self()
    {
        return this;
    }
}