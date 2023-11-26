package com.lakeland.ris.ui.datamodel;

import org.codehaus.jackson.annotate.*;
import org.jetbrains.annotations.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;


public class PacsConfiguration
{
    @NotNull private String host;
    private int port;
    @NotNull private String aETitle;

    public PacsConfiguration()
    {
        // empty
    }

    @JsonCreator
    public PacsConfiguration(@NotNull String host,
                             int port,
                             @NotNull String aETitle)
    {
        super();

        this.host = host;
        this.port = port;
        this.aETitle = aETitle;
    }

    @NotNull
    public String getHost()
    {
        return host;
    }

    public int getPort()
    {
        return port;
    }

    @NotNull
    public String getAETitle()
    {
        return aETitle;
    }
    public void setHost(@NotNull String host)
    {
        this.host = host;
    }

    public void setPort(int port)
    {
        this.port = port;
    }

    public void setAETitle(@NotNull String aETitle)
    {
        this.aETitle = aETitle;
    }

    @NotNull
    public String toString()
    {
        return "PacsConfiguration(" +
            " host: " + getHost() +
            " port: " + getPort() +
            " aETitle: " + getAETitle() + ")";
    }

    @NotNull
    public PacsConfigurationBuilder toBuilder()
    {
        return new PacsConfigurationBuilder(getHost(),
                                            getAETitle()).setPort(getPort())
    ;
    }
}