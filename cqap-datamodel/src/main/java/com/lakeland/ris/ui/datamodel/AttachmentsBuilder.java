package com.lakeland.ris.ui.datamodel;

import org.jetbrains.annotations.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;
import java.util.*;

public class AttachmentsBuilder
{
    @NotNull private Collection<Attachment> attachments;

    public AttachmentsBuilder(@NotNull Collection<Attachment> attachments)
    {
        super();

        this.attachments = attachments;
    }


    @NotNull
    public AttachmentsBuilder setAttachments(@NotNull Collection<Attachment> attachments)
    {
        this.attachments = attachments;

        return self();
    }

    @NotNull
    protected Collection<Attachment> getAttachments()
    {
        return attachments;
    }

    @NotNull
    public Attachments build()
    {
        return new Attachments(getAttachments());
    }


    @NotNull
    protected AttachmentsBuilder self()
    {
        return this;
    }
}