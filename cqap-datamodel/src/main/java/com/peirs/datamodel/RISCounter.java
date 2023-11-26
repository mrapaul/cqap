package com.peirs.datamodel;


import org.springframework.data.mongodb.core.mapping.*;

@SuppressWarnings("serial")
@Document(collection = "Counter")
public class RISCounter
{
    private String name;
    private long sequence;

    public String getName()
    {
        return name;
    }

    public void setName(String aName)
    {
        name = aName;
    }

    public long getSequence()
    {
        return sequence;
    }

    public void setSequence(long aSequence)
    {
        sequence = aSequence;
    }
}

