package com.lakeland.hl7.datamodel;


import java.util.*;
import com.lakeland.ris.datamodel.*;


public abstract class TimedMessageBuilder<M, B extends TimedMessageBuilder<M, B>> 
{
    private Date timestamp;

    public TimedMessageBuilder(Date timestamp)
    {
        super();

        this.timestamp = timestamp;
    }


    
    public B setTimestamp(Date timestamp)
    {
        this.timestamp = timestamp;

        return self();
    }

    
    protected Date getTimestamp()
    {
        return timestamp;
    }

    
    public abstract M build();


    
    protected B self()
    {
        return (B) this;
    }
}