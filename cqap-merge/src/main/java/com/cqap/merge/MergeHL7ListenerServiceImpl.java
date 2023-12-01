package com.cqap.merge;
import com.cqap.client.ClientRestService;
import com.merge.HL7.HL7ReceiverConfiguration;
import jakarta.annotation.PreDestroy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
@Scope("singleton")
public class MergeHL7ListenerServiceImpl implements MergeHL7ListenerService {

    private static final Logger LOGGER = LoggerFactory.getLogger(MergeHL7ListenerServiceImpl.class);

    private final ExecutorService theService = Executors.newSingleThreadExecutor();
    private final ReceiverThread theReceiverThread;

    @Autowired
    public MergeHL7ListenerServiceImpl(ClientRestService clientRestService) {
        // Assuming HL7ReceiverConfiguration and MergeRegistration are managed beans or can be autowired
        this.theReceiverThread = new ReceiverThread(new HL7ReceiverConfiguration(MergeRegistration.registerToolkit()),
                clientRestService);
        addShutdownHook();
    }

    private void addShutdownHook() {
        Runtime.getRuntime().addShutdownHook(new Thread(this::stopListener));
    }

    @Override
    public void startListener() {
        LOGGER.info("Starting HL7 Listener main");
        theService.submit(theReceiverThread);
        LOGGER.info("Started HL7 Listener main");
    }

    @Override
    public void stopListener() {
        LOGGER.info("Stopping HL7 Listener main");
        theReceiverThread.stop();
        theService.shutdown();
        LOGGER.info("Stopped HL7 Listener main");
    }

    @PreDestroy
    private void cleanUp() {
        LOGGER.info("Cleaning up before shutdown");
        stopListener();
    }
}
