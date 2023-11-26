package com.peirs.datamodel.dicom;

import com.peirs.datamodel.*;

import java.util.*;

public class DicomStudyQueryBuilder
{
    private Group theGroup;
    private Institution theInstitution;
    private String theInstitutionAlias;
    private String thePatientLastName;
    private String thePatientFirstName;
    private String thePatientID;
    private List<String> theModalities;
    private String theStudyDescription;
    private String theAccessionNumber;
    private String theStudyDate;
    private String theStudyBeginDate;
    private String theStudyEndDate;
    private String theIIR;
    private String theSiteTechnologist;
    private String theCPTCode;
    private String theStudyInstanceUID;

    public DicomStudyQueryBuilder()
    {
        theModalities = new ArrayList<>();
    }

    public DicomStudyQueryBuilder setGroup(Group aGroup)
    {
        theGroup = aGroup;
        return this;
    }

    public DicomStudyQueryBuilder setInstitution(Institution aInstitution)
    {
        theInstitution = aInstitution;
        return this;
    }

    public DicomStudyQueryBuilder setPatientLastName(String aPatientLastName)
    {
        thePatientLastName = aPatientLastName;
        return this;
    }

    public DicomStudyQueryBuilder setPatientFirstName(String aPatientFirstName)
    {
        thePatientFirstName = aPatientFirstName;
        return this;
    }

    public DicomStudyQueryBuilder setPatientID(String aPatientID)
    {
        thePatientID = aPatientID;
        return this;
    }

    public DicomStudyQueryBuilder setModalities(List<String> aModalities)
    {
        theModalities = aModalities;
        return this;
    }

    public DicomStudyQueryBuilder setStudyDescription(String aStudyDescription)
    {
        theStudyDescription = aStudyDescription;
        return this;
    }

    public DicomStudyQueryBuilder setAccessionNumber(String aAccessionNumber)
    {
        theAccessionNumber = aAccessionNumber;
        return this;
    }

    public DicomStudyQueryBuilder setStudyDate(String aStudyDate)
    {
        theStudyDate = aStudyDate;
        return this;
    }

    public DicomStudyQueryBuilder setIIR(String aIIR)
    {
        theIIR = aIIR;
        return this;
    }

    public DicomStudyQueryBuilder setSiteTechnologist(String aSiteTechnologist)
    {
        theSiteTechnologist = aSiteTechnologist;
        return this;
    }

    public DicomStudyQueryBuilder setInstitutionAlias(String aInstitutionAlias)
    {
        theInstitutionAlias = aInstitutionAlias;
        return this;
    }

    public DicomStudyQueryBuilder setCPTCode(String aCPTCode)
    {
        theCPTCode = aCPTCode;
        return this;
    }

    public DicomStudyQueryBuilder setStudyInstanceUID(String aStudyInstanceUID)
    {
        this.theStudyInstanceUID = aStudyInstanceUID;
        return this;
    }

    public void setStudyBeginDate(String aStudyBeginDate) {
        this.theStudyBeginDate = aStudyBeginDate;
    }

    public void setStudyEndDate(String aStudyEndDate) {
        this.theStudyEndDate = aStudyEndDate;
    }

    public DicomStudyQuery build()
    {
        return new DicomStudyQuery(theGroup,
                theInstitution,
                theInstitutionAlias,
                thePatientLastName,
                thePatientFirstName,
                thePatientID,
                theModalities,
                theStudyDescription,
                theAccessionNumber,
                theStudyDate,
                theStudyBeginDate,
                theStudyEndDate,
                theIIR,
                theSiteTechnologist,
                theCPTCode, theStudyInstanceUID);
    }
}