package com.peirs.datamodel;

public class NotificationPreference
{
    private boolean theAll;
    private boolean theCategory;
    private boolean theRT;
    private boolean theUR;
    private boolean thePR;
    private boolean theTR;
    private boolean theAFFS;

    public boolean isAll()
    {
        return theAll;
    }

    public void setAll(boolean aAll)
    {
        theAll = aAll;
    }

    public boolean isCategory()
    {
        return theCategory;
    }

    public void setCategory(boolean aCategory)
    {
        theCategory = aCategory;
    }

    public boolean isRT()
    {
        return theRT;
    }

    public void setRT(boolean aRT)
    {
        theRT = aRT;
    }

    public boolean isUR()
    {
        return theUR;
    }

    public void setUR(boolean aUR)
    {
        theUR = aUR;
    }

    public boolean isPR()
    {
        return thePR;
    }

    public void setPR(boolean aPR)
    {
        thePR = aPR;
    }

    public boolean isTR()
    {
        return theTR;
    }

    public void setTR(boolean aTR)
    {
        theTR = aTR;
    }

    public boolean isAFFS()
    {
        return theAFFS;
    }

    public void setAFFS(boolean aAFFS)
    {
        theAFFS = aAFFS;
    }
}
