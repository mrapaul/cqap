package web;

import com.peirs.datamodel.ticket.*;
import com.vaadin.data.*;
import com.vaadin.data.util.*;
import com.vaadin.ui.*;
import org.jetbrains.annotations.*;

import java.util.*;

import static web.ComponentFactory.*;

public class PRERPCMOReviewView extends CssLayout
{
    @NotNull private final ComboBox categoryField;
    @NotNull private final TextField reportAccuracyScoreField;
    @NotNull private final TextArea reportAccuracyCommentsField;
    @NotNull private final CheckBox reportQualityCriteria1Field;
    @NotNull private final CheckBox reportQualityCriteria2Field;
    @NotNull private final CheckBox reportQualityCriteria3Field;
    @NotNull private final CheckBox reportQualityCriteria4Field;
    @NotNull private final CheckBox reportQualityCriteria5Field;
    @NotNull private final TextArea reportQualityCommentsField;
    @NotNull private final TextArea recommendationsField;
    @NotNull private final TextArea affsField;
    @NotNull private final TextField reportQualityField;
    @NotNull private final TextField reporterField;
    @NotNull private final DateField reportTimeField;

    public PRERPCMOReviewView()
    {
        categoryField = createFormComboBoxField("Category", Arrays.asList(ProfessionalTicketCategory.values()));
        reportAccuracyScoreField = createFormTextField("Accuracy Score");
        reportAccuracyCommentsField = createFormTextArea("Accuracy Comments");
        reportQualityCriteria1Field = createFormCheckBox(ProfessionalTicketQualityCriteria.CRITERIA1
                .getCriteriaDescription());
        reportQualityCriteria2Field =
                createFormCheckBox(ProfessionalTicketQualityCriteria.CRITERIA2.getCriteriaDescription());
        reportQualityCriteria3Field =
                createFormCheckBox(ProfessionalTicketQualityCriteria.CRITERIA3.getCriteriaDescription());
        reportQualityCriteria4Field =
                createFormCheckBox(ProfessionalTicketQualityCriteria.CRITERIA4.getCriteriaDescription());
        reportQualityCriteria5Field =
                createFormCheckBox(ProfessionalTicketQualityCriteria.CRITERIA5.getCriteriaDescription());
        reportQualityCommentsField = createFormTextArea("Quality comments");
        recommendationsField = createFormTextArea("Recommendations (if any)");
        affsField = createFormTextArea("");
        reportQualityField = new TextField("Quality Score");
        reporterField = createFormTextField("Reporter");
        reportTimeField = createFormDateField("Report Date");

        initLayout();
    }

    private void initLayout()
    {
        setSizeFull();
        reportAccuracyCommentsField.addStyleName("report");
        reportQualityCommentsField.addStyleName("report");
        recommendationsField.addStyleName("report");
        affsField.addStyleName("report");
        reportAccuracyCommentsField.setNullRepresentation("");
        reportQualityCommentsField.setNullRepresentation("");
        recommendationsField.setNullRepresentation("");
        affsField.setNullRepresentation("");
        reporterField.setNullRepresentation("");
        reportQualityField.setWidth("50px");
        reporterField.setWidth("300px");
        reportAccuracyScoreField.setEnabled(false);

        Panel accuracyPanel = new Panel("Report Accuracy", fullWidthVerticalLayout(categoryField,
                reportAccuracyScoreField,
                reportAccuracyCommentsField));
        HorizontalLayout layout = fullWidthHorizontalLayout(reportQualityCommentsField, recommendationsField);
        layout.setSpacing(true);
        Panel qualityPanel = new Panel("Report Quality", fullWidthVerticalLayout(reportQualityCriteria1Field,
                reportQualityCriteria2Field,
                reportQualityCriteria3Field,
                reportQualityCriteria4Field,
                reportQualityCriteria5Field,
                layout));

        HorizontalLayout layout1 = new HorizontalLayout(accuracyPanel, qualityPanel);
        layout1.setSpacing(true);
        layout1.setSizeFull();
        layout1.setExpandRatio(accuracyPanel, 1f);
        layout1.setExpandRatio(qualityPanel, 2f);

        Panel affsPanel = new Panel("Primary Or Secondary Findings", affsField);
        HorizontalLayout layout2 = new HorizontalLayout(reportQualityField, reporterField, reportTimeField);
        layout2.setSpacing(true);
        VerticalLayout content = fullWidthVerticalLayout(layout1, affsPanel, layout2);
        content.setMargin(true);
        content.setSpacing(true);
        content.setSizeFull();
        addComponent(content);
    }

