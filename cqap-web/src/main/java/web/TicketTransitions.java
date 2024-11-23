package web;

import com.cqap.client.*;
import com.peirs.datamodel.*;
import com.peirs.datamodel.ticket.*;


import java.util.*;

import static org.apache.commons.lang3.StringUtils.*;

public class TicketTransitions
{
    public static String complete(ClientRestService clientService,
                                  ProfessionalTicket ticket,
                                  User user)
    {
        TicketStatus status = ticket.getStatus();
        switch (status)
        {
            case OPEN_ERP_REVIEW:
            {
                return onERPReviewCompleted(clientService, ticket, user);
            }
            case OPEN_PIR_REVIEW:
            {
                return onPIRReviewCompleted(clientService, ticket, user);
            }
            case OPEN_CMO_REVIEW:
            {
                return onCMOReviewCompleted(clientService, ticket, user);
            }
            case PENDING:
            case TECH_PENDING:
            {
                return onPendingCompleted(clientService, ticket, user);
            }
            case OPEN_SITE_CALL_REQUIRED:
            {
                return onSiteCallRequiredCompleted(clientService, ticket, user);
            }
            case TECH_OPEN_ERP_REVIEW:
            {
                return onTechERPReviewCompleted(clientService, ticket, user);
            }
            case TECH_OPEN_CMO_REVIEW:
            {
                return null;
            }
        }

        return null;
    }

    private static String onERPReviewCompleted(ClientRestService clientService, ProfessionalTicket ticket, User user)
    {
        String error = checkCategoryAndFindings(ticket);
        if (error == null)
        {
            TicketStatus status = ticket.getERPReport().getCategory() == ProfessionalTicketCategory.CATEGORY_1.getCode()
                    ? TicketStatus.COMPLETED : TicketStatus.OPEN_PIR_REVIEW;

            if (isNotEmpty(ticket.getERPReport().getAdditionalFactFindings()))
            {
                status = TicketStatus.OPEN_SITE_CALL_REQUIRED;
            }

            int aReportQuality = calculateReportQuality(ticket.getERPReport());
            if (aReportQuality != 100 && isEmpty(ticket.getERPReport().getReportQualityComments()))
            {
                return "Please enter Report Quality Comments";
            }

            ticket.getERPReport().setReportQuality(aReportQuality);
            ticket.getERPReport().setReportTime(new Date());
            ticket.getERPReport().setERP(user);

            saveTicket(clientService, ticket, user, status);
            generatePRERPResponseLetter(clientService, ticket, user);

            return null;
        }
        else
        {
            return error;
        }
    }

    private static String onPIRReviewCompleted(ClientRestService clientService, ProfessionalTicket ticket, User user)
    {
        IIRReport iirReport = ticket.getIIRReport();
        if (!iirReport.isIIRAgree() && !iirReport.isIIRMinorDisagree() && !iirReport.isIIRMajorDisagree())
        {
            return "Please Agree or Disagree with the ERP Review";
        }

        if (!iirReport.isIIRAgree())
        {
            if (isNotEmpty(iirReport.getIIRDisagreeComments()))
            {
                ticket.getIIRReport().setReportTime(new Date());
                ticket.getIIRReport().setIIR(user);
                saveTicket(clientService, ticket, user, TicketStatus.OPEN_CMO_REVIEW);
            }
            else
            {
                return "Please enter comments as to why you disagree with the ERP review";
            }
        }
        else
        {
            saveTicket(clientService, ticket, user, TicketStatus.COMPLETED);
        }

        return null;
    }

    private static String onCMOReviewCompleted(ClientRestService clientService, ProfessionalTicket ticket, User user)
    {
        CMOReport cmoReport = ticket.getCMOReport();
        if (cmoReport.getCategory() == 0)
        {
            return "Please select a category";
        }

        if (cmoReport.getCategory() != 1 && isEmpty(cmoReport.getReportAccuracyComments()))
        {
            return "Please enter report accuracy comments";
        }

        int aReportQuality = calculateReportQuality(ticket.getCMOReport());
        if (aReportQuality != 100 && isEmpty(ticket.getCMOReport().getReportQualityComments()))
        {
            return "Please enter Report Quality Comments";
        }
        ticket.getCMOReport().setReportQuality(aReportQuality);
        ticket.getCMOReport().setReportTime(new Date());
        ticket.getCMOReport().setCMO(user);

        saveTicket(clientService,
                ticket,
                user,
                isNotEmpty(ticket.getCMOReport().getAdditionalFactFindings()) ?
                        TicketStatus.OPEN_SITE_CALL_REQUIRED :
                        TicketStatus.COMPLETED);
        generatePRCMOResponseLetter(clientService, ticket, user);

        return null;
    }

