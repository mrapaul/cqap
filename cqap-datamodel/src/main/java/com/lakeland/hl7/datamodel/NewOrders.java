package com.lakeland.hl7.datamodel;

import org.codehaus.jackson.annotate.*;

import java.util.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;
import java.util.*;

public class NewOrders extends TimedMessage implements HL7Visitable
{
    public static final byte TYPE = 21;
    private Collection<NewOrder> orderId;

    public NewOrders()
    {
        // empty
    }

    @JsonCreator
    public NewOrders(Date timestamp,
                     Collection<NewOrder> orderId)
    {
        super(timestamp);

        this.orderId = orderId;
    }

    
    public Collection<NewOrder> getOrderId()
    {
        return orderId;
    }
    public void setOrderId(Collection<NewOrder> orderId)
    {
        this.orderId = orderId;
    }

    public void accept(HL7Visitor aVisitor)
    {
        aVisitor.visit(this);
    }

    
    public String toString()
    {
        return "NewOrders(" +
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

          final NewOrders myObject = (NewOrders) aObject;

          return Objects.equals(getOrderId(), myObject.getOrderId());
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(super.hashCode(),
                            getOrderId());
    }

    
    public NewOrdersBuilder toBuilder()
    {
        return new NewOrdersBuilder(getTimestamp(),
                                    getOrderId());
    }
}