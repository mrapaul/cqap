package com.lakeland.hl7.datamodel;

import org.jetbrains.annotations.*;
import java.util.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;


public class AdministrationSnapshotBeginBuilder extends TimedMessageBuilder<AdministrationSnapshotBegin, AdministrationSnapshotBeginBuilder>
{
    @NotNull private String userId;

    public AdministrationSnapshotBeginBuilder(@NotNull Date timestamp,
                                              @NotNull String userId)
    {
        super(timestamp);

        this.userId = userId;
    }


    @NotNull
    @Override
    public AdministrationSnapshotBeginBuilder setTimestamp(@NotNull Date timestamp)
    {
        super.setTimestamp(timestamp);

        return self();
    }

    @NotNull
    public AdministrationSnapshotBeginBuilder setUserId(@NotNull String userId)
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
    public AdministrationSnapshotBegin build()
    {
        return new AdministrationSnapshotBegin(getTimestamp(),
                                               getUserId());
    }


    @Override
    @NotNull
    protected AdministrationSnapshotBeginBuilder self()
    {
        return this;
    }
}