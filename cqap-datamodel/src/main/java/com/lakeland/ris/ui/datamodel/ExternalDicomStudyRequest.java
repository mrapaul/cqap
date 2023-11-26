package com.lakeland.ris.ui.datamodel;

import com.peirs.datamodel.PACS;
import org.codehaus.jackson.annotate.*;
import org.jetbrains.annotations.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;


public class ExternalDicomStudyRequest
{
    @NotNull private Date requestDate;
    private PACS pacs;

    public ExternalDicomStudyRequest()
    {
        // empty
    }

    @JsonCreator
    public ExternalDicomStudyRequest(@NotNull Date requestDate, PACS pacs)
    {
        super();

        this.requestDate = requestDate;
        this.pacs = pacs;
    }

    @NotNull
    public Date getRequestDate()
    {
        return requestDate;
    }
    public void setRequestDate(@NotNull Date requestDate)
    {
        this.requestDate = requestDate;
    }

    public PACS getPacs() {
        return pacs;
    }

    public void setPacs(PACS pacs) {
        this.pacs = pacs;
    }

    @NotNull
    public String toString()
    {
        return "ExternalDicomStudyRequest(" +
            " requestDate: " + getRequestDate() + ")";
    }

    @NotNull
    public ExternalDicomStudyRequestBuilder toBuilder()
    {
        return new ExternalDicomStudyRequestBuilder(getRequestDate(), getPacs());
    }
}