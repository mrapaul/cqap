package com.lakeland.hl7.datamodel;

import org.codehaus.jackson.annotate.*;

import java.util.*;
import com.lakeland.ris.datamodel.*;


public abstract class TimedMessage implements HL7Visitable
{
    private Date timestamp;

    public TimedMessage()
    {
        // empty
    }

    @JsonCreator
    public TimedMessage(Date timestamp)
    {
        super();

        this.timestamp = timestamp;
    }

    
    public Date getTimestamp()
    {
        return timestamp;
    }
    public void setTimestamp(Date timestamp)
    {
        this.timestamp = timestamp;
    }

    
    public String toString()
    {
        return "TimedMessage(" +
            " timestamp: " + getTimestamp() + ")";
    }

}