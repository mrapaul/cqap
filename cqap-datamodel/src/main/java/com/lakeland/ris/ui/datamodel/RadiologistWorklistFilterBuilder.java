package com.lakeland.ris.ui.datamodel;

import org.jetbrains.annotations.*;
import java.util.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;
import com.peirs.datamodel.*;
import java.util.*;

public class RadiologistWorklistFilterBuilder
{
    @NotNull private Collection<Institution> institutions;
    @NotNull private Collection<String> modalities;
    @NotNull private Collection<OrderPriority> priorities;

    public RadiologistWorklistFilterBuilder(@NotNull Collection<Institution> institutions,
                                            @NotNull Collection<String> modalities,
                                            @NotNull Collection<OrderPriority> priorities)
    {
        super();

        this.institutions = institutions;
        this.modalities = modalities;
        this.priorities = priorities;
    }


    @NotNull
    public RadiologistWorklistFilterBuilder setInstitutions(@NotNull Collection<Institution> institutions)
    {
        this.institutions = institutions;

        return self();
    }

    @NotNull
    public RadiologistWorklistFilterBuilder setModalities(@NotNull Collection<String> modalities)
    {
        this.modalities = modalities;

        return self();
    }

    @NotNull
    public RadiologistWorklistFilterBuilder setPriorities(@NotNull Collection<OrderPriority> priorities)
    {
        this.priorities = priorities;

        return self();
    }

    @NotNull
    protected Collection<Institution> getInstitutions()
    {
        return institutions;
    }

    @NotNull
    protected Collection<String> getModalities()
    {
        return modalities;
    }

    @NotNull
    protected Collection<OrderPriority> getPriorities()
    {
        return priorities;
    }

    @NotNull
    public RadiologistWorklistFilter build()
    {
        return new RadiologistWorklistFilter(getInstitutions(),
                                             getModalities(),
                                             getPriorities());
    }


    @NotNull
    protected RadiologistWorklistFilterBuilder self()
    {
        return this;
    }
}