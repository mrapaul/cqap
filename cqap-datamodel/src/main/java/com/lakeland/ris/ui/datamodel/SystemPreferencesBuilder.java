package com.lakeland.ris.ui.datamodel;

import org.jetbrains.annotations.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;


public class SystemPreferencesBuilder
{
    @Nullable private String id;
    private boolean notifyNewOrders;
    @Nullable private String notificationAddress;

    public SystemPreferencesBuilder()
    {
        super();

    }


    @NotNull
    public SystemPreferencesBuilder setId(@Nullable String id)
    {
        this.id = id;

        return self();
    }

    @NotNull
    public SystemPreferencesBuilder setNotifyNewOrders(boolean notifyNewOrders)
    {
        this.notifyNewOrders = notifyNewOrders;

        return self();
    }

    @NotNull
    public SystemPreferencesBuilder setNotificationAddress(@Nullable String notificationAddress)
    {
        this.notificationAddress = notificationAddress;

        return self();
    }

    @Nullable
    protected String getId()
    {
        return id;
    }

    protected boolean isNotifyNewOrders()
    {
        return notifyNewOrders;
    }

    @Nullable
    protected String getNotificationAddress()
    {
        return notificationAddress;
    }

    @NotNull
    public SystemPreferences build()
    {
        return new SystemPreferences(getId(),
                                     isNotifyNewOrders(),
                                     getNotificationAddress());
    }


    @NotNull
    protected SystemPreferencesBuilder self()
    {
        return this;
    }
}