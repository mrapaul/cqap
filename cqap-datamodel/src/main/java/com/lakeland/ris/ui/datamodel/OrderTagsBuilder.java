package com.lakeland.ris.ui.datamodel;

import org.jetbrains.annotations.*;
import java.util.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;
import java.util.*;

public class OrderTagsBuilder
{
    @NotNull private Collection<OrderTag> tags;

    public OrderTagsBuilder(@NotNull Collection<OrderTag> tags)
    {
        super();

        this.tags = tags;
    }


    @NotNull
    public OrderTagsBuilder setTags(@NotNull Collection<OrderTag> tags)
    {
        this.tags = tags;

        return self();
    }

    @NotNull
    protected Collection<OrderTag> getTags()
    {
        return tags;
    }

    @NotNull
    public OrderTags build()
    {
        return new OrderTags(getTags());
    }


    @NotNull
    protected OrderTagsBuilder self()
    {
        return this;
    }
}