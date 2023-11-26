package com.peirs.datamodel;

public class CompletedNotification
{
    private boolean theFax;
    private boolean theEmail;

    public boolean isFax()
    {
        return theFax;
    }

    public void setFax(boolean aFax)
    {
        theFax = aFax;
    }

    public boolean isEmail()
    {
        return theEmail;
    }

    public void setEmail(boolean aEmail)
    {
        theEmail = aEmail;
    }
}
