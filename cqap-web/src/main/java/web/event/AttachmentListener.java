package web.event;

import com.peirs.datamodel.attachments.*;
import org.jetbrains.annotations.*;

import java.io.*;

public interface AttachmentListener
{

    void uploadAttachment(@NotNull File file);

    @NotNull InputStream openAttachment(@NotNull Attachment attachment) throws IOException;

    void deleteAttachment(@NotNull Attachment attachment);
}
