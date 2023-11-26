package com.capstone.server.controller;

import com.peirs.datamodel.*;
import org.bson.types.*;
import org.springframework.data.mongodb.repository.*;
import org.springframework.stereotype.*;

import java.util.*;

@Repository("UserRepository")
public interface UserRepository extends MongoRepository<User, ObjectId>
{
    User findByTheUsername(String aUsername);

    User findByTheName(String aName);

    List<User> findByTheRole(Role aRole);
}
