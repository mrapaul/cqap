package com.lakeland.ris.ui.datamodel;

import org.codehaus.jackson.annotate.*;
import org.jetbrains.annotations.*;
import java.util.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;
import java.util.*;

public class HL7MessageQuery
{
    @Nullable private String orderNumber;
    @Nullable private Date createdStartDate;
    @Nullable private Date createdEndDate;
    @Nullable private Date updatedStartDate;
    @Nullable private Date updatedEndDate;
    @Nullable private String firstName;
    @Nullable private String lastName;
    @Nullable private String mRN;
    @Nullable private String accession;
    @Nullable private String modality;
    @Nullable private String studyDescription;
    @Nullable private String cPTCode;
    @Nullable private Collection<String> institutions;
    private boolean exactSearch;
    @Nullable private Collection<OrderStatus> statuses;
    @Nullable private Collection<OrderPriority> priorities;
    @Nullable private String dOB;
    private boolean critical;
    @Nullable private Collection<String> reporters;
    @Nullable private Date reportStartDate;
    @Nullable private Date reportEndDate;

    public HL7MessageQuery()
    {
        // empty
    }

    @JsonCreator
    public HL7MessageQuery(@Nullable String orderNumber,
                           @Nullable Date createdStartDate,
                           @Nullable Date createdEndDate,
                           @Nullable Date updatedStartDate,
                           @Nullable Date updatedEndDate,
                           @Nullable String firstName,
                           @Nullable String lastName,
                           @Nullable String mRN,
                           @Nullable String accession,
                           @Nullable String modality,
                           @Nullable String studyDescription,
                           @Nullable String cPTCode,
                           @Nullable Collection<String> institutions,
                           boolean exactSearch,
                           @Nullable Collection<OrderStatus> statuses,
                           @Nullable Collection<OrderPriority> priorities,
                           @Nullable String dOB,
                           boolean critical,
                           @Nullable Collection<String> reporters,
                           @Nullable Date reportStartDate,
                           @Nullable Date reportEndDate)
    {
        super();

        this.orderNumber = orderNumber;
        this.createdStartDate = createdStartDate;
        this.createdEndDate = createdEndDate;
        this.updatedStartDate = updatedStartDate;
        this.updatedEndDate = updatedEndDate;
        this.firstName = firstName;
        this.lastName = lastName;
        this.mRN = mRN;
        this.accession = accession;
        this.modality = modality;
        this.studyDescription = studyDescription;
        this.cPTCode = cPTCode;
        this.institutions = institutions;
        this.exactSearch = exactSearch;
        this.statuses = statuses;
        this.priorities = priorities;
        this.dOB = dOB;
        this.critical = critical;
        this.reporters = reporters;
        this.reportStartDate = reportStartDate;
        this.reportEndDate = reportEndDate;
    }

    @Nullable
    public String getOrderNumber()
    {
        return orderNumber;
    }

    @Nullable
    public Date getCreatedStartDate()
    {
        return createdStartDate;
    }

    @Nullable
    public Date getCreatedEndDate()
    {
        return createdEndDate;
    }

    @Nullable
    public Date getUpdatedStartDate()
    {
        return updatedStartDate;
    }

    @Nullable
    public Date getUpdatedEndDate()
    {
        return updatedEndDate;
    }

    @Nullable
    public String getFirstName()
    {
        return firstName;
    }

    @Nullable
    public String getLastName()
    {
        return lastName;
    }

