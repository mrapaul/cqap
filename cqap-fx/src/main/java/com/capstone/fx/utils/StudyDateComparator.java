package com.capstone.fx.utils;

import com.cqap.util.*;

import java.util.*;

public class StudyDateComparator implements Comparator<String>
{
    @Override public int compare(String o1, String o2)
    {
        Date myDate1 = DicomStudyTagValueFinder.toDate(o1);
        Date myDate2 = DicomStudyTagValueFinder.toDate(o2);

        return myDate1.compareTo(myDate2);
    }
}
