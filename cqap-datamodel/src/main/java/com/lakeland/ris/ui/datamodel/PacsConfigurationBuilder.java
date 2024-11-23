package com.lakeland.ris.ui.datamodel;


import java.util.*;
import com.lakeland.ris.datamodel.*;


public class PacsConfigurationBuilder
{
    private String host;
    private int port;
    private String aETitle;

    public PacsConfigurationBuilder(String host,
                                    String aETitle)
    {
        super();

        this.host = host;
        this.aETitle = aETitle;
    }


    
    public PacsConfigurationBuilder setHost(String host)
    {
        this.host = host;

        return self();
    }

    
    public PacsConfigurationBuilder setPort(int port)
    {
        this.port = port;

        return self();
    }

    
    public PacsConfigurationBuilder setAETitle(String aETitle)
    {
        this.aETitle = aETitle;

        return self();
    }

    
    protected String getHost()
    {
        return host;
    }

    protected int getPort()
    {
        return port;
    }

    
    protected String getAETitle()
    {
        return aETitle;
    }

    
    public PacsConfiguration build()
    {
        return new PacsConfiguration(getHost(),
                                     getPort(),
                                     getAETitle());
    }


    
    protected PacsConfigurationBuilder self()
    {
        return this;
    }
}