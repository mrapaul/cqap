package com.capstone.server.controller;

import com.peirs.datamodel.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

@Component("HealthcareSegmentService")
public class HealthcareSegmentService
{
    @Autowired private HealthcareSegmentRepository theRepository;

    public HealthcareSegments findAll()
    {
        return new HealthcareSegments(theRepository.findAll());
    }
}
