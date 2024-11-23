package com.lakeland.ris.ui.datamodel;


import java.util.*;
import com.lakeland.ris.datamodel.*;


public class SystemPreferencesBuilder
{
     private String id;
    private boolean notifyNewOrders;
     private String notificationAddress;

    public SystemPreferencesBuilder()
    {
        super();

    }


    
    public SystemPreferencesBuilder setId( String id)
    {
        this.id = id;

        return self();
    }

    
    public SystemPreferencesBuilder setNotifyNewOrders(boolean notifyNewOrders)
    {
        this.notifyNewOrders = notifyNewOrders;

        return self();
    }

    
    public SystemPreferencesBuilder setNotificationAddress( String notificationAddress)
    {
        this.notificationAddress = notificationAddress;

        return self();
    }

    
    protected String getId()
    {
        return id;
    }

    protected boolean isNotifyNewOrders()
    {
        return notifyNewOrders;
    }

    
    protected String getNotificationAddress()
    {
        return notificationAddress;
    }

    
    public SystemPreferences build()
    {
        return new SystemPreferences(getId(),
                                     isNotifyNewOrders(),
                                     getNotificationAddress());
    }


    
    protected SystemPreferencesBuilder self()
    {
        return this;
    }
}