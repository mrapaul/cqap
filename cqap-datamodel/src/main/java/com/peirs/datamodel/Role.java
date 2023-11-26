package com.peirs.datamodel;

public enum Role
{
    CMO("Chief Medical Officer"),
    QAD("Quality ASsurance Director"),
    ERP("Expert Review Panel"),
    ETM("Executive Team Member"),
    SQAA("Site/Group QA Adminstrator"),
    SAR("Site/Group Administrator Radiologist "),
    SAT("Site/Group Administrator Technologist "),
    ST("Site Technologist"),
    PIR("Primary Interpreting Radiologist"),
    C("Clerk");
    private final String theDescription;

    private Role(String aDescription)
    {
        theDescription = aDescription;
    }

    public String getDescription()
    {
        return theDescription;
    }
}
