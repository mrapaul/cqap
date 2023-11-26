package parser;

import ca.uhn.hl7v2.*;
import ca.uhn.hl7v2.model.*;
import ca.uhn.hl7v2.model.v26.message.*;
import com.lakeland.ris.ui.datamodel.*;
import org.jetbrains.annotations.*;
import org.slf4j.*;

import java.util.*;

public class HL7MessagesToDetailedOrderConverter
{
    private static final Logger LOGGER = LoggerFactory.getLogger(HL7MessagesToDetailedOrderConverter.class);
    @NotNull private final ORMParser ormParser;
    @NotNull private final OMGParser omgParser;
    @NotNull private final ADT_A01Parser adtA01Parser;

    public HL7MessagesToDetailedOrderConverter()
    {
        ormParser = new ORMParser();
        omgParser = new OMGParser();
        adtA01Parser = new ADT_A01Parser();
    }

    public DetailedOrder convert(Collection<Message> messages, DetailedOrderBuilder orderBuilder)
    {
        for (Message message : messages)
        {
            String name = message.getName();
            try
            {
                switch (name)
                {
                    case ("ORM_O01"):
                    {
                        ORM_O01 orm = (ORM_O01) message;
                        ormParser.convert(orm, orderBuilder);

                        break;
                    }
                    case ("OMG_O19"):
                    {
                        OMG_O19 orm = (OMG_O19) message;
                        omgParser.convert(orm, orderBuilder);

                        break;
                    }
                    case ("ADT_A01"):
                    {
                        ADT_A01 adt = (ADT_A01) message;
                        adtA01Parser.convert(adt, orderBuilder);
                        break;
                    }
                }
            }
            catch (HL7Exception e)
            {
                LOGGER.error("Error parsing {} message", name, e);
            }
        }

        return orderBuilder.build();
    }
}
