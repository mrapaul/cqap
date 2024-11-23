package com.lakeland.ris.ui.datamodel;

import org.codehaus.jackson.annotate.*;

import java.util.*;
import com.lakeland.ris.datamodel.*;


public class UserLocation
{
    private String username;
    private String locationCode;
    private String description;
    private String address;

    public UserLocation()
    {
        // empty
    }

    @JsonCreator
    public UserLocation(String username,
                        String locationCode,
                        String description,
                        String address)
    {
        super();

        this.username = username;
        this.locationCode = locationCode;
        this.description = description;
        this.address = address;
    }


    public String getUsername()
    {
        return username;
    }


    public String getLocationCode()
    {
        return locationCode;
    }


    public String getDescription()
    {
        return description;
    }


    public String getAddress()
    {
        return address;
    }
    public void setUsername(String username)
    {
        this.username = username;
    }

    public void setLocationCode(String locationCode)
    {
        this.locationCode = locationCode;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }


    public String toString()
    {
        return "UserLocation(" +
            " username: " + getUsername() +
            " locationCode: " + getLocationCode() +
            " description: " + getDescription() +
            " address: " + getAddress() + ")";
    }


    public UserLocationBuilder toBuilder()
    {
        return new UserLocationBuilder(getUsername(),
                                       getLocationCode(),
                                       getDescription(),
                                       getAddress());
    }
}