package com.peirs.datamodel.dicom;

import com.peirs.datamodel.*;

import java.util.*;

public final class DicomStudyQuery
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
    private String theIIR;
    private String theSiteTechnologist;
    private String theCPTCode;

    public DicomStudyQuery()
    {
        theModalities = new ArrayList<>();
    }

    public DicomStudyQuery(Group aGroup,
                           Institution aInstitution,
                           String aInstitutionAlias,
                           String aPatientLastName,
                           String aPatientFirstName,
                           String aPatientID,
                           List<String> aModalities,
                           String aStudyDescription,
                           String aAccessionNumber,
                           String aStudyDate,
                           String aIIR,
                           String aSiteTechnologist,
                           String aCPTCode)
    {
        theGroup = aGroup;
        theInstitution = aInstitution;
        theInstitutionAlias = aInstitutionAlias;
        thePatientLastName = aPatientLastName;
        thePatientFirstName = aPatientFirstName;
        thePatientID = aPatientID;
        theModalities = aModalities;
        theStudyDescription = aStudyDescription;
        theAccessionNumber = aAccessionNumber;
        theStudyDate = aStudyDate;
        theIIR = aIIR;
        theSiteTechnologist = aSiteTechnologist;
        theCPTCode = aCPTCode;
    }

    public Group getGroup()
    {
        return theGroup;
    }

    public void setGroup(Group aGroup)
    {
        theGroup = aGroup;
    }

    public Institution getInstitution()
    {
        return theInstitution;
    }

    public void setInstitution(Institution aInstitution)
    {
        theInstitution = aInstitution;
    }

    public String getInstitutionAlias()
    {
        return theInstitutionAlias;
    }

    public void setInstitutionAlias(String aInstitutionAlias)
    {
        theInstitutionAlias = aInstitutionAlias;
    }

    public String getPatientLastName()
    {
        return thePatientLastName;
    }

    public void setPatientLastName(String aPatientLastName)
    {
        thePatientLastName = aPatientLastName;
    }

    public String getPatientFirstName()
    {
        return thePatientFirstName;
    }

    public void setPatientFirstName(String aPatientFirstName)
    {
        thePatientFirstName = aPatientFirstName;
    }

    public String getPatientID()
    {
        return thePatientID;
    }

    public void setPatientID(String aPatientID)
    {
        thePatientID = aPatientID;
    }

    public List<String> getModalities()
    {
        return theModalities;
    }

    public void setModalities(List<String> aModalities)
    {
        theModalities = aModalities;
    }

    public String getStudyDescription()
    {
        return theStudyDescription;
    }

    public void setStudyDescription(String aStudyDescription)
    {
        theStudyDescription = aStudyDescription;
    }

    public String getAccessionNumber()
    {
        return theAccessionNumber;
    }

    public void setAccessionNumber(String aAccessionNumber)
    {
        theAccessionNumber = aAccessionNumber;
    }

    public String getStudyDate()
    {
        return theStudyDate;
    }

    public void setStudyDate(String aStudyDate)
    {
        theStudyDate = aStudyDate;
    }

    public String getIIR()
    {
        return theIIR;
    }

    public void setIIR(String aIIR)
    {
        theIIR = aIIR;
    }

    public String getSiteTechnologist()
    {
        return theSiteTechnologist;
    }

    public void setSiteTechnologist(String aSiteTechnologist)
    {
        theSiteTechnologist = aSiteTechnologist;
    }

    public String getCPTCode()
    {
        return theCPTCode;
    }

    public void setCPTCode(String aCPTCode)
    {
        theCPTCode = aCPTCode;
    }
}
