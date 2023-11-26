package parser;


import ca.uhn.hl7v2.*;
import ca.uhn.hl7v2.model.*;
import ca.uhn.hl7v2.model.v26.datatype.*;
import ca.uhn.hl7v2.model.v26.group.*;
import ca.uhn.hl7v2.model.v26.message.*;
import ca.uhn.hl7v2.model.v26.segment.*;
import com.lakeland.hl7.datamodel.*;
import com.lakeland.ris.ui.datamodel.*;
import org.jetbrains.annotations.*;
import org.slf4j.*;

import java.util.*;

public class HL7Parser
{
    private static final Logger LOGGER = LoggerFactory.getLogger(HL7Parser.class);

    public void parse(@NotNull Message message, @NotNull HL7ParserHandler handler) throws HL7Exception
    {
        MSH msh = (MSH) message.get("MSH");
        MSG messageType = msh.getMessageType();
        String messageTypeCode = messageType.getMessageCode().getValue();
        String institutionCode = msh.getMsh4_SendingFacility().getHd1_NamespaceID().getValue();

        switch (messageTypeCode)
        {
            case (HL7MessageType.GENERAL_ACKNOWLEDGEMENT):
            {
                break;
            }
            case (HL7MessageType.ADMIT_DISCHARGE_TRANSFER):
            {
                ADT_A01 adt = (ADT_A01) message;
                parseADT(adt);

                break;
            }
            case (HL7MessageType.ADD_CHANGE_BILLING_ACCOUNT):
            {
                break;
            }
            case (HL7MessageType.DETAILED_FINANCIAL_TRANSACTION):
            {
                break;
            }
            case (HL7MessageType.MEDICAL_DOCUMENT_MANAGEMENT):
            {
                break;
            }
            case (HL7MessageType.MASTER_FILES_NOTIFICATION):
            {
                break;
            }
            case (HL7MessageType.ORDER):
            {
                ca.uhn.hl7v2.model.v26.message.ORM_O01 orm = (ca.uhn.hl7v2.model.v26.message.ORM_O01) message;
                DisplayOrder order = parseORM(orm);
                order.setInstitutionName(institutionCode);
                handler.onDisplayOrder(order);

                break;
            }
            case ("OMG"):
            {
                OMG_O19 orm = (OMG_O19) message;
                DisplayOrder order = parseOMG(orm);
                order.setInstitutionName(institutionCode);
                handler.onDisplayOrder(order);

                break;
            }
            case (HL7MessageType.OBSERVATION_RESULT):
            {
                break;
            }
            case (HL7MessageType.QUERY):
            {
                break;
            }
            case (HL7MessageType.PHARMACY_TREATMENT_ADMINISTRATION):
            {
                break;
            }
            case (HL7MessageType.PHARMACY_TREATMENT_ENCODED_ORDER):
            {
                break;
            }
            case (HL7MessageType.PHARMACY_TREATMENT_GIVE):
            {
                break;
            }
            case (HL7MessageType.SCHEDULING_INFORMATION_UNSOLICITED):
            {
                break;
            }
        }
    }

    private DisplayOrder parseORM(ORM_O01 orm)
    {
        DisplayOrder order = new DisplayOrder();
        ORM_O01_PATIENT ormPATIENT = orm.getPATIENT();
        ORM_O01_PATIENT_VISIT patientVisit = ormPATIENT.getPATIENT_VISIT();
        ORM_O01_ORDER ormORDER = orm.getORDER();
        ORM_O01_ORDER_DETAIL orderDetail = ormORDER.getORDER_DETAIL();
        parsePID(ormPATIENT.getPID(), order);
        parsePatientVisit(patientVisit, order);
        if (orderDetail != null)
        {
            parseOBR(orderDetail.getOBR(), order);
            parseORC(ormORDER.getORC(), order);
        }

        List<String> names = Arrays.asList(orm.getNames());
        if (names.contains("OBR") && names.contains("ORC")) // WARMC
        {
            try
            {
                Structure obr = orm.get("OBR");
                Structure orc = orm.get("ORC");

                if (orc != null)
                {
                    parseORC((ORC) orc, order);
                }

                if (obr != null)
                {
                    parseOBR((OBR) obr, order);
                }

            }
            catch (HL7Exception e)
            {
                LOGGER.error("Error parsing ORM", e);
            }
        }

        return order;
    }

