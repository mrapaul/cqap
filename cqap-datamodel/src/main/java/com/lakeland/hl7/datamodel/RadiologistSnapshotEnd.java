package com.lakeland.hl7.datamodel;

import org.codehaus.jackson.annotate.*;

import java.util.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;


public class RadiologistSnapshotEnd extends TimedMessage implements HL7Visitable
{
    public static final byte TYPE = 29;
    private String userId;

    public RadiologistSnapshotEnd()
    {
        // empty
    }

    @JsonCreator
    public RadiologistSnapshotEnd(Date timestamp,
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
        return "RadiologistSnapshotEnd(" +
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

          final RadiologistSnapshotEnd myObject = (RadiologistSnapshotEnd) aObject;

          return Objects.equals(getUserId(), myObject.getUserId());
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(super.hashCode(),
                            getUserId());
    }


    public RadiologistSnapshotEndBuilder toBuilder()
    {
        return new RadiologistSnapshotEndBuilder(getTimestamp(),
                                                 getUserId());
    }
}