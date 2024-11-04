package com.capstone.fx.controllers;

import com.capstone.fx.controllers.*;
import com.peirs.datamodel.ticket.*;
import javafx.fxml.*;
import javafx.scene.control.*;

public class ERPConfirmController extends BaseReadOnlyTicketController
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
    private TicketStatus theNextStatus;

    public void display(ProfessionalTicket aTicket)
    {
        super.display(aTicket);

        setReport(aTicket);
    }

    private void setReport(ProfessionalTicket aTicket)
    {
        ERPReport myReport = aTicket.getERPReport();
        if (myReport != null)
        {
            if (myReport.getCategory() != 0)
            {
                ProfessionalTicketCategory myCategory = ProfessionalTicketCategory.lookup(myReport.getCategory());
                theCategory.setText(myCategory.getDescription());
                theReportAccuracyScore.setText(String.valueOf(myCategory.getScore()));
            }
            theReportAccuracyComments.setText(myReport.getReportAccuracyComments());
            theReportQualityComments.setText(myReport.getReportQualityComments());
            theAdditionalFindings.setText(myReport.getAdditionalFactFindings());
            theRecommendations.setText(myReport.getRecommendation());
            theCriteria1.setText(myReport.isCriteria1() ? "25/25" : "0/25");
            theCriteria2.setText(myReport.isCriteria2() ? "25/25" : "0/25");
            theCriteria3.setText(myReport.isCriteria3() ? "25/25" : "0/25");
            theCriteria4.setText(myReport.isCriteria4() ? "20/20" : "0/20");
            theCriteria5.setText(myReport.isCriteria5() ? "5/5" : "0/5");
            theReportQuality.setText(String.valueOf(myReport.getReportQuality()));
        }
    }

    @FXML
    private void onSubmit()
    {
        if (getNextStatus() == null)
        {
            boolean myCategory1Ticket = theTicket.getERPReport().getCategory() == ProfessionalTicketCategory.CATEGORY_1.getCode();
            if (myCategory1Ticket)
            {
                theTicket.setStatus(TicketStatus.COMPLETED);
            }
            else
            {
                theTicket.setStatus(TicketStatus.OPEN_PIR_REVIEW);
            }
        }
        else
        {
            theTicket.setStatus(getNextStatus());
        }
        saveTicket();
        if (getNextStatus() == null)
        {
            generatePRERPResponseLetter();
        }
        theMain.closeTicket();
    }

    @FXML
    private void onEdit()
    {
        theMain.showERPOpen(theTicket);
    }

    public void setNextStatus(TicketStatus aNextStatus)
    {
        theNextStatus = aNextStatus;
    }

    public TicketStatus getNextStatus()
    {
        return theNextStatus;
    }
}
