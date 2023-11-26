package com.capstone.server.controller;

import com.peirs.datamodel.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.data.mongodb.core.*;
import org.springframework.data.mongodb.core.query.*;
import org.springframework.stereotype.*;

import java.util.*;

@Component("CounterService")
public class CounterService
{
    public static final String PR_ID_SEQUENCE_NAME = "TICKET";
    public static final String MESSAGE_ID_SEQUENCE_NAME = "HL7";
    private final MongoTemplate theMongoTemplate;

    @Autowired
    public CounterService(MongoTemplate aMongoTemplate)
    {
        theMongoTemplate = aMongoTemplate;
    }

    public long getNextUserIdSequence()
    {
        createCountersIfMissing();

        return increaseCounter(PR_ID_SEQUENCE_NAME);
    }

    public Long getNextMessageIdSequence()
    {
        Query query = new Query(Criteria.where("name").is(MESSAGE_ID_SEQUENCE_NAME));
        Update update = new Update().inc("sequence", 1);
        RISCounter counter = theMongoTemplate.findAndModify(query, update, RISCounter.class); // return old Counter object
        return counter.getSequence();
    }

    private long increaseCounter(String counterName)
    {
        Query query = new Query(Criteria.where("theName").is(counterName));
        Update update = new Update().inc("theSequence", 1);
        Counter counter = theMongoTemplate.findAndModify(query, update, Counter.class); // return old Counter object
        return counter.getSequence();
    }

    private void createCountersIfMissing()
    {
        Query query = new Query(Criteria.where("theName").is(PR_ID_SEQUENCE_NAME));
        List<Counter> counters = theMongoTemplate.find(query, Counter.class);
        if (counters == null || counters.isEmpty())
        {
            Counter counter = new Counter();
            counter.setName(PR_ID_SEQUENCE_NAME);
            counter.setSequence(1l);
            theMongoTemplate.save(counter);
        }

        Query query1 = new Query(Criteria.where("name").is(MESSAGE_ID_SEQUENCE_NAME));
        List<RISCounter> counters1 = theMongoTemplate.find(query1, RISCounter.class);
        if (counters1 == null || counters1.isEmpty())
        {
            RISCounter counter = new RISCounter();
            counter.setName(MESSAGE_ID_SEQUENCE_NAME);
            counter.setSequence(1l);
            theMongoTemplate.save(counter);
        }
    }
}
