package com.lakeland.ris.ui.datamodel;

import org.codehaus.jackson.annotate.*;

import java.util.*;
import com.lakeland.ris.datamodel.*;


public class Physician
{
     private String name;
     private String role;
     private String address;
     private String city;
     private String state;
     private String zipcode;
     private String phone;
     private String fax;
     private String email;

    public Physician()
    {
        // empty
    }

    @JsonCreator
    public Physician( String name,
                      String role,
                      String address,
                      String city,
                      String state,
                      String zipcode,
                      String phone,
                      String fax,
                      String email)
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

    
    public String getName()
    {
        return name;
    }

    
    public String getRole()
    {
        return role;
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
    public void setName( String name)
    {
        this.name = name;
    }

    public void setRole( String role)
    {
        this.role = role;
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