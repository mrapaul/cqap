package com.lakeland.ris.ui.datamodel;

import org.jetbrains.annotations.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;


public class AttachmentBuilder
{
    @NotNull private String id;
    @NotNull private String orderId;
    @NotNull private String fileName;
    @NotNull private Date uploadDate;

    public AttachmentBuilder(@NotNull String id,
                             @NotNull String orderId,
                             @NotNull String fileName,
                             @NotNull Date uploadDate)
    {
        super();

        this.id = id;
        this.orderId = orderId;
        this.fileName = fileName;
        this.uploadDate = uploadDate;
    }


    @NotNull
    public AttachmentBuilder setId(@NotNull String id)
    {
        this.id = id;

        return self();
    }

    @NotNull
    public AttachmentBuilder setOrderId(@NotNull String orderId)
    {
        this.orderId = orderId;

        return self();
    }

    @NotNull
    public AttachmentBuilder setFileName(@NotNull String fileName)
    {
        this.fileName = fileName;

        return self();
    }

    @NotNull
    public AttachmentBuilder setUploadDate(@NotNull Date uploadDate)
    {
        this.uploadDate = uploadDate;

        return self();
    }

    @NotNull
    protected String getId()
    {
        return id;
    }

    @NotNull
    protected String getOrderId()
    {
        return orderId;
    }

    @NotNull
    protected String getFileName()
    {
        return fileName;
    }

    @NotNull
    protected Date getUploadDate()
    {
        return uploadDate;
    }

    @NotNull
    public Attachment build()
    {
        return new Attachment(getId(),
                              getOrderId(),
                              getFileName(),
                              getUploadDate());
    }


    @NotNull
    protected AttachmentBuilder self()
    {
        return this;
    }
}