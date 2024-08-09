package com.capstone.server.controller;

import com.cqap.util.*;
import com.peirs.datamodel.dicom.*;
import com.peirs.datamodel.hl7.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

import static ch.lambdaj.collection.LambdaCollections.*;
import static org.hamcrest.CoreMatchers.*;

@Controller
public class HL7Controller
{
    private final HL7Service theService;

    @Autowired
    public HL7Controller(@Qualifier("HL7Service") HL7Service aService)
    {
        theService = aService;
    }

    @RequestMapping("/hl7/findAll")
    public @ResponseBody HL7Messages findAll()
    {
        return theService.findAll();
    }

    @RequestMapping(value = "hl7/findForStudy", method = RequestMethod.POST)
    public @ResponseBody HL7Messages findForStudy(@RequestBody DicomStudy aStudy)
    {
        return new HL7Messages(HL7Finder.findHL7Messages(findAll().getMessages(), aStudy));
    }

    @RequestMapping(value = "hl7/createOrUpdate", method = RequestMethod.POST)
    public @ResponseBody void createOrUpdate(@RequestBody MergeHL7Message aMessage)
    {
        theService.createOrUpdate(aMessage);
    }
}
