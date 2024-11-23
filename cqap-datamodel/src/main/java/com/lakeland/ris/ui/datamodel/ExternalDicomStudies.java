package com.lakeland.ris.ui.datamodel;

import org.codehaus.jackson.annotate.*;

import java.util.*;
import com.lakeland.ris.datamodel.*;
import java.util.*;

public class ExternalDicomStudies
{
    private Collection<ExternalDicomStudy> studies;

    public ExternalDicomStudies()
    {
        // empty
    }

    @JsonCreator
    public ExternalDicomStudies(Collection<ExternalDicomStudy> studies)
    {
        super();

        this.studies = studies;
    }

    
    public Collection<ExternalDicomStudy> getStudies()
    {
        return studies;
    }
    public void setStudies(Collection<ExternalDicomStudy> studies)
    {
        this.studies = studies;
    }

    
    public String toString()
    {
        return "ExternalDicomStudies(" +
            " studies: " + getStudies() + ")";
    }

    
    public ExternalDicomStudiesBuilder toBuilder()
    {
        return new ExternalDicomStudiesBuilder(getStudies());
    }
}