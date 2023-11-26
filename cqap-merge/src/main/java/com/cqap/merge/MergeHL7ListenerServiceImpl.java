package com.cqap.merge;

import com.cqap.client.*;
import com.merge.HL7.*;
import org.slf4j.*;
import org.springframework.context.*;
import org.springframework.context.annotation.*;

import java.util.concurrent.*;

public class MergeHL7ListenerServiceImpl implements MergeHL7ListenerService
{
    private static final Logger LOGGER = LoggerFactory.getLogger(MergeHL7ListenerServiceImpl.class);
    private final ExecutorService theService;
    private final ReceiverThread theReceiverThread;

    public MergeHL7ListenerServiceImpl()
    {
        System.setProperty("prod", Boolean.toString(true));
        ConfigurableApplicationContext myContext = new AnnotationConfigApplicationContext(ClientServiceProvider.class);
        theService = Executors.newSingleThreadExecutor();
        ClientRestService myClientRestService = myContext.getBean(ClientRestService.class);
        theReceiverThread = new ReceiverThread(new HL7ReceiverConfiguration(MergeRegistration.registerToolkit()),
                myClientRestService);
    }

    @Override public void startListener()
    {
        LOGGER.info("Starting HL7 Listener main");

        Runtime.getRuntime().addShutdownHook(new Thread()
        {
            @Override public void run()
            {
                // Stop the listener and terminate active connections
                LOGGER.error("Shutting down listener and terminating all connections");

                MergeHL7ListenerServiceImpl.this.stopListener();
            }
        });

        theService.submit(theReceiverThread);

        LOGGER.info("Started HL7 Listener main");
    }

    @Override public void stopListener()
    {
        LOGGER.info("Stopping HL7 Listener main");

        theReceiverThread.stop();
        theService.shutdown();

        LOGGER.info("Stopped HL7 Listener main");
    }
}
