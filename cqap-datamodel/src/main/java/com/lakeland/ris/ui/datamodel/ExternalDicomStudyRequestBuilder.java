package com.lakeland.ris.ui.datamodel;

import com.peirs.datamodel.PACS;

import java.util.*;
import com.lakeland.ris.datamodel.*;


public class ExternalDicomStudyRequestBuilder
{
    private Date requestDate;
    private PACS pacs;

    public ExternalDicomStudyRequestBuilder(Date requestDate, PACS pacs)
    {
        super();

        this.requestDate = requestDate;
        this.pacs = pacs;
    }


    
    public ExternalDicomStudyRequestBuilder setRequestDate(Date requestDate)
    {
        this.requestDate = requestDate;

        return self();
    }

    
    public ExternalDicomStudyRequestBuilder setPACS(PACS pacs)
    {
        this.pacs = pacs;

        return self();
    }

    
    protected Date getRequestDate()
    {
        return requestDate;
    }

    public PACS getPacs() {
        return pacs;
    }

    
    public ExternalDicomStudyRequest build()
    {
        return new ExternalDicomStudyRequest(getRequestDate(), getPacs());
    }


    
    protected ExternalDicomStudyRequestBuilder self()
    {
        return this;
    }
}