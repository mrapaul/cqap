package com.lakeland.ris.ui.datamodel;

import org.codehaus.jackson.annotate.*;
import org.jetbrains.annotations.*;
import java.util.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;
import java.util.*;

public class CPTCodePrimaryGroup
{
    @NotNull private String subspecialtyPrimary;
    @NotNull private Collection<CPTCodeSecondaryGroup> secondaryGroups;

    public CPTCodePrimaryGroup()
    {
        // empty
    }

    @JsonCreator
    public CPTCodePrimaryGroup(@NotNull String subspecialtyPrimary,
                               @NotNull Collection<CPTCodeSecondaryGroup> secondaryGroups)
    {
        super();

        this.subspecialtyPrimary = subspecialtyPrimary;
        this.secondaryGroups = secondaryGroups;
    }

    @NotNull
    public String getSubspecialtyPrimary()
    {
        return subspecialtyPrimary;
    }

    @NotNull
    public Collection<CPTCodeSecondaryGroup> getSecondaryGroups()
    {
        return secondaryGroups;
    }
    public void setSubspecialtyPrimary(@NotNull String subspecialtyPrimary)
    {
        this.subspecialtyPrimary = subspecialtyPrimary;
    }

    public void setSecondaryGroups(@NotNull Collection<CPTCodeSecondaryGroup> secondaryGroups)
    {
        this.secondaryGroups = secondaryGroups;
    }

    @NotNull
    public String toString()
    {
        return "CPTCodePrimaryGroup(" +
            " subspecialtyPrimary: " + getSubspecialtyPrimary() +
            " secondaryGroups: " + getSecondaryGroups() + ")";
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

          final CPTCodePrimaryGroup myObject = (CPTCodePrimaryGroup) aObject;

          return Objects.equals(getSubspecialtyPrimary(), myObject.getSubspecialtyPrimary()) && 
                 Objects.equals(getSecondaryGroups(), myObject.getSecondaryGroups());
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(
                            getSubspecialtyPrimary(),
                            getSecondaryGroups());
    }

    @NotNull
    public CPTCodePrimaryGroupBuilder toBuilder()
    {
        return new CPTCodePrimaryGroupBuilder(getSubspecialtyPrimary(),
                                              getSecondaryGroups());
    }
}