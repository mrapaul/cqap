package com.capstone.server.controller;

import com.mongodb.*;
import org.springframework.data.annotation.*;
import org.springframework.data.mongodb.core.index.*;
import org.springframework.data.mongodb.core.mapping.*;

import java.util.*;

@Document(collection = "HL7Messages")
public class Message
{
    @Id private String id;
    @Indexed private String viewId;
    @Indexed private Date received;
    @Indexed private String type;
    private String version;
    private String rawMessage;
    private BasicDBObject parsedMessage;

    public Message()
    {
        // empty
    }

    public Message(Date received,
                   String type,
                   String version,
                   String rawMessage,
                   BasicDBObject parsedMessage)
    {
        this.received = received;
        this.type = type;
        this.version = version;
        this.rawMessage = rawMessage;
        this.parsedMessage = parsedMessage;
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getViewId()
    {
        return viewId;
    }

    public void setViewId(String viewId)
    {
        this.viewId = viewId;
    }

    public Date getReceived()
    {
        return received;
    }

    public void setReceived(Date received)
    {
        this.received = received;
    }

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public String getVersion()
    {
        return version;
    }

    public void setVersion(String version)
    {
        this.version = version;
    }

    public String getRawMessage()
    {
        return rawMessage;
    }

    public void setRawMessage(String rawMessage)
    {
        this.rawMessage = rawMessage;
    }

    public BasicDBObject getParsedMessage()
    {
        return parsedMessage;
    }

    public void setParsedMessage(BasicDBObject parsedMessage)
    {
        this.parsedMessage = parsedMessage;
    }
}