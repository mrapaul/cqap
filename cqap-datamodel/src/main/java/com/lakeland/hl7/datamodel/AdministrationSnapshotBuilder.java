package com.lakeland.hl7.datamodel;

import org.jetbrains.annotations.*;
import java.util.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;
import java.util.*;

public class AdministrationSnapshotBuilder extends TimedMessageBuilder<AdministrationSnapshot, AdministrationSnapshotBuilder>
{
    @NotNull private Collection<HL7Order> orders;

    public AdministrationSnapshotBuilder(@NotNull Date timestamp,
                                         @NotNull Collection<HL7Order> orders)
    {
        super(timestamp);

        this.orders = orders;
    }


    @NotNull
    @Override
    public AdministrationSnapshotBuilder setTimestamp(@NotNull Date timestamp)
    {
        super.setTimestamp(timestamp);

        return self();
    }

    @NotNull
    public AdministrationSnapshotBuilder setOrders(@NotNull Collection<HL7Order> orders)
    {
        this.orders = orders;

        return self();
    }

    @NotNull
    protected Collection<HL7Order> getOrders()
    {
        return orders;
    }

    @Override
    @NotNull
    public AdministrationSnapshot build()
    {
        return new AdministrationSnapshot(getTimestamp(),
                                          getOrders());
    }


    @Override
    @NotNull
    protected AdministrationSnapshotBuilder self()
    {
        return this;
    }
}