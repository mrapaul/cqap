package com.lakeland.ris.ui.datamodel;


import java.util.*;
import com.lakeland.ris.datamodel.*;


public class ReportTemplateBuilder
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

    public ReportTemplateBuilder(String id,
                                 String cPTCode)
    {
        super();

        this.id = id;
        this.cPTCode = cPTCode;
    }


    
    public ReportTemplateBuilder setId(String id)
    {
        this.id = id;

        return self();
    }

    
    public ReportTemplateBuilder setCPTCode(String cPTCode)
    {
        this.cPTCode = cPTCode;

        return self();
    }

    
    public ReportTemplateBuilder setLakelandDescription( String lakelandDescription)
    {
        this.lakelandDescription = lakelandDescription;

        return self();
    }

    
    public ReportTemplateBuilder setCPTDescription( String cPTDescription)
    {
        this.cPTDescription = cPTDescription;

        return self();
    }

    
    public ReportTemplateBuilder setTriggerPhrase( String triggerPhrase)
    {
        this.triggerPhrase = triggerPhrase;

        return self();
    }

    
    public ReportTemplateBuilder setTemplate1( String template1)
    {
        this.template1 = template1;

        return self();
    }

    
    public ReportTemplateBuilder setTemplate2( String template2)
    {
        this.template2 = template2;

        return self();
    }

    
    public ReportTemplateBuilder setTemplate3( String template3)
    {
        this.template3 = template3;

        return self();
    }

    
    public ReportTemplateBuilder setImagingModality( String imagingModality)
    {
        this.imagingModality = imagingModality;

        return self();
    }

    
    public ReportTemplateBuilder setComments( String comments)
    {
        this.comments = comments;

        return self();
    }

    
    public ReportTemplateBuilder setRegion( String region)
    {
        this.region = region;

        return self();
    }

    
    public ReportTemplateBuilder setModifiers( String modifiers)
    {
        this.modifiers = modifiers;

        return self();
    }

    
    public ReportTemplateBuilder setIVBased( YesNo iVBased)
    {
        this.iVBased = iVBased;

        return self();
    }

    
    public ReportTemplateBuilder setRadiologistLocation( String radiologistLocation)
    {
        this.radiologistLocation = radiologistLocation;

        return self();
    }

    
    public ReportTemplateBuilder setCMORadiologistLocation( String cMORadiologistLocation)
    {
        this.cMORadiologistLocation = cMORadiologistLocation;

        return self();
    }

    
    public ReportTemplateBuilder setSubspecialtyPrimary( String subspecialtyPrimary)
    {
        this.subspecialtyPrimary = subspecialtyPrimary;

        return self();
    }

    
    public ReportTemplateBuilder setSubspecialtySecondary( String subspecialtySecondary)
    {
        this.subspecialtySecondary = subspecialtySecondary;

        return self();
    }

    
    protected String getId()
    {
        return id;
    }

    
    protected String getCPTCode()
    {
        return cPTCode;
    }

    
    protected String getLakelandDescription()
    {
        return lakelandDescription;
    }

    
    protected String getCPTDescription()
    {
        return cPTDescription;
    }

    
    protected String getTriggerPhrase()
    {
        return triggerPhrase;
    }

    
    protected String getTemplate1()
    {
        return template1;
    }

    
    protected String getTemplate2()
    {
        return template2;
    }

    
    protected String getTemplate3()
    {
        return template3;
    }

    
    protected String getImagingModality()
    {
        return imagingModality;
    }

    
    protected String getComments()
    {
        return comments;
    }

    
    protected String getRegion()
    {
        return region;
    }

    
    protected String getModifiers()
    {
        return modifiers;
    }

    
    protected YesNo getIVBased()
    {
        return iVBased;
    }

    
    protected String getRadiologistLocation()
    {
        return radiologistLocation;
    }

    
    protected String getCMORadiologistLocation()
    {
        return cMORadiologistLocation;
    }

    
    protected String getSubspecialtyPrimary()
    {
        return subspecialtyPrimary;
    }

    
    protected String getSubspecialtySecondary()
    {
        return subspecialtySecondary;
    }

    
    public ReportTemplate build()
    {
        return new ReportTemplate(getId(),
                                  getCPTCode(),
                                  getLakelandDescription(),
                                  getCPTDescription(),
                                  getTriggerPhrase(),
                                  getTemplate1(),
                                  getTemplate2(),
                                  getTemplate3(),
                                  getImagingModality(),
                                  getComments(),
                                  getRegion(),
                                  getModifiers(),
                                  getIVBased(),
                                  getRadiologistLocation(),
                                  getCMORadiologistLocation(),
                                  getSubspecialtyPrimary(),
                                  getSubspecialtySecondary());
    }


    
    protected ReportTemplateBuilder self()
    {
        return this;
    }
}