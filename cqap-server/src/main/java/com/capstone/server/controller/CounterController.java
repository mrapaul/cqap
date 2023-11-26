package com.capstone.server.controller;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@RestController
public class CounterController
{
    private final CounterService theService;

    @Autowired
    public CounterController(@Qualifier("CounterService") CounterService aService)
    {
        theService = aService;
    }

    @RequestMapping(value = "/ticket/nextProfessionalTicketSequence", method = RequestMethod.GET)
    public @ResponseBody Long getNextProfessionalTicketId()
    {
        return theService.getNextUserIdSequence();
    }
}
