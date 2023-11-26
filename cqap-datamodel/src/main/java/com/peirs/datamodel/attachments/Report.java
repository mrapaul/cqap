package com.peirs.datamodel.attachments;

import org.springframework.data.annotation.*;
import org.springframework.data.mongodb.core.mapping.*;

import java.io.*;

@Document(collection = "Reports")
public class Report
{
    @Id private String theId;
    @DBRef private String theTicketId;
    File theFile;

    public File getFile()
    {
        return theFile;
    }

    public void setFile(File aFile)
    {
        theFile = aFile;
    }

    public String getId()
    {
        return theId;
    }

    public void setId(String aId)
    {
        theId = aId;
    }

    public String getTicketId()
    {
        return theTicketId;
    }

    public void setTicketId(String aTicketId)
    {
        theTicketId = aTicketId;
    }
}
