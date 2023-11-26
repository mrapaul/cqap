package com.peirs.datamodel;

public class Email
{
    private String theAddress;
    private boolean thePrimary;

    public String getAddress()
    {
        return theAddress;
    }

    public void setAddress(String aAddress)
    {
        theAddress = aAddress;
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
