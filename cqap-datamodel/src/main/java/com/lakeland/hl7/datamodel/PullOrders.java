package com.lakeland.hl7.datamodel;

import org.codehaus.jackson.annotate.*;
import org.jetbrains.annotations.*;
import java.util.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;
import java.util.*;

public class PullOrders extends OrderActivity implements HL7Visitable
{
    public static final byte TYPE = 17;
    @NotNull private Collection<String> orders;

    public PullOrders()
    {
        // empty
    }

    @JsonCreator
    public PullOrders(@NotNull Date timestamp,
                      @NotNull String orderId,
                      @NotNull String userId,
                      @NotNull Collection<String> orders)
    {
        super(timestamp,
              orderId,
              userId);

        this.orders = orders;
    }

    @NotNull
    public Collection<String> getOrders()
    {
        return orders;
    }
    public void setOrders(@NotNull Collection<String> orders)
    {
        this.orders = orders;
    }

    public void accept(@NotNull HL7Visitor aVisitor)
    {
        aVisitor.visit(this);
    }

    @NotNull
    public String toString()
    {
        return "PullOrders(" +
            super.toString() +
            " orders: " + getOrders() + ")";
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

          final PullOrders myObject = (PullOrders) aObject;

          return Objects.equals(getOrders(), myObject.getOrders());
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(super.hashCode(),
                            getOrders());
    }

    @NotNull
    public PullOrdersBuilder toBuilder()
    {
        return new PullOrdersBuilder(getTimestamp(),
                                     getOrderId(),
                                     getUserId(),
                                     getOrders());
    }
}