package com.lakeland.ris.ui.datamodel;

import org.codehaus.jackson.annotate.*;
import org.jetbrains.annotations.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;


public class Attachment
{
    @NotNull private String id;
    @NotNull private String orderId;
    @NotNull private String fileName;
    @NotNull private Date uploadDate;

    public Attachment()
    {
        // empty
    }

    @JsonCreator
    public Attachment(@NotNull String id,
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
    public String getId()
    {
        return id;
    }

    @NotNull
    public String getOrderId()
    {
        return orderId;
    }

    @NotNull
    public String getFileName()
    {
        return fileName;
    }

    @NotNull
    public Date getUploadDate()
    {
        return uploadDate;
    }
    public void setId(@NotNull String id)
    {
        this.id = id;
    }

    public void setOrderId(@NotNull String orderId)
    {
        this.orderId = orderId;
    }

    public void setFileName(@NotNull String fileName)
    {
        this.fileName = fileName;
    }

    public void setUploadDate(@NotNull Date uploadDate)
    {
        this.uploadDate = uploadDate;
    }

    @NotNull
    public String toString()
    {
        return "Attachment(" +
            " id: " + getId() +
            " orderId: " + getOrderId() +
            " fileName: " + getFileName() +
            " uploadDate: " + getUploadDate() + ")";
    }

    @NotNull
    public AttachmentBuilder toBuilder()
    {
        return new AttachmentBuilder(getId(),
                                     getOrderId(),
                                     getFileName(),
                                     getUploadDate());
    }
}