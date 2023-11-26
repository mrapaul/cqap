package com.lakeland.ris.ui.datamodel;

import org.jetbrains.annotations.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;


public class TagCountBuilder
{
    @NotNull private String tag;
    private int count;

    public TagCountBuilder(@NotNull String tag)
    {
        super();

        this.tag = tag;
    }


    @NotNull
    public TagCountBuilder setTag(@NotNull String tag)
    {
        this.tag = tag;

        return self();
    }

    @NotNull
    public TagCountBuilder setCount(int count)
    {
        this.count = count;

        return self();
    }

    @NotNull
    protected String getTag()
    {
        return tag;
    }

    protected int getCount()
    {
        return count;
    }

    @NotNull
    public TagCount build()
    {
        return new TagCount(getTag(),
                            getCount());
    }


    @NotNull
    protected TagCountBuilder self()
    {
        return this;
    }
}