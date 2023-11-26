package com.capstone.server.controller;

import com.peirs.datamodel.hl7.*;
import org.bson.types.*;
import org.springframework.data.mongodb.repository.*;
import org.springframework.stereotype.*;

import java.util.*;

@Repository("CPTCodeRepository")
public interface CPTCodeRepository extends MongoRepository<CPTCode, ObjectId>
{
    CPTCode findByCPTCode(String aCPTCode);

    List<CPTCode> findBySubspecialtyPrimary(String aSubspecialityPrimary);

    List<CPTCode> findBySubspecialtySecondary(String aSubspecialitySecondary);

    List<CPTCode> findBySubspecialtyTertiary(String aSubspecialityTertiary);

    List<CPTCode> findByImagingModality(String aImagingModality);
}
