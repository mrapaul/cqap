package com.capstone.server.controller;

import com.peirs.datamodel.dicom.*;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

@Component("DicomViewerService")
public class DicomViewerService
{
    private static final Logger LOGGER = LoggerFactory.getLogger(DicomViewerService.class);
    private final DicomStudyService dicomService;
    private final DicomViewer dicomViewer;

    @Autowired
    public DicomViewerService(@Qualifier("DicomStudyService") DicomStudyService dicomService,
                              @Qualifier("DicomViewer") DicomViewer dicomViewer)
    {
        this.dicomService = dicomService;
        this.dicomViewer = dicomViewer;
    }

    public String getLaunchURL(String id,
                               String username) throws Exception
    {
        try
        {
            DicomStudy imageDetails = dicomService.findOne(id);
            if (imageDetails != null)
            {
                return dicomViewer.getSignedURL(username, imageDetails.getStudyInstanceUID());
            }
        }
        catch (Exception e)
        {
            LOGGER.error("Error getting viewer URL", e);
        }

        return null;
    }
}

