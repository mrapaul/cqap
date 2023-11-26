package com.capstone.server.controller.responses;

import com.capstone.server.controller.*;
import com.cqap.mail.*;
import com.itextpdf.text.*;
import com.peirs.datamodel.*;
import com.peirs.datamodel.dicom.*;
import com.peirs.datamodel.ticket.*;
import org.apache.commons.io.*;
import org.slf4j.*;

import java.io.*;
import java.text.*;
import java.util.*;

import static org.apache.commons.lang.StringUtils.*;

public class ResponseLetters
{
    private static final Logger LOGGER = LoggerFactory.getLogger(ResponseLetters.class);
    private static final SimpleDateFormat STUDY_DATE_FORMAT = new SimpleDateFormat("yyyymmdd");
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd MMM yyyy");
    private final StorageService theStorageRepository;
//    private final UnmarshallFromTemplate theUnmarshallFromTemplate;
    private final PDFFormFiller thePDFFormFiller;

    public ResponseLetters(StorageService aStorageRepository)
    {
        theStorageRepository = aStorageRepository;
//        theUnmarshallFromTemplate = new UnmarshallFromTemplate();
        thePDFFormFiller = new PDFFormFiller();
    }

    public void generateERPReport(ProfessionalTicket aTicket, boolean aStoreAttachment, String aMailAddresses)
    {
        HashMap<String, String> myMappings = setERPReportValues(aTicket);

        String myTemplateName = "PRSC";
        String myFilename = aTicket.getViewId() + "_" + myTemplateName;
        if (createAndAttachPdf(aTicket,
                myTemplateName,
                myFilename,
                myMappings,
                "Expert Review Panel Response",
                aStoreAttachment,
                aMailAddresses) && aStoreAttachment)
        {
            aTicket.addAttachment(myFilename);
        }
    }

    public void generateTechERPReport(ProfessionalTicket aTicket, boolean aStoreAttachment, String aMailAddresses)
    {
        HashMap<String, String> myMappings = setTechReportValues(aTicket);

        String myTemplateName = "TRSC";
        String myFilename = aTicket.getViewId() + "_" + myTemplateName;
        if (createAndAttachPdf(aTicket,
                myTemplateName,
                myFilename,
                myMappings,
                "Technical Expert Review Panel Response",
                aStoreAttachment,
                aMailAddresses) && aStoreAttachment)
        {
            aTicket.addAttachment(myFilename);
        }
    }

    public void generateCMOReport(ProfessionalTicket aTicket, boolean aStoreAttachment, String aMailAddresses)
    {
        HashMap<String, String> myMappings = setCMOReportValues(aTicket);
        CMOReport myCMOReport = aTicket.getCMOReport();
        if (myCMOReport != null && myCMOReport.getCMO() != null)
        {
            String myTemplateName = "PRSCCMO";
            String myFilename = aTicket.getViewId() + "_" + myTemplateName;
            if (createAndAttachPdf(aTicket,
                    myTemplateName,
                    myFilename,
                    myMappings,
                    "Chief Medical Officer Review Response",
                    aStoreAttachment,
                    aMailAddresses) && aStoreAttachment)
            {
                aTicket.addAttachment(myFilename);
            }
        }
    }

    private HashMap<String, String> setERPReportValues(ProfessionalTicket aTicket)
    {
        DicomStudy myStudy = aTicket.getStudy();
        ERPReport myReport = aTicket.getERPReport();
        ProfessionalTicketCategory myCategory = ProfessionalTicketCategory.lookup(myReport.getCategory());
        HashMap<String, String> myMappings = new HashMap<>();
        myMappings.put("TicketNumber", aTicket.getViewId());
        myMappings.put("DateOfStudy", myStudy.getStudyDate() != null ? myStudy.getStudyDate() :
                DATE_FORMAT.format(new Date()));
        String myPatientName = myStudy.getPatientName().replaceAll("^", " ");
        myMappings.put("PatientName", myPatientName);
        myMappings.put("PatientMRN", myStudy.getPatientID());
        myMappings.put("PatientDOB", myStudy.getPatientBirthDate());
        myMappings.put("AccessionNumber", myStudy.getAccessionNumber());
        myMappings.put("StudyDescription", myStudy.getStudyDescription());
        myMappings.put("Category", String.valueOf(myReport.getCategory()));
        myMappings.put("ReportAccuracyScore/100", String.valueOf(myCategory.getScore()) + "/100");
        myMappings.put("ReportQualityScore/100", String.valueOf(myReport.getReportQuality() + "/100"));
        myMappings.put("IQS/200",
                String.valueOf(myReport.getReportQuality() + myCategory.getScore()) + "/200");
        myMappings.put("ReportAccuracyComments",
                myReport.getReportAccuracyComments() != null ? myReport.getReportAccuracyComments() : "No Comments");
        myMappings.put("ReportQualityComments",
                myReport.getReportQualityComments() != null ? myReport.getReportQualityComments() : "No Comments");
        myMappings.put("Category", String.valueOf(myReport.getCategory()));
        myMappings.put("Radiologist", myReport.getERP().getName());

        return myMappings;
    }

