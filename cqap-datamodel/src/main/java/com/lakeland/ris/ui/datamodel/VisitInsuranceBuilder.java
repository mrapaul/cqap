package com.lakeland.ris.ui.datamodel;


import java.util.*;
import com.lakeland.ris.datamodel.*;


public class VisitInsuranceBuilder
{
     private String plan;
     private String policyNumber;
     private String groupNumber;
     private String authorizationNumber;
     private String effectiveDate;
     private String preCertificationNumber;
     private String address;
     private String city;
     private String state;
     private String zipcode;
     private String phone;
     private String fax;
     private String email;

    public VisitInsuranceBuilder()
    {
        super();

    }



    public VisitInsuranceBuilder setPlan( String plan)
    {
        this.plan = plan;

        return self();
    }


    public VisitInsuranceBuilder setPolicyNumber( String policyNumber)
    {
        this.policyNumber = policyNumber;

        return self();
    }


    public VisitInsuranceBuilder setGroupNumber( String groupNumber)
    {
        this.groupNumber = groupNumber;

        return self();
    }


    public VisitInsuranceBuilder setAuthorizationNumber( String authorizationNumber)
    {
        this.authorizationNumber = authorizationNumber;

        return self();
    }


    public VisitInsuranceBuilder setEffectiveDate( String effectiveDate)
    {
        this.effectiveDate = effectiveDate;

        return self();
    }


    public VisitInsuranceBuilder setPreCertificationNumber( String preCertificationNumber)
    {
        this.preCertificationNumber = preCertificationNumber;

        return self();
    }


    public VisitInsuranceBuilder setAddress( String address)
    {
        this.address = address;

        return self();
    }


    public VisitInsuranceBuilder setCity( String city)
    {
        this.city = city;

        return self();
    }


    public VisitInsuranceBuilder setState( String state)
    {
        this.state = state;

        return self();
    }


    public VisitInsuranceBuilder setZipcode( String zipcode)
    {
        this.zipcode = zipcode;

        return self();
    }


    public VisitInsuranceBuilder setPhone( String phone)
    {
        this.phone = phone;

        return self();
    }


    public VisitInsuranceBuilder setFax( String fax)
    {
        this.fax = fax;

        return self();
    }


    public VisitInsuranceBuilder setEmail( String email)
    {
        this.email = email;

        return self();
    }

    
    protected String getPlan()
    {
        return plan;
    }

    
    protected String getPolicyNumber()
    {
        return policyNumber;
    }

    
    protected String getGroupNumber()
    {
        return groupNumber;
    }

    
    protected String getAuthorizationNumber()
    {
        return authorizationNumber;
    }

    
    protected String getEffectiveDate()
    {
        return effectiveDate;
    }

    
    protected String getPreCertificationNumber()
    {
        return preCertificationNumber;
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


    public VisitInsurance build()
    {
        return new VisitInsurance(getPlan(),
                                  getPolicyNumber(),
                                  getGroupNumber(),
                                  getAuthorizationNumber(),
                                  getEffectiveDate(),
                                  getPreCertificationNumber(),
                                  getAddress(),
                                  getCity(),
                                  getState(),
                                  getZipcode(),
                                  getPhone(),
                                  getFax(),
                                  getEmail());
    }



    protected VisitInsuranceBuilder self()
    {
        return this;
    }
}