package com.capstone.server.controller;

import com.peirs.datamodel.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

@RestController
public class InstitutionController
{
    private final InstitutionService theService;

    @Autowired
    public InstitutionController(@Qualifier("InstitutionService") InstitutionService aService)
    {
        theService = aService;
    }

    @RequestMapping("/institution/findAll")
    public @ResponseBody Institutions findAll()
    {
        return theService.findAll();
    }

    @RequestMapping(value = "institution/createOrUpdate", method = RequestMethod.POST)
    public @ResponseBody void createOrUpdate(@RequestBody Institution aInstitution)
    {
        theService.createOrUpdate(aInstitution);
    }

    @RequestMapping(value = "institution/delete", method = RequestMethod.POST)
    public @ResponseBody void delete(@RequestBody Institution aInstitution)
    {
        theService.delete(aInstitution);
    }
}
