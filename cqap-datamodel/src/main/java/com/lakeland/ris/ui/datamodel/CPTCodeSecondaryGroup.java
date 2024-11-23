package com.lakeland.ris.ui.datamodel;

import org.codehaus.jackson.annotate.*;

import java.util.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;
import java.util.*;

public class CPTCodeSecondaryGroup
{
    private String subspecialtySecondary;
    private Collection<String> codes;

    public CPTCodeSecondaryGroup()
    {
        // empty
    }

    @JsonCreator
    public CPTCodeSecondaryGroup(String subspecialtySecondary,
                                 Collection<String> codes)
    {
        super();

        this.subspecialtySecondary = subspecialtySecondary;
        this.codes = codes;
    }


    public String getSubspecialtySecondary()
    {
        return subspecialtySecondary;
    }


    public Collection<String> getCodes()
    {
        return codes;
    }
    public void setSubspecialtySecondary(String subspecialtySecondary)
    {
        this.subspecialtySecondary = subspecialtySecondary;
    }

    public void setCodes(Collection<String> codes)
    {
        this.codes = codes;
    }


    public String toString()
    {
        return "CPTCodeSecondaryGroup(" +
            " subspecialtySecondary: " + getSubspecialtySecondary() +
            " codes: " + getCodes() + ")";
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

          final CPTCodeSecondaryGroup myObject = (CPTCodeSecondaryGroup) aObject;

          return Objects.equals(getSubspecialtySecondary(), myObject.getSubspecialtySecondary()) && 
                 Objects.equals(getCodes(), myObject.getCodes());
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(
                            getSubspecialtySecondary(),
                            getCodes());
    }


    public CPTCodeSecondaryGroupBuilder toBuilder()
    {
        return new CPTCodeSecondaryGroupBuilder(getSubspecialtySecondary(),
                                                getCodes());
    }
}