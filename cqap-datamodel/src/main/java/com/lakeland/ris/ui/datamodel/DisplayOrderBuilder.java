package com.lakeland.ris.ui.datamodel;

import org.jetbrains.annotations.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;


public class DisplayOrderBuilder
{
    @NotNull private String orderId;
    @NotNull private String messageId;
    @NotNull private OrderStatus status;
    @NotNull private OrderPriority priority;
    @Nullable private String assignedTo;
    @NotNull private Date created;
    @Nullable private Date updated;
    @Nullable private String firstName;
    @Nullable private String middleName;
    @Nullable private String lastName;
    @Nullable private String patientId;
    @Nullable private String birthDate;
    @Nullable private String sex;
    @Nullable private String alternatePatientId;
    @Nullable private String institutionName;
    @Nullable private String accessionNumber;
    @Nullable private String cPTCode;
    @Nullable private String cPTMnemonic;
    @Nullable private String modality;
    @Nullable private String studyDescription;
    @Nullable private String dicomStudyId;
    private int imageCount;
    private long timeElapsed;
    private boolean critical;
    @Nullable private String studyDate;
    @Nullable private String studyTime;
    @Nullable private String arrivalDate;
    @Nullable private String arrivalTime;
    @Nullable private String readingRadiologist;

    public DisplayOrderBuilder(@NotNull String orderId,
                               @NotNull String messageId,
                               @NotNull OrderStatus status,
                               @NotNull OrderPriority priority,
                               @NotNull Date created)
    {
        super();

        this.orderId = orderId;
        this.messageId = messageId;
        this.status = status;
        this.priority = priority;
        this.created = created;
    }


    @NotNull
    public DisplayOrderBuilder setOrderId(@NotNull String orderId)
    {
        this.orderId = orderId;

        return self();
    }

    @NotNull
    public DisplayOrderBuilder setMessageId(@NotNull String messageId)
    {
        this.messageId = messageId;

        return self();
    }

    @NotNull
    public DisplayOrderBuilder setStatus(@NotNull OrderStatus status)
    {
        this.status = status;

        return self();
    }

    @NotNull
    public DisplayOrderBuilder setPriority(@NotNull OrderPriority priority)
    {
        this.priority = priority;

        return self();
    }

    @NotNull
    public DisplayOrderBuilder setAssignedTo(@Nullable String assignedTo)
    {
        this.assignedTo = assignedTo;

        return self();
    }

    @NotNull
    public DisplayOrderBuilder setCreated(@NotNull Date created)
    {
        this.created = created;

        return self();
    }

    @NotNull
    public DisplayOrderBuilder setUpdated(@Nullable Date updated)
    {
        this.updated = updated;

        return self();
    }

    @NotNull
    public DisplayOrderBuilder setFirstName(@Nullable String firstName)
    {
        this.firstName = firstName;

        return self();
    }

    @NotNull
    public DisplayOrderBuilder setMiddleName(@Nullable String middleName)
    {
        this.middleName = middleName;

        return self();
    }

    @NotNull
    public DisplayOrderBuilder setLastName(@Nullable String lastName)
    {
        this.lastName = lastName;

        return self();
    }

    @NotNull
    public DisplayOrderBuilder setPatientId(@Nullable String patientId)
    {
        this.patientId = patientId;

        return self();
    }

    @NotNull
    public DisplayOrderBuilder setBirthDate(@Nullable String birthDate)
    {
        this.birthDate = birthDate;

        return self();
    }

    @NotNull
    public DisplayOrderBuilder setSex(@Nullable String sex)
    {
        this.sex = sex;

        return self();
    }

    @NotNull
    public DisplayOrderBuilder setAlternatePatientId(@Nullable String alternatePatientId)
    {
        this.alternatePatientId = alternatePatientId;

        return self();
    }

    @NotNull
    public DisplayOrderBuilder setInstitutionName(@Nullable String institutionName)
    {
        this.institutionName = institutionName;

        return self();
    }

    @NotNull
    public DisplayOrderBuilder setAccessionNumber(@Nullable String accessionNumber)
    {
        this.accessionNumber = accessionNumber;

        return self();
    }

    @NotNull
    public DisplayOrderBuilder setCPTCode(@Nullable String cPTCode)
    {
        this.cPTCode = cPTCode;

        return self();
    }

