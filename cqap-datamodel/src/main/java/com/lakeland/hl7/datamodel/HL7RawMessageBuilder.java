package com.lakeland.hl7.datamodel;


import java.util.*;
import com.lakeland.ris.datamodel.*;


public class HL7RawMessageBuilder
{
    private String message;

    public HL7RawMessageBuilder(String message)
    {
        super();

        this.message = message;
    }


    
    public HL7RawMessageBuilder setMessage(String message)
    {
        this.message = message;

        return self();
    }

    
    protected String getMessage()
    {
        return message;
    }

    
    public HL7RawMessage build()
    {
        return new HL7RawMessage(getMessage());
    }


    
    protected HL7RawMessageBuilder self()
    {
        return this;
    }
}