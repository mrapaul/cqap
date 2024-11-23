package com.lakeland.ris.ui.datamodel;

import org.codehaus.jackson.annotate.*;

import java.util.*;
import com.lakeland.ris.datamodel.*;
import java.util.*;

public class DisplayOrders
{
    private Collection<DisplayOrder> orders;

    public DisplayOrders()
    {
        // empty
    }

    @JsonCreator
    public DisplayOrders(Collection<DisplayOrder> orders)
    {
        super();

        this.orders = orders;
    }

    
    public Collection<DisplayOrder> getOrders()
    {
        return orders;
    }
    public void setOrders(Collection<DisplayOrder> orders)
    {
        this.orders = orders;
    }

    
    public String toString()
    {
        return "DisplayOrders(" +
            " orders: " + getOrders() + ")";
    }

    
    public DisplayOrdersBuilder toBuilder()
    {
        return new DisplayOrdersBuilder(getOrders());
    }
}