package com.lakeland.ris.ui.datamodel;

import org.codehaus.jackson.annotate.*;
import org.jetbrains.annotations.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;


public class OrderReportData
{
    private int id;
    @NotNull private String patientName;
    @Nullable private String patientId;
    @Nullable private String accession;
    @Nullable private String modality;
    @Nullable private String bodyPart;
    private int imageCount;
    @Nullable private String priority;
    @Nullable private Date studyTime;
    @Nullable private Date arrivalTime;
    @Nullable private Date readyTime;
    @Nullable private Date assignedTime;
    @Nullable private Date readTime;
    @Nullable private Date finalTime;
    @Nullable private String radiologist;
    @Nullable private String description;
    @Nullable private String status;
    @Nullable private String site;
    @Nullable private String cPTCode;
    @Nullable private String cMSRVU;
    private boolean critical;
    private boolean addendum;

    public OrderReportData()
    {
        // empty
    }

    @JsonCreator
    public OrderReportData(int id,
                           @NotNull String patientName,
                           @Nullable String patientId,
                           @Nullable String accession,
                           @Nullable String modality,
                           @Nullable String bodyPart,
                           int imageCount,
                           @Nullable String priority,
                           @Nullable Date studyTime,
                           @Nullable Date arrivalTime,
                           @Nullable Date readyTime,
                           @Nullable Date assignedTime,
                           @Nullable Date readTime,
                           @Nullable Date finalTime,
                           @Nullable String radiologist,
                           @Nullable String description,
                           @Nullable String status,
                           @Nullable String site,
                           @Nullable String cPTCode,
                           @Nullable String cMSRVU,
                           boolean critical,
                           boolean addendum)
    {
        super();

        this.id = id;
        this.patientName = patientName;
        this.patientId = patientId;
        this.accession = accession;
        this.modality = modality;
        this.bodyPart = bodyPart;
        this.imageCount = imageCount;
        this.priority = priority;
        this.studyTime = studyTime;
        this.arrivalTime = arrivalTime;
        this.readyTime = readyTime;
        this.assignedTime = assignedTime;
        this.readTime = readTime;
        this.finalTime = finalTime;
        this.radiologist = radiologist;
        this.description = description;
        this.status = status;
        this.site = site;
        this.cPTCode = cPTCode;
        this.cMSRVU = cMSRVU;
        this.critical = critical;
        this.addendum = addendum;
    }

    public int getId()
    {
        return id;
    }

    @NotNull
    public String getPatientName()
    {
        return patientName;
    }

    @Nullable
    public String getPatientId()
    {
        return patientId;
    }

    @Nullable
    public String getAccession()
    {
        return accession;
    }

    @Nullable
    public String getModality()
    {
        return modality;
    }

    @Nullable
    public String getBodyPart()
    {
        return bodyPart;
    }

    public int getImageCount()
    {
        return imageCount;
    }

    @Nullable
    public String getPriority()
    {
        return priority;
    }

    @Nullable
    public Date getStudyTime()
    {
        return studyTime;
    }

    @Nullable
    public Date getArrivalTime()
    {
        return arrivalTime;
    }

    @Nullable
    public Date getReadyTime()
    {
        return readyTime;
    }

    @Nullable
    public Date getAssignedTime()
    {
        return assignedTime;
    }

    @Nullable
    public Date getReadTime()
    {
        return readTime;
    }

    @Nullable
    public Date getFinalTime()
    {
        return finalTime;
    }

    @Nullable
    public String getRadiologist()
    {
        return radiologist;
    }

    @Nullable
    public String getDescription()
    {
        return description;
    }

    @Nullable
    public String getStatus()
    {
        return status;
    }

    @Nullable
    public String getSite()
    {
        return site;
    }

    @Nullable
    public String getCPTCode()
    {
        return cPTCode;
    }

    @Nullable
    public String getCMSRVU()
    {
        return cMSRVU;
    }

    public boolean isCritical()
    {
        return critical;
    }

    public boolean isAddendum()
    {
        return addendum;
    }
    public void setId(int id)
    {
        this.id = id;
    }

