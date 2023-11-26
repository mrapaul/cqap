package com.capstone.server.controller;

import com.peirs.datamodel.*;
import org.bson.types.*;
import org.springframework.data.mongodb.repository.*;
import org.springframework.stereotype.*;

@Repository("GroupRepository")
public interface GroupRepository extends MongoRepository<Group, ObjectId>
{
}
