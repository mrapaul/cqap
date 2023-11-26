package com.capstone.server.controller;

import org.bson.types.*;
import org.springframework.data.mongodb.repository.*;
import org.springframework.stereotype.*;

@Repository("HL7Repository")
public interface HL7Repository extends MongoRepository<Message, ObjectId>
{
}
