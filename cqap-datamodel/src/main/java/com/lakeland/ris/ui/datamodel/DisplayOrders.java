package com.lakeland.ris.ui.datamodel;

import org.codehaus.jackson.annotate.*;
import org.jetbrains.annotations.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;
import java.util.*;

public class DisplayOrders
{
    @NotNull private Collection<DisplayOrder> orders;

    public DisplayOrders()
    {
        // empty
    }

    @JsonCreator
    public DisplayOrders(@NotNull Collection<DisplayOrder> orders)
    {
        super();

        this.orders = orders;
    }

    @NotNull
    public Collection<DisplayOrder> getOrders()
    {
        return orders;
    }
    public void setOrders(@NotNull Collection<DisplayOrder> orders)
    {
        this.orders = orders;
    }

    @NotNull
    public String toString()
    {
        return "DisplayOrders(" +
            " orders: " + getOrders() + ")";
    }

    @NotNull
    public DisplayOrdersBuilder toBuilder()
    {
        return new DisplayOrdersBuilder(getOrders());
    }
}