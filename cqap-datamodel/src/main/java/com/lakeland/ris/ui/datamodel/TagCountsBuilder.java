package com.lakeland.ris.ui.datamodel;


import java.util.*;
import com.lakeland.ris.datamodel.*;
import java.util.*;

public class TagCountsBuilder
{
    private Collection<TagCount> counts;

    public TagCountsBuilder(Collection<TagCount> counts)
    {
        super();

        this.counts = counts;
    }


    
    public TagCountsBuilder setCounts(Collection<TagCount> counts)
    {
        this.counts = counts;

        return self();
    }

    
    protected Collection<TagCount> getCounts()
    {
        return counts;
    }

    
    public TagCounts build()
    {
        return new TagCounts(getCounts());
    }


    
    protected TagCountsBuilder self()
    {
        return this;
    }
}