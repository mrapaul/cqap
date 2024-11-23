package parser;

import ca.uhn.hl7v2.model.v26.datatype.*;


public class XTNParser
{
    
    public static String parseXTN(XTN xtn)
    {
        return xtn.getXtn1_TelephoneNumber().getValue();
    }
}
