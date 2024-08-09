package com.capstone.server.controller;

import ch.lambdaj.collection.*;
import com.cqap.util.*;
import com.peirs.datamodel.*;
import com.peirs.datamodel.dicom.*;
import com.peirs.datamodel.hl7.*;
import com.peirs.datamodel.ticket.*;
import org.bson.types.*;
import org.hamcrest.*;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.data.domain.*;
import org.springframework.data.mongodb.core.*;
import org.springframework.data.mongodb.core.index.*;
import org.springframework.data.mongodb.core.query.*;
import org.springframework.stereotype.*;

import java.util.*;

import static ch.lambdaj.Lambda.*;
import static ch.lambdaj.collection.LambdaCollections.*;
import static org.apache.commons.lang.StringUtils.*;
import static org.hamcrest.CoreMatchers.*;

@Component("ProfessionalTicketService")
public class ProfessionalTicketService
{
    private static final Logger LOGGER = LoggerFactory.getLogger(ProfessionalTicketService.class);
    private final TicketDifferences theTicketDifferences;
    @Autowired private ProfessionalTicketRepository theTicketRepository;
    @Autowired private UserRepository theUserRepository;
    @Autowired private DicomStudyService theDicomStudyService;
    @Autowired private HL7Service theHL7Service;
    @Autowired private InstitutionService theInstitutionService;
    @Autowired private CounterService theCounterService;
    @Autowired private MongoTemplate theMongoTemplate;

    public ProfessionalTicketService()
    {
        theTicketDifferences = new TicketDifferences();
    }

    public ProfessionalTickets findAllTickets()
    {
        return new ProfessionalTickets(theTicketRepository.findAll());
    }

    public TicketQueryResults findTickets(TicketQuery aSearch)
    {
        List<TicketQueryResult> mySortedTickets = new ArrayList<>();
        LOGGER.info("Querying tickets");
        try
        {
            Query myQuery = createQuery(aSearch);
            if (myQuery != null)
            {
                List<ProfessionalTicket> myProfessionalTickets = theMongoTemplate.find(myQuery,
                        ProfessionalTicket.class);
                LOGGER.info("Selected {} tickets", myProfessionalTickets.size());
                LambdaList<TicketQueryResult> myQueryResults =
                        with(myProfessionalTickets).convert(new TicketQueryResultConverter());
                List<TicketQueryResult>
                        mySort =
                        sort(filter(aSearch, myQueryResults), on(TicketQueryResult.class).getPriority());
                mySortedTickets.addAll(mySort);
            }
        }
        catch (Exception anException)
        {
            LOGGER.error("Error querying tickets", anException);
        }
        return new TicketQueryResults(mySortedTickets);
    }

    private List<TicketQueryResult> filter(TicketQuery aSearch, LambdaList<TicketQueryResult> aTickets)
    {
        final Integer myCategory = aSearch.getCategory();
        if (myCategory != null)
        {
            return new ArrayList<>(with(aTickets).retain(new TicketFilter(myCategory)));
        }
        else
        {
            return aTickets;
        }
    }

    private Query createQuery(TicketQuery aSearch)
    {
        setIndexes();
        Query myQuery = new Query();
        myQuery.with(new Sort(Sort.Direction.DESC, "theSubmittedTime"));
        if (aSearch.isDeleted() != null)
        {
            myQuery.addCriteria(Criteria.where("theDeleted").is(aSearch.isDeleted()));
        }

        String myTicketId = aSearch.getTicketId();
        if (isNotEmpty(myTicketId))
        {
            List<String> myIds = new ArrayList<>();
            if (myTicketId.contains("-"))
            {
                myIds.add(myTicketId);
            }
            else
            {
                for (TicketType myType : TicketType.values())
                {
                    myIds.add(myType + "-" + myTicketId);
                }
            }
            myQuery.addCriteria(Criteria.where("theViewId").in(myIds));

            return myQuery;
        }

        if (isNotEmpty(aSearch.getTicketType()))
        {
            myQuery.addCriteria(Criteria.where("theType").is(aSearch.getTicketType()));
        }

        if (isNotEmpty(aSearch.getTicketPriority()))
        {
            myQuery.addCriteria(Criteria.where("thePriority").is(aSearch.getTicketPriority()));
        }

        if (isNotEmpty(aSearch.getTicketStatus()))
        {
            myQuery.addCriteria(Criteria.where("theStatus").is(aSearch.getTicketStatus()));
        }

        DicomStudyQuery myStudyQuery = createDicomStudyQuery(aSearch);
        if (valid(myStudyQuery))
        {
            List<ObjectId> myStudyIds = getStudies(myStudyQuery);
            if (!myStudyIds.isEmpty())
            {
                myQuery.addCriteria(Criteria.where("theStudy.$id").in(myStudyIds));
            }
            else
            {
                return null;
            }
        }

        if (aSearch.getDateSubmittedFrom() != 0l && aSearch.getDateSubmittedFrom() < aSearch.getDateSubmittedTo())
        {
            Criteria myCriteria = Criteria.where("theSubmittedTime").gte(aSearch.getDateSubmittedFrom());
            if (aSearch.getDateSubmittedTo() != 0l)
            {
                myCriteria.lte(aSearch.getDateSubmittedTo());
            }
            myQuery.addCriteria(myCriteria);
        }

        LOGGER.info("Querying professional tickets {}", myQuery);
        return myQuery;
    }

