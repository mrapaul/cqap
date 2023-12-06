package web;

import com.peirs.datamodel.attachments.*;
import com.vaadin.data.*;
import com.vaadin.data.util.*;
import com.vaadin.server.*;
import com.vaadin.ui.*;
import org.apache.commons.io.*;
import org.jetbrains.annotations.*;
import org.slf4j.*;
import org.vaadin.easyuploads.*;
import web.event.*;

import java.io.*;
import java.util.*;

public final class AttachmentsView extends Panel
{
    private static final Logger LOGGER = LoggerFactory.getLogger(AttachmentsView.class);
    private static final int TWO_MB_FILE_LIMIT = 2 * 1000 * 1024;
    @NotNull private final AttachmentListener listener;
    @NotNull private final Table table;
    @NotNull private final Button download;
    @NotNull private final Button delete;
    @NotNull private final BeanContainer<String, Attachment> container;
    @NotNull private final UploadField uploadField;

    public AttachmentsView(@NotNull AttachmentListener listener)
    {
        this.listener = listener;
        table = new Table();
        download = new Button();
        delete = new Button();
        container = new BeanContainer<>(Attachment.class);
        container.setBeanIdResolver(new AbstractBeanContainer.BeanIdResolver<String, Attachment>()
        {
            @Override public String getIdForBean(Attachment bean)
            {
                return bean.getId();
            }
        });

        uploadField = new UploadField();
        uploadField.setFieldType(UploadField.FieldType.FILE);
        uploadField.setMaxFileSize(TWO_MB_FILE_LIMIT);
        uploadField.setFileDeletesAllowed(false);
        uploadField.setImmediate(false);
        uploadField.addValueChangeListener(new Property.ValueChangeListener()
        {
            @Override public void valueChange(Property.ValueChangeEvent event)
            {
                Object value = uploadField.getValue();
                if (value != null)
                {
                    onFileUpload((File) value);
                }
            }
        });
        uploadField.setFileFactory(new FileFactory()
        {
            public File createFile(String fileName, String mimeType)
            {
                if (mimeType.contains("pdf") || mimeType.contains("doc"))
                {
                    return new File(new File(System.getProperty("java.io.tmpdir")).getPath() + "/" + fileName);
                }

                Notification.show("Please upload a PDF/MS Office file", Notification.Type.ERROR_MESSAGE);

                return null;
            }
        });

        initLayout();
        initTable();
        initListeners();
    }


    private void onFileUpload(@NotNull File file)
    {
        LOGGER.info("Uploading attachment " + file);

        try
        {
            long length = file.length();
            if (length < TWO_MB_FILE_LIMIT)
            {
                listener.uploadAttachment(file);
                uploadField.setValue(null);
            }
            else
            {
                Notification.show("File size is limited to 2 MB", Notification.Type.ERROR_MESSAGE);
            }
        }
        catch (Exception e)
        {
            Notification.show("Error uploading file " + e.getMessage(), Notification.Type.ERROR_MESSAGE);

            LOGGER.error("Error uploading file", e);
        }
    }

    private void initTable()
    {
        table.setContainerDataSource(container);
        table.setStyleName("plain");
        table.setSizeFull();
        table.setImmediate(true);
        table.setSelectable(true);
        table.addValueChangeListener(new Property.ValueChangeListener()
        {
            public void valueChange(Property.ValueChangeEvent event)
            {
                download.setEnabled(table.getValue() != null);
            }
        });
    }

    private void initLayout()
    {
        setSizeFull();
        setWidth("100%");
        setImmediate(true);

        delete.setIcon(FontAwesome.TRASH_O);
        download.setIcon(FontAwesome.DOWNLOAD);
        uploadField.setButtonCaption("Upload Attachment");
        HorizontalLayout buttonBar = new HorizontalLayout(delete, download);
        buttonBar.setWidth("100%");
        buttonBar.setComponentAlignment(download, Alignment.MIDDLE_RIGHT);
        buttonBar.setComponentAlignment(download, Alignment.MIDDLE_LEFT);
        VerticalLayout content = new VerticalLayout(uploadField, table, buttonBar);
        content.setSizeFull();
        content.setMargin(true);
        download.setEnabled(false);
        content.setExpandRatio(table, 1);
        setContent(content);
    }

    private void initListeners()
    {
        OnDemandFileDownloader.OnDemandStreamResource streamResource =
                new OnDemandFileDownloader.OnDemandStreamResource()
                {
                    @Override public String getFilename()
                    {
                        BeanItem<Attachment> item = getSelected();
                        Attachment attachment = item.getBean();
                        return attachment.getFilename();
                    }

                    @Override public InputStream getStream()
                    {
                        try
                        {
                            BeanItem<Attachment> item = getSelected();
                            Attachment attachment = item.getBean();
                            String myFilename = attachment.getFilename();
                            int mySeparator = myFilename.indexOf(".");
                            File
                                    file =
                                    File.createTempFile(myFilename.substring(0, mySeparator),
                                            myFilename.substring(mySeparator));
                            FileUtils.copyInputStreamToFile(listener.openAttachment(attachment), file);
                            file.deleteOnExit();
                            return new FileInputStream(file);
                        }
                        catch (IOException e)
                        {
                            Notification.show("Error opening file",
                                    "File Download Error",
                                    Notification.Type.ERROR_MESSAGE);
                        }
                        return null;
                    }

                    private BeanItem<Attachment> getSelected()
                    {
                        Object itemId = table.getValue();
                        return container.getItem(itemId);
                    }
                };

        OnDemandFileDownloader downloader = new OnDemandFileDownloader(streamResource);
        downloader.extend(download);

        delete.addClickListener(new Button.ClickListener()
        {
            @Override public void buttonClick(Button.ClickEvent event)
            {
                Object itemId = table.getValue();
                if (itemId != null)
                {
                    BeanItem<Attachment> item = container.getItem(itemId);
                    Attachment attachment = item.getBean();
                    listener.deleteAttachment(attachment);
                }
                else
                {
                    Notification.show("Please select an attachment to delete", Notification.Type.ERROR_MESSAGE);
                }
            }
        });
    }

    public void displayAttachments(Collection<Attachment> attachments)
    {
        container.removeAllItems();
        container.removeAllContainerFilters();
        container.addAll(attachments);
        table.setVisibleColumns("filename", "uploadDate");
        table.setColumnHeader("filename", "File");
        table.setColumnHeader("uploadDate", "Date");
        table.setPageLength(attachments.size());
    }
}
