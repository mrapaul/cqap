package com.lakeland.ris.ui.datamodel;

import org.codehaus.jackson.annotate.*;

import java.util.*;
import com.lakeland.ris.datamodel.*;


public class PatientInsurance
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

    public PatientInsurance()
    {
        // empty
    }

    @JsonCreator
    public PatientInsurance( String plan,
                             String carrier,
                             String policyNumber,
                             Date effectiveDate,
                             String groupNumber,
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
        this.carrier = carrier;
        this.policyNumber = policyNumber;
        this.effectiveDate = effectiveDate;
        this.groupNumber = groupNumber;
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

    
    public String getCarrier()
    {
        return carrier;
    }

    
    public String getPolicyNumber()
    {
        return policyNumber;
    }

    
    public Date getEffectiveDate()
    {
        return effectiveDate;
    }

    
    public String getGroupNumber()
    {
        return groupNumber;
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

    public void setCarrier( String carrier)
    {
        this.carrier = carrier;
    }

    public void setPolicyNumber( String policyNumber)
    {
        this.policyNumber = policyNumber;
    }

    public void setEffectiveDate( Date effectiveDate)
    {
        this.effectiveDate = effectiveDate;
    }

    public void setGroupNumber( String groupNumber)
    {
        this.groupNumber = groupNumber;
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
        return "PatientInsurance(" +
            " plan: " + getPlan() +
            " carrier: " + getCarrier() +
            " policyNumber: " + getPolicyNumber() +
            " effectiveDate: " + getEffectiveDate() +
            " groupNumber: " + getGroupNumber() +
            " address: " + getAddress() +
            " city: " + getCity() +
            " state: " + getState() +
            " zipcode: " + getZipcode() +
            " phone: " + getPhone() +
            " fax: " + getFax() +
            " email: " + getEmail() + ")";
    }


    public PatientInsuranceBuilder toBuilder()
    {
        return new PatientInsuranceBuilder().setPlan(getPlan())
                                            .setCarrier(getCarrier())
                                            .setPolicyNumber(getPolicyNumber())
                                            .setEffectiveDate(getEffectiveDate())
                                            .setGroupNumber(getGroupNumber())
                                            .setAddress(getAddress())
                                            .setCity(getCity())
                                            .setState(getState())
                                            .setZipcode(getZipcode())
                                            .setPhone(getPhone())
                                            .setFax(getFax())
                                            .setEmail(getEmail());
    }
}