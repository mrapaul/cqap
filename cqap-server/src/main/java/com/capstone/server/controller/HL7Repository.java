package com.capstone.server.controller;

import com.peirs.datamodel.hl7.*;
import org.bson.types.*;
import org.springframework.data.mongodb.repository.*;
import org.springframework.stereotype.*;

@Repository("HL7Repository")
public interface HL7Repository extends MongoRepository<MergeHL7Message, ObjectId>
{
}
