package parser;

import ca.uhn.hl7v2.*;
import ca.uhn.hl7v2.model.v26.segment.*;
import com.lakeland.ris.ui.datamodel.*;


public class MSHParser implements MessageParser<MSH>
{
    @Override public void convert(MSH msh, DetailedOrderBuilder orderBuilder) throws HL7Exception
    {
        String institutionCode = msh.getMsh4_SendingFacility().getHd1_NamespaceID().getValue();
        orderBuilder.setInstitutionName(institutionCode);
    }
}
