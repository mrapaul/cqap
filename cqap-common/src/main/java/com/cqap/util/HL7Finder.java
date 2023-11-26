package com.cqap.util;

import com.peirs.datamodel.dicom.*;
import com.peirs.datamodel.hl7.*;
import org.slf4j.*;

import java.util.*;

import static ch.lambdaj.Lambda.having;
import static ch.lambdaj.Lambda.on;
import static ch.lambdaj.Lambda.select;
import static org.hamcrest.CoreMatchers.is;

public class HL7Finder
{
    private static final Logger LOGGER = LoggerFactory.getLogger(HL7Finder.class);

    public static List<HL7> findHL7Messages(List<HL7> aHL7s, DicomStudy aStudy)
    {

        List<HL7> myHL7s = new ArrayList<>();

        String myAccessionNumber = aStudy.getAccessionNumber();
        if (myAccessionNumber != null)
        {
            myHL7s.addAll(select(aHL7s, having(on(HL7.class).getFillerOrderNumber(), is(myAccessionNumber))));
        }

        if (myHL7s.isEmpty())
        {
            LOGGER.error("No HL7 messages found for study with accession number {}", myAccessionNumber);
//            myHL7s = select(aHL7s, having(on(HL7.class).getInternalPatientId(), is(aStudy.getPatientID())));
        }
        return myHL7s;
    }
}
