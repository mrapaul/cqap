package com.cqap.merge;

import com.merge.HL7.*;
import com.merge.HL7.v231.fields.*;
import com.merge.HL7.v231.segments.*;
import com.peirs.datamodel.hl7.*;
import org.slf4j.*;

import java.util.*;

public class MergeV231Parser
{
    private static final Logger LOGGER = LoggerFactory.getLogger(MergeV231Parser.class);

    public HL7 parse(HL7Message aMessage)
    {
        HL7 myHL7 = new HL7();
//        System.out.println(aMessage.toAnnotatedString(HL7Toolkit.EXPAND_SEGMENT));
        myHL7.setMergeHL7Message(aMessage.toAnnotatedString(HL7Toolkit.EXPAND_SEGMENT));
        String myMessageType = aMessage.getMessageType();
        myHL7.setMessageType(myMessageType);

        Enumeration<String> mySegmentNames = HL7SegmentConstants.getSegmentNames();
        while (mySegmentNames.hasMoreElements())
        {
            String mySegmentName = mySegmentNames.nextElement();
            switch (mySegmentName)
            {
                case ("ADD"):
                {
                    parseADD(aMessage, myHL7);

                    break;
                }
                case ("MSH"):
                {
                    parseMSH(aMessage, myHL7);

                    break;
                }
                case ("OBR"):
                {
                    parseOBR(aMessage, myHL7);

                    break;
                }
                case ("OBX"):
                {
                    parseOBX(aMessage, myHL7);

                    break;
                }
                case ("ORC"):
                {
                    parseORC(aMessage, myHL7);

                    break;
                }
                case ("PID"):
                {
                    parsePID(aMessage, myHL7);

                    break;
                }
                case ("PV1"):
                {
                    parsePV1(aMessage, myHL7);

                    break;
                }
                default:
                {
                    LOGGER.debug("Skipping segment of type " + mySegmentName);
                }
            }
        }

        return myHL7;
    }

    private void parsePID(HL7Message aMessage, HL7 aHL7)
    {
        HL7SegmentPID pid = (HL7SegmentPID) aMessage.getSegment("PID");
        String myInternalPatientId = pid.getFirstInternalID().getValue();
        String myExternalPatientId = pid.getExternalID().getValue();
        HL7FieldXPN myPatientName = pid.getFirstPatientName();
        HL7FieldCX myFirstAlternatePatientID = pid.getFirstAlternatePatientID();
        String myIDNumber = myFirstAlternatePatientID.getIDNumber();
        String myGivenName = myPatientName.getGivenName();
        String myFamilyName = myPatientName.getFamilyName();
        HL7FieldTS myDateTimeOfBirth = pid.getDateTimeOfBirth();
        String myDateValue = myDateTimeOfBirth.getValue();
        HL7FieldCX myPatientAccountNumber = pid.getPatientAccountNumber();
        aHL7.setInternalPatientId(myInternalPatientId);
        aHL7.setExternalPatientId(myExternalPatientId);
        aHL7.setPatientJacketNumber(myIDNumber);
        aHL7.setPatientAccountNumber(myPatientAccountNumber.getIDNumber());
        aHL7.setPatientLastName(myFamilyName);
        aHL7.setPatientDOB(myDateValue);
        aHL7.setPatientFirstName(myGivenName);
    }

    private void parseADD(HL7Message aMessage, HL7 aHL7)
    {
        HL7SegmentADD mySegment = (HL7SegmentADD) aMessage.getSegment("ADD");
        if (mySegment != null)
        {
            // empty
        }
    }

    private void parseMSH(HL7Message aMessage, HL7 aHL7)
    {
        HL7SegmentMSH myMSH = (HL7SegmentMSH) aMessage.getSegment("MSH");
        if (myMSH != null)
        {
            String myReceivingFacility = myMSH.getReceivingFacility().getValue();
            String mySendingFacility = myMSH.getSendingFacility().getValue();

            aHL7.setSendingFacility(mySendingFacility);
            aHL7.setReceivingFacility(myReceivingFacility);
        }
    }

    private void parseOBR(HL7Message aMessage, HL7 aHL7)
    {
        HL7SegmentOBR myOBR = (HL7SegmentOBR) aMessage.getSegment("OBR");
        if (myOBR != null)
        {
            HL7FieldCE myUniversalServiceID = myOBR.getUniversalServiceID();
            String myAlternateIdentifier = myUniversalServiceID.getAlternateIdentifier();
            String myUniversalServiceIDTex = myUniversalServiceID.getContent();
            String myIdentifier = myUniversalServiceID.getIdentifier();
            String myAlternateText = myUniversalServiceID.getAlternateText();
            HL7FieldST myRelevantClinicalInformation = myOBR.getRelevantClinicalInformation();
            HL7FieldSI mySetID = myOBR.getSetID();
            HL7FieldCE myFirstReasonForStudy = myOBR.getFirstReasonForStudy();
            String myText = myFirstReasonForStudy.getValue();
            String myPrincipalResultInterpreter = myOBR.getPrincipalResultInterpreter().getContent();
            aHL7.setPrincipalResultInterpreter(myPrincipalResultInterpreter);
            aHL7.setStudyDescription(myUniversalServiceIDTex);
            aHL7.setReasonForStudy(myText);
            aHL7.setCPTCode(myAlternateIdentifier);
        }
    }

    private void parseOBX(HL7Message aMessage, HL7 aHL7)
    {
        HL7SegmentOBX myOBX = (HL7SegmentOBX) aMessage.getSegment("OBX");
        if (myOBX != null)
        {
            HL7Field[] myValue = myOBX.getValue();
            StringBuilder myBuilder = new StringBuilder();
            for (HL7Field myHL7Field : myValue)
            {
                myBuilder.append(myHL7Field.toAnnotatedString()).append("\n");
            }
            aHL7.setPatientReport(myBuilder.toString());
        }
    }

    private void parseORC(HL7Message aMessage, HL7 aHL7)
    {
        HL7SegmentORC myORC = (HL7SegmentORC) aMessage.getSegment("ORC");
        if (myORC != null)
        {
            HL7FieldEI myFillerOrderNumber = myORC.getFillerOrderNumber();
            HL7FieldEI myPlacerOrderNumber = myORC.getPlacerOrderNumber();
            HL7FieldCE myOrderControlCodeReason = myORC.getOrderControlCodeReason();
            aHL7.setFillerOrderNumber(myFillerOrderNumber.getValue());
            aHL7.setPlacerOrderNumber(myPlacerOrderNumber.getValue());
            aHL7.setOrderControlCode(myOrderControlCodeReason.getValue());
        }
    }

    private void parsePV1(HL7Message aMessage, HL7 aHL7)
    {
        HL7SegmentPV1 myPV1 = (HL7SegmentPV1) aMessage.getSegment("PV1");
        if (myPV1 != null)
        {
            String myFacilityValue = myPV1.getAssignedPatientLocation().getValue();
            if (myFacilityValue != null && !myFacilityValue.isEmpty())
            {
                aHL7.setInstitutionId(myFacilityValue);
            }
        }
    }
}
