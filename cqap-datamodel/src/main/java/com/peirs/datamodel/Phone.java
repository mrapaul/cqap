package com.peirs.datamodel;

public class Phone
{
    private String theNumber;
    private boolean thePrimary;

    public boolean isPrimary()
    {
        return thePrimary;
    }

    public void setPrimary(boolean aPrimary)
    {
        thePrimary = aPrimary;
    }

    public String getNumber()
    {
        return theNumber;
    }

    public void setNumber(String aNumber)
    {
        theNumber = aNumber;
    }
}
