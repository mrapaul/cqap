package com.lakeland.hl7.datamodel;

import org.codehaus.jackson.annotate.*;
import org.jetbrains.annotations.*;
import java.util.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;


public class AdministrationSnapshotEnd extends TimedMessage implements HL7Visitable
{
    public static final byte TYPE = 14;
    @NotNull private String userId;

    public AdministrationSnapshotEnd()
    {
        // empty
    }

    @JsonCreator
    public AdministrationSnapshotEnd(@NotNull Date timestamp,
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
        return "AdministrationSnapshotEnd(" +
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

          final AdministrationSnapshotEnd myObject = (AdministrationSnapshotEnd) aObject;

          return Objects.equals(getUserId(), myObject.getUserId());
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(super.hashCode(),
                            getUserId());
    }

    @NotNull
    public AdministrationSnapshotEndBuilder toBuilder()
    {
        return new AdministrationSnapshotEndBuilder(getTimestamp(),
                                                    getUserId());
    }
}