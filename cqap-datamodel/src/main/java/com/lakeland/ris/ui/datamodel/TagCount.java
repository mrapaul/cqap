package com.lakeland.ris.ui.datamodel;

import org.codehaus.jackson.annotate.*;

import java.util.*;
import com.lakeland.ris.datamodel.*;


public class TagCount
{
    private String tag;
    private int count;

    public TagCount()
    {
        // empty
    }

    @JsonCreator
    public TagCount(String tag,
                    int count)
    {
        super();

        this.tag = tag;
        this.count = count;
    }


    public String getTag()
    {
        return tag;
    }

    public int getCount()
    {
        return count;
    }
    public void setTag(String tag)
    {
        this.tag = tag;
    }

    public void setCount(int count)
    {
        this.count = count;
    }


    public String toString()
    {
        return "TagCount(" +
            " tag: " + getTag() +
            " count: " + getCount() + ")";
    }


    public TagCountBuilder toBuilder()
    {
        return new TagCountBuilder(getTag()).setCount(getCount());
    }
}