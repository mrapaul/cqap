package com.capstone.server.controller;

import com.capstone.server.controller.responses.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

import javax.annotation.*;
import java.util.concurrent.*;

@Controller
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
                aUserId));
    }

    @RequestMapping(value = "/tickets/generateTechERPResponseLetter", method = RequestMethod.POST)
    public @ResponseBody void generateTechERPResponseLetter(@RequestParam("ticketId") String aTicketId,
                                                            @RequestParam("userId") String aUserId)
    {
        theExecutorService.execute(new TechERPCompletedResponseLetterGenerator(theTicketRepository,
                theUserRepository,
                theStorageService,
                aTicketId,
                aUserId));
    }

    @RequestMapping(value = "/tickets/generateERPSiteCallLetter", method = RequestMethod.POST)
    public @ResponseBody void generateERPSiteCallLetter(@RequestParam("ticketId") String aTicketId,
                                                        @RequestParam("userId") String aUserId)
    {
        theExecutorService.execute(new ERPSiteCallResponseLetterGenerator(theTicketRepository,
                theUserRepository,
                theStorageService,
                aTicketId,
                aUserId));
    }

    @RequestMapping(value = "/tickets/generateCMOSiteCallLetter", method = RequestMethod.POST)
    public @ResponseBody void generateCMOSiteCallLetter(@RequestParam("ticketId") String aTicketId,
                                                        @RequestParam("userId") String aUserId)
    {
        theExecutorService.execute(new CMOSiteCallResponseLetterGenerator(theTicketRepository,
                theUserRepository,
                theStorageService,
                aTicketId,
                aUserId));
    }

    @RequestMapping(value = "/tickets/generateCMOResponseLetter", method = RequestMethod.POST)
    public @ResponseBody void generateCMOResponseLetter(@RequestParam("ticketId") String aTicketId,
                                                        @RequestParam("userId") String aUserId)
    {
        theExecutorService.execute(new CMOCompletedResponseLetterGenerator(theTicketRepository,
                theUserRepository,
                theStorageService,
                aTicketId,
                aUserId));
    }

    @PreDestroy
    public void preDestroy()
    {
        theExecutorService.shutdown();
    }
}
