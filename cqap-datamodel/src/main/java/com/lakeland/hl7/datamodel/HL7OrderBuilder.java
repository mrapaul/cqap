package com.lakeland.hl7.datamodel;

import org.jetbrains.annotations.*;
import java.util.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;


public class HL7OrderBuilder extends TimedMessageBuilder<HL7Order, HL7OrderBuilder>
{
    @NotNull private String id;
    @NotNull private String orderId;
    @NotNull private String messageId;
    private boolean deleted;
    @NotNull private OrderStatus status;
    @NotNull private OrderPriority priority;
    @Nullable private String assignedTo;
    @Nullable private String dicomStudyId;
    private boolean critical;
    @Nullable private UrgentExamType urgentExamType;

    public HL7OrderBuilder(@NotNull Date timestamp,
                           @NotNull String id,
                           @NotNull String orderId,
                           @NotNull String messageId,
                           @NotNull OrderStatus status,
                           @NotNull OrderPriority priority)
    {
        super(timestamp);

        this.id = id;
        this.orderId = orderId;
        this.messageId = messageId;
        this.status = status;
        this.priority = priority;
    }


    @NotNull
    @Override
    public HL7OrderBuilder setTimestamp(@NotNull Date timestamp)
    {
        super.setTimestamp(timestamp);

        return self();
    }

    @NotNull
    public HL7OrderBuilder setId(@NotNull String id)
    {
        this.id = id;

        return self();
    }

    @NotNull
    public HL7OrderBuilder setOrderId(@NotNull String orderId)
    {
        this.orderId = orderId;

        return self();
    }

    @NotNull
    public HL7OrderBuilder setMessageId(@NotNull String messageId)
    {
        this.messageId = messageId;

        return self();
    }

    @NotNull
    public HL7OrderBuilder setDeleted(boolean deleted)
    {
        this.deleted = deleted;

        return self();
    }

    @NotNull
    public HL7OrderBuilder setStatus(@NotNull OrderStatus status)
    {
        this.status = status;

        return self();
    }

    @NotNull
    public HL7OrderBuilder setPriority(@NotNull OrderPriority priority)
    {
        this.priority = priority;

        return self();
    }

    @NotNull
    public HL7OrderBuilder setAssignedTo(@Nullable String assignedTo)
    {
        this.assignedTo = assignedTo;

        return self();
    }

    @NotNull
    public HL7OrderBuilder setDicomStudyId(@Nullable String dicomStudyId)
    {
        this.dicomStudyId = dicomStudyId;

        return self();
    }

    @NotNull
    public HL7OrderBuilder setCritical(boolean critical)
    {
        this.critical = critical;

        return self();
    }

    @NotNull
    public HL7OrderBuilder setUrgentExamType(@Nullable UrgentExamType urgentExamType)
    {
        this.urgentExamType = urgentExamType;

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
    protected String getMessageId()
    {
        return messageId;
    }

    protected boolean isDeleted()
    {
        return deleted;
    }

    @NotNull
    protected OrderStatus getStatus()
    {
        return status;
    }

    @NotNull
    protected OrderPriority getPriority()
    {
        return priority;
    }

    @Nullable
    protected String getAssignedTo()
    {
        return assignedTo;
    }

    @Nullable
    protected String getDicomStudyId()
    {
        return dicomStudyId;
    }

    protected boolean isCritical()
    {
        return critical;
    }

    @Nullable
    protected UrgentExamType getUrgentExamType()
    {
        return urgentExamType;
    }

    @Override
    @NotNull
    public HL7Order build()
    {
        return new HL7Order(getTimestamp(),
                            getId(),
                            getOrderId(),
                            getMessageId(),
                            isDeleted(),
                            getStatus(),
                            getPriority(),
                            getAssignedTo(),
                            getDicomStudyId(),
                            isCritical(),
                            getUrgentExamType());
    }


    @Override
    @NotNull
    protected HL7OrderBuilder self()
    {
        return this;
    }
}