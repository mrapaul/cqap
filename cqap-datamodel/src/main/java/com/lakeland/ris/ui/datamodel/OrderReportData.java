package com.lakeland.ris.ui.datamodel;

import org.codehaus.jackson.annotate.*;

import java.util.*;
import com.lakeland.ris.datamodel.*;


public class OrderReportData
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

    public OrderReportData()
    {
        // empty
    }

    @JsonCreator
    public OrderReportData(int id,
                           String patientName,
                            String patientId,
                            String accession,
                            String modality,
                            String bodyPart,
                           int imageCount,
                            String priority,
                            Date studyTime,
                            Date arrivalTime,
                            Date readyTime,
                            Date assignedTime,
                            Date readTime,
                            Date finalTime,
                            String radiologist,
                            String description,
                            String status,
                            String site,
                            String cPTCode,
                            String cMSRVU,
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

    
    public String getPatientName()
    {
        return patientName;
    }

    
    public String getPatientId()
    {
        return patientId;
    }

    
    public String getAccession()
    {
        return accession;
    }

    
    public String getModality()
    {
        return modality;
    }

    
    public String getBodyPart()
    {
        return bodyPart;
    }

    public int getImageCount()
    {
        return imageCount;
    }

    
    public String getPriority()
    {
        return priority;
    }

    
    public Date getStudyTime()
    {
        return studyTime;
    }

    
    public Date getArrivalTime()
    {
        return arrivalTime;
    }

    
    public Date getReadyTime()
    {
        return readyTime;
    }

    
    public Date getAssignedTime()
    {
        return assignedTime;
    }

    
    public Date getReadTime()
    {
        return readTime;
    }

    
    public Date getFinalTime()
    {
        return finalTime;
    }

    
    public String getRadiologist()
    {
        return radiologist;
    }

    
    public String getDescription()
    {
        return description;
    }

    
    public String getStatus()
    {
        return status;
    }

    
    public String getSite()
    {
        return site;
    }

    
    public String getCPTCode()
    {
        return cPTCode;
    }

    
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

    public void setPatientName(String patientName)
    {
        this.patientName = patientName;
    }

    public void setPatientId( String patientId)
    {
        this.patientId = patientId;
    }

    public void setAccession( String accession)
    {
        this.accession = accession;
    }

    public void setModality( String modality)
    {
        this.modality = modality;
    }

    public void setBodyPart( String bodyPart)
    {
        this.bodyPart = bodyPart;
    }

    public void setImageCount(int imageCount)
    {
        this.imageCount = imageCount;
    }

    public void setPriority( String priority)
    {
        this.priority = priority;
    }

    public void setStudyTime( Date studyTime)
    {
        this.studyTime = studyTime;
    }

    public void setArrivalTime( Date arrivalTime)
    {
        this.arrivalTime = arrivalTime;
    }

    public void setReadyTime( Date readyTime)
    {
        this.readyTime = readyTime;
    }

    public void setAssignedTime( Date assignedTime)
    {
        this.assignedTime = assignedTime;
    }

    public void setReadTime( Date readTime)
    {
        this.readTime = readTime;
    }

    public void setFinalTime( Date finalTime)
    {
        this.finalTime = finalTime;
    }

    public void setRadiologist( String radiologist)
    {
        this.radiologist = radiologist;
    }

    public void setDescription( String description)
    {
        this.description = description;
    }

    public void setStatus( String status)
    {
        this.status = status;
    }

    public void setSite( String site)
    {
        this.site = site;
    }

    public void setCPTCode( String cPTCode)
    {
        this.cPTCode = cPTCode;
    }

    public void setCMSRVU( String cMSRVU)
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