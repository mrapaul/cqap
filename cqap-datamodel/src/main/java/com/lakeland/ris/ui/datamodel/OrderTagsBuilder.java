package com.lakeland.ris.ui.datamodel;


import java.util.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;
import java.util.*;

public class OrderTagsBuilder
{
    private Collection<OrderTag> tags;

    public OrderTagsBuilder(Collection<OrderTag> tags)
    {
        super();

        this.tags = tags;
    }



    public OrderTagsBuilder setTags(Collection<OrderTag> tags)
    {
        this.tags = tags;

        return self();
    }


    protected Collection<OrderTag> getTags()
    {
        return tags;
    }


    public OrderTags build()
    {
        return new OrderTags(getTags());
    }



    protected OrderTagsBuilder self()
    {
        return this;
    }
}