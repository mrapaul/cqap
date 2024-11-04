package com.capstone.fx.controllers;

import com.capstone.fx.controllers.*;
import com.peirs.datamodel.ticket.*;
import javafx.fxml.*;
import javafx.scene.control.*;

public class CompletedController extends BaseReadOnlyTicketController
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

    public void display(ProfessionalTicket aTicket)
    {
        super.display(aTicket);

        ERPReport myERPReport = aTicket.getERPReport();
        IIRReport myIIRReport = aTicket.getIIRReport();
        CMOReport myCMOReport = aTicket.getCMOReport();

        if (myIIRReport != null && !myIIRReport.isIIRAgree() && (myCMOReport != null) &&
                (myERPReport != null && myERPReport.getReportQuality() != myCMOReport.getReportQuality()))
        {
            ProfessionalTicketCategory myCategory = ProfessionalTicketCategory.lookup(myCMOReport.getCategory());
            theCategory.setText(myCategory.getDescription());
            theReportAccuracyScore.setText(String.valueOf(myCategory.getScore()));
            theReportAccuracyComments.setText((myCMOReport.getReportAccuracyComments() != null &&
                    !myCMOReport.getReportAccuracyComments().isEmpty()) ?
                    myCMOReport.getReportAccuracyComments() : myERPReport.getReportAccuracyComments());
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
                theCriteria1.setText(myERPReport.isCriteria1() ? "25/25" : "0/25");
                theCriteria2.setText(myERPReport.isCriteria2() ? "25/25" : "0/25");
                theCriteria3.setText(myERPReport.isCriteria3() ? "25/25" : "0/25");
                theCriteria4.setText(myERPReport.isCriteria4() ? "20/20" : "0/20");
                theCriteria5.setText(myERPReport.isCriteria5() ? "5/5" : "0/5");
                theReportQuality.setText(String.valueOf(myERPReport.getReportQuality()));
                theReportQualityComments.setText(myERPReport.getReportQualityComments());
            }
        }
        else
        {
            ProfessionalTicketCategory myCategory = ProfessionalTicketCategory.lookup(myERPReport.getCategory());
            theCategory.setText(myCategory.getDescription());
            theReportAccuracyScore.setText(String.valueOf(myCategory.getScore()));
            theReportAccuracyComments.setText(myERPReport.getReportAccuracyComments());
            theAdditionalFindings.setText(myERPReport.getAdditionalFactFindings());
            theRecommendations.setText(myERPReport.getRecommendation());
            theCriteria1.setText(myERPReport.isCriteria1() ? "25/25" : "0/25");
            theCriteria2.setText(myERPReport.isCriteria2() ? "25/25" : "0/25");
            theCriteria3.setText(myERPReport.isCriteria3() ? "25/25" : "0/25");
            theCriteria4.setText(myERPReport.isCriteria4() ? "20/20" : "0/20");
            theCriteria5.setText(myERPReport.isCriteria5() ? "5/5" : "0/5");
            theReportQuality.setText(String.valueOf(myERPReport.getReportQuality()));
            theReportQualityComments.setText(myERPReport.getReportQualityComments());
        }
    }
}
