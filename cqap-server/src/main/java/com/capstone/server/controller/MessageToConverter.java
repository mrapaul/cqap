package com.capstone.server.controller;

import ca.uhn.hl7v2.*;
import ca.uhn.hl7v2.model.v26.datatype.*;
import ca.uhn.hl7v2.model.v26.segment.*;
import ca.uhn.hl7v2.parser.*;
import ch.lambdaj.function.convert.*;
import com.mongodb.*;
import org.jetbrains.annotations.*;
import org.json.*;
import org.slf4j.*;

import java.util.*;

public class MessageToConverter implements Converter<String, Message>
{
    private static final Logger LOGGER = LoggerFactory.getLogger(MessageToConverter.class);
    @NotNull private final PipeParser pipeParser;
    @NotNull private final XMLParser xmlParser;

    public MessageToConverter(@NotNull PipeParser pipeParser, @NotNull XMLParser xmlParser)
    {
        this.pipeParser = pipeParser;
        this.xmlParser = xmlParser;
    }

    @Nullable
    @Override public Message convert(@NotNull String message)
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
            BasicDBObject parsedMessageToDBObject = BasicDBObject.parse(jsonObject.toString());

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