package com.lakeland.hl7.datamodel;


import java.util.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;
import java.util.Date;


public class HL7MessageBuilder
{
     private String id;
     private String viewId;
    private Date received;
    private String type;
    private String version;
    private String rawMessage;

    public HL7MessageBuilder(Date received,
                             String type,
                             String version,
                             String rawMessage)
    {
        super();

        this.received = received;
        this.type = type;
        this.version = version;
        this.rawMessage = rawMessage;
    }



    public HL7MessageBuilder setId( String id)
    {
        this.id = id;

        return self();
    }


    public HL7MessageBuilder setViewId( String viewId)
    {
        this.viewId = viewId;

        return self();
    }


    public HL7MessageBuilder setReceived(Date received)
    {
        this.received = received;

        return self();
    }


    public HL7MessageBuilder setType(String type)
    {
        this.type = type;

        return self();
    }


    public HL7MessageBuilder setVersion(String version)
    {
        this.version = version;

        return self();
    }


    public HL7MessageBuilder setRawMessage(String rawMessage)
    {
        this.rawMessage = rawMessage;

        return self();
    }

    
    protected String getId()
    {
        return id;
    }

    
    protected String getViewId()
    {
        return viewId;
    }


    protected Date getReceived()
    {
        return received;
    }


    protected String getType()
    {
        return type;
    }


    protected String getVersion()
    {
        return version;
    }


    protected String getRawMessage()
    {
        return rawMessage;
    }


    public HL7Message build()
    {
        return new HL7Message(getId(),
                              getViewId(),
                              getReceived(),
                              getType(),
                              getVersion(),
                              getRawMessage());
    }



    protected HL7MessageBuilder self()
    {
        return this;
    }
}