package com.lakeland.ris.ui.datamodel;

import org.jetbrains.annotations.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;


public class OrderReportDataBuilder
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

    public OrderReportDataBuilder(@NotNull String patientName)
    {
        super();

        this.patientName = patientName;
    }


    @NotNull
    public OrderReportDataBuilder setId(int id)
    {
        this.id = id;

        return self();
    }

    @NotNull
    public OrderReportDataBuilder setPatientName(@NotNull String patientName)
    {
        this.patientName = patientName;

        return self();
    }

    @NotNull
    public OrderReportDataBuilder setPatientId(@Nullable String patientId)
    {
        this.patientId = patientId;

        return self();
    }

    @NotNull
    public OrderReportDataBuilder setAccession(@Nullable String accession)
    {
        this.accession = accession;

        return self();
    }

    @NotNull
    public OrderReportDataBuilder setModality(@Nullable String modality)
    {
        this.modality = modality;

        return self();
    }

    @NotNull
    public OrderReportDataBuilder setBodyPart(@Nullable String bodyPart)
    {
        this.bodyPart = bodyPart;

        return self();
    }

    @NotNull
    public OrderReportDataBuilder setImageCount(int imageCount)
    {
        this.imageCount = imageCount;

        return self();
    }

    @NotNull
    public OrderReportDataBuilder setPriority(@Nullable String priority)
    {
        this.priority = priority;

        return self();
    }

    @NotNull
    public OrderReportDataBuilder setStudyTime(@Nullable Date studyTime)
    {
        this.studyTime = studyTime;

        return self();
    }

    @NotNull
    public OrderReportDataBuilder setArrivalTime(@Nullable Date arrivalTime)
    {
        this.arrivalTime = arrivalTime;

        return self();
    }

    @NotNull
    public OrderReportDataBuilder setReadyTime(@Nullable Date readyTime)
    {
        this.readyTime = readyTime;

        return self();
    }

    @NotNull
    public OrderReportDataBuilder setAssignedTime(@Nullable Date assignedTime)
    {
        this.assignedTime = assignedTime;

        return self();
    }

    @NotNull
    public OrderReportDataBuilder setReadTime(@Nullable Date readTime)
    {
        this.readTime = readTime;

        return self();
    }

    @NotNull
    public OrderReportDataBuilder setFinalTime(@Nullable Date finalTime)
    {
        this.finalTime = finalTime;

        return self();
    }

    @NotNull
    public OrderReportDataBuilder setRadiologist(@Nullable String radiologist)
    {
        this.radiologist = radiologist;

        return self();
    }

    @NotNull
    public OrderReportDataBuilder setDescription(@Nullable String description)
    {
        this.description = description;

        return self();
    }

    @NotNull
    public OrderReportDataBuilder setStatus(@Nullable String status)
    {
        this.status = status;

        return self();
    }

    @NotNull
    public OrderReportDataBuilder setSite(@Nullable String site)
    {
        this.site = site;

        return self();
    }

    @NotNull
    public OrderReportDataBuilder setCPTCode(@Nullable String cPTCode)
    {
        this.cPTCode = cPTCode;

        return self();
    }

    @NotNull
    public OrderReportDataBuilder setCMSRVU(@Nullable String cMSRVU)
    {
        this.cMSRVU = cMSRVU;

        return self();
    }

    @NotNull
    public OrderReportDataBuilder setCritical(boolean critical)
    {
        this.critical = critical;

        return self();
    }

    @NotNull
    public OrderReportDataBuilder setAddendum(boolean addendum)
    {
        this.addendum = addendum;

        return self();
    }

    protected int getId()
    {
        return id;
    }

    @NotNull
    protected String getPatientName()
    {
        return patientName;
    }

    @Nullable
    protected String getPatientId()
    {
        return patientId;
    }

    @Nullable
    protected String getAccession()
    {
        return accession;
    }

    @Nullable
    protected String getModality()
    {
        return modality;
    }

    @Nullable
    protected String getBodyPart()
    {
        return bodyPart;
    }

    protected int getImageCount()
    {
        return imageCount;
    }

    @Nullable
    protected String getPriority()
    {
        return priority;
    }

    @Nullable
    protected Date getStudyTime()
    {
        return studyTime;
    }

    @Nullable
    protected Date getArrivalTime()
    {
        return arrivalTime;
    }

    @Nullable
    protected Date getReadyTime()
    {
        return readyTime;
    }

    @Nullable
    protected Date getAssignedTime()
    {
        return assignedTime;
    }

    @Nullable
    protected Date getReadTime()
    {
        return readTime;
    }

    @Nullable
    protected Date getFinalTime()
    {
        return finalTime;
    }

    @Nullable
    protected String getRadiologist()
    {
        return radiologist;
    }

    @Nullable
    protected String getDescription()
    {
        return description;
    }

    @Nullable
    protected String getStatus()
    {
        return status;
    }

    @Nullable
    protected String getSite()
    {
        return site;
    }

    @Nullable
    protected String getCPTCode()
    {
        return cPTCode;
    }

    @Nullable
    protected String getCMSRVU()
    {
        return cMSRVU;
    }

    protected boolean isCritical()
    {
        return critical;
    }

    protected boolean isAddendum()
    {
        return addendum;
    }

    @NotNull
    public OrderReportData build()
    {
        return new OrderReportData(getId(),
                                   getPatientName(),
                                   getPatientId(),
                                   getAccession(),
                                   getModality(),
                                   getBodyPart(),
                                   getImageCount(),
                                   getPriority(),
                                   getStudyTime(),
                                   getArrivalTime(),
                                   getReadyTime(),
                                   getAssignedTime(),
                                   getReadTime(),
                                   getFinalTime(),
                                   getRadiologist(),
                                   getDescription(),
                                   getStatus(),
                                   getSite(),
                                   getCPTCode(),
                                   getCMSRVU(),
                                   isCritical(),
                                   isAddendum());
    }


    @NotNull
    protected OrderReportDataBuilder self()
    {
        return this;
    }
}