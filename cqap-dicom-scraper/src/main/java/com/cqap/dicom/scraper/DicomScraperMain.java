package com.cqap.dicom.scraper;

import com.cqap.client.*;
import org.springframework.context.*;
import org.springframework.context.annotation.*;

import java.io.*;
import java.nio.file.*;
import java.util.concurrent.*;

public class DicomScraperMain
{
    private final ScheduledExecutorService theExecutorService;
    private final ParsingTask theParsingTask;

    public DicomScraperMain(String aDirectory)
    {
        theExecutorService = Executors.newSingleThreadScheduledExecutor();
        ConfigurableApplicationContext myContext = new AnnotationConfigApplicationContext(ClientServiceProvider.class);
        ClientRestService myClientRestService = myContext.getBean(ClientRestService.class);
        DicomScraper myDicomScraper = new DicomScraper(myClientRestService);
        theParsingTask = new ParsingTask(myDicomScraper, Paths.get(aDirectory));
    }

    public static void main(String[] anArguments) throws IOException
    {
        if (anArguments.length == 0)
        {
            usage();
        }

        System.setProperty("prod", Boolean.toString(true));
        new DicomScraperMain(anArguments[0]).start();
    }

    public void start()
    {
        theExecutorService.scheduleAtFixedRate(theParsingTask,
                0,
                5,
                TimeUnit.MINUTES);

    }

    static void usage()
    {
        System.err.println("usage: java DicomScraperMain dir");
        System.exit(-1);
    }
}
