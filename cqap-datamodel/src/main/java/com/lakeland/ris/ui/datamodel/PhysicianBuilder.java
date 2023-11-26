package com.lakeland.ris.ui.datamodel;

import org.jetbrains.annotations.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;


public class PhysicianBuilder
{
    @Nullable private String name;
    @Nullable private String role;
    @Nullable private String address;
    @Nullable private String city;
    @Nullable private String state;
    @Nullable private String zipcode;
    @Nullable private String phone;
    @Nullable private String fax;
    @Nullable private String email;

    public PhysicianBuilder()
    {
        super();

    }


    @NotNull
    public PhysicianBuilder setName(@Nullable String name)
    {
        this.name = name;

        return self();
    }

    @NotNull
    public PhysicianBuilder setRole(@Nullable String role)
    {
        this.role = role;

        return self();
    }

    @NotNull
    public PhysicianBuilder setAddress(@Nullable String address)
    {
        this.address = address;

        return self();
    }

    @NotNull
    public PhysicianBuilder setCity(@Nullable String city)
    {
        this.city = city;

        return self();
    }

    @NotNull
    public PhysicianBuilder setState(@Nullable String state)
    {
        this.state = state;

        return self();
    }

    @NotNull
    public PhysicianBuilder setZipcode(@Nullable String zipcode)
    {
        this.zipcode = zipcode;

        return self();
    }

    @NotNull
    public PhysicianBuilder setPhone(@Nullable String phone)
    {
        this.phone = phone;

        return self();
    }

    @NotNull
    public PhysicianBuilder setFax(@Nullable String fax)
    {
        this.fax = fax;

        return self();
    }

    @NotNull
    public PhysicianBuilder setEmail(@Nullable String email)
    {
        this.email = email;

        return self();
    }

    @Nullable
    protected String getName()
    {
        return name;
    }

    @Nullable
    protected String getRole()
    {
        return role;
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
    public Physician build()
    {
        return new Physician(getName(),
                             getRole(),
                             getAddress(),
                             getCity(),
                             getState(),
                             getZipcode(),
                             getPhone(),
                             getFax(),
                             getEmail());
    }


    @NotNull
    protected PhysicianBuilder self()
    {
        return this;
    }
}