    private HashMap<String, String> setCMOReportValues(ProfessionalTicket aTicket)
    {
        DicomStudy myStudy = aTicket.getStudy();
        CMOReport myCMOReport = aTicket.getCMOReport();
        ProfessionalTicketCategory myCategory = ProfessionalTicketCategory.lookup(myCMOReport.getCategory());
        HashMap<String, String> myMappings = new HashMap<>();
        myMappings.put("TicketNumber", aTicket.getViewId());
        myMappings.put("DateOfStudy", myStudy.getStudyDate() != null ? myStudy.getStudyDate() :
                DATE_FORMAT.format(new Date()));
        String myPatientName = myStudy.getPatientName().replaceAll("^", " ");
        myMappings.put("PatientName", myPatientName);
        myMappings.put("PatientMRN", myStudy.getPatientID());
        myMappings.put("PatientDOB", myStudy.getPatientBirthDate());
        myMappings.put("AccessionNumber", myStudy.getAccessionNumber());
        myMappings.put("StudyDescription", myStudy.getStudyDescription());
        myMappings.put("ReportAccuracyScore/100", String.valueOf(myCategory.getScore()) + "/100");
        myMappings.put("ReportQualityScore/100", String.valueOf(myCMOReport.getReportQuality() + "/100"));
        myMappings.put("IQS/200",
                String.valueOf(myCMOReport.getReportQuality() + myCategory.getScore()) + "/200");
        myMappings.put("CMOReportAccuracyComments",
                myCMOReport.getReportAccuracyComments() != null ?
                        myCMOReport.getReportAccuracyComments() :
                        "No Comments");
        myMappings.put("CMOReportQualityComments",
                myCMOReport.getReportQualityComments() != null ?
                        myCMOReport.getReportQualityComments() :
                        "No Comments");
        myMappings.put("CMOCategory", String.valueOf(myCMOReport.getCategory()));
        myMappings.put("ERPCategory", String.valueOf(aTicket.getERPReport().getCategory()));
        myMappings.put("CMOusername", myCMOReport.getCMO().getName());
        myMappings.put("Radiologist", myCMOReport.getCMO().getName());

        return myMappings;
    }

    private HashMap<String, String> setTechReportValues(ProfessionalTicket aTicket)
    {
        DicomStudy myStudy = aTicket.getStudy();
        TechReport myReport = aTicket.getTechReport();
        ProfessionalTicketCategory myCategory = ProfessionalTicketCategory.lookup(myReport.getCategory());
        HashMap<String, String> myMappings = new HashMap<>();
        myMappings.put("TicketNumber", aTicket.getViewId());
        myMappings.put("DateOfStudy", myStudy.getStudyDate() != null ? myStudy.getStudyDate() :
                DATE_FORMAT.format(new Date()));
        myMappings.put("Recipient", "Site Quality Assurance Administrator");
        String myPatientName = myStudy.getPatientName().replaceAll("^", " ");
        myMappings.put("PatientName", myPatientName);
        myMappings.put("PatientMRN", myStudy.getPatientID());
        myMappings.put("PatientDOB", myStudy.getPatientBirthDate());
        myMappings.put("AccessionNumber", myStudy.getAccessionNumber());
        myMappings.put("StudyDescription", myStudy.getStudyDescription());
        myMappings.put("Category", String.valueOf(myReport.getCategory()));
        myMappings.put("MedicalImageQualityScore/100", String.valueOf(myCategory.getScore()) + "/100");
        myMappings.put("TechnicalImageQualityScore/100", String.valueOf(myReport.getReportQuality() + "/100"));
        myMappings.put("TIQS/200",
                String.valueOf(myReport.getReportQuality() + myCategory.getScore()) + "/200");
        myMappings.put("MedicalImageQualityComments",
                myReport.getMedicalImageQualityComments() != null ?
                        myReport.getMedicalImageQualityComments() :
                        "No Comments");
        myMappings.put("TechnicalImageQualityComments",
                myReport.getTechnicalImageQualityComments() != null ?
                        myReport.getTechnicalImageQualityComments() :
                        "No Comments");
        myMappings.put("Category", String.valueOf(myReport.getCategory()));
        myMappings.put("Technologist", myReport.getERP().getName());

        return myMappings;
    }

