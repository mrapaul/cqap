package com.peirs.datamodel.hl7;

import java.lang.*;import java.lang.Override;import java.lang.String;public class HL7
{
    private java.lang.String theMergeHL7Message;
    private String theInternalPatientId;
    private String thePatientJacketNumber;
    private String thePatientReport;
    private String theInstitutionId;
    private String thePatientFirstName;
    private String thePatientLastName;
    private String theStudyDescription;
    private String theFillerOrderNumber;
    private String thePlacerOrderNumber;
    private String theReasonForStudy;
    private String theMessageType;
    private String thePatientDOB;
    private String thePatientAccountNumber;
    private String theExternalPatientId;
    private String theReceivingFacility;
    private String theSendingFacility;
    private String thePrincipalResultInterpreter;
    private String theOrderControlCode;
    private String theCPTCode;

    public String getMergeHL7Message()
    {
        return theMergeHL7Message;
    }

    public void setMergeHL7Message(String aMergeHL7Message)
    {
        theMergeHL7Message = aMergeHL7Message;
    }

    public String getInternalPatientId()
    {
        return theInternalPatientId;
    }

    public void setInternalPatientId(String aInternalPatientId)
    {
        theInternalPatientId = aInternalPatientId;
    }

    public String getPatientJacketNumber()
    {
        return thePatientJacketNumber;
    }

    public void setPatientJacketNumber(String aPatientJacketNumber)
    {
        thePatientJacketNumber = aPatientJacketNumber;
    }

    public String getPatientReport()
    {
        return thePatientReport;
    }

    public void setPatientReport(String aPatientReport)
    {
        thePatientReport = aPatientReport;
    }

    public String getInstitutionId()
    {
        return theInstitutionId;
    }

    public void setInstitutionId(String aInstitutionId)
    {
        theInstitutionId = aInstitutionId;
    }

    public void setPatientFirstName(String aPatientFirstName)
    {
        thePatientFirstName = aPatientFirstName;
    }

    public String getPatientFirstName()
    {
        return thePatientFirstName;
    }

    public void setPatientLastName(String aPatientLastName)
    {
        thePatientLastName = aPatientLastName;
    }

    public String getPatientLastName()
    {
        return thePatientLastName;
    }

    public void setStudyDescription(String aStudyDescription)
    {
        theStudyDescription = aStudyDescription;
    }

    public String getStudyDescription()
    {
        return theStudyDescription;
    }


    public void setFillerOrderNumber(String aFillerOrderNumber)
    {
        theFillerOrderNumber = aFillerOrderNumber;
    }

    public String getFillerOrderNumber()
    {
        return theFillerOrderNumber;
    }

    public void setPlacerOrderNumber(String aPlacerOrderNumber)
    {
        thePlacerOrderNumber = aPlacerOrderNumber;
    }

    public String getPlacerOrderNumber()
    {
        return thePlacerOrderNumber;
    }

    public void setReasonForStudy(String aReasonForStudy)
    {
        theReasonForStudy = aReasonForStudy;
    }

    public String getReasonForStudy()
    {
        return theReasonForStudy;
    }

    public void setMessageType(String aMessageType)
    {
        theMessageType = aMessageType;
    }

    public String getMessageType()
    {
        return theMessageType;
    }

    public void setPatientDOB(String aPatientDOB)
    {
        thePatientDOB = aPatientDOB;
    }

    public String getPatientDOB()
    {
        return thePatientDOB;
    }

    public void setPatientAccountNumber(String aPatientAccountNumber)
    {
        thePatientAccountNumber = aPatientAccountNumber;
    }

    public String getPatientAccountNumber()
    {
        return thePatientAccountNumber;
    }

    public void setExternalPatientId(String aExternalPatientId)
    {
        theExternalPatientId = aExternalPatientId;
    }

    public String getExternalPatientId()
    {
        return theExternalPatientId;
    }

    public void setReceivingFacility(String aReceivingFacility)
    {
        theReceivingFacility = aReceivingFacility;
    }

    public String getReceivingFacility()
    {
        return theReceivingFacility;
    }

    public void setSendingFacility(String aSendingFacility)
    {
        theSendingFacility = aSendingFacility;
    }

    public String getSendingFacility()
    {
        return theSendingFacility;
    }

    public void setPrincipalResultInterpreter(String aPrincipalResultInterpreter)
    {
        thePrincipalResultInterpreter = aPrincipalResultInterpreter;
    }

    public String getPrincipalResultInterpreter()
    {
        return thePrincipalResultInterpreter;
    }

    @Override public String toString()
    {
        return theMessageType + " - " + thePatientFirstName + " " + thePatientLastName;
    }

    public void setOrderControlCode(String aOrderControlCode)
    {
        theOrderControlCode = aOrderControlCode;
    }

    public String getOrderControlCode()
    {
        return theOrderControlCode;
    }

    public void setCPTCode(String aCPTCode)
    {
        theCPTCode = aCPTCode;
    }

    public String getCPTCode()
    {
        return theCPTCode;
    }
}
