package com.lakeland.ris.ui.datamodel;

import org.codehaus.jackson.annotate.*;
import org.jetbrains.annotations.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;


public class Referral
{
    @Nullable private Date effectiveDate;
    @Nullable private String status;
    @Nullable private String referredBy;
    @Nullable private String referredTo;
    @Nullable private String reason;

    public Referral()
    {
        // empty
    }

    @JsonCreator
    public Referral(@Nullable Date effectiveDate,
                    @Nullable String status,
                    @Nullable String referredBy,
                    @Nullable String referredTo,
                    @Nullable String reason)
    {
        super();

        this.effectiveDate = effectiveDate;
        this.status = status;
        this.referredBy = referredBy;
        this.referredTo = referredTo;
        this.reason = reason;
    }

    @Nullable
    public Date getEffectiveDate()
    {
        return effectiveDate;
    }

    @Nullable
    public String getStatus()
    {
        return status;
    }

    @Nullable
    public String getReferredBy()
    {
        return referredBy;
    }

    @Nullable
    public String getReferredTo()
    {
        return referredTo;
    }

    @Nullable
    public String getReason()
    {
        return reason;
    }
    public void setEffectiveDate(@Nullable Date effectiveDate)
    {
        this.effectiveDate = effectiveDate;
    }

    public void setStatus(@Nullable String status)
    {
        this.status = status;
    }

    public void setReferredBy(@Nullable String referredBy)
    {
        this.referredBy = referredBy;
    }

    public void setReferredTo(@Nullable String referredTo)
    {
        this.referredTo = referredTo;
    }

    public void setReason(@Nullable String reason)
    {
        this.reason = reason;
    }

    @NotNull
    public String toString()
    {
        return "Referral(" +
            " effectiveDate: " + getEffectiveDate() +
            " status: " + getStatus() +
            " referredBy: " + getReferredBy() +
            " referredTo: " + getReferredTo() +
            " reason: " + getReason() + ")";
    }

    @NotNull
    public ReferralBuilder toBuilder()
    {
        return new ReferralBuilder().setEffectiveDate(getEffectiveDate())
                                    .setStatus(getStatus())
                                    .setReferredBy(getReferredBy())
                                    .setReferredTo(getReferredTo())
                                    .setReason(getReason());
    }
}