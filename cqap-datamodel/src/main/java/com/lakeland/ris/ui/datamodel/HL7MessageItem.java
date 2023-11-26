package com.lakeland.ris.ui.datamodel;

import org.codehaus.jackson.annotate.*;
import org.jetbrains.annotations.*;
import java.util.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;


public class HL7MessageItem
{
    @NotNull private String id;
    @NotNull private Date received;
    @NotNull private String institution;
    @NotNull private String patientID;
    @NotNull private String patientName;
    @NotNull private String accessionNumber;
    @NotNull private String modality;
    @NotNull private String studyDescription;

    public HL7MessageItem()
    {
        // empty
    }

    @JsonCreator
    public HL7MessageItem(@NotNull String id,
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
    public String getId()
    {
        return id;
    }

    @NotNull
    public Date getReceived()
    {
        return received;
    }

    @NotNull
    public String getInstitution()
    {
        return institution;
    }

    @NotNull
    public String getPatientID()
    {
        return patientID;
    }

    @NotNull
    public String getPatientName()
    {
        return patientName;
    }

    @NotNull
    public String getAccessionNumber()
    {
        return accessionNumber;
    }

    @NotNull
    public String getModality()
    {
        return modality;
    }

    @NotNull
    public String getStudyDescription()
    {
        return studyDescription;
    }
    public void setId(@NotNull String id)
    {
        this.id = id;
    }

    public void setReceived(@NotNull Date received)
    {
        this.received = received;
    }

    public void setInstitution(@NotNull String institution)
    {
        this.institution = institution;
    }

    public void setPatientID(@NotNull String patientID)
    {
        this.patientID = patientID;
    }

    public void setPatientName(@NotNull String patientName)
    {
        this.patientName = patientName;
    }

    public void setAccessionNumber(@NotNull String accessionNumber)
    {
        this.accessionNumber = accessionNumber;
    }

    public void setModality(@NotNull String modality)
    {
        this.modality = modality;
    }

    public void setStudyDescription(@NotNull String studyDescription)
    {
        this.studyDescription = studyDescription;
    }

    @NotNull
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

    @NotNull
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