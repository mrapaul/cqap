package com.lakeland.hl7.datamodel;

import org.codehaus.jackson.annotate.*;
import org.jetbrains.annotations.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;


public abstract class TimedMessage implements HL7Visitable
{
    @NotNull private Date timestamp;

    public TimedMessage()
    {
        // empty
    }

    @JsonCreator
    public TimedMessage(@NotNull Date timestamp)
    {
        super();

        this.timestamp = timestamp;
    }

    @NotNull
    public Date getTimestamp()
    {
        return timestamp;
    }
    public void setTimestamp(@NotNull Date timestamp)
    {
        this.timestamp = timestamp;
    }

    @NotNull
    public String toString()
    {
        return "TimedMessage(" +
            " timestamp: " + getTimestamp() + ")";
    }

}