    private void setIndexes()
    {
        theMongoTemplate.indexOps(ProfessionalTicket.class)
                .ensureIndex(new Index().on("theSubmittedTime", Sort.Direction.DESC));
        theMongoTemplate.indexOps(ProfessionalTicket.class)
                .ensureIndex(new Index().on("thePriority", Sort.Direction.ASC));
        theMongoTemplate.indexOps(ProfessionalTicket.class)
                .ensureIndex(new Index().on("theViewId", Sort.Direction.DESC));
    }

    private List<ObjectId> getStudies(DicomStudyQuery aStudyQuery)
    {
        List<ObjectId> myStudyIds = new ArrayList<>();
        DicomStudies myStudies = theDicomStudyService.findStudiesForTickets(aStudyQuery);
        for (DicomStudy myDicomStudy : myStudies.getStudies())
        {
            myStudyIds.add(new ObjectId(myDicomStudy.getId()));
        }
        return myStudyIds;
    }

    private DicomStudyQuery createDicomStudyQuery(TicketQuery aSearch)
    {
        return new DicomStudyQueryBuilder()
                .setPatientFirstName(aSearch.getPatientFirstName())
                .setPatientLastName(aSearch.getPatientLastName())
                .setAccessionNumber(aSearch.getAccessionNumber())
                .setStudyDate(aSearch.getStudyDate())
                .setModalities(aSearch.getModalities())
                .setStudyDescription(aSearch.getStudyDescription())
                .setSiteTechnologist(aSearch.getSiteTechnologist())
                .setPatientID(aSearch.getPatientID())
                .setInstitution(aSearch.getInstitution())
                .setGroup(aSearch.getGroup())
                .setIIR(aSearch.getIIR())
                .setCPTCode(aSearch.getCPTCode())
                .build();
    }

    private boolean valid(DicomStudyQuery aQuery)
    {
        return !(aQuery.getPatientFirstName() == null &&
                aQuery.getPatientLastName() == null &&
                aQuery.getAccessionNumber() == null &&
                aQuery.getStudyDate() == null &&
                aQuery.getModalities().isEmpty() &&
                aQuery.getStudyDescription() == null &&
                aQuery.getSiteTechnologist() == null &&
                aQuery.getPatientID() == null &&
                aQuery.getInstitution() == null &&
                aQuery.getIIR() == null &&
                aQuery.getCPTCode() != null);
    }

    public ProfessionalTicket findOne(String aId)
    {
        ProfessionalTicket myTicket = theTicketRepository.findOne(new ObjectId(aId));
        HL7Messages myHL7Messages = theHL7Service.findMessagesForStudy(myTicket.getStudy());
        myTicket.setHL7Messages(myHL7Messages.getMessages());

        return myTicket;
    }

    public ProfessionalTicket createOrUpdate(ProfessionalTicket aTicket)
    {
        logDifference(aTicket);
        return theTicketRepository.save(aTicket);
    }

    private void logDifference(ProfessionalTicket aTicket)
    {
        if (aTicket.getId() != null)
        {
            ObjectId myTicketId = new ObjectId(aTicket.getId());
            boolean myTicketExists = theTicketRepository.exists(myTicketId);
            if (myTicketExists)
            {
                ProfessionalTicket myExistingTicket = theTicketRepository.findOne(myTicketId);
                String myDifference = theTicketDifferences.getDifference(aTicket, myExistingTicket);
                if (myDifference != null && !myDifference.isEmpty())
                {
                    aTicket.addNote(new InternalNote(myDifference, new Date(), aTicket.getLastUpdatedBy()));
                }
            }
        }
    }

