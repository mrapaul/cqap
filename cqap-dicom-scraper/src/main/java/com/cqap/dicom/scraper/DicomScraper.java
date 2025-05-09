package com.cqap.dicom.scraper;

import com.cqap.client.*;
import com.cqap.util.*;
import com.google.common.collect.*;
import com.peirs.datamodel.*;
import com.peirs.datamodel.dicom.*;
import com.peirs.datamodel.hl7.*;
import com.peirs.dicom.*;
import org.apache.commons.io.*;
import org.slf4j.*;

import java.io.*;
import java.util.*;

public class DicomScraper
{
    private static final Logger LOGGER = LoggerFactory.getLogger(DicomScraper.class);
    private final ClientRestService theClientRestService;
    private final Set<String> theParsedFiles;
    private List<Institution> theInstitutions;

    public DicomScraper(ClientRestService aClientRestService)
    {
        theClientRestService = aClientRestService;
        theParsedFiles = Sets.newHashSet();
    }

    public void parseFiles(File aDirectory)
    {
        theInstitutions = theClientRestService.findAllInstitutions();
        try
        {
            if (aDirectory.isDirectory())
            {
                for (File myFile : FileUtils.listFiles(aDirectory, null, true))
                {
                    String myAbsolutePath = myFile.getAbsolutePath();
                    if (!theParsedFiles.contains(myAbsolutePath))
                    {
                        parseFile(myFile);
                        theParsedFiles.add(myAbsolutePath);
                    }
                }
            }
            else
            {
                parseFile(aDirectory);
            }

        }
        catch (Exception aException)
        {
            LOGGER.error("Error parsing images", aException);
        }
    }

    private void parseFile(File myFile)
    {
        LOGGER.info("Parsing " + myFile.getAbsolutePath());
        try
        {
            DicomParser myParser = new DicomParser();
            DicomImage myImage = myParser.parse(myFile);
            storeImage(myImage);
        }
        catch (Exception e)
        {
            LOGGER.error("Error parsing dicom image " + myFile.getPath(), e);
        }
    }

    private void storeImage(DicomImage aImage)
    {
        if (aImage != null && aImage.getStudyInstanceUID() != null)
        {
            LOGGER.info("Image parsed successfully with {} tags", aImage.getTags().size());
            List<DicomStudy> myStudies =
                    theClientRestService.findDicomStudiesByStudyInstanceUID(aImage.getStudyInstanceUID());
            if (!myStudies.isEmpty())
            {
                updateExistingStudy(aImage, myStudies);
            }
            else
            {
                createNewStudy(aImage);
            }
        }
    }

    private void createNewStudy(DicomImage aImage)
    {
        List<DicomStudy> myCreatedStudies = toStudies(aImage);
        for (DicomStudy myDicomStudy : myCreatedStudies)
        {
            if (myDicomStudy.getTags() != null && myDicomStudy.getTags().size() > 0)
            {
                LOGGER.info("Creating study with UID {}", myDicomStudy.getStudyInstanceUID());
                theClientRestService.createOrUpdateDicomStudy(myDicomStudy);
            }
        }
    }

    private void updateExistingStudy(DicomImage aImage, List<DicomStudy> aStudies)
    {
        for (DicomStudy myStudy : aStudies)
        {
            LOGGER.info("Updating study with UID {}", myStudy.getStudyInstanceUID());
            if (aImage.getTags().size() != myStudy.getTags().size())
            {
                myStudy.setTags(getUniqueTags(aImage, myStudy));
            }
            String mySeriesInstanceUID = aImage.getSeriesInstanceUID();
            if (!myStudy.getSeriesInstanceUIDs().contains(mySeriesInstanceUID))
            {
                myStudy.getSeriesInstanceUIDs().add(mySeriesInstanceUID);
                myStudy.setImageCount(myStudy.getImageCount() + 1);
            }
            theClientRestService.createOrUpdateDicomStudy(myStudy);
        }
    }

    private Sets.SetView<DicomTag> getUniqueTags(DicomImage aImage, DicomStudy myStudy)
    {
        return Sets.symmetricDifference(Sets.newHashSet(aImage.getTags()), Sets.newHashSet(myStudy.getTags()));
    }

    private List<DicomStudy> toStudies(DicomImage... aImages)
    {
        List<DicomStudy> myStudies = Lists.newArrayList();
        Multimap<String, DicomImage> myImages = HashMultimap.create();

        for (DicomImage myImage : aImages)
        {
            String myStudyInstanceUID = myImage.getStudyInstanceUID();
            if (myImage.getTags().size() > 1 && myStudyInstanceUID != null)
            {
                myImages.put(myStudyInstanceUID, myImage);
            }
            else
            {
                LOGGER.error("No StudyInstanceUID tag found for image for patient : " + myImage.getPatientName());
            }
        }

        for (String myStudyId : myImages.keySet())
        {
            DicomStudy myStudy = new DicomStudy();
            myStudy.setImages(myImages.get(myStudyId));
            myStudy.setInstitution(InstitutionFinder.findInstitution(myStudy.getInstitutions(),
                    new ArrayList<HL7>(),
                    theInstitutions));
            myStudies.add(myStudy);
        }

        return myStudies;
    }
}