    private static String onTechERPReviewCompleted(ClientRestService clientService,
                                                   ProfessionalTicket ticket,
                                                   User user)
    {

        String error = checkTechTicketCategory(ticket);
        if (error == null)
        {
            int aReportQuality = calculateReportQuality(ticket.getTechReport());

            if (aReportQuality != 100 && isEmpty(ticket.getTechReport().getTechnicalImageQualityComments()))
            {
                return "Please enter Technical Image Quality Comments";
            }

            ticket.getTechReport().setReportQuality(aReportQuality);
            ticket.getTechReport().setReportCompletedTime(new Date());
            ticket.getTechReport().setERP(user);
            saveTicket(clientService, ticket, user, TicketStatus.TECH_COMPLETED);
            generateTRERPResponseLetter(clientService, ticket, user);
        }

        return error;
    }

    private static String checkTechTicketCategory(ProfessionalTicket ticket)
    {
        TechReport techReport = ticket.getTechReport();
        if (techReport.getCategory() != 0)
        {
            int myCategory = techReport.getCategory();
            if ((myCategory != 1 && isNotEmpty(techReport.getMedicalImageQualityComments())) || myCategory == 1)
            {
                return null;
            }
            else
            {
                return "Please enter Medical Image Quality Comments";
            }
        }
        return "Please select a category";
    }

    public static String techERPReviewCompletedAndPRTicketRequest(ClientRestService clientService,
                                                                  ProfessionalTicket ticket,
                                                                  User user)
    {
        return onTechERPReviewCompleted(clientService, ticket, user);
    }

    private static String onTechCMOReviewCompleted(ClientRestService clientService,
                                                   ProfessionalTicket ticket,
                                                   User user)
    {
        saveTicket(clientService, ticket, user, TicketStatus.TECH_COMPLETED);

        return null;
    }

    private static String onPendingCompleted(ClientRestService clientService, ProfessionalTicket ticket, User user)
    {
        saveTicket(clientService, ticket, user, ticket.getPreviousStatus());

        return null;
    }

    private static String onSiteCallRequiredCompleted(ClientRestService clientService,
                                                      ProfessionalTicket ticket,
                                                      User user)
    {

        if (!allSiteCallFieldsPresent(ticket, user))
        {
            return "Please fill in all site call review fields";
        }


        boolean category1Ticket = ticket.getERPReport().getCategory() == 1;
        boolean containsCMOReport = hasCMOReport(ticket);
        TicketStatus
                status =
                (category1Ticket || containsCMOReport) ? TicketStatus.COMPLETED : TicketStatus.OPEN_PIR_REVIEW;
        saveTicket(clientService,
                ticket,
                user,
                status);
        sendResponseLetter(clientService, ticket, user, containsCMOReport);

        return null;
    }

    private static boolean allSiteCallFieldsPresent(ProfessionalTicket ticket, User user)
    {
        if (ticket.getPreviousStatus() == TicketStatus.OPEN_ERP_REVIEW)
        {
            return checkSiteCallFields(ticket.getERPReport().getSiteCallReport(), user);
        }
        else if (ticket.getPreviousStatus() == TicketStatus.OPEN_CMO_REVIEW)
        {
            return checkSiteCallFields(ticket.getCMOReport().getSiteCallReport(), user);
        }
        return false;
    }

    private static boolean checkSiteCallFields( SiteCallReport siteCallReport, User user)
    {
        if (siteCallReport != null)
        {
            siteCallReport.setReportTime(new Date());
            siteCallReport.setUser(user);

            return isNotEmpty(siteCallReport.getCaller()) &&
                    isNotEmpty(siteCallReport.getCallDate()) &&
                    isNotEmpty(siteCallReport.getCallNotes()) &&
                    isNotEmpty(siteCallReport.getCallPhysician());
        }
        return false;
    }

    public static String pending(ClientRestService clientService, ProfessionalTicket ticket, User user)
    {
        saveTicket(clientService, ticket, user, ticket.getType() == TicketType.PR ?
                TicketStatus.PENDING :
                TicketStatus.TECH_PENDING);

        return null;
    }

    private static String checkCategoryAndFindings(ProfessionalTicket ticket)
    {
        if (ticket.getStatus() == TicketStatus.OPEN_ERP_REVIEW)
        {
            ERPReport erpReport = ticket.getERPReport();
            if (erpReport.getCategory() == 0)
            {
                return "Please select a category";
            }
            int myCategory = ProfessionalTicketCategory.lookup(erpReport.getCategory()).getCode();
            if ((myCategory != 1 && isNotEmpty(erpReport.getReportAccuracyComments()) || myCategory == 1))
            {
                return null;
            }
            else
            {
                return "Please check to see that you have entered Report Accuracy comments";
            }
        }
        else if (ticket.getStatus() == TicketStatus.OPEN_CMO_REVIEW)
        {
            CMOReport cmoReport = ticket.getCMOReport();
            if (cmoReport.getCategory() == 0)
            {
                return "Please select a category";
            }
            int myCategory = ProfessionalTicketCategory.lookup(cmoReport.getCategory()).getCode();
            if ((myCategory != 1 && isNotEmpty(cmoReport.getReportAccuracyComments()) || myCategory == 1))
            {
                return null;
            }
            else
            {
                return "Please check to see that you have entered Report Accuracy comments";
            }
        }

        return null;
    }

