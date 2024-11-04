package com.capstone.fx.controllers;

import com.capstone.fx.controllers.*;
import com.capstone.fx.utils.*;
import com.peirs.datamodel.ticket.*;
import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.scene.input.*;

public class CompletedAdminController extends BaseEditableTicketController
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
    @FXML private TextArea theCMOAdditionalFindings;
    @FXML private Label theReportQuality;
    @FXML private Label theIIRDecision;
    @FXML private TextArea theDisagreeComments;
    @FXML private ComboBox<String> theCMOCategory;
    @FXML private TextArea theCMOReportAccuracyComments;
    @FXML private Label theCMOReportAccuracyScore;
    @FXML private Label theCMOReportQualityScore;
    @FXML private CheckBox theCMOCriteria1;
    @FXML private CheckBox theCMOCriteria2;
    @FXML private CheckBox theCMOCriteria3;
    @FXML private CheckBox theCMOCriteria4;
    @FXML private CheckBox theCMOCriteria5;
    @FXML private TextArea theCMOReportQualityComments;
    @FXML private TextArea theCMORecommendations;

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

        theCMOCategory.setItems(EnumItems.fromEnum(ProfessionalTicketCategory.values()));
    }

    public void display(ProfessionalTicket aTicket)
    {
        super.display(aTicket);

        setERPReport(aTicket);
        setIIRReport(aTicket);
        setCMOReport(aTicket);
    }

    private void setERPReport(ProfessionalTicket aTicket)
    {
        ERPReport myERPReport = aTicket.getERPReport();
        if (myERPReport != null)
        {
            ProfessionalTicketCategory myCategory = ProfessionalTicketCategory.lookup(myERPReport.getCategory());
            theCategory.setText(myCategory.getDescription());
            theReportAccuracyScore.setText(String.valueOf(myCategory.getScore()));
            theReportAccuracyComments.setText(myERPReport.getReportAccuracyComments());
            theReportQualityComments.setText(myERPReport.getReportQualityComments());
            theAdditionalFindings.setText(myERPReport.getAdditionalFactFindings());
            theRecommendations.setText(myERPReport.getRecommendation());
            theCriteria1.setText(myERPReport.isCriteria1() ? "25/25" : "0/25");
            theCriteria2.setText(myERPReport.isCriteria2() ? "25/25" : "0/25");
            theCriteria3.setText(myERPReport.isCriteria3() ? "25/25" : "0/25");
            theCriteria4.setText(myERPReport.isCriteria4() ? "20/20" : "0/20");
            theCriteria5.setText(myERPReport.isCriteria5() ? "5/5" : "0/5");
            theReportQuality.setText(String.valueOf(myERPReport.getReportQuality()));
        }
    }

    private void setIIRReport(ProfessionalTicket aTicket)
    {
        IIRReport myIIRReport = aTicket.getIIRReport();
        if (myIIRReport != null)
        {
            theIIRDecision.setText(myIIRReport.isIIRAgree() ?
                    "AGREE" :
                    myIIRReport.isIIRMinorDisagree() ? "MINOR DISAGREE" :
                            myIIRReport.isIIRMajorDisagree() ? "MAJOR DISAGREE" :
                                    "N/A");
            if (myIIRReport.getIIRDisagreeComments() != null)
            {
                theDisagreeComments.setText(myIIRReport.getIIRDisagreeComments());
            }
        }
    }

    private void setCMOReport(ProfessionalTicket aTicket)
    {
        CMOReport myCMOReport = aTicket.getCMOReport();
        if (myCMOReport != null)
        {
            theCMOCriteria1.setSelected(myCMOReport.isCriteria1());
            theCMOCriteria2.setSelected(myCMOReport.isCriteria2());
            theCMOCriteria3.setSelected(myCMOReport.isCriteria3());
            theCMOCriteria4.setSelected(myCMOReport.isCriteria4());
            theCMOCriteria5.setSelected(myCMOReport.isCriteria5());
            ProfessionalTicketCategory myCategory = ProfessionalTicketCategory.lookup(myCMOReport.getCategory());
            if (myCategory != null)
            {
                theCMOCategory.getSelectionModel().select(myCategory.getDescription());
                theReportAccuracyScore.setText(String.valueOf(myCategory.getScore()));
            }
            theCMOReportQualityScore.setText(String.valueOf(myCMOReport.getReportQuality()));
            theCMOReportAccuracyComments.setText(myCMOReport.getReportAccuracyComments());
            theCMOReportQualityComments.setText(myCMOReport.getReportQualityComments());
            theCMOAdditionalFindings.setText(myCMOReport.getAdditionalFactFindings());
            theCMORecommendations.setText(myCMOReport.getRecommendation());
        }
    }

    protected void saveDetails()
    {
        CMOReport myReport = theTicket.getCMOReport();
        String myCategory = theCMOCategory.getSelectionModel().getSelectedItem();
        if (myCategory != null)
        {
            myReport.setCategory(ProfessionalTicketCategory.lookup(myCategory).getCode());
        }
        if (myReport != null)
        {
            myReport.setReportAccuracyComments(theCMOReportAccuracyComments.getText());
            myReport.setCriteria1(theCMOCriteria1.isSelected());
            myReport.setCriteria2(theCMOCriteria2.isSelected());
            myReport.setCriteria3(theCMOCriteria3.isSelected());
            myReport.setCriteria4(theCMOCriteria4.isSelected());
            myReport.setCriteria5(theCMOCriteria5.isSelected());
            myReport.setReportQualityComments(theCMOReportQualityComments.getText());
            myReport.setRecommendation(theCMORecommendations.getText());
            myReport.setReportQuality(calculateReportQuality(myReport));
            if (theCMOAdditionalFindings.getText() != null)
            {
                myReport.setAdditionalFactFindings(theCMOAdditionalFindings.getText().trim());
            }
            myReport.setCMO(theUser);
            theTicket.setCMOReport(myReport);
        }
    }

    @FXML
    public void onAdditionalFactFindings()
    {
        super.onAdditionalFactFindings();

        theCMOAdditionalFindings.requestFocus();
    }
}
