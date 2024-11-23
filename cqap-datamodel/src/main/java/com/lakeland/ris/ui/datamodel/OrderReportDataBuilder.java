package com.lakeland.ris.ui.datamodel;


import java.util.*;
import com.lakeland.ris.datamodel.*;


public class OrderReportDataBuilder
{
    private int id;
    private String patientName;
     private String patientId;
     private String accession;
     private String modality;
     private String bodyPart;
    private int imageCount;
     private String priority;
     private Date studyTime;
     private Date arrivalTime;
     private Date readyTime;
     private Date assignedTime;
     private Date readTime;
     private Date finalTime;
     private String radiologist;
     private String description;
     private String status;
     private String site;
     private String cPTCode;
     private String cMSRVU;
    private boolean critical;
    private boolean addendum;

    public OrderReportDataBuilder(String patientName)
    {
        super();

        this.patientName = patientName;
    }


    
    public OrderReportDataBuilder setId(int id)
    {
        this.id = id;

        return self();
    }

    
    public OrderReportDataBuilder setPatientName(String patientName)
    {
        this.patientName = patientName;

        return self();
    }

    
    public OrderReportDataBuilder setPatientId( String patientId)
    {
        this.patientId = patientId;

        return self();
    }

    
    public OrderReportDataBuilder setAccession( String accession)
    {
        this.accession = accession;

        return self();
    }

    
    public OrderReportDataBuilder setModality( String modality)
    {
        this.modality = modality;

        return self();
    }

    
    public OrderReportDataBuilder setBodyPart( String bodyPart)
    {
        this.bodyPart = bodyPart;

        return self();
    }

    
    public OrderReportDataBuilder setImageCount(int imageCount)
    {
        this.imageCount = imageCount;

        return self();
    }

    
    public OrderReportDataBuilder setPriority( String priority)
    {
        this.priority = priority;

        return self();
    }

    
    public OrderReportDataBuilder setStudyTime( Date studyTime)
    {
        this.studyTime = studyTime;

        return self();
    }

    
    public OrderReportDataBuilder setArrivalTime( Date arrivalTime)
    {
        this.arrivalTime = arrivalTime;

        return self();
    }

    
    public OrderReportDataBuilder setReadyTime( Date readyTime)
    {
        this.readyTime = readyTime;

        return self();
    }

    
    public OrderReportDataBuilder setAssignedTime( Date assignedTime)
    {
        this.assignedTime = assignedTime;

        return self();
    }

    
    public OrderReportDataBuilder setReadTime( Date readTime)
    {
        this.readTime = readTime;

        return self();
    }

    
    public OrderReportDataBuilder setFinalTime( Date finalTime)
    {
        this.finalTime = finalTime;

        return self();
    }

    
    public OrderReportDataBuilder setRadiologist( String radiologist)
    {
        this.radiologist = radiologist;

        return self();
    }

    
    public OrderReportDataBuilder setDescription( String description)
    {
        this.description = description;

        return self();
    }

    
    public OrderReportDataBuilder setStatus( String status)
    {
        this.status = status;

        return self();
    }

    
    public OrderReportDataBuilder setSite( String site)
    {
        this.site = site;

        return self();
    }

    
    public OrderReportDataBuilder setCPTCode( String cPTCode)
    {
        this.cPTCode = cPTCode;

        return self();
    }

    
    public OrderReportDataBuilder setCMSRVU( String cMSRVU)
    {
        this.cMSRVU = cMSRVU;

        return self();
    }

    
    public OrderReportDataBuilder setCritical(boolean critical)
    {
        this.critical = critical;

        return self();
    }

    
    public OrderReportDataBuilder setAddendum(boolean addendum)
    {
        this.addendum = addendum;

        return self();
    }

    protected int getId()
    {
        return id;
    }

    
    protected String getPatientName()
    {
        return patientName;
    }

    
    protected String getPatientId()
    {
        return patientId;
    }

    
    protected String getAccession()
    {
        return accession;
    }

    
    protected String getModality()
    {
        return modality;
    }

    
    protected String getBodyPart()
    {
        return bodyPart;
    }

    protected int getImageCount()
    {
        return imageCount;
    }

    
    protected String getPriority()
    {
        return priority;
    }

    
    protected Date getStudyTime()
    {
        return studyTime;
    }

    
    protected Date getArrivalTime()
    {
        return arrivalTime;
    }

    
    protected Date getReadyTime()
    {
        return readyTime;
    }

    
    protected Date getAssignedTime()
    {
        return assignedTime;
    }

    
    protected Date getReadTime()
    {
        return readTime;
    }

    
    protected Date getFinalTime()
    {
        return finalTime;
    }

    
    protected String getRadiologist()
    {
        return radiologist;
    }

    
    protected String getDescription()
    {
        return description;
    }

    
    protected String getStatus()
    {
        return status;
    }

    
    protected String getSite()
    {
        return site;
    }

    
    protected String getCPTCode()
    {
        return cPTCode;
    }

    
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


    
    protected OrderReportDataBuilder self()
    {
        return this;
    }
}