package com.lakeland.hl7.datamodel;

import org.codehaus.jackson.annotate.*;

import java.util.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;


public class OrderStatusChange extends OrderActivity implements HL7Visitable
{
    public static final byte TYPE = 10;
    private OrderStatus status;
     private String assignedTo;

    public OrderStatusChange()
    {
        // empty
    }

    @JsonCreator
    public OrderStatusChange(Date timestamp,
                             String orderId,
                             String userId,
                             OrderStatus status,
                              String assignedTo)
    {
        super(timestamp,
              orderId,
              userId);

        this.status = status;
        this.assignedTo = assignedTo;
    }

    
    public OrderStatus getStatus()
    {
        return status;
    }

    
    public String getAssignedTo()
    {
        return assignedTo;
    }
    public void setStatus(OrderStatus status)
    {
        this.status = status;
    }

    public void setAssignedTo( String assignedTo)
    {
        this.assignedTo = assignedTo;
    }

    public void accept(HL7Visitor aVisitor)
    {
        aVisitor.visit(this);
    }

    
    public String toString()
    {
        return "OrderStatusChange(" +
            super.toString() +
            " status: " + getStatus() +
            " assignedTo: " + getAssignedTo() + ")";
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

          final OrderStatusChange myObject = (OrderStatusChange) aObject;

          return Objects.equals(getStatus(), myObject.getStatus()) && 
                 Objects.equals(getAssignedTo(), myObject.getAssignedTo());
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(super.hashCode(),
                            getStatus(),
                            getAssignedTo());
    }

    
    public OrderStatusChangeBuilder toBuilder()
    {
        return new OrderStatusChangeBuilder(getTimestamp(),
                                            getOrderId(),
                                            getUserId(),
                                            getStatus()).setAssignedTo(getAssignedTo());
    }
}