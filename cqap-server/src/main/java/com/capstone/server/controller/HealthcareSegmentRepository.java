package com.capstone.server.controller;

import com.peirs.datamodel.*;
import org.springframework.data.mongodb.repository.*;
import org.springframework.stereotype.*;

@Repository("HealthcareSegmentRepository")
public interface HealthcareSegmentRepository extends MongoRepository<HealthcareSegment, String>
{
}
