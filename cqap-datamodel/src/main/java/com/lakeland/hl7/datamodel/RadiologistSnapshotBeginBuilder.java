package com.lakeland.hl7.datamodel;

import org.jetbrains.annotations.*;
import java.util.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;


public class RadiologistSnapshotBeginBuilder extends TimedMessageBuilder<RadiologistSnapshotBegin, RadiologistSnapshotBeginBuilder>
{
    @NotNull private String userId;

    public RadiologistSnapshotBeginBuilder(@NotNull Date timestamp,
                                           @NotNull String userId)
    {
        super(timestamp);

        this.userId = userId;
    }


    @NotNull
    @Override
    public RadiologistSnapshotBeginBuilder setTimestamp(@NotNull Date timestamp)
    {
        super.setTimestamp(timestamp);

        return self();
    }

    @NotNull
    public RadiologistSnapshotBeginBuilder setUserId(@NotNull String userId)
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
    public RadiologistSnapshotBegin build()
    {
        return new RadiologistSnapshotBegin(getTimestamp(),
                                            getUserId());
    }


    @Override
    @NotNull
    protected RadiologistSnapshotBeginBuilder self()
    {
        return this;
    }
}