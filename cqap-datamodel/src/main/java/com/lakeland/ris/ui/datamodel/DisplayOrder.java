package com.lakeland.ris.ui.datamodel;

import org.codehaus.jackson.annotate.*;

import java.util.*;
import com.lakeland.ris.datamodel.*;


public class DisplayOrder
{
    private String orderId;
    private String messageId;
    private OrderStatus status;
    private OrderPriority priority;
     private String assignedTo;
    private Date created;
     private Date updated;
     private String firstName;
     private String middleName;
     private String lastName;
     private String patientId;
     private String birthDate;
     private String sex;
     private String alternatePatientId;
     private String institutionName;
     private String accessionNumber;
     private String cPTCode;
     private String cPTMnemonic;
     private String modality;
     private String studyDescription;
     private String dicomStudyId;
    private int imageCount;
    private long timeElapsed;
    private boolean critical;
     private String studyDate;
     private String studyTime;
     private String arrivalDate;
     private String arrivalTime;
     private String readingRadiologist;

    public DisplayOrder()
    {
        // empty
    }

    @JsonCreator
    public DisplayOrder(String orderId,
                        String messageId,
                        OrderStatus status,
                        OrderPriority priority,
                         String assignedTo,
                        Date created,
                         Date updated,
                         String firstName,
                         String middleName,
                         String lastName,
                         String patientId,
                         String birthDate,
                         String sex,
                         String alternatePatientId,
                         String institutionName,
                         String accessionNumber,
                         String cPTCode,
                         String cPTMnemonic,
                         String modality,
                         String studyDescription,
                         String dicomStudyId,
                        int imageCount,
                        long timeElapsed,
                        boolean critical,
                         String studyDate,
                         String studyTime,
                         String arrivalDate,
                         String arrivalTime,
                         String readingRadiologist)
    {
        super();

        this.orderId = orderId;
        this.messageId = messageId;
        this.status = status;
        this.priority = priority;
        this.assignedTo = assignedTo;
        this.created = created;
        this.updated = updated;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.patientId = patientId;
        this.birthDate = birthDate;
        this.sex = sex;
        this.alternatePatientId = alternatePatientId;
        this.institutionName = institutionName;
        this.accessionNumber = accessionNumber;
        this.cPTCode = cPTCode;
        this.cPTMnemonic = cPTMnemonic;
        this.modality = modality;
        this.studyDescription = studyDescription;
        this.dicomStudyId = dicomStudyId;
        this.imageCount = imageCount;
        this.timeElapsed = timeElapsed;
        this.critical = critical;
        this.studyDate = studyDate;
        this.studyTime = studyTime;
        this.arrivalDate = arrivalDate;
        this.arrivalTime = arrivalTime;
        this.readingRadiologist = readingRadiologist;
    }

    
    public String getOrderId()
    {
        return orderId;
    }

    
    public String getMessageId()
    {
        return messageId;
    }

    
    public OrderStatus getStatus()
    {
        return status;
    }

    
    public OrderPriority getPriority()
    {
        return priority;
    }

    
    public String getAssignedTo()
    {
        return assignedTo;
    }

    
    public Date getCreated()
    {
        return created;
    }

    
    public Date getUpdated()
    {
        return updated;
    }

    
    public String getFirstName()
    {
        return firstName;
    }

    
    public String getMiddleName()
    {
        return middleName;
    }

    
    public String getLastName()
    {
        return lastName;
    }

    
    public String getPatientId()
    {
        return patientId;
    }

    
    public String getBirthDate()
    {
        return birthDate;
    }

    
    public String getSex()
    {
        return sex;
    }

    
    public String getAlternatePatientId()
    {
        return alternatePatientId;
    }

    
    public String getInstitutionName()
    {
        return institutionName;
    }

    
    public String getAccessionNumber()
    {
        return accessionNumber;
    }

    
    public String getCPTCode()
    {
        return cPTCode;
    }

    
    public String getCPTMnemonic()
    {
        return cPTMnemonic;
    }

    
    public String getModality()
    {
        return modality;
    }

    
    public String getStudyDescription()
    {
        return studyDescription;
    }

    
    public String getDicomStudyId()
    {
        return dicomStudyId;
    }

    public int getImageCount()
    {
        return imageCount;
    }

    public long getTimeElapsed()
    {
        return timeElapsed;
    }

    public boolean isCritical()
    {
        return critical;
    }

    
    public String getStudyDate()
    {
        return studyDate;
    }

    
    public String getStudyTime()
    {
        return studyTime;
    }

    
    public String getArrivalDate()
    {
        return arrivalDate;
    }

    
    public String getArrivalTime()
    {
        return arrivalTime;
    }

    
    public String getReadingRadiologist()
    {
        return readingRadiologist;
    }
    public void setOrderId(String orderId)
    {
        this.orderId = orderId;
    }

    public void setMessageId(String messageId)
    {
        this.messageId = messageId;
    }

    public void setStatus(OrderStatus status)
    {
        this.status = status;
    }

    public void setPriority(OrderPriority priority)
    {
        this.priority = priority;
    }

    public void setAssignedTo( String assignedTo)
    {
        this.assignedTo = assignedTo;
    }

