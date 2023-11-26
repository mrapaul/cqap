package com.lakeland.ris.ui.datamodel;

import org.codehaus.jackson.annotate.*;
import org.jetbrains.annotations.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;
import java.util.*;

public class InstitutionDayOrderCount
{
    @NotNull private String institution;
    @NotNull private Collection<DayOrderCount> counts;

    public InstitutionDayOrderCount()
    {
        // empty
    }

    @JsonCreator
    public InstitutionDayOrderCount(@NotNull String institution,
                                    @NotNull Collection<DayOrderCount> counts)
    {
        super();

        this.institution = institution;
        this.counts = counts;
    }

    @NotNull
    public String getInstitution()
    {
        return institution;
    }

    @NotNull
    public Collection<DayOrderCount> getCounts()
    {
        return counts;
    }
    public void setInstitution(@NotNull String institution)
    {
        this.institution = institution;
    }

    public void setCounts(@NotNull Collection<DayOrderCount> counts)
    {
        this.counts = counts;
    }

    @NotNull
    public String toString()
    {
        return "InstitutionDayOrderCount(" +
            " institution: " + getInstitution() +
            " counts: " + getCounts() + ")";
    }

    @NotNull
    public InstitutionDayOrderCountBuilder toBuilder()
    {
        return new InstitutionDayOrderCountBuilder(getInstitution(),
                                                   getCounts());
    }
}