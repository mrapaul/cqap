package com.lakeland.hl7.datamodel;

import org.jetbrains.annotations.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;


public class HL7RawMessageBuilder
{
    @NotNull private String message;

    public HL7RawMessageBuilder(@NotNull String message)
    {
        super();

        this.message = message;
    }


    @NotNull
    public HL7RawMessageBuilder setMessage(@NotNull String message)
    {
        this.message = message;

        return self();
    }

    @NotNull
    protected String getMessage()
    {
        return message;
    }

    @NotNull
    public HL7RawMessage build()
    {
        return new HL7RawMessage(getMessage());
    }


    @NotNull
    protected HL7RawMessageBuilder self()
    {
        return this;
    }
}