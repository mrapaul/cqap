package com.lakeland.ris.ui.datamodel;


import java.util.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;


public class HL7MessageItemBuilder
{
    private String id;
    private Date received;
    private String institution;
    private String patientID;
    private String patientName;
    private String accessionNumber;
    private String modality;
    private String studyDescription;

    public HL7MessageItemBuilder(String id,
                                 Date received,
                                 String institution,
                                 String patientID,
                                 String patientName,
                                 String accessionNumber,
                                 String modality,
                                 String studyDescription)
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


    
    public HL7MessageItemBuilder setId(String id)
    {
        this.id = id;

        return self();
    }

    
    public HL7MessageItemBuilder setReceived(Date received)
    {
        this.received = received;

        return self();
    }

    
    public HL7MessageItemBuilder setInstitution(String institution)
    {
        this.institution = institution;

        return self();
    }

    
    public HL7MessageItemBuilder setPatientID(String patientID)
    {
        this.patientID = patientID;

        return self();
    }

    
    public HL7MessageItemBuilder setPatientName(String patientName)
    {
        this.patientName = patientName;

        return self();
    }

    
    public HL7MessageItemBuilder setAccessionNumber(String accessionNumber)
    {
        this.accessionNumber = accessionNumber;

        return self();
    }

    
    public HL7MessageItemBuilder setModality(String modality)
    {
        this.modality = modality;

        return self();
    }

    
    public HL7MessageItemBuilder setStudyDescription(String studyDescription)
    {
        this.studyDescription = studyDescription;

        return self();
    }

    
    protected String getId()
    {
        return id;
    }

    
    protected Date getReceived()
    {
        return received;
    }

    
    protected String getInstitution()
    {
        return institution;
    }

    
    protected String getPatientID()
    {
        return patientID;
    }

    
    protected String getPatientName()
    {
        return patientName;
    }

    
    protected String getAccessionNumber()
    {
        return accessionNumber;
    }

    
    protected String getModality()
    {
        return modality;
    }

    
    protected String getStudyDescription()
    {
        return studyDescription;
    }

    
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


    
    protected HL7MessageItemBuilder self()
    {
        return this;
    }
}