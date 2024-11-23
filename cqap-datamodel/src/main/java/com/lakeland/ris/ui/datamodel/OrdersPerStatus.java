package com.lakeland.ris.ui.datamodel;

import org.codehaus.jackson.annotate.*;

import java.util.*;
import com.lakeland.ris.datamodel.*;
import java.util.*;

public class OrdersPerStatus
{
    private Collection<StatusOrderCount> counts;

    public OrdersPerStatus()
    {
        // empty
    }

    @JsonCreator
    public OrdersPerStatus(Collection<StatusOrderCount> counts)
    {
        super();

        this.counts = counts;
    }

    
    public Collection<StatusOrderCount> getCounts()
    {
        return counts;
    }
    public void setCounts(Collection<StatusOrderCount> counts)
    {
        this.counts = counts;
    }

    
    public String toString()
    {
        return "OrdersPerStatus(" +
            " counts: " + getCounts() + ")";
    }

    
    public OrdersPerStatusBuilder toBuilder()
    {
        return new OrdersPerStatusBuilder(getCounts());
    }
}