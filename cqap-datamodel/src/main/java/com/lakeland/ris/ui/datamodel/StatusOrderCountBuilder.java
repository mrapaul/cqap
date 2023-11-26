package com.lakeland.ris.ui.datamodel;

import org.jetbrains.annotations.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;


public class StatusOrderCountBuilder
{
    @NotNull private String user;
    private int count;

    public StatusOrderCountBuilder(@NotNull String user)
    {
        super();

        this.user = user;
    }


    @NotNull
    public StatusOrderCountBuilder setUser(@NotNull String user)
    {
        this.user = user;

        return self();
    }

    @NotNull
    public StatusOrderCountBuilder setCount(int count)
    {
        this.count = count;

        return self();
    }

    @NotNull
    protected String getUser()
    {
        return user;
    }

    protected int getCount()
    {
        return count;
    }

    @NotNull
    public StatusOrderCount build()
    {
        return new StatusOrderCount(getUser(),
                                    getCount());
    }


    @NotNull
    protected StatusOrderCountBuilder self()
    {
        return this;
    }
}