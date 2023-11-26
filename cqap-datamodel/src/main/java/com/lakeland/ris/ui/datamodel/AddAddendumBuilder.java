package com.lakeland.ris.ui.datamodel;

import org.jetbrains.annotations.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;


public class AddAddendumBuilder
{
    @NotNull private String orderId;
    @NotNull private Date timestamp;
    @NotNull private String userId;
    @NotNull private String addendum;

    public AddAddendumBuilder(@NotNull String orderId,
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
    public AddAddendumBuilder setOrderId(@NotNull String orderId)
    {
        this.orderId = orderId;

        return self();
    }

    @NotNull
    public AddAddendumBuilder setTimestamp(@NotNull Date timestamp)
    {
        this.timestamp = timestamp;

        return self();
    }

    @NotNull
    public AddAddendumBuilder setUserId(@NotNull String userId)
    {
        this.userId = userId;

        return self();
    }

    @NotNull
    public AddAddendumBuilder setAddendum(@NotNull String addendum)
    {
        this.addendum = addendum;

        return self();
    }

    @NotNull
    protected String getOrderId()
    {
        return orderId;
    }

    @NotNull
    protected Date getTimestamp()
    {
        return timestamp;
    }

    @NotNull
    protected String getUserId()
    {
        return userId;
    }

    @NotNull
    protected String getAddendum()
    {
        return addendum;
    }

    @NotNull
    public AddAddendum build()
    {
        return new AddAddendum(getOrderId(),
                               getTimestamp(),
                               getUserId(),
                               getAddendum());
    }


    @NotNull
    protected AddAddendumBuilder self()
    {
        return this;
    }
}