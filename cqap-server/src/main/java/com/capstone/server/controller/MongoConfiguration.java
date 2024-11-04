package com.capstone.server.controller;

import com.mongodb.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.context.annotation.*;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.*;
import org.springframework.data.mongodb.core.*;
import org.springframework.data.mongodb.repository.config.*;

import javax.servlet.*;
import java.net.*;

@Configuration
@EnableMongoRepositories
@PropertySource(value = "classpath:/mongo.properties")
public class MongoConfiguration
{
    @Autowired private Environment theEnvironment;

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
        return new MongoURI(getDBURL());
    }

    private String getDBURL()
    {
        return isProd() ? theEnvironment.getProperty("prod.mongoURL") : theEnvironment.getProperty("test.mongoURL");
    }

    private boolean isProd()
    {
        return Boolean.valueOf(theEnvironment.getProperty("prod"));
    }

    @Bean MultipartConfigElement multipartConfigElement()
    {
        return new MultipartConfigElement("");
    }
}
