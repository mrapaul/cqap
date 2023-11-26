package com.peirs.datamodel.hl7;

import org.springframework.data.annotation.*;
import org.springframework.data.mongodb.core.mapping.*;

@Document(collection = "CPTCodes")
public class CPTCode
{
    @Id private String id;
    private String CPTCode;
    private String StudyDescription;
    private String CPTDescription;
    private String SubspecialtyPrimary;
    private String SubspecialtySecondary;
    private String SubspecialtyTertiary;
    private String ImagingModality;
    private String CMSRVU;

    public String getId()
    {
        return id;
    }

    public void setId(String aId)
    {
        id = aId;
    }

    public String getCPTCode()
    {
        return CPTCode;
    }

    public void setCPTCode(String aCPTCode)
    {
        CPTCode = aCPTCode;
    }

    public String getStudyDescription()
    {
        return StudyDescription;
    }

    public void setStudyDescription(String aStudyDescription)
    {
        StudyDescription = aStudyDescription;
    }

    public String getCPTDescription()
    {
        return CPTDescription;
    }

    public void setCPTDescription(String aCPTDescription)
    {
        CPTDescription = aCPTDescription;
    }

    public String getSubspecialtyPrimary()
    {
        return SubspecialtyPrimary;
    }

    public void setSubspecialtyPrimary(String aSubspecialtyPrimary)
    {
        SubspecialtyPrimary = aSubspecialtyPrimary;
    }

    public String getSubspecialtySecondary()
    {
        return SubspecialtySecondary;
    }

    public void setSubspecialtySecondary(String aSubspecialtySecondary)
    {
        SubspecialtySecondary = aSubspecialtySecondary;
    }

    public String getSubspecialtyTertiary()
    {
        return SubspecialtyTertiary;
    }

    public void setSubspecialtyTertiary(String aSubspecialtyTertiary)
    {
        SubspecialtyTertiary = aSubspecialtyTertiary;
    }

    public String getImagingModality()
    {
        return ImagingModality;
    }

    public void setImagingModality(String aImagingModality)
    {
        ImagingModality = aImagingModality;
    }

    public String getCMSRVU()
    {
        return CMSRVU;
    }

    public void setCMSRVU(String aCMSRVU)
    {
        CMSRVU = aCMSRVU;
    }
}
