package com.peirs.datamodel;

import org.springframework.data.mongodb.core.mapping.*;

@Document(collection = "HealthcareSegments")
public class HealthcareSegment
{
    String theName;

    public String getName()
    {
        return theName;
    }

    public void setName(String aName)
    {
        theName = aName;
    }
}
