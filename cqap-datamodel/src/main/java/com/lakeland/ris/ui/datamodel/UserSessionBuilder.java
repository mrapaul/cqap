package com.lakeland.ris.ui.datamodel;


import java.util.*;
import com.lakeland.ris.datamodel.*;


public class UserSessionBuilder
{
    private String username;
    private String iP;
    private Date timestamp;

    public UserSessionBuilder(String username,
                              String iP,
                              Date timestamp)
    {
        super();

        this.username = username;
        this.iP = iP;
        this.timestamp = timestamp;
    }


    
    public UserSessionBuilder setUsername(String username)
    {
        this.username = username;

        return self();
    }

    
    public UserSessionBuilder setIP(String iP)
    {
        this.iP = iP;

        return self();
    }

    
    public UserSessionBuilder setTimestamp(Date timestamp)
    {
        this.timestamp = timestamp;

        return self();
    }

    
    protected String getUsername()
    {
        return username;
    }

    
    protected String getIP()
    {
        return iP;
    }

    
    protected Date getTimestamp()
    {
        return timestamp;
    }

    
    public UserSession build()
    {
        return new UserSession(getUsername(),
                               getIP(),
                               getTimestamp());
    }


    
    protected UserSessionBuilder self()
    {
        return this;
    }
}