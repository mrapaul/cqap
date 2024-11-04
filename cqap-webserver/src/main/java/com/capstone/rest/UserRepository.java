package com.capstone.rest;

import com.peirs.datamodel.*;
import org.springframework.data.mongodb.repository.*;
import org.springframework.stereotype.*;

import java.util.*;

@Repository("UserRepository")
public interface UserRepository extends MongoRepository<User, String>
{
    User findByTheUsername(String aUsername);

    List<User> findByTheRole(Role aRole);
}
