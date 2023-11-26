package com.capstone.server.controller;

import com.peirs.datamodel.dicom.*;
import com.peirs.datamodel.ticket.*;
import org.bson.types.*;
import org.springframework.data.mongodb.repository.*;
import org.springframework.stereotype.*;

import java.util.*;

@Repository("ProfessionalTicketRepository")
public interface ProfessionalTicketRepository extends MongoRepository<ProfessionalTicket, ObjectId>
{
    public List<ProfessionalTicket> findByTheStudy(DicomStudy aStudy);
}
