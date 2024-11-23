package com.lakeland.ris.ui.datamodel;

import org.codehaus.jackson.annotate.*;

import java.util.*;
import com.lakeland.ris.datamodel.*;
import java.util.*;

public class Attachments
{
    private Collection<Attachment> attachments;

    public Attachments()
    {
        // empty
    }

    @JsonCreator
    public Attachments(Collection<Attachment> attachments)
    {
        super();

        this.attachments = attachments;
    }


    public Collection<Attachment> getAttachments()
    {
        return attachments;
    }
    public void setAttachments(Collection<Attachment> attachments)
    {
        this.attachments = attachments;
    }


    public String toString()
    {
        return "Attachments(" +
            " attachments: " + getAttachments() + ")";
    }


    public AttachmentsBuilder toBuilder()
    {
        return new AttachmentsBuilder(getAttachments());
    }
}