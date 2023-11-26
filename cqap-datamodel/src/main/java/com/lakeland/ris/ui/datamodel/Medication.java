package com.lakeland.ris.ui.datamodel;

import org.codehaus.jackson.annotate.*;
import org.jetbrains.annotations.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;


public class Medication
{
    @Nullable private String drugName;
    @Nullable private String genericName;
    @Nullable private String orderingPhysician;
    @Nullable private String pharmacy;
    @Nullable private String status;
    @Nullable private Date lastRefillDate;
    @Nullable private String daysSupply;
    @Nullable private String refills;
    @Nullable private String quantity;
    @Nullable private String qualifier;
    @Nullable private String substitution;
    @Nullable private String pharmacyNotes;
    @Nullable private String directions;
    @Nullable private Date orderDate;
    @Nullable private Date reconcileDate;

    public Medication()
    {
        // empty
    }

    @JsonCreator
    public Medication(@Nullable String drugName,
                      @Nullable String genericName,
                      @Nullable String orderingPhysician,
                      @Nullable String pharmacy,
                      @Nullable String status,
                      @Nullable Date lastRefillDate,
                      @Nullable String daysSupply,
                      @Nullable String refills,
                      @Nullable String quantity,
                      @Nullable String qualifier,
                      @Nullable String substitution,
                      @Nullable String pharmacyNotes,
                      @Nullable String directions,
                      @Nullable Date orderDate,
                      @Nullable Date reconcileDate)
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

    @Nullable
    public String getDrugName()
    {
        return drugName;
    }

    @Nullable
    public String getGenericName()
    {
        return genericName;
    }

    @Nullable
    public String getOrderingPhysician()
    {
        return orderingPhysician;
    }

    @Nullable
    public String getPharmacy()
    {
        return pharmacy;
    }

    @Nullable
    public String getStatus()
    {
        return status;
    }

    @Nullable
    public Date getLastRefillDate()
    {
        return lastRefillDate;
    }

    @Nullable
    public String getDaysSupply()
    {
        return daysSupply;
    }

    @Nullable
    public String getRefills()
    {
        return refills;
    }

    @Nullable
    public String getQuantity()
    {
        return quantity;
    }

    @Nullable
    public String getQualifier()
    {
        return qualifier;
    }

    @Nullable
    public String getSubstitution()
    {
        return substitution;
    }

    @Nullable
    public String getPharmacyNotes()
    {
        return pharmacyNotes;
    }

    @Nullable
    public String getDirections()
    {
        return directions;
    }

    @Nullable
    public Date getOrderDate()
    {
        return orderDate;
    }

    @Nullable
    public Date getReconcileDate()
    {
        return reconcileDate;
    }
    public void setDrugName(@Nullable String drugName)
    {
        this.drugName = drugName;
    }

    public void setGenericName(@Nullable String genericName)
    {
        this.genericName = genericName;
    }

    public void setOrderingPhysician(@Nullable String orderingPhysician)
    {
        this.orderingPhysician = orderingPhysician;
    }

    public void setPharmacy(@Nullable String pharmacy)
    {
        this.pharmacy = pharmacy;
    }

    public void setStatus(@Nullable String status)
    {
        this.status = status;
    }

    public void setLastRefillDate(@Nullable Date lastRefillDate)
    {
        this.lastRefillDate = lastRefillDate;
    }

    public void setDaysSupply(@Nullable String daysSupply)
    {
        this.daysSupply = daysSupply;
    }

    public void setRefills(@Nullable String refills)
    {
        this.refills = refills;
    }

    public void setQuantity(@Nullable String quantity)
    {
        this.quantity = quantity;
    }

    public void setQualifier(@Nullable String qualifier)
    {
        this.qualifier = qualifier;
    }

    public void setSubstitution(@Nullable String substitution)
    {
        this.substitution = substitution;
    }

    public void setPharmacyNotes(@Nullable String pharmacyNotes)
    {
        this.pharmacyNotes = pharmacyNotes;
    }

    public void setDirections(@Nullable String directions)
    {
        this.directions = directions;
    }

    public void setOrderDate(@Nullable Date orderDate)
    {
        this.orderDate = orderDate;
    }

    public void setReconcileDate(@Nullable Date reconcileDate)
    {
        this.reconcileDate = reconcileDate;
    }

    @NotNull
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

    @NotNull
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