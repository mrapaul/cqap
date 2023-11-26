package com.peirs.datamodel.attachments;

import java.util.*;

public class Attachments
{
    private List<Attachment> theAttachments;

    public Attachments()
    {
        theAttachments = new ArrayList<>();
    }

    public Attachments(List<Attachment> aAttachments)
    {
        theAttachments = aAttachments;
    }

    public List<Attachment> getAttachments()
    {
        return theAttachments;
    }

    public void setAttachments(List<Attachment> aAttachments)
    {
        theAttachments = aAttachments;
    }
}
