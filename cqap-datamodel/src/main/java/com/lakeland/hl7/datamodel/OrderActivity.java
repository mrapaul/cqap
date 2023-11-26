package com.lakeland.hl7.datamodel;

import org.codehaus.jackson.annotate.*;
import org.jetbrains.annotations.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;


public abstract class OrderActivity extends TimedMessage implements HL7Visitable
{
    public static final byte TYPE = 6;
    @NotNull private String orderId;
    @NotNull private String userId;

    public OrderActivity()
    {
        // empty
    }

    @JsonCreator
    public OrderActivity(@NotNull Date timestamp,
                         @NotNull String orderId,
                         @NotNull String userId)
    {
        super(timestamp);

        this.orderId = orderId;
        this.userId = userId;
    }

    @NotNull
    public String getOrderId()
    {
        return orderId;
    }

    @NotNull
    public String getUserId()
    {
        return userId;
    }
    public void setOrderId(@NotNull String orderId)
    {
        this.orderId = orderId;
    }

    public void setUserId(@NotNull String userId)
    {
        this.userId = userId;
    }

    @NotNull
    public String toString()
    {
        return "OrderActivity(" +
            super.toString() +
            " orderId: " + getOrderId() +
            " userId: " + getUserId() + ")";
    }

}