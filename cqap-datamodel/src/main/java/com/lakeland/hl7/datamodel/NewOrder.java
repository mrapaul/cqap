package com.lakeland.hl7.datamodel;

import org.codehaus.jackson.annotate.*;

import java.util.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;


public class NewOrder extends TimedMessage implements HL7Visitable
{
    public static final byte TYPE = 5;
    private String orderId;

    public NewOrder()
    {
        // empty
    }

    @JsonCreator
    public NewOrder(Date timestamp,
                    String orderId)
    {
        super(timestamp);

        this.orderId = orderId;
    }

    
    public String getOrderId()
    {
        return orderId;
    }
    public void setOrderId(String orderId)
    {
        this.orderId = orderId;
    }

    public void accept(HL7Visitor aVisitor)
    {
        aVisitor.visit(this);
    }

    
    public String toString()
    {
        return "NewOrder(" +
            super.toString() +
            " orderId: " + getOrderId() + ")";
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

          final NewOrder myObject = (NewOrder) aObject;

          return Objects.equals(getOrderId(), myObject.getOrderId());
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(super.hashCode(),
                            getOrderId());
    }

    
    public NewOrderBuilder toBuilder()
    {
        return new NewOrderBuilder(getTimestamp(),
                                   getOrderId());
    }
}