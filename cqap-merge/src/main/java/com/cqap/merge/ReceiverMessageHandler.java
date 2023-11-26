package com.cqap.merge;

import com.cqap.client.*;
import com.merge.HL7.*;
import com.peirs.datamodel.hl7.*;
import org.slf4j.*;


public class ReceiverMessageHandler implements HL7ReceiverMessageHandler
{
    private static final Logger LOGGER = LoggerFactory.getLogger(ReceiverMessageHandler.class);
    private final ClientRestService theClientRestService;
    private String theSource = null;

    public ReceiverMessageHandler(String aSource, ClientRestService aClientRestService)
    {
        theSource = aSource;
        theClientRestService = aClientRestService;
    }

    /*
     * This method is called by the receiver whenever a new message is received.
     */
    public String messageReceived(String aMessage)
    {
        LOGGER.info("Message received");

        theClientRestService.createHL7Message(new MergeHL7Message(aMessage));
        // message accepted
        return "";
    }

    /*
     * This method is called by the receiver whenever a receiving error occurs.
     */
    public void receiverError(HL7Exception exception)
    {
        LOGGER.info("ERROR on connection " + theSource + " : " + exception.getMessage());
    }

    /*
     * This method is called by the receiver whenever a new network connection is established.
     */
    public void connectionEstablished()
    {
        LOGGER.info("Connection from " + theSource);
    }

    /*
     * This method is called by the receiver whenever a network connection is terminated.
     */
    public void connectionEnded()
    {
        LOGGER.info("Connection with " + theSource + " ended");
    }
}
