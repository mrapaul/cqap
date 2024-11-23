package com.lakeland.ris.ui.datamodel;


import java.util.*;
import com.lakeland.ris.datamodel.*;
import java.util.*;

public class UserLocationsBuilder
{
    private Collection<UserLocation> locations;

    public UserLocationsBuilder(Collection<UserLocation> locations)
    {
        super();

        this.locations = locations;
    }



    public UserLocationsBuilder setLocations(Collection<UserLocation> locations)
    {
        this.locations = locations;

        return self();
    }


    protected Collection<UserLocation> getLocations()
    {
        return locations;
    }


    public UserLocations build()
    {
        return new UserLocations(getLocations());
    }



    protected UserLocationsBuilder self()
    {
        return this;
    }
}