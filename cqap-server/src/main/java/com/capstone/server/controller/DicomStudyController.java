package com.capstone.server.controller;

import com.peirs.datamodel.dicom.*;
import org.apache.commons.io.*;
import org.dcm4che2.io.*;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.*;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

@RestController
public class DicomStudyController
{
    private static final Logger LOGGER = LoggerFactory.getLogger(DicomStudyController.class);
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

    @RequestMapping(value = "dicomStudy/processImageMultipart", method = RequestMethod.POST)
    public @ResponseBody void processImage(@RequestBody MultipartFile aMultipartFile)
    {
        if (aMultipartFile != null)
        {
            theService.processImage(aMultipartFile);
        }
    }

    @RequestMapping(value = "dicomStudy/processImage", method = RequestMethod.POST)
    public @ResponseBody void processImage(HttpServletRequest aRequest, HttpServletResponse aResponse)
    {
        try
        {
            Collection<Part> myParts = aRequest.getParts();
            Part filePart = myParts.iterator().next();
            InputStream myInputStream = null;
            try
            {
                myInputStream = filePart.getInputStream();
                byte[] myBytes = IOUtils.toByteArray(myInputStream);

                theService.processImage(new DicomInputStream(new ByteArrayInputStream(myBytes)));
            }
            catch (Exception anException)
            {
                anException.printStackTrace();
            }
            finally
            {
                if (myInputStream != null)
                {
                    myInputStream.close();
                }
            }
        }
        catch (IOException | ServletException anException)
        {
            LOGGER.error("Error parsing image", anException);
        }
    }

    @RequestMapping(value = "dicomStudy/test", method = RequestMethod.POST)
    public @ResponseBody void test()
    {
        System.out.println("CALLED TEST METHOD");
    }

    @RequestMapping(value = "dicomStudy/findRelatedStudies", method = RequestMethod.POST)
    public @ResponseBody DicomStudies findRelatedStudies(@RequestBody DicomStudy study)
    {
        return theService.findRelatedStudies(study);
    }
}
