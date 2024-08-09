package com.capstone.server.controller.responses;

import com.capstone.server.controller.*;
import com.cqap.mail.*;
import com.itextpdf.text.*;
import com.peirs.datamodel.*;
import com.peirs.datamodel.dicom.*;
import com.peirs.datamodel.ticket.*;
import org.apache.commons.io.*;
import org.docx4j.openpackaging.exceptions.*;
import org.slf4j.*;

import javax.xml.bind.*;
import java.io.*;
import java.text.*;
import java.util.*;

public class ResponseLetters
{
    private static final Logger LOGGER = LoggerFactory.getLogger(ResponseLetters.class);
    private static final SimpleDateFormat STUDY_DATE_FORMAT = new SimpleDateFormat("yyyymmdd");
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd MMM yyyy");
    private final StorageService theStorageRepository;
    private final UnmarshallFromTemplate theUnmarshallFromTemplate;
    private final PDFFormFiller thePDFFormFiller;

    public ResponseLetters(StorageService aStorageRepository)
    {
        theStorageRepository = aStorageRepository;
        theUnmarshallFromTemplate = new UnmarshallFromTemplate();
        thePDFFormFiller = new PDFFormFiller();
    }

    public void generateERPReport(ProfessionalTicket aTicket)
    {
        HashMap<String, String> myMappings = setReportValues(aTicket);

        String myTemplateName = "ERP_Category_" + aTicket.getERPReport().getCategory() + "_Response_Letter";
        String myFilename = aTicket.getViewId() + "_" + myTemplateName;
        if (createAndAttachDocx(aTicket, myTemplateName, myFilename, myMappings, "Expert Review Panel Response"))
        {
            aTicket.addAttachment(myFilename);
        }
    }

    public void generateTechERPReport(ProfessionalTicket aTicket)
    {
        HashMap<String, String> myMappings = setReportValues(aTicket);

        String myTemplateName = "TRT_ERP_Category_" + aTicket.getTechReport().getCategory() + "_Response_Letter";
        String myFilename = aTicket.getViewId() + "_" + myTemplateName;
        if (createAndAttachDocx(aTicket, myTemplateName, myFilename, myMappings, "Technical Expert Review Panel Response"))
        {
            aTicket.addAttachment(myFilename);
        }
    }

    public void generateCMOReport(ProfessionalTicket aTicket)
    {
        HashMap<String, String> myMappings = setReportValues(aTicket);
        CMOReport myCMOReport = aTicket.getCMOReport();
        if (myCMOReport != null && myCMOReport.getCMO() != null)
        {
            int myERPReportCategory = aTicket.getERPReport().getCategory();
            int myCMOCategory = myCMOReport.getCategory() != 0 ?
                    myCMOReport.getCategory() :
                    myERPReportCategory;

            String myTemplateName = "CMO_Category_" + myERPReportCategory + "_to_" + myCMOCategory + "_Response_Letter";
            String myFilename = aTicket.toString() + "_" + myTemplateName;
            if (createAndAttachDocx(aTicket,
                    myTemplateName,
                    myFilename,
                    myMappings,
                    "Chief Medical Officer Review Response"))
            {
                aTicket.addAttachment(myFilename);
            }
        }
    }

    private HashMap<String, String> setReportValues(ProfessionalTicket aTicket)
    {
        HashMap<String, String> myMappings = new HashMap<>();
        myMappings.put("TicketNumber", aTicket.getViewId());
        myMappings.put("Date", DATE_FORMAT.format(new Date()));
        myMappings.put("Recipient", "Site Quality Assurance Administrator");
        return myMappings;
    }

    public void generateERPSiteCallReport(ProfessionalTicket aTicket)
    {
        HashMap<String, String> myMappings = new HashMap<>();
        getStudyDetails(aTicket, myMappings);

        ERPReport myERPReport = aTicket.getERPReport();
        if (myERPReport != null)
        {
            myMappings.put("CMOusername", myERPReport.getERP().getName());
            myMappings.put("ReportAccuracyComments", myERPReport.getReportAccuracyComments());
            myMappings.put("AdditionalFindingsComments", myERPReport.getAdditionalFactFindings());
            populateSiteCallReport(myMappings, myERPReport.getSiteCallReport());
        }
        createAndAttachSiteCallReport(aTicket, myMappings);
    }

    public void generateCMOSiteCallReport(ProfessionalTicket aTicket)
    {
        HashMap<String, String> myMappings = new HashMap<>();
        getStudyDetails(aTicket, myMappings);

        CMOReport myCMOReport = aTicket.getCMOReport();
        if (myCMOReport != null)
        {
            myMappings.put("CMOusername", myCMOReport.getCMO().getName());
            myMappings.put("ReportAccuracyComments", myCMOReport.getReportAccuracyComments());
            myMappings.put("AdditionalFindingsComments", myCMOReport.getAdditionalFactFindings());
            populateSiteCallReport(myMappings, myCMOReport.getSiteCallReport());
        }
        createAndAttachSiteCallReport(aTicket, myMappings);
    }

