package com.peirs.datamodel;


import org.springframework.data.annotation.*;
import org.springframework.data.mongodb.core.mapping.*;

@Document(collection = "Groups")
public class Group
{
    @Id private String theId;
    private String theName;
    private String theSegment;
    private Address thePrimaryAddress;
    private String thePrimaryContactName;
    private Phone thePrimaryPhone;
    private Phone thePrimaryFax;
    private Email thePrimaryEmail;
    private Address theBillingAddress;
    private String theBillingContactName;
    private Phone theBillingPhone;
    private Phone theBillingFax;
    private Email theBillingEmail;
    private String theWebsite;
    private String theNotes;
    private Contract theContract;

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

    public String getSegment()
    {
        return theSegment;
    }

    public void setSegment(String aSegment)
    {
        theSegment = aSegment;
    }

    public Address getPrimaryAddress()
    {
        return thePrimaryAddress;
    }

    public void setPrimaryAddress(Address aPrimaryAddress)
    {
        thePrimaryAddress = aPrimaryAddress;
    }

    public String getPrimaryContactName()
    {
        return thePrimaryContactName;
    }

    public void setPrimaryContactName(String aPrimaryContactName)
    {
        thePrimaryContactName = aPrimaryContactName;
    }

    public Phone getPrimaryPhone()
    {
        return thePrimaryPhone;
    }

    public void setPrimaryPhone(Phone aPrimaryPhone)
    {
        thePrimaryPhone = aPrimaryPhone;
    }

    public Phone getPrimaryFax()
    {
        return thePrimaryFax;
    }

    public void setPrimaryFax(Phone aPrimaryFax)
    {
        thePrimaryFax = aPrimaryFax;
    }

    public Email getPrimaryEmail()
    {
        return thePrimaryEmail;
    }

    public void setPrimaryEmail(Email aPrimaryEmail)
    {
        thePrimaryEmail = aPrimaryEmail;
    }

    public Address getBillingAddress()
    {
        return theBillingAddress;
    }

    public void setBillingAddress(Address aBillingAddress)
    {
        theBillingAddress = aBillingAddress;
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

    @Override
    public String toString()
    {
        return getName();
    }
}
