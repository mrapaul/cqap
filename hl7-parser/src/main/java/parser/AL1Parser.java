package parser;


import ca.uhn.hl7v2.model.v26.datatype.*;
import ca.uhn.hl7v2.model.v26.segment.*;
import com.google.common.collect.*;
import com.lakeland.ris.ui.datamodel.*;
import org.jetbrains.annotations.*;

import java.util.*;

public class AL1Parser implements MessageParser<List<AL1>>
{
    @Override public void convert(@NotNull List<AL1> al1s, @NotNull DetailedOrderBuilder orderBuilder)
    {
        List<Allergy> allergies = Lists.newArrayList();
        for (AL1 al1 : al1s)
        {
            String id = al1.getAl11_SetIDAL1().getValue();
            String type = al1.getAl12_AllergenTypeCode().getAlternateText().getValue();
            String description = al1.getAl13_AllergenCodeMnemonicDescription().getCwe2_Text().getValue();
            String severityCode = al1.getAl14_AllergySeverityCode().getText().getValue();
            String reaction = "";
            for (ST st : al1.getAllergyReactionCode())
            {
                reaction += st.getValue() + " ";
            }

            String identificationDate = al1.getAl16_IdentificationDate().getValue();
            Allergy allergy = new Allergy(id, type, description, severityCode, reaction, identificationDate);
            allergies.add(allergy);
        }

        orderBuilder.setAllergies(allergies);
    }
}
