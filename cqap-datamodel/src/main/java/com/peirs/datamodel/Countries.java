package com.peirs.datamodel;

import java.util.*;

public class Countries
{
    private List<Country> theCountries;

    public Countries()
    {
        theCountries = new ArrayList<>();
    }

    public Countries(List<Country> aCountries)
    {
        theCountries = aCountries;
    }

    public List<Country> getCountries()
    {
        return theCountries;
    }

    public void setCountries(List<Country> aCountries)
    {
        theCountries = aCountries;
    }
}
