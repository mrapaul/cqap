package com.lakeland.hl7.datamodel;

import org.codehaus.jackson.annotate.*;
import org.jetbrains.annotations.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;


public class HL7RawMessage implements HL7Visitable
{
    public static final byte TYPE = 15;
    @NotNull private String message;

    public HL7RawMessage()
    {
        // empty
    }

    @JsonCreator
    public HL7RawMessage(@NotNull String message)
    {
        super();

        this.message = message;
    }

    @NotNull
    public String getMessage()
    {
        return message;
    }
    public void setMessage(@NotNull String message)
    {
        this.message = message;
    }

    public void accept(@NotNull HL7Visitor aVisitor)
    {
        aVisitor.visit(this);
    }

    @NotNull
    public String toString()
    {
        return "HL7RawMessage(" +
            " message: " + getMessage() + ")";
    }

    @NotNull
    public HL7RawMessageBuilder toBuilder()
    {
        return new HL7RawMessageBuilder(getMessage());
    }
}