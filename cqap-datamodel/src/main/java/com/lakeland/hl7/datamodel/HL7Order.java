package com.lakeland.hl7.datamodel;

import org.codehaus.jackson.annotate.*;
import org.jetbrains.annotations.*;
import java.util.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;


public class HL7Order extends TimedMessage implements HL7Visitable
{
    public static final byte TYPE = 3;
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

    public HL7Order()
    {
        // empty
    }

    @JsonCreator
    public HL7Order(@NotNull Date timestamp,
                    @NotNull String id,
                    @NotNull String orderId,
                    @NotNull String messageId,
                    boolean deleted,
                    @NotNull OrderStatus status,
                    @NotNull OrderPriority priority,
                    @Nullable String assignedTo,
                    @Nullable String dicomStudyId,
                    boolean critical,
                    @Nullable UrgentExamType urgentExamType)
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
    public String getMessageId()
    {
        return messageId;
    }

    public boolean isDeleted()
    {
        return deleted;
    }

    @NotNull
    public OrderStatus getStatus()
    {
        return status;
    }

    @NotNull
    public OrderPriority getPriority()
    {
        return priority;
    }

    @Nullable
    public String getAssignedTo()
    {
        return assignedTo;
    }

    @Nullable
    public String getDicomStudyId()
    {
        return dicomStudyId;
    }

    public boolean isCritical()
    {
        return critical;
    }

    @Nullable
    public UrgentExamType getUrgentExamType()
    {
        return urgentExamType;
    }
    public void setId(@NotNull String id)
    {
        this.id = id;
    }

    public void setOrderId(@NotNull String orderId)
    {
        this.orderId = orderId;
    }

    public void setMessageId(@NotNull String messageId)
    {
        this.messageId = messageId;
    }

    public void setDeleted(boolean deleted)
    {
        this.deleted = deleted;
    }

    public void setStatus(@NotNull OrderStatus status)
    {
        this.status = status;
    }

    public void setPriority(@NotNull OrderPriority priority)
    {
        this.priority = priority;
    }

    public void setAssignedTo(@Nullable String assignedTo)
    {
        this.assignedTo = assignedTo;
    }

    public void setDicomStudyId(@Nullable String dicomStudyId)
    {
        this.dicomStudyId = dicomStudyId;
    }

    public void setCritical(boolean critical)
    {
        this.critical = critical;
    }

    public void setUrgentExamType(@Nullable UrgentExamType urgentExamType)
    {
        this.urgentExamType = urgentExamType;
    }

    public void accept(@NotNull HL7Visitor aVisitor)
    {
        aVisitor.visit(this);
    }

    @NotNull
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
    public boolean equals(@Nullable Object aObject)
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

    @NotNull
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