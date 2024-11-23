package com.lakeland.ris.ui.datamodel;


import java.util.*;
import com.lakeland.ris.datamodel.*;
import java.util.*;

public class InstitutionDayOrderCountBuilder
{
    private String institution;
    private Collection<DayOrderCount> counts;

    public InstitutionDayOrderCountBuilder(String institution,
                                           Collection<DayOrderCount> counts)
    {
        super();

        this.institution = institution;
        this.counts = counts;
    }



    public InstitutionDayOrderCountBuilder setInstitution(String institution)
    {
        this.institution = institution;

        return self();
    }


    public InstitutionDayOrderCountBuilder setCounts(Collection<DayOrderCount> counts)
    {
        this.counts = counts;

        return self();
    }


    protected String getInstitution()
    {
        return institution;
    }


    protected Collection<DayOrderCount> getCounts()
    {
        return counts;
    }


    public InstitutionDayOrderCount build()
    {
        return new InstitutionDayOrderCount(getInstitution(),
                                            getCounts());
    }



    protected InstitutionDayOrderCountBuilder self()
    {
        return this;
    }
}