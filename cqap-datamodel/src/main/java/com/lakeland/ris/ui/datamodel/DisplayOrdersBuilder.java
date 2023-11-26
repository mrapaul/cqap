package com.lakeland.ris.ui.datamodel;

import org.jetbrains.annotations.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;
import java.util.*;

public class DisplayOrdersBuilder
{
    @NotNull private Collection<DisplayOrder> orders;

    public DisplayOrdersBuilder(@NotNull Collection<DisplayOrder> orders)
    {
        super();

        this.orders = orders;
    }


    @NotNull
    public DisplayOrdersBuilder setOrders(@NotNull Collection<DisplayOrder> orders)
    {
        this.orders = orders;

        return self();
    }

    @NotNull
    protected Collection<DisplayOrder> getOrders()
    {
        return orders;
    }

    @NotNull
    public DisplayOrders build()
    {
        return new DisplayOrders(getOrders());
    }


    @NotNull
    protected DisplayOrdersBuilder self()
    {
        return this;
    }
}