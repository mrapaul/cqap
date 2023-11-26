package com.lakeland.hl7.datamodel;

import org.codehaus.jackson.annotate.*;
import org.jetbrains.annotations.*;
import java.util.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;


public class NewOrder extends TimedMessage implements HL7Visitable
{
    public static final byte TYPE = 5;
    @NotNull private String orderId;

    public NewOrder()
    {
        // empty
    }

    @JsonCreator
    public NewOrder(@NotNull Date timestamp,
                    @NotNull String orderId)
    {
        super(timestamp);

        this.orderId = orderId;
    }

    @NotNull
    public String getOrderId()
    {
        return orderId;
    }
    public void setOrderId(@NotNull String orderId)
    {
        this.orderId = orderId;
    }

    public void accept(@NotNull HL7Visitor aVisitor)
    {
        aVisitor.visit(this);
    }

    @NotNull
    public String toString()
    {
        return "NewOrder(" +
            super.toString() +
            " orderId: " + getOrderId() + ")";
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

          final NewOrder myObject = (NewOrder) aObject;

          return Objects.equals(getOrderId(), myObject.getOrderId());
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(super.hashCode(),
                            getOrderId());
    }

    @NotNull
    public NewOrderBuilder toBuilder()
    {
        return new NewOrderBuilder(getTimestamp(),
                                   getOrderId());
    }
}