    @Nullable
    public String getMRN()
    {
        return mRN;
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
    public String getStudyDescription()
    {
        return studyDescription;
    }

    @Nullable
    public String getCPTCode()
    {
        return cPTCode;
    }

    @Nullable
    public Collection<String> getInstitutions()
    {
        return institutions;
    }

    public boolean isExactSearch()
    {
        return exactSearch;
    }

    @Nullable
    public Collection<OrderStatus> getStatuses()
    {
        return statuses;
    }

    @Nullable
    public Collection<OrderPriority> getPriorities()
    {
        return priorities;
    }

    @Nullable
    public String getDOB()
    {
        return dOB;
    }

    public boolean isCritical()
    {
        return critical;
    }

    @Nullable
    public Collection<String> getReporters()
    {
        return reporters;
    }

    @Nullable
    public Date getReportStartDate()
    {
        return reportStartDate;
    }

    @Nullable
    public Date getReportEndDate()
    {
        return reportEndDate;
    }
    public void setOrderNumber(@Nullable String orderNumber)
    {
        this.orderNumber = orderNumber;
    }

    public void setCreatedStartDate(@Nullable Date createdStartDate)
    {
        this.createdStartDate = createdStartDate;
    }

    public void setCreatedEndDate(@Nullable Date createdEndDate)
    {
        this.createdEndDate = createdEndDate;
    }

    public void setUpdatedStartDate(@Nullable Date updatedStartDate)
    {
        this.updatedStartDate = updatedStartDate;
    }

    public void setUpdatedEndDate(@Nullable Date updatedEndDate)
    {
        this.updatedEndDate = updatedEndDate;
    }

    public void setFirstName(@Nullable String firstName)
    {
        this.firstName = firstName;
    }

    public void setLastName(@Nullable String lastName)
    {
        this.lastName = lastName;
    }

    public void setMRN(@Nullable String mRN)
    {
        this.mRN = mRN;
    }

    public void setAccession(@Nullable String accession)
    {
        this.accession = accession;
    }

    public void setModality(@Nullable String modality)
    {
        this.modality = modality;
    }

    public void setStudyDescription(@Nullable String studyDescription)
    {
        this.studyDescription = studyDescription;
    }

    public void setCPTCode(@Nullable String cPTCode)
    {
        this.cPTCode = cPTCode;
    }

    public void setInstitutions(@Nullable Collection<String> institutions)
    {
        this.institutions = institutions;
    }

    public void setExactSearch(boolean exactSearch)
    {
        this.exactSearch = exactSearch;
    }

    public void setStatuses(@Nullable Collection<OrderStatus> statuses)
    {
        this.statuses = statuses;
    }

    public void setPriorities(@Nullable Collection<OrderPriority> priorities)
    {
        this.priorities = priorities;
    }

    public void setDOB(@Nullable String dOB)
    {
        this.dOB = dOB;
    }

    public void setCritical(boolean critical)
    {
        this.critical = critical;
    }

    public void setReporters(@Nullable Collection<String> reporters)
    {
        this.reporters = reporters;
    }

    public void setReportStartDate(@Nullable Date reportStartDate)
    {
        this.reportStartDate = reportStartDate;
    }

    public void setReportEndDate(@Nullable Date reportEndDate)
    {
        this.reportEndDate = reportEndDate;
    }

    @NotNull
    public String toString()
    {
        return "HL7MessageQuery(" +
            " orderNumber: " + getOrderNumber() +
            " createdStartDate: " + getCreatedStartDate() +
            " createdEndDate: " + getCreatedEndDate() +
            " updatedStartDate: " + getUpdatedStartDate() +
            " updatedEndDate: " + getUpdatedEndDate() +
            " firstName: " + getFirstName() +
            " lastName: " + getLastName() +
            " mRN: " + getMRN() +
            " accession: " + getAccession() +
            " modality: " + getModality() +
            " studyDescription: " + getStudyDescription() +
            " cPTCode: " + getCPTCode() +
            " institutions: " + getInstitutions() +
            " exactSearch: " + isExactSearch() +
            " statuses: " + getStatuses() +
            " priorities: " + getPriorities() +
            " dOB: " + getDOB() +
            " critical: " + isCritical() +
            " reporters: " + getReporters() +
            " reportStartDate: " + getReportStartDate() +
            " reportEndDate: " + getReportEndDate() + ")";
    }


    @Override
    public boolean equals(@Nullable Object aObject)
    {
          if (this == aObject)
          {
              return true;
          }

          if (aObject == null || getClass() != aObject.getClass())
          {
              return false;
          }

          final HL7MessageQuery myObject = (HL7MessageQuery) aObject;

          return Objects.equals(getOrderNumber(), myObject.getOrderNumber()) && 
                 Objects.equals(getCreatedStartDate(), myObject.getCreatedStartDate()) && 
                 Objects.equals(getCreatedEndDate(), myObject.getCreatedEndDate()) && 
                 Objects.equals(getUpdatedStartDate(), myObject.getUpdatedStartDate()) && 
                 Objects.equals(getUpdatedEndDate(), myObject.getUpdatedEndDate()) && 
                 Objects.equals(getFirstName(), myObject.getFirstName()) && 
                 Objects.equals(getLastName(), myObject.getLastName()) && 
                 Objects.equals(getMRN(), myObject.getMRN()) && 
                 Objects.equals(getAccession(), myObject.getAccession()) && 
                 Objects.equals(getModality(), myObject.getModality()) && 
                 Objects.equals(getStudyDescription(), myObject.getStudyDescription()) && 
                 Objects.equals(getCPTCode(), myObject.getCPTCode()) && 
                 Objects.equals(getInstitutions(), myObject.getInstitutions()) && 
                 Objects.equals(isExactSearch(), myObject.isExactSearch()) && 
                 Objects.equals(getStatuses(), myObject.getStatuses()) && 
                 Objects.equals(getPriorities(), myObject.getPriorities()) && 
                 Objects.equals(getDOB(), myObject.getDOB()) && 
                 Objects.equals(isCritical(), myObject.isCritical()) && 
                 Objects.equals(getReporters(), myObject.getReporters()) && 
                 Objects.equals(getReportStartDate(), myObject.getReportStartDate()) && 
                 Objects.equals(getReportEndDate(), myObject.getReportEndDate());
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(
                            getOrderNumber(),
                            getCreatedStartDate(),
                            getCreatedEndDate(),
                            getUpdatedStartDate(),
                            getUpdatedEndDate(),
                            getFirstName(),
                            getLastName(),
                            getMRN(),
                            getAccession(),
                            getModality(),
                            getStudyDescription(),
                            getCPTCode(),
                            getInstitutions(),
                            isExactSearch(),
                            getStatuses(),
                            getPriorities(),
                            getDOB(),
                            isCritical(),
                            getReporters(),
                            getReportStartDate(),
                            getReportEndDate());
    }

    @NotNull
    public HL7MessageQueryBuilder toBuilder()
    {
        return new HL7MessageQueryBuilder().setOrderNumber(getOrderNumber())
                                           .setCreatedStartDate(getCreatedStartDate())
                                           .setCreatedEndDate(getCreatedEndDate())
                                           .setUpdatedStartDate(getUpdatedStartDate())
                                           .setUpdatedEndDate(getUpdatedEndDate())
                                           .setFirstName(getFirstName())
                                           .setLastName(getLastName())
                                           .setMRN(getMRN())
                                           .setAccession(getAccession())
                                           .setModality(getModality())
                                           .setStudyDescription(getStudyDescription())
                                           .setCPTCode(getCPTCode())
                                           .setInstitutions(getInstitutions())
                                           .setExactSearch(isExactSearch())
                                           .setStatuses(getStatuses())
                                           .setPriorities(getPriorities())
                                           .setDOB(getDOB())
                                           .setCritical(isCritical())
                                           .setReporters(getReporters())
                                           .setReportStartDate(getReportStartDate())
                                           .setReportEndDate(getReportEndDate());
    }
}