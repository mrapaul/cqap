package com.lakeland.ris.ui.datamodel;

import org.jetbrains.annotations.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;


public class UserSessionBuilder
{
    @NotNull private String username;
    @NotNull private String iP;
    @NotNull private Date timestamp;

    public UserSessionBuilder(@NotNull String username,
                              @NotNull String iP,
                              @NotNull Date timestamp)
    {
        super();

        this.username = username;
        this.iP = iP;
        this.timestamp = timestamp;
    }


    @NotNull
    public UserSessionBuilder setUsername(@NotNull String username)
    {
        this.username = username;

        return self();
    }

    @NotNull
    public UserSessionBuilder setIP(@NotNull String iP)
    {
        this.iP = iP;

        return self();
    }

    @NotNull
    public UserSessionBuilder setTimestamp(@NotNull Date timestamp)
    {
        this.timestamp = timestamp;

        return self();
    }

    @NotNull
    protected String getUsername()
    {
        return username;
    }

    @NotNull
    protected String getIP()
    {
        return iP;
    }

    @NotNull
    protected Date getTimestamp()
    {
        return timestamp;
    }

    @NotNull
    public UserSession build()
    {
        return new UserSession(getUsername(),
                               getIP(),
                               getTimestamp());
    }


    @NotNull
    protected UserSessionBuilder self()
    {
        return this;
    }
}