package com.lakeland.ris.ui.datamodel;

import org.codehaus.jackson.annotate.*;

import java.util.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;
import java.util.*;

public class HL7MessageQuery
{
     private String orderNumber;
     private Date createdStartDate;
     private Date createdEndDate;
     private Date updatedStartDate;
     private Date updatedEndDate;
     private String firstName;
     private String lastName;
     private String mRN;
     private String accession;
     private String modality;
     private String studyDescription;
     private String cPTCode;
     private Collection<String> institutions;
    private boolean exactSearch;
     private Collection<OrderStatus> statuses;
     private Collection<OrderPriority> priorities;
     private String dOB;
    private boolean critical;
     private Collection<String> reporters;
     private Date reportStartDate;
     private Date reportEndDate;

    public HL7MessageQuery()
    {
        // empty
    }

    @JsonCreator
    public HL7MessageQuery( String orderNumber,
                            Date createdStartDate,
                            Date createdEndDate,
                            Date updatedStartDate,
                            Date updatedEndDate,
                            String firstName,
                            String lastName,
                            String mRN,
                            String accession,
                            String modality,
                            String studyDescription,
                            String cPTCode,
                            Collection<String> institutions,
                           boolean exactSearch,
                            Collection<OrderStatus> statuses,
                            Collection<OrderPriority> priorities,
                            String dOB,
                           boolean critical,
                            Collection<String> reporters,
                            Date reportStartDate,
                            Date reportEndDate)
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

    
    public String getOrderNumber()
    {
        return orderNumber;
    }

    
    public Date getCreatedStartDate()
    {
        return createdStartDate;
    }

    
    public Date getCreatedEndDate()
    {
        return createdEndDate;
    }

    
    public Date getUpdatedStartDate()
    {
        return updatedStartDate;
    }

    
    public Date getUpdatedEndDate()
    {
        return updatedEndDate;
    }

    
    public String getFirstName()
    {
        return firstName;
    }

    
    public String getLastName()
    {
        return lastName;
    }

    
    public String getMRN()
    {
        return mRN;
    }

    
    public String getAccession()
    {
        return accession;
    }

    
    public String getModality()
    {
        return modality;
    }

    
    public String getStudyDescription()
    {
        return studyDescription;
    }

    
    public String getCPTCode()
    {
        return cPTCode;
    }

    
    public Collection<String> getInstitutions()
    {
        return institutions;
    }

    public boolean isExactSearch()
    {
        return exactSearch;
    }

    
    public Collection<OrderStatus> getStatuses()
    {
        return statuses;
    }

    
    public Collection<OrderPriority> getPriorities()
    {
        return priorities;
    }

    
    public String getDOB()
    {
        return dOB;
    }

    public boolean isCritical()
    {
        return critical;
    }

    
    public Collection<String> getReporters()
    {
        return reporters;
    }

    
    public Date getReportStartDate()
    {
        return reportStartDate;
    }

    
    public Date getReportEndDate()
    {
        return reportEndDate;
    }
    public void setOrderNumber( String orderNumber)
    {
        this.orderNumber = orderNumber;
    }

    public void setCreatedStartDate( Date createdStartDate)
    {
        this.createdStartDate = createdStartDate;
    }

    public void setCreatedEndDate( Date createdEndDate)
    {
        this.createdEndDate = createdEndDate;
    }

    public void setUpdatedStartDate( Date updatedStartDate)
    {
        this.updatedStartDate = updatedStartDate;
    }

    public void setUpdatedEndDate( Date updatedEndDate)
    {
        this.updatedEndDate = updatedEndDate;
    }

    public void setFirstName( String firstName)
    {
        this.firstName = firstName;
    }

    public void setLastName( String lastName)
    {
        this.lastName = lastName;
    }

    public void setMRN( String mRN)
    {
        this.mRN = mRN;
    }

    public void setAccession( String accession)
    {
        this.accession = accession;
    }

    public void setModality( String modality)
    {
        this.modality = modality;
    }

    public void setStudyDescription( String studyDescription)
    {
        this.studyDescription = studyDescription;
    }

    public void setCPTCode( String cPTCode)
    {
        this.cPTCode = cPTCode;
    }

    public void setInstitutions( Collection<String> institutions)
    {
        this.institutions = institutions;
    }

    public void setExactSearch(boolean exactSearch)
    {
        this.exactSearch = exactSearch;
    }

    public void setStatuses( Collection<OrderStatus> statuses)
    {
        this.statuses = statuses;
    }

    public void setPriorities( Collection<OrderPriority> priorities)
    {
        this.priorities = priorities;
    }

    public void setDOB( String dOB)
    {
        this.dOB = dOB;
    }

    public void setCritical(boolean critical)
    {
        this.critical = critical;
    }

    public void setReporters( Collection<String> reporters)
    {
        this.reporters = reporters;
    }

    public void setReportStartDate( Date reportStartDate)
    {
        this.reportStartDate = reportStartDate;
    }

    public void setReportEndDate( Date reportEndDate)
    {
        this.reportEndDate = reportEndDate;
    }

    
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
    public boolean equals( Object aObject)
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