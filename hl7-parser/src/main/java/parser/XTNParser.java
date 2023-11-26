package parser;

import ca.uhn.hl7v2.model.v26.datatype.*;
import org.jetbrains.annotations.*;

public class XTNParser
{
    @Nullable
    public static String parseXTN(@NotNull XTN xtn)
    {
        return xtn.getXtn1_TelephoneNumber().getValue();
    }
}
