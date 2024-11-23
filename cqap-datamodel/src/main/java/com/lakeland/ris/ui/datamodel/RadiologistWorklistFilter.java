package com.lakeland.ris.ui.datamodel;

import org.codehaus.jackson.annotate.*;

import java.util.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;
import com.peirs.datamodel.*;
import java.util.*;

public class RadiologistWorklistFilter
{
    private Collection<Institution> institutions;
    private Collection<String> modalities;
    private Collection<OrderPriority> priorities;

    public RadiologistWorklistFilter()
    {
        // empty
    }

    @JsonCreator
    public RadiologistWorklistFilter(Collection<Institution> institutions,
                                     Collection<String> modalities,
                                     Collection<OrderPriority> priorities)
    {
        super();

        this.institutions = institutions;
        this.modalities = modalities;
        this.priorities = priorities;
    }

    
    public Collection<Institution> getInstitutions()
    {
        return institutions;
    }

    
    public Collection<String> getModalities()
    {
        return modalities;
    }

    
    public Collection<OrderPriority> getPriorities()
    {
        return priorities;
    }
    public void setInstitutions(Collection<Institution> institutions)
    {
        this.institutions = institutions;
    }

    public void setModalities(Collection<String> modalities)
    {
        this.modalities = modalities;
    }

    public void setPriorities(Collection<OrderPriority> priorities)
    {
        this.priorities = priorities;
    }

    
    public String toString()
    {
        return "RadiologistWorklistFilter(" +
            " institutions: " + getInstitutions() +
            " modalities: " + getModalities() +
            " priorities: " + getPriorities() + ")";
    }


    @Override
    public boolean equals( Object aObject)
    {
          if (this == aObject)
          {
              return true;
          }

          if (aObject == null || getClass() != aObject.getClass())
          {
              return false;
          }

          final RadiologistWorklistFilter myObject = (RadiologistWorklistFilter) aObject;

          return Objects.equals(getInstitutions(), myObject.getInstitutions()) && 
                 Objects.equals(getModalities(), myObject.getModalities()) && 
                 Objects.equals(getPriorities(), myObject.getPriorities());
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(
                            getInstitutions(),
                            getModalities(),
                            getPriorities());
    }

    
    public RadiologistWorklistFilterBuilder toBuilder()
    {
        return new RadiologistWorklistFilterBuilder(getInstitutions(),
                                                    getModalities(),
                                                    getPriorities());
    }
}