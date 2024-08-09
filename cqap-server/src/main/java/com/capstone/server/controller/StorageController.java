package com.capstone.server.controller;

import com.itextpdf.text.pdf.*;
import com.itextpdf.text.pdf.parser.*;
import com.peirs.datamodel.attachments.*;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.core.io.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.*;

import java.io.*;

@Controller
public class StorageController
{
    private static final Logger LOGGER = LoggerFactory.getLogger(StorageController.class);
    @Autowired private StorageService theStorageService;

    @RequestMapping(value = "/tickets/uploadAttachment", method = RequestMethod.POST)
    public @ResponseBody String handleFileUpload(@RequestParam("ticketId") String aTicketId,
                                                 @RequestParam("file") MultipartFile file)
    {
        LOGGER.info("Storing attachment for ticket {}", aTicketId);
        try
        {
            theStorageService.storeAttachment(aTicketId, file.getOriginalFilename(), file.getBytes());
        }
        catch (IOException e)
        {
            return e.getMessage();
        }

        return Boolean.TRUE.toString();
    }

    @RequestMapping(value = "/dicomStudy/uploadPatientReport", method = RequestMethod.POST)
    public @ResponseBody String storePatientReport(@RequestParam("studyId") String aStudyId,
                                                   @RequestParam("file") MultipartFile file)
    {
        LOGGER.info("Storing patient report for study {}", aStudyId);
        StringBuilder myReportBuilder = new StringBuilder();
        try
        {
            byte[] myBytes = file.getBytes();
            theStorageService.storePatientReport(aStudyId, file.getOriginalFilename(), myBytes);
            PdfReader myReader = new PdfReader(myBytes);
            for (int i = 1; i < myReader.getNumberOfPages() + 1; i++)
            {
                myReportBuilder.append(PdfTextExtractor.getTextFromPage(myReader, i)).append("\n\n");
            }
        }
        catch (IOException e)
        {
            return e.getMessage();
        }
        String myReport = myReportBuilder.toString().trim();
        LOGGER.info("Parsed report of length {}", myReport.length());

        if (myReport.trim().length() == 0)
        {
            myReport = "See attachments tab for patient report";
        }

        return myReport;
    }

    @RequestMapping("/tickets/getAttachmentNames")
    public @ResponseBody Attachments getAttachmentNames(@RequestParam("ticketId") String aTicketId,
                                                        @RequestParam("studyId") String aStudyId)
    {
        return new Attachments(theStorageService.getAttachmentNames(aTicketId, aStudyId));
    }

    @RequestMapping("/tickets/getAttachment")
    public @ResponseBody FileSystemResource getAttachment(@RequestParam("id") String aId)
    {
        return new FileSystemResource(theStorageService.getAttachment(aId));
    }

    @RequestMapping("/tickets/deleteAttachment")
    public @ResponseBody void deleteAttachment(@RequestParam("id") String aId)
    {
        theStorageService.deleteAttachment(aId);
    }
}
