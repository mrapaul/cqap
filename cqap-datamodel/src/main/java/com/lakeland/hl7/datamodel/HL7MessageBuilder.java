package com.lakeland.hl7.datamodel;

import org.jetbrains.annotations.*;
import java.util.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;
import java.util.Date;


public class HL7MessageBuilder
{
    @Nullable private String id;
    @Nullable private String viewId;
    @NotNull private Date received;
    @NotNull private String type;
    @NotNull private String version;
    @NotNull private String rawMessage;

    public HL7MessageBuilder(@NotNull Date received,
                             @NotNull String type,
                             @NotNull String version,
                             @NotNull String rawMessage)
    {
        super();

        this.received = received;
        this.type = type;
        this.version = version;
        this.rawMessage = rawMessage;
    }


    @NotNull
    public HL7MessageBuilder setId(@Nullable String id)
    {
        this.id = id;

        return self();
    }

    @NotNull
    public HL7MessageBuilder setViewId(@Nullable String viewId)
    {
        this.viewId = viewId;

        return self();
    }

    @NotNull
    public HL7MessageBuilder setReceived(@NotNull Date received)
    {
        this.received = received;

        return self();
    }

    @NotNull
    public HL7MessageBuilder setType(@NotNull String type)
    {
        this.type = type;

        return self();
    }

    @NotNull
    public HL7MessageBuilder setVersion(@NotNull String version)
    {
        this.version = version;

        return self();
    }

    @NotNull
    public HL7MessageBuilder setRawMessage(@NotNull String rawMessage)
    {
        this.rawMessage = rawMessage;

        return self();
    }

    @Nullable
    protected String getId()
    {
        return id;
    }

    @Nullable
    protected String getViewId()
    {
        return viewId;
    }

    @NotNull
    protected Date getReceived()
    {
        return received;
    }

    @NotNull
    protected String getType()
    {
        return type;
    }

    @NotNull
    protected String getVersion()
    {
        return version;
    }

    @NotNull
    protected String getRawMessage()
    {
        return rawMessage;
    }

    @NotNull
    public HL7Message build()
    {
        return new HL7Message(getId(),
                              getViewId(),
                              getReceived(),
                              getType(),
                              getVersion(),
                              getRawMessage());
    }


    @NotNull
    protected HL7MessageBuilder self()
    {
        return this;
    }
}