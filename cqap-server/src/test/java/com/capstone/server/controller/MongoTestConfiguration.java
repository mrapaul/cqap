package com.capstone.server.controller;

import org.springframework.context.annotation.*;
import org.springframework.data.mongodb.repository.config.*;

@Configuration
@EnableMongoRepositories
@Profile("dev")
public class MongoTestConfiguration
{
}
