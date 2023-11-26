package com.capstone.server.controller;

import com.capstone.server.controller.responses.*;
import com.peirs.datamodel.*;
import com.peirs.datamodel.ticket.*;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

import javax.annotation.*;
import java.util.concurrent.*;

@RestController
public class ReportController
{
    @Autowired private ProfessionalTicketRepository theTicketRepository;
    @Autowired private UserRepository theUserRepository;
    @Autowired private StorageService theStorageService;
    private ExecutorService theExecutorService;

    public ReportController()
    {
        theExecutorService = Executors.newCachedThreadPool();
    }

    @RequestMapping(value = "/tickets/generateERPResponseLetter", method = RequestMethod.POST)
    public @ResponseBody void generateERPResponseLetter(@RequestParam("ticketId") String aTicketId,
                                                        @RequestParam("userId") String aUserId)
    {
        theExecutorService.execute(new ERPCompletedResponseLetterGenerator(theTicketRepository,
                theUserRepository,
                theStorageService,
                aTicketId,
                aUserId,
                true,
                null));
    }

    @RequestMapping(value = "/tickets/generateTechERPResponseLetter", method = RequestMethod.POST)
    public @ResponseBody void generateTechERPResponseLetter(@RequestParam("ticketId") String aTicketId,
                                                            @RequestParam("userId") String aUserId)
    {
        theExecutorService.execute(new TechERPCompletedResponseLetterGenerator(theTicketRepository,
                theUserRepository,
                theStorageService,
                aTicketId,
                aUserId,
                true,
                null));
    }

    @RequestMapping(value = "/tickets/generateERPSiteCallLetter", method = RequestMethod.POST)
    public @ResponseBody void generateERPSiteCallLetter(@RequestParam("ticketId") String aTicketId,
                                                        @RequestParam("userId") String aUserId)
    {
        theExecutorService.execute(new ERPSiteCallResponseLetterGenerator(theTicketRepository,
                theUserRepository,
                theStorageService,
                aTicketId,
                aUserId,
                true,
                null));
    }

    @RequestMapping(value = "/tickets/generateCMOSiteCallLetter", method = RequestMethod.POST)
    public @ResponseBody void generateCMOSiteCallLetter(@RequestParam("ticketId") String aTicketId,
                                                        @RequestParam("userId") String aUserId)
    {
        theExecutorService.execute(new CMOSiteCallResponseLetterGenerator(theTicketRepository,
                theUserRepository,
                theStorageService,
                aTicketId,
                aUserId,
                true,
                null));
    }

    @RequestMapping(value = "/tickets/generateCMOResponseLetter", method = RequestMethod.POST)
    public @ResponseBody void generateCMOResponseLetter(@RequestParam("ticketId") String aTicketId,
                                                        @RequestParam("userId") String aUserId)
    {
        theExecutorService.execute(new CMOCompletedResponseLetterGenerator(theTicketRepository,
                theUserRepository,
                theStorageService,
                aTicketId,
                aUserId,
                true,
                null));
    }

    @RequestMapping(value = "/tickets/resendReports", method = RequestMethod.POST)
    public @ResponseBody void generateCMOResponseLetter(@RequestBody ResendReportRequest resendReportRequest)
    {
        ProfessionalTicket ticket = resendReportRequest.getTicket();
        User user = resendReportRequest.getUser();
        String addresses = resendReportRequest.getAddresses();
        boolean storeAttachment = false;
        String ticketId = ticket.getId();
        String userId = user.getId();

        if (resendReportRequest.isERPReport())
        {
            theExecutorService.execute(new ERPCompletedResponseLetterGenerator(theTicketRepository,
                    theUserRepository,
                    theStorageService,
                    ticketId,
                    userId,
                    storeAttachment,
                    addresses));

        }

        if (resendReportRequest.isERPSiteCallReport())
        {
            theExecutorService.execute(new ERPSiteCallResponseLetterGenerator(theTicketRepository,
                    theUserRepository,
                    theStorageService,
                    ticketId,
                    userId,
                    storeAttachment,
                    addresses));
        }

        if (resendReportRequest.isCMOReport())
        {
            theExecutorService.execute(new CMOCompletedResponseLetterGenerator(theTicketRepository,
                    theUserRepository,
                    theStorageService,
                    ticketId,
                    userId,
                    storeAttachment,
                    addresses));
        }

        if (resendReportRequest.isCMOSiteCallReport())
        {
            theExecutorService.execute(new CMOSiteCallResponseLetterGenerator(theTicketRepository,
                    theUserRepository,
                    theStorageService,
                    ticketId,
                    userId,
                    storeAttachment,
                    addresses));
        }

        if (resendReportRequest.isTechReport())
        {
            theExecutorService.execute(new TechERPCompletedResponseLetterGenerator(theTicketRepository,
                    theUserRepository,
                    theStorageService,
                    ticketId,
                    userId,
                    storeAttachment,
                    addresses));
        }
    }

    @PreDestroy
    public void preDestroy()
    {
        theExecutorService.shutdown();
    }
}
