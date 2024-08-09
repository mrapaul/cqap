package com.cqap.util;

import com.peirs.datamodel.dicom.*;
import org.dcm4che2.data.*;
import org.dcm4che2.util.*;

import java.text.*;
import java.util.*;

public final class DicomStudyTagValueFinder
{
    private static final DateFormat DATE_FORMAT = new SimpleDateFormat("dd MMM yyyy HH:mm:ss");

    private DicomStudyTagValueFinder()
    {
        // empty
    }

    public static String getDOB(DicomStudy aStudy)
    {
        Date myDate = DateUtils.parseDA(aStudy.getPatientBirthDate(), false);

        return myDate != null ? myDate.toString() : "N/A";
    }

    public static String getStudyDateToString(DicomStudy aStudy)
    {
        String myStudyTime = findValue(aStudy, Tag.StudyTime);
        Date myDate = (myStudyTime != null && !myStudyTime.equals("N/A")) && aStudy.getStudyDate() != null ?
                DateUtils.parseDT(aStudy.getStudyDate() + myStudyTime, false) : null;

        return myDate != null ? DATE_FORMAT.format(myDate) : "N/A";
    }

    public static Date toDate(String aDate)
    {
        try
        {
            return DATE_FORMAT.parse(aDate);
        }
        catch (ParseException e)
        {
            return new Date();
        }
    }

    public static String findValue(DicomStudy aStudy, int aTag)
    {
        DicomTag myTag = find(aStudy, aTag);

        return myTag != null ? myTag.getValue() : "N/A";
    }

    public static DicomTag find(DicomStudy aStudy, int aTag)
    {
        if (aStudy.getTags() != null)
        {
            for (DicomTag myTag : aStudy.getTags())
            {
                if (myTag.getDicomTag() == aTag)
                {
                    return myTag;
                }
            }
        }

        return null;
    }

    public static String getAge(DicomStudy aStudy)
    {
        String myAge = findValue(aStudy, Tag.PatientAge);

        if (myAge != null)
        {
            myAge = myAge.replaceAll("Y", "");
            if (myAge.indexOf("0") == 0)
            {
                myAge = myAge.replaceFirst("0", "");
            }
        }
        else
        {
            myAge = "N/A";
        }

        return myAge;
    }
}
