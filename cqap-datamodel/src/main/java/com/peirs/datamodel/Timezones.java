package com.peirs.datamodel;

import java.util.*;

public class Timezones
{
    private Set<String> theTimezones;

    public Timezones()
    {
        theTimezones = new HashSet<>();
    }

    public Timezones(Set<String> aTimezones)
    {
        theTimezones = aTimezones;
    }

    public Set<String> getTimezones()
    {
        return theTimezones;
    }

    public void setTimezones(Set<String> aTimezones)
    {
        theTimezones = aTimezones;
    }
}
