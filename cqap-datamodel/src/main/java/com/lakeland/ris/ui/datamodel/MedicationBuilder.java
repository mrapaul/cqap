package com.lakeland.ris.ui.datamodel;


import java.util.*;
import com.lakeland.ris.datamodel.*;


public class MedicationBuilder
{
     private String drugName;
     private String genericName;
     private String orderingPhysician;
     private String pharmacy;
     private String status;
     private Date lastRefillDate;
     private String daysSupply;
     private String refills;
     private String quantity;
     private String qualifier;
     private String substitution;
     private String pharmacyNotes;
     private String directions;
     private Date orderDate;
     private Date reconcileDate;

    public MedicationBuilder()
    {
        super();

    }


    
    public MedicationBuilder setDrugName( String drugName)
    {
        this.drugName = drugName;

        return self();
    }

    
    public MedicationBuilder setGenericName( String genericName)
    {
        this.genericName = genericName;

        return self();
    }

    
    public MedicationBuilder setOrderingPhysician( String orderingPhysician)
    {
        this.orderingPhysician = orderingPhysician;

        return self();
    }

    
    public MedicationBuilder setPharmacy( String pharmacy)
    {
        this.pharmacy = pharmacy;

        return self();
    }

    
    public MedicationBuilder setStatus( String status)
    {
        this.status = status;

        return self();
    }

    
    public MedicationBuilder setLastRefillDate( Date lastRefillDate)
    {
        this.lastRefillDate = lastRefillDate;

        return self();
    }

    
    public MedicationBuilder setDaysSupply( String daysSupply)
    {
        this.daysSupply = daysSupply;

        return self();
    }

    
    public MedicationBuilder setRefills( String refills)
    {
        this.refills = refills;

        return self();
    }

    
    public MedicationBuilder setQuantity( String quantity)
    {
        this.quantity = quantity;

        return self();
    }

    
    public MedicationBuilder setQualifier( String qualifier)
    {
        this.qualifier = qualifier;

        return self();
    }

    
    public MedicationBuilder setSubstitution( String substitution)
    {
        this.substitution = substitution;

        return self();
    }

    
    public MedicationBuilder setPharmacyNotes( String pharmacyNotes)
    {
        this.pharmacyNotes = pharmacyNotes;

        return self();
    }

    
    public MedicationBuilder setDirections( String directions)
    {
        this.directions = directions;

        return self();
    }

    
    public MedicationBuilder setOrderDate( Date orderDate)
    {
        this.orderDate = orderDate;

        return self();
    }

    
    public MedicationBuilder setReconcileDate( Date reconcileDate)
    {
        this.reconcileDate = reconcileDate;

        return self();
    }

    
    protected String getDrugName()
    {
        return drugName;
    }

    
    protected String getGenericName()
    {
        return genericName;
    }

    
    protected String getOrderingPhysician()
    {
        return orderingPhysician;
    }

    
    protected String getPharmacy()
    {
        return pharmacy;
    }

    
    protected String getStatus()
    {
        return status;
    }

    
    protected Date getLastRefillDate()
    {
        return lastRefillDate;
    }

    
    protected String getDaysSupply()
    {
        return daysSupply;
    }

    
    protected String getRefills()
    {
        return refills;
    }

    
    protected String getQuantity()
    {
        return quantity;
    }

    
    protected String getQualifier()
    {
        return qualifier;
    }

    
    protected String getSubstitution()
    {
        return substitution;
    }

    
    protected String getPharmacyNotes()
    {
        return pharmacyNotes;
    }

    
    protected String getDirections()
    {
        return directions;
    }

    
    protected Date getOrderDate()
    {
        return orderDate;
    }

    
    protected Date getReconcileDate()
    {
        return reconcileDate;
    }

    
    public Medication build()
    {
        return new Medication(getDrugName(),
                              getGenericName(),
                              getOrderingPhysician(),
                              getPharmacy(),
                              getStatus(),
                              getLastRefillDate(),
                              getDaysSupply(),
                              getRefills(),
                              getQuantity(),
                              getQualifier(),
                              getSubstitution(),
                              getPharmacyNotes(),
                              getDirections(),
                              getOrderDate(),
                              getReconcileDate());
    }


    
    protected MedicationBuilder self()
    {
        return this;
    }
}