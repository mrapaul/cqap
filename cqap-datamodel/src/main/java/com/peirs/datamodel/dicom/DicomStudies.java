package com.peirs.datamodel.dicom;

import java.util.*;

public class DicomStudies
{
    private List<DicomStudy> theStudies;

    public DicomStudies()
    {
        theStudies = new ArrayList<>();
    }

    public DicomStudies(List<DicomStudy> aStudies)
    {
        theStudies = aStudies;
    }

    public List<DicomStudy> getStudies()
    {
        return theStudies;
    }

    public void setStudies(List<DicomStudy> aStudies)
    {
        theStudies = aStudies;
    }
}
