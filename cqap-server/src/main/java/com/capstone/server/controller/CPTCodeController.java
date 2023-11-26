package com.capstone.server.controller;

import com.lakeland.ris.ui.datamodel.*;
import com.peirs.datamodel.hl7.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@RestController
public class CPTCodeController
{
    private final CPTCodeService theService;

    @Autowired
    public CPTCodeController(@Qualifier("CPTCodeService") CPTCodeService aService)
    {
        theService = aService;
    }

    @RequestMapping("/CPTCodes/findAll")
    public @ResponseBody CPTCodes findAll()
    {
        return theService.findAll();
    }

    @RequestMapping("/CPTCodes/findOne")
    public @ResponseBody CPTCode findOne(@RequestParam("CPTCode") String aCPTCode)
    {
        return theService.findOne(aCPTCode);
    }

    @RequestMapping(value = "CPTCodes/createOrUpdate", method = RequestMethod.POST)
    public @ResponseBody CPTCode createOrUpdate(@RequestBody CPTCode aCPTCode)
    {
        return theService.createOrUpdate(aCPTCode);
    }

    @RequestMapping("/CPTCodes/findAllMapped")
    public @ResponseBody CPTCodePrimaryGroups findAllMapped()
    {
        return theService.primarySecondarySpecialities();
    }

}
