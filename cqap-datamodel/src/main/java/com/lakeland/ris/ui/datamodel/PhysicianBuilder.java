package com.lakeland.ris.ui.datamodel;


import java.util.*;
import com.lakeland.ris.datamodel.*;


public class PhysicianBuilder
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

    public PhysicianBuilder()
    {
        super();

    }



    public PhysicianBuilder setName( String name)
    {
        this.name = name;

        return self();
    }


    public PhysicianBuilder setRole( String role)
    {
        this.role = role;

        return self();
    }


    public PhysicianBuilder setAddress( String address)
    {
        this.address = address;

        return self();
    }


    public PhysicianBuilder setCity( String city)
    {
        this.city = city;

        return self();
    }


    public PhysicianBuilder setState( String state)
    {
        this.state = state;

        return self();
    }


    public PhysicianBuilder setZipcode( String zipcode)
    {
        this.zipcode = zipcode;

        return self();
    }


    public PhysicianBuilder setPhone( String phone)
    {
        this.phone = phone;

        return self();
    }


    public PhysicianBuilder setFax( String fax)
    {
        this.fax = fax;

        return self();
    }


    public PhysicianBuilder setEmail( String email)
    {
        this.email = email;

        return self();
    }

    
    protected String getName()
    {
        return name;
    }

    
    protected String getRole()
    {
        return role;
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



    protected PhysicianBuilder self()
    {
        return this;
    }
}