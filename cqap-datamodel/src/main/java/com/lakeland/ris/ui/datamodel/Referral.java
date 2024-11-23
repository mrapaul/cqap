package com.lakeland.ris.ui.datamodel;

import org.codehaus.jackson.annotate.*;

import java.util.*;
import com.lakeland.ris.datamodel.*;


public class Referral
{
     private Date effectiveDate;
     private String status;
     private String referredBy;
     private String referredTo;
     private String reason;

    public Referral()
    {
        // empty
    }

    @JsonCreator
    public Referral( Date effectiveDate,
                     String status,
                     String referredBy,
                     String referredTo,
                     String reason)
    {
        super();

        this.effectiveDate = effectiveDate;
        this.status = status;
        this.referredBy = referredBy;
        this.referredTo = referredTo;
        this.reason = reason;
    }

    
    public Date getEffectiveDate()
    {
        return effectiveDate;
    }

    
    public String getStatus()
    {
        return status;
    }

    
    public String getReferredBy()
    {
        return referredBy;
    }

    
    public String getReferredTo()
    {
        return referredTo;
    }

    
    public String getReason()
    {
        return reason;
    }
    public void setEffectiveDate( Date effectiveDate)
    {
        this.effectiveDate = effectiveDate;
    }

    public void setStatus( String status)
    {
        this.status = status;
    }

    public void setReferredBy( String referredBy)
    {
        this.referredBy = referredBy;
    }

    public void setReferredTo( String referredTo)
    {
        this.referredTo = referredTo;
    }

    public void setReason( String reason)
    {
        this.reason = reason;
    }


    public String toString()
    {
        return "Referral(" +
            " effectiveDate: " + getEffectiveDate() +
            " status: " + getStatus() +
            " referredBy: " + getReferredBy() +
            " referredTo: " + getReferredTo() +
            " reason: " + getReason() + ")";
    }


    public ReferralBuilder toBuilder()
    {
        return new ReferralBuilder().setEffectiveDate(getEffectiveDate())
                                    .setStatus(getStatus())
                                    .setReferredBy(getReferredBy())
                                    .setReferredTo(getReferredTo())
                                    .setReason(getReason());
    }
}