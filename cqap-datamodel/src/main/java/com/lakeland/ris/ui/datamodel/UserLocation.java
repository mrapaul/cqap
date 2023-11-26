package com.lakeland.ris.ui.datamodel;

import org.codehaus.jackson.annotate.*;
import org.jetbrains.annotations.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;


public class UserLocation
{
    @NotNull private String username;
    @NotNull private String locationCode;
    @NotNull private String description;
    @NotNull private String address;

    public UserLocation()
    {
        // empty
    }

    @JsonCreator
    public UserLocation(@NotNull String username,
                        @NotNull String locationCode,
                        @NotNull String description,
                        @NotNull String address)
    {
        super();

        this.username = username;
        this.locationCode = locationCode;
        this.description = description;
        this.address = address;
    }

    @NotNull
    public String getUsername()
    {
        return username;
    }

    @NotNull
    public String getLocationCode()
    {
        return locationCode;
    }

    @NotNull
    public String getDescription()
    {
        return description;
    }

    @NotNull
    public String getAddress()
    {
        return address;
    }
    public void setUsername(@NotNull String username)
    {
        this.username = username;
    }

    public void setLocationCode(@NotNull String locationCode)
    {
        this.locationCode = locationCode;
    }

    public void setDescription(@NotNull String description)
    {
        this.description = description;
    }

    public void setAddress(@NotNull String address)
    {
        this.address = address;
    }

    @NotNull
    public String toString()
    {
        return "UserLocation(" +
            " username: " + getUsername() +
            " locationCode: " + getLocationCode() +
            " description: " + getDescription() +
            " address: " + getAddress() + ")";
    }

    @NotNull
    public UserLocationBuilder toBuilder()
    {
        return new UserLocationBuilder(getUsername(),
                                       getLocationCode(),
                                       getDescription(),
                                       getAddress());
    }
}