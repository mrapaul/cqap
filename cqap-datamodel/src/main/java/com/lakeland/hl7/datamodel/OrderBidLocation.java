package com.lakeland.hl7.datamodel;

import org.codehaus.jackson.annotate.*;

import java.util.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;


public class OrderBidLocation extends OrderActivity implements HL7Visitable
{
    public static final byte TYPE = 7;
    private String location;
    private int orderCount;

    public OrderBidLocation()
    {
        // empty
    }

    @JsonCreator
    public OrderBidLocation(Date timestamp,
                            String orderId,
                            String userId,
                            String location,
                            int orderCount)
    {
        super(timestamp,
              orderId,
              userId);

        this.location = location;
        this.orderCount = orderCount;
    }


    public String getLocation()
    {
        return location;
    }

    public int getOrderCount()
    {
        return orderCount;
    }
    public void setLocation(String location)
    {
        this.location = location;
    }

    public void setOrderCount(int orderCount)
    {
        this.orderCount = orderCount;
    }

    public void accept(HL7Visitor aVisitor)
    {
        aVisitor.visit(this);
    }


    public String toString()
    {
        return "OrderBidLocation(" +
            super.toString() +
            " location: " + getLocation() +
            " orderCount: " + getOrderCount() + ")";
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

          final OrderBidLocation myObject = (OrderBidLocation) aObject;

          return Objects.equals(getLocation(), myObject.getLocation()) && 
                 Objects.equals(getOrderCount(), myObject.getOrderCount());
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(super.hashCode(),
                            getLocation(),
                            getOrderCount());
    }


    public OrderBidLocationBuilder toBuilder()
    {
        return new OrderBidLocationBuilder(getTimestamp(),
                                           getOrderId(),
                                           getUserId(),
                                           getLocation()).setOrderCount(getOrderCount());
    }
}