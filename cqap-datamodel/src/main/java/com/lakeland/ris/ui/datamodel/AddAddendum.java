package com.lakeland.ris.ui.datamodel;

import org.codehaus.jackson.annotate.*;
import org.jetbrains.annotations.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;


public class AddAddendum
{
    @NotNull private String orderId;
    @NotNull private Date timestamp;
    @NotNull private String userId;
    @NotNull private String addendum;

    public AddAddendum()
    {
        // empty
    }

    @JsonCreator
    public AddAddendum(@NotNull String orderId,
                       @NotNull Date timestamp,
                       @NotNull String userId,
                       @NotNull String addendum)
    {
        super();

        this.orderId = orderId;
        this.timestamp = timestamp;
        this.userId = userId;
        this.addendum = addendum;
    }

    @NotNull
    public String getOrderId()
    {
        return orderId;
    }

    @NotNull
    public Date getTimestamp()
    {
        return timestamp;
    }

    @NotNull
    public String getUserId()
    {
        return userId;
    }

    @NotNull
    public String getAddendum()
    {
        return addendum;
    }
    public void setOrderId(@NotNull String orderId)
    {
        this.orderId = orderId;
    }

    public void setTimestamp(@NotNull Date timestamp)
    {
        this.timestamp = timestamp;
    }

    public void setUserId(@NotNull String userId)
    {
        this.userId = userId;
    }

    public void setAddendum(@NotNull String addendum)
    {
        this.addendum = addendum;
    }

    @NotNull
    public String toString()
    {
        return "AddAddendum(" +
            " orderId: " + getOrderId() +
            " timestamp: " + getTimestamp() +
            " userId: " + getUserId() +
            " addendum: " + getAddendum() + ")";
    }

    @NotNull
    public AddAddendumBuilder toBuilder()
    {
        return new AddAddendumBuilder(getOrderId(),
                                      getTimestamp(),
                                      getUserId(),
                                      getAddendum());
    }
}