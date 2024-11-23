package web;

import com.peirs.datamodel.*;
import com.peirs.datamodel.ticket.*;
import com.vaadin.ui.*;


public final class ReviewLayoutFactory
{
    public static Component getLayout(ProfessionalTicket ticket, User user)
    {
        Component view = new CssLayout();
        TicketStatus status = ticket.getStatus();
        switch (status)
        {
            case OPEN_ERP_REVIEW:
            {
                view = createOPENERP(ticket);

                break;
            }
            case OPEN_SITE_CALL_REQUIRED:
            {
                view = createSITECALL(ticket, user);

                break;
            }
            case OPEN_PIR_REVIEW:
            {
                view = createOPENPIR(ticket, user);

                break;
            }
            case OPEN_CMO_REVIEW:
            {
                view = createOPENCMO(ticket, user);

                break;
            }
            case PENDING:
            {
                view = createPending(ticket, user);

                break;
            }
            case COMPLETED:
            {
                view = createCompleted(ticket, user);

                break;
            }
            case TECH_OPEN_ERP_REVIEW:
            {
                view = createTechERP(ticket, user);

                break;
            }
            case TECH_OPEN_CMO_REVIEW:
            {
                view = createTechERP(ticket, user);

                break;
            }
            case TECH_PENDING:
            {
                view = createTechPending(ticket, user);

                break;
            }
            case TECH_COMPLETED:
            {
                view = createTechCompleted(ticket, user);

                break;
            }

        }

        return view;
    }

    private static Component createTechPending(ProfessionalTicket ticket, User user)
    {
        TabSheet tabSheet = new TabSheet();
        addTechTab(ticket, tabSheet, false);

        return tabSheet;
    }

    private static Component createTechERP(ProfessionalTicket ticket, User user)
    {
        TabSheet tabSheet = new TabSheet();
        addTechTab(ticket, tabSheet, true);

        return tabSheet;
    }

    private static Component createTechCompleted(ProfessionalTicket ticket, User user)
    {
        TabSheet tabSheet = new TabSheet();
        addTechTab(ticket, tabSheet, false);

        return tabSheet;
    }

    private static Component createOPENERP(ProfessionalTicket ticket)
    {
        TabSheet tabSheet = new TabSheet();
        addERPTab(ticket, tabSheet, true);

        return tabSheet;
    }

    private static Component createOPENPIR(ProfessionalTicket ticket, User user)
    {
        TabSheet tabSheet = new TabSheet();

        addERPTab(ticket, tabSheet, false);
        if (ticket.getPreviousStatus() == TicketStatus.OPEN_SITE_CALL_REQUIRED)
        {
            addERPSiteCallTab(ticket, user, tabSheet, false);
        }
        tabSheet.setSelectedTab(addPIRTab(ticket, user, tabSheet, true));

        return tabSheet;
    }

    private static Component createSITECALL(ProfessionalTicket ticket, User user)
    {
        TabSheet tabSheet = new TabSheet();

        addERPTab(ticket, tabSheet, false);

        if (ticket.getPreviousStatus() == TicketStatus.OPEN_ERP_REVIEW)
        {
            tabSheet.setSelectedTab(addERPSiteCallTab(ticket, user, tabSheet, true));
        }
        else if (ticket.getPreviousStatus() == TicketStatus.OPEN_CMO_REVIEW)
        {
            if (ticket.getERPReport().getSiteCallReport() != null)
            {
                addERPSiteCallTab(ticket, user, tabSheet, false);
            }
            addPIRTab(ticket, user, tabSheet, false);
            addCMOTab(ticket, tabSheet, false);
            tabSheet.setSelectedTab(addCMOSiteCallTab(ticket, user, tabSheet, true));
        }

        return tabSheet;
    }

