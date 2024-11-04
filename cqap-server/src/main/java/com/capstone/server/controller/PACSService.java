package com.capstone.server.controller;

import com.google.common.collect.*;
import com.lakeland.ris.ui.datamodel.*;
import com.peirs.datamodel.*;
import com.peirs.datamodel.dicom.*;
import org.dcm4che2.data.*;
import org.jetbrains.annotations.*;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.util.*;

import static ch.lambdaj.collection.LambdaCollections.*;

@Component("PACSService")
public class PACSService
{
    private static final Logger LOGGER = LoggerFactory.getLogger(PACSService.class);
    @Autowired private PACSRepository repository;
    @Autowired private Dcm4cheeStudyFinder dicomStudyFinder;
    @Autowired private DicomStudyService dicomStudyService;

    public PACSs findAll()
    {
        return new PACSs(repository.findAll());
    }

    public PACS createOrUpdate(PACS pacs)
    {
        return repository.save(pacs);
    }

    public void delete(PACS pacs)
    {
        repository.delete(pacs);
    }

    @NotNull
    public ExternalDicomStudies queryExternalStudies(@NotNull ExternalDicomStudyRequest request)
    {
        List<ExternalDicomStudy> studies = Lists.newArrayList();
        PACS pacs = request.getPacs();
        if (pacs != null)
        {
            try
            {
                List<DicomObject> results = dicomStudyFinder.query(pacs, request.getRequestDate());
                if (!results.isEmpty())
                {
                    studies.addAll(with(results).convert(new DicomObjectToExternalDicomStudyConverter()));
                }
            }
            catch (Exception e)
            {
                LOGGER.error("Error querying studies from PACS", e);
            }
        }

        return new ExternalDicomStudies(studies);
    }

    public DicomStudies importExternal(PACS pacs, @NotNull ExternalDicomStudy externalDicomStudy)
    {
        List<DicomStudy> studies = Lists.newArrayList();
        try
        {
            List<DicomObject> objects = dicomStudyFinder.detailedQuery(pacs, externalDicomStudy.getAccessionNumber());
            for (DicomObject object : objects)
            {
//                List<DicomStudy> dicomStudies = dicomStudyService.processImage(object);
//                if (dicomStudies != null)
//                {
//                    studies.addAll(dicomStudies);
//                }
            }
        }
        catch (Exception e)
        {
            LOGGER.error("Error importing external image {}", externalDicomStudy, e);
        }

        return new DicomStudies(studies);
    }
}
