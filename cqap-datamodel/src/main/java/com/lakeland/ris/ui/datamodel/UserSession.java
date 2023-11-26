package com.lakeland.ris.ui.datamodel;

import org.codehaus.jackson.annotate.*;
import org.jetbrains.annotations.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;


public class UserSession
{
    @NotNull private String username;
    @NotNull private String iP;
    @NotNull private Date timestamp;

    public UserSession()
    {
        // empty
    }

    @JsonCreator
    public UserSession(@NotNull String username,
                       @NotNull String iP,
                       @NotNull Date timestamp)
    {
        super();

        this.username = username;
        this.iP = iP;
        this.timestamp = timestamp;
    }

    @NotNull
    public String getUsername()
    {
        return username;
    }

    @NotNull
    public String getIP()
    {
        return iP;
    }

    @NotNull
    public Date getTimestamp()
    {
        return timestamp;
    }
    public void setUsername(@NotNull String username)
    {
        this.username = username;
    }

    public void setIP(@NotNull String iP)
    {
        this.iP = iP;
    }

    public void setTimestamp(@NotNull Date timestamp)
    {
        this.timestamp = timestamp;
    }

    @NotNull
    public String toString()
    {
        return "UserSession(" +
            " username: " + getUsername() +
            " iP: " + getIP() +
            " timestamp: " + getTimestamp() + ")";
    }

    @NotNull
    public UserSessionBuilder toBuilder()
    {
        return new UserSessionBuilder(getUsername(),
                                      getIP(),
                                      getTimestamp());
    }
}