package com.lakeland.ris.ui.datamodel;

import org.codehaus.jackson.annotate.*;

import java.util.*;
import com.lakeland.ris.datamodel.*;
import java.util.*;

public class UserLocations
{
    private Collection<UserLocation> locations;

    public UserLocations()
    {
        // empty
    }

    @JsonCreator
    public UserLocations(Collection<UserLocation> locations)
    {
        super();

        this.locations = locations;
    }


    public Collection<UserLocation> getLocations()
    {
        return locations;
    }
    public void setLocations(Collection<UserLocation> locations)
    {
        this.locations = locations;
    }


    public String toString()
    {
        return "UserLocations(" +
            " locations: " + getLocations() + ")";
    }


    public UserLocationsBuilder toBuilder()
    {
        return new UserLocationsBuilder(getLocations());
    }
}