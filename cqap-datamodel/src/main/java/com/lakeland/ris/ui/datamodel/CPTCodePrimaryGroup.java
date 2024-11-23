package com.lakeland.ris.ui.datamodel;

import org.codehaus.jackson.annotate.*;

import java.util.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;
import java.util.*;

public class CPTCodePrimaryGroup
{
    private String subspecialtyPrimary;
    private Collection<CPTCodeSecondaryGroup> secondaryGroups;

    public CPTCodePrimaryGroup()
    {
        // empty
    }

    @JsonCreator
    public CPTCodePrimaryGroup(String subspecialtyPrimary,
                               Collection<CPTCodeSecondaryGroup> secondaryGroups)
    {
        super();

        this.subspecialtyPrimary = subspecialtyPrimary;
        this.secondaryGroups = secondaryGroups;
    }

    
    public String getSubspecialtyPrimary()
    {
        return subspecialtyPrimary;
    }

    
    public Collection<CPTCodeSecondaryGroup> getSecondaryGroups()
    {
        return secondaryGroups;
    }
    public void setSubspecialtyPrimary(String subspecialtyPrimary)
    {
        this.subspecialtyPrimary = subspecialtyPrimary;
    }

    public void setSecondaryGroups(Collection<CPTCodeSecondaryGroup> secondaryGroups)
    {
        this.secondaryGroups = secondaryGroups;
    }

    
    public String toString()
    {
        return "CPTCodePrimaryGroup(" +
            " subspecialtyPrimary: " + getSubspecialtyPrimary() +
            " secondaryGroups: " + getSecondaryGroups() + ")";
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

    
    public CPTCodePrimaryGroupBuilder toBuilder()
    {
        return new CPTCodePrimaryGroupBuilder(getSubspecialtyPrimary(),
                                              getSecondaryGroups());
    }
}