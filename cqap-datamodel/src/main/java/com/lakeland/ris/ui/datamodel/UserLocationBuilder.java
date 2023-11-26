package com.lakeland.ris.ui.datamodel;

import org.jetbrains.annotations.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;


public class UserLocationBuilder
{
    @NotNull private String username;
    @NotNull private String locationCode;
    @NotNull private String description;
    @NotNull private String address;

    public UserLocationBuilder(@NotNull String username,
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
    public UserLocationBuilder setUsername(@NotNull String username)
    {
        this.username = username;

        return self();
    }

    @NotNull
    public UserLocationBuilder setLocationCode(@NotNull String locationCode)
    {
        this.locationCode = locationCode;

        return self();
    }

    @NotNull
    public UserLocationBuilder setDescription(@NotNull String description)
    {
        this.description = description;

        return self();
    }

    @NotNull
    public UserLocationBuilder setAddress(@NotNull String address)
    {
        this.address = address;

        return self();
    }

    @NotNull
    protected String getUsername()
    {
        return username;
    }

    @NotNull
    protected String getLocationCode()
    {
        return locationCode;
    }

    @NotNull
    protected String getDescription()
    {
        return description;
    }

    @NotNull
    protected String getAddress()
    {
        return address;
    }

    @NotNull
    public UserLocation build()
    {
        return new UserLocation(getUsername(),
                                getLocationCode(),
                                getDescription(),
                                getAddress());
    }


    @NotNull
    protected UserLocationBuilder self()
    {
        return this;
    }
}