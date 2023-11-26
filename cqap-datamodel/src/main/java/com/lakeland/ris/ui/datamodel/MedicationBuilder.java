package com.lakeland.ris.ui.datamodel;

import org.jetbrains.annotations.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;


public class MedicationBuilder
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

    public MedicationBuilder()
    {
        super();

    }


    @NotNull
    public MedicationBuilder setDrugName(@Nullable String drugName)
    {
        this.drugName = drugName;

        return self();
    }

    @NotNull
    public MedicationBuilder setGenericName(@Nullable String genericName)
    {
        this.genericName = genericName;

        return self();
    }

    @NotNull
    public MedicationBuilder setOrderingPhysician(@Nullable String orderingPhysician)
    {
        this.orderingPhysician = orderingPhysician;

        return self();
    }

    @NotNull
    public MedicationBuilder setPharmacy(@Nullable String pharmacy)
    {
        this.pharmacy = pharmacy;

        return self();
    }

    @NotNull
    public MedicationBuilder setStatus(@Nullable String status)
    {
        this.status = status;

        return self();
    }

    @NotNull
    public MedicationBuilder setLastRefillDate(@Nullable Date lastRefillDate)
    {
        this.lastRefillDate = lastRefillDate;

        return self();
    }

    @NotNull
    public MedicationBuilder setDaysSupply(@Nullable String daysSupply)
    {
        this.daysSupply = daysSupply;

        return self();
    }

    @NotNull
    public MedicationBuilder setRefills(@Nullable String refills)
    {
        this.refills = refills;

        return self();
    }

    @NotNull
    public MedicationBuilder setQuantity(@Nullable String quantity)
    {
        this.quantity = quantity;

        return self();
    }

    @NotNull
    public MedicationBuilder setQualifier(@Nullable String qualifier)
    {
        this.qualifier = qualifier;

        return self();
    }

    @NotNull
    public MedicationBuilder setSubstitution(@Nullable String substitution)
    {
        this.substitution = substitution;

        return self();
    }

    @NotNull
    public MedicationBuilder setPharmacyNotes(@Nullable String pharmacyNotes)
    {
        this.pharmacyNotes = pharmacyNotes;

        return self();
    }

    @NotNull
    public MedicationBuilder setDirections(@Nullable String directions)
    {
        this.directions = directions;

        return self();
    }

    @NotNull
    public MedicationBuilder setOrderDate(@Nullable Date orderDate)
    {
        this.orderDate = orderDate;

        return self();
    }

    @NotNull
    public MedicationBuilder setReconcileDate(@Nullable Date reconcileDate)
    {
        this.reconcileDate = reconcileDate;

        return self();
    }

    @Nullable
    protected String getDrugName()
    {
        return drugName;
    }

    @Nullable
    protected String getGenericName()
    {
        return genericName;
    }

    @Nullable
    protected String getOrderingPhysician()
    {
        return orderingPhysician;
    }

    @Nullable
    protected String getPharmacy()
    {
        return pharmacy;
    }

    @Nullable
    protected String getStatus()
    {
        return status;
    }

    @Nullable
    protected Date getLastRefillDate()
    {
        return lastRefillDate;
    }

    @Nullable
    protected String getDaysSupply()
    {
        return daysSupply;
    }

    @Nullable
    protected String getRefills()
    {
        return refills;
    }

    @Nullable
    protected String getQuantity()
    {
        return quantity;
    }

    @Nullable
    protected String getQualifier()
    {
        return qualifier;
    }

    @Nullable
    protected String getSubstitution()
    {
        return substitution;
    }

    @Nullable
    protected String getPharmacyNotes()
    {
        return pharmacyNotes;
    }

    @Nullable
    protected String getDirections()
    {
        return directions;
    }

    @Nullable
    protected Date getOrderDate()
    {
        return orderDate;
    }

    @Nullable
    protected Date getReconcileDate()
    {
        return reconcileDate;
    }

    @NotNull
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


    @NotNull
    protected MedicationBuilder self()
    {
        return this;
    }
}