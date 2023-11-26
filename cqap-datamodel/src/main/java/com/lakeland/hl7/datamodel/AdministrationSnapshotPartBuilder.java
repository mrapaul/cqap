package com.lakeland.hl7.datamodel;

import org.jetbrains.annotations.*;
import java.util.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;


public class AdministrationSnapshotPartBuilder extends TimedMessageBuilder<AdministrationSnapshotPart, AdministrationSnapshotPartBuilder>
{
    @NotNull private String userId;
    @NotNull private String order;

    public AdministrationSnapshotPartBuilder(@NotNull Date timestamp,
                                             @NotNull String userId,
                                             @NotNull String order)
    {
        super(timestamp);

        this.userId = userId;
        this.order = order;
    }


    @NotNull
    @Override
    public AdministrationSnapshotPartBuilder setTimestamp(@NotNull Date timestamp)
    {
        super.setTimestamp(timestamp);

        return self();
    }

    @NotNull
    public AdministrationSnapshotPartBuilder setUserId(@NotNull String userId)
    {
        this.userId = userId;

        return self();
    }

    @NotNull
    public AdministrationSnapshotPartBuilder setOrder(@NotNull String order)
    {
        this.order = order;

        return self();
    }

    @NotNull
    protected String getUserId()
    {
        return userId;
    }

    @NotNull
    protected String getOrder()
    {
        return order;
    }

    @Override
    @NotNull
    public AdministrationSnapshotPart build()
    {
        return new AdministrationSnapshotPart(getTimestamp(),
                                              getUserId(),
                                              getOrder());
    }


    @Override
    @NotNull
    protected AdministrationSnapshotPartBuilder self()
    {
        return this;
    }
}