package com.lakeland.ris.ui.datamodel;

import org.codehaus.jackson.annotate.*;
import org.jetbrains.annotations.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;


public class TagCount
{
    @NotNull private String tag;
    private int count;

    public TagCount()
    {
        // empty
    }

    @JsonCreator
    public TagCount(@NotNull String tag,
                    int count)
    {
        super();

        this.tag = tag;
        this.count = count;
    }

    @NotNull
    public String getTag()
    {
        return tag;
    }

    public int getCount()
    {
        return count;
    }
    public void setTag(@NotNull String tag)
    {
        this.tag = tag;
    }

    public void setCount(int count)
    {
        this.count = count;
    }

    @NotNull
    public String toString()
    {
        return "TagCount(" +
            " tag: " + getTag() +
            " count: " + getCount() + ")";
    }

    @NotNull
    public TagCountBuilder toBuilder()
    {
        return new TagCountBuilder(getTag()).setCount(getCount());
    }
}