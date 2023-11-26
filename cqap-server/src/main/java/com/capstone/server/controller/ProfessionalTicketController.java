package com.capstone.server.controller;

import com.peirs.datamodel.ticket.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProfessionalTicketController
{
    private final ProfessionalTicketService theTicketService;

    @Autowired
    public ProfessionalTicketController(@Qualifier("ProfessionalTicketService") ProfessionalTicketService aTicketService)
    {
        theTicketService = aTicketService;
    }

    @RequestMapping("/professionalTickets/findAll")
    public @ResponseBody ProfessionalTickets findAll()
    {
        return theTicketService.findAllTickets();
    }

    @RequestMapping(value = "/professionalTickets/find", method = RequestMethod.POST)
    public @ResponseBody TicketQueryResults find(@RequestBody TicketQuery aQuery)
    {
        return theTicketService.findTickets(aQuery);
    }

    @RequestMapping("/professionalTickets/findOne")
    public @ResponseBody ProfessionalTicket findOne(@RequestParam("ticketId") String aTicketId)
    {
        return theTicketService.findOne(aTicketId);
    }

    @RequestMapping(value = "professionalTickets/createOrUpdate", method = RequestMethod.POST)
    public @ResponseBody ProfessionalTicket createOrUpdate(@RequestBody ProfessionalTicket aTicket)
    {
        return theTicketService.createOrUpdate(aTicket, false);
    }

    @RequestMapping(value = "professionalTickets/delete", method = RequestMethod.POST)
    public @ResponseBody void delete(@RequestBody ProfessionalTicket aTicket)
    {
        theTicketService.delete(aTicket);
    }

    @RequestMapping(value = "professionalTickets/create", method = RequestMethod.POST)
    public @ResponseBody String create(@RequestBody CreateTicketRequests aRequests)
    {
        return theTicketService.create(aRequests);
    }

    @RequestMapping(value = "professionalTickets/createCorresponding", method = RequestMethod.POST)
    public @ResponseBody ProfessionalTicket createCorrespondingTicket(@RequestParam("ticketId") String aTicketId,
                                                                      @RequestParam("userId") String aUserId)
    {
        return theTicketService.createCorresponding(aTicketId, aUserId);
    }
}
