package com.capstone.server.controller;

import com.google.common.collect.*;
import com.mongodb.*;
import com.peirs.datamodel.*;
import org.bson.types.*;
import org.joda.time.*;
import org.junit.*;
import org.springframework.data.mongodb.core.*;

import java.util.*;

public class StatisticsServiceTest
{
//    @Test
//    public void testTicketsPerDay() throws Exception
//    {
//        MongoTemplate mongoTemplate = new MongoTemplate(new SimpleMongoDbFactory(new MongoURI(
//                "mongodb://writer:writer@127.0.0.1:27017/peirs")));
//
//        Set<TicketsPerDay> counts = Sets.newHashSet();
//        try
//        {
//            DBObject projectFields = new BasicDBObject("dt", "$substr: [{$add: [new Date(0), \"$theSubmittedTime\"]}, 0, -1]");
//            DBObject project = new BasicDBObject("$project", projectFields);
//
//            DBObject groupFields = new BasicDBObject("_id", new BasicDBObject("date", "$dt"));
//            groupFields.put("count", new BasicDBObject("$sum", 1));
//            DBObject group = new BasicDBObject("$group", groupFields);
//
//
//            AggregationOutput output = mongoTemplate.getCollection("PRTickets").aggregate(project, group);
//
//            for (DBObject obj : output.results())
//            {
//                System.out.println(obj);
//                ObjectId id = (ObjectId) obj.get("_id");
//                LocalDate localDate = new LocalDate(id.getTime());
//                Date date = localDate.toDate();
////                int month = (Integer) id.get("month");
////                int year = (Integer) id.get("year");
////                LocalDate date = new LocalDate(year, month, day);
////
//                int times = Integer.parseInt(obj.get("count").toString());
//                counts.add(new TicketsPerDay(date, times));
//                System.out.println(date + " - " + times);
//            }
//        }
//        catch (Exception e)
//        {
//            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
//        }
//
//    }
}
