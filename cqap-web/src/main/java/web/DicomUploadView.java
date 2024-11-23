package web;

import com.vaadin.ui.*;

import org.vaadin.easyuploads.*;

import java.io.*;

public class DicomUploadView extends Window
{
    private final MultiFileUpload uploadField;
    private final Button closeButton;

    public DicomUploadView(final NewTicketView.Listener listener)
    {
        uploadField = new MultiFileUpload()
        {
            @Override protected void handleFile(File file, String fileName, String mimeType, long length)
            {
                String report = listener.uploadFile(file);
                if (report != null)
                {
                    Notification.show(report, Notification.Type.HUMANIZED_MESSAGE);
                }
            }
        };
        uploadField.setUploadButtonCaption("Upload DICOM Image(s)");
        closeButton = new Button("Close");

        initLayout();
        initListeners();
    }

    private void initLayout()
    {
        setCaption("Upload Images");
        setModal(true);
        setHeight(600, Unit.PIXELS);
        setWidth(400, Unit.PIXELS);
        setResizable(false);

        VerticalLayout layout = new VerticalLayout();
        layout.setSizeFull();
        layout.setMargin(true);
        layout.addStyleName("search");

        layout.addComponent(uploadField);
        layout.addComponent(closeButton);
        uploadField.addStyleName("fq");
        closeButton.addStyleName("fq");
        layout.setComponentAlignment(uploadField, Alignment.MIDDLE_CENTER);
        layout.setComponentAlignment(closeButton, Alignment.BOTTOM_CENTER);

        setContent(layout);
        UI.getCurrent().addWindow(this);
    }

    private void initListeners()
    {
        closeButton.addClickListener(new Button.ClickListener()
        {
            @Override public void buttonClick(Button.ClickEvent event)
            {
                UI.getCurrent().removeWindow(DicomUploadView.this);
            }
        });
    }
}