    public void delete(ProfessionalTicket aTicket)
    {
        aTicket.setDeleted(true);
        User myLastUpdatedBy = aTicket.getLastUpdatedBy();
        aTicket.addNote(new InternalNote("Ticket Deleted by " + myLastUpdatedBy, new Date(), myLastUpdatedBy));
        theTicketRepository.save(aTicket);
    }

    public String create(CreateTicketRequests aRequests)
    {
        LOGGER.info("Received {} ticket creation requests", aRequests.getRequests().size());
        List<String> myCreatedTickets = new ArrayList<>();
        try
        {
            List<Institution> myAvailableInstitutions = theInstitutionService.findAll().getInstitutions();
            List<TicketType> myAllTicketTypes = Arrays.asList(TicketType.values());
            User myUser = aRequests.getUser();
            for (CreateTicketRequest myTicketRequest : aRequests.getRequests())
            {
                DicomStudy myStudy = theDicomStudyService.findOne(myTicketRequest.getStudyId());
                List<ProfessionalTicket> myExistingTickets = theTicketRepository.findByTheStudy(myStudy);
                List<HL7> myHL7Messages = theHL7Service.findMessagesForStudy(myStudy).getMessages();
                TicketPriority myTicketPriority = myTicketRequest.getPriority();
                setInstitution(myAvailableInstitutions, myStudy, myHL7Messages);
                List<TicketType> myRequestedTypes = myTicketRequest.getRequestedTypes();
                List<TicketType> myExistingTicketTypes = with(myExistingTickets)
                        .remove(having(on(ProfessionalTicket.class).isDeleted(), is(true)))
                        .extract(on(ProfessionalTicket.class).getType());
                myRequestedTypes.removeAll(myExistingTicketTypes);
                if (myRequestedTypes.containsAll(myAllTicketTypes))
                {
                    ProfessionalTicket myPRTicket =
                            createPRTicket(myTicketRequest, myTicketPriority, myUser, myStudy, myHL7Messages);
                    ProfessionalTicket myTRTicket =
                            createTRTicket(myTicketRequest, myTicketPriority, myUser, myStudy, myHL7Messages);
                    myPRTicket.setCorrespondingReviewViewId(myTRTicket.getViewId());
                    myTRTicket.setCorrespondingReviewViewId(myPRTicket.getViewId());
                    createOrUpdate(myPRTicket);
                    createOrUpdate(myTRTicket);
                    myCreatedTickets.add(myPRTicket.getViewId());
                    myCreatedTickets.add(myTRTicket.getViewId());
                }
                else if (myRequestedTypes.contains(TicketType.TR))
                {
                    ProfessionalTicket myTRTicket =
                            createTRTicket(myTicketRequest, myTicketPriority, myUser, myStudy, myHL7Messages);
                    createOrUpdate(myTRTicket);
                    myCreatedTickets.add(myTRTicket.getViewId());
                }
                else if (myRequestedTypes.contains(TicketType.PR))
                {
                    ProfessionalTicket myPRTicket =
                            createPRTicket(myTicketRequest, myTicketPriority, myUser, myStudy, myHL7Messages);
                    createOrUpdate(myPRTicket);
                    myCreatedTickets.add(myPRTicket.getViewId());
                }
            }
        }
        catch (Exception anException)
        {
            LOGGER.error("Error creating studies", anException);
        }
        return with(myCreatedTickets).join(", ");
    }

    private void setInstitution(List<Institution> aAvailableInstitutions, DicomStudy aStudy, List<HL7> aHL7Messages)
    {
        Institution myInstitution = aStudy.getInstitution();
        if (myInstitution == null)
        {
            aStudy.setInstitution(InstitutionFinder.findInstitution(
                    aStudy.getInstitutions(),
                    aHL7Messages,
                    aAvailableInstitutions));
            theDicomStudyService.createOrUpdate(aStudy);
        }
    }

    private ProfessionalTicket createTRTicket(CreateTicketRequest aRequest,
                                              TicketPriority aTicketPriority,
                                              User aUser,
                                              DicomStudy myStudy, List<HL7> aHL7Messages)
    {
        return createTicket(aRequest, aTicketPriority, aUser, myStudy, aHL7Messages,
                TicketType.TR, TicketStatus.TECH_OPEN_ERP_REVIEW);
    }

    private ProfessionalTicket createPRTicket(CreateTicketRequest aRequest,
                                              TicketPriority aTicketPriority,
                                              User aUser,
                                              DicomStudy myStudy, List<HL7> aHL7Messages)
    {
        return createTicket(aRequest, aTicketPriority, aUser, myStudy, aHL7Messages,
                TicketType.PR, TicketStatus.OPEN_ERP_REVIEW);
    }

