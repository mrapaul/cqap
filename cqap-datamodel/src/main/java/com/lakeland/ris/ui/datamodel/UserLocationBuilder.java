package com.lakeland.ris.ui.datamodel;


import java.util.*;
import com.lakeland.ris.datamodel.*;


public class UserLocationBuilder
{
    private String username;
    private String locationCode;
    private String description;
    private String address;

    public UserLocationBuilder(String username,
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


    
    public UserLocationBuilder setUsername(String username)
    {
        this.username = username;

        return self();
    }

    
    public UserLocationBuilder setLocationCode(String locationCode)
    {
        this.locationCode = locationCode;

        return self();
    }

    
    public UserLocationBuilder setDescription(String description)
    {
        this.description = description;

        return self();
    }

    
    public UserLocationBuilder setAddress(String address)
    {
        this.address = address;

        return self();
    }

    
    protected String getUsername()
    {
        return username;
    }

    
    protected String getLocationCode()
    {
        return locationCode;
    }

    
    protected String getDescription()
    {
        return description;
    }

    
    protected String getAddress()
    {
        return address;
    }

    
    public UserLocation build()
    {
        return new UserLocation(getUsername(),
                                getLocationCode(),
                                getDescription(),
                                getAddress());
    }


    
    protected UserLocationBuilder self()
    {
        return this;
    }
}