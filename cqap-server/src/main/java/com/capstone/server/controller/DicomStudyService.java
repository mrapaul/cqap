package com.capstone.server.controller;

import com.cqap.util.*;
import com.google.common.collect.*;
import com.peirs.datamodel.*;
import com.peirs.datamodel.dicom.*;
import com.peirs.datamodel.hl7.*;
import com.peirs.datamodel.ticket.*;
import com.peirs.dicom.*;
import org.bson.types.*;
import org.dcm4che2.data.*;
import org.dcm4che2.io.*;
import org.jetbrains.annotations.*;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.data.mongodb.core.*;
import org.springframework.data.mongodb.core.query.*;
import org.springframework.stereotype.*;

import java.io.*;
import java.text.*;
import java.util.*;

import static ch.lambdaj.Lambda.*;
import static ch.lambdaj.collection.LambdaCollections.*;
import static com.cqap.util.DicomStudyTagValueFinder.*;
import static org.apache.commons.lang.StringUtils.*;

@Service("DicomStudyService")
public class DicomStudyService
{
    private static final Logger LOGGER = LoggerFactory.getLogger(DicomStudyService.class);
    private static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyMMdd");
    private static final DateFormat STUDY_DATE_FORMAT = new SimpleDateFormat("yyyyMMdd");
    @Autowired private DicomStudyRepository theRepository;
    @Autowired private InstitutionRepository theInstitutionRepository;
    @Autowired private UserRepository theUserRepository;
    @Autowired private HL7Service theHL7Service;
    @Autowired private MongoTemplate theMongoTemplate;

