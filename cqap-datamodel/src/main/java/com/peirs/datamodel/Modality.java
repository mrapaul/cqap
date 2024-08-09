package com.peirs.datamodel;

public enum Modality
{
    CT("CT/SR"),
    NM("NM"),
    US("US"),
    XR("XR/CR/RF"),
    MR("MR"),
    XA("XA/IV"),
    MG("MG"),
    OTHER("OTHER");

    private final String theDescription;

    Modality(String aDescription)
    {
        theDescription = aDescription;
    }

    public String getDescription()
    {
        return theDescription;
    }


    @Override public String toString()
    {
        return theDescription;
    }
}
