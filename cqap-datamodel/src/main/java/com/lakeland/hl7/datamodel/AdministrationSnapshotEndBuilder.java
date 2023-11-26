package com.lakeland.hl7.datamodel;

import org.jetbrains.annotations.*;
import java.util.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;


public class AdministrationSnapshotEndBuilder extends TimedMessageBuilder<AdministrationSnapshotEnd, AdministrationSnapshotEndBuilder>
{
    @NotNull private String userId;

    public AdministrationSnapshotEndBuilder(@NotNull Date timestamp,
                                            @NotNull String userId)
    {
        super(timestamp);

        this.userId = userId;
    }


    @NotNull
    @Override
    public AdministrationSnapshotEndBuilder setTimestamp(@NotNull Date timestamp)
    {
        super.setTimestamp(timestamp);

        return self();
    }

    @NotNull
    public AdministrationSnapshotEndBuilder setUserId(@NotNull String userId)
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
    public AdministrationSnapshotEnd build()
    {
        return new AdministrationSnapshotEnd(getTimestamp(),
                                             getUserId());
    }


    @Override
    @NotNull
    protected AdministrationSnapshotEndBuilder self()
    {
        return this;
    }
}