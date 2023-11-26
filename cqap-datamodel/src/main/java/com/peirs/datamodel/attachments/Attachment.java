package com.peirs.datamodel.attachments;

import java.util.*;

public class Attachment
{
    private String theId;
    private String theTicketId;
    private String theStudyId;
    private String theFilename;
    private Date theUploadDate;

    public Attachment()
    {
        // empty
    }

    public Attachment(String aId, String aTicketId, String aStudyId, String aFilename, Date aUploadDate)
    {
        theId = aId;
        theTicketId = aTicketId;
        theStudyId = aStudyId;
        theFilename = aFilename;
        theUploadDate = aUploadDate;
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

    public String getStudyId()
    {
        return theStudyId;
    }

    public void setStudyId(String aStudyId)
    {
        theStudyId = aStudyId;
    }

    public String getFilename()
    {
        return theFilename;
    }

    public void setFilename(String aFilename)
    {
        theFilename = aFilename;
    }

    public Date getUploadDate()
    {
        return theUploadDate;
    }

    public void setUploadDate(Date aUploadDate)
    {
        theUploadDate = aUploadDate;
    }
}
