package com.lakeland.hl7.datamodel;

import org.codehaus.jackson.annotate.*;

import java.util.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;


public class AdministrationSnapshotPart extends TimedMessage implements HL7Visitable
{
    public static final byte TYPE = 13;
    private String userId;
    private String order;

    public AdministrationSnapshotPart()
    {
        // empty
    }

    @JsonCreator
    public AdministrationSnapshotPart(Date timestamp,
                                      String userId,
                                      String order)
    {
        super(timestamp);

        this.userId = userId;
        this.order = order;
    }

    
    public String getUserId()
    {
        return userId;
    }

    
    public String getOrder()
    {
        return order;
    }
    public void setUserId(String userId)
    {
        this.userId = userId;
    }

    public void setOrder(String order)
    {
        this.order = order;
    }

    public void accept(HL7Visitor aVisitor)
    {
        aVisitor.visit(this);
    }

    
    public String toString()
    {
        return "AdministrationSnapshotPart(" +
            super.toString() +
            " userId: " + getUserId() +
            " order: " + getOrder() + ")";
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

    
    public AdministrationSnapshotPartBuilder toBuilder()
    {
        return new AdministrationSnapshotPartBuilder(getTimestamp(),
                                                     getUserId(),
                                                     getOrder());
    }
}