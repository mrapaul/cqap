package parser;

import org.jetbrains.annotations.*;

public class XADParser
{
    @Nullable
    public static String getStreetAddress(@NotNull ca.uhn.hl7v2.model.v26.datatype.XAD xad)
    {
       return  xad.getXad1_StreetAddress().getSad1_StreetOrMailingAddress().getValue();
    }

    @Nullable
    public static String getZipcode(@NotNull ca.uhn.hl7v2.model.v26.datatype.XAD xad)
    {
        return  xad.getXad5_ZipOrPostalCode().getValue();
    }

    @Nullable
    public static String getCity(@NotNull ca.uhn.hl7v2.model.v26.datatype.XAD xad)
    {
        return  xad.getXad3_City().getValue();
    }

    @Nullable
    public static String getState(@NotNull ca.uhn.hl7v2.model.v26.datatype.XAD xad)
    {
        return  xad.getXad4_StateOrProvince().getValue();
    }
}
