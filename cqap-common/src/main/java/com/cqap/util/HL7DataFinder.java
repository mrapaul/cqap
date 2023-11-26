package com.cqap.util;

import com.peirs.datamodel.hl7.*;

import java.util.*;

import static ch.lambdaj.Lambda.*;
import static ch.lambdaj.collection.LambdaCollections.*;
import static org.hamcrest.Matchers.*;

public class HL7DataFinder
{
    public static String findPatientReport(List<HL7> aHL7s)
    {
        List<String> myReports = with(aHL7s).extract(on(HL7.class).getPatientReport()).remove(nullValue());
        for (String myReport : myReports)
        {
            if (!myReport.isEmpty())
            {
                return myReport;
            }
        }
        return null;
    }

    public static String findPIR(List<HL7> aHL7s)
    {
        List<String> myPIRs = with(aHL7s).extract(on(HL7.class).getPrincipalResultInterpreter()).remove(nullValue());
        for (String myPIR : myPIRs)
        {
            if (!myPIR.isEmpty())
            {
                return myPIR;
            }
        }
        return null;
    }

    public static String findPatientHistory(List<HL7> aHL7s)
    {
        List<String> myReasons = with(aHL7s).extract(on(HL7.class).getReasonForStudy()).remove(nullValue());
        List<String> myOrderControlCodes = with(aHL7s).extract(on(HL7.class).getOrderControlCode()).remove(nullValue());
        for (String myReason : myReasons)
        {
            if (!myReason.isEmpty())
            {
                return myReason;
            }
        }

        for (String myOrderControlCode : myOrderControlCodes)
        {
            if (!myOrderControlCode.isEmpty())
            {
                return myOrderControlCode;
            }
        }
        return null;
    }

    public static String findCPTCode(List<HL7> aHL7s)
    {
        List<String> myCPTCodes = with(aHL7s).extract(on(HL7.class).getCPTCode()).remove(nullValue());
        for (String myCPTCode : myCPTCodes)
        {
            if (!myCPTCode.isEmpty())
            {
                return myCPTCode;
            }
        }
        return null;
    }
}
