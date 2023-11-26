package com.lakeland.ris.ui.datamodel;

import org.jetbrains.annotations.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;


public class PatientInsuranceBuilder
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

    public PatientInsuranceBuilder()
    {
        super();

    }


    @NotNull
    public PatientInsuranceBuilder setPlan(@Nullable String plan)
    {
        this.plan = plan;

        return self();
    }

    @NotNull
    public PatientInsuranceBuilder setCarrier(@Nullable String carrier)
    {
        this.carrier = carrier;

        return self();
    }

    @NotNull
    public PatientInsuranceBuilder setPolicyNumber(@Nullable String policyNumber)
    {
        this.policyNumber = policyNumber;

        return self();
    }

    @NotNull
    public PatientInsuranceBuilder setEffectiveDate(@Nullable Date effectiveDate)
    {
        this.effectiveDate = effectiveDate;

        return self();
    }

    @NotNull
    public PatientInsuranceBuilder setGroupNumber(@Nullable String groupNumber)
    {
        this.groupNumber = groupNumber;

        return self();
    }

    @NotNull
    public PatientInsuranceBuilder setAddress(@Nullable String address)
    {
        this.address = address;

        return self();
    }

    @NotNull
    public PatientInsuranceBuilder setCity(@Nullable String city)
    {
        this.city = city;

        return self();
    }

    @NotNull
    public PatientInsuranceBuilder setState(@Nullable String state)
    {
        this.state = state;

        return self();
    }

    @NotNull
    public PatientInsuranceBuilder setZipcode(@Nullable String zipcode)
    {
        this.zipcode = zipcode;

        return self();
    }

    @NotNull
    public PatientInsuranceBuilder setPhone(@Nullable String phone)
    {
        this.phone = phone;

        return self();
    }

    @NotNull
    public PatientInsuranceBuilder setFax(@Nullable String fax)
    {
        this.fax = fax;

        return self();
    }

    @NotNull
    public PatientInsuranceBuilder setEmail(@Nullable String email)
    {
        this.email = email;

        return self();
    }

    @Nullable
    protected String getPlan()
    {
        return plan;
    }

    @Nullable
    protected String getCarrier()
    {
        return carrier;
    }

    @Nullable
    protected String getPolicyNumber()
    {
        return policyNumber;
    }

    @Nullable
    protected Date getEffectiveDate()
    {
        return effectiveDate;
    }

    @Nullable
    protected String getGroupNumber()
    {
        return groupNumber;
    }

    @Nullable
    protected String getAddress()
    {
        return address;
    }

    @Nullable
    protected String getCity()
    {
        return city;
    }

    @Nullable
    protected String getState()
    {
        return state;
    }

    @Nullable
    protected String getZipcode()
    {
        return zipcode;
    }

    @Nullable
    protected String getPhone()
    {
        return phone;
    }

    @Nullable
    protected String getFax()
    {
        return fax;
    }

    @Nullable
    protected String getEmail()
    {
        return email;
    }

    @NotNull
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


    @NotNull
    protected PatientInsuranceBuilder self()
    {
        return this;
    }
}