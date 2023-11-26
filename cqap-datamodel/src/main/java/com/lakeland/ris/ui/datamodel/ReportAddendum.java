package com.lakeland.ris.ui.datamodel;

import org.codehaus.jackson.annotate.*;
import org.jetbrains.annotations.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;


public class ReportAddendum
{
    @NotNull private Date timestamp;
    @NotNull private String userId;
    @NotNull private String addendum;

    public ReportAddendum()
    {
        // empty
    }

    @JsonCreator
    public ReportAddendum(@NotNull Date timestamp,
                          @NotNull String userId,
                          @NotNull String addendum)
    {
        super();

        this.timestamp = timestamp;
        this.userId = userId;
        this.addendum = addendum;
    }

    @NotNull
    public Date getTimestamp()
    {
        return timestamp;
    }

    @NotNull
    public String getUserId()
    {
        return userId;
    }

    @NotNull
    public String getAddendum()
    {
        return addendum;
    }
    public void setTimestamp(@NotNull Date timestamp)
    {
        this.timestamp = timestamp;
    }

    public void setUserId(@NotNull String userId)
    {
        this.userId = userId;
    }

    public void setAddendum(@NotNull String addendum)
    {
        this.addendum = addendum;
    }

    @NotNull
    public String toString()
    {
        return "ReportAddendum(" +
            " timestamp: " + getTimestamp() +
            " userId: " + getUserId() +
            " addendum: " + getAddendum() + ")";
    }

    @NotNull
    public ReportAddendumBuilder toBuilder()
    {
        return new ReportAddendumBuilder(getTimestamp(),
                                         getUserId(),
                                         getAddendum());
    }
}