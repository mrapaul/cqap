package com.lakeland.ris.ui.datamodel;


import java.util.*;
import com.lakeland.ris.datamodel.*;


public class ReferralBuilder
{
     private Date effectiveDate;
     private String status;
     private String referredBy;
     private String referredTo;
     private String reason;

    public ReferralBuilder()
    {
        super();

    }



    public ReferralBuilder setEffectiveDate( Date effectiveDate)
    {
        this.effectiveDate = effectiveDate;

        return self();
    }


    public ReferralBuilder setStatus( String status)
    {
        this.status = status;

        return self();
    }


    public ReferralBuilder setReferredBy( String referredBy)
    {
        this.referredBy = referredBy;

        return self();
    }


    public ReferralBuilder setReferredTo( String referredTo)
    {
        this.referredTo = referredTo;

        return self();
    }


    public ReferralBuilder setReason( String reason)
    {
        this.reason = reason;

        return self();
    }

    
    protected Date getEffectiveDate()
    {
        return effectiveDate;
    }

    
    protected String getStatus()
    {
        return status;
    }

    
    protected String getReferredBy()
    {
        return referredBy;
    }

    
    protected String getReferredTo()
    {
        return referredTo;
    }

    
    protected String getReason()
    {
        return reason;
    }


    public Referral build()
    {
        return new Referral(getEffectiveDate(),
                            getStatus(),
                            getReferredBy(),
                            getReferredTo(),
                            getReason());
    }



    protected ReferralBuilder self()
    {
        return this;
    }
}