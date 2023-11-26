package com.peirs.datamodel;

import org.springframework.data.mongodb.core.mapping.*;

@SuppressWarnings("serial")
@Document(collection = "Counter")
public class Counter
{
    private String theName;
    private long theSequence;

    public String getName()
    {
        return theName;
    }

    public void setName(String aName)
    {
        theName = aName;
    }

    public long getSequence()
    {
        return theSequence;
    }

    public void setSequence(long aSequence)
    {
        theSequence = aSequence;
    }
}
