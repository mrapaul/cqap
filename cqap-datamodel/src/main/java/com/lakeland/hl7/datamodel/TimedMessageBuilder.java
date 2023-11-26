package com.lakeland.hl7.datamodel;

import org.jetbrains.annotations.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;


public abstract class TimedMessageBuilder<M, B extends TimedMessageBuilder<M, B>> 
{
    @NotNull private Date timestamp;

    public TimedMessageBuilder(@NotNull Date timestamp)
    {
        super();

        this.timestamp = timestamp;
    }


    @NotNull
    public B setTimestamp(@NotNull Date timestamp)
    {
        this.timestamp = timestamp;

        return self();
    }

    @NotNull
    protected Date getTimestamp()
    {
        return timestamp;
    }

    @NotNull
    public abstract M build();


    @NotNull
    protected B self()
    {
        return (B) this;
    }
}