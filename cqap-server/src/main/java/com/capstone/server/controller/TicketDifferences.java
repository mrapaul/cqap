package com.capstone.server.controller;

import com.fasterxml.jackson.databind.*;
import com.peirs.datamodel.ticket.*;
import org.slf4j.*;

import java.io.*;
import java.util.*;

public class TicketDifferences
{
    private static final Logger LOGGER = LoggerFactory.getLogger(TicketDifferences.class);
    private final ObjectMapper theMapper;

    public TicketDifferences()
    {
        theMapper = new ObjectMapper();
    }

    public String getDifference(ProfessionalTicket aTicket1,
                                ProfessionalTicket aTicket2)
    {
        try
        {
            JsonNode myExisitingTicketStr = theMapper.readTree(theMapper.writeValueAsString(aTicket1));
            JsonNode myCurrentTicketStr = theMapper.readTree(theMapper.writeValueAsString(aTicket2));
            StringBuilder myDiffBuilder = new StringBuilder();
            Iterator<Map.Entry<String, JsonNode>> myFields = myCurrentTicketStr.fields();
            while (myFields.hasNext())
            {
                Map.Entry<String, JsonNode> myNext = myFields.next();
                JsonNode myJsonNode = myExisitingTicketStr.get(myNext.getKey());
                if (myJsonNode != null)
                {
                    if (myNext.getValue() != null &&
                            myNext.getValue().textValue() != null &&
                            myJsonNode.textValue() != null &&
                            !myNext.getValue().textValue().equalsIgnoreCase(myJsonNode.textValue()))
                    {
                        myDiffBuilder.append("Changed ")
                                .append(myNext.getKey())
                                .append(" from ")
                                .append(myNext.getValue().textValue())
                                .append(" to ")
                                .append(myJsonNode.textValue())
                                .append("\n");
                    }
                }
            }
            return myDiffBuilder.toString().trim();
        }
        catch (IOException anException)
        {
            LOGGER.error("Error recording ticket diff", anException);
        }

        return null;
    }
}
