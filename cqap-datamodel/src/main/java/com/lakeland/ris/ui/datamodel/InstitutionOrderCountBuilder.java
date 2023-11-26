package com.lakeland.ris.ui.datamodel;

import org.jetbrains.annotations.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;


public class InstitutionOrderCountBuilder
{
    @NotNull private String institution;
    private int count;

    public InstitutionOrderCountBuilder(@NotNull String institution)
    {
        super();

        this.institution = institution;
    }


    @NotNull
    public InstitutionOrderCountBuilder setInstitution(@NotNull String institution)
    {
        this.institution = institution;

        return self();
    }

    @NotNull
    public InstitutionOrderCountBuilder setCount(int count)
    {
        this.count = count;

        return self();
    }

    @NotNull
    protected String getInstitution()
    {
        return institution;
    }

    protected int getCount()
    {
        return count;
    }

    @NotNull
    public InstitutionOrderCount build()
    {
        return new InstitutionOrderCount(getInstitution(),
                                         getCount());
    }


    @NotNull
    protected InstitutionOrderCountBuilder self()
    {
        return this;
    }
}