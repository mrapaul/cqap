package com.peirs.datamodel;

import org.springframework.data.annotation.*;
import org.springframework.data.mongodb.core.mapping.*;

@Document(collection = "Institutions")
public class Institution
{
    @Id private String theId;
    private String theName;
    private String theAlias;
    @DBRef private Group theGroup;
    private Address theAddress;
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
