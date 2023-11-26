package com.lakeland.ris.ui.datamodel;

import org.jetbrains.annotations.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;


public class PacsConfigurationBuilder
{
    @NotNull private String host;
    private int port;
    @NotNull private String aETitle;

    public PacsConfigurationBuilder(@NotNull String host,
                                    @NotNull String aETitle)
    {
        super();

        this.host = host;
        this.aETitle = aETitle;
    }


    @NotNull
    public PacsConfigurationBuilder setHost(@NotNull String host)
    {
        this.host = host;

        return self();
    }

    @NotNull
    public PacsConfigurationBuilder setPort(int port)
    {
        this.port = port;

        return self();
    }

    @NotNull
    public PacsConfigurationBuilder setAETitle(@NotNull String aETitle)
    {
        this.aETitle = aETitle;

        return self();
    }

    @NotNull
    protected String getHost()
    {
        return host;
    }

    protected int getPort()
    {
        return port;
    }

    @NotNull
    protected String getAETitle()
    {
        return aETitle;
    }

    @NotNull
    public PacsConfiguration build()
    {
        return new PacsConfiguration(getHost(),
                                     getPort(),
                                     getAETitle());
    }


    @NotNull
    protected PacsConfigurationBuilder self()
    {
        return this;
    }
}