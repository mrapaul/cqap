package com.lakeland.hl7.datamodel;


import java.util.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;
import java.util.*;

public class HL7MessagesBuilder
{
    private Collection<HL7Message> messages;

    public HL7MessagesBuilder(Collection<HL7Message> messages)
    {
        super();

        this.messages = messages;
    }



    public HL7MessagesBuilder setMessages(Collection<HL7Message> messages)
    {
        this.messages = messages;

        return self();
    }


    protected Collection<HL7Message> getMessages()
    {
        return messages;
    }


    public HL7Messages build()
    {
        return new HL7Messages(getMessages());
    }



    protected HL7MessagesBuilder self()
    {
        return this;
    }
}