package com.lakeland.hl7.datamodel;

import org.codehaus.jackson.annotate.*;

import java.util.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;
import java.util.*;

public class PullOrders extends OrderActivity implements HL7Visitable
{
    public static final byte TYPE = 17;
    private Collection<String> orders;

    public PullOrders()
    {
        // empty
    }

    @JsonCreator
    public PullOrders(Date timestamp,
                      String orderId,
                      String userId,
                      Collection<String> orders)
    {
        super(timestamp,
              orderId,
              userId);

        this.orders = orders;
    }


    public Collection<String> getOrders()
    {
        return orders;
    }
    public void setOrders(Collection<String> orders)
    {
        this.orders = orders;
    }

    public void accept(HL7Visitor aVisitor)
    {
        aVisitor.visit(this);
    }


    public String toString()
    {
        return "PullOrders(" +
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

          final PullOrders myObject = (PullOrders) aObject;

          return Objects.equals(getOrders(), myObject.getOrders());
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(super.hashCode(),
                            getOrders());
    }


    public PullOrdersBuilder toBuilder()
    {
        return new PullOrdersBuilder(getTimestamp(),
                                     getOrderId(),
                                     getUserId(),
                                     getOrders());
    }
}