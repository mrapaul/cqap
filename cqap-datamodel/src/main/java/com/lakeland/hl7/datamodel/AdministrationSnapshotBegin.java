package com.lakeland.hl7.datamodel;

import org.codehaus.jackson.annotate.*;
import org.jetbrains.annotations.*;
import java.util.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;


public class AdministrationSnapshotBegin extends TimedMessage implements HL7Visitable
{
    public static final byte TYPE = 12;
    @NotNull private String userId;

    public AdministrationSnapshotBegin()
    {
        // empty
    }

    @JsonCreator
    public AdministrationSnapshotBegin(@NotNull Date timestamp,
                                       @NotNull String userId)
    {
        super(timestamp);

        this.userId = userId;
    }

    @NotNull
    public String getUserId()
    {
        return userId;
    }
    public void setUserId(@NotNull String userId)
    {
        this.userId = userId;
    }

    public void accept(@NotNull HL7Visitor aVisitor)
    {
        aVisitor.visit(this);
    }

    @NotNull
    public String toString()
    {
        return "AdministrationSnapshotBegin(" +
            super.toString() +
            " userId: " + getUserId() + ")";
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

          if (!super.equals(aObject))
          {
              return false;
          }

          final AdministrationSnapshotBegin myObject = (AdministrationSnapshotBegin) aObject;

          return Objects.equals(getUserId(), myObject.getUserId());
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(super.hashCode(),
                            getUserId());
    }

    @NotNull
    public AdministrationSnapshotBeginBuilder toBuilder()
    {
        return new AdministrationSnapshotBeginBuilder(getTimestamp(),
                                                      getUserId());
    }
}