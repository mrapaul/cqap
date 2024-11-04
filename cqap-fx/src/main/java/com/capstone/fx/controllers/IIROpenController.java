package com.capstone.fx.controllers;

import com.capstone.fx.controllers.*;
import com.peirs.datamodel.ticket.*;
import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.scene.input.*;

import static com.capstone.fx.utils.FieldValidation.*;

public class IIROpenController extends BaseEditableTicketController
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
    @FXML private RadioButton theAgree;
    @FXML private RadioButton theMinorDisagree;
    @FXML private RadioButton theMajorDisagree;
    @FXML private TextArea theDisagreeComments;
    @FXML private Button thePendingButton;
    @FXML private Button theCompleteButton;

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
        checkInternalNotes();
    }

    private void setERPReport(ProfessionalTicket aTicket)
    {
        ERPReport myReport = aTicket.getERPReport();
        if (myReport != null)
        {
            ProfessionalTicketCategory myCategory = ProfessionalTicketCategory.lookup(myReport.getCategory());
            theCategory.setText(myCategory.getDescription());
            theReportAccuracyScore.setText(String.valueOf(myCategory.getScore()));
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

    private void setIIRReport(ProfessionalTicket aTicket)
    {
        IIRReport myIIRReport = aTicket.getIIRReport();
        if (myIIRReport != null)
        {
            theAgree.setSelected(myIIRReport.isIIRAgree());
            theMinorDisagree.setSelected(myIIRReport.isIIRMinorDisagree());
            theMajorDisagree.setSelected(myIIRReport.isIIRMajorDisagree());
            if (myIIRReport.getIIRDisagreeComments() != null)
            {
                theDisagreeComments.setText(myIIRReport.getIIRDisagreeComments());
            }
        }
    }

    protected void saveDetails()
    {
        IIRReport myReport = theTicket.getIIRReport() != null ? theTicket.getIIRReport() : new IIRReport();
        myReport.setIIRAgree(theAgree.isSelected());
        myReport.setIIRMinorDisagree(theMinorDisagree.isSelected());
        myReport.setIIRMajorDisagree(theMajorDisagree.isSelected());
        myReport.setIIRDisagreeComments(theDisagreeComments.getText());
        myReport.setIIR(theUser);
        theTicket.setIIRReport(myReport);
    }

    @FXML
    private void onComplete()
    {
        if (!theAgree.isSelected())
        {
            if (checkTextArea(theDisagreeComments))
            {
                saveTicket(TicketStatus.OPEN_CMO_REVIEW);
            }
        }
        else
        {
            saveTicket(TicketStatus.COMPLETED);
        }
    }

    private void saveTicket(TicketStatus aStatus)
    {
        saveDetails();
        theTicket.setStatus(aStatus);
        saveTicket();
        theMain.closeTicket();
    }
}
