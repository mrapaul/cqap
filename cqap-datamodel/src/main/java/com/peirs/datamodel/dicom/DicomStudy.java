package com.peirs.datamodel.dicom;

import com.peirs.datamodel.*;
import org.springframework.data.annotation.*;
import org.springframework.data.mongodb.core.index.*;
import org.springframework.data.mongodb.core.mapping.*;

import java.util.*;

@Document(collection = "DicomStudy")
public class DicomStudy
{
    public transient boolean theImport;
    @Id private String theId;
    private String theStudyId;
    @Indexed private String theStudyInstanceUID;
    private String theStudyDate;
    @Indexed private String thePatientName;
    @Indexed private String thePatientID;
    private String thePatientBirthDate;
    private String thePatientSex;
    @Indexed private String theAccessionNumber;
    @Indexed private String theStudyDescription;
    @Indexed private String theModality;
    @Deprecated @Indexed private String theInstitutionName;
    private String theInstitutionalDepartmentName;
    private String theScheduledProcedureStepDescription;
    @Indexed private String theOperatorName;
    @Indexed private Collection<String> theInstitutions;
    @Indexed private Collection<DicomTag> theTags;
    private int theImageCount;
    private Set<String> theSeriesInstanceUIDs;
    private String thePatientReport;
    private Institution theInstitution;

    public DicomStudy()
    {
        theInstitutions = new HashSet<>();
        theTags = new HashSet<>();
        theSeriesInstanceUIDs = new HashSet<>();
    }

    private static DicomImage selectImage(Collection<DicomImage> aImages)
    {
        for (DicomImage myImage : aImages)
        {
            if (imageContainsData(myImage))
            {
                return myImage;
            }
        }

        return null;
    }

    private static boolean imageContainsData(DicomImage myImage)
    {
        return myImage.getPatientName() != null &&
                myImage.getModality() != null &&
                myImage.getStudyInstanceUID() != null;
    }

    public void setImages(Collection<DicomImage> aImages)
    {
        theImageCount = aImages.size();
        DicomImage mySelectedImage = selectImage(aImages);

        if (mySelectedImage != null)
        {
            theStudyId = mySelectedImage.getStudyId();
            theStudyInstanceUID = mySelectedImage.getStudyInstanceUID();
            theStudyDate = mySelectedImage.getStudyDate();
            thePatientName = mySelectedImage.getPatientName();
            thePatientID = mySelectedImage.getPatientID();
            thePatientBirthDate = mySelectedImage.getPatientBirthDate();
            thePatientSex = mySelectedImage.getPatientSex();
            theAccessionNumber = mySelectedImage.getAccessionNumber();
            theStudyDescription = mySelectedImage.getStudyDescription();
            theModality = mySelectedImage.getModality();
            theInstitutionName = mySelectedImage.getInstitutionName();
            theInstitutionalDepartmentName = mySelectedImage.getInstitutionalDepartmentName();
            theScheduledProcedureStepDescription = mySelectedImage.getScheduledProcedureStepDescription();
            theOperatorName = mySelectedImage.getOperatorName();
            theInstitutions = mySelectedImage.getInstitutions();
            theTags = new ArrayList<>();
            theTags.addAll(mySelectedImage.getTags());
            theSeriesInstanceUIDs.add(mySelectedImage.getSeriesInstanceUID());

            if (theStudyDescription == null && theScheduledProcedureStepDescription != null)
            {
                theStudyDescription = theScheduledProcedureStepDescription;
            }
        }
    }

    public String getId()
    {
        return theId;
    }

    public void setId(String aId)
    {
        theId = aId;
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

    public String getPatientBirthDate()
    {
        return thePatientBirthDate;
    }

    public void setPatientBirthDate(String aPatientBirthDate)
    {
        thePatientBirthDate = aPatientBirthDate;
    }

    public String getPatientSex()
    {
        return thePatientSex;
    }

    public void setPatientSex(String aPatientSex)
    {
        thePatientSex = aPatientSex;
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

    @Deprecated
    public String getInstitutionName()
    {
        return theInstitutionName;
    }

    @Deprecated
    public void setInstitutionName(String aInstitutionName)
    {
        theInstitutionName = aInstitutionName;
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

    public String getOperatorName()
    {
        return theOperatorName;
    }

    public void setOperatorName(String aOperatorName)
    {
        theOperatorName = aOperatorName;
    }

    public Collection<String> getInstitutions()
    {
        return theInstitutions;
    }

    public void setInstitutions(Collection<String> aInstitutions)
    {
        theInstitutions = aInstitutions;
    }

    public Collection<DicomTag> getTags()
    {
        return theTags;
    }

    public void setTags(Collection<DicomTag> aTags)
    {
        theTags = aTags;
    }

    @Override
    public String toString()
    {
        return theStudyId;
    }

    public boolean getImport()
    {
        return theImport;
    }

    public void setImport(boolean aImport)
    {
        theImport = aImport;
    }

    public int getImageCount()
    {
        return theImageCount;
    }

    public void setImageCount(int aImageCount)
    {
        theImageCount = aImageCount;
    }

    public Set<String> getSeriesInstanceUIDs()
    {
        return theSeriesInstanceUIDs;
    }

    public void setSeriesInstanceUIDs(Set<String> aSeriesInstanceUIDs)
    {
        theSeriesInstanceUIDs = aSeriesInstanceUIDs;
    }

    public String getPatientReport()
    {
        return thePatientReport;
    }

    public void setPatientReport(String aPatientReport)
    {
        thePatientReport = aPatientReport;
    }

    public Institution getInstitution()
    {
        return theInstitution;
    }

    public void setInstitution(Institution aInstitution)
    {
        theInstitution = aInstitution;
    }
}
