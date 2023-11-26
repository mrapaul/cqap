package com.lakeland.ris.ui.datamodel;

import org.codehaus.jackson.annotate.*;
import org.jetbrains.annotations.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;


public class VisitInsurance
{
    @Nullable private String plan;
    @Nullable private String policyNumber;
    @Nullable private String groupNumber;
    @Nullable private String authorizationNumber;
    @Nullable private String effectiveDate;
    @Nullable private String preCertificationNumber;
    @Nullable private String address;
    @Nullable private String city;
    @Nullable private String state;
    @Nullable private String zipcode;
    @Nullable private String phone;
    @Nullable private String fax;
    @Nullable private String email;

    public VisitInsurance()
    {
        // empty
    }

    @JsonCreator
    public VisitInsurance(@Nullable String plan,
                          @Nullable String policyNumber,
                          @Nullable String groupNumber,
                          @Nullable String authorizationNumber,
                          @Nullable String effectiveDate,
                          @Nullable String preCertificationNumber,
                          @Nullable String address,
                          @Nullable String city,
                          @Nullable String state,
                          @Nullable String zipcode,
                          @Nullable String phone,
                          @Nullable String fax,
                          @Nullable String email)
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

    @Nullable
    public String getPlan()
    {
        return plan;
    }

    @Nullable
    public String getPolicyNumber()
    {
        return policyNumber;
    }

    @Nullable
    public String getGroupNumber()
    {
        return groupNumber;
    }

    @Nullable
    public String getAuthorizationNumber()
    {
        return authorizationNumber;
    }

    @Nullable
    public String getEffectiveDate()
    {
        return effectiveDate;
    }

    @Nullable
    public String getPreCertificationNumber()
    {
        return preCertificationNumber;
    }

    @Nullable
    public String getAddress()
    {
        return address;
    }

    @Nullable
    public String getCity()
    {
        return city;
    }

    @Nullable
    public String getState()
    {
        return state;
    }

    @Nullable
    public String getZipcode()
    {
        return zipcode;
    }

    @Nullable
    public String getPhone()
    {
        return phone;
    }

    @Nullable
    public String getFax()
    {
        return fax;
    }

    @Nullable
    public String getEmail()
    {
        return email;
    }
    public void setPlan(@Nullable String plan)
    {
        this.plan = plan;
    }

    public void setPolicyNumber(@Nullable String policyNumber)
    {
        this.policyNumber = policyNumber;
    }

    public void setGroupNumber(@Nullable String groupNumber)
    {
        this.groupNumber = groupNumber;
    }

    public void setAuthorizationNumber(@Nullable String authorizationNumber)
    {
        this.authorizationNumber = authorizationNumber;
    }

    public void setEffectiveDate(@Nullable String effectiveDate)
    {
        this.effectiveDate = effectiveDate;
    }

    public void setPreCertificationNumber(@Nullable String preCertificationNumber)
    {
        this.preCertificationNumber = preCertificationNumber;
    }

    public void setAddress(@Nullable String address)
    {
        this.address = address;
    }

    public void setCity(@Nullable String city)
    {
        this.city = city;
    }

    public void setState(@Nullable String state)
    {
        this.state = state;
    }

    public void setZipcode(@Nullable String zipcode)
    {
        this.zipcode = zipcode;
    }

    public void setPhone(@Nullable String phone)
    {
        this.phone = phone;
    }

    public void setFax(@Nullable String fax)
    {
        this.fax = fax;
    }

    public void setEmail(@Nullable String email)
    {
        this.email = email;
    }

    @NotNull
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

    @NotNull
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