package com.lakeland.ris.ui.datamodel;


import java.util.*;
import com.lakeland.ris.datamodel.*;
import java.util.*;

public class OrderIdsBuilder
{
    private Collection<String> ids;

    public OrderIdsBuilder(Collection<String> ids)
    {
        super();

        this.ids = ids;
    }



    public OrderIdsBuilder setIds(Collection<String> ids)
    {
        this.ids = ids;

        return self();
    }


    protected Collection<String> getIds()
    {
        return ids;
    }


    public OrderIds build()
    {
        return new OrderIds(getIds());
    }



    protected OrderIdsBuilder self()
    {
        return this;
    }
}