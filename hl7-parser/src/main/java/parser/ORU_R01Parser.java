package parser;

import ca.uhn.hl7v2.*;
import ca.uhn.hl7v2.model.*;
import ca.uhn.hl7v2.model.v26.datatype.*;
import ca.uhn.hl7v2.model.v26.group.*;
import ca.uhn.hl7v2.model.v26.message.*;
import ca.uhn.hl7v2.model.v26.segment.*;
import com.lakeland.ris.datamodel.*;
import com.lakeland.ris.ui.datamodel.*;
import com.peirs.datamodel.hl7.*;
import org.jetbrains.annotations.*;

import java.util.*;

public class ORU_R01Parser
{
    @NotNull private final MSHParser mshParser;
    @NotNull private final OBRParser obrParser;
    @NotNull private final PIDParser pidParser;
    @NotNull private final PV1Parser pv1Parser;
    private DetailedOrderBuilder detailedOrderBuilder;
    private HL7 hl7;

    public ORU_R01Parser()
    {
        mshParser = new MSHParser();
        obrParser = new OBRParser();
        pidParser = new PIDParser();
        pv1Parser = new PV1Parser();
    }

    public HL7 parseReport(ORU_R01 report) throws HL7Exception
    {
        detailedOrderBuilder = new DetailedOrderBuilder("", OrderStatus.READ, OrderPriority.Low, "server");
        hl7 = new HL7();
        String[] names = report.getNames();
        for (String name : names)
        {
            Structure structure = report.get(name);
            switch (name)
            {
                case ("MSH"):
                {
                    MSH msh = (MSH) structure;
                    mshParser.convert(msh, detailedOrderBuilder);

                    break;
                }
                case ("PATIENT_RESULT"):
                {
                    ORU_R01_PATIENT_RESULT result = (ORU_R01_PATIENT_RESULT) structure;
                    convert(result);

                    break;
                }
            }
        }

        DetailedOrder order = detailedOrderBuilder.build();
        hl7.setCPTCode(order.getCPTCode());
        hl7.setExternalPatientId(order.getPatientId());
        hl7.setInternalPatientId(order.getPatientId());
        hl7.setMergeHL7Message(report.getMessage().encode());
        hl7.setMessageType("ORU");
        Date patientBirthDate = order.getPatientBirthDate();
        if (patientBirthDate != null)
        {
            hl7.setPatientDOB(patientBirthDate.toString());
        }
        hl7.setPatientFirstName(order.getPatientFirstName());
        hl7.setPatientJacketNumber(order.getAccessionNumber());
        hl7.setPatientLastName(order.getPatientLastName());
        hl7.setReceivingFacility(order.getInstitutionName());
        hl7.setStudyDescription(order.getStudyDescription());

        return hl7;
    }

    private void convert(ORU_R01_PATIENT_RESULT result) throws HL7Exception
    {
        String[] names = result.getNames();
        for (String name : names)
        {
            Structure structure = result.get(name);
            switch (name)
            {
                case ("PATIENT"):
                {
                    ORU_R01_PATIENT patient = (ORU_R01_PATIENT) structure;
                    convert(patient);

                    break;
                }
                case ("ORDER_OBSERVATION"):
                {
                    ORU_R01_ORDER_OBSERVATION observation = (ORU_R01_ORDER_OBSERVATION) structure;
                    convert(observation);

                    break;
                }
            }
        }

    }

    private void convert(ORU_R01_PATIENT patient) throws HL7Exception
    {
        String[] names = patient.getNames();
        for (String name : names)
        {
            Structure structure = patient.get(name);

            switch (name)
            {
                case ("PID"):
                {
                    PID pid = (PID) structure;
                    pidParser.convert(pid, detailedOrderBuilder);

                    break;
                }
                case ("VISIT"):
                {
                    ORU_R01_VISIT visit = (ORU_R01_VISIT) structure;
                    PV1 pv1 = visit.getPV1();
                    pv1Parser.convert(pv1, detailedOrderBuilder);

                    for (XCN xcn : pv1.getPv17_AttendingDoctor())
                    {
                        String lastName = xcn.getFamilyName().getFn1_Surname().getValue();
                        String firstName = xcn.getGivenName().getValue();
                        hl7.setPrincipalResultInterpreter(firstName + " " + lastName);
                    }

                    break;
                }
            }
        }
    }

    private void convert(ORU_R01_ORDER_OBSERVATION observation) throws HL7Exception
    {
        String reportText = "";
        List<ORU_R01_OBSERVATION> report = observation.getOBSERVATIONAll();

        for (ORU_R01_OBSERVATION oru_r01_observation : report)
        {
            OBX obx = oru_r01_observation.getOBX();
            if (!obx.isEmpty())
            {
                Varies[] observationValue = obx.getObx5_ObservationValue();
                for (Varies varies : observationValue)
                {
                    reportText += varies.getData() + "\n";
                }
            }
        }

        if (reportText.isEmpty())
        {
            List<NTE> nteAll = observation.getNTEAll();
            for (NTE nte : nteAll)
            {
                for (FT ft : nte.getNte3_Comment())
                {
                    reportText += ft.getValue() + "\n";
                }
            }
        }
        hl7.setPatientReport(reportText);

        OBR obr = observation.getOBR();
        obrParser.convert(obr, detailedOrderBuilder);
        String fillerOrderNumber = obr.getFillerOrderNumber().getEntityIdentifier().getValue();
        String placerOrderNumber = obr.getPlacerOrderNumber().getEntityIdentifier().getValue();
        hl7.setFillerOrderNumber(fillerOrderNumber);
        hl7.setPlacerOrderNumber(placerOrderNumber);
    }
}
