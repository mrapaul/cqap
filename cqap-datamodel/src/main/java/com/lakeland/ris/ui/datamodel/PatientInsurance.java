package com.lakeland.ris.ui.datamodel;

import org.codehaus.jackson.annotate.*;
import org.jetbrains.annotations.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;


public class PatientInsurance
{
    @Nullable private String plan;
    @Nullable private String carrier;
    @Nullable private String policyNumber;
    @Nullable private Date effectiveDate;
    @Nullable private String groupNumber;
    @Nullable private String address;
    @Nullable private String city;
    @Nullable private String state;
    @Nullable private String zipcode;
    @Nullable private String phone;
    @Nullable private String fax;
    @Nullable private String email;

    public PatientInsurance()
    {
        // empty
    }

    @JsonCreator
    public PatientInsurance(@Nullable String plan,
                            @Nullable String carrier,
                            @Nullable String policyNumber,
                            @Nullable Date effectiveDate,
                            @Nullable String groupNumber,
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

    @Nullable
    public String getPlan()
    {
        return plan;
    }

    @Nullable
    public String getCarrier()
    {
        return carrier;
    }

    @Nullable
    public String getPolicyNumber()
    {
        return policyNumber;
    }

    @Nullable
    public Date getEffectiveDate()
    {
        return effectiveDate;
    }

    @Nullable
    public String getGroupNumber()
    {
        return groupNumber;
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

    public void setCarrier(@Nullable String carrier)
    {
        this.carrier = carrier;
    }

    public void setPolicyNumber(@Nullable String policyNumber)
    {
        this.policyNumber = policyNumber;
    }

    public void setEffectiveDate(@Nullable Date effectiveDate)
    {
        this.effectiveDate = effectiveDate;
    }

    public void setGroupNumber(@Nullable String groupNumber)
    {
        this.groupNumber = groupNumber;
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

    @NotNull
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