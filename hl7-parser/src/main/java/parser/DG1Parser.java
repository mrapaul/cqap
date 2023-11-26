package parser;

import ca.uhn.hl7v2.*;
import ca.uhn.hl7v2.model.v26.segment.*;
import com.lakeland.ris.ui.datamodel.*;
import org.jetbrains.annotations.*;

import java.util.*;

public class DG1Parser implements MessageParser<List<DG1>>
{
    @Override public void convert(@NotNull List<DG1> dg1s, @NotNull DetailedOrderBuilder orderBuilder) throws HL7Exception
    {
        String diagnosisCode = "";
        for (DG1 dg1 : dg1s)
        {
            String value = dg1.getDg14_DiagnosisDescription().getValue();
            diagnosisCode = value + " ";
        }
        orderBuilder.setDiagnosisCode(diagnosisCode.trim());
    }
}
