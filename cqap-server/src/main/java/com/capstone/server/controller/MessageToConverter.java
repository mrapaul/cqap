package com.capstone.server.controller;

import ca.uhn.hl7v2.*;
import ca.uhn.hl7v2.model.v26.datatype.*;
import ca.uhn.hl7v2.model.v26.segment.*;
import ca.uhn.hl7v2.parser.*;
import ch.lambdaj.function.convert.*;
import com.mongodb.*;
import com.mongodb.util.JSON;
import org.json.*;
import org.slf4j.*;

import java.util.*;

public class MessageToConverter implements Converter<String, Message>
{
    private static final Logger LOGGER = LoggerFactory.getLogger(MessageToConverter.class);
    private final PipeParser pipeParser;
    private final XMLParser xmlParser;

    public MessageToConverter(PipeParser pipeParser, XMLParser xmlParser)
    {
        this.pipeParser = pipeParser;
        this.xmlParser = xmlParser;
    }

    @Override public Message convert(String message)
    {
        try
        {
            ca.uhn.hl7v2.model.Message parsedMessage = pipeParser.parse(message);
            MSH msh = (MSH) parsedMessage.get("MSH");
            MSG messageType = msh.getMessageType();
            String messageTypeCode = messageType.getMessageCode().getValue();
            Date date = msh.getDateTimeOfMessage().getValueAsDate();
            String xml = xmlParser.encode(parsedMessage);
            String xmlToJson = XML.toJSONObject(xml).toString();
            xmlToJson = xmlToJson.replace(".", "");
            JSONObject jsonObject = JSONML.toJSONObject(xmlToJson);
            Object parsedObject = JSON.parse(jsonObject.toString());
            BasicDBObject parsedMessageToDBObject = (BasicDBObject) parsedObject;

            return new Message(date,
                    messageTypeCode,
                    parsedMessage.getVersion(),
                    message,
                    parsedMessageToDBObject);
        }
        catch (HL7Exception e)
        {
            LOGGER.error("Error converting HL7 message");
        }

        return null;
    }
}