package com.lakeland.ris.ui.datamodel;

import org.codehaus.jackson.annotate.*;
import org.jetbrains.annotations.*;
import java.util.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;
import java.util.*;

public class CPTCodeSecondaryGroup
{
    @NotNull private String subspecialtySecondary;
    @NotNull private Collection<String> codes;

    public CPTCodeSecondaryGroup()
    {
        // empty
    }

    @JsonCreator
    public CPTCodeSecondaryGroup(@NotNull String subspecialtySecondary,
                                 @NotNull Collection<String> codes)
    {
        super();

        this.subspecialtySecondary = subspecialtySecondary;
        this.codes = codes;
    }

    @NotNull
    public String getSubspecialtySecondary()
    {
        return subspecialtySecondary;
    }

    @NotNull
    public Collection<String> getCodes()
    {
        return codes;
    }
    public void setSubspecialtySecondary(@NotNull String subspecialtySecondary)
    {
        this.subspecialtySecondary = subspecialtySecondary;
    }

    public void setCodes(@NotNull Collection<String> codes)
    {
        this.codes = codes;
    }

    @NotNull
    public String toString()
    {
        return "CPTCodeSecondaryGroup(" +
            " subspecialtySecondary: " + getSubspecialtySecondary() +
            " codes: " + getCodes() + ")";
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

    @NotNull
    public CPTCodeSecondaryGroupBuilder toBuilder()
    {
        return new CPTCodeSecondaryGroupBuilder(getSubspecialtySecondary(),
                                                getCodes());
    }
}