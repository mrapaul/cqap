package com.lakeland.ris.ui.datamodel;


import java.util.*;
import com.lakeland.ris.datamodel.*;


public class AttachmentBuilder
{
    private String id;
    private String orderId;
    private String fileName;
    private Date uploadDate;

    public AttachmentBuilder(String id,
                             String orderId,
                             String fileName,
                             Date uploadDate)
    {
        super();

        this.id = id;
        this.orderId = orderId;
        this.fileName = fileName;
        this.uploadDate = uploadDate;
    }



    public AttachmentBuilder setId(String id)
    {
        this.id = id;

        return self();
    }


    public AttachmentBuilder setOrderId(String orderId)
    {
        this.orderId = orderId;

        return self();
    }


    public AttachmentBuilder setFileName(String fileName)
    {
        this.fileName = fileName;

        return self();
    }


    public AttachmentBuilder setUploadDate(Date uploadDate)
    {
        this.uploadDate = uploadDate;

        return self();
    }


    protected String getId()
    {
        return id;
    }


    protected String getOrderId()
    {
        return orderId;
    }


    protected String getFileName()
    {
        return fileName;
    }


    protected Date getUploadDate()
    {
        return uploadDate;
    }


    public Attachment build()
    {
        return new Attachment(getId(),
                              getOrderId(),
                              getFileName(),
                              getUploadDate());
    }



    protected AttachmentBuilder self()
    {
        return this;
    }
}