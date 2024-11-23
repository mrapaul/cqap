package com.lakeland.ris.ui.datamodel;


import java.util.*;
import com.lakeland.ris.datamodel.*;


public class InstitutionOrderCountBuilder
{
    private String institution;
    private int count;

    public InstitutionOrderCountBuilder(String institution)
    {
        super();

        this.institution = institution;
    }


    
    public InstitutionOrderCountBuilder setInstitution(String institution)
    {
        this.institution = institution;

        return self();
    }

    
    public InstitutionOrderCountBuilder setCount(int count)
    {
        this.count = count;

        return self();
    }

    
    protected String getInstitution()
    {
        return institution;
    }

    protected int getCount()
    {
        return count;
    }

    
    public InstitutionOrderCount build()
    {
        return new InstitutionOrderCount(getInstitution(),
                                         getCount());
    }


    
    protected InstitutionOrderCountBuilder self()
    {
        return this;
    }
}