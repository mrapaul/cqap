package com.capstone.rest;

import ch.lambdaj.*;
import com.peirs.datamodel.dicom.*;
import com.peirs.datamodel.ticket.*;
import org.apache.commons.lang.*;
import org.bson.types.*;
import org.hamcrest.*;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.data.mongodb.core.*;
import org.springframework.data.mongodb.core.query.*;
import org.springframework.stereotype.*;

import java.util.*;

import static ch.lambdaj.collection.LambdaCollections.*;

@Component("ProfessionalTicketService")
public class ProfessionalTicketService
{
    private static final Logger LOGGER = LoggerFactory.getLogger(ProfessionalTicketService.class);
    @Autowired private ProfessionalTicketRepository theTicketRepository;
    @Autowired private MongoTemplate theMongoTemplate;

    public ProfessionalTickets findAllTickets()
    {
        return new ProfessionalTickets(theTicketRepository.findAll());
    }

    public ProfessionalTickets findTickets(TicketQuery aSearch)
    {
        LOGGER.info("Querying tickets");
        List<ProfessionalTicket> myProfessionalTickets = theMongoTemplate.find(createQuery(aSearch),
                ProfessionalTicket.class);
        LOGGER.info("Selected {} tickets", myProfessionalTickets.size());
        List<ProfessionalTicket> myFiltered = Lambda.sort(filter(aSearch, myProfessionalTickets),
                Lambda.on(ProfessionalTicket.class).getSubmittedTime());
        LOGGER.info("Filtered {} tickets", myFiltered.size());
        List<ProfessionalTicket> mySorted = Lambda.sort(myFiltered, Lambda.on(ProfessionalTicket.class).getPriority());
        return new ProfessionalTickets(mySorted);
    }

    private List<ProfessionalTicket> filter(TicketQuery aSearch, List<ProfessionalTicket> aTickets)
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
        Query myQuery = new Query();

        if (aSearch.getTicketId() != null && !aSearch.getTicketId().isEmpty())
        {
            myQuery.addCriteria(Criteria.where("theViewId").is("PR-" + aSearch.getTicketId()));

            return myQuery;
        }

        if (aSearch.getTicketPriority() != null)
        {
            myQuery.addCriteria(Criteria.where("thePriority").is(aSearch.getTicketPriority()));
        }

        if (aSearch.getTicketStatus() != null)
        {
            myQuery.addCriteria(Criteria.where("theStatus").is(aSearch.getTicketStatus()));
        }

        List<ObjectId> myStudies = getStudies(aSearch);
        if (!myStudies.isEmpty())
        {
            myQuery.addCriteria(Criteria.where("theStudy.$id").in(myStudies));
        }

        if (aSearch.getDateSubmittedFrom() != 0l)
        {
            Criteria myCriteria = Criteria.where("theSubmittedTime").gte(aSearch.getDateSubmittedFrom());
            if (aSearch.getDateSubmittedTo() != 0l)
            {
                myCriteria.lte(aSearch.getDateSubmittedTo());
            }
            myQuery.addCriteria(myCriteria);
        }

        return myQuery;
    }

    private List<ObjectId> getStudies(TicketQuery aSearch)
    {
        int myCriteriaCount = 0;
        Query myQuery = new Query();
        if (!StringUtils.isEmpty(aSearch.getPatientFirstName()) || !StringUtils.isEmpty(aSearch.getPatientLastName()))
        {
            StringBuilder myBuilder = new StringBuilder();
            if (!StringUtils.isEmpty(aSearch.getPatientLastName()))
            {
                myBuilder.append("(?i)(").append(aSearch.getPatientLastName()).append("*)");
            }

            if (!StringUtils.isEmpty(aSearch.getPatientFirstName()) && !StringUtils.isEmpty(aSearch.getPatientLastName()))
            {
                myBuilder.append("?");
            }

            if (!StringUtils.isEmpty(aSearch.getPatientFirstName()))
            {
                myBuilder.append("(?i)(").append(aSearch.getPatientFirstName()).append("*)");
            }

            myQuery.addCriteria(Criteria.where("thePatientName").regex(myBuilder.toString()));
            myCriteriaCount++;
        }

        if (!StringUtils.isEmpty(aSearch.getAccessionNumber()))
        {
            myQuery.addCriteria(Criteria.where("theAccessionNumber").regex(aSearch.getAccessionNumber()));
            myCriteriaCount++;
        }

        if (aSearch.getInstitution() != null)
        {
            myQuery.addCriteria(Criteria.where("theInstitutions").in(aSearch.getInstitution().getAlias()));
            myCriteriaCount++;
        }

        if (aSearch.getModalities() != null && !aSearch.getModalities().isEmpty())
        {
            myQuery.addCriteria(Criteria.where("theModality").in(aSearch.getModalities()));
            myCriteriaCount++;
        }

        if (!StringUtils.isEmpty(aSearch.getStudyDate()))
        {
            myQuery.addCriteria(Criteria.where("theStudyDate").is(aSearch.getStudyDate()));
            myCriteriaCount++;
        }

        if (!StringUtils.isEmpty(aSearch.getStudyDescription()))
        {
            myQuery.addCriteria(Criteria.where("theStudyDescription")
                    .regex("(?i)(" + aSearch.getStudyDescription() + "*)"));
            myCriteriaCount++;
        }

        if (!StringUtils.isEmpty(aSearch.getPatientID()))
        {
            myQuery.addCriteria(Criteria.where("thePatientID").regex(aSearch.getPatientID()));
            myCriteriaCount++;
        }

        if (!StringUtils.isEmpty(aSearch.getSiteTechnologist()))
        {
            myQuery.addCriteria(Criteria.where("theOperatorName").is(aSearch.getSiteTechnologist()));
            myCriteriaCount++;
        }

        if (myCriteriaCount == 0)
        {
            return Collections.emptyList();
        }

        List<DicomStudy> myStudies = theMongoTemplate.find(myQuery, DicomStudy.class);

        return with(myStudies).extract(Lambda.on(DicomStudy.class).getId());
    }

    private static class TicketFilter extends BaseMatcher<ProfessionalTicket>
    {
        private final int theTicketCategory;

        private TicketFilter(int aTicketCategory)
        {
            theTicketCategory = aTicketCategory;
        }

        @Override public boolean matches(Object o)
        {
            ProfessionalTicket aTicket = (ProfessionalTicket) o;
            int myTicketCategory = aTicket.getCMOReport() != null &&
                    aTicket.getCMOReport().getCMO() != null &&
                    aTicket.getCMOReport().getCategory() != 0 ?
                    aTicket.getCMOReport().getCategory() :
                    aTicket.getERPReport() != null ? aTicket.getERPReport().getCategory() : 0;

            return myTicketCategory == theTicketCategory;
        }

        @Override public void describeTo(Description aDescription)
        {
            // empty
        }
    }
}

