package com.peirs.datamodel;

import java.util.*;

public class Institutions
{
    private List<Institution> theInstitutions;

    public Institutions()
    {
        theInstitutions = new ArrayList<>();
    }

    public Institutions(List<Institution> aInstitutions)
    {
        theInstitutions = aInstitutions;
    }

    public List<Institution> getInstitutions()
    {
        return theInstitutions;
    }

    public void setInstitutions(List<Institution> aInstitutions)
    {
        theInstitutions = aInstitutions;
    }
}
