package com.capstone.server.controller;

import com.cqap.util.*;
import com.google.common.collect.*;
import com.peirs.datamodel.*;
import com.peirs.datamodel.dicom.*;
import com.peirs.datamodel.hl7.*;
import com.peirs.datamodel.ticket.*;
import org.bson.types.*;
import org.dcm4che2.data.*;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.data.mongodb.core.*;
import org.springframework.data.mongodb.core.query.*;
import org.springframework.stereotype.*;

import java.util.*;

import static ch.lambdaj.Lambda.on;
import static ch.lambdaj.collection.LambdaCollections.with;
import static com.cqap.util.DicomStudyTagValueFinder.findValue;
import static org.apache.commons.lang.StringUtils.*;

@Component("DicomStudyService")
public class DicomStudyService
{
    private static final Logger LOGGER = LoggerFactory.getLogger(DicomStudyService.class);
    @Autowired private DicomStudyRepository theRepository;
    @Autowired private InstitutionRepository theInstitutionRepository;
    @Autowired private UserRepository theUserRepository;
    @Autowired private HL7Service theHL7Service;
    @Autowired private MongoTemplate theMongoTemplate;

    public DicomStudy createOrUpdate(DicomStudy aStudy)
    {
        return theRepository.save(aStudy);
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
        return theRepository.findAll(myIds);
    }

    public DicomStudyQueryResults findStudies(DicomStudyQuery aQuery)
    {
        LOGGER.info("Querying dicom studies");

        List<DicomStudyQueryResult> myResults = Lists.newArrayList();
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
        return new DicomStudyQueryResults(myResults);
    }

    public DicomStudies findStudiesForTickets(DicomStudyQuery aQuery)
    {
        return new DicomStudies(searchStudies(aQuery));
    }

    private List<DicomStudy> searchStudies(DicomStudyQuery aQuery)
    {
        List<DicomStudy> myDicomStudies = theMongoTemplate.find(createQuery(aQuery), DicomStudy.class);
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

    private Query createQuery(DicomStudyQuery aSearch)
    {
        Query myQuery = new Query();
        myQuery.fields()
                .include("theId")
                .include("theStudyId")
                .include("theStudyInstanceUID")
                .include("theStudyDate")
                .include("thePatientName")
                .include("thePatientID")
                .include("thePatientBirthDate")
                .include("thePatientSex")
                .include("theAccessionNumber")
                .include("theStudyDescription")
                .include("theModality")
                .include("theInstitutionName")
                .include("theInstitutions")
                .include("theImageCount");

        boolean myFirstNamePresent = isNotEmpty(aSearch.getPatientFirstName());
        boolean myLastNamePresent = isNotEmpty(aSearch.getPatientLastName());
        if (myFirstNamePresent || myLastNamePresent)
        {
            StringBuilder myBuilder = new StringBuilder();
            if (myLastNamePresent && !myFirstNamePresent)
            {
                myBuilder.append("^\\b").append(aSearch.getPatientLastName()).append("\\b.*");
            }
            else if (!myLastNamePresent)
            {
                myBuilder.append("^\\w*.\\b").append(aSearch.getPatientFirstName()).append("\\b.*");
            }
            else
            {
                myBuilder.append("^\\b")
                        .append(aSearch.getPatientLastName())
                        .append("\\b.\\b")
                        .append(aSearch.getPatientFirstName())
                        .append("\\b");
            }

            myQuery.addCriteria(Criteria.where("thePatientName").regex(myBuilder.toString(), "i"));
        }

        if (isNotEmpty(aSearch.getAccessionNumber()))
        {
            myQuery.addCriteria(Criteria.where("theAccessionNumber")
                    .regex("^" + aSearch.getAccessionNumber(), "i"));
        }

        if (aSearch.getGroup() != null)
        {
            List<Institution> myInstitutions = theInstitutionRepository.findByTheGroup(aSearch.getGroup());
            myQuery.addCriteria(Criteria.where("theInstitution.theAlias")
                    .in(with(myInstitutions).extract(on(Institution.class).getAlias())));
        }

        if (aSearch.getInstitution() != null)
        {
            myQuery.addCriteria(Criteria.where("theInstitution.theAlias").is(aSearch.getInstitution().getAlias()));
        }

        if (isNotEmpty(aSearch.getInstitutionAlias()))
        {
            myQuery.addCriteria(Criteria.where("theInstitutions").in(aSearch.getInstitutionAlias()));
        }

        if (aSearch.getModalities() != null && !aSearch.getModalities().isEmpty())
        {
            List<String> myModalities = Lists.newArrayList();
            for (String myModality : aSearch.getModalities())
            {
                myModalities.addAll(!myModality.contains("/") ?
                        Arrays.asList(myModality) :
                        Arrays.asList(myModality.split("/")));
            }
            myQuery.addCriteria(Criteria.where("theModality").in(myModalities));
        }

        if (isNotEmpty(aSearch.getStudyDate()))
        {
            myQuery.addCriteria(Criteria.where("theStudyDate").is(aSearch.getStudyDate()));
        }

        if (isNotEmpty(aSearch.getStudyDescription()))
        {
            myQuery.addCriteria(Criteria.where("theStudyDescription")
                    .regex("\\b" + aSearch.getStudyDescription() + "\\b", "i"));
        }

        if (isNotEmpty(aSearch.getPatientID()))
        {
            myQuery.addCriteria(Criteria.where("thePatientID").regex("^" + aSearch.getPatientID(), "i"));
        }

        if (isNotEmpty(aSearch.getSiteTechnologist()))
        {
            myQuery.addCriteria(Criteria.where("theOperatorName")
                    .regex("\\b" + aSearch.getSiteTechnologist() + "\\b", "i"));
        }

        LOGGER.info("Querying dicom studies : " + myQuery);
        return myQuery;
    }

    public DicomStudy findOne(String aId)
    {
        return theRepository.findOne(new ObjectId(aId));
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
}
