package com.lakeland.ris.ui.datamodel;

import org.jetbrains.annotations.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;
import java.util.*;

public class OrdersPerUserBuilder
{
    @NotNull private Collection<UserOrderCount> counts;

    public OrdersPerUserBuilder(@NotNull Collection<UserOrderCount> counts)
    {
        super();

        this.counts = counts;
    }


    @NotNull
    public OrdersPerUserBuilder setCounts(@NotNull Collection<UserOrderCount> counts)
    {
        this.counts = counts;

        return self();
    }

    @NotNull
    protected Collection<UserOrderCount> getCounts()
    {
        return counts;
    }

    @NotNull
    public OrdersPerUser build()
    {
        return new OrdersPerUser(getCounts());
    }


    @NotNull
    protected OrdersPerUserBuilder self()
    {
        return this;
    }
}