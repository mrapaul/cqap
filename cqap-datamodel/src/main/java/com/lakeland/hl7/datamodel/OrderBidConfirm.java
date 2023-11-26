package com.lakeland.hl7.datamodel;

import org.codehaus.jackson.annotate.*;
import org.jetbrains.annotations.*;
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
    public OrderBidConfirm(@NotNull Date timestamp,
                           @NotNull String orderId,
                           @NotNull String userId)
    {
        super(timestamp,
              orderId,
              userId);

    }


    public void accept(@NotNull HL7Visitor aVisitor)
    {
        aVisitor.visit(this);
    }

    @NotNull
    public String toString()
    {
        return "OrderBidConfirm(" +
            super.toString() + ")";
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

            return super.equals(aObject);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(super.hashCode()
    );
    }

    @NotNull
    public OrderBidConfirmBuilder toBuilder()
    {
        return new OrderBidConfirmBuilder(getTimestamp(),
                                          getOrderId(),
                                          getUserId());
    }
}