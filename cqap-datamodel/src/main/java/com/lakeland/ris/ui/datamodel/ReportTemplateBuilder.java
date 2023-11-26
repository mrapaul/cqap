package com.lakeland.ris.ui.datamodel;

import org.jetbrains.annotations.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;


public class ReportTemplateBuilder
{
    @NotNull private String id;
    @NotNull private String cPTCode;
    @Nullable private String lakelandDescription;
    @Nullable private String cPTDescription;
    @Nullable private String triggerPhrase;
    @Nullable private String template1;
    @Nullable private String template2;
    @Nullable private String template3;
    @Nullable private String imagingModality;
    @Nullable private String comments;
    @Nullable private String region;
    @Nullable private String modifiers;
    @Nullable private YesNo iVBased;
    @Nullable private String radiologistLocation;
    @Nullable private String cMORadiologistLocation;
    @Nullable private String subspecialtyPrimary;
    @Nullable private String subspecialtySecondary;

    public ReportTemplateBuilder(@NotNull String id,
                                 @NotNull String cPTCode)
    {
        super();

        this.id = id;
        this.cPTCode = cPTCode;
    }


    @NotNull
    public ReportTemplateBuilder setId(@NotNull String id)
    {
        this.id = id;

        return self();
    }

    @NotNull
    public ReportTemplateBuilder setCPTCode(@NotNull String cPTCode)
    {
        this.cPTCode = cPTCode;

        return self();
    }

    @NotNull
    public ReportTemplateBuilder setLakelandDescription(@Nullable String lakelandDescription)
    {
        this.lakelandDescription = lakelandDescription;

        return self();
    }

    @NotNull
    public ReportTemplateBuilder setCPTDescription(@Nullable String cPTDescription)
    {
        this.cPTDescription = cPTDescription;

        return self();
    }

    @NotNull
    public ReportTemplateBuilder setTriggerPhrase(@Nullable String triggerPhrase)
    {
        this.triggerPhrase = triggerPhrase;

        return self();
    }

    @NotNull
    public ReportTemplateBuilder setTemplate1(@Nullable String template1)
    {
        this.template1 = template1;

        return self();
    }

    @NotNull
    public ReportTemplateBuilder setTemplate2(@Nullable String template2)
    {
        this.template2 = template2;

        return self();
    }

    @NotNull
    public ReportTemplateBuilder setTemplate3(@Nullable String template3)
    {
        this.template3 = template3;

        return self();
    }

    @NotNull
    public ReportTemplateBuilder setImagingModality(@Nullable String imagingModality)
    {
        this.imagingModality = imagingModality;

        return self();
    }

    @NotNull
    public ReportTemplateBuilder setComments(@Nullable String comments)
    {
        this.comments = comments;

        return self();
    }

    @NotNull
    public ReportTemplateBuilder setRegion(@Nullable String region)
    {
        this.region = region;

        return self();
    }

    @NotNull
    public ReportTemplateBuilder setModifiers(@Nullable String modifiers)
    {
        this.modifiers = modifiers;

        return self();
    }

    @NotNull
    public ReportTemplateBuilder setIVBased(@Nullable YesNo iVBased)
    {
        this.iVBased = iVBased;

        return self();
    }

    @NotNull
    public ReportTemplateBuilder setRadiologistLocation(@Nullable String radiologistLocation)
    {
        this.radiologistLocation = radiologistLocation;

        return self();
    }

    @NotNull
    public ReportTemplateBuilder setCMORadiologistLocation(@Nullable String cMORadiologistLocation)
    {
        this.cMORadiologistLocation = cMORadiologistLocation;

        return self();
    }

    @NotNull
    public ReportTemplateBuilder setSubspecialtyPrimary(@Nullable String subspecialtyPrimary)
    {
        this.subspecialtyPrimary = subspecialtyPrimary;

        return self();
    }

    @NotNull
    public ReportTemplateBuilder setSubspecialtySecondary(@Nullable String subspecialtySecondary)
    {
        this.subspecialtySecondary = subspecialtySecondary;

        return self();
    }

    @NotNull
    protected String getId()
    {
        return id;
    }

    @NotNull
    protected String getCPTCode()
    {
        return cPTCode;
    }

    @Nullable
    protected String getLakelandDescription()
    {
        return lakelandDescription;
    }

    @Nullable
    protected String getCPTDescription()
    {
        return cPTDescription;
    }

    @Nullable
    protected String getTriggerPhrase()
    {
        return triggerPhrase;
    }

    @Nullable
    protected String getTemplate1()
    {
        return template1;
    }

    @Nullable
    protected String getTemplate2()
    {
        return template2;
    }

    @Nullable
    protected String getTemplate3()
    {
        return template3;
    }

    @Nullable
    protected String getImagingModality()
    {
        return imagingModality;
    }

    @Nullable
    protected String getComments()
    {
        return comments;
    }

    @Nullable
    protected String getRegion()
    {
        return region;
    }

    @Nullable
    protected String getModifiers()
    {
        return modifiers;
    }

    @Nullable
    protected YesNo getIVBased()
    {
        return iVBased;
    }

    @Nullable
    protected String getRadiologistLocation()
    {
        return radiologistLocation;
    }

    @Nullable
    protected String getCMORadiologistLocation()
    {
        return cMORadiologistLocation;
    }

    @Nullable
    protected String getSubspecialtyPrimary()
    {
        return subspecialtyPrimary;
    }

    @Nullable
    protected String getSubspecialtySecondary()
    {
        return subspecialtySecondary;
    }

    @NotNull
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


    @NotNull
    protected ReportTemplateBuilder self()
    {
        return this;
    }
}