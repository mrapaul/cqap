package com.lakeland.ris.ui.datamodel;

import org.codehaus.jackson.annotate.*;
import org.jetbrains.annotations.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;


public class InstitutionOrderCount
{
    @NotNull private String institution;
    private int count;

    public InstitutionOrderCount()
    {
        // empty
    }

    @JsonCreator
    public InstitutionOrderCount(@NotNull String institution,
                                 int count)
    {
        super();

        this.institution = institution;
        this.count = count;
    }

    @NotNull
    public String getInstitution()
    {
        return institution;
    }

    public int getCount()
    {
        return count;
    }
    public void setInstitution(@NotNull String institution)
    {
        this.institution = institution;
    }

    public void setCount(int count)
    {
        this.count = count;
    }

    @NotNull
    public String toString()
    {
        return "InstitutionOrderCount(" +
            " institution: " + getInstitution() +
            " count: " + getCount() + ")";
    }

    @NotNull
    public InstitutionOrderCountBuilder toBuilder()
    {
        return new InstitutionOrderCountBuilder(getInstitution()).setCount(getCount());
    }
}