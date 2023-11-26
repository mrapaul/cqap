package com.lakeland.ris.ui.datamodel;

import com.peirs.datamodel.PACS;
import org.jetbrains.annotations.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;


public class ExternalDicomStudyRequestBuilder
{
    @NotNull private Date requestDate;
    private PACS pacs;

    public ExternalDicomStudyRequestBuilder(@NotNull Date requestDate, PACS pacs)
    {
        super();

        this.requestDate = requestDate;
        this.pacs = pacs;
    }


    @NotNull
    public ExternalDicomStudyRequestBuilder setRequestDate(@NotNull Date requestDate)
    {
        this.requestDate = requestDate;

        return self();
    }

    @NotNull
    public ExternalDicomStudyRequestBuilder setPACS(@NotNull PACS pacs)
    {
        this.pacs = pacs;

        return self();
    }

    @NotNull
    protected Date getRequestDate()
    {
        return requestDate;
    }

    public PACS getPacs() {
        return pacs;
    }

    @NotNull
    public ExternalDicomStudyRequest build()
    {
        return new ExternalDicomStudyRequest(getRequestDate(), getPacs());
    }


    @NotNull
    protected ExternalDicomStudyRequestBuilder self()
    {
        return this;
    }
}