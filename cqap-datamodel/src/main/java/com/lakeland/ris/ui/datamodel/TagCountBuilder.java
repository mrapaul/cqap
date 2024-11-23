package com.lakeland.ris.ui.datamodel;


import java.util.*;
import com.lakeland.ris.datamodel.*;


public class TagCountBuilder
{
    private String tag;
    private int count;

    public TagCountBuilder(String tag)
    {
        super();

        this.tag = tag;
    }



    public TagCountBuilder setTag(String tag)
    {
        this.tag = tag;

        return self();
    }


    public TagCountBuilder setCount(int count)
    {
        this.count = count;

        return self();
    }


    protected String getTag()
    {
        return tag;
    }

    protected int getCount()
    {
        return count;
    }


    public TagCount build()
    {
        return new TagCount(getTag(),
                            getCount());
    }



    protected TagCountBuilder self()
    {
        return this;
    }
}