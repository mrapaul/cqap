package com.lakeland.hl7.datamodel;


import java.util.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;


public class CreateDicomOrderBuilder extends TimedMessageBuilder<CreateDicomOrder, CreateDicomOrderBuilder>
{
    private String userId;
    private String dicomStudyId;
    private String patientHistory;
    private String referringPhysician;
    private OrderPriority priority;
     private String assignedTo;
     private String techNote;

    public CreateDicomOrderBuilder(Date timestamp,
                                   String userId,
                                   String dicomStudyId,
                                   String patientHistory,
                                   String referringPhysician,
                                   OrderPriority priority)
    {
        super(timestamp);

        this.userId = userId;
        this.dicomStudyId = dicomStudyId;
        this.patientHistory = patientHistory;
        this.referringPhysician = referringPhysician;
        this.priority = priority;
    }


    
    @Override
    public CreateDicomOrderBuilder setTimestamp(Date timestamp)
    {
        super.setTimestamp(timestamp);

        return self();
    }

    
    public CreateDicomOrderBuilder setUserId(String userId)
    {
        this.userId = userId;

        return self();
    }

    
    public CreateDicomOrderBuilder setDicomStudyId(String dicomStudyId)
    {
        this.dicomStudyId = dicomStudyId;

        return self();
    }

    
    public CreateDicomOrderBuilder setPatientHistory(String patientHistory)
    {
        this.patientHistory = patientHistory;

        return self();
    }

    
    public CreateDicomOrderBuilder setReferringPhysician(String referringPhysician)
    {
        this.referringPhysician = referringPhysician;

        return self();
    }

    
    public CreateDicomOrderBuilder setPriority(OrderPriority priority)
    {
        this.priority = priority;

        return self();
    }

    
    public CreateDicomOrderBuilder setAssignedTo( String assignedTo)
    {
        this.assignedTo = assignedTo;

        return self();
    }

    
    public CreateDicomOrderBuilder setTechNote( String techNote)
    {
        this.techNote = techNote;

        return self();
    }

    
    protected String getUserId()
    {
        return userId;
    }

    
    protected String getDicomStudyId()
    {
        return dicomStudyId;
    }

    
    protected String getPatientHistory()
    {
        return patientHistory;
    }

    
    protected String getReferringPhysician()
    {
        return referringPhysician;
    }

    
    protected OrderPriority getPriority()
    {
        return priority;
    }

    
    protected String getAssignedTo()
    {
        return assignedTo;
    }

    
    protected String getTechNote()
    {
        return techNote;
    }

    @Override
    
    public CreateDicomOrder build()
    {
        return new CreateDicomOrder(getTimestamp(),
                                    getUserId(),
                                    getDicomStudyId(),
                                    getPatientHistory(),
                                    getReferringPhysician(),
                                    getPriority(),
                                    getAssignedTo(),
                                    getTechNote());
    }


    @Override
    
    protected CreateDicomOrderBuilder self()
    {
        return this;
    }
}