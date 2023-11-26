package com.lakeland.ris.ui.datamodel;

import org.codehaus.jackson.annotate.*;
import org.jetbrains.annotations.*;
import java.util.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;
import java.util.*;

public class CPTCodePrimaryGroups
{
    @NotNull private Collection<CPTCodePrimaryGroup> groups;

    public CPTCodePrimaryGroups()
    {
        // empty
    }

    @JsonCreator
    public CPTCodePrimaryGroups(@NotNull Collection<CPTCodePrimaryGroup> groups)
    {
        super();

        this.groups = groups;
    }

    @NotNull
    public Collection<CPTCodePrimaryGroup> getGroups()
    {
        return groups;
    }
    public void setGroups(@NotNull Collection<CPTCodePrimaryGroup> groups)
    {
        this.groups = groups;
    }

    @NotNull
    public String toString()
    {
        return "CPTCodePrimaryGroups(" +
            " groups: " + getGroups() + ")";
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

          final CPTCodePrimaryGroups myObject = (CPTCodePrimaryGroups) aObject;

          return Objects.equals(getGroups(), myObject.getGroups());
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(
                            getGroups());
    }

    @NotNull
    public CPTCodePrimaryGroupsBuilder toBuilder()
    {
        return new CPTCodePrimaryGroupsBuilder(getGroups());
    }
}