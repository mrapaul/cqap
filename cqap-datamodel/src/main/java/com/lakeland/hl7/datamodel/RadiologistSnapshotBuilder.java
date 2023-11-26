package com.lakeland.hl7.datamodel;

import org.jetbrains.annotations.*;
import java.util.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;
import java.util.*;

public class RadiologistSnapshotBuilder extends TimedMessageBuilder<RadiologistSnapshot, RadiologistSnapshotBuilder>
{
    @NotNull private String userId;
    @NotNull private Collection<HL7Order> orders;

    public RadiologistSnapshotBuilder(@NotNull Date timestamp,
                                      @NotNull String userId,
                                      @NotNull Collection<HL7Order> orders)
    {
        super(timestamp);

        this.userId = userId;
        this.orders = orders;
    }


    @NotNull
    @Override
    public RadiologistSnapshotBuilder setTimestamp(@NotNull Date timestamp)
    {
        super.setTimestamp(timestamp);

        return self();
    }

    @NotNull
    public RadiologistSnapshotBuilder setUserId(@NotNull String userId)
    {
        this.userId = userId;

        return self();
    }

    @NotNull
    public RadiologistSnapshotBuilder setOrders(@NotNull Collection<HL7Order> orders)
    {
        this.orders = orders;

        return self();
    }

    @NotNull
    protected String getUserId()
    {
        return userId;
    }

    @NotNull
    protected Collection<HL7Order> getOrders()
    {
        return orders;
    }

    @Override
    @NotNull
    public RadiologistSnapshot build()
    {
        return new RadiologistSnapshot(getTimestamp(),
                                       getUserId(),
                                       getOrders());
    }


    @Override
    @NotNull
    protected RadiologistSnapshotBuilder self()
    {
        return this;
    }
}