package com.lakeland.hl7.datamodel;

import org.jetbrains.annotations.*;
import java.util.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;


public class AssignImageBuilder extends TimedMessageBuilder<AssignImage, AssignImageBuilder>
{
    @NotNull private String userId;
    @NotNull private String orderId;
    @NotNull private String dicomStudyId;

    public AssignImageBuilder(@NotNull Date timestamp,
                              @NotNull String userId,
                              @NotNull String orderId,
                              @NotNull String dicomStudyId)
    {
        super(timestamp);

        this.userId = userId;
        this.orderId = orderId;
        this.dicomStudyId = dicomStudyId;
    }


    @NotNull
    @Override
    public AssignImageBuilder setTimestamp(@NotNull Date timestamp)
    {
        super.setTimestamp(timestamp);

        return self();
    }

    @NotNull
    public AssignImageBuilder setUserId(@NotNull String userId)
    {
        this.userId = userId;

        return self();
    }

    @NotNull
    public AssignImageBuilder setOrderId(@NotNull String orderId)
    {
        this.orderId = orderId;

        return self();
    }

    @NotNull
    public AssignImageBuilder setDicomStudyId(@NotNull String dicomStudyId)
    {
        this.dicomStudyId = dicomStudyId;

        return self();
    }

    @NotNull
    protected String getUserId()
    {
        return userId;
    }

    @NotNull
    protected String getOrderId()
    {
        return orderId;
    }

    @NotNull
    protected String getDicomStudyId()
    {
        return dicomStudyId;
    }

    @Override
    @NotNull
    public AssignImage build()
    {
        return new AssignImage(getTimestamp(),
                               getUserId(),
                               getOrderId(),
                               getDicomStudyId());
    }


    @Override
    @NotNull
    protected AssignImageBuilder self()
    {
        return this;
    }
}