package com.lakeland.hl7.datamodel;

import org.codehaus.jackson.annotate.*;
import java.util.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;
import java.util.*;

public class AdministrationSnapshot extends TimedMessage implements HL7Visitable
{
    public static final byte TYPE = 31;
    private Collection<HL7Order> orders;

    public AdministrationSnapshot()
    {
        // empty
    }

    @JsonCreator
    public AdministrationSnapshot(Date timestamp,
                                  Collection<HL7Order> orders)
    {
        super(timestamp);

        this.orders = orders;
    }

    
    public Collection<HL7Order> getOrders()
    {
        return orders;
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
        return "AdministrationSnapshot(" +
            super.toString() +
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

          final AdministrationSnapshot myObject = (AdministrationSnapshot) aObject;

          return Objects.equals(getOrders(), myObject.getOrders());
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(super.hashCode(),
                            getOrders());
    }


    public AdministrationSnapshotBuilder toBuilder()
    {
        return new AdministrationSnapshotBuilder(getTimestamp(),
                                                 getOrders());
    }
}