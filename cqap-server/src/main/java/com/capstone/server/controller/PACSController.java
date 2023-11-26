package com.capstone.server.controller;

import com.lakeland.ris.ui.datamodel.*;
import com.peirs.datamodel.*;
import com.peirs.datamodel.dicom.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

@RestController
public class PACSController
{
    private final PACSService service;

    @Autowired
    public PACSController(@Qualifier("PACSService") PACSService service)
    {
        this.service = service;
    }

    @RequestMapping("/PACS/findAll")
    public @ResponseBody PACSs findAll()
    {
        return service.findAll();
    }

    @RequestMapping(value = "/PACS/createOrUpdate", method = RequestMethod.POST)
    public @ResponseBody PACS createOrUpdate(@RequestBody PACS pacs)
    {
        return service.createOrUpdate(pacs);
    }

    @RequestMapping(value = "/PACS/delete", method = RequestMethod.POST)
    public @ResponseBody void delete(@RequestBody PACS pacs)
    {
        service.delete(pacs);
    }

    @RequestMapping(value = "/PACS/queryExternalStudies", method = RequestMethod.POST)
    public @ResponseBody ExternalDicomStudies queryExternalStudies(@RequestBody ExternalDicomStudyRequest request)
    {
        return service.queryExternalStudies(request);
    }

//    @RequestMapping(value = "PACS/importExternal", method = RequestMethod.POST)
//    public @ResponseBody DicomStudies importExternal(@RequestBody ExternalDicomStudyImportRequest request)
//    {
//        return service.importExternal(request.getPACS(), request.getStudy());
//    }
}
