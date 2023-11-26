package com.lakeland.ris.ui.datamodel;

import org.codehaus.jackson.annotate.*;
import org.jetbrains.annotations.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;
import java.util.*;

public class OrderIds
{
    @NotNull private Collection<String> ids;

    public OrderIds()
    {
        // empty
    }

    @JsonCreator
    public OrderIds(@NotNull Collection<String> ids)
    {
        super();

        this.ids = ids;
    }

    @NotNull
    public Collection<String> getIds()
    {
        return ids;
    }
    public void setIds(@NotNull Collection<String> ids)
    {
        this.ids = ids;
    }

    @NotNull
    public String toString()
    {
        return "OrderIds(" +
            " ids: " + getIds() + ")";
    }

    @NotNull
    public OrderIdsBuilder toBuilder()
    {
        return new OrderIdsBuilder(getIds());
    }
}