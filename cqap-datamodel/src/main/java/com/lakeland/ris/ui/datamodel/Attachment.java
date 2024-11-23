package com.lakeland.ris.ui.datamodel;

import org.codehaus.jackson.annotate.*;

import java.util.*;
import com.lakeland.ris.datamodel.*;


public class Attachment
{
    private String id;
    private String orderId;
    private String fileName;
    private Date uploadDate;

    public Attachment()
    {
        // empty
    }

    @JsonCreator
    public Attachment(String id,
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


    public String getId()
    {
        return id;
    }


    public String getOrderId()
    {
        return orderId;
    }


    public String getFileName()
    {
        return fileName;
    }


    public Date getUploadDate()
    {
        return uploadDate;
    }
    public void setId(String id)
    {
        this.id = id;
    }

    public void setOrderId(String orderId)
    {
        this.orderId = orderId;
    }

    public void setFileName(String fileName)
    {
        this.fileName = fileName;
    }

    public void setUploadDate(Date uploadDate)
    {
        this.uploadDate = uploadDate;
    }


    public String toString()
    {
        return "Attachment(" +
            " id: " + getId() +
            " orderId: " + getOrderId() +
            " fileName: " + getFileName() +
            " uploadDate: " + getUploadDate() + ")";
    }


    public AttachmentBuilder toBuilder()
    {
        return new AttachmentBuilder(getId(),
                                     getOrderId(),
                                     getFileName(),
                                     getUploadDate());
    }
}