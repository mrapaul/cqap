package com.cqap.dicom.scraper;

import com.cqap.client.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.io.*;
import java.nio.file.*;
import java.util.concurrent.*;

@SpringBootApplication
public class DicomScraperMain {

    @Autowired
    private ClientRestService clientRestService;

    private final ScheduledExecutorService theExecutorService = Executors.newSingleThreadScheduledExecutor();
    private ParsingTask theParsingTask;

    public static void main(String[] anArguments) {
        SpringApplication.run(DicomScraperMain.class, anArguments);
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {
            if (args.length == 0) {
                usage();
            }

            start(args[0]);
        };
    }

    public void start(String aDirectory) {
        DicomScraper myDicomScraper = new DicomScraper(clientRestService);
        theParsingTask = new ParsingTask(myDicomScraper, Paths.get(aDirectory));

        theExecutorService.scheduleAtFixedRate(theParsingTask,
                0,
                5,
                TimeUnit.MINUTES);
    }

    static void usage() {
        System.err.println("usage: java DicomScraperMain dir");
        System.exit(-1);
    }
}
