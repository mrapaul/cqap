package com.lakeland.ris.ui.datamodel;


import java.util.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;
import com.peirs.datamodel.*;
import java.util.*;

public class RadiologistWorklistFilterBuilder
{
    private Collection<Institution> institutions;
    private Collection<String> modalities;
    private Collection<OrderPriority> priorities;

    public RadiologistWorklistFilterBuilder(Collection<Institution> institutions,
                                            Collection<String> modalities,
                                            Collection<OrderPriority> priorities)
    {
        super();

        this.institutions = institutions;
        this.modalities = modalities;
        this.priorities = priorities;
    }


    
    public RadiologistWorklistFilterBuilder setInstitutions(Collection<Institution> institutions)
    {
        this.institutions = institutions;

        return self();
    }

    
    public RadiologistWorklistFilterBuilder setModalities(Collection<String> modalities)
    {
        this.modalities = modalities;

        return self();
    }

    
    public RadiologistWorklistFilterBuilder setPriorities(Collection<OrderPriority> priorities)
    {
        this.priorities = priorities;

        return self();
    }

    
    protected Collection<Institution> getInstitutions()
    {
        return institutions;
    }

    
    protected Collection<String> getModalities()
    {
        return modalities;
    }

    
    protected Collection<OrderPriority> getPriorities()
    {
        return priorities;
    }

    
    public RadiologistWorklistFilter build()
    {
        return new RadiologistWorklistFilter(getInstitutions(),
                                             getModalities(),
                                             getPriorities());
    }


    
    protected RadiologistWorklistFilterBuilder self()
    {
        return this;
    }
}