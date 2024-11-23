package com.lakeland.hl7.datamodel;

import org.codehaus.jackson.annotate.*;

import java.util.*;
import com.lakeland.ris.datamodel.*;


public class HL7RawMessage implements HL7Visitable
{
    public static final byte TYPE = 15;
    private String message;

    public HL7RawMessage()
    {
        // empty
    }

    @JsonCreator
    public HL7RawMessage(String message)
    {
        super();

        this.message = message;
    }

    
    public String getMessage()
    {
        return message;
    }
    public void setMessage(String message)
    {
        this.message = message;
    }

    public void accept(HL7Visitor aVisitor)
    {
        aVisitor.visit(this);
    }

    
    public String toString()
    {
        return "HL7RawMessage(" +
            " message: " + getMessage() + ")";
    }

    
    public HL7RawMessageBuilder toBuilder()
    {
        return new HL7RawMessageBuilder(getMessage());
    }
}