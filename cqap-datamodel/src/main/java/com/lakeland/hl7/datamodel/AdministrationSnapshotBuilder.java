package com.lakeland.hl7.datamodel;


import java.util.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;
import java.util.*;

public class AdministrationSnapshotBuilder extends TimedMessageBuilder<AdministrationSnapshot, AdministrationSnapshotBuilder>
{
    private Collection<HL7Order> orders;

    public AdministrationSnapshotBuilder(Date timestamp,
                                         Collection<HL7Order> orders)
    {
        super(timestamp);

        this.orders = orders;
    }



    @Override
    public AdministrationSnapshotBuilder setTimestamp(Date timestamp)
    {
        super.setTimestamp(timestamp);

        return self();
    }


    public AdministrationSnapshotBuilder setOrders(Collection<HL7Order> orders)
    {
        this.orders = orders;

        return self();
    }


    protected Collection<HL7Order> getOrders()
    {
        return orders;
    }

    @Override

    public AdministrationSnapshot build()
    {
        return new AdministrationSnapshot(getTimestamp(),
                                          getOrders());
    }


    @Override

    protected AdministrationSnapshotBuilder self()
    {
        return this;
    }
}