    private void createAndAttachSiteCallReport(ProfessionalTicket aTicket, HashMap<String, String> aMappings)
    {
        String myTemplateName = "AFFS";
        String myFilename = aTicket.toString() + "_" + myTemplateName;
        if (createAndAttachDocx(aTicket,
                myTemplateName,
                myFilename,
                aMappings,
                "Primary or Secondary Findings Communication"))
        {
            aTicket.addAttachment(myFilename);
        }
    }

    private void populateSiteCallReport(HashMap<String, String> aMappings, SiteCallReport aSiteCallReport)
    {
        if (aSiteCallReport != null)
        {
            aMappings.put("PhysicianTakingCall", aSiteCallReport.getCallPhysician());
            aMappings.put("DateAndTimeOfCall", aSiteCallReport.getCallDate());
            aMappings.put("CallNotes", aSiteCallReport.getCallNotes());
            aMappings.put("UserCalling", aSiteCallReport.getCaller());
        }
    }

    private void getStudyDetails(ProfessionalTicket aTicket, HashMap<String, String> aMappings)
    {
        aMappings.put("TicketNumber", aTicket.getViewId());
        aMappings.put("Date", DATE_FORMAT.format(new Date()));

        Institution myInstitution = aTicket.getStudy().getInstitution();
        if (myInstitution != null)
        {
            aMappings.put("Institution", myInstitution.getName());
            aMappings.put("Recipient", myInstitution.getBillingContactName());
            Address myAddress = myInstitution.getAddress();
            if (myAddress != null)
            {
                aMappings.put("Town", myAddress.getCity());
                aMappings.put("State", myAddress.getState());
            }
        }
        DicomStudy myStudy = aTicket.getStudy();
        aMappings.put("PatientName", myStudy.getPatientName().replace('^', ' '));
        aMappings.put("PatientMRN", myStudy.getPatientID());
        aMappings.put("StudyDescription", myStudy.getStudyDescription());
        aMappings.put("PatientDOB", formatDate(myStudy.getPatientBirthDate()));
        aMappings.put("StudyDate", formatDate(myStudy.getStudyDate()));
    }

    private String formatDate(String aDate)
    {
        try
        {
            return DATE_FORMAT.format(STUDY_DATE_FORMAT.parse(aDate));
        }
        catch (ParseException anException)
        {
            LOGGER.error("Error parsing date", anException);
        }

        return aDate;
    }

    private boolean createAndAttachDocx(ProfessionalTicket aTicket,
                                        String aTemplateName,
                                        String aFilename,
                                        HashMap<String, String> aMappings,
                                        String aResponseType)
    {
        try
        {
            File myFile = theUnmarshallFromTemplate.unmarshall(aTemplateName + ".docx", aMappings, aFilename);
            theStorageRepository.storeAttachment(aTicket.getId(),
                    myFile.getName(),
                    FileUtils.readFileToByteArray(myFile));
            sendMail(aTicket, myFile, aResponseType);
            myFile.delete();
        }
        catch (Docx4JException | JAXBException | IOException e)
        {
            LOGGER.error("Error creating response letter", e);

            return false;
        }

        return true;
    }

    private boolean createAndAttachPdf(ProfessionalTicket aTicket,
                                       String aTemplateName,
                                       String aFilename,
                                       HashMap<String, String> aMappings,
                                       String aResponseType)
    {
        try
        {
            File myFile = thePDFFormFiller.fillForm(aTemplateName + ".pdf", aMappings, aFilename);
            theStorageRepository.storeAttachment(aTicket.getId(),
                    myFile.getName(),
                    FileUtils.readFileToByteArray(myFile));
            sendMail(aTicket, myFile, aResponseType);
            myFile.delete();
        }
        catch (DocumentException | IOException e)
        {
            LOGGER.error("Error creating response letter", e);

            return false;
        }

        return true;
    }

    private void sendMail(ProfessionalTicket aTicket, File aFile, String aResponseType)
    {
        try
        {
            Institution myInstitution = aTicket.getStudy().getInstitution();
            if (myInstitution != null &&
                    myInstitution.getBillingEmail() != null &&
                    myInstitution.getBillingEmail().getAddress() != null &&
                    !myInstitution.getBillingEmail().getAddress().trim().isEmpty())
            {
                String myAddress = myInstitution.getBillingEmail().getAddress();
                String myTicketId = aTicket.getViewId();
                String mySubject = "Capstone Radiology " + aResponseType + " - " + myTicketId;
                String myBody = new StringBuilder(myInstitution.getBillingContactName())
                        .append(",")
                        .append("\n\n")
                        .append("Please find the results attached.")
                        .append("\n\n")
                        .append("Regards,")
                        .append("\n")
                        .append("Capstone Radiology.").toString();
                SendMail.sendMail(myAddress,
                        mySubject,
                        myBody,
                        aResponseType + myTicketId + ".pdf",
                        aFile.getAbsolutePath());

                LOGGER.info("Sent mail for {} to {}", myTicketId, myAddress);
            }
            else
            {
                LOGGER.info("No institution or billing email set for ticket {}, response was not mailed out",
                        aTicket.getViewId());
            }
        }
        catch (Exception e)
        {
            LOGGER.error("Error sending mail", e);
        }
    }
}
