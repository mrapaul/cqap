package com.lakeland.ris.ui.datamodel;

import org.codehaus.jackson.annotate.*;

import java.util.*;
import com.lakeland.ris.datamodel.*;
import java.util.*;

public class OrderIds
{
    private Collection<String> ids;

    public OrderIds()
    {
        // empty
    }

    @JsonCreator
    public OrderIds(Collection<String> ids)
    {
        super();

        this.ids = ids;
    }


    public Collection<String> getIds()
    {
        return ids;
    }
    public void setIds(Collection<String> ids)
    {
        this.ids = ids;
    }


    public String toString()
    {
        return "OrderIds(" +
            " ids: " + getIds() + ")";
    }


    public OrderIdsBuilder toBuilder()
    {
        return new OrderIdsBuilder(getIds());
    }
}