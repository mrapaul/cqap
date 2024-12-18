package com.peirs.datamodel.hl7;


import org.springframework.data.annotation.*;
import org.springframework.data.mongodb.core.mapping.*;

@Document(collection = "MergeHL7Messages")
public class MergeHL7Message
{
    @Id private String theId;
    private String theMessage;

    public MergeHL7Message()
    {
        // empty
    }

    public MergeHL7Message(String aMessage)
    {
        theMessage = aMessage;
    }

    public String getId()
    {
        return theId;
    }

    public void setId(String aId)
    {
        theId = aId;
    }

    public String getMessage()
    {
        return theMessage;
    }

    public void setMessage(String aMessage)
    {
        theMessage = aMessage;
    }
}