    private DisplayOrder parseOMG(OMG_O19 orm)
    {
        DisplayOrder order = new DisplayOrder();
        OMG_O19_PATIENT ormPATIENT = orm.getPATIENT();
        OMG_O19_PATIENT_VISIT patientVisit = ormPATIENT.getPATIENT_VISIT();
        OMG_O19_ORDER ormORDER = orm.getORDER();
        ORC orc = ormORDER.getORC();
        OBR obr = ormORDER.getOBR();
        parsePID(ormPATIENT.getPID(), order);
        parsePatientVisit(patientVisit, order);
        parseOBR(obr, order);
        parseORC(orc, order);

        return order;
    }

    private void parseORC(ORC orc, DisplayOrder order)
    {
        String value = orc.getOrc2_PlacerOrderNumber().getEi1_EntityIdentifier().getValue();

        if (value != null)
        {
            order.setAccessionNumber(value);
        }
    }

    private DisplayOrder parseADT(ADT_A01 adt)
    {
        DisplayOrder order = new DisplayOrder();
        PID pid = adt.getPID();
        parsePID(pid, order);

        return order;
    }

    private void parsePID(PID pid, DisplayOrder order)
    {
        XPN[] patientName = pid.getPatientName();
        for (XPN xpn : patientName)
        {
            order.setFirstName(xpn.getGivenName().getValue());
            order.setMiddleName(xpn.getSecondAndFurtherGivenNamesOrInitialsThereof().getValue());
            order.setLastName(xpn.getFamilyName().getFn1_Surname().getValue());
        }
        CX[] cx = pid.getPatientIdentifierList();
        for (CX cx1 : cx)
        {
            String patientId = cx1.getIDNumber().getValue();
            if (order.getPatientId() == null && patientId != null)
            {
                order.setPatientId(patientId);
                break;
            }
        }

        order.setBirthDate(pid.getDateTimeOfBirth().getValue());
        order.setSex(pid.getAdministrativeSex().getValue());

        for (CX cx1 : pid.getAlternatePatientIDPID())
        {
            order.setAlternatePatientId(cx1.getIDNumber().getValue());
        }
    }

    private void parsePatientVisit(ORM_O01_PATIENT_VISIT patientVisit, DisplayOrder order)
    {
        PV1 pv1 = patientVisit.getPV1();
        parsePV1(pv1, order);
    }

    private void parsePatientVisit(OMG_O19_PATIENT_VISIT patientVisit, DisplayOrder order)
    {
        PV1 pv1 = patientVisit.getPV1();
        parsePV1(pv1, order);
    }

    private void parsePV1(PV1 pv1, DisplayOrder order)
    {
        PL assignedPatientLocation = pv1.getAssignedPatientLocation();
        HD facility = assignedPatientLocation.getFacility();
        String facilityNamespaceID = facility.getHd1_NamespaceID().getValue();
        order.setInstitutionName(facilityNamespaceID);
    }

    private void parseOBR(@NotNull OBR obr, @NotNull DisplayOrder order)
    {
        String accessionNumber = obr.getFillerOrderNumber().getEntityIdentifier().getValue();
        if (accessionNumber == null)
        {
            accessionNumber = obr.getObr20_FillerField1().getValue();
        }
        if (accessionNumber == null)
        {
            accessionNumber = obr.getPlacerOrderNumber().getEntityIdentifier().getValue();
        }
        order.setAccessionNumber(accessionNumber != null ? accessionNumber : "");
        CWE universalServiceIdentifier = obr.getObr4_UniversalServiceIdentifier();
        if (universalServiceIdentifier.getAlternateIdentifier().getValue() != null)
        {
            order.setCPTCode(universalServiceIdentifier.getAlternateIdentifier().getValue());
        }
        else
        {
            order.setCPTCode("");
        }
        order.setCPTMnemonic(universalServiceIdentifier.getIdentifier().getValue());
        order.setModality(universalServiceIdentifier.getNameOfCodingSystem().getValue());
        order.setStudyDescription(universalServiceIdentifier.getText().getValue());

        String modality = order.getModality();
        String studyDescription = order.getStudyDescription();
        if ((modality == null || modality.isEmpty()) && studyDescription != null)
        {
            order.setModality(studyDescription.substring(0, 2));
        }
    }
}
