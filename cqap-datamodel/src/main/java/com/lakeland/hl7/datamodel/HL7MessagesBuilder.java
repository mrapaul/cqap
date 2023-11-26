package com.lakeland.hl7.datamodel;

import org.jetbrains.annotations.*;
import java.util.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;
import java.util.*;

public class HL7MessagesBuilder
{
    @NotNull private Collection<HL7Message> messages;

    public HL7MessagesBuilder(@NotNull Collection<HL7Message> messages)
    {
        super();

        this.messages = messages;
    }


    @NotNull
    public HL7MessagesBuilder setMessages(@NotNull Collection<HL7Message> messages)
    {
        this.messages = messages;

        return self();
    }

    @NotNull
    protected Collection<HL7Message> getMessages()
    {
        return messages;
    }

    @NotNull
    public HL7Messages build()
    {
        return new HL7Messages(getMessages());
    }


    @NotNull
    protected HL7MessagesBuilder self()
    {
        return this;
    }
}