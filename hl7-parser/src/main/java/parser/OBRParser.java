package parser;

import ca.uhn.hl7v2.*;
import ca.uhn.hl7v2.model.v26.datatype.*;
import ca.uhn.hl7v2.model.v26.segment.*;
import com.lakeland.ris.ui.datamodel.*;
import org.jetbrains.annotations.*;

import java.util.*;

public class OBRParser implements MessageParser<OBR>
{
    @Override public void convert(@NotNull OBR obr, @NotNull DetailedOrderBuilder detailedOrderBuilder) throws HL7Exception
    {
        String reasonForExam = null;
        for (CWE cwe : obr.getReasonForStudy())
        {
            String identifier = cwe.getCwe1_Identifier().getValue();
            String text = cwe.getCwe2_Text().getValue();
            String codingSystem = cwe.getCwe3_NameOfCodingSystem().getValue();
            String alternateIdentifier = cwe.getCwe4_AlternateIdentifier().getValue();

            reasonForExam = text;
            detailedOrderBuilder.setReasonForExam(text);
        }

        if (reasonForExam == null)
        {
            String relevantClinicalInformation = obr.getRelevantClinicalInformation().getValue();
            detailedOrderBuilder.setReasonForExam(relevantClinicalInformation);
        }

        String accessionNumber = obr.getFillerOrderNumber().getEntityIdentifier().getValue();
        if (accessionNumber == null)
        {
            accessionNumber = obr.getObr20_FillerField1().getValue();
        }
        if (accessionNumber == null)
        {
            accessionNumber = obr.getPlacerOrderNumber().getEntityIdentifier().getValue();
        }
        if (accessionNumber != null)
        {
            detailedOrderBuilder.setAccessionNumber(accessionNumber);
        }

        CWE universalServiceIdentifier_OBR4 = obr.getUniversalServiceIdentifier();
        String universalServiceIdentifier = universalServiceIdentifier_OBR4.getIdentifier().getValue();
        String studyDescription = universalServiceIdentifier_OBR4.getText().getValue();
        String modality = universalServiceIdentifier_OBR4.getNameOfCodingSystem().getValue();
        detailedOrderBuilder.setProcedureCode(universalServiceIdentifier);

        String priLastName = obr.getPrincipalResultInterpreter().getNDLName().getCnn2_FamilyName().getValue();
        String priFirstName = obr.getPrincipalResultInterpreter().getNDLName().getCnn3_GivenName().getValue();
        String priSuffix = obr.getPrincipalResultInterpreter().getNDLName().getCnn5_SuffixEgJRorIII().getValue();
        String priDegree = obr.getPrincipalResultInterpreter().getNDLName().getCnn7_DegreeEgMD().getValue();


        EI placerOrderNumber = obr.getPlacerOrderNumber();
        String ponEntityIdentifier = placerOrderNumber.getEi1_EntityIdentifier().getValue();
        String ponNamespaceId = placerOrderNumber.getEi2_NamespaceID().getValue();
        String ponUniversalId = placerOrderNumber.getEi3_UniversalID().getValue();
        String ponUniversalType = placerOrderNumber.getEi4_UniversalIDType().getValue();

        for (XCN xcn : obr.getOrderingProvider())
        {
            String orderingPhysicianLastName = xcn.getFamilyName().getSurname().getValue();
            String orderingPhysicianFirstName = xcn.getGivenName().getValue();
            String orderingPhysicianDegree = xcn.getDegreeEgMD().getValue();

            detailedOrderBuilder.setOrderingDoctorLastName(orderingPhysicianLastName)
                    .setOrderingDoctorFirstName(orderingPhysicianFirstName)
                    .setOrderingDoctorDegree(orderingPhysicianDegree)
                    .setOrderingDoctorFullName(orderingPhysicianFirstName + " " + orderingPhysicianLastName);
        }

//        Date scheduledDate = obr.getScheduledDateTime().getValueAsDate();
        String priority = obr.getPriority().getValue();

//        detailedOrderBuilder.setProcedureStartDate(scheduledDate);
        detailedOrderBuilder.setPrincipalResultInterpreter(priDegree +
                " " +
                priFirstName +
                " " +
                priLastName +
                " " +
                priSuffix);
        if (universalServiceIdentifier_OBR4.getAlternateIdentifier().getValue() != null)
        {
            detailedOrderBuilder.setCPTCode(universalServiceIdentifier_OBR4.getAlternateIdentifier().getValue());
        }
        else
        {
            detailedOrderBuilder.setCPTCode("");
        }
        detailedOrderBuilder.setCPTMnemonic(universalServiceIdentifier_OBR4.getIdentifier().getValue());
        detailedOrderBuilder.setPriority(priority).setModality(modality).setStudyDescription(studyDescription);
        TQ[] obr27_quantityTiming = obr.getObr27_QuantityTiming();
        for (TQ tq : obr27_quantityTiming)
        {
            String procedureDateTime = tq.getTq1_Quantity().getCq1_Quantity().getValue();
            detailedOrderBuilder.setProcedureStartDate(procedureDateTime);
        }

        if ((modality == null || modality.isEmpty()) && studyDescription != null)
        {
            detailedOrderBuilder.setModality(studyDescription.substring(0, 2));
        }
    }
}
