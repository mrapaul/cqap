package com.lakeland.hl7.datamodel;

import org.jetbrains.annotations.*;
import java.util.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;


public class CreateDicomOrderBuilder extends TimedMessageBuilder<CreateDicomOrder, CreateDicomOrderBuilder>
{
    @NotNull private String userId;
    @NotNull private String dicomStudyId;
    @NotNull private String patientHistory;
    @NotNull private String referringPhysician;
    @NotNull private OrderPriority priority;
    @Nullable private String assignedTo;
    @Nullable private String techNote;

    public CreateDicomOrderBuilder(@NotNull Date timestamp,
                                   @NotNull String userId,
                                   @NotNull String dicomStudyId,
                                   @NotNull String patientHistory,
                                   @NotNull String referringPhysician,
                                   @NotNull OrderPriority priority)
    {
        super(timestamp);

        this.userId = userId;
        this.dicomStudyId = dicomStudyId;
        this.patientHistory = patientHistory;
        this.referringPhysician = referringPhysician;
        this.priority = priority;
    }


    @NotNull
    @Override
    public CreateDicomOrderBuilder setTimestamp(@NotNull Date timestamp)
    {
        super.setTimestamp(timestamp);

        return self();
    }

    @NotNull
    public CreateDicomOrderBuilder setUserId(@NotNull String userId)
    {
        this.userId = userId;

        return self();
    }

    @NotNull
    public CreateDicomOrderBuilder setDicomStudyId(@NotNull String dicomStudyId)
    {
        this.dicomStudyId = dicomStudyId;

        return self();
    }

    @NotNull
    public CreateDicomOrderBuilder setPatientHistory(@NotNull String patientHistory)
    {
        this.patientHistory = patientHistory;

        return self();
    }

    @NotNull
    public CreateDicomOrderBuilder setReferringPhysician(@NotNull String referringPhysician)
    {
        this.referringPhysician = referringPhysician;

        return self();
    }

    @NotNull
    public CreateDicomOrderBuilder setPriority(@NotNull OrderPriority priority)
    {
        this.priority = priority;

        return self();
    }

    @NotNull
    public CreateDicomOrderBuilder setAssignedTo(@Nullable String assignedTo)
    {
        this.assignedTo = assignedTo;

        return self();
    }

    @NotNull
    public CreateDicomOrderBuilder setTechNote(@Nullable String techNote)
    {
        this.techNote = techNote;

        return self();
    }

    @NotNull
    protected String getUserId()
    {
        return userId;
    }

    @NotNull
    protected String getDicomStudyId()
    {
        return dicomStudyId;
    }

    @NotNull
    protected String getPatientHistory()
    {
        return patientHistory;
    }

    @NotNull
    protected String getReferringPhysician()
    {
        return referringPhysician;
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
    protected String getTechNote()
    {
        return techNote;
    }

    @Override
    @NotNull
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
    @NotNull
    protected CreateDicomOrderBuilder self()
    {
        return this;
    }
}