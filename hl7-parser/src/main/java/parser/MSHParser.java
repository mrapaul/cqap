package parser;

import ca.uhn.hl7v2.*;
import ca.uhn.hl7v2.model.v26.segment.*;
import com.lakeland.ris.ui.datamodel.*;
import org.jetbrains.annotations.*;

public class MSHParser implements MessageParser<MSH>
{
    @Override public void convert(@NotNull MSH msh, @NotNull DetailedOrderBuilder orderBuilder) throws HL7Exception
    {
        String institutionCode = msh.getMsh4_SendingFacility().getHd1_NamespaceID().getValue();
        orderBuilder.setInstitutionName(institutionCode);
    }
}
