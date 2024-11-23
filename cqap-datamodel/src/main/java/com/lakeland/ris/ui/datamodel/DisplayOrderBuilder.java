package com.lakeland.ris.ui.datamodel;


import java.util.*;
import com.lakeland.ris.datamodel.*;


public class DisplayOrderBuilder
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

    public DisplayOrderBuilder(String orderId,
                               String messageId,
                               OrderStatus status,
                               OrderPriority priority,
                               Date created)
    {
        super();

        this.orderId = orderId;
        this.messageId = messageId;
        this.status = status;
        this.priority = priority;
        this.created = created;
    }



    public DisplayOrderBuilder setOrderId(String orderId)
    {
        this.orderId = orderId;

        return self();
    }


    public DisplayOrderBuilder setMessageId(String messageId)
    {
        this.messageId = messageId;

        return self();
    }


    public DisplayOrderBuilder setStatus(OrderStatus status)
    {
        this.status = status;

        return self();
    }


    public DisplayOrderBuilder setPriority(OrderPriority priority)
    {
        this.priority = priority;

        return self();
    }


    public DisplayOrderBuilder setAssignedTo( String assignedTo)
    {
        this.assignedTo = assignedTo;

        return self();
    }


    public DisplayOrderBuilder setCreated(Date created)
    {
        this.created = created;

        return self();
    }


    public DisplayOrderBuilder setUpdated( Date updated)
    {
        this.updated = updated;

        return self();
    }


    public DisplayOrderBuilder setFirstName( String firstName)
    {
        this.firstName = firstName;

        return self();
    }


    public DisplayOrderBuilder setMiddleName( String middleName)
    {
        this.middleName = middleName;

        return self();
    }


    public DisplayOrderBuilder setLastName( String lastName)
    {
        this.lastName = lastName;

        return self();
    }


    public DisplayOrderBuilder setPatientId( String patientId)
    {
        this.patientId = patientId;

        return self();
    }


    public DisplayOrderBuilder setBirthDate( String birthDate)
    {
        this.birthDate = birthDate;

        return self();
    }


    public DisplayOrderBuilder setSex( String sex)
    {
        this.sex = sex;

        return self();
    }


    public DisplayOrderBuilder setAlternatePatientId( String alternatePatientId)
    {
        this.alternatePatientId = alternatePatientId;

        return self();
    }


    public DisplayOrderBuilder setInstitutionName( String institutionName)
    {
        this.institutionName = institutionName;

        return self();
    }


    public DisplayOrderBuilder setAccessionNumber( String accessionNumber)
    {
        this.accessionNumber = accessionNumber;

        return self();
    }


    public DisplayOrderBuilder setCPTCode( String cPTCode)
    {
        this.cPTCode = cPTCode;

        return self();
    }


    public DisplayOrderBuilder setCPTMnemonic( String cPTMnemonic)
    {
        this.cPTMnemonic = cPTMnemonic;

        return self();
    }


    public DisplayOrderBuilder setModality( String modality)
    {
        this.modality = modality;

        return self();
    }


    public DisplayOrderBuilder setStudyDescription( String studyDescription)
    {
        this.studyDescription = studyDescription;

        return self();
    }


    public DisplayOrderBuilder setDicomStudyId( String dicomStudyId)
    {
        this.dicomStudyId = dicomStudyId;

        return self();
    }


    public DisplayOrderBuilder setImageCount(int imageCount)
    {
        this.imageCount = imageCount;

        return self();
    }


    public DisplayOrderBuilder setTimeElapsed(long timeElapsed)
    {
        this.timeElapsed = timeElapsed;

        return self();
    }


    public DisplayOrderBuilder setCritical(boolean critical)
    {
        this.critical = critical;

        return self();
    }


    public DisplayOrderBuilder setStudyDate( String studyDate)
    {
        this.studyDate = studyDate;

        return self();
    }


    public DisplayOrderBuilder setStudyTime( String studyTime)
    {
        this.studyTime = studyTime;

        return self();
    }


    public DisplayOrderBuilder setArrivalDate( String arrivalDate)
    {
        this.arrivalDate = arrivalDate;

        return self();
    }


    public DisplayOrderBuilder setArrivalTime( String arrivalTime)
    {
        this.arrivalTime = arrivalTime;

        return self();
    }


    public DisplayOrderBuilder setReadingRadiologist( String readingRadiologist)
    {
        this.readingRadiologist = readingRadiologist;

        return self();
    }


    protected String getOrderId()
    {
        return orderId;
    }


    protected String getMessageId()
    {
        return messageId;
    }


    protected OrderStatus getStatus()
    {
        return status;
    }


    protected OrderPriority getPriority()
    {
        return priority;
    }

    
    protected String getAssignedTo()
    {
        return assignedTo;
    }


    protected Date getCreated()
    {
        return created;
    }

    
    protected Date getUpdated()
    {
        return updated;
    }

    
    protected String getFirstName()
    {
        return firstName;
    }

    
    protected String getMiddleName()
    {
        return middleName;
    }

    
    protected String getLastName()
    {
        return lastName;
    }

    
    protected String getPatientId()
    {
        return patientId;
    }

    
    protected String getBirthDate()
    {
        return birthDate;
    }

    
    protected String getSex()
    {
        return sex;
    }

    
    protected String getAlternatePatientId()
    {
        return alternatePatientId;
    }

    
    protected String getInstitutionName()
    {
        return institutionName;
    }

    
    protected String getAccessionNumber()
    {
        return accessionNumber;
    }

    
    protected String getCPTCode()
    {
        return cPTCode;
    }

    
    protected String getCPTMnemonic()
    {
        return cPTMnemonic;
    }

    
    protected String getModality()
    {
        return modality;
    }

    
    protected String getStudyDescription()
    {
        return studyDescription;
    }

    
    protected String getDicomStudyId()
    {
        return dicomStudyId;
    }

    protected int getImageCount()
    {
        return imageCount;
    }

    protected long getTimeElapsed()
    {
        return timeElapsed;
    }

    protected boolean isCritical()
    {
        return critical;
    }

    
    protected String getStudyDate()
    {
        return studyDate;
    }

    
    protected String getStudyTime()
    {
        return studyTime;
    }

    
    protected String getArrivalDate()
    {
        return arrivalDate;
    }

    
    protected String getArrivalTime()
    {
        return arrivalTime;
    }

    
    protected String getReadingRadiologist()
    {
        return readingRadiologist;
    }


    public DisplayOrder build()
    {
        return new DisplayOrder(getOrderId(),
                                getMessageId(),
                                getStatus(),
                                getPriority(),
                                getAssignedTo(),
                                getCreated(),
                                getUpdated(),
                                getFirstName(),
                                getMiddleName(),
                                getLastName(),
                                getPatientId(),
                                getBirthDate(),
                                getSex(),
                                getAlternatePatientId(),
                                getInstitutionName(),
                                getAccessionNumber(),
                                getCPTCode(),
                                getCPTMnemonic(),
                                getModality(),
                                getStudyDescription(),
                                getDicomStudyId(),
                                getImageCount(),
                                getTimeElapsed(),
                                isCritical(),
                                getStudyDate(),
                                getStudyTime(),
                                getArrivalDate(),
                                getArrivalTime(),
                                getReadingRadiologist());
    }



    protected DisplayOrderBuilder self()
    {
        return this;
    }
}