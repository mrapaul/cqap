package com.lakeland.ris.ui.datamodel;

import org.codehaus.jackson.annotate.*;

import java.util.*;
import com.lakeland.ris.datamodel.*;
import java.util.*;

public class TagCounts
{
    private Collection<TagCount> counts;

    public TagCounts()
    {
        // empty
    }

    @JsonCreator
    public TagCounts(Collection<TagCount> counts)
    {
        super();

        this.counts = counts;
    }

    
    public Collection<TagCount> getCounts()
    {
        return counts;
    }
    public void setCounts(Collection<TagCount> counts)
    {
        this.counts = counts;
    }

    
    public String toString()
    {
        return "TagCounts(" +
            " counts: " + getCounts() + ")";
    }

    
    public TagCountsBuilder toBuilder()
    {
        return new TagCountsBuilder(getCounts());
    }
}