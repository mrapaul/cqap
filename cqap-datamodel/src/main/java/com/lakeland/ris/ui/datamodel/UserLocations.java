package com.lakeland.ris.ui.datamodel;

import org.codehaus.jackson.annotate.*;
import org.jetbrains.annotations.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;
import java.util.*;

public class UserLocations
{
    @NotNull private Collection<UserLocation> locations;

    public UserLocations()
    {
        // empty
    }

    @JsonCreator
    public UserLocations(@NotNull Collection<UserLocation> locations)
    {
        super();

        this.locations = locations;
    }

    @NotNull
    public Collection<UserLocation> getLocations()
    {
        return locations;
    }
    public void setLocations(@NotNull Collection<UserLocation> locations)
    {
        this.locations = locations;
    }

    @NotNull
    public String toString()
    {
        return "UserLocations(" +
            " locations: " + getLocations() + ")";
    }

    @NotNull
    public UserLocationsBuilder toBuilder()
    {
        return new UserLocationsBuilder(getLocations());
    }
}