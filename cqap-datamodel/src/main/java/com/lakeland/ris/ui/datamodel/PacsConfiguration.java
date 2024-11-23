package com.lakeland.ris.ui.datamodel;

import org.codehaus.jackson.annotate.*;

import java.util.*;
import com.lakeland.ris.datamodel.*;


public class PacsConfiguration
{
    private String host;
    private int port;
    private String aETitle;

    public PacsConfiguration()
    {
        // empty
    }

    @JsonCreator
    public PacsConfiguration(String host,
                             int port,
                             String aETitle)
    {
        super();

        this.host = host;
        this.port = port;
        this.aETitle = aETitle;
    }

    
    public String getHost()
    {
        return host;
    }

    public int getPort()
    {
        return port;
    }

    
    public String getAETitle()
    {
        return aETitle;
    }
    public void setHost(String host)
    {
        this.host = host;
    }

    public void setPort(int port)
    {
        this.port = port;
    }

    public void setAETitle(String aETitle)
    {
        this.aETitle = aETitle;
    }

    
    public String toString()
    {
        return "PacsConfiguration(" +
            " host: " + getHost() +
            " port: " + getPort() +
            " aETitle: " + getAETitle() + ")";
    }

    
    public PacsConfigurationBuilder toBuilder()
    {
        return new PacsConfigurationBuilder(getHost(),
                                            getAETitle()).setPort(getPort())
    ;
    }
}