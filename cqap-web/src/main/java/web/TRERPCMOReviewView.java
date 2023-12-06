package web;

import com.peirs.datamodel.ticket.*;
import com.vaadin.data.*;
import com.vaadin.data.util.*;
import com.vaadin.ui.*;
import org.jetbrains.annotations.*;

import java.util.*;

import static web.ComponentFactory.*;

public class TRERPCMOReviewView extends CssLayout
{
    @NotNull private final ComboBox categoryField;
    @NotNull private final TextField medicalImageQualityScoreField;
    @NotNull private final TextArea medicalImageQualityCommentsField;
    @NotNull private final CheckBox technicalImageQualityCriteria1Field;
    @NotNull private final CheckBox technicalImageQualityCriteria2Field;
    @NotNull private final CheckBox technicalImageQualityCriteria3Field;
    @NotNull private final CheckBox technicalImageQualityCriteria4Field;
    @NotNull private final CheckBox technicalImageQualityCriteria5Field;
    @NotNull private final TextArea technicalImageQualityCommentsField;
    @NotNull private final TextArea recommendationsField;
    @NotNull private final TextField reportQualityField;
    @NotNull private final TextField reporterField;
    @NotNull private final DateField reportTimeField;

    public TRERPCMOReviewView()
    {
        categoryField = createFormComboBoxField("Category", Arrays.asList(TechTicketCategory.values()));
        medicalImageQualityScoreField = createFormTextField("Medical Image Quality Score");
        medicalImageQualityCommentsField = createFormTextArea("Medical Image Quality Comments");
        technicalImageQualityCriteria1Field = createFormCheckBox(TechTicketQualityCriteria.CRITERIA1
                .getCriteriaDescription());
        technicalImageQualityCriteria2Field =
                createFormCheckBox(TechTicketQualityCriteria.CRITERIA2.getCriteriaDescription());
        technicalImageQualityCriteria3Field =
                createFormCheckBox(TechTicketQualityCriteria.CRITERIA3.getCriteriaDescription());
        technicalImageQualityCriteria4Field =
                createFormCheckBox(TechTicketQualityCriteria.CRITERIA4.getCriteriaDescription());
        technicalImageQualityCriteria5Field =
                createFormCheckBox(TechTicketQualityCriteria.CRITERIA5.getCriteriaDescription());
        technicalImageQualityCommentsField = createFormTextArea("Technical Image Quality comments");
        recommendationsField = createFormTextArea("Recommendations (if any)");
        reportQualityField = new TextField("Technical Image Quality Score");
        reporterField = createFormTextField("Reporter");
        reportTimeField = createFormDateField("Report Date");

        initLayout();
    }

    private void initLayout()
    {
        setSizeFull();
        medicalImageQualityCommentsField.addStyleName("report");
        technicalImageQualityCommentsField.addStyleName("report");
        recommendationsField.addStyleName("report");
        medicalImageQualityCommentsField.setNullRepresentation("");
        technicalImageQualityCommentsField.setNullRepresentation("");
        recommendationsField.setNullRepresentation("");
        reporterField.setNullRepresentation("");
        reportQualityField.setWidth("50px");
        reporterField.setWidth("300px");
        medicalImageQualityScoreField.setEnabled(false);

        Panel accuracyPanel = new Panel("Medical Image Quality", fullWidthVerticalLayout(categoryField,
                medicalImageQualityScoreField,
                medicalImageQualityCommentsField));
        HorizontalLayout layout = fullWidthHorizontalLayout(technicalImageQualityCommentsField, recommendationsField);
        layout.setSpacing(true);
        Panel qualityPanel = new Panel("Technical Image Quality", fullWidthVerticalLayout(technicalImageQualityCriteria1Field,
                technicalImageQualityCriteria2Field,
                technicalImageQualityCriteria3Field,
                technicalImageQualityCriteria4Field,
                technicalImageQualityCriteria5Field,
                layout));

        HorizontalLayout layout2 = new HorizontalLayout(reportQualityField, reporterField, reportTimeField);
        layout2.setSpacing(true);
        HorizontalLayout layout1 = new HorizontalLayout(accuracyPanel, qualityPanel);
        layout1.setSpacing(true);
        layout1.setSizeFull();
        layout1.setExpandRatio(accuracyPanel, 1f);
        layout1.setExpandRatio(qualityPanel, 2f);

        VerticalLayout content = fullWidthVerticalLayout(layout1, layout2);
        content.setMargin(true);
        content.setSpacing(true);
        content.setSizeFull();
        addComponent(content);
    }

