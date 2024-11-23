package com.lakeland.ris.ui.datamodel;

import org.codehaus.jackson.annotate.*;

import java.util.*;
import com.lakeland.ris.datamodel.*;
import java.util.*;

public class OrdersPerUser
{
    private Collection<UserOrderCount> counts;

    public OrdersPerUser()
    {
        // empty
    }

    @JsonCreator
    public OrdersPerUser(Collection<UserOrderCount> counts)
    {
        super();

        this.counts = counts;
    }


    public Collection<UserOrderCount> getCounts()
    {
        return counts;
    }
    public void setCounts(Collection<UserOrderCount> counts)
    {
        this.counts = counts;
    }


    public String toString()
    {
        return "OrdersPerUser(" +
            " counts: " + getCounts() + ")";
    }


    public OrdersPerUserBuilder toBuilder()
    {
        return new OrdersPerUserBuilder(getCounts());
    }
}