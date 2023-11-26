package com.lakeland.ris.ui.datamodel;

import org.jetbrains.annotations.*;
import java.util.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;


public class HL7MessageItemBuilder
{
    @NotNull private String id;
    @NotNull private Date received;
    @NotNull private String institution;
    @NotNull private String patientID;
    @NotNull private String patientName;
    @NotNull private String accessionNumber;
    @NotNull private String modality;
    @NotNull private String studyDescription;

    public HL7MessageItemBuilder(@NotNull String id,
                                 @NotNull Date received,
                                 @NotNull String institution,
                                 @NotNull String patientID,
                                 @NotNull String patientName,
                                 @NotNull String accessionNumber,
                                 @NotNull String modality,
                                 @NotNull String studyDescription)
    {
        super();

        this.id = id;
        this.received = received;
        this.institution = institution;
        this.patientID = patientID;
        this.patientName = patientName;
        this.accessionNumber = accessionNumber;
        this.modality = modality;
        this.studyDescription = studyDescription;
    }


    @NotNull
    public HL7MessageItemBuilder setId(@NotNull String id)
    {
        this.id = id;

        return self();
    }

    @NotNull
    public HL7MessageItemBuilder setReceived(@NotNull Date received)
    {
        this.received = received;

        return self();
    }

    @NotNull
    public HL7MessageItemBuilder setInstitution(@NotNull String institution)
    {
        this.institution = institution;

        return self();
    }

    @NotNull
    public HL7MessageItemBuilder setPatientID(@NotNull String patientID)
    {
        this.patientID = patientID;

        return self();
    }

    @NotNull
    public HL7MessageItemBuilder setPatientName(@NotNull String patientName)
    {
        this.patientName = patientName;

        return self();
    }

    @NotNull
    public HL7MessageItemBuilder setAccessionNumber(@NotNull String accessionNumber)
    {
        this.accessionNumber = accessionNumber;

        return self();
    }

    @NotNull
    public HL7MessageItemBuilder setModality(@NotNull String modality)
    {
        this.modality = modality;

        return self();
    }

    @NotNull
    public HL7MessageItemBuilder setStudyDescription(@NotNull String studyDescription)
    {
        this.studyDescription = studyDescription;

        return self();
    }

    @NotNull
    protected String getId()
    {
        return id;
    }

    @NotNull
    protected Date getReceived()
    {
        return received;
    }

    @NotNull
    protected String getInstitution()
    {
        return institution;
    }

    @NotNull
    protected String getPatientID()
    {
        return patientID;
    }

    @NotNull
    protected String getPatientName()
    {
        return patientName;
    }

    @NotNull
    protected String getAccessionNumber()
    {
        return accessionNumber;
    }

    @NotNull
    protected String getModality()
    {
        return modality;
    }

    @NotNull
    protected String getStudyDescription()
    {
        return studyDescription;
    }

    @NotNull
    public HL7MessageItem build()
    {
        return new HL7MessageItem(getId(),
                                  getReceived(),
                                  getInstitution(),
                                  getPatientID(),
                                  getPatientName(),
                                  getAccessionNumber(),
                                  getModality(),
                                  getStudyDescription());
    }


    @NotNull
    protected HL7MessageItemBuilder self()
    {
        return this;
    }
}