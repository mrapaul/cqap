package com.lakeland.ris.ui.datamodel;

import org.codehaus.jackson.annotate.*;

import java.util.*;
import com.lakeland.ris.datamodel.*;


public class VisitInsurance
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

    public VisitInsurance()
    {
        // empty
    }

    @JsonCreator
    public VisitInsurance( String plan,
                           String policyNumber,
                           String groupNumber,
                           String authorizationNumber,
                           String effectiveDate,
                           String preCertificationNumber,
                           String address,
                           String city,
                           String state,
                           String zipcode,
                           String phone,
                           String fax,
                           String email)
    {
        super();

        this.plan = plan;
        this.policyNumber = policyNumber;
        this.groupNumber = groupNumber;
        this.authorizationNumber = authorizationNumber;
        this.effectiveDate = effectiveDate;
        this.preCertificationNumber = preCertificationNumber;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
        this.phone = phone;
        this.fax = fax;
        this.email = email;
    }

    
    public String getPlan()
    {
        return plan;
    }

    
    public String getPolicyNumber()
    {
        return policyNumber;
    }

    
    public String getGroupNumber()
    {
        return groupNumber;
    }

    
    public String getAuthorizationNumber()
    {
        return authorizationNumber;
    }

    
    public String getEffectiveDate()
    {
        return effectiveDate;
    }

    
    public String getPreCertificationNumber()
    {
        return preCertificationNumber;
    }

    
    public String getAddress()
    {
        return address;
    }

    
    public String getCity()
    {
        return city;
    }

    
    public String getState()
    {
        return state;
    }

    
    public String getZipcode()
    {
        return zipcode;
    }

    
    public String getPhone()
    {
        return phone;
    }

    
    public String getFax()
    {
        return fax;
    }

    
    public String getEmail()
    {
        return email;
    }
    public void setPlan( String plan)
    {
        this.plan = plan;
    }

    public void setPolicyNumber( String policyNumber)
    {
        this.policyNumber = policyNumber;
    }

    public void setGroupNumber( String groupNumber)
    {
        this.groupNumber = groupNumber;
    }

    public void setAuthorizationNumber( String authorizationNumber)
    {
        this.authorizationNumber = authorizationNumber;
    }

    public void setEffectiveDate( String effectiveDate)
    {
        this.effectiveDate = effectiveDate;
    }

    public void setPreCertificationNumber( String preCertificationNumber)
    {
        this.preCertificationNumber = preCertificationNumber;
    }

    public void setAddress( String address)
    {
        this.address = address;
    }

    public void setCity( String city)
    {
        this.city = city;
    }

    public void setState( String state)
    {
        this.state = state;
    }

    public void setZipcode( String zipcode)
    {
        this.zipcode = zipcode;
    }

    public void setPhone( String phone)
    {
        this.phone = phone;
    }

    public void setFax( String fax)
    {
        this.fax = fax;
    }

    public void setEmail( String email)
    {
        this.email = email;
    }


    public String toString()
    {
        return "VisitInsurance(" +
            " plan: " + getPlan() +
            " policyNumber: " + getPolicyNumber() +
            " groupNumber: " + getGroupNumber() +
            " authorizationNumber: " + getAuthorizationNumber() +
            " effectiveDate: " + getEffectiveDate() +
            " preCertificationNumber: " + getPreCertificationNumber() +
            " address: " + getAddress() +
            " city: " + getCity() +
            " state: " + getState() +
            " zipcode: " + getZipcode() +
            " phone: " + getPhone() +
            " fax: " + getFax() +
            " email: " + getEmail() + ")";
    }


    public VisitInsuranceBuilder toBuilder()
    {
        return new VisitInsuranceBuilder().setPlan(getPlan())
                                          .setPolicyNumber(getPolicyNumber())
                                          .setGroupNumber(getGroupNumber())
                                          .setAuthorizationNumber(getAuthorizationNumber())
                                          .setEffectiveDate(getEffectiveDate())
                                          .setPreCertificationNumber(getPreCertificationNumber())
                                          .setAddress(getAddress())
                                          .setCity(getCity())
                                          .setState(getState())
                                          .setZipcode(getZipcode())
                                          .setPhone(getPhone())
                                          .setFax(getFax())
                                          .setEmail(getEmail());
    }
}