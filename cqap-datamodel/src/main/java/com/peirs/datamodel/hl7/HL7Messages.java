package com.peirs.datamodel.hl7;

import java.util.*;

public class HL7Messages
{
    private List<HL7> theMessages;

    public HL7Messages()
    {
        theMessages = new ArrayList<>();
    }

    public HL7Messages(List<HL7> aMessages)
    {
        theMessages = aMessages;
    }

    public List<HL7> getMessages()
    {
        return theMessages;
    }

    public void setMessages(List<HL7> aMessages)
    {
        theMessages = aMessages;
    }
}
