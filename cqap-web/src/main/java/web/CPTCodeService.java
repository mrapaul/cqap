package web;

import com.cqap.client.*;
import com.lakeland.ris.ui.datamodel.*;
import com.peirs.datamodel.hl7.*;


import java.util.*;

public class CPTCodeService
{
    private final ClientRestService restApi;

    public CPTCodeService(ClientRestService restApi)
    {
        this.restApi = restApi;
    }

    public Collection<CPTCode> get()
    {
        return restApi.findAllCPTCodes();
    }

    public Collection<CPTCodePrimaryGroup> getMapped()
    {
        return restApi.findAllCPTCodesMapped();
    }
}
