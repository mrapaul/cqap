package com.cqap.dicom.scraper;

import org.slf4j.*;

import java.nio.file.*;

import static java.nio.file.StandardWatchEventKinds.*;
import static java.nio.file.LinkOption.*;

import java.nio.file.attribute.*;
import java.io.*;
import java.util.*;

public class DirectoryWatcher
{
    private static final Logger LOGGER = LoggerFactory.getLogger(DicomScraper.class);
    private final WatchService theWatchService;
    private final Map<WatchKey, Path> theWatchKeys;
    private final boolean theRecursive;
    private final DicomScraper theDicomScraper;
    private boolean theTrace;

    DirectoryWatcher(Path aDirectory, boolean aRecursive, DicomScraper aDicomScraper) throws IOException
    {
        theDicomScraper = aDicomScraper;
        theWatchService = FileSystems.getDefault().newWatchService();
        theWatchKeys = new HashMap<>();
        theRecursive = aRecursive;

        if (theRecursive)
        {
            LOGGER.info("Scanning recursively {} ...\n", aDirectory);
            registerAll(aDirectory);
            LOGGER.info("Finished scanning.");
        }
        else
        {
            register(aDirectory);
        }
        theTrace = true;
    }

    @SuppressWarnings("unchecked")
    static <T> WatchEvent<T> cast(WatchEvent<?> aWatchEvent)
    {
        return (WatchEvent<T>) aWatchEvent;
    }

    private void register(Path aDirectory) throws IOException
    {
        WatchKey myWatchKey = aDirectory.register(theWatchService, ENTRY_CREATE, ENTRY_DELETE, ENTRY_MODIFY);
        if (theTrace)
        {
            Path myPreviousPath = theWatchKeys.get(myWatchKey);
            if (myPreviousPath == null)
            {
                LOGGER.info("register: {}\n", aDirectory);
            }
            else
            {
                if (!aDirectory.equals(myPreviousPath))
                {
                    LOGGER.info("update: {} -> {}\n", myPreviousPath, aDirectory);
                }
            }
        }
        theWatchKeys.put(myWatchKey, aDirectory);
    }

    private void registerAll(final Path aStart) throws IOException
    {
        Files.walkFileTree(aStart, new SimpleFileVisitor<Path>()
        {
            @Override
            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs)
            throws IOException
            {
                LOGGER.info("Registering directory : " + dir);
                register(dir);
                return FileVisitResult.CONTINUE;
            }
        });
    }

    /**
     * Process all events for theWatchKeys queued to the theWatchService
     */
    void processEvents()
    {
        for (; ; )
        {
            WatchKey myKey;
            try
            {
                myKey = theWatchService.take();
            }
            catch (InterruptedException x)
            {
                return;
            }

            Path dir = theWatchKeys.get(myKey);
            if (dir == null)
            {
                LOGGER.error("WatchKey not recognized!!");
                continue;
            }

            for (WatchEvent<?> myWatchEvent : myKey.pollEvents())
            {
                WatchEvent.Kind kind = myWatchEvent.kind();

                // TBD - provide example of how OVERFLOW event is handled
                if (kind == OVERFLOW)
                {
                    continue;
                }

                // Context for directory entry event is the file name of entry
                WatchEvent<Path> myDirectoryEvent = cast(myWatchEvent);
                Path myDirectory = myDirectoryEvent.context();
                Path myChildDirectory = dir.resolve(myDirectory);

                // print out event
                LOGGER.info("{}: {}\n", myWatchEvent.kind().name(), myChildDirectory);

                // if directory is created, and watching recursively, then
                // register it and its sub-directories
                if (theRecursive && (kind == ENTRY_CREATE))
                {
                    try
                    {
                        if (Files.isDirectory(myChildDirectory, NOFOLLOW_LINKS))
                        {
                            registerAll(myChildDirectory);
                        }
                    }
                    catch (IOException aException)
                    {
                        LOGGER.error("Error registering child directories", aException);
                    }

                    LOGGER.info("Parsing directory : " + myChildDirectory);
                    theDicomScraper.parseFiles(myChildDirectory.toFile());
                }
            }

            // reset myKey and remove from set if directory no longer accessible
            boolean isValid = myKey.reset();
            if (!isValid)
            {
                theWatchKeys.remove(myKey);

                // all directories are inaccessible
                if (theWatchKeys.isEmpty())
                {
                    break;
                }
            }
        }
    }
}
