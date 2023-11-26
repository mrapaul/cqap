package com.lakeland.hl7.datamodel;

import org.codehaus.jackson.annotate.*;
import org.jetbrains.annotations.*;
import java.util.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;
import java.util.*;

public class RadiologistSnapshot extends TimedMessage implements HL7Visitable
{
    public static final byte TYPE = 32;
    @NotNull private String userId;
    @NotNull private Collection<HL7Order> orders;

    public RadiologistSnapshot()
    {
        // empty
    }

    @JsonCreator
    public RadiologistSnapshot(@NotNull Date timestamp,
                               @NotNull String userId,
                               @NotNull Collection<HL7Order> orders)
    {
        super(timestamp);

        this.userId = userId;
        this.orders = orders;
    }

    @NotNull
    public String getUserId()
    {
        return userId;
    }

    @NotNull
    public Collection<HL7Order> getOrders()
    {
        return orders;
    }
    public void setUserId(@NotNull String userId)
    {
        this.userId = userId;
    }

    public void setOrders(@NotNull Collection<HL7Order> orders)
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
        return "RadiologistSnapshot(" +
            super.toString() +
            " userId: " + getUserId() +
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

          final RadiologistSnapshot myObject = (RadiologistSnapshot) aObject;

          return Objects.equals(getUserId(), myObject.getUserId()) && 
                 Objects.equals(getOrders(), myObject.getOrders());
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(super.hashCode(),
                            getUserId(),
                            getOrders());
    }

    @NotNull
    public RadiologistSnapshotBuilder toBuilder()
    {
        return new RadiologistSnapshotBuilder(getTimestamp(),
                                              getUserId(),
                                              getOrders());
    }
}