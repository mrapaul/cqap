package web.event;

import com.peirs.datamodel.attachments.*;


import java.io.*;

public interface AttachmentListener
{

    void uploadAttachment(File file);

    InputStream openAttachment(Attachment attachment) throws IOException;

    void deleteAttachment(Attachment attachment);
}
