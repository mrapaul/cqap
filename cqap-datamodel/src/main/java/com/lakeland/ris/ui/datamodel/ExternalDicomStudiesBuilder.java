package com.lakeland.ris.ui.datamodel;


import java.util.*;
import com.lakeland.ris.datamodel.*;
import java.util.*;

public class ExternalDicomStudiesBuilder
{
    private Collection<ExternalDicomStudy> studies;

    public ExternalDicomStudiesBuilder(Collection<ExternalDicomStudy> studies)
    {
        super();

        this.studies = studies;
    }


    
    public ExternalDicomStudiesBuilder setStudies(Collection<ExternalDicomStudy> studies)
    {
        this.studies = studies;

        return self();
    }

    
    protected Collection<ExternalDicomStudy> getStudies()
    {
        return studies;
    }

    
    public ExternalDicomStudies build()
    {
        return new ExternalDicomStudies(getStudies());
    }


    
    protected ExternalDicomStudiesBuilder self()
    {
        return this;
    }
}