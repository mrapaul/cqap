package com.capstone.server.controller;

import com.peirs.datamodel.dicom.*;
import com.peirs.datamodel.hl7.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.data.mongodb.core.*;
import org.springframework.data.mongodb.core.query.*;
import org.springframework.stereotype.*;

import java.util.*;

import static ch.lambdaj.collection.LambdaCollections.with;
import static org.hamcrest.CoreMatchers.nullValue;

@Component("HL7Service")
public class HL7Service
{
    @Autowired private HL7Repository theRepository;
    @Autowired private MongoTemplate theMongoTemplate;
    private final MergeHL7MessageToHL7Converter theConverter;

    public HL7Service()
    {
        theConverter = new MergeHL7MessageToHL7Converter();
    }

    public HL7Messages findAll()
    {
        List<MergeHL7Message> myMessages = theRepository.findAll();
        return convertToMessages(myMessages);
    }

    public HL7Messages findMessagesForStudy(DicomStudy aStudy)
    {
        String myAccessionNumber = aStudy.getAccessionNumber();
        if (myAccessionNumber != null)
        {
            Query myQuery = new Query();
            myQuery.addCriteria(Criteria.where("theMessage").regex("\\b" + myAccessionNumber + "\\b", "i"));
            List<MergeHL7Message> myMergeHL7Messages = theMongoTemplate.find(myQuery, MergeHL7Message.class);
            return convertToMessages(myMergeHL7Messages);
        }
        return new HL7Messages();
    }

    private HL7Messages convertToMessages(List<MergeHL7Message> aMessages)
    {
        return !aMessages.isEmpty() ?
                new HL7Messages(with(aMessages).convert(theConverter).remove(nullValue())) :
                new HL7Messages();
    }

    public MergeHL7Message createOrUpdate(MergeHL7Message aGroup)
    {
        return theRepository.save(aGroup);
    }
}
