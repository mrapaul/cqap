package com.lakeland.hl7.datamodel;

import org.codehaus.jackson.annotate.*;
import org.jetbrains.annotations.*;
import java.util.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;


public class OrderBidTelerad extends OrderActivity implements HL7Visitable
{
    public static final byte TYPE = 22;
    private int orderCount;

    public OrderBidTelerad()
    {
        // empty
    }

    @JsonCreator
    public OrderBidTelerad(@NotNull Date timestamp,
                           @NotNull String orderId,
                           @NotNull String userId,
                           int orderCount)
    {
        super(timestamp,
              orderId,
              userId);

        this.orderCount = orderCount;
    }

    public int getOrderCount()
    {
        return orderCount;
    }
    public void setOrderCount(int orderCount)
    {
        this.orderCount = orderCount;
    }

    public void accept(@NotNull HL7Visitor aVisitor)
    {
        aVisitor.visit(this);
    }

    @NotNull
    public String toString()
    {
        return "OrderBidTelerad(" +
            super.toString() +
            " orderCount: " + getOrderCount() + ")";
    }


    @Override
    public boolean equals(@Nullable Object aObject)
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

          final OrderBidTelerad myObject = (OrderBidTelerad) aObject;

          return Objects.equals(getOrderCount(), myObject.getOrderCount());
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(super.hashCode(),
                            getOrderCount());
    }

    @NotNull
    public OrderBidTeleradBuilder toBuilder()
    {
        return new OrderBidTeleradBuilder(getTimestamp(),
                                          getOrderId(),
                                          getUserId()).setOrderCount(getOrderCount());
    }
}