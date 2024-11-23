package com.lakeland.ris.ui.datamodel;

import org.codehaus.jackson.annotate.*;

import java.util.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;


public class HL7MessageItem
{
    private String id;
    private Date received;
    private String institution;
    private String patientID;
    private String patientName;
    private String accessionNumber;
    private String modality;
    private String studyDescription;

    public HL7MessageItem()
    {
        // empty
    }

    @JsonCreator
    public HL7MessageItem(String id,
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


    public String getId()
    {
        return id;
    }


    public Date getReceived()
    {
        return received;
    }


    public String getInstitution()
    {
        return institution;
    }


    public String getPatientID()
    {
        return patientID;
    }


    public String getPatientName()
    {
        return patientName;
    }


    public String getAccessionNumber()
    {
        return accessionNumber;
    }


    public String getModality()
    {
        return modality;
    }


    public String getStudyDescription()
    {
        return studyDescription;
    }
    public void setId(String id)
    {
        this.id = id;
    }

    public void setReceived(Date received)
    {
        this.received = received;
    }

    public void setInstitution(String institution)
    {
        this.institution = institution;
    }

    public void setPatientID(String patientID)
    {
        this.patientID = patientID;
    }

    public void setPatientName(String patientName)
    {
        this.patientName = patientName;
    }

    public void setAccessionNumber(String accessionNumber)
    {
        this.accessionNumber = accessionNumber;
    }

    public void setModality(String modality)
    {
        this.modality = modality;
    }

    public void setStudyDescription(String studyDescription)
    {
        this.studyDescription = studyDescription;
    }


    public String toString()
    {
        return "HL7MessageItem(" +
            " id: " + getId() +
            " received: " + getReceived() +
            " institution: " + getInstitution() +
            " patientID: " + getPatientID() +
            " patientName: " + getPatientName() +
            " accessionNumber: " + getAccessionNumber() +
            " modality: " + getModality() +
            " studyDescription: " + getStudyDescription() + ")";
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

          final HL7MessageItem myObject = (HL7MessageItem) aObject;

          return Objects.equals(getId(), myObject.getId()) && 
                 Objects.equals(getReceived(), myObject.getReceived()) && 
                 Objects.equals(getInstitution(), myObject.getInstitution()) && 
                 Objects.equals(getPatientID(), myObject.getPatientID()) && 
                 Objects.equals(getPatientName(), myObject.getPatientName()) && 
                 Objects.equals(getAccessionNumber(), myObject.getAccessionNumber()) && 
                 Objects.equals(getModality(), myObject.getModality()) && 
                 Objects.equals(getStudyDescription(), myObject.getStudyDescription());
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(
                            getId(),
                            getReceived(),
                            getInstitution(),
                            getPatientID(),
                            getPatientName(),
                            getAccessionNumber(),
                            getModality(),
                            getStudyDescription());
    }


    public HL7MessageItemBuilder toBuilder()
    {
        return new HL7MessageItemBuilder(getId(),
                                         getReceived(),
                                         getInstitution(),
                                         getPatientID(),
                                         getPatientName(),
                                         getAccessionNumber(),
                                         getModality(),
                                         getStudyDescription());
    }
}