    public void displayERPReport(@NotNull final ProfessionalTicket ticket, boolean editable)
    {
        if (ticket.getERPReport() == null)
        {
            ticket.setERPReport(new ERPReport());
        }
        reportAccuracyCommentsField.setPropertyDataSource(new NestedMethodProperty(ticket,
                "ERPReport.ReportAccuracyComments"));
        reportQualityCriteria1Field.setPropertyDataSource(new NestedMethodProperty(ticket,
                "ERPReport.Criteria1"));
        reportQualityCriteria2Field.setPropertyDataSource(new NestedMethodProperty(ticket,
                "ERPReport.Criteria2"));
        reportQualityCriteria3Field.setPropertyDataSource(new NestedMethodProperty(ticket,
                "ERPReport.Criteria3"));
        reportQualityCriteria4Field.setPropertyDataSource(new NestedMethodProperty(ticket,
                "ERPReport.Criteria4"));
        reportQualityCriteria5Field.setPropertyDataSource(new NestedMethodProperty(ticket,
                "ERPReport.Criteria5"));
        reportQualityCommentsField.setPropertyDataSource(new NestedMethodProperty(ticket,
                "ERPReport.ReportQualityComments"));
        recommendationsField.setPropertyDataSource(new NestedMethodProperty(ticket,
                "ERPReport.Recommendation"));
        affsField.setPropertyDataSource(new NestedMethodProperty(ticket,
                "ERPReport.AdditionalFactFindings"));
        reportQualityField.setPropertyDataSource(new NestedMethodProperty(ticket,
                "ERPReport.ReportQuality"));
        reporterField.setPropertyDataSource(new NestedMethodProperty(ticket,
                "ERPReport.ERP.name"));
        reportTimeField.setPropertyDataSource(new NestedMethodProperty(ticket,
                "ERPReport.ReportTime"));

        ERPReport erpReport = ticket.getERPReport();
        if (erpReport != null)
        {
            ProfessionalTicketCategory category = ProfessionalTicketCategory.lookup(erpReport.getCategory());
            if (category != null)
            {
                categoryField.setValue(category);
                if (ticket.getStatus() != TicketStatus.OPEN_ERP_REVIEW)
                {
                    reportAccuracyScoreField.setValue(String.valueOf(category.getScore()));
                }
                ticket.getERPReport().setCategory(category.getCode());
            }
        }

        categoryField.addValueChangeListener(new Property.ValueChangeListener()
        {
            @Override public void valueChange(Property.ValueChangeEvent event)
            {
                Object value = categoryField.getValue();
                if (value != null)
                {
                    ProfessionalTicketCategory category = (ProfessionalTicketCategory) value;
                    if (category != null)
                    {
                        categoryField.setValue(category);
                        if (ticket.getStatus() != TicketStatus.OPEN_ERP_REVIEW)
                        {
                            reportAccuracyScoreField.setValue(String.valueOf(category.getScore()));
                        }
                        ticket.getERPReport().setCategory(category.getCode());
                    }
                }
            }
        });
        setEditable(editable);

    }

    public void displayCMOReport(@NotNull final ProfessionalTicket ticket, boolean editable)
    {
        if (ticket.getCMOReport() == null)
        {
            ticket.setCMOReport(new CMOReport());
        }
        reportAccuracyCommentsField.setPropertyDataSource(new NestedMethodProperty(ticket,
                "CMOReport.ReportAccuracyComments"));
        reportQualityCriteria1Field.setPropertyDataSource(new NestedMethodProperty(ticket,
                "CMOReport.Criteria1"));
        reportQualityCriteria2Field.setPropertyDataSource(new NestedMethodProperty(ticket,
                "CMOReport.Criteria2"));
        reportQualityCriteria3Field.setPropertyDataSource(new NestedMethodProperty(ticket,
                "CMOReport.Criteria3"));
        reportQualityCriteria4Field.setPropertyDataSource(new NestedMethodProperty(ticket,
                "CMOReport.Criteria4"));
        reportQualityCriteria5Field.setPropertyDataSource(new NestedMethodProperty(ticket,
                "CMOReport.Criteria5"));
        reportQualityCommentsField.setPropertyDataSource(new NestedMethodProperty(ticket,
                "CMOReport.ReportQualityComments"));
        recommendationsField.setPropertyDataSource(new NestedMethodProperty(ticket,
                "CMOReport.Recommendation"));
        affsField.setPropertyDataSource(new NestedMethodProperty(ticket,
                "CMOReport.AdditionalFactFindings"));
        reportQualityField.setPropertyDataSource(new NestedMethodProperty(ticket,
                "CMOReport.ReportQuality"));
        reporterField.setPropertyDataSource(new NestedMethodProperty(ticket,
                "CMOReport.CMO.name"));
        reportTimeField.setPropertyDataSource(new NestedMethodProperty(ticket,
                "CMOReport.ReportTime"));

        CMOReport cmoReport = ticket.getCMOReport();
        if (cmoReport != null)
        {
            ProfessionalTicketCategory category = ProfessionalTicketCategory.lookup(cmoReport.getCategory());
            if (category != null)
            {
                categoryField.setValue(category);
                if (ticket.getStatus() != TicketStatus.OPEN_CMO_REVIEW)
                {
                    reportAccuracyScoreField.setValue(String.valueOf(category.getScore()));
                }
                ticket.getCMOReport().setCategory(category.getCode());
            }
        }

        categoryField.addValueChangeListener(new Property.ValueChangeListener()
        {
            @Override public void valueChange(Property.ValueChangeEvent event)
            {
                Object value = categoryField.getValue();
                if (value != null)
                {
                    ProfessionalTicketCategory category = (ProfessionalTicketCategory) value;
                    if (category != null)
                    {
                        categoryField.setValue(category);
                        if (ticket.getStatus() != TicketStatus.OPEN_CMO_REVIEW)
                        {
                            reportAccuracyScoreField.setValue(String.valueOf(category.getScore()));
                        }
                        ticket.getCMOReport().setCategory(category.getCode());
                    }
                }
            }
        });
        setEditable(editable);
    }

    private void setEditable(boolean editable)
    {
        categoryField.setReadOnly(!editable);
        reportAccuracyCommentsField.setReadOnly(!editable);
        reportQualityCriteria1Field.setReadOnly(!editable);
        reportQualityCriteria2Field.setReadOnly(!editable);
        reportQualityCriteria3Field.setReadOnly(!editable);
        reportQualityCriteria4Field.setReadOnly(!editable);
        reportQualityCriteria5Field.setReadOnly(!editable);
        reportQualityCommentsField.setReadOnly(!editable);
        recommendationsField.setReadOnly(!editable);
        affsField.setReadOnly(!editable);

        reportQualityField.setReadOnly(true);
        reporterField.setReadOnly(true);
        reportTimeField.setReadOnly(true);
    }
}
