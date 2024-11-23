package com.lakeland.hl7.datamodel;

import org.codehaus.jackson.annotate.*;

import java.util.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;


public class HL7Order extends TimedMessage implements HL7Visitable
{
    public static final byte TYPE = 3;
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

    public HL7Order()
    {
        // empty
    }

    @JsonCreator
    public HL7Order(Date timestamp,
                    String id,
                    String orderId,
                    String messageId,
                    boolean deleted,
                    OrderStatus status,
                    OrderPriority priority,
                     String assignedTo,
                     String dicomStudyId,
                    boolean critical,
                     UrgentExamType urgentExamType)
    {
        super(timestamp);

        this.id = id;
        this.orderId = orderId;
        this.messageId = messageId;
        this.deleted = deleted;
        this.status = status;
        this.priority = priority;
        this.assignedTo = assignedTo;
        this.dicomStudyId = dicomStudyId;
        this.critical = critical;
        this.urgentExamType = urgentExamType;
    }

    
    public String getId()
    {
        return id;
    }

    
    public String getOrderId()
    {
        return orderId;
    }

    
    public String getMessageId()
    {
        return messageId;
    }

    public boolean isDeleted()
    {
        return deleted;
    }

    
    public OrderStatus getStatus()
    {
        return status;
    }

    
    public OrderPriority getPriority()
    {
        return priority;
    }

    
    public String getAssignedTo()
    {
        return assignedTo;
    }

    
    public String getDicomStudyId()
    {
        return dicomStudyId;
    }

    public boolean isCritical()
    {
        return critical;
    }

    
    public UrgentExamType getUrgentExamType()
    {
        return urgentExamType;
    }
    public void setId(String id)
    {
        this.id = id;
    }

    public void setOrderId(String orderId)
    {
        this.orderId = orderId;
    }

    public void setMessageId(String messageId)
    {
        this.messageId = messageId;
    }

    public void setDeleted(boolean deleted)
    {
        this.deleted = deleted;
    }

    public void setStatus(OrderStatus status)
    {
        this.status = status;
    }

    public void setPriority(OrderPriority priority)
    {
        this.priority = priority;
    }

    public void setAssignedTo( String assignedTo)
    {
        this.assignedTo = assignedTo;
    }

    public void setDicomStudyId( String dicomStudyId)
    {
        this.dicomStudyId = dicomStudyId;
    }

    public void setCritical(boolean critical)
    {
        this.critical = critical;
    }

    public void setUrgentExamType( UrgentExamType urgentExamType)
    {
        this.urgentExamType = urgentExamType;
    }

    public void accept(HL7Visitor aVisitor)
    {
        aVisitor.visit(this);
    }

    
    public String toString()
    {
        return "HL7Order(" +
            super.toString() +
            " id: " + getId() +
            " orderId: " + getOrderId() +
            " messageId: " + getMessageId() +
            " deleted: " + isDeleted() +
            " status: " + getStatus() +
            " priority: " + getPriority() +
            " assignedTo: " + getAssignedTo() +
            " dicomStudyId: " + getDicomStudyId() +
            " critical: " + isCritical() +
            " urgentExamType: " + getUrgentExamType() + ")";
    }


    @Override
    public boolean equals( Object aObject)
    {
          if (this == aObject)
          {
              return true;
          }

          if (aObject == null || getClass() != aObject.getClass())
          {
              return false;
          }

          if (!super.equals(aObject))
          {
              return false;
          }

          final HL7Order myObject = (HL7Order) aObject;

          return Objects.equals(getId(), myObject.getId()) && 
                 Objects.equals(getOrderId(), myObject.getOrderId()) && 
                 Objects.equals(getMessageId(), myObject.getMessageId()) && 
                 Objects.equals(isDeleted(), myObject.isDeleted()) && 
                 Objects.equals(getStatus(), myObject.getStatus()) && 
                 Objects.equals(getPriority(), myObject.getPriority()) && 
                 Objects.equals(getAssignedTo(), myObject.getAssignedTo()) && 
                 Objects.equals(getDicomStudyId(), myObject.getDicomStudyId()) && 
                 Objects.equals(isCritical(), myObject.isCritical()) && 
                 Objects.equals(getUrgentExamType(), myObject.getUrgentExamType());
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(super.hashCode(),
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

    
    public HL7OrderBuilder toBuilder()
    {
        return new HL7OrderBuilder(getTimestamp(),
                                   getId(),
                                   getOrderId(),
                                   getMessageId(),
                                   getStatus(),
                                   getPriority()).setDeleted(isDeleted())


                                                  .setAssignedTo(getAssignedTo())
                                                  .setDicomStudyId(getDicomStudyId())
                                                  .setCritical(isCritical())
                                                  .setUrgentExamType(getUrgentExamType());
    }
}