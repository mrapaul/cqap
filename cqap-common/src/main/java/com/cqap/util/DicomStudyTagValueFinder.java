package com.cqap.util;

import com.peirs.datamodel.dicom.*;
import org.dcm4che2.data.*;
import org.dcm4che2.util.*;
import org.joda.time.*;

import java.text.*;
import java.util.*;

public final class DicomStudyTagValueFinder
{
    private static final DateFormat DATE_FORMAT = new SimpleDateFormat("dd MMM yyyy HH:mm:ss");
    private static final DateFormat DOB_FORMAT = new SimpleDateFormat("MMM dd yyyy");

    private DicomStudyTagValueFinder()
    {
        // empty
    }

    public static String getDOB(DicomStudy aStudy)
    {
        Date myDate = DateUtils.parseDA(aStudy.getPatientBirthDate(), false);

        return myDate != null ? DOB_FORMAT.format(myDate) : "N/A";
    }

    public static String getStudyDateToString(DicomStudy aStudy)
    {
        String myStudyTime = findValue(aStudy, Tag.StudyTime);
        String myStudyDate = aStudy.getStudyDate();
        Date myDate = ((myStudyTime != null && !myStudyTime.equals("N/A")) && myStudyDate != null) ?
                DateUtils.parseDT(myStudyDate + myStudyTime, false) : null;

        return myDate != null ? DATE_FORMAT.format(myDate) : (myStudyDate != null ? myStudyDate : "N/A");
    }

    public static String calculateAge(DicomStudy study)
    {
        Date myDate = DateUtils.parseDA(study.getPatientBirthDate(), false);

        Years age = null;
        if (myDate != null)
        {
            LocalDate birthdate = new LocalDate(myDate);
            LocalDate now = new LocalDate();
            age = Years.yearsBetween(birthdate, now);
        }

        return age != null ? String.valueOf(age.getYears()) : "N/A";
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
