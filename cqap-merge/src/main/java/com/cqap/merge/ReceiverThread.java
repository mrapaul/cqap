package com.cqap.merge;

import com.cqap.client.*;
import com.merge.HL7.*;
import org.slf4j.*;

public class ReceiverThread implements Runnable
{
    private static final Logger LOGGER = LoggerFactory.getLogger(ReceiverThread.class);
    private final HL7Receiver theHL7Receiver;

    public ReceiverThread(HL7ReceiverConfiguration aConfig, ClientRestService aRepository)
    {
         theHL7Receiver = new HL7Receiver(aConfig, new Receiver(aRepository));
    }

    @Override public void run()
    {
        LOGGER.info("Starting Merge HL7 Receiver");

        theHL7Receiver.start();

        LOGGER.info("Started Merge HL7 Receiver");
    }

    public void stop()
    {
        LOGGER.info("Stopping Merge HL7 Receiver");

        theHL7Receiver.stop(true);

        LOGGER.info("Stopped Merge HL7 Receiver");
    }
}
