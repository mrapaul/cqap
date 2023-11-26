package com.peirs.datamodel;

public class Country
{
    private String theName;
    private String theCode;
    private String theTimezone;

    public Country()
    {
        // empty
    }

    public Country(String aName, String aCode, String aTimezone)
    {
        theName = aName;
        theCode = aCode;
        theTimezone = aTimezone;
    }

    public String getName()
    {
        return theName;
    }

    public String getCode()
    {
        return theCode;
    }

    public String getTimezone()
    {
        return theTimezone;
    }

    public void setName(String aName)
    {
        theName = aName;
    }

    public void setCode(String aCode)
    {
        theCode = aCode;
    }

    public void setTimezone(String aTimezone)
    {
        theTimezone = aTimezone;
    }

    @Override public String toString()
    {
        return theName;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
        {
            return true;
        }
        if (o == null || getClass() != o.getClass())
        {
            return false;
        }

        Country myCountry = (Country) o;

        if (theCode != null ? !theCode.equals(myCountry.theCode) : myCountry.theCode != null)
        {
            return false;
        }
        if (theName != null ? !theName.equals(myCountry.theName) : myCountry.theName != null)
        {
            return false;
        }
        if (theTimezone != null ? !theTimezone.equals(myCountry.theTimezone) : myCountry.theTimezone != null)
        {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode()
    {
        int myresult = theName != null ? theName.hashCode() : 0;
        myresult = 31 * myresult + (theCode != null ? theCode.hashCode() : 0);
        myresult = 31 * myresult + (theTimezone != null ? theTimezone.hashCode() : 0);
        return myresult;
    }
}
