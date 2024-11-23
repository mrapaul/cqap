package com.lakeland.ris.ui.datamodel;


import java.util.*;
import com.lakeland.ris.datamodel.*;


public class UserOrderCountBuilder
{
    private String user;
    private int count;

    public UserOrderCountBuilder(String user)
    {
        super();

        this.user = user;
    }


    
    public UserOrderCountBuilder setUser(String user)
    {
        this.user = user;

        return self();
    }

    
    public UserOrderCountBuilder setCount(int count)
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

    
    public UserOrderCount build()
    {
        return new UserOrderCount(getUser(),
                                  getCount());
    }


    
    protected UserOrderCountBuilder self()
    {
        return this;
    }
}