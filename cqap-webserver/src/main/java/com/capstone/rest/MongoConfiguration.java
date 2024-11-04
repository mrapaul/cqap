package com.capstone.rest;

import com.mongodb.*;
import org.springframework.context.annotation.*;
import org.springframework.data.mongodb.core.*;
import org.springframework.data.mongodb.repository.config.*;

import java.net.*;

@Configuration
@EnableMongoRepositories(basePackages = "com.capstone.rest",
        includeFilters = @ComponentScan.Filter(value = { ProfessionalTicketRepository.class, UserRepository.class }, type = FilterType.ASSIGNABLE_TYPE))
public class MongoConfiguration {

    @Bean
    public Mongo mongo() throws UnknownHostException
    {
        return new Mongo(getMongoURI());
    }

    @Bean
    public MongoTemplate mongoTemplate() throws Exception
    {
        return new MongoTemplate(mongoDbFactory());
    }

    @Bean
    public SimpleMongoDbFactory mongoDbFactory() throws Exception
    {
        return new SimpleMongoDbFactory(getMongoURI());
    }

    private MongoURI getMongoURI()
    {
        return new MongoURI("mongodb://writer:writer@192.168.10.57:27017/peirs");
//        return new MongoURI("mongodb://cloudbees:09a81311b420190222fb78d35db54420@linus.mongohq.com:10047/2GeDJNBcpsRRq59T6iQsg");
    }
}
