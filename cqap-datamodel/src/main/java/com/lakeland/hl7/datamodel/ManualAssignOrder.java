package com.lakeland.hl7.datamodel;

import org.codehaus.jackson.annotate.*;
import org.jetbrains.annotations.*;
import java.util.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;
import java.util.*;

public class ManualAssignOrder extends OrderActivity implements HL7Visitable
{
    public static final byte TYPE = 16;
    @NotNull private Collection<String> orders;
    @NotNull private String assignUserId;

    public ManualAssignOrder()
    {
        // empty
    }

    @JsonCreator
    public ManualAssignOrder(@NotNull Date timestamp,
                             @NotNull String orderId,
                             @NotNull String userId,
                             @NotNull Collection<String> orders,
                             @NotNull String assignUserId)
    {
        super(timestamp,
              orderId,
              userId);

        this.orders = orders;
        this.assignUserId = assignUserId;
    }

    @NotNull
    public Collection<String> getOrders()
    {
        return orders;
    }

    @NotNull
    public String getAssignUserId()
    {
        return assignUserId;
    }
    public void setOrders(@NotNull Collection<String> orders)
    {
        this.orders = orders;
    }

    public void setAssignUserId(@NotNull String assignUserId)
    {
        this.assignUserId = assignUserId;
    }

    public void accept(@NotNull HL7Visitor aVisitor)
    {
        aVisitor.visit(this);
    }

    @NotNull
    public String toString()
    {
        return "ManualAssignOrder(" +
            super.toString() +
            " orders: " + getOrders() +
            " assignUserId: " + getAssignUserId() + ")";
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

          final ManualAssignOrder myObject = (ManualAssignOrder) aObject;

          return Objects.equals(getOrders(), myObject.getOrders()) && 
                 Objects.equals(getAssignUserId(), myObject.getAssignUserId());
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(super.hashCode(),
                            getOrders(),
                            getAssignUserId());
    }

    @NotNull
    public ManualAssignOrderBuilder toBuilder()
    {
        return new ManualAssignOrderBuilder(getTimestamp(),
                                            getOrderId(),
                                            getUserId(),
                                            getOrders(),
                                            getAssignUserId());
    }
}