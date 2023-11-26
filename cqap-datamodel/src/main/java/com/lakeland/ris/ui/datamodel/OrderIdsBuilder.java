package com.lakeland.ris.ui.datamodel;

import org.jetbrains.annotations.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;
import java.util.*;

public class OrderIdsBuilder
{
    @NotNull private Collection<String> ids;

    public OrderIdsBuilder(@NotNull Collection<String> ids)
    {
        super();

        this.ids = ids;
    }


    @NotNull
    public OrderIdsBuilder setIds(@NotNull Collection<String> ids)
    {
        this.ids = ids;

        return self();
    }

    @NotNull
    protected Collection<String> getIds()
    {
        return ids;
    }

    @NotNull
    public OrderIds build()
    {
        return new OrderIds(getIds());
    }


    @NotNull
    protected OrderIdsBuilder self()
    {
        return this;
    }
}