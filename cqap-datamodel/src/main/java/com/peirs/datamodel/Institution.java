package com.peirs.datamodel;

import com.lakeland.ris.datamodel.*;
import org.springframework.data.annotation.*;
import org.springframework.data.mongodb.core.mapping.*;

import java.util.*;

@Document(collection = "Institutions")
public class Institution
{
    @Id private String theId;
    private String theName;
    private String theAlias;
    private String theCode;
    @DBRef private Group theGroup;
    private Address theAddress;
    private String theBillingContactName;
    private Phone theBillingPhone;
    private Phone theBillingFax;
    private Email theBillingEmail;
    private String theWebsite;
    private String theNotes;
    private Contract theContract;
    private String theUserPassword;
    private String theOwnerPassword;
    private HL7OutgoingConfiguration theOutgoingReportConfiguration;
    private Set<String> theRadiologists;
    private boolean theDicomOnly;
    private Phone theEmergencyDeptPhone;
    private Phone theRadiologyDeptPhone;
    private boolean theAutoFax;
    private Set<OrderPriority> theAutoFaxPriorities;

    public String getId()
    {
        return theId;
    }

    public void setId(String aId)
    {
        theId = aId;
    }

    public String getName()
    {
        return theName;
    }

    public void setName(String aName)
    {
        theName = aName;
    }

    public String getAlias()
    {
        return theAlias;
    }

    public void setAlias(String aAlias)
    {
        theAlias = aAlias;
    }

    public Group getGroup()
    {
        return theGroup;
    }

    public void setGroup(Group aGroup)
    {
        theGroup = aGroup;
    }

    public Address getAddress()
    {
        return theAddress;
    }

    public void setAddress(Address aAddress)
    {
        theAddress = aAddress;
    }

    public String getCode()
    {
        return theCode;
    }

    public void setCode(String aCode)
    {
        theCode = aCode;
    }

    public String getBillingContactName()
    {
        return theBillingContactName;
    }

    public void setBillingContactName(String aBillingContactName)
    {
        theBillingContactName = aBillingContactName;
    }

    public Phone getBillingPhone()
    {
        return theBillingPhone;
    }

    public void setBillingPhone(Phone aBillingPhone)
    {
        theBillingPhone = aBillingPhone;
    }

    public Phone getBillingFax()
    {
        return theBillingFax;
    }

    public void setBillingFax(Phone aBillingFax)
    {
        theBillingFax = aBillingFax;
    }

    public Email getBillingEmail()
    {
        return theBillingEmail;
    }

    public void setBillingEmail(Email aBillingEmail)
    {
        theBillingEmail = aBillingEmail;
    }

    public String getWebsite()
    {
        return theWebsite;
    }

    public void setWebsite(String aWebsite)
    {
        theWebsite = aWebsite;
    }

    public String getNotes()
    {
        return theNotes;
    }

    public void setNotes(String aNotes)
    {
        theNotes = aNotes;
    }

    public Contract getContract()
    {
        return theContract;
    }

    public void setContract(Contract aContract)
    {
        theContract = aContract;
    }

    public String getUserPassword()
    {
        return theUserPassword;
    }

    public void setUserPassword(String aUserPassword)
    {
        theUserPassword = aUserPassword;
    }

    public String getOwnerPassword()
    {
        return theOwnerPassword;
    }

    public void setOwnerPassword(String aOwnerPassword)
    {
        theOwnerPassword = aOwnerPassword;
    }

    public HL7OutgoingConfiguration getOutgoingReportConfiguration()
    {
        return theOutgoingReportConfiguration;
    }

    public void setOutgoingReportConfiguration(HL7OutgoingConfiguration aOutgoingReportConfiguration)
    {
        theOutgoingReportConfiguration = aOutgoingReportConfiguration;
    }

    public Set<String> getRadiologists()
    {
        return theRadiologists;
    }

    public void setRadiologists(Set<String> aRadiologists)
    {
        theRadiologists = aRadiologists;
    }

    public boolean isDicomOnly()
    {
        return theDicomOnly;
    }

    public void setDicomOnly(boolean aDicomOnly)
    {
        this.theDicomOnly = aDicomOnly;
    }

    public Phone getEmergencyDeptPhone()
    {
        return theEmergencyDeptPhone;
    }

    public void setEmergencyDeptPhone(Phone aEmergencyDeptPhone)
    {
        this.theEmergencyDeptPhone = aEmergencyDeptPhone;
    }

    public Phone getRadiologyDeptPhone()
    {
        return theRadiologyDeptPhone;
    }

    public void setRadiologyDeptPhone(Phone aRadiologyDeptPhone)
    {
        this.theRadiologyDeptPhone = aRadiologyDeptPhone;
    }

    public boolean isAutoFax()
    {
        return theAutoFax;
    }

    public void setAutoFax(boolean aAutoFax)
    {
        this.theAutoFax = aAutoFax;
    }

    public Set<OrderPriority> getAutoFaxPriorities()
    {
        return theAutoFaxPriorities;
    }

    public void setAutoFaxPriorities(Set<OrderPriority> aAutoFaxPriorities)
    {
        this.theAutoFaxPriorities = aAutoFaxPriorities;
    }

    @Override
    public String toString()
    {
        return getName();
    }
}
