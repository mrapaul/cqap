package com.lakeland.ris.ui.datamodel;

import org.codehaus.jackson.annotate.*;
import org.jetbrains.annotations.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;


public class Physician
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

    public Physician()
    {
        // empty
    }

    @JsonCreator
    public Physician(@Nullable String name,
                     @Nullable String role,
                     @Nullable String address,
                     @Nullable String city,
                     @Nullable String state,
                     @Nullable String zipcode,
                     @Nullable String phone,
                     @Nullable String fax,
                     @Nullable String email)
    {
        super();

        this.name = name;
        this.role = role;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
        this.phone = phone;
        this.fax = fax;
        this.email = email;
    }

    @Nullable
    public String getName()
    {
        return name;
    }

    @Nullable
    public String getRole()
    {
        return role;
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
    public void setName(@Nullable String name)
    {
        this.name = name;
    }

    public void setRole(@Nullable String role)
    {
        this.role = role;
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
        return "Physician(" +
            " name: " + getName() +
            " role: " + getRole() +
            " address: " + getAddress() +
            " city: " + getCity() +
            " state: " + getState() +
            " zipcode: " + getZipcode() +
            " phone: " + getPhone() +
            " fax: " + getFax() +
            " email: " + getEmail() + ")";
    }

    @NotNull
    public PhysicianBuilder toBuilder()
    {
        return new PhysicianBuilder().setName(getName())
                                     .setRole(getRole())
                                     .setAddress(getAddress())
                                     .setCity(getCity())
                                     .setState(getState())
                                     .setZipcode(getZipcode())
                                     .setPhone(getPhone())
                                     .setFax(getFax())
                                     .setEmail(getEmail());
    }
}