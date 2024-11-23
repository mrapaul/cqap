package com.lakeland.ris.ui.datamodel;


import java.util.*;
import com.lakeland.ris.datamodel.*;
import java.util.*;

public class InstitutionDayOrderCountsBuilder
{
    private Collection<InstitutionDayOrderCount> counts;

    public InstitutionDayOrderCountsBuilder(Collection<InstitutionDayOrderCount> counts)
    {
        super();

        this.counts = counts;
    }



    public InstitutionDayOrderCountsBuilder setCounts(Collection<InstitutionDayOrderCount> counts)
    {
        this.counts = counts;

        return self();
    }


    protected Collection<InstitutionDayOrderCount> getCounts()
    {
        return counts;
    }


    public InstitutionDayOrderCounts build()
    {
        return new InstitutionDayOrderCounts(getCounts());
    }



    protected InstitutionDayOrderCountsBuilder self()
    {
        return this;
    }
}