package com.lakeland.hl7.datamodel;

import org.jetbrains.annotations.*;
import java.util.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;
import java.util.*;

public class NewOrdersBuilder extends TimedMessageBuilder<NewOrders, NewOrdersBuilder>
{
    @NotNull private Collection<NewOrder> orderId;

    public NewOrdersBuilder(@NotNull Date timestamp,
                            @NotNull Collection<NewOrder> orderId)
    {
        super(timestamp);

        this.orderId = orderId;
    }


    @NotNull
    @Override
    public NewOrdersBuilder setTimestamp(@NotNull Date timestamp)
    {
        super.setTimestamp(timestamp);

        return self();
    }

    @NotNull
    public NewOrdersBuilder setOrderId(@NotNull Collection<NewOrder> orderId)
    {
        this.orderId = orderId;

        return self();
    }

    @NotNull
    protected Collection<NewOrder> getOrderId()
    {
        return orderId;
    }

    @Override
    @NotNull
    public NewOrders build()
    {
        return new NewOrders(getTimestamp(),
                             getOrderId());
    }


    @Override
    @NotNull
    protected NewOrdersBuilder self()
    {
        return this;
    }
}