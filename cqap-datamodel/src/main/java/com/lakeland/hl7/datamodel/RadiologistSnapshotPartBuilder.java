package com.lakeland.hl7.datamodel;

import org.jetbrains.annotations.*;
import java.util.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;


public class RadiologistSnapshotPartBuilder extends TimedMessageBuilder<RadiologistSnapshotPart, RadiologistSnapshotPartBuilder>
{
    @NotNull private String userId;
    @NotNull private String order;

    public RadiologistSnapshotPartBuilder(@NotNull Date timestamp,
                                          @NotNull String userId,
                                          @NotNull String order)
    {
        super(timestamp);

        this.userId = userId;
        this.order = order;
    }


    @NotNull
    @Override
    public RadiologistSnapshotPartBuilder setTimestamp(@NotNull Date timestamp)
    {
        super.setTimestamp(timestamp);

        return self();
    }

    @NotNull
    public RadiologistSnapshotPartBuilder setUserId(@NotNull String userId)
    {
        this.userId = userId;

        return self();
    }

    @NotNull
    public RadiologistSnapshotPartBuilder setOrder(@NotNull String order)
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
    public RadiologistSnapshotPart build()
    {
        return new RadiologistSnapshotPart(getTimestamp(),
                                           getUserId(),
                                           getOrder());
    }


    @Override
    @NotNull
    protected RadiologistSnapshotPartBuilder self()
    {
        return this;
    }
}