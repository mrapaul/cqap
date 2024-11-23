package com.lakeland.hl7.datamodel;

import org.codehaus.jackson.annotate.*;

import java.util.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;


public class CreateDicomOrder extends TimedMessage implements HL7Visitable
{
    public static final byte TYPE = 33;
    private String userId;
    private String dicomStudyId;
    private String patientHistory;
    private String referringPhysician;
    private OrderPriority priority;
     private String assignedTo;
     private String techNote;

    public CreateDicomOrder()
    {
        // empty
    }

    @JsonCreator
    public CreateDicomOrder(Date timestamp,
                            String userId,
                            String dicomStudyId,
                            String patientHistory,
                            String referringPhysician,
                            OrderPriority priority,
                             String assignedTo,
                             String techNote)
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


    public String getUserId()
    {
        return userId;
    }


    public String getDicomStudyId()
    {
        return dicomStudyId;
    }


    public String getPatientHistory()
    {
        return patientHistory;
    }


    public String getReferringPhysician()
    {
        return referringPhysician;
    }


    public OrderPriority getPriority()
    {
        return priority;
    }

    
    public String getAssignedTo()
    {
        return assignedTo;
    }

    
    public String getTechNote()
    {
        return techNote;
    }
    public void setUserId(String userId)
    {
        this.userId = userId;
    }

    public void setDicomStudyId(String dicomStudyId)
    {
        this.dicomStudyId = dicomStudyId;
    }

    public void setPatientHistory(String patientHistory)
    {
        this.patientHistory = patientHistory;
    }

    public void setReferringPhysician(String referringPhysician)
    {
        this.referringPhysician = referringPhysician;
    }

    public void setPriority(OrderPriority priority)
    {
        this.priority = priority;
    }

    public void setAssignedTo( String assignedTo)
    {
        this.assignedTo = assignedTo;
    }

    public void setTechNote( String techNote)
    {
        this.techNote = techNote;
    }

    public void accept(HL7Visitor aVisitor)
    {
        aVisitor.visit(this);
    }


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