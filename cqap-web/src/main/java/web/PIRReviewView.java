package web;

import com.peirs.datamodel.*;
import com.peirs.datamodel.ticket.*;
import com.vaadin.data.*;
import com.vaadin.data.util.*;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.*;
import org.jetbrains.annotations.*;

import java.util.*;

import static web.ComponentFactory.*;

public class PIRReviewView extends VerticalLayout
{
    private static final String AGREE = "Agree";
    private static final String MINOR_DISAGREE = "Minor Disagree";
    private static final String MAJOR_DISAGREE = "Major Disagree";
    @NotNull private final User user;
    private final OptionGroup agreeField;
    private final TextArea disagreeCommentsField;
    @NotNull private final TextField reporterField;
    @NotNull private final DateField reportTimeField;

    public PIRReviewView(@NotNull User user)
    {
        this.user = user;
        agreeField = new OptionGroup("Decision of ERP Review", Arrays.asList(AGREE, MINOR_DISAGREE, MAJOR_DISAGREE));
        disagreeCommentsField = createFormTextArea("Disagree comments");
        reporterField = createFormTextField("Reporter");
        reportTimeField = createFormDateField("Report Date");

        initLayout();
    }

    private void initLayout()
    {
        setSizeFull();
        setMargin(true);
        setSpacing(true);

        disagreeCommentsField.setSizeFull();
        disagreeCommentsField.addStyleName("report");
        disagreeCommentsField.setNullRepresentation("");
        reporterField.setNullRepresentation("");
        agreeField.addStyleName(ValoTheme.OPTIONGROUP_HORIZONTAL);
        addComponent(agreeField);
        addComponent(disagreeCommentsField);
        HorizontalLayout layout2 = new HorizontalLayout(reporterField, reportTimeField);
        layout2.setSpacing(true);
        addComponent(layout2);
    }

    public void displayReport(@NotNull final ProfessionalTicket ticket, boolean editable)
    {
        if (ticket.getIIRReport() == null)
        {
            ticket.setIIRReport(new IIRReport());
        }

        IIRReport report = ticket.getIIRReport();
        if (report != null)
        {
            if (report.isIIRAgree())
            {
                agreeField.setValue(AGREE);
            }
            else if (report.isIIRMinorDisagree())
            {
                agreeField.setValue(MINOR_DISAGREE);
            }
            else if (report.isIIRMajorDisagree())
            {
                agreeField.setValue(MAJOR_DISAGREE);
            }
        }
        disagreeCommentsField.setPropertyDataSource(new NestedMethodProperty(ticket, "IIRReport.IIRDisagreeComments"));
        reporterField.setPropertyDataSource(new NestedMethodProperty(ticket,
                "IIRReport.IIR.name"));
        reportTimeField.setPropertyDataSource(new NestedMethodProperty(ticket,
                "IIRReport.ReportTime"));

        agreeField.setReadOnly(!editable);
        disagreeCommentsField.setReadOnly(!editable);

        reporterField.setReadOnly(true);
        reportTimeField.setReadOnly(true);

        agreeField.addValueChangeListener(new Property.ValueChangeListener()
        {
            @Override public void valueChange(Property.ValueChangeEvent event)
            {
                Object value = agreeField.getValue();
                if (value != null)
                {
                    if (value == AGREE)
                    {
                        ticket.getIIRReport().setIIRAgree(true);
                        ticket.getIIRReport().setIIRMinorDisagree(false);
                        ticket.getIIRReport().setIIRMajorDisagree(false);
                    }
                    else if (value == MINOR_DISAGREE)
                    {
                        ticket.getIIRReport().setIIRAgree(false);
                        ticket.getIIRReport().setIIRMinorDisagree(true);
                        ticket.getIIRReport().setIIRMajorDisagree(false);
                    }
                    else if (value == MAJOR_DISAGREE)
                    {
                        ticket.getIIRReport().setIIRAgree(false);
                        ticket.getIIRReport().setIIRMinorDisagree(false);
                        ticket.getIIRReport().setIIRMajorDisagree(true);
                    }
                }
            }
        });
    }
}