    private ProfessionalTicket createTicket(CreateTicketRequest aRequest,
                                            TicketPriority aTicketPriority,
                                            User aUser,
                                            DicomStudy myStudy,
                                            List<HL7> aHL7Messages,
                                            TicketType aTicketType,
                                            TicketStatus aTicketStatus)
    {
        ProfessionalTicket myProfessionalTicket = new ProfessionalTicket();
        myProfessionalTicket.setType(aTicketType);
        myProfessionalTicket.setCreatedDate(new Date());
        myProfessionalTicket.setViewId(aTicketType.name() + newId());
        myProfessionalTicket.setSubmittedTime(new Date().getTime());
        myProfessionalTicket.setPriority(aTicketPriority);
        myProfessionalTicket.setStudy(myStudy);
        myProfessionalTicket.setStatus(aTicketStatus);
        myProfessionalTicket.setSubmittedUser(aUser);
        myProfessionalTicket.setHL7Messages(aHL7Messages);
        myProfessionalTicket.setSubmittedVariance(aRequest.isSubmittedVariance());
        updateExistingTicket(aRequest, myProfessionalTicket);

        return myProfessionalTicket;
    }

    private void updateExistingTicket(CreateTicketRequest aRequest, ProfessionalTicket aProfessionalTicket)
    {
        if (!aRequest.getExistingTicketIds().isEmpty())
        {
            String myExistingTicketId = aRequest.getExistingTicketIds().iterator().next();
            ProfessionalTicket myExistingTicket = findCorrespondingTicket(myExistingTicketId);
            if (myExistingTicket != null)
            {
                aProfessionalTicket.setCorrespondingReviewViewId(myExistingTicketId);
                myExistingTicket.setCorrespondingReviewViewId(aProfessionalTicket.getViewId());
                createOrUpdate(myExistingTicket);
            }
        }
    }

    private String newId()
    {
        return "-" + theCounterService.getNextUserIdSequence();
    }

    public ProfessionalTicket createCorresponding(String aTicketId, String aUserId)
    {
        LOGGER.info("Creating corresponding ticket for ticket id {}", aTicketId);
        ProfessionalTicket myTicket = findOne(aTicketId);
        User myUser = theUserRepository.findOne(new ObjectId(aUserId));

        TicketPriority myPriority = myTicket.getPriority();
        if (myPriority == TicketPriority.RTRT || myPriority == TicketPriority.RTRC || myPriority == TicketPriority.UR)
        {
            myPriority = TicketPriority.TR;
        }
        String myTickets = create(new CreateTicketRequests(Arrays.asList(new CreateTicketRequest(
                myTicket.getStudy().getId(),
                myPriority,
                Arrays.asList(TicketType.PR),
                myTicket.isSubmittedVariance(),
                Arrays.asList(myTicket.getViewId()),
                Arrays.asList(myTicket.getType()))), myUser));
        if (!myTickets.isEmpty())
        {
            ProfessionalTicket myProfessionalTicket = findOne(myTicket.getId());
            String myCorrespondingReviewViewId = myProfessionalTicket.getCorrespondingReviewViewId();
            LOGGER.info("Created corresponding ticket with id {}", myCorrespondingReviewViewId);

            return findCorrespondingTicket(myCorrespondingReviewViewId);
        }
        LOGGER.info("No corresponding ticket was created");

        return null;
    }

    private ProfessionalTicket findCorrespondingTicket(String aCorrespondingTicketViewId)
    {
        TicketQuery myQuery = new TicketQueryBuilder().setTicketId(aCorrespondingTicketViewId).build();
        TicketQueryResults myTickets = findTickets(myQuery);
        List<TicketQueryResult> myTicketQueryResults = myTickets.getTickets();
        if (!myTicketQueryResults.isEmpty())
        {
            TicketQueryResult myExistingTicketResult = myTicketQueryResults.iterator().next();
            return findOne(myExistingTicketResult.getTicketId());
        }
        return null;
    }

    private static class TicketFilter extends BaseMatcher<TicketQueryResult>
    {

        private final int theTicketCategory;

        private TicketFilter(int aTicketCategory)
        {
            theTicketCategory = aTicketCategory;
        }

        @Override public boolean matches(Object o)
        {
            TicketQueryResult myResult = (TicketQueryResult) o;

            return myResult.getCategory() == theTicketCategory;
        }

        @Override public void describeTo(Description aDescription)
        {
            // empty
        }

    }

    // testing
    public void setMongoTemplate(MongoTemplate aMongoTemplate)
    {
        theMongoTemplate = aMongoTemplate;
    }
}

