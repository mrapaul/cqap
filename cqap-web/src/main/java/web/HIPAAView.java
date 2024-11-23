package web;

import com.cqap.client.*;
import com.peirs.datamodel.*;
import com.vaadin.server.*;
import com.vaadin.ui.*;

import org.vaadin.maddon.layouts.*;
import web.event.*;

import static web.ComponentFactory.*;

public class HIPAAView extends Window
{
    private static final String HIPAA_AGREEMENT = "I,%s, an affiliate of Fortis Qualitas LLC acknowledge the confidentiality of patient health care information (“Confidential Patient Information”) that I may receive or have access to in the course of providing patient care services at participating Healthcare Facilities at which I am assigned. Patient and personnel information from any source and in any form, including oral communication, audio recording, and electronic display, is strictly confidential. Access to confidential patient and personnel information is permitted only on a need-to-know basis. It is the policy of Fortis Qualitas LLC and healthcare facilities that all users respect and preserve this right to privacy and confidentiality. Violations of this policy include, but are not limited to:\n" +
            "•\tAccessing information that is not within the scope of your job;\n\n" +
            "•\tDisclosing, misusing without proper authorization, or altering patient or personnel information;\n\n" +
            "•\tDisclosing your sign-on code and password or using another person’s sign-on code and password for accessing electronic or computerized records;\n\n" +
            "•\tLeaving a secured application unattended while logged on; and\n\n" +
            "•\tAttempting to access a secured application without proper authorization.\n\n" +
            "Violations of this policy will results in the loss of access rights to the Fortis Qualitas LLC System in accordance with Hospital procedures and/or federal or state law.  I shall maintain the confidentiality of Confidential Patient Information, and in doing so shall comply with all applicable state and federal laws and regulations, including without limitation, the privacy provisions under Health Insurance Portability and Accountability Act of 1996 (“HIPAA”) and the policies and procedures of each participating Healthcare Facility where I am assigned.  My agreement to maintain the confidentiality of Confidential Patient Information shall survive the conclusion of any assignment at the participating Healthcare Facility and with Fortis Qualitas LLC.\n";

    private final User user;
    private final TextArea agreementField;
    private final Button approveButton;
    private final Button disapproveButton;

    public HIPAAView(User user)
    {
        this.user = user;
        agreementField = createFormTextArea("");
        approveButton = new Button();
        disapproveButton = new Button();

        initLayout();
        initListeners();
    }

    private void initLayout()
    {
        setWidth(80, Unit.PERCENTAGE);
        setHeight(80, Unit.PERCENTAGE);
        setModal(true);

        Label title = new Label("HIPAA Acknowledgement");
        title.addStyleName("h1");
        agreementField.addStyleName("report");
        approveButton.addStyleName("fq");
        disapproveButton.addStyleName("fq");
        approveButton.setIcon(FontAwesome.CHECK);
        disapproveButton.setIcon(FQIcons.CLOSE);
        agreementField.setValue(String.format(HIPAA_AGREEMENT, user.getName()));
        agreementField.setSizeFull();
        agreementField.setWordwrap(true);

        MHorizontalLayout toolbar = new MHorizontalLayout(approveButton, disapproveButton).withSpacing(true);

        MVerticalLayout
                verticalLayout =
                new MVerticalLayout(title, agreementField, toolbar).withMargin(true)
                        .withSpacing(true)
                        .withFullHeight()
                        .withFullWidth()
                        .withAlign(toolbar, Alignment.MIDDLE_CENTER);
        verticalLayout.addStyleName("sidebar");
        verticalLayout.setExpandRatio(agreementField, 1f);
        setContent(verticalLayout);
    }

    private void initListeners()
    {
        approveButton.addClickListener(new Button.ClickListener()
        {
            @Override public void buttonClick(Button.ClickEvent event)
            {
                HIPAAView.this.close();
                DashboardEventBus.post(new DashboardEvent.HIPAAComplianceEvent(user, true));
            }
        });
        disapproveButton.addClickListener(new Button.ClickListener()
        {
            @Override public void buttonClick(Button.ClickEvent event)
            {
                HIPAAView.this.close();
                DashboardEventBus.post(new DashboardEvent.HIPAAComplianceEvent(user, false));
            }
        });
    }
}
