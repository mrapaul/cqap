package com.lakeland.ris.ui.datamodel;

import org.codehaus.jackson.annotate.*;

import java.util.*;
import com.lakeland.ris.datamodel.*;


public class ReportTemplate
{
    private String id;
    private String cPTCode;
     private String lakelandDescription;
     private String cPTDescription;
     private String triggerPhrase;
     private String template1;
     private String template2;
     private String template3;
     private String imagingModality;
     private String comments;
     private String region;
     private String modifiers;
     private YesNo iVBased;
     private String radiologistLocation;
     private String cMORadiologistLocation;
     private String subspecialtyPrimary;
     private String subspecialtySecondary;

    public ReportTemplate()
    {
        // empty
    }

    @JsonCreator
    public ReportTemplate(String id,
                          String cPTCode,
                           String lakelandDescription,
                           String cPTDescription,
                           String triggerPhrase,
                           String template1,
                           String template2,
                           String template3,
                           String imagingModality,
                           String comments,
                           String region,
                           String modifiers,
                           YesNo iVBased,
                           String radiologistLocation,
                           String cMORadiologistLocation,
                           String subspecialtyPrimary,
                           String subspecialtySecondary)
    {
        super();

        this.id = id;
        this.cPTCode = cPTCode;
        this.lakelandDescription = lakelandDescription;
        this.cPTDescription = cPTDescription;
        this.triggerPhrase = triggerPhrase;
        this.template1 = template1;
        this.template2 = template2;
        this.template3 = template3;
        this.imagingModality = imagingModality;
        this.comments = comments;
        this.region = region;
        this.modifiers = modifiers;
        this.iVBased = iVBased;
        this.radiologistLocation = radiologistLocation;
        this.cMORadiologistLocation = cMORadiologistLocation;
        this.subspecialtyPrimary = subspecialtyPrimary;
        this.subspecialtySecondary = subspecialtySecondary;
    }


    public String getId()
    {
        return id;
    }


    public String getCPTCode()
    {
        return cPTCode;
    }

    
    public String getLakelandDescription()
    {
        return lakelandDescription;
    }

    
    public String getCPTDescription()
    {
        return cPTDescription;
    }

    
    public String getTriggerPhrase()
    {
        return triggerPhrase;
    }

    
    public String getTemplate1()
    {
        return template1;
    }

    
    public String getTemplate2()
    {
        return template2;
    }

    
    public String getTemplate3()
    {
        return template3;
    }

    
    public String getImagingModality()
    {
        return imagingModality;
    }

    
    public String getComments()
    {
        return comments;
    }

    
    public String getRegion()
    {
        return region;
    }

    
    public String getModifiers()
    {
        return modifiers;
    }

    
    public YesNo getIVBased()
    {
        return iVBased;
    }

    
    public String getRadiologistLocation()
    {
        return radiologistLocation;
    }

    
    public String getCMORadiologistLocation()
    {
        return cMORadiologistLocation;
    }

    
    public String getSubspecialtyPrimary()
    {
        return subspecialtyPrimary;
    }

    
    public String getSubspecialtySecondary()
    {
        return subspecialtySecondary;
    }
    public void setId(String id)
    {
        this.id = id;
    }

    public void setCPTCode(String cPTCode)
    {
        this.cPTCode = cPTCode;
    }

    public void setLakelandDescription( String lakelandDescription)
    {
        this.lakelandDescription = lakelandDescription;
    }

    public void setCPTDescription( String cPTDescription)
    {
        this.cPTDescription = cPTDescription;
    }

    public void setTriggerPhrase( String triggerPhrase)
    {
        this.triggerPhrase = triggerPhrase;
    }

    public void setTemplate1( String template1)
    {
        this.template1 = template1;
    }

    public void setTemplate2( String template2)
    {
        this.template2 = template2;
    }

    public void setTemplate3( String template3)
    {
        this.template3 = template3;
    }

    public void setImagingModality( String imagingModality)
    {
        this.imagingModality = imagingModality;
    }

    public void setComments( String comments)
    {
        this.comments = comments;
    }

    public void setRegion( String region)
    {
        this.region = region;
    }

    public void setModifiers( String modifiers)
    {
        this.modifiers = modifiers;
    }

    public void setIVBased( YesNo iVBased)
    {
        this.iVBased = iVBased;
    }

    public void setRadiologistLocation( String radiologistLocation)
    {
        this.radiologistLocation = radiologistLocation;
    }

    public void setCMORadiologistLocation( String cMORadiologistLocation)
    {
        this.cMORadiologistLocation = cMORadiologistLocation;
    }

    public void setSubspecialtyPrimary( String subspecialtyPrimary)
    {
        this.subspecialtyPrimary = subspecialtyPrimary;
    }

    public void setSubspecialtySecondary( String subspecialtySecondary)
    {
        this.subspecialtySecondary = subspecialtySecondary;
    }


    public String toString()
    {
        return "ReportTemplate(" +
            " id: " + getId() +
            " cPTCode: " + getCPTCode() +
            " lakelandDescription: " + getLakelandDescription() +
            " cPTDescription: " + getCPTDescription() +
            " triggerPhrase: " + getTriggerPhrase() +
            " template1: " + getTemplate1() +
            " template2: " + getTemplate2() +
            " template3: " + getTemplate3() +
            " imagingModality: " + getImagingModality() +
            " comments: " + getComments() +
            " region: " + getRegion() +
            " modifiers: " + getModifiers() +
            " iVBased: " + getIVBased() +
            " radiologistLocation: " + getRadiologistLocation() +
            " cMORadiologistLocation: " + getCMORadiologistLocation() +
            " subspecialtyPrimary: " + getSubspecialtyPrimary() +
            " subspecialtySecondary: " + getSubspecialtySecondary() + ")";
    }


    public ReportTemplateBuilder toBuilder()
    {
        return new ReportTemplateBuilder(getId(),
                                         getCPTCode()).setLakelandDescription(getLakelandDescription())
                                                       .setCPTDescription(getCPTDescription())
                                                       .setTriggerPhrase(getTriggerPhrase())
                                                       .setTemplate1(getTemplate1())
                                                       .setTemplate2(getTemplate2())
                                                       .setTemplate3(getTemplate3())
                                                       .setImagingModality(getImagingModality())
                                                       .setComments(getComments())
                                                       .setRegion(getRegion())
                                                       .setModifiers(getModifiers())
                                                       .setIVBased(getIVBased())
                                                       .setRadiologistLocation(getRadiologistLocation())
                                                       .setCMORadiologistLocation(getCMORadiologistLocation())
                                                       .setSubspecialtyPrimary(getSubspecialtyPrimary())
                                                       .setSubspecialtySecondary(getSubspecialtySecondary());
    }
}