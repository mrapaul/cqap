package com.capstone.server.controller;

import org.jetbrains.annotations.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@RestController
public class DicomViewerController
{
    @NotNull private final DicomViewerService service;

    @Autowired
    public DicomViewerController(@NotNull @Qualifier("DicomViewerService") DicomViewerService service)
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

