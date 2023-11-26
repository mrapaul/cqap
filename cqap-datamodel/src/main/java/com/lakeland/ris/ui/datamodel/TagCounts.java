package com.lakeland.ris.ui.datamodel;

import org.codehaus.jackson.annotate.*;
import org.jetbrains.annotations.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;
import java.util.*;

public class TagCounts
{
    @NotNull private Collection<TagCount> counts;

    public TagCounts()
    {
        // empty
    }

    @JsonCreator
    public TagCounts(@NotNull Collection<TagCount> counts)
    {
        super();

        this.counts = counts;
    }

    @NotNull
    public Collection<TagCount> getCounts()
    {
        return counts;
    }
    public void setCounts(@NotNull Collection<TagCount> counts)
    {
        this.counts = counts;
    }

    @NotNull
    public String toString()
    {
        return "TagCounts(" +
            " counts: " + getCounts() + ")";
    }

    @NotNull
    public TagCountsBuilder toBuilder()
    {
        return new TagCountsBuilder(getCounts());
    }
}