    public void setCreated(Date created)
    {
        this.created = created;
    }

    public void setUpdated( Date updated)
    {
        this.updated = updated;
    }

    public void setFirstName( String firstName)
    {
        this.firstName = firstName;
    }

    public void setMiddleName( String middleName)
    {
        this.middleName = middleName;
    }

    public void setLastName( String lastName)
    {
        this.lastName = lastName;
    }

    public void setPatientId( String patientId)
    {
        this.patientId = patientId;
    }

    public void setBirthDate( String birthDate)
    {
        this.birthDate = birthDate;
    }

    public void setSex( String sex)
    {
        this.sex = sex;
    }

    public void setAlternatePatientId( String alternatePatientId)
    {
        this.alternatePatientId = alternatePatientId;
    }

    public void setInstitutionName( String institutionName)
    {
        this.institutionName = institutionName;
    }

    public void setAccessionNumber( String accessionNumber)
    {
        this.accessionNumber = accessionNumber;
    }

    public void setCPTCode( String cPTCode)
    {
        this.cPTCode = cPTCode;
    }

    public void setCPTMnemonic( String cPTMnemonic)
    {
        this.cPTMnemonic = cPTMnemonic;
    }

    public void setModality( String modality)
    {
        this.modality = modality;
    }

    public void setStudyDescription( String studyDescription)
    {
        this.studyDescription = studyDescription;
    }

    public void setDicomStudyId( String dicomStudyId)
    {
        this.dicomStudyId = dicomStudyId;
    }

    public void setImageCount(int imageCount)
    {
        this.imageCount = imageCount;
    }

    public void setTimeElapsed(long timeElapsed)
    {
        this.timeElapsed = timeElapsed;
    }

    public void setCritical(boolean critical)
    {
        this.critical = critical;
    }

    public void setStudyDate( String studyDate)
    {
        this.studyDate = studyDate;
    }

    public void setStudyTime( String studyTime)
    {
        this.studyTime = studyTime;
    }

    public void setArrivalDate( String arrivalDate)
    {
        this.arrivalDate = arrivalDate;
    }

    public void setArrivalTime( String arrivalTime)
    {
        this.arrivalTime = arrivalTime;
    }

    public void setReadingRadiologist( String readingRadiologist)
    {
        this.readingRadiologist = readingRadiologist;
    }

    
    public String toString()
    {
        return "DisplayOrder(" +
            " orderId: " + getOrderId() +
            " messageId: " + getMessageId() +
            " status: " + getStatus() +
            " priority: " + getPriority() +
            " assignedTo: " + getAssignedTo() +
            " created: " + getCreated() +
            " updated: " + getUpdated() +
            " firstName: " + getFirstName() +
            " middleName: " + getMiddleName() +
            " lastName: " + getLastName() +
            " patientId: " + getPatientId() +
            " birthDate: " + getBirthDate() +
            " sex: " + getSex() +
            " alternatePatientId: " + getAlternatePatientId() +
            " institutionName: " + getInstitutionName() +
            " accessionNumber: " + getAccessionNumber() +
            " cPTCode: " + getCPTCode() +
            " cPTMnemonic: " + getCPTMnemonic() +
            " modality: " + getModality() +
            " studyDescription: " + getStudyDescription() +
            " dicomStudyId: " + getDicomStudyId() +
            " imageCount: " + getImageCount() +
            " timeElapsed: " + getTimeElapsed() +
            " critical: " + isCritical() +
            " studyDate: " + getStudyDate() +
            " studyTime: " + getStudyTime() +
            " arrivalDate: " + getArrivalDate() +
            " arrivalTime: " + getArrivalTime() +
            " readingRadiologist: " + getReadingRadiologist() + ")";
    }

    
    public DisplayOrderBuilder toBuilder()
    {
        return new DisplayOrderBuilder(getOrderId(),
                                       getMessageId(),
                                       getStatus(),
                                       getPriority(),
                                       getCreated()).setAssignedTo(getAssignedTo())

                                                     .setUpdated(getUpdated())
                                                     .setFirstName(getFirstName())
                                                     .setMiddleName(getMiddleName())
                                                     .setLastName(getLastName())
                                                     .setPatientId(getPatientId())
                                                     .setBirthDate(getBirthDate())
                                                     .setSex(getSex())
                                                     .setAlternatePatientId(getAlternatePatientId())
                                                     .setInstitutionName(getInstitutionName())
                                                     .setAccessionNumber(getAccessionNumber())
                                                     .setCPTCode(getCPTCode())
                                                     .setCPTMnemonic(getCPTMnemonic())
                                                     .setModality(getModality())
                                                     .setStudyDescription(getStudyDescription())
                                                     .setDicomStudyId(getDicomStudyId())
                                                     .setImageCount(getImageCount())
                                                     .setTimeElapsed(getTimeElapsed())
                                                     .setCritical(isCritical())
                                                     .setStudyDate(getStudyDate())
                                                     .setStudyTime(getStudyTime())
                                                     .setArrivalDate(getArrivalDate())
                                                     .setArrivalTime(getArrivalTime())
                                                     .setReadingRadiologist(getReadingRadiologist());
    }
}