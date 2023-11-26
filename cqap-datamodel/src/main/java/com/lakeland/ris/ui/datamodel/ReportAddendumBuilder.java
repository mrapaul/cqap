package com.lakeland.ris.ui.datamodel;

import org.jetbrains.annotations.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;


public class ReportAddendumBuilder
{
    @NotNull private Date timestamp;
    @NotNull private String userId;
    @NotNull private String addendum;

    public ReportAddendumBuilder(@NotNull Date timestamp,
                                 @NotNull String userId,
                                 @NotNull String addendum)
    {
        super();

        this.timestamp = timestamp;
        this.userId = userId;
        this.addendum = addendum;
    }


    @NotNull
    public ReportAddendumBuilder setTimestamp(@NotNull Date timestamp)
    {
        this.timestamp = timestamp;

        return self();
    }

    @NotNull
    public ReportAddendumBuilder setUserId(@NotNull String userId)
    {
        this.userId = userId;

        return self();
    }

    @NotNull
    public ReportAddendumBuilder setAddendum(@NotNull String addendum)
    {
        this.addendum = addendum;

        return self();
    }

    @NotNull
    protected Date getTimestamp()
    {
        return timestamp;
    }

    @NotNull
    protected String getUserId()
    {
        return userId;
    }

    @NotNull
    protected String getAddendum()
    {
        return addendum;
    }

    @NotNull
    public ReportAddendum build()
    {
        return new ReportAddendum(getTimestamp(),
                                  getUserId(),
                                  getAddendum());
    }


    @NotNull
    protected ReportAddendumBuilder self()
    {
        return this;
    }
}