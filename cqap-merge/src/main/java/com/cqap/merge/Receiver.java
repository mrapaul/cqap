package com.cqap.merge;

import com.cqap.client.*;
import com.merge.HL7.*;
import org.slf4j.*;

import java.util.*;

public class Receiver implements HL7ReceiverListener
{
    private static final Logger LOGGER = LoggerFactory.getLogger(Receiver.class);
    private static final Object OBJECT = new Object();
    private final Hashtable<String, ReceiverMessageHandler> theHandlers;
    private final ClientRestService theClientRestService;

    public Receiver(ClientRestService aClientRestService)
    {
        theClientRestService = aClientRestService;
        theHandlers = new Hashtable<>();
    }

    public HL7ReceiverMessageHandler getMessageHandler(String aSource)
    {
        if (aSource == null)
        {
            return null;
        }

        synchronized (OBJECT)
        {
            ReceiverMessageHandler myHandler = theHandlers.get(aSource);
            if (myHandler == null)
            {
                myHandler = new ReceiverMessageHandler(aSource, theClientRestService);
                theHandlers.put(aSource, myHandler);
            }
            return myHandler;
        }
    }

    public void listenerError(HL7Exception exception)
    {
        LOGGER.error("ERROR on listener " + exception.getMessage());
    }
}
