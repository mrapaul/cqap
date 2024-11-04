package com.capstone.rest;

import com.peirs.datamodel.ticket.*;
import org.springframework.data.mongodb.repository.*;
import org.springframework.stereotype.*;

@Repository("ProfessionalTicketRepository")
public interface ProfessionalTicketRepository extends MongoRepository<ProfessionalTicket, String>
{
}
