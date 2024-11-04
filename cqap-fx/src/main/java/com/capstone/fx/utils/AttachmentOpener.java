package com.capstone.fx.utils;

import com.cqap.client.*;
import com.peirs.datamodel.attachments.*;
import org.apache.commons.io.*;
import org.slf4j.*;

import java.io.*;

public final class AttachmentOpener
{
    private static final Logger LOGGER = LoggerFactory.getLogger(AttachmentOpener.class);

    private AttachmentOpener()
    {
        // empty
    }

    public static void open(ClientRestService aClientRestService, Attachment aAttachment)
    {
        try
        {
            String myFilename = aAttachment.getFilename();
            int mySeparator = myFilename.indexOf(".");
            File myFile = File.createTempFile(myFilename.substring(0, mySeparator), myFilename.substring(mySeparator));
            FileUtils.copyInputStreamToFile(aClientRestService.getTicketAttachment(aAttachment), myFile);
            myFile.deleteOnExit();
            if (isMac())
            {
                Runtime.getRuntime().exec(new String[]{"/usr/bin/open", myFile.getAbsolutePath()});
            }
            else
            {
                Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + myFile);
            }
        }
        catch (IOException e)
        {
            LOGGER.error("Error opening file", e);
        }
    }

    private static boolean isMac()
    {
        return System.getProperty("os.name").toLowerCase().contains("mac");
    }
}
