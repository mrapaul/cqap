package com.lakeland.hl7.datamodel;


import java.util.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;


public class HL7OrderBuilder extends TimedMessageBuilder<HL7Order, HL7OrderBuilder>
{
    private String id;
    private String orderId;
    private String messageId;
    private boolean deleted;
    private OrderStatus status;
    private OrderPriority priority;
     private String assignedTo;
     private String dicomStudyId;
    private boolean critical;
     private UrgentExamType urgentExamType;

    public HL7OrderBuilder(Date timestamp,
                           String id,
                           String orderId,
                           String messageId,
                           OrderStatus status,
                           OrderPriority priority)
    {
        super(timestamp);

        this.id = id;
        this.orderId = orderId;
        this.messageId = messageId;
        this.status = status;
        this.priority = priority;
    }



    @Override
    public HL7OrderBuilder setTimestamp(Date timestamp)
    {
        super.setTimestamp(timestamp);

        return self();
    }


    public HL7OrderBuilder setId(String id)
    {
        this.id = id;

        return self();
    }


    public HL7OrderBuilder setOrderId(String orderId)
    {
        this.orderId = orderId;

        return self();
    }


    public HL7OrderBuilder setMessageId(String messageId)
    {
        this.messageId = messageId;

        return self();
    }


    public HL7OrderBuilder setDeleted(boolean deleted)
    {
        this.deleted = deleted;

        return self();
    }


    public HL7OrderBuilder setStatus(OrderStatus status)
    {
        this.status = status;

        return self();
    }


    public HL7OrderBuilder setPriority(OrderPriority priority)
    {
        this.priority = priority;

        return self();
    }


    public HL7OrderBuilder setAssignedTo( String assignedTo)
    {
        this.assignedTo = assignedTo;

        return self();
    }


    public HL7OrderBuilder setDicomStudyId( String dicomStudyId)
    {
        this.dicomStudyId = dicomStudyId;

        return self();
    }


    public HL7OrderBuilder setCritical(boolean critical)
    {
        this.critical = critical;

        return self();
    }


    public HL7OrderBuilder setUrgentExamType( UrgentExamType urgentExamType)
    {
        this.urgentExamType = urgentExamType;

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


    protected String getMessageId()
    {
        return messageId;
    }

    protected boolean isDeleted()
    {
        return deleted;
    }


    protected OrderStatus getStatus()
    {
        return status;
    }


    protected OrderPriority getPriority()
    {
        return priority;
    }

    
    protected String getAssignedTo()
    {
        return assignedTo;
    }

    
    protected String getDicomStudyId()
    {
        return dicomStudyId;
    }

    protected boolean isCritical()
    {
        return critical;
    }

    
    protected UrgentExamType getUrgentExamType()
    {
        return urgentExamType;
    }

    @Override

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

    protected HL7OrderBuilder self()
    {
        return this;
    }
}