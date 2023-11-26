package com.lakeland.hl7.datamodel;

import org.codehaus.jackson.annotate.*;
import org.jetbrains.annotations.*;
import java.util.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;


public class OrderStatusChange extends OrderActivity implements HL7Visitable
{
    public static final byte TYPE = 10;
    @NotNull private OrderStatus status;
    @Nullable private String assignedTo;

    public OrderStatusChange()
    {
        // empty
    }

    @JsonCreator
    public OrderStatusChange(@NotNull Date timestamp,
                             @NotNull String orderId,
                             @NotNull String userId,
                             @NotNull OrderStatus status,
                             @Nullable String assignedTo)
    {
        super(timestamp,
              orderId,
              userId);

        this.status = status;
        this.assignedTo = assignedTo;
    }

    @NotNull
    public OrderStatus getStatus()
    {
        return status;
    }

    @Nullable
    public String getAssignedTo()
    {
        return assignedTo;
    }
    public void setStatus(@NotNull OrderStatus status)
    {
        this.status = status;
    }

    public void setAssignedTo(@Nullable String assignedTo)
    {
        this.assignedTo = assignedTo;
    }

    public void accept(@NotNull HL7Visitor aVisitor)
    {
        aVisitor.visit(this);
    }

    @NotNull
    public String toString()
    {
        return "OrderStatusChange(" +
            super.toString() +
            " status: " + getStatus() +
            " assignedTo: " + getAssignedTo() + ")";
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

          final OrderStatusChange myObject = (OrderStatusChange) aObject;

          return Objects.equals(getStatus(), myObject.getStatus()) && 
                 Objects.equals(getAssignedTo(), myObject.getAssignedTo());
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(super.hashCode(),
                            getStatus(),
                            getAssignedTo());
    }

    @NotNull
    public OrderStatusChangeBuilder toBuilder()
    {
        return new OrderStatusChangeBuilder(getTimestamp(),
                                            getOrderId(),
                                            getUserId(),
                                            getStatus()).setAssignedTo(getAssignedTo());
    }
}