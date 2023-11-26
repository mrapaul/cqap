package com.lakeland.ris.ui.datamodel;

import org.codehaus.jackson.annotate.*;
import org.jetbrains.annotations.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;
import java.util.*;

public class InstitutionDayOrderCounts
{
    @NotNull private Collection<InstitutionDayOrderCount> counts;

    public InstitutionDayOrderCounts()
    {
        // empty
    }

    @JsonCreator
    public InstitutionDayOrderCounts(@NotNull Collection<InstitutionDayOrderCount> counts)
    {
        super();

        this.counts = counts;
    }

    @NotNull
    public Collection<InstitutionDayOrderCount> getCounts()
    {
        return counts;
    }
    public void setCounts(@NotNull Collection<InstitutionDayOrderCount> counts)
    {
        this.counts = counts;
    }

    @NotNull
    public String toString()
    {
        return "InstitutionDayOrderCounts(" +
            " counts: " + getCounts() + ")";
    }

    @NotNull
    public InstitutionDayOrderCountsBuilder toBuilder()
    {
        return new InstitutionDayOrderCountsBuilder(getCounts());
    }
}