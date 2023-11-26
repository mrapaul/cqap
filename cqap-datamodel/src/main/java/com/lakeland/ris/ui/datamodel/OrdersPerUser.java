package com.lakeland.ris.ui.datamodel;

import org.codehaus.jackson.annotate.*;
import org.jetbrains.annotations.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;
import java.util.*;

public class OrdersPerUser
{
    @NotNull private Collection<UserOrderCount> counts;

    public OrdersPerUser()
    {
        // empty
    }

    @JsonCreator
    public OrdersPerUser(@NotNull Collection<UserOrderCount> counts)
    {
        super();

        this.counts = counts;
    }

    @NotNull
    public Collection<UserOrderCount> getCounts()
    {
        return counts;
    }
    public void setCounts(@NotNull Collection<UserOrderCount> counts)
    {
        this.counts = counts;
    }

    @NotNull
    public String toString()
    {
        return "OrdersPerUser(" +
            " counts: " + getCounts() + ")";
    }

    @NotNull
    public OrdersPerUserBuilder toBuilder()
    {
        return new OrdersPerUserBuilder(getCounts());
    }
}