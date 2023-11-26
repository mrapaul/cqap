package com.lakeland.ris.ui.datamodel;

import org.codehaus.jackson.annotate.*;
import org.jetbrains.annotations.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;


public class UserOrderCount
{
    @NotNull private String user;
    private int count;

    public UserOrderCount()
    {
        // empty
    }

    @JsonCreator
    public UserOrderCount(@NotNull String user,
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
        return "UserOrderCount(" +
            " user: " + getUser() +
            " count: " + getCount() + ")";
    }

    @NotNull
    public UserOrderCountBuilder toBuilder()
    {
        return new UserOrderCountBuilder(getUser()).setCount(getCount());
    }
}