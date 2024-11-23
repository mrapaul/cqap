package parser;



public class XADParser
{
    
    public static String getStreetAddress(ca.uhn.hl7v2.model.v26.datatype.XAD xad)
    {
       return  xad.getXad1_StreetAddress().getSad1_StreetOrMailingAddress().getValue();
    }

    
    public static String getZipcode(ca.uhn.hl7v2.model.v26.datatype.XAD xad)
    {
        return  xad.getXad5_ZipOrPostalCode().getValue();
    }

    
    public static String getCity(ca.uhn.hl7v2.model.v26.datatype.XAD xad)
    {
        return  xad.getXad3_City().getValue();
    }

    
    public static String getState(ca.uhn.hl7v2.model.v26.datatype.XAD xad)
    {
        return  xad.getXad4_StateOrProvince().getValue();
    }
}