    private static Component createOPENCMO(ProfessionalTicket ticket, User user)
    {
        TabSheet tabSheet = new TabSheet();
        addERPTab(ticket, tabSheet, false);
        if (ticket.getERPReport().getSiteCallReport() != null)
        {
            addERPSiteCallTab(ticket, user, tabSheet, false);
        }
        addPIRTab(ticket, user, tabSheet, false);
        tabSheet.setSelectedTab(addCMOTab(ticket, tabSheet, true));

        return tabSheet;
    }

    private static Component createPending(ProfessionalTicket ticket, User user)
    {
        TabSheet tabSheet = new TabSheet();

        if (ticket.getERPReport() != null)
        {
            addERPTab(ticket, tabSheet, false);
            if (ticket.getERPReport().getSiteCallReport() != null)
            {
                addERPSiteCallTab(ticket, user, tabSheet, false);
            }
        }
        if (ticket.getIIRReport() != null)
        {
            addPIRTab(ticket, user, tabSheet, false);
        }
        if (ticket.getCMOReport() != null)
        {
            addCMOTab(ticket, tabSheet, false);
            if (ticket.getCMOReport().getSiteCallReport() != null)
            {
                addCMOSiteCallTab(ticket, user, tabSheet, false);
            }
        }

        return tabSheet;
    }

    private static Component createCompleted(ProfessionalTicket ticket, User user)
    {
        TabSheet tabSheet = new TabSheet();
        addERPTab(ticket, tabSheet, false);
        if (ticket.getERPReport().getSiteCallReport() != null)
        {
            addERPSiteCallTab(ticket, user, tabSheet, false);
        }
        if (ticket.getIIRReport() != null)
        {
            addPIRTab(ticket, user, tabSheet, false);
        }
        if (ticket.getCMOReport() != null)
        {
            tabSheet.setSelectedTab(addCMOTab(ticket, tabSheet, false));
            if (ticket.getCMOReport().getSiteCallReport() != null)
            {
                addCMOSiteCallTab(ticket, user, tabSheet, false);
            }
        }
        return tabSheet;
    }

    private static TabSheet.Tab addCMOTab(ProfessionalTicket ticket, TabSheet tabSheet, boolean editable)
    {
        PRERPCMOReviewView view = new PRERPCMOReviewView();
        view.displayCMOReport(ticket, editable);
        return tabSheet.addTab(view, "CMO Review");
    }

    private static TabSheet.Tab addERPSiteCallTab(ProfessionalTicket ticket,
                                                  User user,
                                                  TabSheet tabSheet,
                                                  boolean editable)
    {
        SiteCallView scView = new SiteCallView(user);
        scView.displayERPReport(ticket, editable);
        return tabSheet.addTab(scView, "ERP Site Call");
    }

    private static TabSheet.Tab addCMOSiteCallTab(ProfessionalTicket ticket,
                                                  User user,
                                                  TabSheet tabSheet,
                                                  boolean editable)
    {
        SiteCallView scView = new SiteCallView(user);
        scView.displayCMOReport(ticket, editable);
        return tabSheet.addTab(scView, "CMO Site Call");
    }

    private static TabSheet.Tab addERPTab(ProfessionalTicket ticket, TabSheet tabSheet, boolean editable)
    {
        PRERPCMOReviewView view = new PRERPCMOReviewView();
        view.displayERPReport(ticket, editable);
        return tabSheet.addTab(view, "ERP Review");
    }

    private static TabSheet.Tab addPIRTab(ProfessionalTicket ticket, User user, TabSheet tabSheet, boolean editable)
    {
        PIRReviewView pirView = new PIRReviewView(user);
        pirView.displayReport(ticket, editable);
        return tabSheet.addTab(pirView, "PIR Review");
    }

    private static TabSheet.Tab addTechTab(ProfessionalTicket ticket, TabSheet tabSheet, boolean editable)
    {
        TRERPCMOReviewView view = new TRERPCMOReviewView();
        view.displayReport(ticket, editable);
        return tabSheet.addTab(view, "ERP Review");
    }
}
