package com.lakeland.ris.ui.datamodel;

import org.codehaus.jackson.annotate.*;

import java.util.*;
import com.lakeland.ris.datamodel.*;


public class StatusOrderCount
{
    private String user;
    private int count;

    public StatusOrderCount()
    {
        // empty
    }

    @JsonCreator
    public StatusOrderCount(String user,
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
        return "StatusOrderCount(" +
            " user: " + getUser() +
            " count: " + getCount() + ")";
    }

    
    public StatusOrderCountBuilder toBuilder()
    {
        return new StatusOrderCountBuilder(getUser()).setCount(getCount());
    }
}