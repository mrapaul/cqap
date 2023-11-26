package com.lakeland.hl7.datamodel;

import org.codehaus.jackson.annotate.*;
import org.jetbrains.annotations.*;
import java.util.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;
import java.util.*;

public class NewOrders extends TimedMessage implements HL7Visitable
{
    public static final byte TYPE = 21;
    @NotNull private Collection<NewOrder> orderId;

    public NewOrders()
    {
        // empty
    }

    @JsonCreator
    public NewOrders(@NotNull Date timestamp,
                     @NotNull Collection<NewOrder> orderId)
    {
        super(timestamp);

        this.orderId = orderId;
    }

    @NotNull
    public Collection<NewOrder> getOrderId()
    {
        return orderId;
    }
    public void setOrderId(@NotNull Collection<NewOrder> orderId)
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
        return "NewOrders(" +
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

          final NewOrders myObject = (NewOrders) aObject;

          return Objects.equals(getOrderId(), myObject.getOrderId());
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(super.hashCode(),
                            getOrderId());
    }

    @NotNull
    public NewOrdersBuilder toBuilder()
    {
        return new NewOrdersBuilder(getTimestamp(),
                                    getOrderId());
    }
}