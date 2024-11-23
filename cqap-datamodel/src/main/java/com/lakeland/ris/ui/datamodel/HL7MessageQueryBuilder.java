package com.lakeland.ris.ui.datamodel;


import java.util.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;
import java.util.*;

public class HL7MessageQueryBuilder
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

    public HL7MessageQueryBuilder()
    {
        super();

    }


    
    public HL7MessageQueryBuilder setOrderNumber( String orderNumber)
    {
        this.orderNumber = orderNumber;

        return self();
    }

    
    public HL7MessageQueryBuilder setCreatedStartDate( Date createdStartDate)
    {
        this.createdStartDate = createdStartDate;

        return self();
    }

    
    public HL7MessageQueryBuilder setCreatedEndDate( Date createdEndDate)
    {
        this.createdEndDate = createdEndDate;

        return self();
    }

    
    public HL7MessageQueryBuilder setUpdatedStartDate( Date updatedStartDate)
    {
        this.updatedStartDate = updatedStartDate;

        return self();
    }

    
    public HL7MessageQueryBuilder setUpdatedEndDate( Date updatedEndDate)
    {
        this.updatedEndDate = updatedEndDate;

        return self();
    }

    
    public HL7MessageQueryBuilder setFirstName( String firstName)
    {
        this.firstName = firstName;

        return self();
    }

    
    public HL7MessageQueryBuilder setLastName( String lastName)
    {
        this.lastName = lastName;

        return self();
    }

    
    public HL7MessageQueryBuilder setMRN( String mRN)
    {
        this.mRN = mRN;

        return self();
    }

    
    public HL7MessageQueryBuilder setAccession( String accession)
    {
        this.accession = accession;

        return self();
    }

    
    public HL7MessageQueryBuilder setModality( String modality)
    {
        this.modality = modality;

        return self();
    }

    
    public HL7MessageQueryBuilder setStudyDescription( String studyDescription)
    {
        this.studyDescription = studyDescription;

        return self();
    }

    
    public HL7MessageQueryBuilder setCPTCode( String cPTCode)
    {
        this.cPTCode = cPTCode;

        return self();
    }

    
    public HL7MessageQueryBuilder setInstitutions( Collection<String> institutions)
    {
        this.institutions = institutions;

        return self();
    }

    
    public HL7MessageQueryBuilder setExactSearch(boolean exactSearch)
    {
        this.exactSearch = exactSearch;

        return self();
    }

    
    public HL7MessageQueryBuilder setStatuses( Collection<OrderStatus> statuses)
    {
        this.statuses = statuses;

        return self();
    }

    
    public HL7MessageQueryBuilder setPriorities( Collection<OrderPriority> priorities)
    {
        this.priorities = priorities;

        return self();
    }

    
    public HL7MessageQueryBuilder setDOB( String dOB)
    {
        this.dOB = dOB;

        return self();
    }

    
    public HL7MessageQueryBuilder setCritical(boolean critical)
    {
        this.critical = critical;

        return self();
    }

    
    public HL7MessageQueryBuilder setReporters( Collection<String> reporters)
    {
        this.reporters = reporters;

        return self();
    }

    
    public HL7MessageQueryBuilder setReportStartDate( Date reportStartDate)
    {
        this.reportStartDate = reportStartDate;

        return self();
    }

    
    public HL7MessageQueryBuilder setReportEndDate( Date reportEndDate)
    {
        this.reportEndDate = reportEndDate;

        return self();
    }

    
    protected String getOrderNumber()
    {
        return orderNumber;
    }

    
    protected Date getCreatedStartDate()
    {
        return createdStartDate;
    }

    
    protected Date getCreatedEndDate()
    {
        return createdEndDate;
    }

    
    protected Date getUpdatedStartDate()
    {
        return updatedStartDate;
    }

    
    protected Date getUpdatedEndDate()
    {
        return updatedEndDate;
    }

    
    protected String getFirstName()
    {
        return firstName;
    }

    
    protected String getLastName()
    {
        return lastName;
    }

    
    protected String getMRN()
    {
        return mRN;
    }

    
    protected String getAccession()
    {
        return accession;
    }

    
    protected String getModality()
    {
        return modality;
    }

    
    protected String getStudyDescription()
    {
        return studyDescription;
    }

    
    protected String getCPTCode()
    {
        return cPTCode;
    }

    
    protected Collection<String> getInstitutions()
    {
        return institutions;
    }

    protected boolean isExactSearch()
    {
        return exactSearch;
    }

    
    protected Collection<OrderStatus> getStatuses()
    {
        return statuses;
    }

    
    protected Collection<OrderPriority> getPriorities()
    {
        return priorities;
    }

    
    protected String getDOB()
    {
        return dOB;
    }

    protected boolean isCritical()
    {
        return critical;
    }

    
    protected Collection<String> getReporters()
    {
        return reporters;
    }

    
    protected Date getReportStartDate()
    {
        return reportStartDate;
    }

    
    protected Date getReportEndDate()
    {
        return reportEndDate;
    }

    
    public HL7MessageQuery build()
    {
        return new HL7MessageQuery(getOrderNumber(),
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


    
    protected HL7MessageQueryBuilder self()
    {
        return this;
    }
}