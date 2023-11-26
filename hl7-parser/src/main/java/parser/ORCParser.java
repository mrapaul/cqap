package parser;

import ca.uhn.hl7v2.*;
import ca.uhn.hl7v2.model.v26.datatype.*;
import ca.uhn.hl7v2.model.v26.segment.*;
import com.lakeland.ris.ui.datamodel.*;
import org.jetbrains.annotations.*;

public class ORCParser implements MessageParser<ORC>
{
    @Override public void convert(@NotNull ORC orc, @NotNull DetailedOrderBuilder detailedOrderBuilder) throws HL7Exception
    {
        EI placerOrderNumber = orc.getPlacerOrderNumber();
        EI fillerOrderNumber = orc.getFillerOrderNumber();
        CWE orderControlCodeReason = orc.getOrderControlCodeReason();
        String placerOrderNumberValue = placerOrderNumber.getEntityIdentifier().getValue();
        String fillerOrderNumberValue = fillerOrderNumber.getEntityIdentifier().getValue();
        String orderControlCodeReasonValue = orderControlCodeReason.getIdentifier().getValue();

        detailedOrderBuilder.setOrderNumber(placerOrderNumberValue);

        if (placerOrderNumberValue != null && !placerOrderNumber.isEmpty())
        {
            detailedOrderBuilder.setAccessionNumber(placerOrderNumberValue);
        }

        XCN[] orderingProvider = orc.getOrc12_OrderingProvider();
        for (XCN xcn : orderingProvider)
        {
            String referringDoctorLastName = xcn.getFamilyName().getSurname().getValue();
            String referringDoctorFirstName = xcn.getGivenName().getValue();
            String referringDoctorDegree = xcn.getDegreeEgMD().getValue();
            detailedOrderBuilder.setReferringDoctorLastName(referringDoctorLastName)
                    .setReferringDoctorFirstName(referringDoctorFirstName)
                    .setReferringDoctorDegree(referringDoctorDegree);

            String referringName = (referringDoctorFirstName != null ? (referringDoctorFirstName + " ") : "") +
                    (referringDoctorLastName != null ? (referringDoctorLastName + " ") : "") +
                    (referringDoctorDegree != null ? (referringDoctorDegree + " ") : "");
            detailedOrderBuilder.setReferringDoctorFullName(referringName);
        }
    }
}
