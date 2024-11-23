package com.lakeland.hl7.datamodel;

import org.codehaus.jackson.annotate.*;

import java.util.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;
import java.util.*;

public class RadiologistSnapshot extends TimedMessage implements HL7Visitable
{
    public static final byte TYPE = 32;
    private String userId;
    private Collection<HL7Order> orders;

    public RadiologistSnapshot()
    {
        // empty
    }

    @JsonCreator
    public RadiologistSnapshot(Date timestamp,
                               String userId,
                               Collection<HL7Order> orders)
    {
        super(timestamp);

        this.userId = userId;
        this.orders = orders;
    }

    
    public String getUserId()
    {
        return userId;
    }

    
    public Collection<HL7Order> getOrders()
    {
        return orders;
    }
    public void setUserId(String userId)
    {
        this.userId = userId;
    }

    public void setOrders(Collection<HL7Order> orders)
    {
        this.orders = orders;
    }

    public void accept(HL7Visitor aVisitor)
    {
        aVisitor.visit(this);
    }

    
    public String toString()
    {
        return "RadiologistSnapshot(" +
            super.toString() +
            " userId: " + getUserId() +
            " orders: " + getOrders() + ")";
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

          final RadiologistSnapshot myObject = (RadiologistSnapshot) aObject;

          return Objects.equals(getUserId(), myObject.getUserId()) && 
                 Objects.equals(getOrders(), myObject.getOrders());
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(super.hashCode(),
                            getUserId(),
                            getOrders());
    }

    
    public RadiologistSnapshotBuilder toBuilder()
    {
        return new RadiologistSnapshotBuilder(getTimestamp(),
                                              getUserId(),
                                              getOrders());
    }
}