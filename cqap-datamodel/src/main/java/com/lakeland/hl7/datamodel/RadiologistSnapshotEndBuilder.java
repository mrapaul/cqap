package com.lakeland.hl7.datamodel;

import org.jetbrains.annotations.*;
import java.util.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;


public class RadiologistSnapshotEndBuilder extends TimedMessageBuilder<RadiologistSnapshotEnd, RadiologistSnapshotEndBuilder>
{
    @NotNull private String userId;

    public RadiologistSnapshotEndBuilder(@NotNull Date timestamp,
                                         @NotNull String userId)
    {
        super(timestamp);

        this.userId = userId;
    }


    @NotNull
    @Override
    public RadiologistSnapshotEndBuilder setTimestamp(@NotNull Date timestamp)
    {
        super.setTimestamp(timestamp);

        return self();
    }

    @NotNull
    public RadiologistSnapshotEndBuilder setUserId(@NotNull String userId)
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
    public RadiologistSnapshotEnd build()
    {
        return new RadiologistSnapshotEnd(getTimestamp(),
                                          getUserId());
    }


    @Override
    @NotNull
    protected RadiologistSnapshotEndBuilder self()
    {
        return this;
    }
}