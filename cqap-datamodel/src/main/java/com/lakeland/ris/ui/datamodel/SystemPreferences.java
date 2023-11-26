package com.lakeland.ris.ui.datamodel;

import org.codehaus.jackson.annotate.*;
import org.jetbrains.annotations.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;


public class SystemPreferences
{
    @Nullable private String id;
    private boolean notifyNewOrders;
    @Nullable private String notificationAddress;

    public SystemPreferences()
    {
        // empty
    }

    @JsonCreator
    public SystemPreferences(@Nullable String id,
                             boolean notifyNewOrders,
                             @Nullable String notificationAddress)
    {
        super();

        this.id = id;
        this.notifyNewOrders = notifyNewOrders;
        this.notificationAddress = notificationAddress;
    }

    @Nullable
    public String getId()
    {
        return id;
    }

    public boolean isNotifyNewOrders()
    {
        return notifyNewOrders;
    }

    @Nullable
    public String getNotificationAddress()
    {
        return notificationAddress;
    }
    public void setId(@Nullable String id)
    {
        this.id = id;
    }

    public void setNotifyNewOrders(boolean notifyNewOrders)
    {
        this.notifyNewOrders = notifyNewOrders;
    }

    public void setNotificationAddress(@Nullable String notificationAddress)
    {
        this.notificationAddress = notificationAddress;
    }

    @NotNull
    public String toString()
    {
        return "SystemPreferences(" +
            " id: " + getId() +
            " notifyNewOrders: " + isNotifyNewOrders() +
            " notificationAddress: " + getNotificationAddress() + ")";
    }

    @NotNull
    public SystemPreferencesBuilder toBuilder()
    {
        return new SystemPreferencesBuilder().setId(getId())
                                             .setNotifyNewOrders(isNotifyNewOrders())
                                             .setNotificationAddress(getNotificationAddress());
    }
}