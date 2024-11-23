package com.lakeland.hl7.datamodel;

import org.codehaus.jackson.annotate.*;

import java.util.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;
import java.util.*;

public class HL7Orders implements HL7Visitable
{
    public static final byte TYPE = 4;
    private Collection<HL7Order> orders;

    public HL7Orders()
    {
        // empty
    }

    @JsonCreator
    public HL7Orders(Collection<HL7Order> orders)
    {
        super();

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
        return "HL7Orders(" +
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

          final HL7Orders myObject = (HL7Orders) aObject;

          return Objects.equals(getOrders(), myObject.getOrders());
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(
                            getOrders());
    }

    
    public HL7OrdersBuilder toBuilder()
    {
        return new HL7OrdersBuilder(getOrders());
    }
}