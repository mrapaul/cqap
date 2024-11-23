package com.capstone.server.controller;

import com.peirs.datamodel.ticket.ProfessionalTicket;
import com.peirs.datamodel.ticket.TicketType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

@Component("StatisticsService")
public class StatisticsService
{
    private static final Logger LOGGER = LoggerFactory.getLogger(StatisticsService.class);
    private final ProfessionalTicketService professionalTicketService;
    private final MongoTemplate mongoTemplate;

    @Autowired
    public StatisticsService(ProfessionalTicketService professionalTicketService,
                             MongoTemplate mongoTemplate)
    {
        this.professionalTicketService = professionalTicketService;
        this.mongoTemplate = mongoTemplate;
    }

    public Long getTotalOrderCount()
    {
        Query query = new Query(Criteria.where("theDeleted").is(false));

        return mongoTemplate.count(query, ProfessionalTicket.class);
    }

    public Long getTotalPROrderCount()
    {
        Query query = new Query(Criteria.where("theType").is(TicketType.PR.name()));
        query.addCriteria(Criteria.where("theDeleted").is(false));

        return mongoTemplate.count(query, ProfessionalTicket.class);
    }

    public Long getTotalTROrderCount()
    {
        Query query = new Query(Criteria.where("theType").is(TicketType.TR.name()));
        query.addCriteria(Criteria.where("theDeleted").is(false));

        return mongoTemplate.count(query, ProfessionalTicket.class);
    }

//    public TicketsPerDayCollection getTotalTicketsPerDay()
//    {
//        Set<TicketsPerDay> counts = Sets.newHashSet();
//        DBObject fields = new BasicDBObject("day", new BasicDBObject("$dayOfMonth", "$theCreatedDate"));
//        fields.put("month", new BasicDBObject("$month", "$theCreatedDate"));
//        fields.put("year", new BasicDBObject("$year", "$theCreatedDate"));
//        DBObject groupFields = new BasicDBObject("_id", fields);
//        groupFields.put("count", new BasicDBObject("$sum", 1));
//        DBObject group = new BasicDBObject("$group", groupFields);
//
//
//        AggregationOutput output = mongoTemplate.getCollection("PRTickets").aggregate(group);
//
//        for (DBObject obj : output.results())
//        {
//            DBObject id = (DBObject) obj.get("_id");
//            int day = (Integer) id.get("day");
//            int month = (Integer) id.get("month");
//            int year = (Integer) id.get("year");
//            LocalDate calendar = new LocalDate(year, month, day);
//
//            int times = Integer.parseInt(obj.get("count").toString());
//            counts.add(new TicketsPerDay(calendar.toDate(), times));
//        }
//
//        return new TicketsPerDayCollection(counts);
//    }

//    public CategoryDistributions getCategoryModalityDistribution()
//    {
//        Set<CategoryDistribution> distributions = Sets.newHashSet();
//        for (Integer category : Arrays.asList(1, 2, 3, 4, 5))
//        {
//            Query query = new Query();
//            Criteria andCriteria1 = Criteria.where("theCMOReport").exists(true)
//                    .andOperator(Criteria.where("theCMOReport.theCategory").is(category));
//
//            Criteria andCriteria2 = Criteria.where("theCMOReport").exists(false)
//                    .andOperator(Criteria.where("theERPReport.theCategory").is(category));
//
//            query.addCriteria(new Criteria().andOperator(Criteria.where("theDeleted").is(false),
//                    new Criteria().orOperator(andCriteria1, andCriteria2)));
//
//            List<ProfessionalTicket> professionalTickets = mongoTemplate.find(query, ProfessionalTicket.class);
//            Multimap<String, ProfessionalTicket> results = HashMultimap.create();
//
//            for (ProfessionalTicket result : professionalTickets)
//            {
//                results.put(result.getStudy().getModality(), result);
//            }
//
//            Set<ModalityDistribution> modalityDistributions = Sets.newHashSet();
//            for (String modality : results.keySet())
//            {
//                modalityDistributions.add(new ModalityDistribution(modality, results.get(modality).size()));
//            }
//
//            distributions.add(new CategoryDistribution(String.valueOf(category),
//                    results.size(),
//                    modalityDistributions));
//        }
//
//        return new CategoryDistributions(distributions);
//    }
}
