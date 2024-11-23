package com.lakeland.ris.ui.datamodel;

import org.codehaus.jackson.annotate.*;

import java.util.*;
import com.lakeland.ris.datamodel.*;


public class InstitutionOrderCount
{
    private String institution;
    private int count;

    public InstitutionOrderCount()
    {
        // empty
    }

    @JsonCreator
    public InstitutionOrderCount(String institution,
                                 int count)
    {
        super();

        this.institution = institution;
        this.count = count;
    }

    
    public String getInstitution()
    {
        return institution;
    }

    public int getCount()
    {
        return count;
    }
    public void setInstitution(String institution)
    {
        this.institution = institution;
    }

    public void setCount(int count)
    {
        this.count = count;
    }

    
    public String toString()
    {
        return "InstitutionOrderCount(" +
            " institution: " + getInstitution() +
            " count: " + getCount() + ")";
    }

    
    public InstitutionOrderCountBuilder toBuilder()
    {
        return new InstitutionOrderCountBuilder(getInstitution()).setCount(getCount());
    }
}