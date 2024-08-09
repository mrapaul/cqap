package com.capstone.server.controller;

import com.peirs.datamodel.dicom.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@Controller
public class DicomStudyController
{
    private final DicomStudyService theService;

    @Autowired
    public DicomStudyController(@Qualifier("DicomStudyService") DicomStudyService aService)
    {
        theService = aService;
    }

    @RequestMapping(value = "dicomStudy/find", method = RequestMethod.POST)
    public @ResponseBody DicomStudyQueryResults find(@RequestBody DicomStudyQuery aQuery)
    {
        return theService.findStudies(aQuery);
    }

    @RequestMapping("/dicomStudy/findOne")
    public @ResponseBody DicomStudy findOne(@RequestParam("id") String aId)
    {
        return theService.findOne(aId);
    }

    @RequestMapping("/dicomStudy/findByStudyInstanceUID")
    public @ResponseBody DicomStudies findByStudyInstanceUID(@RequestParam("studyInstanceUID") String aStudyInstanceUID)
    {
        return theService.findByStudyInstanceUID(aStudyInstanceUID);
    }

    @RequestMapping(value = "dicomStudy/createOrUpdate", method = RequestMethod.POST)
    public @ResponseBody DicomStudy createOrUpdate(@RequestBody DicomStudy aDicomStudy)
    {
        return theService.createOrUpdate(aDicomStudy);
    }

    @RequestMapping(value = "dicomStudy/delete", method = RequestMethod.POST)
    public @ResponseBody void delete(@RequestBody DicomStudy aDicomStudy)
    {
        theService.delete(aDicomStudy);
    }
}