    public void generateERPSiteCallReport(ProfessionalTicket aTicket, boolean aStoreAttachment, String aMailAddresses)
    {
        HashMap<String, String> myMappings = new HashMap<>();
        getStudyDetails(aTicket, myMappings);
        DicomStudy myStudy = aTicket.getStudy();
        ERPReport myERPReport = aTicket.getERPReport();
        if (myERPReport != null)
        {
            myMappings.put("TicketNumber", aTicket.getViewId());
            myMappings.put("StudyDate", myStudy.getStudyDate() != null ? myStudy.getStudyDate() :
                    DATE_FORMAT.format(new Date()));
            myMappings.put("Date", DATE_FORMAT.format(new Date()));
            String myPatientName = myStudy.getPatientName().replaceAll("\\^", " ");
            myMappings.put("PatientName", myPatientName);
            myMappings.put("PatientID", myStudy.getPatientID());
            myMappings.put("PatientDOB", myStudy.getPatientBirthDate());
            myMappings.put("AccessionNumber", myStudy.getAccessionNumber());
            myMappings.put("StudyDescription", myStudy.getStudyDescription());
            myMappings.put("ReportAccuracyComments",
                    myERPReport.getReportAccuracyComments() != null ?
                            myERPReport.getReportAccuracyComments() :
                            "No Comments");
            myMappings.put("ReportQualityComments",
                    myERPReport.getReportQualityComments() != null ?
                            myERPReport.getReportQualityComments() :
                            "No Comments");
            myMappings.put("CMOusername", myERPReport.getERP().getName());
            myMappings.put("AdditionalFindingsComments", myERPReport.getAdditionalFactFindings());
            populateSiteCallReport(myMappings, myERPReport.getSiteCallReport());
        }
        createAndAttachSiteCallReport(aTicket, myMappings, aStoreAttachment, aMailAddresses);
    }

    public void generateCMOSiteCallReport(ProfessionalTicket aTicket, boolean aStoreAttachment, String aMailAddresses)
    {
        HashMap<String, String> myMappings = new HashMap<>();
        getStudyDetails(aTicket, myMappings);

        DicomStudy myStudy = aTicket.getStudy();
        CMOReport myCMOReport = aTicket.getCMOReport();
        if (myCMOReport != null)
        {
            myMappings.put("TicketNumber", aTicket.getViewId());
            myMappings.put("StudyDate", myStudy.getStudyDate() != null ? myStudy.getStudyDate() :
                    DATE_FORMAT.format(new Date()));
            myMappings.put("Date", DATE_FORMAT.format(new Date()));
            String myPatientName = myStudy.getPatientName().replaceAll("\\^", " ");
            myMappings.put("PatientName", myPatientName);
            myMappings.put("PatientID", myStudy.getPatientID());
            myMappings.put("PatientDOB", myStudy.getPatientBirthDate());
            myMappings.put("AccessionNumber", myStudy.getAccessionNumber());
            myMappings.put("StudyDescription", myStudy.getStudyDescription());
            myMappings.put("ReportAccuracyComments",
                    myCMOReport.getReportAccuracyComments() != null ?
                            myCMOReport.getReportAccuracyComments() :
                            "No Comments");
            myMappings.put("ReportQualityComments",
                    myCMOReport.getReportQualityComments() != null ?
                            myCMOReport.getReportQualityComments() :
                            "No Comments");
            myMappings.put("CMOusername", myCMOReport.getCMO().getName());
            myMappings.put("AdditionalFindingsComments", myCMOReport.getAdditionalFactFindings());
            populateSiteCallReport(myMappings, myCMOReport.getSiteCallReport());
        }
        createAndAttachSiteCallReport(aTicket, myMappings, aStoreAttachment, aMailAddresses);
    }

