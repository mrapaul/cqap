package com.lakeland.ris.ui.datamodel;

import org.codehaus.jackson.annotate.*;
import org.jetbrains.annotations.*;
import java.util.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;
import com.peirs.datamodel.*;
import java.util.*;

public class RadiologistWorklistFilter
{
    @NotNull private Collection<Institution> institutions;
    @NotNull private Collection<String> modalities;
    @NotNull private Collection<OrderPriority> priorities;

    public RadiologistWorklistFilter()
    {
        // empty
    }

    @JsonCreator
    public RadiologistWorklistFilter(@NotNull Collection<Institution> institutions,
                                     @NotNull Collection<String> modalities,
                                     @NotNull Collection<OrderPriority> priorities)
    {
        super();

        this.institutions = institutions;
        this.modalities = modalities;
        this.priorities = priorities;
    }

    @NotNull
    public Collection<Institution> getInstitutions()
    {
        return institutions;
    }

    @NotNull
    public Collection<String> getModalities()
    {
        return modalities;
    }

    @NotNull
    public Collection<OrderPriority> getPriorities()
    {
        return priorities;
    }
    public void setInstitutions(@NotNull Collection<Institution> institutions)
    {
        this.institutions = institutions;
    }

    public void setModalities(@NotNull Collection<String> modalities)
    {
        this.modalities = modalities;
    }

    public void setPriorities(@NotNull Collection<OrderPriority> priorities)
    {
        this.priorities = priorities;
    }

    @NotNull
    public String toString()
    {
        return "RadiologistWorklistFilter(" +
            " institutions: " + getInstitutions() +
            " modalities: " + getModalities() +
            " priorities: " + getPriorities() + ")";
    }


    @Override
    public boolean equals(@Nullable Object aObject)
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

    @NotNull
    public RadiologistWorklistFilterBuilder toBuilder()
    {
        return new RadiologistWorklistFilterBuilder(getInstitutions(),
                                                    getModalities(),
                                                    getPriorities());
    }
}