package com.lakeland.ris.ui.datamodel;

import org.jetbrains.annotations.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;
import java.util.*;

public class TagCountsBuilder
{
    @NotNull private Collection<TagCount> counts;

    public TagCountsBuilder(@NotNull Collection<TagCount> counts)
    {
        super();

        this.counts = counts;
    }


    @NotNull
    public TagCountsBuilder setCounts(@NotNull Collection<TagCount> counts)
    {
        this.counts = counts;

        return self();
    }

    @NotNull
    protected Collection<TagCount> getCounts()
    {
        return counts;
    }

    @NotNull
    public TagCounts build()
    {
        return new TagCounts(getCounts());
    }


    @NotNull
    protected TagCountsBuilder self()
    {
        return this;
    }
}