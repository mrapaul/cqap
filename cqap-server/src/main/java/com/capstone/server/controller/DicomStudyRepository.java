package com.capstone.server.controller;

import com.peirs.datamodel.dicom.*;
import org.bson.types.*;
import org.springframework.data.mongodb.repository.*;
import org.springframework.stereotype.*;

import java.util.*;

@Repository("DicomStudyRepository")
public interface DicomStudyRepository extends MongoRepository<DicomStudy, ObjectId>
{
    List<DicomStudy> findByTheStudyInstanceUID(String aStudyInstanceUID);
}
