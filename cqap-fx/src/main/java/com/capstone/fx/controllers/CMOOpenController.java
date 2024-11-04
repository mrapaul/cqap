package com.capstone.fx.controllers;

import com.capstone.fx.controllers.*;
import com.capstone.fx.utils.*;
import com.peirs.datamodel.ticket.*;
import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.scene.input.*;

import java.util.*;

import static com.capstone.fx.utils.FieldValidation.*;

public class CMOOpenController extends BaseEditableTicketController
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
    @FXML private Button thePendingButton;
    @FXML private Button theCallSiteButton;
    @FXML private Button theCompleteButton;
    @FXML private ComboBox<String> theCMOCategory;
    @FXML private TextArea theCMOReportAccuracyComments;
    @FXML private Label theCMOReportAccuracyScore;
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
                checkInternalNotes();
            }
        });
        theCMOAdditionalFindings.addEventFilter(KeyEvent.KEY_TYPED, new EventHandler<KeyEvent>()
        {
            @Override public void handle(KeyEvent aKeyEvent)
            {
                checkAdditionalFindings();
            }
        });
        thePendingButton.setDisable(true);
        theCallSiteButton.setDisable(true);
        theCMOCategory.setItems(EnumItems.fromEnum(ProfessionalTicketCategory.values()));
    }

    private void checkAdditionalFindings()
    {
        if (theCMOAdditionalFindings.getText() != null)
        {
            boolean myFindingsSubmitted = theCMOAdditionalFindings.getText().isEmpty();
            theCallSiteButton.setDisable(myFindingsSubmitted);
            theCompleteButton.setDisable(!myFindingsSubmitted);
        }
    }

    private void checkInternalNotes()
    {
        if (internalNotesPresent())
        {
            thePendingButton.setDisable(theInternalNotes.getText().trim().isEmpty());
        }
    }

    public void display(ProfessionalTicket aTicket)
    {
        super.display(aTicket);

        setERPReport(aTicket);
        setIIRReport(aTicket);
        setCMOReport(aTicket);
        checkInternalNotes();
        checkAdditionalFindings();
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
            theCMOReportAccuracyComments.setText(myCMOReport.getReportAccuracyComments());
            theCMOReportQualityComments.setText(myCMOReport.getReportQualityComments());
            theCMOAdditionalFindings.setText(myCMOReport.getAdditionalFactFindings());
            theCMORecommendations.setText(myCMOReport.getRecommendation());
        }
    }

    protected void saveDetails()
    {
        if (checkComboBox(theCMOCategory))
        {
            CMOReport myReport = theTicket.getCMOReport() != null ? theTicket.getCMOReport() : new CMOReport();
            String myCategoryStr = theCMOCategory.getSelectionModel().getSelectedItem();
            if (myCategoryStr != null)
            {
                int myCategory = ProfessionalTicketCategory.lookup(myCategoryStr).getCode();
                myReport.setCategory(myCategory);
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
                myReport.setReportTime(new Date());
                theTicket.setCMOReport(myReport);
            }
        }
    }

    @FXML
    private void onComplete()
    {
        if (checkComboBox(theCMOCategory))
        {
            saveDetails();
            saveTicket();
            theMain.showCMOConfirm(theTicket);
        }
    }

    @FXML
    private void onSiteCallRequired()
    {
        if (checkComboBox(theCMOCategory) && checkTextArea(theCMOAdditionalFindings))
        {
            saveDetails();
            theTicket.setStatus(TicketStatus.OPEN_SITE_CALL_REQUIRED);
            saveTicket();
            theMain.closeTicket();
        }
    }

    @FXML
    public void onAdditionalFactFindings()
    {
        super.onAdditionalFactFindings();

        theCMOAdditionalFindings.requestFocus();
    }
}
