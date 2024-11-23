package com.lakeland.ris.ui.datamodel;

import org.codehaus.jackson.annotate.*;

import java.util.*;
import com.lakeland.ris.datamodel.*;


public class Medication
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

    public Medication()
    {
        // empty
    }

    @JsonCreator
    public Medication( String drugName,
                       String genericName,
                       String orderingPhysician,
                       String pharmacy,
                       String status,
                       Date lastRefillDate,
                       String daysSupply,
                       String refills,
                       String quantity,
                       String qualifier,
                       String substitution,
                       String pharmacyNotes,
                       String directions,
                       Date orderDate,
                       Date reconcileDate)
    {
        super();

        this.drugName = drugName;
        this.genericName = genericName;
        this.orderingPhysician = orderingPhysician;
        this.pharmacy = pharmacy;
        this.status = status;
        this.lastRefillDate = lastRefillDate;
        this.daysSupply = daysSupply;
        this.refills = refills;
        this.quantity = quantity;
        this.qualifier = qualifier;
        this.substitution = substitution;
        this.pharmacyNotes = pharmacyNotes;
        this.directions = directions;
        this.orderDate = orderDate;
        this.reconcileDate = reconcileDate;
    }

    
    public String getDrugName()
    {
        return drugName;
    }

    
    public String getGenericName()
    {
        return genericName;
    }

    
    public String getOrderingPhysician()
    {
        return orderingPhysician;
    }

    
    public String getPharmacy()
    {
        return pharmacy;
    }

    
    public String getStatus()
    {
        return status;
    }

    
    public Date getLastRefillDate()
    {
        return lastRefillDate;
    }

    
    public String getDaysSupply()
    {
        return daysSupply;
    }

    
    public String getRefills()
    {
        return refills;
    }

    
    public String getQuantity()
    {
        return quantity;
    }

    
    public String getQualifier()
    {
        return qualifier;
    }

    
    public String getSubstitution()
    {
        return substitution;
    }

    
    public String getPharmacyNotes()
    {
        return pharmacyNotes;
    }

    
    public String getDirections()
    {
        return directions;
    }

    
    public Date getOrderDate()
    {
        return orderDate;
    }

    
    public Date getReconcileDate()
    {
        return reconcileDate;
    }
    public void setDrugName( String drugName)
    {
        this.drugName = drugName;
    }

    public void setGenericName( String genericName)
    {
        this.genericName = genericName;
    }

    public void setOrderingPhysician( String orderingPhysician)
    {
        this.orderingPhysician = orderingPhysician;
    }

    public void setPharmacy( String pharmacy)
    {
        this.pharmacy = pharmacy;
    }

    public void setStatus( String status)
    {
        this.status = status;
    }

    public void setLastRefillDate( Date lastRefillDate)
    {
        this.lastRefillDate = lastRefillDate;
    }

    public void setDaysSupply( String daysSupply)
    {
        this.daysSupply = daysSupply;
    }

    public void setRefills( String refills)
    {
        this.refills = refills;
    }

    public void setQuantity( String quantity)
    {
        this.quantity = quantity;
    }

    public void setQualifier( String qualifier)
    {
        this.qualifier = qualifier;
    }

    public void setSubstitution( String substitution)
    {
        this.substitution = substitution;
    }

    public void setPharmacyNotes( String pharmacyNotes)
    {
        this.pharmacyNotes = pharmacyNotes;
    }

    public void setDirections( String directions)
    {
        this.directions = directions;
    }

    public void setOrderDate( Date orderDate)
    {
        this.orderDate = orderDate;
    }

    public void setReconcileDate( Date reconcileDate)
    {
        this.reconcileDate = reconcileDate;
    }


    public String toString()
    {
        return "Medication(" +
            " drugName: " + getDrugName() +
            " genericName: " + getGenericName() +
            " orderingPhysician: " + getOrderingPhysician() +
            " pharmacy: " + getPharmacy() +
            " status: " + getStatus() +
            " lastRefillDate: " + getLastRefillDate() +
            " daysSupply: " + getDaysSupply() +
            " refills: " + getRefills() +
            " quantity: " + getQuantity() +
            " qualifier: " + getQualifier() +
            " substitution: " + getSubstitution() +
            " pharmacyNotes: " + getPharmacyNotes() +
            " directions: " + getDirections() +
            " orderDate: " + getOrderDate() +
            " reconcileDate: " + getReconcileDate() + ")";
    }


    public MedicationBuilder toBuilder()
    {
        return new MedicationBuilder().setDrugName(getDrugName())
                                      .setGenericName(getGenericName())
                                      .setOrderingPhysician(getOrderingPhysician())
                                      .setPharmacy(getPharmacy())
                                      .setStatus(getStatus())
                                      .setLastRefillDate(getLastRefillDate())
                                      .setDaysSupply(getDaysSupply())
                                      .setRefills(getRefills())
                                      .setQuantity(getQuantity())
                                      .setQualifier(getQualifier())
                                      .setSubstitution(getSubstitution())
                                      .setPharmacyNotes(getPharmacyNotes())
                                      .setDirections(getDirections())
                                      .setOrderDate(getOrderDate())
                                      .setReconcileDate(getReconcileDate());
    }
}