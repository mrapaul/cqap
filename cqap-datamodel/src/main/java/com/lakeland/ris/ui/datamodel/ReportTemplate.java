package com.lakeland.ris.ui.datamodel;

import org.codehaus.jackson.annotate.*;
import org.jetbrains.annotations.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;


public class ReportTemplate
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

    public ReportTemplate()
    {
        // empty
    }

    @JsonCreator
    public ReportTemplate(@NotNull String id,
                          @NotNull String cPTCode,
                          @Nullable String lakelandDescription,
                          @Nullable String cPTDescription,
                          @Nullable String triggerPhrase,
                          @Nullable String template1,
                          @Nullable String template2,
                          @Nullable String template3,
                          @Nullable String imagingModality,
                          @Nullable String comments,
                          @Nullable String region,
                          @Nullable String modifiers,
                          @Nullable YesNo iVBased,
                          @Nullable String radiologistLocation,
                          @Nullable String cMORadiologistLocation,
                          @Nullable String subspecialtyPrimary,
                          @Nullable String subspecialtySecondary)
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

    @NotNull
    public String getId()
    {
        return id;
    }

    @NotNull
    public String getCPTCode()
    {
        return cPTCode;
    }

    @Nullable
    public String getLakelandDescription()
    {
        return lakelandDescription;
    }

    @Nullable
    public String getCPTDescription()
    {
        return cPTDescription;
    }

    @Nullable
    public String getTriggerPhrase()
    {
        return triggerPhrase;
    }

    @Nullable
    public String getTemplate1()
    {
        return template1;
    }

    @Nullable
    public String getTemplate2()
    {
        return template2;
    }

    @Nullable
    public String getTemplate3()
    {
        return template3;
    }

    @Nullable
    public String getImagingModality()
    {
        return imagingModality;
    }

    @Nullable
    public String getComments()
    {
        return comments;
    }

    @Nullable
    public String getRegion()
    {
        return region;
    }

    @Nullable
    public String getModifiers()
    {
        return modifiers;
    }

    @Nullable
    public YesNo getIVBased()
    {
        return iVBased;
    }

    @Nullable
    public String getRadiologistLocation()
    {
        return radiologistLocation;
    }

    @Nullable
    public String getCMORadiologistLocation()
    {
        return cMORadiologistLocation;
    }

    @Nullable
    public String getSubspecialtyPrimary()
    {
        return subspecialtyPrimary;
    }

    @Nullable
    public String getSubspecialtySecondary()
    {
        return subspecialtySecondary;
    }
    public void setId(@NotNull String id)
    {
        this.id = id;
    }

    public void setCPTCode(@NotNull String cPTCode)
    {
        this.cPTCode = cPTCode;
    }

    public void setLakelandDescription(@Nullable String lakelandDescription)
    {
        this.lakelandDescription = lakelandDescription;
    }

    public void setCPTDescription(@Nullable String cPTDescription)
    {
        this.cPTDescription = cPTDescription;
    }

    public void setTriggerPhrase(@Nullable String triggerPhrase)
    {
        this.triggerPhrase = triggerPhrase;
    }

    public void setTemplate1(@Nullable String template1)
    {
        this.template1 = template1;
    }

    public void setTemplate2(@Nullable String template2)
    {
        this.template2 = template2;
    }

    public void setTemplate3(@Nullable String template3)
    {
        this.template3 = template3;
    }

    public void setImagingModality(@Nullable String imagingModality)
    {
        this.imagingModality = imagingModality;
    }

    public void setComments(@Nullable String comments)
    {
        this.comments = comments;
    }

    public void setRegion(@Nullable String region)
    {
        this.region = region;
    }

    public void setModifiers(@Nullable String modifiers)
    {
        this.modifiers = modifiers;
    }

    public void setIVBased(@Nullable YesNo iVBased)
    {
        this.iVBased = iVBased;
    }

    public void setRadiologistLocation(@Nullable String radiologistLocation)
    {
        this.radiologistLocation = radiologistLocation;
    }

    public void setCMORadiologistLocation(@Nullable String cMORadiologistLocation)
    {
        this.cMORadiologistLocation = cMORadiologistLocation;
    }

    public void setSubspecialtyPrimary(@Nullable String subspecialtyPrimary)
    {
        this.subspecialtyPrimary = subspecialtyPrimary;
    }

    public void setSubspecialtySecondary(@Nullable String subspecialtySecondary)
    {
        this.subspecialtySecondary = subspecialtySecondary;
    }

    @NotNull
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

    @NotNull
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