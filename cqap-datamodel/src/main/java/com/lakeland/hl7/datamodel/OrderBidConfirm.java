package com.lakeland.hl7.datamodel;

import org.codehaus.jackson.annotate.*;

import java.util.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;


public class OrderBidConfirm extends OrderActivity implements HL7Visitable
{
    public static final byte TYPE = 8;

    public OrderBidConfirm()
    {
        // empty
    }

    @JsonCreator
    public OrderBidConfirm(Date timestamp,
                           String orderId,
                           String userId)
    {
        super(timestamp,
              orderId,
              userId);

    }


    public void accept(HL7Visitor aVisitor)
    {
        aVisitor.visit(this);
    }

    
    public String toString()
    {
        return "OrderBidConfirm(" +
            super.toString() + ")";
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

            return super.equals(aObject);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(super.hashCode()
    );
    }

    
    public OrderBidConfirmBuilder toBuilder()
    {
        return new OrderBidConfirmBuilder(getTimestamp(),
                                          getOrderId(),
                                          getUserId());
    }
}