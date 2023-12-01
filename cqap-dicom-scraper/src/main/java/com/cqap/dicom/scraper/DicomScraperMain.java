package com.cqap.dicom.scraper;

import com.cqap.client.ClientRestService;
import jakarta.annotation.PreDestroy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.nio.file.Paths;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


@SpringBootApplication(scanBasePackages = {"com.cqap.*"})
public class DicomScraperMain {

    private static final Logger logger = LoggerFactory.getLogger(DicomScraperMain.class);

    private final ClientRestService clientRestService;
    private final ScheduledExecutorService theExecutorService;
    private ParsingTask theParsingTask;

    public DicomScraperMain(ClientRestService clientRestService) {
        this.clientRestService = clientRestService;
        this.theExecutorService = Executors.newSingleThreadScheduledExecutor();
    }

    public static void main(String[] args) {
        SpringApplication.run(DicomScraperMain.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner() {
        return args -> {
            if (args.length == 0) {
                logger.error("No directory provided. Usage: java DicomScraperMain dir");
                System.exit(-1);
            }
            start(args[0]);
        };
    }

    public void start(String aDirectory) {
        logger.info("Starting Dicom Scraper for directory: {}", aDirectory);
        DicomScraper myDicomScraper = new DicomScraper(clientRestService);
        theParsingTask = new ParsingTask(myDicomScraper, Paths.get(aDirectory));
        theExecutorService.scheduleAtFixedRate(theParsingTask, 0, 5, TimeUnit.SECONDS);
        logger.info("Started Dicom Scraper for directory: {}", aDirectory);
    }

    @PreDestroy
    public void cleanUp() {
        logger.info("Shutting down executor service");
        theExecutorService.shutdown();
    }
}
