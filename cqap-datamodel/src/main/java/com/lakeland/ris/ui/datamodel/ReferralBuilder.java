package com.lakeland.ris.ui.datamodel;

import org.jetbrains.annotations.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;


public class ReferralBuilder
{
    @Nullable private Date effectiveDate;
    @Nullable private String status;
    @Nullable private String referredBy;
    @Nullable private String referredTo;
    @Nullable private String reason;

    public ReferralBuilder()
    {
        super();

    }


    @NotNull
    public ReferralBuilder setEffectiveDate(@Nullable Date effectiveDate)
    {
        this.effectiveDate = effectiveDate;

        return self();
    }

    @NotNull
    public ReferralBuilder setStatus(@Nullable String status)
    {
        this.status = status;

        return self();
    }

    @NotNull
    public ReferralBuilder setReferredBy(@Nullable String referredBy)
    {
        this.referredBy = referredBy;

        return self();
    }

    @NotNull
    public ReferralBuilder setReferredTo(@Nullable String referredTo)
    {
        this.referredTo = referredTo;

        return self();
    }

    @NotNull
    public ReferralBuilder setReason(@Nullable String reason)
    {
        this.reason = reason;

        return self();
    }

    @Nullable
    protected Date getEffectiveDate()
    {
        return effectiveDate;
    }

    @Nullable
    protected String getStatus()
    {
        return status;
    }

    @Nullable
    protected String getReferredBy()
    {
        return referredBy;
    }

    @Nullable
    protected String getReferredTo()
    {
        return referredTo;
    }

    @Nullable
    protected String getReason()
    {
        return reason;
    }

    @NotNull
    public Referral build()
    {
        return new Referral(getEffectiveDate(),
                            getStatus(),
                            getReferredBy(),
                            getReferredTo(),
                            getReason());
    }


    @NotNull
    protected ReferralBuilder self()
    {
        return this;
    }
}