package com.lakeland.ris.ui.datamodel;

import org.jetbrains.annotations.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;


public class UserOrderCountBuilder
{
    @NotNull private String user;
    private int count;

    public UserOrderCountBuilder(@NotNull String user)
    {
        super();

        this.user = user;
    }


    @NotNull
    public UserOrderCountBuilder setUser(@NotNull String user)
    {
        this.user = user;

        return self();
    }

    @NotNull
    public UserOrderCountBuilder setCount(int count)
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
    public UserOrderCount build()
    {
        return new UserOrderCount(getUser(),
                                  getCount());
    }


    @NotNull
    protected UserOrderCountBuilder self()
    {
        return this;
    }
}