package com.capstone.server.controller;


import com.mongodb.Mongo;
import com.mongodb.MongoURI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import javax.servlet.*;
import java.net.UnknownHostException;

@SpringBootApplication
@EnableMongoRepositories
@PropertySource(value = "classpath:/mongo.properties")
public class Server
{
    public static void main(String[] args)
    {
        try {
            SpringApplication.run(Server.class, args);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Autowired
    private Environment theEnvironment;

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

    @Bean
    MultipartConfigElement multipartConfigElement()
    {
        return new MultipartConfigElement("");
    }
}
