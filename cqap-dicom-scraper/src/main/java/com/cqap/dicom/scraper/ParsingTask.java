package com.cqap.dicom.scraper;

import java.nio.file.*;

public class ParsingTask implements Runnable
{
    private final DicomScraper theScraper;
    private final Path thePath;

    public ParsingTask(DicomScraper aScraper, Path aPath)
    {
        theScraper = aScraper;
        thePath = aPath;
    }

    @Override public void run()
    {
        theScraper.parseFiles(thePath.toFile());
    }
}
