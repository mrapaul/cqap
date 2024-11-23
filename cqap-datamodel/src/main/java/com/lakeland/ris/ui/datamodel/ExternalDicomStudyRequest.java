package com.lakeland.ris.ui.datamodel;

import com.peirs.datamodel.PACS;
import org.codehaus.jackson.annotate.*;

import java.util.*;
import com.lakeland.ris.datamodel.*;


public class ExternalDicomStudyRequest
{
    private Date requestDate;
    private PACS pacs;

    public ExternalDicomStudyRequest()
    {
        // empty
    }

    @JsonCreator
    public ExternalDicomStudyRequest(Date requestDate, PACS pacs)
    {
        super();

        this.requestDate = requestDate;
        this.pacs = pacs;
    }

    
    public Date getRequestDate()
    {
        return requestDate;
    }
    public void setRequestDate(Date requestDate)
    {
        this.requestDate = requestDate;
    }

    public PACS getPacs() {
        return pacs;
    }

    public void setPacs(PACS pacs) {
        this.pacs = pacs;
    }

    
    public String toString()
    {
        return "ExternalDicomStudyRequest(" +
            " requestDate: " + getRequestDate() + ")";
    }

    
    public ExternalDicomStudyRequestBuilder toBuilder()
    {
        return new ExternalDicomStudyRequestBuilder(getRequestDate(), getPacs());
    }
}