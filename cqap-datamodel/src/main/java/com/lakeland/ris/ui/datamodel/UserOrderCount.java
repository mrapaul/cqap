package com.lakeland.ris.ui.datamodel;

import org.codehaus.jackson.annotate.*;

import java.util.*;
import com.lakeland.ris.datamodel.*;


public class UserOrderCount
{
    private String user;
    private int count;

    public UserOrderCount()
    {
        // empty
    }

    @JsonCreator
    public UserOrderCount(String user,
                          int count)
    {
        super();

        this.user = user;
        this.count = count;
    }

    
    public String getUser()
    {
        return user;
    }

    public int getCount()
    {
        return count;
    }
    public void setUser(String user)
    {
        this.user = user;
    }

    public void setCount(int count)
    {
        this.count = count;
    }

    
    public String toString()
    {
        return "UserOrderCount(" +
            " user: " + getUser() +
            " count: " + getCount() + ")";
    }

    
    public UserOrderCountBuilder toBuilder()
    {
        return new UserOrderCountBuilder(getUser()).setCount(getCount());
    }
}