package com.lakeland.hl7.datamodel;

import org.codehaus.jackson.annotate.*;
import org.jetbrains.annotations.*;
import java.util.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;


public class AssignImage extends TimedMessage implements HL7Visitable
{
    public static final byte TYPE = 28;
    @NotNull private String userId;
    @NotNull private String orderId;
    @NotNull private String dicomStudyId;

    public AssignImage()
    {
        // empty
    }

    @JsonCreator
    public AssignImage(@NotNull Date timestamp,
                       @NotNull String userId,
                       @NotNull String orderId,
                       @NotNull String dicomStudyId)
    {
        super(timestamp);

        this.userId = userId;
        this.orderId = orderId;
        this.dicomStudyId = dicomStudyId;
    }

    @NotNull
    public String getUserId()
    {
        return userId;
    }

    @NotNull
    public String getOrderId()
    {
        return orderId;
    }

    @NotNull
    public String getDicomStudyId()
    {
        return dicomStudyId;
    }
    public void setUserId(@NotNull String userId)
    {
        this.userId = userId;
    }

    public void setOrderId(@NotNull String orderId)
    {
        this.orderId = orderId;
    }

    public void setDicomStudyId(@NotNull String dicomStudyId)
    {
        this.dicomStudyId = dicomStudyId;
    }

    public void accept(@NotNull HL7Visitor aVisitor)
    {
        aVisitor.visit(this);
    }

    @NotNull
    public String toString()
    {
        return "AssignImage(" +
            super.toString() +
            " userId: " + getUserId() +
            " orderId: " + getOrderId() +
            " dicomStudyId: " + getDicomStudyId() + ")";
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

          final AssignImage myObject = (AssignImage) aObject;

          return Objects.equals(getUserId(), myObject.getUserId()) && 
                 Objects.equals(getOrderId(), myObject.getOrderId()) && 
                 Objects.equals(getDicomStudyId(), myObject.getDicomStudyId());
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(super.hashCode(),
                            getUserId(),
                            getOrderId(),
                            getDicomStudyId());
    }

    @NotNull
    public AssignImageBuilder toBuilder()
    {
        return new AssignImageBuilder(getTimestamp(),
                                      getUserId(),
                                      getOrderId(),
                                      getDicomStudyId());
    }
}