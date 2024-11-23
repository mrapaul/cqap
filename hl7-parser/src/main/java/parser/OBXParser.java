package parser;

import ca.uhn.hl7v2.*;
import ca.uhn.hl7v2.model.*;
import ca.uhn.hl7v2.model.v26.segment.*;
import com.lakeland.ris.ui.datamodel.*;


import java.util.*;

public class OBXParser implements MessageParser<OBX>
{
    @Override public void convert(OBX obx, DetailedOrderBuilder orderBuilder) throws HL7Exception
    {
        String observationIdentifier = obx.getObx3_ObservationIdentifier().getCwe1_Identifier().getValue();
        Varies[] observationValue = obx.getObx5_ObservationValue();
        for (Varies varies : observationValue)
        {
            Type data = varies.getData();
            orderBuilder.setReasonForExam(data.getName());
        }
        String cwe1_identifier = obx.getObx6_Units().getCwe3_NameOfCodingSystem().getValue();
        Date observationDateTime = obx.getObx14_DateTimeOfTheObservation().getValueAsDate();
    }
}
