package com.peirs.datamodel.dicom;

import java.util.*;

public class DicomStudyQueryResults
{
    private List<DicomStudyQueryResult> theResults;

    public DicomStudyQueryResults()
    {
        theResults = new ArrayList<>();
    }

    public DicomStudyQueryResults(List<DicomStudyQueryResult> aResults)
    {
        theResults = aResults;
    }

    public List<DicomStudyQueryResult> getResults()
    {
        return theResults;
    }

    public void setResults(List<DicomStudyQueryResult> aResults)
    {
        theResults = aResults;
    }
}