    public DicomStudy createOrUpdate(DicomStudy aStudy)
    {
        try {
            return theRepository.save(aStudy);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(DicomStudy aStudy)
    {
        theRepository.delete(aStudy);
    }

    public DicomStudies findAllStudies()
    {
        return new DicomStudies(theRepository.findAll());
    }

    public Iterable<DicomStudy> findStudies(List<String> aIds)
    {
        List<ObjectId> myIds = new ArrayList<>();
        for (String myId : aIds)
        {
            myIds.add(new ObjectId(myId));
        }
        return theRepository.findAllById(myIds);
    }

    public DicomStudyQueryResults findStudies(DicomStudyQuery aQuery)
    {
        LOGGER.debug("Querying dicom studies");

        List<DicomStudyQueryResult> myResults = Lists.newArrayList();
        try
        {
            List<DicomStudy> myStudies = searchStudies(aQuery);
            Query myQuery = new Query(Criteria.where("theStudy").in(myStudies));
            List<ProfessionalTicket> myProfessionalTickets = theMongoTemplate.find(myQuery, ProfessionalTicket.class);
            HashMultimap<String, ProfessionalTicket> myTicketsByStudy = HashMultimap.create();
            for (ProfessionalTicket myProfessionalTicket : myProfessionalTickets)
            {
                myTicketsByStudy.put(myProfessionalTicket.getStudy().getId(), myProfessionalTicket);
            }

            for (DicomStudy myStudy : myStudies)
            {
                Set<ProfessionalTicket> myTickets = myTicketsByStudy.get(myStudy.getId());
                List<String> myTicketIds = Lists.newArrayList();
                List<TicketType> myTicketTypes = Lists.newArrayList();
                for (ProfessionalTicket myTicket : myTickets)
                {
                    if (!myTicket.isDeleted())
                    {
                        myTicketIds.add(myTicket.getViewId());
                        myTicketTypes.add(myTicket.getType());
                    }
                }
                myResults.add(new DicomStudyQueryResult(myStudy, myTicketIds, myTicketTypes));
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return new DicomStudyQueryResults(myResults);
    }

    public DicomStudies findStudiesForTickets(DicomStudyQuery aQuery)
    {
        return new DicomStudies(searchStudies(aQuery));
    }

    private List<DicomStudy> searchStudies(DicomStudyQuery aQuery)
    {
        List<DicomStudy> myDicomStudies = Lists.newArrayList();

        myDicomStudies.addAll(theMongoTemplate.find(createQuery(aQuery), DicomStudy.class));
        String myQueriedPIR = aQuery.getIIR();
        String myCPTCode = aQuery.getCPTCode();

        List<DicomStudy> myFilteredStudies =
                isEmpty(myQueriedPIR) ? myDicomStudies : filterByPIR(myDicomStudies, myQueriedPIR);
        return isEmpty(myCPTCode) ? myFilteredStudies : filterByCPTCode(myFilteredStudies, myCPTCode);
    }

    private List<DicomStudy> filterByCPTCode(List<DicomStudy> aDicomStudies, String aCPTCode)
    {
        List<DicomStudy> myFilteredDicomStudies = new ArrayList<>();
        for (DicomStudy myDicomStudy : aDicomStudies)
        {
            HL7Messages myHL7Messages = theHL7Service.findMessagesForStudy(myDicomStudy);
            String myCPTCode = HL7DataFinder.findCPTCode(myHL7Messages.getMessages());

            if (myCPTCode != null && aCPTCode.equalsIgnoreCase(myCPTCode))
            {
                myFilteredDicomStudies.add(myDicomStudy);
            }
        }
        return myFilteredDicomStudies;
    }

    private List<DicomStudy> filterByPIR(List<DicomStudy> aDicomStudies, String aQueriedPIR)
    {
        List<DicomStudy> myFilteredDicomStudies = new ArrayList<>();
        User myUser = theUserRepository.findByTheName(aQueriedPIR);
        if (myUser != null && myUser.getAlias() != null)
        {
            List<String> myAliases = Arrays.asList(myUser.getAlias().split(","));
            for (DicomStudy myDicomStudy : aDicomStudies)
            {
                HL7Messages myHL7Messages = theHL7Service.findMessagesForStudy(myDicomStudy);
                String myPIR = !myHL7Messages.getMessages().isEmpty() ?
                        HL7DataFinder.findPIR(myHL7Messages.getMessages()) :
                        findValue(myDicomStudy, Tag.InterpretationAuthor);

                if (myPIR != null && myAliases.contains(myPIR))
                {
                    myFilteredDicomStudies.add(myDicomStudy);
                }
            }
        }
        return myFilteredDicomStudies;
    }

    private Query createQuery(DicomStudyQuery aQuery)
    {
        Query myQuery = new Query();
        myQuery.fields().exclude("theTags");

        boolean myFirstNamePresent = isNotEmpty(aQuery.getPatientFirstName());
        boolean myLastNamePresent = isNotEmpty(aQuery.getPatientLastName());
        if (myFirstNamePresent || myLastNamePresent)
        {
            StringBuilder myBuilder = new StringBuilder();
            if (myLastNamePresent && !myFirstNamePresent)
            {
                myBuilder.append("^").append(aQuery.getPatientLastName()).append(".*");
            }
            else if (!myLastNamePresent)
            {
                myBuilder.append("^\\w*.").append(aQuery.getPatientFirstName()).append(".*");
            }
            else
            {
                myBuilder.append("^")
                        .append(aQuery.getPatientLastName())
                        .append(".*")
                        .append(aQuery.getPatientFirstName());
            }

            myQuery.addCriteria(Criteria.where("thePatientName").regex(myBuilder.toString(), "i"));
        }

        if (isNotEmpty(aQuery.getAccessionNumber()))
        {
            myQuery.addCriteria(Criteria.where("theAccessionNumber")
                    .regex("^" + aQuery.getAccessionNumber(), "i"));
        }

        if (aQuery.getGroup() != null)
        {
            List<Institution> myInstitutions = theInstitutionRepository.findByTheGroup(aQuery.getGroup());
            myQuery.addCriteria(Criteria.where("theStudyInstitution").in(myInstitutions));
        }

        if (aQuery.getInstitution() != null)
        {
            myQuery.addCriteria(Criteria.where("theStudyInstitution").is(aQuery.getInstitution()));
        }

        String myInstitutionAlias = aQuery.getInstitutionAlias();
        if (isNotEmpty(myInstitutionAlias))
        {
            List<String> myAliases = getAliases(myInstitutionAlias);
            myQuery.addCriteria(Criteria.where("theInstitutions").in(myAliases));
        }

        if (aQuery.getModalities() != null && !aQuery.getModalities().isEmpty())
        {
            List<String> myModalities = Lists.newArrayList();
            for (String myModality : aQuery.getModalities())
            {
                myModalities.addAll(!myModality.contains("/") ?
                        Arrays.asList(myModality) :
                        Arrays.asList(myModality.split("/")));
            }
            myQuery.addCriteria(Criteria.where("theModality").in(myModalities));
        }

        if (isNotEmpty(aQuery.getStudyDescription()))
        {
            myQuery.addCriteria(Criteria.where("theStudyDescription")
                    .regex("\\b" + aQuery.getStudyDescription() + "\\b", "i"));
        }

        if (isNotEmpty(aQuery.getPatientID()))
        {
            myQuery.addCriteria(Criteria.where("thePatientID").regex("^" + aQuery.getPatientID(), "i"));
        }

        if (isNotEmpty(aQuery.getSiteTechnologist()))
        {
            myQuery.addCriteria(Criteria.where("theOperatorName")
                    .regex("\\b" + aQuery.getSiteTechnologist() + "\\b", "i"));
        }


        if (isNotEmpty(aQuery.getStudyDate()))
        {
            myQuery.addCriteria(Criteria.where("theStudyDate").is(aQuery.getStudyDate()));
        }
        else
        {
            String studyBeginDate = aQuery.getStudyBeginDate();
            String studyEndDate = aQuery.getStudyEndDate();

            if (studyBeginDate != null && studyEndDate == null)
            {
                myQuery.addCriteria(Criteria.where("theStudyDate").gte(studyBeginDate));
            }
            else if (studyBeginDate == null && studyEndDate != null)
            {
                myQuery.addCriteria(Criteria.where("theStudyDate").lte(studyEndDate));
            }
            else if (studyBeginDate != null)
            {
                myQuery.addCriteria(Criteria.where("theStudyDate").gte(studyBeginDate).lte(studyEndDate));
            }
        }


        LOGGER.debug("Querying dicom studies : " + myQuery);
        return myQuery;
    }

    private List<String> getAliases(String aInstitutionAlias)
    {
        List<String> aliases = Lists.newArrayList();
        if (aInstitutionAlias.contains(","))
        {
            aliases.addAll(Lists.newArrayList(aInstitutionAlias.split(",")));
        }
        else
        {
            aliases.add(aInstitutionAlias);
        }
        return aliases;
    }

    public DicomStudy findOne(String aId)
    {
        return theRepository.findById(new ObjectId(aId)).orElseThrow();
    }

    public DicomStudies findByStudyInstanceUID(String aStudyInstanceUID)
    {
        return new DicomStudies(theRepository.findByTheStudyInstanceUID(aStudyInstanceUID));
    }

    //testing
    public void setMongoTemplate(MongoTemplate aMongoTemplate)
    {
        theMongoTemplate = aMongoTemplate;
    }

    public void processImage(Object aImage)
    {
        File myFile = (File) aImage;
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

    public List<DicomStudy> processImage(DicomInputStream aInputStream)
    {
        LOGGER.info("Parsing Dicom input stream");
        try
        {
            DicomParser myParser = new DicomParser();
            DicomImage myImage = myParser.parse(aInputStream);
            return storeImage(myImage);
        }
        catch (Exception e)
        {
            LOGGER.error("Error parsing dicom input stream ", e);
        }
        return Lists.newArrayList();
    }

    public List<DicomStudy> processImage(DicomObject object)
    {
        try
        {
            DicomParser myParser = new DicomParser();
            DicomImage myImage = new DicomImage();
            myParser.parseFields(myImage, object);
            return storeImage(myImage);
        }
        catch (Exception e)
        {
            LOGGER.error("Error parsing dicom input stream ", e);
        }
        return Lists.newArrayList();
    }

    private List<DicomStudy> storeImage(DicomImage aImage)
    {
        if (aImage != null && aImage.getStudyInstanceUID() != null)
        {
            LOGGER.info("Image parsed successfully with {} tags", aImage.getTags().size());
            List<DicomStudy> myStudies = findByStudyInstanceUID(aImage.getStudyInstanceUID()).getStudies();
            if (!myStudies.isEmpty())
            {
                return updateExistingStudy(aImage, myStudies);
            }
            else
            {
                return createNewStudy(aImage);
            }
        }
        return Lists.newArrayList();
    }

    private List<DicomStudy> createNewStudy(DicomImage aImage)
    {
        List<DicomStudy> studiesToCreate = toStudies(aImage);
        List<DicomStudy> createdStudies = Lists.newArrayList();
        for (DicomStudy myDicomStudy : studiesToCreate)
        {
            if (myDicomStudy.getTags() != null && myDicomStudy.getTags().size() > 0)
            {
                LOGGER.info("Creating study with UID {}", myDicomStudy.getStudyInstanceUID());
                createdStudies.add(createOrUpdate(myDicomStudy));
            }
        }

        return createdStudies;
    }

    private List<DicomStudy> updateExistingStudy(DicomImage aImage, List<DicomStudy> aStudies)
    {
        List<DicomStudy> updatedStudies = Lists.newArrayList();
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
            updatedStudies.add(createOrUpdate(myStudy));
        }
        return updatedStudies;
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
                    theInstitutionRepository.findAll()));
            myStudies.add(myStudy);
        }

        return myStudies;
    }

    private Sets.SetView<DicomTag> getUniqueTags(DicomImage aImage, DicomStudy myStudy)
    {
        return Sets.symmetricDifference(Sets.newHashSet(aImage.getTags()), Sets.newHashSet(myStudy.getTags()));
    }

    @NotNull DicomStudies findRelatedStudies(DicomStudy study)
    {
//        Calendar calendar = new GregorianCalendar();
//        calendar.add(Calendar.MONTH, -1);
//        Date aMonthAgo = calendar.getTime();
        List<DicomStudy> relatedOrders = Lists.newArrayList();
        try
        {
            String dicomStudyId = study.getId();
            DicomStudy dicomStudy = findOne(dicomStudyId);
            DicomStudyQueryResults studies = findDicomStudies(study);
            for (DicomStudyQueryResult relatedOrderStudy : studies.getResults())
            {
                DicomStudy relatedOrder = findOne(relatedOrderStudy.getStudy().getId());
                String patientBirthDate = relatedOrder.getPatientBirthDate();
                if (birthDateMatches(dicomStudy, patientBirthDate) && !relatedOrder.getId().equals(dicomStudyId))
                {
                    relatedOrders.add(relatedOrder);
                    //                DicomTag dicomTag = DicomTagFinder.find(relatedOrder, Tag.StudyArrivalDate);
                    //                if (dicomTag != null)
                    //                {
                    //                    String arrivalDateStr = dicomTag.getValue();
                    //                    if (arrivalDateStr != null && arrivalDateStr.length() == 6)
                    //                    {
                    //                        try
                    //                        {
                    //                            Date arrivalDate = DATE_FORMAT.parse(arrivalDateStr);
                    //                            if (arrivalDate.after(aMonthAgo))
                    //                            {
                    //                                relatedOrders.add(relatedOrder);
                    //                            }
                    //                        }
                    //                        catch (ParseException e)
                    //                        {
                    //                            LOGGER.error("Error parsing arrival date {}", arrivalDateStr, e);
                    //                        }
                    //                    }
                    //                }
                }
            }
        }
        catch (Exception e)
        {
            LOGGER.error("Error finding related studies", e);
        }

        return new DicomStudies(relatedOrders);
    }

    @NotNull
    private DicomStudyQueryResults findDicomStudies(DicomStudy study)
    {
        Set<DicomStudyQueryResult> results = Sets.newHashSet();
        String patientName = study.getPatientName();
        if (patientName != null)
        {
            String[] name = patientName.contains("^") ? patientName.split("\\^") : patientName.split(" ");
            String patientLastName = null;
            String patientFirstName = null;
            if (name.length == 1)
            {
                patientLastName = name[0];
            }

            if (name.length >= 2)
            {
                patientLastName = name[0];
                patientFirstName = name[1];
            }
            DicomStudyQuery dicomStudyQuery = new DicomStudyQueryBuilder().setPatientFirstName(patientFirstName)
                    .setPatientLastName(patientLastName)
                    .build();
            DicomStudyQueryResults studies = findStudies(dicomStudyQuery);
            if (!studies.getResults().isEmpty())
            {
                results.addAll(studies.getResults());
            }
        }

        String patientID = study.getPatientID();
        if (patientID != null)
        {
            DicomStudyQueryResults
                    studies1 =
                    findStudies(new DicomStudyQueryBuilder().setPatientID(patientID).build());
            if (!studies1.getResults().isEmpty())
            {
                results.addAll(studies1.getResults());
            }
        }

        return new DicomStudyQueryResults(Lists.newArrayList(results));
    }

    private boolean birthDateMatches(@NotNull DicomStudy dicomStudy, @Nullable String patientBirthDate)
    {
        return patientBirthDate != null && patientBirthDate.equals(dicomStudy.getPatientBirthDate());
    }
}
