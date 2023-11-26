package com.lakeland.ris.ui.datamodel;

import org.codehaus.jackson.annotate.*;
import org.jetbrains.annotations.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;


public class DisplayOrder
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

    public DisplayOrder()
    {
        // empty
    }

    @JsonCreator
    public DisplayOrder(@NotNull String orderId,
                        @NotNull String messageId,
                        @NotNull OrderStatus status,
                        @NotNull OrderPriority priority,
                        @Nullable String assignedTo,
                        @NotNull Date created,
                        @Nullable Date updated,
                        @Nullable String firstName,
                        @Nullable String middleName,
                        @Nullable String lastName,
                        @Nullable String patientId,
                        @Nullable String birthDate,
                        @Nullable String sex,
                        @Nullable String alternatePatientId,
                        @Nullable String institutionName,
                        @Nullable String accessionNumber,
                        @Nullable String cPTCode,
                        @Nullable String cPTMnemonic,
                        @Nullable String modality,
                        @Nullable String studyDescription,
                        @Nullable String dicomStudyId,
                        int imageCount,
                        long timeElapsed,
                        boolean critical,
                        @Nullable String studyDate,
                        @Nullable String studyTime,
                        @Nullable String arrivalDate,
                        @Nullable String arrivalTime,
                        @Nullable String readingRadiologist)
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

    @NotNull
    public String getOrderId()
    {
        return orderId;
    }

    @NotNull
    public String getMessageId()
    {
        return messageId;
    }

    @NotNull
    public OrderStatus getStatus()
    {
        return status;
    }

    @NotNull
    public OrderPriority getPriority()
    {
        return priority;
    }

    @Nullable
    public String getAssignedTo()
    {
        return assignedTo;
    }

    @NotNull
    public Date getCreated()
    {
        return created;
    }

    @Nullable
    public Date getUpdated()
    {
        return updated;
    }

    @Nullable
    public String getFirstName()
    {
        return firstName;
    }

    @Nullable
    public String getMiddleName()
    {
        return middleName;
    }

    @Nullable
    public String getLastName()
    {
        return lastName;
    }

    @Nullable
    public String getPatientId()
    {
        return patientId;
    }

    @Nullable
    public String getBirthDate()
    {
        return birthDate;
    }

    @Nullable
    public String getSex()
    {
        return sex;
    }

    @Nullable
    public String getAlternatePatientId()
    {
        return alternatePatientId;
    }

    @Nullable
    public String getInstitutionName()
    {
        return institutionName;
    }

    @Nullable
    public String getAccessionNumber()
    {
        return accessionNumber;
    }

    @Nullable
    public String getCPTCode()
    {
        return cPTCode;
    }

    @Nullable
    public String getCPTMnemonic()
    {
        return cPTMnemonic;
    }

    @Nullable
    public String getModality()
    {
        return modality;
    }

    @Nullable
    public String getStudyDescription()
    {
        return studyDescription;
    }

    @Nullable
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

    @Nullable
    public String getStudyDate()
    {
        return studyDate;
    }

    @Nullable
    public String getStudyTime()
    {
        return studyTime;
    }

    @Nullable
    public String getArrivalDate()
    {
        return arrivalDate;
    }

    @Nullable
    public String getArrivalTime()
    {
        return arrivalTime;
    }

    @Nullable
    public String getReadingRadiologist()
    {
        return readingRadiologist;
    }
    public void setOrderId(@NotNull String orderId)
    {
        this.orderId = orderId;
    }

    public void setMessageId(@NotNull String messageId)
    {
        this.messageId = messageId;
    }

    public void setStatus(@NotNull OrderStatus status)
    {
        this.status = status;
    }

    public void setPriority(@NotNull OrderPriority priority)
    {
        this.priority = priority;
    }

    public void setAssignedTo(@Nullable String assignedTo)
    {
        this.assignedTo = assignedTo;
    }

    public void setCreated(@NotNull Date created)
    {
        this.created = created;
    }

    public void setUpdated(@Nullable Date updated)
    {
        this.updated = updated;
    }

    public void setFirstName(@Nullable String firstName)
    {
        this.firstName = firstName;
    }

    public void setMiddleName(@Nullable String middleName)
    {
        this.middleName = middleName;
    }

    public void setLastName(@Nullable String lastName)
    {
        this.lastName = lastName;
    }

    public void setPatientId(@Nullable String patientId)
    {
        this.patientId = patientId;
    }

    public void setBirthDate(@Nullable String birthDate)
    {
        this.birthDate = birthDate;
    }

    public void setSex(@Nullable String sex)
    {
        this.sex = sex;
    }

    public void setAlternatePatientId(@Nullable String alternatePatientId)
    {
        this.alternatePatientId = alternatePatientId;
    }

    public void setInstitutionName(@Nullable String institutionName)
    {
        this.institutionName = institutionName;
    }

    public void setAccessionNumber(@Nullable String accessionNumber)
    {
        this.accessionNumber = accessionNumber;
    }

    public void setCPTCode(@Nullable String cPTCode)
    {
        this.cPTCode = cPTCode;
    }

    public void setCPTMnemonic(@Nullable String cPTMnemonic)
    {
        this.cPTMnemonic = cPTMnemonic;
    }

    public void setModality(@Nullable String modality)
    {
        this.modality = modality;
    }

    public void setStudyDescription(@Nullable String studyDescription)
    {
        this.studyDescription = studyDescription;
    }

    public void setDicomStudyId(@Nullable String dicomStudyId)
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

    public void setStudyDate(@Nullable String studyDate)
    {
        this.studyDate = studyDate;
    }

    public void setStudyTime(@Nullable String studyTime)
    {
        this.studyTime = studyTime;
    }

    public void setArrivalDate(@Nullable String arrivalDate)
    {
        this.arrivalDate = arrivalDate;
    }

    public void setArrivalTime(@Nullable String arrivalTime)
    {
        this.arrivalTime = arrivalTime;
    }

    public void setReadingRadiologist(@Nullable String readingRadiologist)
    {
        this.readingRadiologist = readingRadiologist;
    }

    @NotNull
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

    @NotNull
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