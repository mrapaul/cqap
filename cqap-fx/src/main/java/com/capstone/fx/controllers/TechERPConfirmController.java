package com.capstone.fx.controllers;

import com.capstone.fx.utils.*;
import com.peirs.datamodel.ticket.*;
import javafx.fxml.*;
import javafx.scene.control.*;

import java.util.*;

public class TechERPConfirmController extends BaseReadOnlyTicketController
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
        TechReport myReport = aTicket.getTechReport();
        if (myReport != null)
        {
            if (myReport.getCategory() != 0)
            {
                TechTicketCategory myCategory = TechTicketCategory.lookup(myReport.getCategory());
                theCategory.setText(myCategory.getDescription());
                theReportAccuracyScore.setText(String.valueOf(myCategory.getScore()));
            }
            theReportAccuracyComments.setText(myReport.getMedicalImageQualityComments());
            theReportQualityComments.setText(myReport.getMedicalImageQualityComments());
            theRecommendations.setText(myReport.getRecommendation());
            theCriteria1.setText(TicketCriteriaScore.getTechReportCriteriaScore(myReport.isCriteria1(),
                    TechTicketQualityCriteria.CRITERIA1));
            theCriteria2.setText(TicketCriteriaScore.getTechReportCriteriaScore(myReport.isCriteria2(),
                    TechTicketQualityCriteria.CRITERIA2));
            theCriteria3.setText(TicketCriteriaScore.getTechReportCriteriaScore(myReport.isCriteria3(),
                    TechTicketQualityCriteria.CRITERIA3));
            theCriteria4.setText(TicketCriteriaScore.getTechReportCriteriaScore(myReport.isCriteria4(),
                    TechTicketQualityCriteria.CRITERIA4));
            theCriteria5.setText(TicketCriteriaScore.getTechReportCriteriaScore(myReport.isCriteria5(),
                    TechTicketQualityCriteria.CRITERIA5));
            theReportQuality.setText(String.valueOf(myReport.getReportQuality()));
        }
    }

    @FXML
    private void onSubmit()
    {
        TicketStatus myCurrentStatus = theTicket.getStatus();
        TicketStatus myNextStatus = getNextStatus();
        if (myNextStatus == null || myNextStatus == TicketStatus.OPEN_ERP_REVIEW)
        {
            theTicket.setStatus(TicketStatus.TECH_COMPLETED);
        }
        else
        {
            theTicket.setStatus(myNextStatus);
        }

        saveTicket();
        if (myCurrentStatus != TicketStatus.TECH_OPEN_CMO_REVIEW)
        {
            if (theTicket.getTechReport().getCategory() == TechTicketCategory.CATEGORY_5.getCode())
            {
                generateTRERPResponseLetter();
            }
            theMain.closeTicket();
        }

        if (myNextStatus == TicketStatus.OPEN_ERP_REVIEW)
        {
            theMain.createAndShowPRTicket(theTicket);
        }
    }

    @FXML
    private void onEdit()
    {
        saveDetails();
        theMain.showTechERPOpen(theTicket);
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
