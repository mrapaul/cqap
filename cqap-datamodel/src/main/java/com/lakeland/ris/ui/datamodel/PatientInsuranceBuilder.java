package com.lakeland.ris.ui.datamodel;


import java.util.*;
import com.lakeland.ris.datamodel.*;


public class PatientInsuranceBuilder
{
     private String plan;
     private String carrier;
     private String policyNumber;
     private Date effectiveDate;
     private String groupNumber;
     private String address;
     private String city;
     private String state;
     private String zipcode;
     private String phone;
     private String fax;
     private String email;

    public PatientInsuranceBuilder()
    {
        super();

    }


    
    public PatientInsuranceBuilder setPlan( String plan)
    {
        this.plan = plan;

        return self();
    }

    
    public PatientInsuranceBuilder setCarrier( String carrier)
    {
        this.carrier = carrier;

        return self();
    }

    
    public PatientInsuranceBuilder setPolicyNumber( String policyNumber)
    {
        this.policyNumber = policyNumber;

        return self();
    }

    
    public PatientInsuranceBuilder setEffectiveDate( Date effectiveDate)
    {
        this.effectiveDate = effectiveDate;

        return self();
    }

    
    public PatientInsuranceBuilder setGroupNumber( String groupNumber)
    {
        this.groupNumber = groupNumber;

        return self();
    }

    
    public PatientInsuranceBuilder setAddress( String address)
    {
        this.address = address;

        return self();
    }

    
    public PatientInsuranceBuilder setCity( String city)
    {
        this.city = city;

        return self();
    }

    
    public PatientInsuranceBuilder setState( String state)
    {
        this.state = state;

        return self();
    }

    
    public PatientInsuranceBuilder setZipcode( String zipcode)
    {
        this.zipcode = zipcode;

        return self();
    }

    
    public PatientInsuranceBuilder setPhone( String phone)
    {
        this.phone = phone;

        return self();
    }

    
    public PatientInsuranceBuilder setFax( String fax)
    {
        this.fax = fax;

        return self();
    }

    
    public PatientInsuranceBuilder setEmail( String email)
    {
        this.email = email;

        return self();
    }

    
    protected String getPlan()
    {
        return plan;
    }

    
    protected String getCarrier()
    {
        return carrier;
    }

    
    protected String getPolicyNumber()
    {
        return policyNumber;
    }

    
    protected Date getEffectiveDate()
    {
        return effectiveDate;
    }

    
    protected String getGroupNumber()
    {
        return groupNumber;
    }

    
    protected String getAddress()
    {
        return address;
    }

    
    protected String getCity()
    {
        return city;
    }

    
    protected String getState()
    {
        return state;
    }

    
    protected String getZipcode()
    {
        return zipcode;
    }

    
    protected String getPhone()
    {
        return phone;
    }

    
    protected String getFax()
    {
        return fax;
    }

    
    protected String getEmail()
    {
        return email;
    }

    
    public PatientInsurance build()
    {
        return new PatientInsurance(getPlan(),
                                    getCarrier(),
                                    getPolicyNumber(),
                                    getEffectiveDate(),
                                    getGroupNumber(),
                                    getAddress(),
                                    getCity(),
                                    getState(),
                                    getZipcode(),
                                    getPhone(),
                                    getFax(),
                                    getEmail());
    }


    
    protected PatientInsuranceBuilder self()
    {
        return this;
    }
}