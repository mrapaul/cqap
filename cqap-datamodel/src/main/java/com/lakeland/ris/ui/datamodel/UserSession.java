package com.lakeland.ris.ui.datamodel;

import org.codehaus.jackson.annotate.*;

import java.util.*;
import com.lakeland.ris.datamodel.*;


public class UserSession
{
    private String username;
    private String iP;
    private Date timestamp;

    public UserSession()
    {
        // empty
    }

    @JsonCreator
    public UserSession(String username,
                       String iP,
                       Date timestamp)
    {
        super();

        this.username = username;
        this.iP = iP;
        this.timestamp = timestamp;
    }


    public String getUsername()
    {
        return username;
    }


    public String getIP()
    {
        return iP;
    }


    public Date getTimestamp()
    {
        return timestamp;
    }
    public void setUsername(String username)
    {
        this.username = username;
    }

    public void setIP(String iP)
    {
        this.iP = iP;
    }

    public void setTimestamp(Date timestamp)
    {
        this.timestamp = timestamp;
    }


    public String toString()
    {
        return "UserSession(" +
            " username: " + getUsername() +
            " iP: " + getIP() +
            " timestamp: " + getTimestamp() + ")";
    }


    public UserSessionBuilder toBuilder()
    {
        return new UserSessionBuilder(getUsername(),
                                      getIP(),
                                      getTimestamp());
    }
}