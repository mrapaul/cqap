package com.lakeland.ris.ui.datamodel;

import org.jetbrains.annotations.*;
import java.util.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;
import java.util.*;

public class HL7MessageQueryBuilder
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

    public HL7MessageQueryBuilder()
    {
        super();

    }


    @NotNull
    public HL7MessageQueryBuilder setOrderNumber(@Nullable String orderNumber)
    {
        this.orderNumber = orderNumber;

        return self();
    }

    @NotNull
    public HL7MessageQueryBuilder setCreatedStartDate(@Nullable Date createdStartDate)
    {
        this.createdStartDate = createdStartDate;

        return self();
    }

    @NotNull
    public HL7MessageQueryBuilder setCreatedEndDate(@Nullable Date createdEndDate)
    {
        this.createdEndDate = createdEndDate;

        return self();
    }

    @NotNull
    public HL7MessageQueryBuilder setUpdatedStartDate(@Nullable Date updatedStartDate)
    {
        this.updatedStartDate = updatedStartDate;

        return self();
    }

    @NotNull
    public HL7MessageQueryBuilder setUpdatedEndDate(@Nullable Date updatedEndDate)
    {
        this.updatedEndDate = updatedEndDate;

        return self();
    }

    @NotNull
    public HL7MessageQueryBuilder setFirstName(@Nullable String firstName)
    {
        this.firstName = firstName;

        return self();
    }

    @NotNull
    public HL7MessageQueryBuilder setLastName(@Nullable String lastName)
    {
        this.lastName = lastName;

        return self();
    }

    @NotNull
    public HL7MessageQueryBuilder setMRN(@Nullable String mRN)
    {
        this.mRN = mRN;

        return self();
    }

    @NotNull
    public HL7MessageQueryBuilder setAccession(@Nullable String accession)
    {
        this.accession = accession;

        return self();
    }

    @NotNull
    public HL7MessageQueryBuilder setModality(@Nullable String modality)
    {
        this.modality = modality;

        return self();
    }

    @NotNull
    public HL7MessageQueryBuilder setStudyDescription(@Nullable String studyDescription)
    {
        this.studyDescription = studyDescription;

        return self();
    }

    @NotNull
    public HL7MessageQueryBuilder setCPTCode(@Nullable String cPTCode)
    {
        this.cPTCode = cPTCode;

        return self();
    }

    @NotNull
    public HL7MessageQueryBuilder setInstitutions(@Nullable Collection<String> institutions)
    {
        this.institutions = institutions;

        return self();
    }

    @NotNull
    public HL7MessageQueryBuilder setExactSearch(boolean exactSearch)
    {
        this.exactSearch = exactSearch;

        return self();
    }

    @NotNull
    public HL7MessageQueryBuilder setStatuses(@Nullable Collection<OrderStatus> statuses)
    {
        this.statuses = statuses;

        return self();
    }

    @NotNull
    public HL7MessageQueryBuilder setPriorities(@Nullable Collection<OrderPriority> priorities)
    {
        this.priorities = priorities;

        return self();
    }

    @NotNull
    public HL7MessageQueryBuilder setDOB(@Nullable String dOB)
    {
        this.dOB = dOB;

        return self();
    }

    @NotNull
    public HL7MessageQueryBuilder setCritical(boolean critical)
    {
        this.critical = critical;

        return self();
    }

    @NotNull
    public HL7MessageQueryBuilder setReporters(@Nullable Collection<String> reporters)
    {
        this.reporters = reporters;

        return self();
    }

    @NotNull
    public HL7MessageQueryBuilder setReportStartDate(@Nullable Date reportStartDate)
    {
        this.reportStartDate = reportStartDate;

        return self();
    }

    @NotNull
    public HL7MessageQueryBuilder setReportEndDate(@Nullable Date reportEndDate)
    {
        this.reportEndDate = reportEndDate;

        return self();
    }

    @Nullable
    protected String getOrderNumber()
    {
        return orderNumber;
    }

    @Nullable
    protected Date getCreatedStartDate()
    {
        return createdStartDate;
    }

    @Nullable
    protected Date getCreatedEndDate()
    {
        return createdEndDate;
    }

    @Nullable
    protected Date getUpdatedStartDate()
    {
        return updatedStartDate;
    }

    @Nullable
    protected Date getUpdatedEndDate()
    {
        return updatedEndDate;
    }

    @Nullable
    protected String getFirstName()
    {
        return firstName;
    }

    @Nullable
    protected String getLastName()
    {
        return lastName;
    }

    @Nullable
    protected String getMRN()
    {
        return mRN;
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
    protected String getStudyDescription()
    {
        return studyDescription;
    }

    @Nullable
    protected String getCPTCode()
    {
        return cPTCode;
    }

    @Nullable
    protected Collection<String> getInstitutions()
    {
        return institutions;
    }

    protected boolean isExactSearch()
    {
        return exactSearch;
    }

    @Nullable
    protected Collection<OrderStatus> getStatuses()
    {
        return statuses;
    }

    @Nullable
    protected Collection<OrderPriority> getPriorities()
    {
        return priorities;
    }

    @Nullable
    protected String getDOB()
    {
        return dOB;
    }

    protected boolean isCritical()
    {
        return critical;
    }

    @Nullable
    protected Collection<String> getReporters()
    {
        return reporters;
    }

    @Nullable
    protected Date getReportStartDate()
    {
        return reportStartDate;
    }

    @Nullable
    protected Date getReportEndDate()
    {
        return reportEndDate;
    }

    @NotNull
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


    @NotNull
    protected HL7MessageQueryBuilder self()
    {
        return this;
    }
}