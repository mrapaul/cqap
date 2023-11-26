package com.capstone.server.controller;

import ca.uhn.hl7v2.*;
import ca.uhn.hl7v2.model.v26.message.*;
import ca.uhn.hl7v2.parser.*;
import com.google.common.collect.*;
import com.lakeland.hl7.datamodel.*;
import com.peirs.datamodel.dicom.*;
import com.peirs.datamodel.hl7.*;
import com.peirs.datamodel.hl7.HL7Messages;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.data.mongodb.core.*;
import org.springframework.data.mongodb.core.query.*;
import org.springframework.stereotype.*;
import parser.*;

import java.util.*;

import static ch.lambdaj.collection.LambdaCollections.*;
import static org.hamcrest.CoreMatchers.*;

@Component("HL7Service")
public class HL7Service
{
    private static final Logger LOGGER = LoggerFactory.getLogger(HL7Service.class);
    private final PipeParser thePipeParser;
    private final XMLParser theXmlParser;
    private final ORU_R01Parser theORUR01Parser;
    private final MessageToConverter theMessageToConverter;
    @Autowired private HL7Repository theRepository;
    @Autowired private MongoTemplate theMongoTemplate;
    @Autowired private CounterService theCounterService;

    public HL7Service()
    {
        HapiContext hapiContext = new HL7ContextSupplier().get();
        thePipeParser = hapiContext.getPipeParser();
        theXmlParser = hapiContext.getXMLParser();
        theORUR01Parser = new ORU_R01Parser();
        theMessageToConverter = new MessageToConverter(thePipeParser, theXmlParser);
    }

    public HL7Messages findAll()
    {
        List<Message> myMessages = theRepository.findAll();
        return convertToMessages(myMessages);
    }

    public HL7Messages findMessagesForStudy(DicomStudy aStudy)
    {
        String myAccessionNumber = aStudy.getAccessionNumber();

        if (myAccessionNumber != null)
        {
            try
            {
                List<Message> myMessages = findForAccession(myAccessionNumber);
                if (myMessages.isEmpty())
                {
                    myAccessionNumber = aStudy.getAccessionNumber();
                    if (myAccessionNumber.contains("MCH"))
                    {
                        myAccessionNumber = aStudy.getAccessionNumber().substring(0, myAccessionNumber.indexOf("MCH"));
                        myMessages = findForAccession(myAccessionNumber);

                        if (!myMessages.isEmpty())
                        {
                            return convertToMessages(myMessages);
                        }
                    }
                }
                else
                {
                    return convertToMessages(myMessages);
                }
            }
            catch (Exception e)
            {
                LOGGER.error("Error converting HL7 messages", e);
            }
        }
        return new HL7Messages();
    }

    private List<Message> findForAccession(String aAccessionNumber)
    {
        Query myQuery = new Query();
        myQuery.addCriteria(Criteria.where("rawMessage").regex("\\b" + aAccessionNumber + "\\b", "i"));
        myQuery.addCriteria(Criteria.where("type").is("ORU"));

        return theMongoTemplate.find(myQuery, Message.class);
    }

    private HL7Messages convertToMessages(List<Message> aMessages)
    {
        List<HL7> myMessages = Lists.newArrayList();
        for (Message myMessage : aMessages)
        {
            try
            {
                ca.uhn.hl7v2.model.Message parsedMessage = thePipeParser.parse(myMessage.getRawMessage());
                HL7 myHL7 = theORUR01Parser.parseReport((ORU_R01) parsedMessage);
                myMessages.add(myHL7);
            }
            catch (HL7Exception e)
            {
                LOGGER.error("Error parsing message", e);
            }
        }
        return new HL7Messages(myMessages);
    }

//    public MergeHL7Message createOrUpdate(MergeHL7Message aGroup)
//    {
//        return theRepository.save(aGroup);
//    }

    public void store(String aMessage)
    {
        Message storedMessage = theMessageToConverter.convert(aMessage);
        storedMessage.setViewId("HL7-" + theCounterService.getNextMessageIdSequence());
        theMongoTemplate.save(storedMessage, "HL7Messages");
    }
}
