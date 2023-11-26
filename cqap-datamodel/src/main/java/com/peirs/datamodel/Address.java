package com.peirs.datamodel;

public class Address
{
    private String theAddress;
    private String theAddress1;
    private String theCity;
    private String theState;
    private String theZipcode;
    private Country theCountry;
    private String theTimeZone;
    private boolean thePrimary;

    public String getAddress()
    {
        return theAddress;
    }

    public void setAddress(String aAddress)
    {
        theAddress = aAddress;
    }

    public String getAddress1()
    {
        return theAddress1;
    }

    public void setAddress1(String aAddress1)
    {
        theAddress1 = aAddress1;
    }

    public String getCity()
    {
        return theCity;
    }

    public void setCity(String aCity)
    {
        theCity = aCity;
    }

    public String getState()
    {
        return theState;
    }

    public void setState(String aState)
    {
        theState = aState;
    }

    public String getZipcode()
    {
        return theZipcode;
    }

    public void setZipcode(String aZipcode)
    {
        theZipcode = aZipcode;
    }

    public Country getCountry()
    {
        return theCountry;
    }

    public void setCountry(Country aCountry)
    {
        theCountry = aCountry;
    }

    public String getTimeZone()
    {
        return theTimeZone;
    }

    public void setTimeZone(String aTimeZone)
    {
        theTimeZone = aTimeZone;
    }

    public boolean isPrimary()
    {
        return thePrimary;
    }

    public void setPrimary(boolean aPrimary)
    {
        thePrimary = aPrimary;
    }
}
