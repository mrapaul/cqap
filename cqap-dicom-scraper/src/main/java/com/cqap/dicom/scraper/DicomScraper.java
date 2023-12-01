package com.cqap.dicom.scraper;

import com.cqap.client.ClientRestService;
import com.cqap.util.InstitutionFinder;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import com.google.common.collect.Sets;
import com.peirs.datamodel.Institution;
import com.peirs.datamodel.dicom.DicomImage;
import com.peirs.datamodel.dicom.DicomStudy;
import com.peirs.datamodel.dicom.DicomTag;
import com.peirs.datamodel.hl7.HL7;
import com.peirs.dicom.DicomParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class DicomScraper {
    private static final Logger LOGGER = LoggerFactory.getLogger(DicomScraper.class);
    private final ClientRestService theClientRestService;
    private final Set<String> theParsedFiles;
    private List<Institution> theInstitutions;

    @Autowired
    public DicomScraper(ClientRestService aClientRestService) {
        theClientRestService = aClientRestService;
        theParsedFiles = new HashSet<>();
    }

    public void parseFiles(File aDirectory) {
        theInstitutions = theClientRestService.findAllInstitutions();
        LOGGER.info("Parsing files in directory {}", aDirectory.getAbsolutePath());
        LOGGER.info("Found {} institutions", theInstitutions.size());
        try {
            Files.walkFileTree(aDirectory.toPath(), new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    File currentFile = file.toFile();
                    LOGGER.info("Found file: {}", currentFile.getAbsolutePath());
                    String absolutePath = currentFile.getAbsolutePath();
                    if (!theParsedFiles.contains(absolutePath)) {
                        parseFile(currentFile);
                        theParsedFiles.add(absolutePath);
                    }
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult visitFileFailed(Path file, IOException exc) {
                    LOGGER.error("Error visiting file: {}", file, exc);
                    return FileVisitResult.CONTINUE;
                }
            });
        } catch (Exception e) {
            LOGGER.error("Error parsing images in directory: {}", aDirectory.getAbsolutePath(), e);
        }
    }


    private void parseFile(File myFile) {
        long fileSizeMb = fileLength(myFile);
        if (fileSizeMb > 5L) {
            LOGGER.error("Skipping file {} because it is larger than 5MB", myFile.getAbsolutePath());
            return;
        }

        LOGGER.info("Parsing file: {}", myFile.getAbsolutePath());
        try {
            DicomParser myParser = new DicomParser();
            DicomImage myImage = myParser.parse(myFile);
            if (myImage != null) {
                storeImage(myImage);
            } else {
                LOGGER.warn("No image parsed from file: {}", myFile.getAbsolutePath());
            }
        } catch (Exception e) {
            LOGGER.error("Error parsing DICOM image: {}", myFile.getPath(), e);
        }
    }


    private long fileLength(File aFile) {
        long sizeInBytes = aFile.length();
        long sizeInMb = sizeInBytes / (1024 * 1024);

        return sizeInMb;
    }

    private void storeImage(DicomImage aImage) {
        if (aImage != null && aImage.getStudyInstanceUID() != null) {
            LOGGER.info("Image parsed successfully with {} tags", aImage.getTags().size());
            List<DicomStudy> myStudies =
                    theClientRestService.findDicomStudiesByStudyInstanceUID(aImage.getStudyInstanceUID());
            if (!myStudies.isEmpty()) {
                try {
                    LOGGER.info("Updating existing study");
                    updateExistingStudy(aImage, myStudies);
                } catch (Exception e) {
                    LOGGER.error("Error updating existing study", e);
                }
            } else {
                try {
                    LOGGER.info("Creating new study");
                    createNewStudy(aImage);
                } catch (Exception e) {
                    LOGGER.error("Error creating new study", e);
                }
            }
        }
    }

    private void createNewStudy(DicomImage aImage) {
        List<DicomStudy> myCreatedStudies = toStudies(aImage);
        for (DicomStudy myDicomStudy : myCreatedStudies) {
            if (myDicomStudy.getTags() != null && myDicomStudy.getTags().size() > 0) {
                LOGGER.info("Creating study with UID {}", myDicomStudy.getStudyInstanceUID());
                theClientRestService.createOrUpdateDicomStudy(myDicomStudy);
                LOGGER.info("Created study with UID {}", myDicomStudy.getStudyInstanceUID());
            }
        }
    }

    private void updateExistingStudy(DicomImage aImage, List<DicomStudy> aStudies) {
        for (DicomStudy myStudy : aStudies) {
            LOGGER.info("Updating study with UID {}", myStudy.getStudyInstanceUID());
            if (aImage.getTags().size() != myStudy.getTags().size()) {
                myStudy.setTags(getUniqueTags(aImage, myStudy));
            }
            String mySeriesInstanceUID = aImage.getSeriesInstanceUID();
            if (!myStudy.getSeriesInstanceUIDs().contains(mySeriesInstanceUID)) {
                myStudy.getSeriesInstanceUIDs().add(mySeriesInstanceUID);
                myStudy.setImageCount(myStudy.getImageCount() + 1);
            }
            theClientRestService.createOrUpdateDicomStudy(myStudy);
        }
    }

    private Sets.SetView<DicomTag> getUniqueTags(DicomImage aImage, DicomStudy myStudy) {
        return Sets.symmetricDifference(Sets.newHashSet(aImage.getTags()), Sets.newHashSet(myStudy.getTags()));
    }

    private List<DicomStudy> toStudies(DicomImage... aImages) {
        List<DicomStudy> myStudies = Lists.newArrayList();
        Multimap<String, DicomImage> myImages = HashMultimap.create();

        for (DicomImage myImage : aImages) {
            String myStudyInstanceUID = myImage.getStudyInstanceUID();
            if (myImage.getTags().size() > 1 && myStudyInstanceUID != null) {
                myImages.put(myStudyInstanceUID, myImage);
            } else {
                LOGGER.error("No StudyInstanceUID tag found for image for patient : " + myImage.getPatientName());
            }
        }

        for (String myStudyId : myImages.keySet()) {
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
