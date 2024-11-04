package com.capstone.fx.controllers;

import com.capstone.fx.controllers.*;
import com.google.common.collect.*;
import com.peirs.datamodel.*;
import com.peirs.datamodel.dicom.*;
import com.peirs.datamodel.ticket.*;
import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.stage.*;

import java.text.*;
import java.util.*;

import static ch.lambdaj.collection.LambdaCollections.*;
import static com.capstone.fx.utils.FieldValidation.*;

public class SiteCallController extends BaseEditableTicketController
{
    @FXML private Label theCategory;
    @FXML private TextArea theReportAccuracyComments;
    @FXML private Label theReportAccuracyScore;
    @FXML private Label theCriteria1;
    @FXML private Label theCriteria2;
    @FXML private Label theCriteria3;
    @FXML private Label theCriteria4;
    @FXML private Label theCriteria5;
    @FXML private TextArea theReportQualityComments;
    @FXML private TextArea theRecommendations;
    @FXML private Label theReportQuality;
    @FXML private ScrollPane theScroller;
    @FXML private TextField theCallPhysician;
    @FXML private TextField theCallDate;
    @FXML private TextArea theCallNotes;
    @FXML private TextField theCaller;
    private SiteCallReport theSiteCallReport;

    public void display(ProfessionalTicket aTicket)
    {
        super.display(aTicket);

        if (hasCMOReport())
        {
            setCMOReport(aTicket);
        }
        else
        {
            setERPReport(aTicket);
        }
        theDetails.setExpandedPane(theAdditionalFactFindingsPanel);
    }

    private void setCMOReport(ProfessionalTicket aTicket)
    {
        CMOReport myCMOReport = aTicket.getCMOReport();
        ProfessionalTicketCategory myCategory = ProfessionalTicketCategory.lookup(myCMOReport.getCategory());
        theCategory.setText(myCategory.getDescription());
        theReportAccuracyComments.setText(myCMOReport.getReportAccuracyComments());
        theReportAccuracyScore.setText(String.valueOf(myCategory.getScore()));
        theReportQualityComments.setText(myCMOReport.getReportQualityComments());
        theAdditionalFindings.setText(myCMOReport.getAdditionalFactFindings());
        theRecommendations.setText(myCMOReport.getRecommendation());
        if (myCMOReport.getReportQuality() != 0)
        {
            theCriteria1.setText(myCMOReport.isCriteria1() ? "25/25" : "0/25");
            theCriteria2.setText(myCMOReport.isCriteria2() ? "25/25" : "0/25");
            theCriteria3.setText(myCMOReport.isCriteria3() ? "25/25" : "0/25");
            theCriteria4.setText(myCMOReport.isCriteria4() ? "20/20" : "0/20");
            theCriteria5.setText(myCMOReport.isCriteria5() ? "5/5" : "0/5");
            theReportQuality.setText(String.valueOf(myCMOReport.getReportQuality()));
            theReportQualityComments.setText(myCMOReport.getReportQualityComments());
        }
        else
        {
            ERPReport myERPReport = aTicket.getERPReport();
            theCriteria1.setText(myERPReport.isCriteria1() ? "25/25" : "0/25");
            theCriteria2.setText(myERPReport.isCriteria2() ? "25/25" : "0/25");
            theCriteria3.setText(myERPReport.isCriteria3() ? "25/25" : "0/25");
            theCriteria4.setText(myERPReport.isCriteria4() ? "20/20" : "0/20");
            theCriteria5.setText(myERPReport.isCriteria5() ? "5/5" : "0/5");
            theReportQuality.setText(String.valueOf(myERPReport.getReportQuality()));
            theReportQualityComments.setText(myERPReport.getReportQualityComments());
        }
        setSiteCallReport(myCMOReport.getSiteCallReport());
    }

    private void setERPReport(ProfessionalTicket aTicket)
    {
        ERPReport myReport = aTicket.getERPReport();
        ProfessionalTicketCategory myCategory = ProfessionalTicketCategory.lookup(myReport.getCategory());
        theCategory.setText(myCategory.getDescription());
        theReportAccuracyComments.setText(myReport.getReportAccuracyComments());
        theReportAccuracyScore.setText(String.valueOf(myCategory.getScore()));
        theReportQualityComments.setText(myReport.getReportQualityComments());
        theAdditionalFindings.setText(myReport.getAdditionalFactFindings());
        theRecommendations.setText(myReport.getRecommendation());
        theCriteria1.setText(myReport.isCriteria1() ? "25/25" : "0/25");
        theCriteria2.setText(myReport.isCriteria2() ? "25/25" : "0/25");
        theCriteria3.setText(myReport.isCriteria3() ? "25/25" : "0/25");
        theCriteria4.setText(myReport.isCriteria4() ? "20/20" : "0/20");
        theCriteria5.setText(myReport.isCriteria5() ? "5/5" : "0/5");
        theReportQuality.setText(String.valueOf(myReport.getReportQuality()));
        setSiteCallReport(myReport.getSiteCallReport());
    }

