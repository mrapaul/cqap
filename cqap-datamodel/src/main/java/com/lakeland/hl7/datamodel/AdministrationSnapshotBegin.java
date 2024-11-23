package com.lakeland.hl7.datamodel;

import org.codehaus.jackson.annotate.*;

import java.util.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;


public class AdministrationSnapshotBegin extends TimedMessage implements HL7Visitable
{
    public static final byte TYPE = 12;
    private String userId;

    public AdministrationSnapshotBegin()
    {
        // empty
    }

    @JsonCreator
    public AdministrationSnapshotBegin(Date timestamp,
                                       String userId)
    {
        super(timestamp);

        this.userId = userId;
    }

    
    public String getUserId()
    {
        return userId;
    }
    public void setUserId(String userId)
    {
        this.userId = userId;
    }

    public void accept(HL7Visitor aVisitor)
    {
        aVisitor.visit(this);
    }

    
    public String toString()
    {
        return "AdministrationSnapshotBegin(" +
            super.toString() +
            " userId: " + getUserId() + ")";
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

          final AdministrationSnapshotBegin myObject = (AdministrationSnapshotBegin) aObject;

          return Objects.equals(getUserId(), myObject.getUserId());
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(super.hashCode(),
                            getUserId());
    }

    
    public AdministrationSnapshotBeginBuilder toBuilder()
    {
        return new AdministrationSnapshotBeginBuilder(getTimestamp(),
                                                      getUserId());
    }
}