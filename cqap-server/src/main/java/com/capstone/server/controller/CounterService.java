package com.capstone.server.controller;

import com.peirs.datamodel.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.data.mongodb.core.*;
import org.springframework.data.mongodb.core.query.*;
import org.springframework.stereotype.*;

@Component("CounterService")
public class CounterService
{
    public static final String PR_ID_SEQUENCE_NAME = "TICKET";
    @Autowired private MongoTemplate theMongoTemplate;

    public long getNextUserIdSequence()
    {
        return increaseCounter(PR_ID_SEQUENCE_NAME);
    }

    private long increaseCounter(String counterName)
    {
        Query query = new Query(Criteria.where("theName").is(counterName));
        Update update = new Update().inc("theSequence", 1);
        Counter counter = theMongoTemplate.findAndModify(query, update, Counter.class); // return old Counter object
        return counter.getSequence();
    }
}
