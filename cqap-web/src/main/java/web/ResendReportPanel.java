package web;

import com.peirs.datamodel.ticket.*;
import com.vaadin.ui.*;


import static web.ComponentFactory.*;

class ResendReportPanel extends Window
{
    private final PRTicketView ticketListener;
    private final TextField addressField;
    private final CheckBox erpReportField;
    private final CheckBox erpSiteCallReportField;
    private final CheckBox cmoReportField;
    private final CheckBox cmoSiteCallReportField;
    private final CheckBox techReportField;
    private final Button okButton;
    private final Button cancelButton;

    ResendReportPanel(ProfessionalTicket ticket, PRTicketView ticketListener)
    {
        this.ticketListener = ticketListener;
        addressField = createFormTextField("");
        erpReportField = createFormCheckBox("ERP Report");
        erpSiteCallReportField = createFormCheckBox("ERP Site Call Report");
        cmoReportField = createFormCheckBox("CMO Report");
        cmoSiteCallReportField = createFormCheckBox("CMO Site Call Report");
        techReportField = createFormCheckBox("Tech Report");
        okButton = createFormButton("Ok");
        cancelButton = createFormButton("Cancel");

        initLayout();
        initListeners();
        enableFields(ticket);
    }

    private void enableFields(ProfessionalTicket ticket)
    {
        TicketType type = ticket.getType();
        if (type == TicketType.PR)
        {
            techReportField.setVisible(false);

            ERPReport erpReport = ticket.getERPReport();
            CMOReport cmoReport = ticket.getCMOReport();

            erpReportField.setVisible(erpReport != null && erpReport.getERP() != null);
            erpSiteCallReportField.setVisible(erpReport != null &&
                    erpReport.getSiteCallReport() != null &&
                    erpReport.getSiteCallReport().getUser() != null);
            cmoReportField.setVisible(cmoReport != null && cmoReport.getCMO() != null);
            cmoSiteCallReportField.setVisible(cmoReport != null &&
                    cmoReport.getSiteCallReport() != null &&
                    cmoReport.getSiteCallReport().getUser() != null);
        }
        else if (type == TicketType.TR)
        {
            erpReportField.setVisible(false);
            erpSiteCallReportField.setVisible(false);
            cmoReportField.setVisible(false);
            cmoSiteCallReportField.setVisible(false);

            TechReport techReport = ticket.getTechReport();

            techReportField.setVisible(techReport != null && techReport.getERP() != null);
        }
    }

    private void initLayout()
    {
        setCaption("Enter mailing addresses (comma separated)");
        setSizeUndefined();
        VerticalLayout verticalLayout = new VerticalLayout();
        verticalLayout.addStyleName("sidebar");
        verticalLayout.setMargin(true);
        verticalLayout.setSpacing(true);
        HorizontalLayout buttons = new HorizontalLayout(cancelButton, okButton);
        buttons.setMargin(true);
        buttons.setSpacing(true);
        verticalLayout.addComponent(addressField);
        verticalLayout.addComponent(erpReportField);
        verticalLayout.addComponent(erpSiteCallReportField);
        verticalLayout.addComponent(cmoReportField);
        verticalLayout.addComponent(cmoSiteCallReportField);
        verticalLayout.addComponent(techReportField);
        verticalLayout.addComponent(buttons);
        setContent(verticalLayout);
        setModal(true);
    }

    private void initListeners()
    {
        cancelButton.addClickListener(new Button.ClickListener()
        {
            @Override public void buttonClick(Button.ClickEvent event)
            {
                close();
            }
        });
        okButton.addClickListener(new Button.ClickListener()
        {
            @Override public void buttonClick(Button.ClickEvent event)
            {

                String addresses = addressField.getValue();
                if (!addresses.isEmpty())
                {

                    ticketListener.resendReports(addresses,
                            erpReportField.getValue(),
                            erpSiteCallReportField.getValue(),
                            cmoReportField.getValue(),
                            cmoSiteCallReportField.getValue(),
                            techReportField.getValue());
                    close();
                }
                else
                {
                    Notification.show("Please enter mailing addresses");
                }
            }
        });
    }
}