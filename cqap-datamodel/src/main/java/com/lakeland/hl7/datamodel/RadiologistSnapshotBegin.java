package com.lakeland.hl7.datamodel;

import org.codehaus.jackson.annotate.*;

import java.util.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;


public class RadiologistSnapshotBegin extends TimedMessage implements HL7Visitable
{
    public static final byte TYPE = 30;
    private String userId;

    public RadiologistSnapshotBegin()
    {
        // empty
    }

    @JsonCreator
    public RadiologistSnapshotBegin(Date timestamp,
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
        return "RadiologistSnapshotBegin(" +
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

          final RadiologistSnapshotBegin myObject = (RadiologistSnapshotBegin) aObject;

          return Objects.equals(getUserId(), myObject.getUserId());
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(super.hashCode(),
                            getUserId());
    }


    public RadiologistSnapshotBeginBuilder toBuilder()
    {
        return new RadiologistSnapshotBeginBuilder(getTimestamp(),
                                                   getUserId());
    }
}