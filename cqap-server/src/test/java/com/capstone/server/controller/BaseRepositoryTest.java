package com.capstone.server.controller;

import com.mongodb.*;
import de.flapdoodle.embedmongo.*;
import de.flapdoodle.embedmongo.config.*;
import de.flapdoodle.embedmongo.distribution.*;
import de.flapdoodle.embedmongo.runtime.*;
import org.junit.*;
import org.springframework.context.annotation.*;
import org.springframework.data.mongodb.core.*;

public class BaseRepositoryTest
{
    private static final String DB_NAME = "pretech_embedded1";
    private static MongodExecutable mongodExe;
    private static MongodProcess mongod;
    private static Mongo mongo;
    protected MongoTemplate theTemplate;

    @BeforeClass
    public static void setup() throws Exception
    {
        MongoDBRuntime runtime = MongoDBRuntime.getDefaultInstance();
        mongodExe = runtime.prepare(new MongodConfig(Version.V2_0_4, 12345, Network.localhostIsIPv6()));
        mongod = mongodExe.start();
        mongo = new Mongo("localhost", 12345);
    }

    @AfterClass
    public static void teardown() throws Exception
    {
        mongod.stop();
        mongodExe.cleanup();
    }

    @Before
    public void setUp() throws Exception
    {
        theTemplate = new MongoTemplate(mongo, DB_NAME);
    }

    @Bean
    public MongoTemplate getTemplate()
    {
        return theTemplate;
    }
}