    private void setSiteCallReport(SiteCallReport aSiteCallReport)
    {
        if (aSiteCallReport != null)
        {
            theSiteCallReport = aSiteCallReport;
            theCallPhysician.setText(theSiteCallReport.getCallPhysician());
            theCaller.setText(theSiteCallReport.getCaller());
            theCallDate.setText(theSiteCallReport.getCallDate());
            theCallNotes.setText(theSiteCallReport.getCallNotes());
        }
        else
        {
            theSiteCallReport = new SiteCallReport();
            List<String> myUser = Lists.newArrayList();
            myUser.add(theUser.getName());
            String myPosition = theUser.getPosition();
            if (myPosition != null && !myPosition.isEmpty())
            {
                myUser.add(myPosition);
            }
            List<Institution> myInstitutions = theUser.getInstitutions();
            if (myInstitutions != null && !myInstitutions.isEmpty())
            {
                myUser.add(myInstitutions.iterator().next().getName());
            }
            theCaller.setText(with(myUser).join(", "));

            String myTimeZone = getTimeZone();
            TimeZone myZone = TimeZone.getTimeZone(myTimeZone);
            Calendar myCalendar = new GregorianCalendar(myZone);
            DateFormat myFormatter = new SimpleDateFormat("dd MMM yyyy HH:mm:ss z");
            myFormatter.setTimeZone(myZone);
            theCallDate.setText(myFormatter.format(myCalendar.getTime()));
        }
    }

    private String getTimeZone()
    {
        DicomStudy myStudy = theTicket.getStudy();
        return (myStudy.getInstitution() != null && myStudy.getInstitution().getAddress() != null &&
                myStudy.getInstitution().getAddress().getTimeZone() != null) ?
                myStudy.getInstitution().getAddress().getTimeZone() :
                Calendar.getInstance().getTimeZone().getDisplayName();
    }

    protected void saveDetails()
    {
        SiteCallReport myReport = theSiteCallReport;
        myReport.setCallPhysician(theCallPhysician.getText());
        myReport.setCallDate(theCallDate.getText());
        myReport.setCallNotes(theCallNotes.getText());
        myReport.setCaller(theCaller.getText());
        myReport.setUser(theUser);
        myReport.setReportTime(new Date());
        if (hasCMOReport())
        {
            theTicket.getCMOReport().setSiteCallReport(theSiteCallReport);
        }
        else
        {
            theTicket.getERPReport().setSiteCallReport(theSiteCallReport);
        }
    }

    @FXML
    private void onComplete()
    {
        if (checkTextField(theCallPhysician) &&
                checkTextField(theCallDate) &&
                checkTextField(theCaller) &&
                checkTextArea(theCallNotes))
        {
            boolean myCategory1Ticket = theTicket.getERPReport().getCategory() == 1;
            boolean myHasCMOReport = hasCMOReport();
            if (myCategory1Ticket || myHasCMOReport)
            {
                saveTicket(TicketStatus.COMPLETED);
            }
            else
            {
                saveTicket(TicketStatus.OPEN_PIR_REVIEW);
            }
            sendResponseLetter(myHasCMOReport);
        }
        else
        {
            theScroller.setVvalue(Screen.getPrimary().getBounds().getHeight());
        }
    }

    private void saveTicket(TicketStatus aStatus)
    {
        saveDetails();
        theTicket.setStatus(aStatus);
        saveTicket();
        theMain.closeTicket();
    }

    private void sendResponseLetter(boolean aHasCMOReport)
    {
        if (aHasCMOReport)
        {
            generatePRCMOResponseLetter();
            generatePRCMOSiteCallLetter();
        }
        else
        {
            generatePRERPResponseLetter();
            generatePRERPSiteCallLetter();
        }
    }

    private boolean hasCMOReport()
    {
        return theTicket.getCMOReport() != null && theTicket.getCMOReport().getCMO() != null;
    }
}
