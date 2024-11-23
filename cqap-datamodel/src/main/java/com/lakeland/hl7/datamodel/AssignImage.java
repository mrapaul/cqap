package com.lakeland.hl7.datamodel;

import org.codehaus.jackson.annotate.*;

import java.util.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;


public class AssignImage extends TimedMessage implements HL7Visitable
{
    public static final byte TYPE = 28;
    private String userId;
    private String orderId;
    private String dicomStudyId;

    public AssignImage()
    {
        // empty
    }

    @JsonCreator
    public AssignImage(Date timestamp,
                       String userId,
                       String orderId,
                       String dicomStudyId)
    {
        super(timestamp);

        this.userId = userId;
        this.orderId = orderId;
        this.dicomStudyId = dicomStudyId;
    }


    public String getUserId()
    {
        return userId;
    }


    public String getOrderId()
    {
        return orderId;
    }


    public String getDicomStudyId()
    {
        return dicomStudyId;
    }
    public void setUserId(String userId)
    {
        this.userId = userId;
    }

    public void setOrderId(String orderId)
    {
        this.orderId = orderId;
    }

    public void setDicomStudyId(String dicomStudyId)
    {
        this.dicomStudyId = dicomStudyId;
    }

    public void accept(HL7Visitor aVisitor)
    {
        aVisitor.visit(this);
    }


    public String toString()
    {
        return "AssignImage(" +
            super.toString() +
            " userId: " + getUserId() +
            " orderId: " + getOrderId() +
            " dicomStudyId: " + getDicomStudyId() + ")";
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


    public AssignImageBuilder toBuilder()
    {
        return new AssignImageBuilder(getTimestamp(),
                                      getUserId(),
                                      getOrderId(),
                                      getDicomStudyId());
    }
}