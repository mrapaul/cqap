package web;

import com.peirs.datamodel.*;
import com.peirs.datamodel.dicom.*;
import com.vaadin.data.*;
import com.vaadin.data.util.*;
import com.vaadin.ui.*;
import org.jetbrains.annotations.*;
import org.vaadin.easyuploads.*;

import java.io.*;
import java.net.*;
import java.nio.file.*;

public class ExamReportView extends VerticalLayout
{
    private static final int TWO_MB_FILE_LIMIT = 2 * 1000 * 1024;
    @NotNull private final User user;
    @NotNull private final TextArea reportArea;
    @NotNull private final UploadField uploadField;
    @Nullable private ExamReportAttachListener listener;
    @Nullable private DicomStudy study;

    public ExamReportView(@NotNull User user)
    {
        this.user = user;
        reportArea = new TextArea();

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
                if (mimeType.contains("pdf"))
                {
                    try
                    {
                        return File.createTempFile("Patient_Report", ".pdf");
                    }
                    catch (IOException e)
                    {
                        Notification.show("Error uploading file : " + e.getMessage(), Notification.Type.ERROR_MESSAGE);
                    }
                }

                Notification.show("Please upload a PDF file containing the report", Notification.Type.ERROR_MESSAGE);

                return null;
            }
        });

        initLayout();
    }

    private void onFileUpload(@Nullable File file)
    {
        if (file != null)
        {
            long length = file.length();
            if (length < TWO_MB_FILE_LIMIT)
            {
                try
                {
                    if (listener != null && study != null)
                    {

                        String myReport = listener.uploadPatientReport(study, file);
                        reportArea.setValue(myReport);
                        uploadField.setValue(null);
                    }
                }
                catch (Exception e)
                {
                    Notification.show("Error uploading patient report, " + e.getMessage(),
                            Notification.Type.ERROR_MESSAGE);
                }
            }
            else
            {
                Notification.show("File size is limited to 2 MB", Notification.Type.ERROR_MESSAGE);
            }
        }
    }

    private void initLayout()
    {
        setSizeFull();
        setMargin(true);
        setSpacing(true);

        reportArea.setSizeFull();
        reportArea.setWordwrap(true);
        reportArea.setImmediate(true);
        reportArea.setNullRepresentation("No report available.");

        uploadField.setButtonCaption("Upload Patient Report");
        reportArea.addStyleName("report");

        addComponent(reportArea);
        addComponent(uploadField);
        setExpandRatio(reportArea, 1f);
        setComponentAlignment(uploadField, Alignment.BOTTOM_CENTER);

        if (user.getRole() != Role.QAD)
        {
            uploadField.setVisible(false);
        }
    }

    public void setDetails(@NotNull DicomStudy study, boolean editable)
    {
        this.study = study;
        reportArea.setPropertyDataSource(new MethodProperty(this.study, "patientReport"));

        uploadField.setVisible(editable);
        reportArea.setReadOnly(!editable);
    }

    public void setListener(@NotNull ExamReportAttachListener listener)
    {
        this.listener = listener;
    }
}
