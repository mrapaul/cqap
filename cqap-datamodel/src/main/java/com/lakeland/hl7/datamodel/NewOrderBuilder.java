package com.lakeland.hl7.datamodel;

import org.jetbrains.annotations.*;
import java.util.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;


public class NewOrderBuilder extends TimedMessageBuilder<NewOrder, NewOrderBuilder>
{
    @NotNull private String orderId;

    public NewOrderBuilder(@NotNull Date timestamp,
                           @NotNull String orderId)
    {
        super(timestamp);

        this.orderId = orderId;
    }


    @NotNull
    @Override
    public NewOrderBuilder setTimestamp(@NotNull Date timestamp)
    {
        super.setTimestamp(timestamp);

        return self();
    }

    @NotNull
    public NewOrderBuilder setOrderId(@NotNull String orderId)
    {
        this.orderId = orderId;

        return self();
    }

    @NotNull
    protected String getOrderId()
    {
        return orderId;
    }

    @Override
    @NotNull
    public NewOrder build()
    {
        return new NewOrder(getTimestamp(),
                            getOrderId());
    }


    @Override
    @NotNull
    protected NewOrderBuilder self()
    {
        return this;
    }
}