    public void setPatientName(@NotNull String patientName)
    {
        this.patientName = patientName;
    }

    public void setPatientId(@Nullable String patientId)
    {
        this.patientId = patientId;
    }

    public void setAccession(@Nullable String accession)
    {
        this.accession = accession;
    }

    public void setModality(@Nullable String modality)
    {
        this.modality = modality;
    }

    public void setBodyPart(@Nullable String bodyPart)
    {
        this.bodyPart = bodyPart;
    }

    public void setImageCount(int imageCount)
    {
        this.imageCount = imageCount;
    }

    public void setPriority(@Nullable String priority)
    {
        this.priority = priority;
    }

    public void setStudyTime(@Nullable Date studyTime)
    {
        this.studyTime = studyTime;
    }

    public void setArrivalTime(@Nullable Date arrivalTime)
    {
        this.arrivalTime = arrivalTime;
    }

    public void setReadyTime(@Nullable Date readyTime)
    {
        this.readyTime = readyTime;
    }

    public void setAssignedTime(@Nullable Date assignedTime)
    {
        this.assignedTime = assignedTime;
    }

    public void setReadTime(@Nullable Date readTime)
    {
        this.readTime = readTime;
    }

    public void setFinalTime(@Nullable Date finalTime)
    {
        this.finalTime = finalTime;
    }

    public void setRadiologist(@Nullable String radiologist)
    {
        this.radiologist = radiologist;
    }

    public void setDescription(@Nullable String description)
    {
        this.description = description;
    }

    public void setStatus(@Nullable String status)
    {
        this.status = status;
    }

    public void setSite(@Nullable String site)
    {
        this.site = site;
    }

    public void setCPTCode(@Nullable String cPTCode)
    {
        this.cPTCode = cPTCode;
    }

    public void setCMSRVU(@Nullable String cMSRVU)
    {
        this.cMSRVU = cMSRVU;
    }

    public void setCritical(boolean critical)
    {
        this.critical = critical;
    }

    public void setAddendum(boolean addendum)
    {
        this.addendum = addendum;
    }

    @NotNull
    public String toString()
    {
        return "OrderReportData(" +
            " id: " + getId() +
            " patientName: " + getPatientName() +
            " patientId: " + getPatientId() +
            " accession: " + getAccession() +
            " modality: " + getModality() +
            " bodyPart: " + getBodyPart() +
            " imageCount: " + getImageCount() +
            " priority: " + getPriority() +
            " studyTime: " + getStudyTime() +
            " arrivalTime: " + getArrivalTime() +
            " readyTime: " + getReadyTime() +
            " assignedTime: " + getAssignedTime() +
            " readTime: " + getReadTime() +
            " finalTime: " + getFinalTime() +
            " radiologist: " + getRadiologist() +
            " description: " + getDescription() +
            " status: " + getStatus() +
            " site: " + getSite() +
            " cPTCode: " + getCPTCode() +
            " cMSRVU: " + getCMSRVU() +
            " critical: " + isCritical() +
            " addendum: " + isAddendum() + ")";
    }

    @NotNull
    public OrderReportDataBuilder toBuilder()
    {
        return new OrderReportDataBuilder(getPatientName()).setId(getId())

                                                           .setPatientId(getPatientId())
                                                           .setAccession(getAccession())
                                                           .setModality(getModality())
                                                           .setBodyPart(getBodyPart())
                                                           .setImageCount(getImageCount())
                                                           .setPriority(getPriority())
                                                           .setStudyTime(getStudyTime())
                                                           .setArrivalTime(getArrivalTime())
                                                           .setReadyTime(getReadyTime())
                                                           .setAssignedTime(getAssignedTime())
                                                           .setReadTime(getReadTime())
                                                           .setFinalTime(getFinalTime())
                                                           .setRadiologist(getRadiologist())
                                                           .setDescription(getDescription())
                                                           .setStatus(getStatus())
                                                           .setSite(getSite())
                                                           .setCPTCode(getCPTCode())
                                                           .setCMSRVU(getCMSRVU())
                                                           .setCritical(isCritical())
                                                           .setAddendum(isAddendum());
    }
}