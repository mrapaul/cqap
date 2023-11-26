package com.lakeland.ris.ui.datamodel;

import org.jetbrains.annotations.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;


public class VisitInsuranceBuilder
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

    public VisitInsuranceBuilder()
    {
        super();

    }


    @NotNull
    public VisitInsuranceBuilder setPlan(@Nullable String plan)
    {
        this.plan = plan;

        return self();
    }

    @NotNull
    public VisitInsuranceBuilder setPolicyNumber(@Nullable String policyNumber)
    {
        this.policyNumber = policyNumber;

        return self();
    }

    @NotNull
    public VisitInsuranceBuilder setGroupNumber(@Nullable String groupNumber)
    {
        this.groupNumber = groupNumber;

        return self();
    }

    @NotNull
    public VisitInsuranceBuilder setAuthorizationNumber(@Nullable String authorizationNumber)
    {
        this.authorizationNumber = authorizationNumber;

        return self();
    }

    @NotNull
    public VisitInsuranceBuilder setEffectiveDate(@Nullable String effectiveDate)
    {
        this.effectiveDate = effectiveDate;

        return self();
    }

    @NotNull
    public VisitInsuranceBuilder setPreCertificationNumber(@Nullable String preCertificationNumber)
    {
        this.preCertificationNumber = preCertificationNumber;

        return self();
    }

    @NotNull
    public VisitInsuranceBuilder setAddress(@Nullable String address)
    {
        this.address = address;

        return self();
    }

    @NotNull
    public VisitInsuranceBuilder setCity(@Nullable String city)
    {
        this.city = city;

        return self();
    }

    @NotNull
    public VisitInsuranceBuilder setState(@Nullable String state)
    {
        this.state = state;

        return self();
    }

    @NotNull
    public VisitInsuranceBuilder setZipcode(@Nullable String zipcode)
    {
        this.zipcode = zipcode;

        return self();
    }

    @NotNull
    public VisitInsuranceBuilder setPhone(@Nullable String phone)
    {
        this.phone = phone;

        return self();
    }

    @NotNull
    public VisitInsuranceBuilder setFax(@Nullable String fax)
    {
        this.fax = fax;

        return self();
    }

    @NotNull
    public VisitInsuranceBuilder setEmail(@Nullable String email)
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
    protected String getPolicyNumber()
    {
        return policyNumber;
    }

    @Nullable
    protected String getGroupNumber()
    {
        return groupNumber;
    }

    @Nullable
    protected String getAuthorizationNumber()
    {
        return authorizationNumber;
    }

    @Nullable
    protected String getEffectiveDate()
    {
        return effectiveDate;
    }

    @Nullable
    protected String getPreCertificationNumber()
    {
        return preCertificationNumber;
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


    @NotNull
    protected VisitInsuranceBuilder self()
    {
        return this;
    }
}