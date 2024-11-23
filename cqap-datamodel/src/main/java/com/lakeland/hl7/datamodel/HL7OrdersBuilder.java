package com.lakeland.hl7.datamodel;


import java.util.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;
import java.util.*;

public class HL7OrdersBuilder
{
    private Collection<HL7Order> orders;

    public HL7OrdersBuilder(Collection<HL7Order> orders)
    {
        super();

        this.orders = orders;
    }



    public HL7OrdersBuilder setOrders(Collection<HL7Order> orders)
    {
        this.orders = orders;

        return self();
    }


    protected Collection<HL7Order> getOrders()
    {
        return orders;
    }


    public HL7Orders build()
    {
        return new HL7Orders(getOrders());
    }



    protected HL7OrdersBuilder self()
    {
        return this;
    }
}