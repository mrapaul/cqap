package com.lakeland.hl7.datamodel;

import org.codehaus.jackson.annotate.*;
import org.jetbrains.annotations.*;
import java.util.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;


public class AdministrationSnapshotPart extends TimedMessage implements HL7Visitable
{
    public static final byte TYPE = 13;
    @NotNull private String userId;
    @NotNull private String order;

    public AdministrationSnapshotPart()
    {
        // empty
    }

    @JsonCreator
    public AdministrationSnapshotPart(@NotNull Date timestamp,
                                      @NotNull String userId,
                                      @NotNull String order)
    {
        super(timestamp);

        this.userId = userId;
        this.order = order;
    }

    @NotNull
    public String getUserId()
    {
        return userId;
    }

    @NotNull
    public String getOrder()
    {
        return order;
    }
    public void setUserId(@NotNull String userId)
    {
        this.userId = userId;
    }

    public void setOrder(@NotNull String order)
    {
        this.order = order;
    }

    public void accept(@NotNull HL7Visitor aVisitor)
    {
        aVisitor.visit(this);
    }

    @NotNull
    public String toString()
    {
        return "AdministrationSnapshotPart(" +
            super.toString() +
            " userId: " + getUserId() +
            " order: " + getOrder() + ")";
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

          final AdministrationSnapshotPart myObject = (AdministrationSnapshotPart) aObject;

          return Objects.equals(getUserId(), myObject.getUserId()) && 
                 Objects.equals(getOrder(), myObject.getOrder());
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(super.hashCode(),
                            getUserId(),
                            getOrder());
    }

    @NotNull
    public AdministrationSnapshotPartBuilder toBuilder()
    {
        return new AdministrationSnapshotPartBuilder(getTimestamp(),
                                                     getUserId(),
                                                     getOrder());
    }
}