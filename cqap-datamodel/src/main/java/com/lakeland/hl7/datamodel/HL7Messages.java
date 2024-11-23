package com.lakeland.hl7.datamodel;

import org.codehaus.jackson.annotate.*;

import java.util.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;
import java.util.*;

public class HL7Messages implements HL7Visitable
{
    public static final byte TYPE = 2;
    private Collection<HL7Message> messages;

    public HL7Messages()
    {
        // empty
    }

    @JsonCreator
    public HL7Messages(Collection<HL7Message> messages)
    {
        super();

        this.messages = messages;
    }

    
    public Collection<HL7Message> getMessages()
    {
        return messages;
    }
    public void setMessages(Collection<HL7Message> messages)
    {
        this.messages = messages;
    }

    public void accept(HL7Visitor aVisitor)
    {
        aVisitor.visit(this);
    }

    
    public String toString()
    {
        return "HL7Messages(" +
            " messages: " + getMessages() + ")";
    }


    @Override
    public boolean equals( Object aObject)
    {
          if (this == aObject)
          {
              return true;
          }

          if (aObject == null || getClass() != aObject.getClass())
          {
              return false;
          }

          final HL7Messages myObject = (HL7Messages) aObject;

          return Objects.equals(getMessages(), myObject.getMessages());
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(
                            getMessages());
    }

    
    public HL7MessagesBuilder toBuilder()
    {
        return new HL7MessagesBuilder(getMessages());
    }
}