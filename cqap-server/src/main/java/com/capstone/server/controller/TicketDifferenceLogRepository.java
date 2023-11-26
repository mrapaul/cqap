package com.capstone.server.controller;

import com.peirs.datamodel.ticket.*;
import org.bson.types.*;
import org.springframework.data.mongodb.repository.*;
import org.springframework.stereotype.*;

@Repository("TicketDifferenceLogRepository")
public interface TicketDifferenceLogRepository extends MongoRepository<TicketDifferenceLog, ObjectId>
{
}
