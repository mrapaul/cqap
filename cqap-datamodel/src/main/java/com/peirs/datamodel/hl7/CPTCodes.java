package com.peirs.datamodel.hl7;

import java.util.*;

public class CPTCodes
{
    private List<CPTCode> theCodes;

    public CPTCodes()
    {
        theCodes = new ArrayList<>();
    }

    public CPTCodes(List<CPTCode> aCodes)
    {
        theCodes = aCodes;
    }

    public List<CPTCode> getCodes()
    {
        return theCodes;
    }

    public void setCodes(List<CPTCode> aCodes)
    {
        theCodes = aCodes;
    }
}
