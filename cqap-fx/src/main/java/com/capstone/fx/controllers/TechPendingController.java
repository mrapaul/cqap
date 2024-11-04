package com.capstone.fx.controllers;

import com.peirs.datamodel.ticket.*;
import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.scene.input.*;

public class TechPendingController extends BaseEditableTicketController
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

    @FXML
    protected void initialize()
    {
        super.initialize();

        theInternalNotes.addEventFilter(KeyEvent.KEY_TYPED, new EventHandler<KeyEvent>()
        {
            @Override public void handle(KeyEvent aKeyEvent)
            {
                if (theInternalNotes.getText() != null && !theInternalNotes.getText().isEmpty())
                {
                    theAddNoteButton.setDisable(false);
                }
            }
        });
    }

    public void display(ProfessionalTicket aTicket)
    {
        super.display(aTicket);

        setTechReport(aTicket);
    }

    private void setTechReport(ProfessionalTicket aTicket)
    {
        TechReport myReport = aTicket.getTechReport();
        if (myReport != null)
        {
            TechTicketCategory myCategory = TechTicketCategory.lookup(myReport.getCategory());
            if (myCategory != null)
            {
                theCategory.setText(myCategory.getDescription());
                theReportAccuracyScore.setText(String.valueOf(myCategory.getScore()));
            }
            theReportAccuracyComments.setText(myReport.getMedicalImageQualityComments());
            theReportQualityComments.setText(myReport.getTechnicalImageQualityComments());
            theRecommendations.setText(myReport.getRecommendation());
            theCriteria1.setText(myReport.isCriteria1() ?
                    TechTicketQualityCriteria.CRITERIA1.getScore() +
                            "/" +
                            TechTicketQualityCriteria.CRITERIA1.getScore() :
                    "0/" + TechTicketQualityCriteria.CRITERIA1.getScore());
            theCriteria2.setText(myReport.isCriteria2() ?
                    TechTicketQualityCriteria.CRITERIA2.getScore() +
                            "/" +
                            TechTicketQualityCriteria.CRITERIA2.getScore() :
                    "0/" + TechTicketQualityCriteria.CRITERIA2.getScore());
            theCriteria3.setText(myReport.isCriteria3() ?
                    TechTicketQualityCriteria.CRITERIA3.getScore() +
                            "/" +
                            TechTicketQualityCriteria.CRITERIA3.getScore() :
                    "0/" + TechTicketQualityCriteria.CRITERIA3.getScore());
            theCriteria4.setText(myReport.isCriteria4() ?
                    TechTicketQualityCriteria.CRITERIA4.getScore() +
                            "/" +
                            TechTicketQualityCriteria.CRITERIA4.getScore() :
                    "0/" + TechTicketQualityCriteria.CRITERIA4.getScore());
            theCriteria5.setText(myReport.isCriteria5() ?
                    TechTicketQualityCriteria.CRITERIA5.getScore() +
                            "/" +
                            TechTicketQualityCriteria.CRITERIA5.getScore() :
                    "0/" + TechTicketQualityCriteria.CRITERIA5.getScore());
            theReportQuality.setText(String.valueOf(myReport.getReportQuality()));
        }
    }

    protected void saveDetails()
    {
        // empty
    }

    @FXML
    public void onReview()
    {
        theTicket.setStatus(theTicket.getPreviousStatus());
        saveDetails();
        saveTicket();
        theMain.closeTicket();
    }
}
