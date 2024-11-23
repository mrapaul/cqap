package com.lakeland.ris.ui.datamodel;

import org.codehaus.jackson.annotate.*;

import java.util.*;
import com.lakeland.ris.datamodel.*;
import java.util.*;

public class InstitutionDayOrderCounts
{
    private Collection<InstitutionDayOrderCount> counts;

    public InstitutionDayOrderCounts()
    {
        // empty
    }

    @JsonCreator
    public InstitutionDayOrderCounts(Collection<InstitutionDayOrderCount> counts)
    {
        super();

        this.counts = counts;
    }


    public Collection<InstitutionDayOrderCount> getCounts()
    {
        return counts;
    }
    public void setCounts(Collection<InstitutionDayOrderCount> counts)
    {
        this.counts = counts;
    }


    public String toString()
    {
        return "InstitutionDayOrderCounts(" +
            " counts: " + getCounts() + ")";
    }


    public InstitutionDayOrderCountsBuilder toBuilder()
    {
        return new InstitutionDayOrderCountsBuilder(getCounts());
    }
}