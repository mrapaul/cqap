package com.lakeland.ris.ui.datamodel;


import java.util.*;
import com.lakeland.ris.datamodel.*;


public class StatusOrderCountBuilder
{
    private String user;
    private int count;

    public StatusOrderCountBuilder(String user)
    {
        super();

        this.user = user;
    }



    public StatusOrderCountBuilder setUser(String user)
    {
        this.user = user;

        return self();
    }


    public StatusOrderCountBuilder setCount(int count)
    {
        this.count = count;

        return self();
    }


    protected String getUser()
    {
        return user;
    }

    protected int getCount()
    {
        return count;
    }


    public StatusOrderCount build()
    {
        return new StatusOrderCount(getUser(),
                                    getCount());
    }



    protected StatusOrderCountBuilder self()
    {
        return this;
    }
}