    public void displayReport(@NotNull final ProfessionalTicket ticket, boolean editable)
    {
        if (ticket.getTechReport() == null)
        {
            ticket.setTechReport(new TechReport());
        }
        medicalImageQualityCommentsField.setPropertyDataSource(new NestedMethodProperty(ticket,
                "TechReport.MedicalImageQualityComments"));
        technicalImageQualityCriteria1Field.setPropertyDataSource(new NestedMethodProperty(ticket,
                "TechReport.Criteria1"));
        technicalImageQualityCriteria2Field.setPropertyDataSource(new NestedMethodProperty(ticket,
                "TechReport.Criteria2"));
        technicalImageQualityCriteria3Field.setPropertyDataSource(new NestedMethodProperty(ticket,
                "TechReport.Criteria3"));
        technicalImageQualityCriteria4Field.setPropertyDataSource(new NestedMethodProperty(ticket,
                "TechReport.Criteria4"));
        technicalImageQualityCriteria5Field.setPropertyDataSource(new NestedMethodProperty(ticket,
                "TechReport.Criteria5"));
        technicalImageQualityCommentsField.setPropertyDataSource(new NestedMethodProperty(ticket,
                "TechReport.TechnicalImageQualityComments"));
        recommendationsField.setPropertyDataSource(new NestedMethodProperty(ticket,
                "TechReport.Recommendation"));
        reportQualityField.setPropertyDataSource(new NestedMethodProperty(ticket,
                "TechReport.ReportQuality"));
        reporterField.setPropertyDataSource(new NestedMethodProperty(ticket,
                "TechReport.ERP.name"));
        reportTimeField.setPropertyDataSource(new NestedMethodProperty(ticket,
                "TechReport.ReportCompletedTime"));
        TechReport techReport = ticket.getTechReport();
        if (techReport != null)
        {
            TechTicketCategory category = TechTicketCategory.lookup(techReport.getCategory());
            if (category != null)
            {
                categoryField.setValue(category);
                if (ticket.getStatus() != TicketStatus.TECH_OPEN_ERP_REVIEW)
                {
                    medicalImageQualityScoreField.setValue(String.valueOf(category.getScore()));
                }
            }
        }

        categoryField.addValueChangeListener(new Property.ValueChangeListener()
        {
            @Override public void valueChange(Property.ValueChangeEvent event)
            {
                Object value = categoryField.getValue();
                if (value != null)
                {
                    TechTicketCategory category = (TechTicketCategory) value;
                    if (category != null)
                    {
                        categoryField.setValue(category);
                        ticket.getTechReport().setCategory(category.getCode());
                    }
                }
            }
        });
        setEditable(editable);
    }

    private void setEditable(boolean editable)
    {
        categoryField.setReadOnly(!editable);
        medicalImageQualityCommentsField.setReadOnly(!editable);
        technicalImageQualityCriteria1Field.setReadOnly(!editable);
        technicalImageQualityCriteria2Field.setReadOnly(!editable);
        technicalImageQualityCriteria3Field.setReadOnly(!editable);
        technicalImageQualityCriteria4Field.setReadOnly(!editable);
        technicalImageQualityCriteria5Field.setReadOnly(!editable);
        technicalImageQualityCommentsField.setReadOnly(!editable);
        recommendationsField.setReadOnly(!editable);

        reporterField.setReadOnly(true);
        reportTimeField.setReadOnly(true);
        reportQualityField.setReadOnly(true);
    }
}
