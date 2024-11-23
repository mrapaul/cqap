package com.capstone.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController
public class DicomViewerController
{
    private final DicomViewerService service;

    @Autowired
    public DicomViewerController(@Qualifier("DicomViewerService") DicomViewerService service)
    {
        this.service = service;
    }

    @RequestMapping(value = "dicomViewer/launchURL", method = RequestMethod.POST)
    public @ResponseBody String getLaunchURL(@RequestParam("dicomId") String id,
                                             @RequestParam("username") String username) throws
    Exception
    {
        return service.getLaunchURL(id, username);
    }
}