    private void createAndAttachSiteCallReport(ProfessionalTicket aTicket,
                                               HashMap<String, String> aMappings,
                                               boolean aStoreAttachment,
                                               String aMailAddresses)
    {
        String myTemplateName = "PSFC";
        String myFilename = aTicket.getViewId() + "_" + myTemplateName;
        if (createAndAttachPdf(aTicket,
                myTemplateName,
                myFilename,
                aMappings,
                "Primary or Secondary Findings Communication",
                aStoreAttachment,
                aMailAddresses) && aStoreAttachment)
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
            String institution = myInstitution.getName();
            aMappings.put("Recipient",
                    myInstitution.getBillingContactName() != null ?
                            myInstitution.getBillingContactName() :
                            "Whomever it may concern");
            Address myAddress = myInstitution.getAddress();
            if (myAddress != null)
            {
                if (myAddress.getCity() != null)
                {
                    institution += " " + myAddress.getCity();
                }

                if (myAddress.getState() != null)
                {
                    institution += " ," + myAddress.getState();
                }
            }
            aMappings.put("Institution - Town, State", institution);
        }
        DicomStudy myStudy = aTicket.getStudy();
        aMappings.put("PatientName", myStudy.getPatientName().replace('^', ' '));
        aMappings.put("PatientID", myStudy.getPatientID());
        aMappings.put("StudyDescription", myStudy.getStudyDescription());
        aMappings.put("PatientDOB", formatDate(myStudy.getPatientBirthDate()));
        aMappings.put("StudyDate", formatDate(myStudy.getStudyDate()));
    }

    private String formatDate(String aDate)
    {
        if (aDate == null)
        {
            return "N/A";
        }

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

//    private boolean createAndAttachDocx(ProfessionalTicket aTicket,
//                                        String aTemplateName,
//                                        String aFilename,
//                                        HashMap<String, String> aMappings,
//                                        String aResponseType)
//    {
//        try
//        {
//            Institution myInstitution = aTicket.getStudy().getStudyInstitution();
//            String myUserPassword = myInstitution != null ? myInstitution.getUserPassword() : null;
//            String myOwnerPassword = myInstitution != null ? myInstitution.getOwnerPassword() : null;
//            File myFile = theUnmarshallFromTemplate.unmarshall(aTemplateName + ".docx",
//                    aMappings,
//                    aFilename,
//                    myUserPassword != null ? myUserPassword : "CQAP",
//                    myOwnerPassword != null ? myOwnerPassword : "CQAP");
//            theStorageRepository.storeAttachment(aTicket.getId(),
//                    myFile.getName(),
//                    FileUtils.readFileToByteArray(myFile));
//            sendMail(aTicket, myFile, aResponseType);
//            myFile.delete();
//        }
//        catch (Docx4JException | JAXBException | IOException | DocumentException e)
//        {
//            LOGGER.error("Error creating response letter", e);
//
//            return false;
//        }
//
//        return true;
//    }

    private boolean createAndAttachPdf(ProfessionalTicket aTicket,
                                       String aTemplateName,
                                       String aFilename,
                                       HashMap<String, String> aMappings,
                                       String aResponseType,
                                       boolean aStoreAttachment,
                                       String aMailAddresses)
    {
        try
        {
            File myFile = thePDFFormFiller.fillForm(aTemplateName, aMappings, aFilename);
            if (aStoreAttachment)
            {
                theStorageRepository.storeAttachment(aTicket.getId(),
                        myFile.getName(),
                        FileUtils.readFileToByteArray(myFile));
            }
            sendMail(aTicket, myFile, aResponseType, aMailAddresses);
            FileUtils.deleteQuietly(myFile);
        }
        catch (DocumentException | IOException e)
        {
            LOGGER.error("Error creating response letter", e);

            return false;
        }

        return true;
    }

    private void sendMail(ProfessionalTicket aTicket, File aFile, String aResponseType, String aMailAddresses)
    {
        try
        {
            String addresses = getAddresses(aTicket, aMailAddresses);
            if (isNotEmpty(addresses))
            {
                String myTicketId = aTicket.getViewId();
                String mySubject = "Fortis Qualitas " + aResponseType + " - " + myTicketId
                        + "[ " + (aTicket.isSubmittedVariance() ? "Submitted" : "Random" + " ]");
                String contact = getContactName(aTicket, aMailAddresses);
                String myBody =
                        new StringBuilder(contact != null ? contact : "Whomever it may concern")
                                .append(",")
                                .append("\n\n")
                                .append("Please find the results attached.")
                                .append("\n\n")
                                .append("Regards,")
                                .append("\n")
                                .append("Fortis Qualitas.").toString();
                SendMail.sendMail(addresses,
                        mySubject,
                        myBody,
                        aResponseType + myTicketId + ".pdf",
                        aFile.getAbsolutePath());

                LOGGER.info("Sent mail for {} to {}", myTicketId, addresses);
            }
            else
            {
                LOGGER.info("No valid mail addresses set for ticket {}, response was not mailed out",
                        aTicket.getViewId());
            }
        }
        catch (Exception e)
        {
            LOGGER.error("Error sending mail", e);
        }
    }

    private String getContactName(ProfessionalTicket aTicket, String mailAddresses)
    {
        if (isNotEmpty(mailAddresses))
        {
            return "Whomever it may concern";
        }

        Institution myInstitution = aTicket.getStudy().getInstitution();

        if (isNotEmpty(myInstitution.getBillingContactName()))
        {
            return myInstitution.getBillingContactName();
        }

        return "Whomever it may concern";
    }

    private String getAddresses(ProfessionalTicket aTicket, String aMailAddresses)
    {
        if (isNotEmpty(aMailAddresses))
        {
            return aMailAddresses;
        }

        Institution myInstitution = aTicket.getStudy().getInstitution();
        if (myInstitution != null &&
                myInstitution.getBillingEmail() != null &&
                isNotEmpty(myInstitution.getBillingEmail().getAddress()))
        {
            return myInstitution.getBillingEmail().getAddress();
        }

        return null;
    }
}
