package com.lakeland.ris.ui.datamodel;

import org.codehaus.jackson.annotate.*;

import java.util.*;
import com.lakeland.ris.datamodel.*;


public class SystemPreferences
{
     private String id;
    private boolean notifyNewOrders;
     private String notificationAddress;

    public SystemPreferences()
    {
        // empty
    }

    @JsonCreator
    public SystemPreferences( String id,
                             boolean notifyNewOrders,
                              String notificationAddress)
    {
        super();

        this.id = id;
        this.notifyNewOrders = notifyNewOrders;
        this.notificationAddress = notificationAddress;
    }

    
    public String getId()
    {
        return id;
    }

    public boolean isNotifyNewOrders()
    {
        return notifyNewOrders;
    }

    
    public String getNotificationAddress()
    {
        return notificationAddress;
    }
    public void setId( String id)
    {
        this.id = id;
    }

    public void setNotifyNewOrders(boolean notifyNewOrders)
    {
        this.notifyNewOrders = notifyNewOrders;
    }

    public void setNotificationAddress( String notificationAddress)
    {
        this.notificationAddress = notificationAddress;
    }


    public String toString()
    {
        return "SystemPreferences(" +
            " id: " + getId() +
            " notifyNewOrders: " + isNotifyNewOrders() +
            " notificationAddress: " + getNotificationAddress() + ")";
    }


    public SystemPreferencesBuilder toBuilder()
    {
        return new SystemPreferencesBuilder().setId(getId())
                                             .setNotifyNewOrders(isNotifyNewOrders())
                                             .setNotificationAddress(getNotificationAddress());
    }
}