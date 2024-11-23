package com.lakeland.hl7.datamodel;


import java.util.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;


public class AssignImageBuilder extends TimedMessageBuilder<AssignImage, AssignImageBuilder>
{
    private String userId;
    private String orderId;
    private String dicomStudyId;

    public AssignImageBuilder(Date timestamp,
                              String userId,
                              String orderId,
                              String dicomStudyId)
    {
        super(timestamp);

        this.userId = userId;
        this.orderId = orderId;
        this.dicomStudyId = dicomStudyId;
    }



    @Override
    public AssignImageBuilder setTimestamp(Date timestamp)
    {
        super.setTimestamp(timestamp);

        return self();
    }


    public AssignImageBuilder setUserId(String userId)
    {
        this.userId = userId;

        return self();
    }


    public AssignImageBuilder setOrderId(String orderId)
    {
        this.orderId = orderId;

        return self();
    }


    public AssignImageBuilder setDicomStudyId(String dicomStudyId)
    {
        this.dicomStudyId = dicomStudyId;

        return self();
    }


    protected String getUserId()
    {
        return userId;
    }


    protected String getOrderId()
    {
        return orderId;
    }


    protected String getDicomStudyId()
    {
        return dicomStudyId;
    }

    @Override

    public AssignImage build()
    {
        return new AssignImage(getTimestamp(),
                               getUserId(),
                               getOrderId(),
                               getDicomStudyId());
    }


    @Override

    protected AssignImageBuilder self()
    {
        return this;
    }
}