package com.lakeland.ris.ui.datamodel;

import org.jetbrains.annotations.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;
import java.util.*;

public class InstitutionDayOrderCountsBuilder
{
    @NotNull private Collection<InstitutionDayOrderCount> counts;

    public InstitutionDayOrderCountsBuilder(@NotNull Collection<InstitutionDayOrderCount> counts)
    {
        super();

        this.counts = counts;
    }


    @NotNull
    public InstitutionDayOrderCountsBuilder setCounts(@NotNull Collection<InstitutionDayOrderCount> counts)
    {
        this.counts = counts;

        return self();
    }

    @NotNull
    protected Collection<InstitutionDayOrderCount> getCounts()
    {
        return counts;
    }

    @NotNull
    public InstitutionDayOrderCounts build()
    {
        return new InstitutionDayOrderCounts(getCounts());
    }


    @NotNull
    protected InstitutionDayOrderCountsBuilder self()
    {
        return this;
    }
}