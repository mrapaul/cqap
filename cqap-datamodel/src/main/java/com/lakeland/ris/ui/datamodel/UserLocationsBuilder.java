package com.lakeland.ris.ui.datamodel;

import org.jetbrains.annotations.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;
import java.util.*;

public class UserLocationsBuilder
{
    @NotNull private Collection<UserLocation> locations;

    public UserLocationsBuilder(@NotNull Collection<UserLocation> locations)
    {
        super();

        this.locations = locations;
    }


    @NotNull
    public UserLocationsBuilder setLocations(@NotNull Collection<UserLocation> locations)
    {
        this.locations = locations;

        return self();
    }

    @NotNull
    protected Collection<UserLocation> getLocations()
    {
        return locations;
    }

    @NotNull
    public UserLocations build()
    {
        return new UserLocations(getLocations());
    }


    @NotNull
    protected UserLocationsBuilder self()
    {
        return this;
    }
}