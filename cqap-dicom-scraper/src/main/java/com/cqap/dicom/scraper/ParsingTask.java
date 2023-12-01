package com.cqap.dicom.scraper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.nio.file.*;

public class ParsingTask implements Runnable
{
    private static final Logger LOGGER = LoggerFactory.getLogger(ParsingTask.class);
    private final DicomScraper theScraper;
    private final Path thePath;

    public ParsingTask(DicomScraper aScraper, Path aPath)
    {
        theScraper = aScraper;
        thePath = aPath;
    }

    @Override public void run()
    {
        LOGGER.info("Parsing files in directory {}", thePath.toAbsolutePath());
        theScraper.parseFiles(thePath.toFile());
        LOGGER.info("Finished parsing files in directory {}", thePath.toAbsolutePath());
    }
}
