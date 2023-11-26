package com.lakeland.ris.ui.datamodel;

import org.codehaus.jackson.annotate.*;
import org.jetbrains.annotations.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;


public class StatusOrderCount
{
    @NotNull private String user;
    private int count;

    public StatusOrderCount()
    {
        // empty
    }

    @JsonCreator
    public StatusOrderCount(@NotNull String user,
                            int count)
    {
        super();

        this.user = user;
        this.count = count;
    }

    @NotNull
    public String getUser()
    {
        return user;
    }

    public int getCount()
    {
        return count;
    }
    public void setUser(@NotNull String user)
    {
        this.user = user;
    }

    public void setCount(int count)
    {
        this.count = count;
    }

    @NotNull
    public String toString()
    {
        return "StatusOrderCount(" +
            " user: " + getUser() +
            " count: " + getCount() + ")";
    }

    @NotNull
    public StatusOrderCountBuilder toBuilder()
    {
        return new StatusOrderCountBuilder(getUser()).setCount(getCount());
    }
}