    private static ProfessionalTicket saveTicket(ClientRestService clientService,
                                                 ProfessionalTicket ticket,
                                                 User user,
                                                 TicketStatus newStatus)
    {
        ticket.setPreviousStatus(ticket.getStatus());
        ticket.setStatus(newStatus);
        ticket.setUpdatedDate(new Date());
        ticket.setLastUpdatedBy(user);
        clientService.createOrUpdateDicomStudy(ticket.getStudy());
        return clientService.createOrUpdateProfessionalTicket(ticket, user);
    }

    private static void sendResponseLetter(ClientRestService clientService,
                                           ProfessionalTicket ticket,
                                           User user,
                                           boolean containsCMOReport)
    {
        if (containsCMOReport)
        {
            generatePRCMOSiteCallLetter(clientService, ticket, user);
        }
        else
        {
            generatePRERPSiteCallLetter(clientService, ticket, user);
        }
    }

    private static boolean hasCMOReport(ProfessionalTicket ticket)
    {
        return ticket.getCMOReport() != null && ticket.getCMOReport().getCMO() != null;
    }

    private static void generatePRERPResponseLetter(ClientRestService clientService,
                                                    ProfessionalTicket ticket,
                                                    User user)
    {
        clientService.generateERPResponseLetter(ticket, user);
    }

    private static void generatePRERPSiteCallLetter(ClientRestService clientService,
                                                    ProfessionalTicket ticket,
                                                    User user)
    {
        clientService.generateERPSiteCallLetter(ticket, user);
    }

    private static void generatePRCMOSiteCallLetter(ClientRestService clientService,
                                                    ProfessionalTicket ticket,
                                                    User user)
    {
        clientService.generateCMOSiteCallLetter(ticket, user);
    }

    private static void generatePRCMOResponseLetter(ClientRestService clientService,
                                                    ProfessionalTicket ticket,
                                                    User user)
    {
        clientService.generateCMOResponseLetter(ticket, user);
    }

    private static void generateTRERPResponseLetter(ClientRestService clientService,
                                                    ProfessionalTicket ticket,
                                                    User user)
    {
        clientService.generateTechERPResponseLetter(ticket, user);
    }

    private static int calculateReportQuality(ERPReport aReport)
    {
        return (aReport.isCriteria1() ? ProfessionalTicketQualityCriteria.CRITERIA1.getScore() : 0) +
                (aReport.isCriteria2() ? ProfessionalTicketQualityCriteria.CRITERIA2.getScore() : 0) +
                (aReport.isCriteria3() ? ProfessionalTicketQualityCriteria.CRITERIA3.getScore() : 0) +
                (aReport.isCriteria4() ? ProfessionalTicketQualityCriteria.CRITERIA4.getScore() : 0) +
                (aReport.isCriteria5() ? ProfessionalTicketQualityCriteria.CRITERIA5.getScore() : 0);
    }

    private static int calculateReportQuality(TechReport aReport)
    {
        return (aReport.isCriteria1() ? TechTicketQualityCriteria.CRITERIA1.getScore() : 0) +
                (aReport.isCriteria2() ? TechTicketQualityCriteria.CRITERIA2.getScore() : 0) +
                (aReport.isCriteria3() ? TechTicketQualityCriteria.CRITERIA3.getScore() : 0) +
                (aReport.isCriteria4() ? TechTicketQualityCriteria.CRITERIA4.getScore() : 0) +
                (aReport.isCriteria5() ? TechTicketQualityCriteria.CRITERIA5.getScore() : 0);
    }

    private static int calculateReportQuality(CMOReport aReport)
    {
        return (aReport.isCriteria1() ? ProfessionalTicketQualityCriteria.CRITERIA1.getScore() : 0) +
                (aReport.isCriteria2() ? ProfessionalTicketQualityCriteria.CRITERIA2.getScore() : 0) +
                (aReport.isCriteria3() ? ProfessionalTicketQualityCriteria.CRITERIA3.getScore() : 0) +
                (aReport.isCriteria4() ? ProfessionalTicketQualityCriteria.CRITERIA4.getScore() : 0) +
                (aReport.isCriteria5() ? ProfessionalTicketQualityCriteria.CRITERIA5.getScore() : 0);
    }
}
