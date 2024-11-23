package com.lakeland.ris.ui.datamodel;

import org.codehaus.jackson.annotate.*;

import java.util.*;
import com.lakeland.ris.datamodel.*;
import java.util.*;

public class InstitutionDayOrderCount
{
    private String institution;
    private Collection<DayOrderCount> counts;

    public InstitutionDayOrderCount()
    {
        // empty
    }

    @JsonCreator
    public InstitutionDayOrderCount(String institution,
                                    Collection<DayOrderCount> counts)
    {
        super();

        this.institution = institution;
        this.counts = counts;
    }


    public String getInstitution()
    {
        return institution;
    }


    public Collection<DayOrderCount> getCounts()
    {
        return counts;
    }
    public void setInstitution(String institution)
    {
        this.institution = institution;
    }

    public void setCounts(Collection<DayOrderCount> counts)
    {
        this.counts = counts;
    }


    public String toString()
    {
        return "InstitutionDayOrderCount(" +
            " institution: " + getInstitution() +
            " counts: " + getCounts() + ")";
    }


    public InstitutionDayOrderCountBuilder toBuilder()
    {
        return new InstitutionDayOrderCountBuilder(getInstitution(),
                                                   getCounts());
    }
}