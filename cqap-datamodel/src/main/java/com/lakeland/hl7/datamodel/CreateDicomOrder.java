package com.lakeland.hl7.datamodel;

import org.codehaus.jackson.annotate.*;
import org.jetbrains.annotations.*;
import java.util.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;


public class CreateDicomOrder extends TimedMessage implements HL7Visitable
{
    public static final byte TYPE = 33;
    @NotNull private String userId;
    @NotNull private String dicomStudyId;
    @NotNull private String patientHistory;
    @NotNull private String referringPhysician;
    @NotNull private OrderPriority priority;
    @Nullable private String assignedTo;
    @Nullable private String techNote;

    public CreateDicomOrder()
    {
        // empty
    }

    @JsonCreator
    public CreateDicomOrder(@NotNull Date timestamp,
                            @NotNull String userId,
                            @NotNull String dicomStudyId,
                            @NotNull String patientHistory,
                            @NotNull String referringPhysician,
                            @NotNull OrderPriority priority,
                            @Nullable String assignedTo,
                            @Nullable String techNote)
    {
        super(timestamp);

        this.userId = userId;
        this.dicomStudyId = dicomStudyId;
        this.patientHistory = patientHistory;
        this.referringPhysician = referringPhysician;
        this.priority = priority;
        this.assignedTo = assignedTo;
        this.techNote = techNote;
    }

    @NotNull
    public String getUserId()
    {
        return userId;
    }

    @NotNull
    public String getDicomStudyId()
    {
        return dicomStudyId;
    }

    @NotNull
    public String getPatientHistory()
    {
        return patientHistory;
    }

    @NotNull
    public String getReferringPhysician()
    {
        return referringPhysician;
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
    public String getTechNote()
    {
        return techNote;
    }
    public void setUserId(@NotNull String userId)
    {
        this.userId = userId;
    }

    public void setDicomStudyId(@NotNull String dicomStudyId)
    {
        this.dicomStudyId = dicomStudyId;
    }

    public void setPatientHistory(@NotNull String patientHistory)
    {
        this.patientHistory = patientHistory;
    }

    public void setReferringPhysician(@NotNull String referringPhysician)
    {
        this.referringPhysician = referringPhysician;
    }

    public void setPriority(@NotNull OrderPriority priority)
    {
        this.priority = priority;
    }

    public void setAssignedTo(@Nullable String assignedTo)
    {
        this.assignedTo = assignedTo;
    }

    public void setTechNote(@Nullable String techNote)
    {
        this.techNote = techNote;
    }

    public void accept(@NotNull HL7Visitor aVisitor)
    {
        aVisitor.visit(this);
    }

    @NotNull
    public String toString()
    {
        return "CreateDicomOrder(" +
            super.toString() +
            " userId: " + getUserId() +
            " dicomStudyId: " + getDicomStudyId() +
            " patientHistory: " + getPatientHistory() +
            " referringPhysician: " + getReferringPhysician() +
            " priority: " + getPriority() +
            " assignedTo: " + getAssignedTo() +
            " techNote: " + getTechNote() + ")";
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

          final CreateDicomOrder myObject = (CreateDicomOrder) aObject;

          return Objects.equals(getUserId(), myObject.getUserId()) && 
                 Objects.equals(getDicomStudyId(), myObject.getDicomStudyId()) && 
                 Objects.equals(getPatientHistory(), myObject.getPatientHistory()) && 
                 Objects.equals(getReferringPhysician(), myObject.getReferringPhysician()) && 
                 Objects.equals(getPriority(), myObject.getPriority()) && 
                 Objects.equals(getAssignedTo(), myObject.getAssignedTo()) && 
                 Objects.equals(getTechNote(), myObject.getTechNote());
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(super.hashCode(),
                            getUserId(),
                            getDicomStudyId(),
                            getPatientHistory(),
                            getReferringPhysician(),
                            getPriority(),
                            getAssignedTo(),
                            getTechNote());
    }

    @NotNull
    public CreateDicomOrderBuilder toBuilder()
    {
        return new CreateDicomOrderBuilder(getTimestamp(),
                                           getUserId(),
                                           getDicomStudyId(),
                                           getPatientHistory(),
                                           getReferringPhysician(),
                                           getPriority()).setAssignedTo(getAssignedTo())
                                                          .setTechNote(getTechNote());
    }
}