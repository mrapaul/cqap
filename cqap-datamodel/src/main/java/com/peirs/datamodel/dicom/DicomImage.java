package com.peirs.datamodel.dicom;

import org.springframework.data.annotation.*;
import org.springframework.data.mongodb.core.mapping.*;

import java.util.*;

@Document(collection = "DicomImages")
public class DicomImage
{
    @Id private String theId;
    private Date theImportedTime;
    private String theStudyId;
    private String theStudyInstanceUID;
    private String theStudyDate;
    private String thePatientName;
    private String thePatientID;
    private String thePatientBirthDate;
    private String thePatientSex;
    private String theAccessionNumber;
    private String theStudyDescription;
    private String theModality;
    private String theInstitutionName;
    private String theInstitutionalDepartmentName;
    private String theScheduledProcedureStepDescription;
    private String theOperatorName;
    private List<String> theInstitutions;
    private List<DicomTag> theTags;
    private String theSeriesInstanceUID;

    public DicomImage()
    {
        theImportedTime = new Date();
        theInstitutions = new ArrayList<>();
        theTags = new ArrayList<>();
    }

    public void addInstitution(String anInstitution)
    {
        theInstitutions.add(anInstitution);
    }

    public void addTag(DicomTag aTag)
    {
        theTags.add(aTag);
    }

    public Date getImportedTime()
    {
        return theImportedTime;
    }

    public void setImportedTime(Date aImportedTime)
    {
        theImportedTime = aImportedTime;
    }

    public String getStudyId()
    {
        return theStudyId;
    }

    public void setStudyId(String aStudyId)
    {
        theStudyId = aStudyId;
    }

    public String getStudyInstanceUID()
    {
        return theStudyInstanceUID;
    }

    public void setStudyInstanceUID(String aStudyInstanceUID)
    {
        theStudyInstanceUID = aStudyInstanceUID;
    }

    public String getStudyDate()
    {
        return theStudyDate;
    }

    public void setStudyDate(String aStudyDate)
    {
        theStudyDate = aStudyDate;
    }

    public String getPatientName()
    {
        return thePatientName;
    }

    public void setPatientName(String aPatientName)
    {
        thePatientName = aPatientName;
    }

    public String getPatientID()
    {
        return thePatientID;
    }

    public void setPatientID(String aPatientID)
    {
        thePatientID = aPatientID;
    }

    public String getAccessionNumber()
    {
        return theAccessionNumber;
    }

    public void setAccessionNumber(String aAccessionNumber)
    {
        theAccessionNumber = aAccessionNumber;
    }

    public String getStudyDescription()
    {
        return theStudyDescription;
    }

    public void setStudyDescription(String aStudyDescription)
    {
        theStudyDescription = aStudyDescription;
    }

    public String getModality()
    {
        return theModality;
    }

    public void setModality(String aModality)
    {
        theModality = aModality;
    }

    public void setInstitutionName(String aInstitutionName)
    {
        theInstitutionName = aInstitutionName;
    }

    public String getInstitutionName()
    {
        return theInstitutionName;
    }

    public String getInstitutionalDepartmentName()
    {
        return theInstitutionalDepartmentName;
    }

    public void setInstitutionalDepartmentName(String aInstitutionalDepartmentName)
    {
        theInstitutionalDepartmentName = aInstitutionalDepartmentName;
    }

    public String getScheduledProcedureStepDescription()
    {
        return theScheduledProcedureStepDescription;
    }

    public void setScheduledProcedureStepDescription(String aScheduledProcedureStepDescription)
    {
        theScheduledProcedureStepDescription = aScheduledProcedureStepDescription;
    }

    public void setPatientBirthDate(String aPatientBirthDate)
    {
        thePatientBirthDate = aPatientBirthDate;
    }

    public String getPatientBirthDate()
    {
        return thePatientBirthDate;
    }

    public String getPatientSex()
    {
        return thePatientSex;
    }

    public void setPatientSex(String aPatientSex)
    {
        thePatientSex = aPatientSex;
    }

    public String getOperatorName()
    {
        return theOperatorName;
    }

    public void setOperatorName(String aOperatorName)
    {
        theOperatorName = aOperatorName;
    }

    public List<DicomTag> getTags()
    {
        return theTags;
    }

    public void setTags(List<DicomTag> aTags)
    {
        theTags = aTags;
    }

    public List<String> getInstitutions()
    {
        return theInstitutions;
    }

    public void setInstitutions(List<String> aInstitutions)
    {
        theInstitutions = aInstitutions;
    }


    public void setSeriesInstanceUID(String aSeriesInstanceUID)
    {
        theSeriesInstanceUID = aSeriesInstanceUID;
    }

    public String getSeriesInstanceUID()
    {
        return theSeriesInstanceUID;
    }
}