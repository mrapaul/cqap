package com.lakeland.hl7.datamodel;

import org.jetbrains.annotations.*;
import java.util.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;
import java.util.*;

public class HL7OrdersBuilder
{
    @NotNull private Collection<HL7Order> orders;

    public HL7OrdersBuilder(@NotNull Collection<HL7Order> orders)
    {
        super();

        this.orders = orders;
    }


    @NotNull
    public HL7OrdersBuilder setOrders(@NotNull Collection<HL7Order> orders)
    {
        this.orders = orders;

        return self();
    }

    @NotNull
    protected Collection<HL7Order> getOrders()
    {
        return orders;
    }

    @NotNull
    public HL7Orders build()
    {
        return new HL7Orders(getOrders());
    }


    @NotNull
    protected HL7OrdersBuilder self()
    {
        return this;
    }
}