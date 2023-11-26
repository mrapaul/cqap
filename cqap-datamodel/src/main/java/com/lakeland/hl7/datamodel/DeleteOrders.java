package com.lakeland.hl7.datamodel;

import org.codehaus.jackson.annotate.*;
import org.jetbrains.annotations.*;
import java.util.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;
import java.util.*;

public class DeleteOrders extends OrderActivity implements HL7Visitable
{
    public static final byte TYPE = 18;
    @NotNull private Collection<String> orders;

    public DeleteOrders()
    {
        // empty
    }

    @JsonCreator
    public DeleteOrders(@NotNull Date timestamp,
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
        return "DeleteOrders(" +
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

          final DeleteOrders myObject = (DeleteOrders) aObject;

          return Objects.equals(getOrders(), myObject.getOrders());
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(super.hashCode(),
                            getOrders());
    }

    @NotNull
    public DeleteOrdersBuilder toBuilder()
    {
        return new DeleteOrdersBuilder(getTimestamp(),
                                       getOrderId(),
                                       getUserId(),
                                       getOrders());
    }
}