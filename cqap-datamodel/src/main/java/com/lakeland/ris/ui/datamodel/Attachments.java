package com.lakeland.ris.ui.datamodel;

import org.codehaus.jackson.annotate.*;
import org.jetbrains.annotations.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;
import java.util.*;

public class Attachments
{
    @NotNull private Collection<Attachment> attachments;

    public Attachments()
    {
        // empty
    }

    @JsonCreator
    public Attachments(@NotNull Collection<Attachment> attachments)
    {
        super();

        this.attachments = attachments;
    }

    @NotNull
    public Collection<Attachment> getAttachments()
    {
        return attachments;
    }
    public void setAttachments(@NotNull Collection<Attachment> attachments)
    {
        this.attachments = attachments;
    }

    @NotNull
    public String toString()
    {
        return "Attachments(" +
            " attachments: " + getAttachments() + ")";
    }

    @NotNull
    public AttachmentsBuilder toBuilder()
    {
        return new AttachmentsBuilder(getAttachments());
    }
}