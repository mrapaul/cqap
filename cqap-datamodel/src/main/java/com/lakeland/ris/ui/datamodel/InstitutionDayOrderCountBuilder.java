package com.lakeland.ris.ui.datamodel;

import org.jetbrains.annotations.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;
import java.util.*;

public class InstitutionDayOrderCountBuilder
{
    @NotNull private String institution;
    @NotNull private Collection<DayOrderCount> counts;

    public InstitutionDayOrderCountBuilder(@NotNull String institution,
                                           @NotNull Collection<DayOrderCount> counts)
    {
        super();

        this.institution = institution;
        this.counts = counts;
    }


    @NotNull
    public InstitutionDayOrderCountBuilder setInstitution(@NotNull String institution)
    {
        this.institution = institution;

        return self();
    }

    @NotNull
    public InstitutionDayOrderCountBuilder setCounts(@NotNull Collection<DayOrderCount> counts)
    {
        this.counts = counts;

        return self();
    }

    @NotNull
    protected String getInstitution()
    {
        return institution;
    }

    @NotNull
    protected Collection<DayOrderCount> getCounts()
    {
        return counts;
    }

    @NotNull
    public InstitutionDayOrderCount build()
    {
        return new InstitutionDayOrderCount(getInstitution(),
                                            getCounts());
    }


    @NotNull
    protected InstitutionDayOrderCountBuilder self()
    {
        return this;
    }
}