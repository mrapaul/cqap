package com.capstone.fx.controllers;

import com.capstone.fx.controllers.*;
import com.peirs.datamodel.ticket.*;
import javafx.fxml.*;
import javafx.scene.control.*;

public class CMOConfirmController extends BaseReadOnlyTicketController
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
    @FXML private TextArea theCMOAdditionalFindings;

    public void display(ProfessionalTicket aTicket)
    {
        super.display(aTicket);
        ERPReport myERPReport = aTicket.getERPReport();
        IIRReport myIIRReport = aTicket.getIIRReport();
        CMOReport myCMOReport = aTicket.getCMOReport();

        if (myIIRReport != null && !myIIRReport.isIIRAgree() && myCMOReport != null &&
                (myERPReport.getCategory() != myCMOReport.getCategory()))
        {
            ProfessionalTicketCategory myCategory = ProfessionalTicketCategory.lookup(myCMOReport.getCategory());
            theCategory.setText(myCategory.getDescription());
            theReportAccuracyScore.setText(String.valueOf(myCategory.getScore()));
            theReportAccuracyComments.setText((myCMOReport.getReportAccuracyComments() != null &&
                    !myCMOReport.getReportAccuracyComments().isEmpty()) ?
                    myCMOReport.getReportAccuracyComments() : myERPReport.getReportAccuracyComments());
            theCMOAdditionalFindings.setText(myCMOReport.getAdditionalFactFindings());
            theAdditionalFindings.setText(myERPReport.getAdditionalFactFindings());
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
                setERPReportQuality(myERPReport);
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
            setERPReportQuality(myERPReport);
        }
    }

    private void setERPReportQuality(ERPReport aERPReport)
    {
        theCriteria1.setText(aERPReport.isCriteria1() ? "25/25" : "0/25");
        theCriteria2.setText(aERPReport.isCriteria2() ? "25/25" : "0/25");
        theCriteria3.setText(aERPReport.isCriteria3() ? "25/25" : "0/25");
        theCriteria4.setText(aERPReport.isCriteria4() ? "20/20" : "0/20");
        theCriteria5.setText(aERPReport.isCriteria5() ? "5/5" : "0/5");
        theReportQuality.setText(String.valueOf(aERPReport.getReportQuality()));
        theReportQualityComments.setText(aERPReport.getReportQualityComments());
    }

    @FXML
    private void onSubmit()
    {
        theTicket.setStatus(TicketStatus.COMPLETED);
        saveTicket();
        generatePRCMOResponseLetter();
        theMain.closeTicket();
    }

    @FXML
    private void onEdit()
    {
        theMain.showCMOOpen(theTicket);
    }
}
