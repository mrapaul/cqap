package com.lakeland.hl7.datamodel;

import org.codehaus.jackson.annotate.*;
import org.jetbrains.annotations.*;
import java.util.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;
import java.util.*;

public class AdministrationSnapshot extends TimedMessage implements HL7Visitable
{
    public static final byte TYPE = 31;
    @NotNull private Collection<HL7Order> orders;

    public AdministrationSnapshot()
    {
        // empty
    }

    @JsonCreator
    public AdministrationSnapshot(@NotNull Date timestamp,
                                  @NotNull Collection<HL7Order> orders)
    {
        super(timestamp);

        this.orders = orders;
    }

    @NotNull
    public Collection<HL7Order> getOrders()
    {
        return orders;
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
        return "AdministrationSnapshot(" +
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

          final AdministrationSnapshot myObject = (AdministrationSnapshot) aObject;

          return Objects.equals(getOrders(), myObject.getOrders());
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(super.hashCode(),
                            getOrders());
    }

    @NotNull
    public AdministrationSnapshotBuilder toBuilder()
    {
        return new AdministrationSnapshotBuilder(getTimestamp(),
                                                 getOrders());
    }
}