package com.capstone.server.controller;

import com.peirs.datamodel.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@Controller
public class HealthcareSegmentController
{
    private final HealthcareSegmentService theService;

    @Autowired
    public HealthcareSegmentController(@Qualifier("HealthcareSegmentService") HealthcareSegmentService aService)
    {
        theService = aService;
    }

    @RequestMapping("/healthcareSegment/findAll")
    public @ResponseBody HealthcareSegments findAll()
    {
        return theService.findAll();
    }
}
