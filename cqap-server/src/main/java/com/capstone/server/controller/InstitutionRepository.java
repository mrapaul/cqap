package com.capstone.server.controller;

import com.peirs.datamodel.*;
import org.bson.types.*;
import org.springframework.data.mongodb.repository.*;
import org.springframework.stereotype.*;

import java.util.*;

@Repository("InstitutionRepository")
public interface InstitutionRepository extends MongoRepository<Institution, ObjectId>
{
    public List<Institution> findByTheGroup(Group aGroup);
}