    @NotNull
    public DisplayOrderBuilder setCPTMnemonic(@Nullable String cPTMnemonic)
    {
        this.cPTMnemonic = cPTMnemonic;

        return self();
    }

    @NotNull
    public DisplayOrderBuilder setModality(@Nullable String modality)
    {
        this.modality = modality;

        return self();
    }

    @NotNull
    public DisplayOrderBuilder setStudyDescription(@Nullable String studyDescription)
    {
        this.studyDescription = studyDescription;

        return self();
    }

    @NotNull
    public DisplayOrderBuilder setDicomStudyId(@Nullable String dicomStudyId)
    {
        this.dicomStudyId = dicomStudyId;

        return self();
    }

    @NotNull
    public DisplayOrderBuilder setImageCount(int imageCount)
    {
        this.imageCount = imageCount;

        return self();
    }

    @NotNull
    public DisplayOrderBuilder setTimeElapsed(long timeElapsed)
    {
        this.timeElapsed = timeElapsed;

        return self();
    }

    @NotNull
    public DisplayOrderBuilder setCritical(boolean critical)
    {
        this.critical = critical;

        return self();
    }

    @NotNull
    public DisplayOrderBuilder setStudyDate(@Nullable String studyDate)
    {
        this.studyDate = studyDate;

        return self();
    }

    @NotNull
    public DisplayOrderBuilder setStudyTime(@Nullable String studyTime)
    {
        this.studyTime = studyTime;

        return self();
    }

    @NotNull
    public DisplayOrderBuilder setArrivalDate(@Nullable String arrivalDate)
    {
        this.arrivalDate = arrivalDate;

        return self();
    }

    @NotNull
    public DisplayOrderBuilder setArrivalTime(@Nullable String arrivalTime)
    {
        this.arrivalTime = arrivalTime;

        return self();
    }

    @NotNull
    public DisplayOrderBuilder setReadingRadiologist(@Nullable String readingRadiologist)
    {
        this.readingRadiologist = readingRadiologist;

        return self();
    }

    @NotNull
    protected String getOrderId()
    {
        return orderId;
    }

    @NotNull
    protected String getMessageId()
    {
        return messageId;
    }

    @NotNull
    protected OrderStatus getStatus()
    {
        return status;
    }

    @NotNull
    protected OrderPriority getPriority()
    {
        return priority;
    }

    @Nullable
    protected String getAssignedTo()
    {
        return assignedTo;
    }

    @NotNull
    protected Date getCreated()
    {
        return created;
    }

    @Nullable
    protected Date getUpdated()
    {
        return updated;
    }

    @Nullable
    protected String getFirstName()
    {
        return firstName;
    }

    @Nullable
    protected String getMiddleName()
    {
        return middleName;
    }

    @Nullable
    protected String getLastName()
    {
        return lastName;
    }

    @Nullable
    protected String getPatientId()
    {
        return patientId;
    }

    @Nullable
    protected String getBirthDate()
    {
        return birthDate;
    }

    @Nullable
    protected String getSex()
    {
        return sex;
    }

    @Nullable
    protected String getAlternatePatientId()
    {
        return alternatePatientId;
    }

    @Nullable
    protected String getInstitutionName()
    {
        return institutionName;
    }

    @Nullable
    protected String getAccessionNumber()
    {
        return accessionNumber;
    }

    @Nullable
    protected String getCPTCode()
    {
        return cPTCode;
    }

    @Nullable
    protected String getCPTMnemonic()
    {
        return cPTMnemonic;
    }

    @Nullable
    protected String getModality()
    {
        return modality;
    }

    @Nullable
    protected String getStudyDescription()
    {
        return studyDescription;
    }

    @Nullable
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

    @Nullable
    protected String getStudyDate()
    {
        return studyDate;
    }

    @Nullable
    protected String getStudyTime()
    {
        return studyTime;
    }

    @Nullable
    protected String getArrivalDate()
    {
        return arrivalDate;
    }

    @Nullable
    protected String getArrivalTime()
    {
        return arrivalTime;
    }

    @Nullable
    protected String getReadingRadiologist()
    {
        return readingRadiologist;
    }

    @NotNull
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


    @NotNull
    protected DisplayOrderBuilder self()
    {
        return this;
    }
}