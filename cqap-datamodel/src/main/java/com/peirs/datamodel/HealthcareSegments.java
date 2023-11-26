package com.peirs.datamodel;

import java.util.*;

public class HealthcareSegments
{
    private List<HealthcareSegment> theHealthcareSegments;

    public HealthcareSegments()
    {
        theHealthcareSegments = new ArrayList<>();
    }

    public HealthcareSegments(List<HealthcareSegment> aHealthcareSegments)
    {
        theHealthcareSegments = aHealthcareSegments;
    }

    public List<HealthcareSegment> getHealthcareSegments()
    {
        return theHealthcareSegments;
    }

    public void setHealthcareSegments(List<HealthcareSegment> aHealthcareSegments)
    {
        theHealthcareSegments = aHealthcareSegments;
    }
}
