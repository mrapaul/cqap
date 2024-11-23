package web;

import com.peirs.datamodel.*;
import com.peirs.datamodel.dicom.*;
import com.vaadin.data.util.*;
import com.vaadin.server.*;
import com.vaadin.shared.ui.*;
import com.vaadin.ui.*;

import org.vaadin.maddon.layouts.*;

import java.util.*;

public class EditExamView extends VerticalLayout
{
    private final User user;
    private final StudyDetailsView studyDetailsView;
    private final DicomTagsView dicomTagsView;
    private final ExamReportView examReportView;
    private final RelatedExamsView relatedExamsView;
    private final Button saveButton;
    private final Button closeButton;
    private final TabSheet tabsheet;
    private NewTicketView.Listener listener;
    private DicomStudy study;

    public EditExamView(User user, TabSheet tabsheet, BeanContainer<String, Institution> containerDataSource)
    {
        this.user = user;
        this.tabsheet = tabsheet;
        studyDetailsView = new StudyDetailsView(this.user, containerDataSource);
        dicomTagsView = new DicomTagsView();
        examReportView = new ExamReportView(this.user);
        relatedExamsView = new RelatedExamsView();
        saveButton = new Button();
        closeButton = new Button();

        initLayout();
        initListeners();
    }

    private void initLayout()
    {
        setSizeFull();
        setMargin(new MarginInfo(true, false, true, false));

        Accordion accordion = new Accordion();
        accordion.addTab(dicomTagsView, "Additional Exam Details");
        accordion.addTab(relatedExamsView, "Related Exams");
        accordion.setSizeFull();

        Panel accordionPanel = new Panel("Details", accordion);
        accordionPanel.setSizeFull();
        Panel examReportPanel = new Panel("Exam Report", examReportView);
        examReportPanel.setSizeFull();
        VerticalLayout leftLayout = new VerticalLayout();
        leftLayout.setSizeFull();
        HorizontalSplitPanel splitPanel = new HorizontalSplitPanel(examReportPanel, accordionPanel);
        splitPanel.setSplitPosition(60, Unit.PERCENTAGE);

        VerticalSplitPanel verticalSplitPanel = new VerticalSplitPanel(studyDetailsView, splitPanel);
        verticalSplitPanel.setSplitPosition(45, Unit.PERCENTAGE);
        addComponent(verticalSplitPanel);
        setExpandRatio(verticalSplitPanel, 1f);
        saveButton.addStyleName("fq");
        closeButton.addStyleName("fq");
        saveButton.setIcon(FontAwesome.SAVE);
        closeButton.setIcon(FQIcons.CLOSE);
        MHorizontalLayout innerButtonLayout = new MHorizontalLayout(saveButton, closeButton).withSpacing(true);
        HorizontalLayout
                bottomLayout =
                new MHorizontalLayout(innerButtonLayout).withSpacing(true).withMargin(true)
                        .withFullWidth()
                        .withAlign(innerButtonLayout, Alignment.BOTTOM_RIGHT);
        addComponent(bottomLayout);
    }

    private void initListeners()
    {
        saveButton.addClickListener(new Button.ClickListener()
        {
            @Override public void buttonClick(Button.ClickEvent event)
            {
                if (listener != null)
                {
                    listener.saveStudy(study);
                    closeEditor();
                }
            }
        });
        closeButton.addClickListener(new Button.ClickListener()
        {
            @Override public void buttonClick(Button.ClickEvent event)
            {
                closeEditor();
            }
        });
    }

    private void closeEditor()
    {
        tabsheet.removeComponent(this);
    }

    public void setDetails(DicomStudy study, Collection<DicomStudy> relatedExams)
    {
        this.study = study;
        studyDetailsView.setDetails(this.study, null);
        dicomTagsView.setDetails(this.study);
        examReportView.setDetails(this.study, true);
        relatedExamsView.display(relatedExams);
    }

    public void setListener(NewTicketView.Listener listener)
    {
        this.listener = listener;
        examReportView.setListener(listener);
    }
}
