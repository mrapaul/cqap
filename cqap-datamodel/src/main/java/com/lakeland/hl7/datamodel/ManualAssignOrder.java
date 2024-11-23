package com.lakeland.hl7.datamodel;

import org.codehaus.jackson.annotate.*;

import java.util.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;
import java.util.*;

public class ManualAssignOrder extends OrderActivity implements HL7Visitable
{
    public static final byte TYPE = 16;
    private Collection<String> orders;
    private String assignUserId;

    public ManualAssignOrder()
    {
        // empty
    }

    @JsonCreator
    public ManualAssignOrder(Date timestamp,
                             String orderId,
                             String userId,
                             Collection<String> orders,
                             String assignUserId)
    {
        super(timestamp,
              orderId,
              userId);

        this.orders = orders;
        this.assignUserId = assignUserId;
    }


    public Collection<String> getOrders()
    {
        return orders;
    }


    public String getAssignUserId()
    {
        return assignUserId;
    }
    public void setOrders(Collection<String> orders)
    {
        this.orders = orders;
    }

    public void setAssignUserId(String assignUserId)
    {
        this.assignUserId = assignUserId;
    }

    public void accept(HL7Visitor aVisitor)
    {
        aVisitor.visit(this);
    }


    public String toString()
    {
        return "ManualAssignOrder(" +
            super.toString() +
            " orders: " + getOrders() +
            " assignUserId: " + getAssignUserId() + ")";
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

          final ManualAssignOrder myObject = (ManualAssignOrder) aObject;

          return Objects.equals(getOrders(), myObject.getOrders()) && 
                 Objects.equals(getAssignUserId(), myObject.getAssignUserId());
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(super.hashCode(),
                            getOrders(),
                            getAssignUserId());
    }


    public ManualAssignOrderBuilder toBuilder()
    {
        return new ManualAssignOrderBuilder(getTimestamp(),
                                            getOrderId(),
                                            getUserId(),
                                            getOrders(),
                                            getAssignUserId());
    }
}