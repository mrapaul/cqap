package com.lakeland.ris.ui.datamodel;


import java.util.*;
import com.lakeland.ris.datamodel.*;
import java.util.*;

public class AttachmentsBuilder
{
    private Collection<Attachment> attachments;

    public AttachmentsBuilder(Collection<Attachment> attachments)
    {
        super();

        this.attachments = attachments;
    }



    public AttachmentsBuilder setAttachments(Collection<Attachment> attachments)
    {
        this.attachments = attachments;

        return self();
    }


    protected Collection<Attachment> getAttachments()
    {
        return attachments;
    }


    public Attachments build()
    {
        return new Attachments(getAttachments());
    }



    protected AttachmentsBuilder self()
    {
        return this;
    }
}