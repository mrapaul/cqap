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

public class ERPOpenController extends BaseEditableTicketController
{
    @FXML private ComboBox<String> theCategory;
    @FXML private TextArea theReportAccuracyComments;
    @FXML private Label theReportAccuracyScore;
    @FXML private CheckBox theCriteria1;
    @FXML private CheckBox theCriteria2;
    @FXML private CheckBox theCriteria3;
    @FXML private CheckBox theCriteria4;
    @FXML private CheckBox theCriteria5;
    @FXML private TextArea theReportQualityComments;
    @FXML private TextArea theRecommendations;
    @FXML private Button thePendingButton;
    @FXML private Button theCallSiteButton;
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
        theAdditionalFindings.addEventFilter(KeyEvent.KEY_TYPED, new EventHandler<KeyEvent>()
        {
            @Override public void handle(KeyEvent aKeyEvent)
            {
                checkAdditionalFindings();
            }
        });
        thePendingButton.setDisable(true);
        theCallSiteButton.setDisable(true);
        theCategory.setItems(EnumItems.fromEnum(ProfessionalTicketCategory.values()));
    }

    private void checkAdditionalFindings()
    {
        if (theAdditionalFindings.getText() != null)
        {
            boolean myFindingsSubmitted = theAdditionalFindings.getText().trim().isEmpty();
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
        setReport(aTicket);
        checkInternalNotes();
        checkAdditionalFindings();
    }

    private void setReport(ProfessionalTicket aTicket)
    {
        ERPReport myReport = aTicket.getERPReport();
        if (myReport != null)
        {
            if (myReport.getCategory() != 0)
            {
                ProfessionalTicketCategory myCategory = ProfessionalTicketCategory.lookup(myReport.getCategory());
                theCategory.getSelectionModel().select(myCategory.getDescription());
                theReportAccuracyScore.setText(String.valueOf(myCategory.getScore()));
            }
            theReportAccuracyComments.setText(myReport.getReportAccuracyComments());
            theReportQualityComments.setText(myReport.getReportQualityComments());
            theAdditionalFindings.setText(myReport.getAdditionalFactFindings());
            theRecommendations.setText(myReport.getRecommendation());
            theCriteria1.setSelected(myReport.isCriteria1());
            theCriteria2.setSelected(myReport.isCriteria2());
            theCriteria3.setSelected(myReport.isCriteria3());
            theCriteria4.setSelected(myReport.isCriteria4());
            theCriteria5.setSelected(myReport.isCriteria5());
        }
    }

    protected void saveDetails()
    {
        ERPReport myReport = theTicket.getERPReport() != null ? theTicket.getERPReport() : new ERPReport();
        String myCategoryStr = theCategory.getSelectionModel().getSelectedItem();
        if (myCategoryStr != null)
        {
            myReport.setCategory(ProfessionalTicketCategory.lookup(myCategoryStr).getCode());
            myReport.setReportAccuracyComments(theReportAccuracyComments.getText());
            myReport.setCriteria1(theCriteria1.isSelected());
            myReport.setCriteria2(theCriteria2.isSelected());
            myReport.setCriteria3(theCriteria3.isSelected());
            myReport.setCriteria4(theCriteria4.isSelected());
            myReport.setCriteria5(theCriteria5.isSelected());
            myReport.setReportQualityComments(theReportQualityComments.getText());
            myReport.setRecommendation(theRecommendations.getText());
            myReport.setReportQuality(calculateReportQuality(myReport));
            if (theAdditionalFindings.getText() != null)
            {
                myReport.setAdditionalFactFindings(theAdditionalFindings.getText().trim());
            }
            myReport.setERP(theUser);
            myReport.setReportTime(new Date());
            theTicket.setERPReport(myReport);
        }
    }

    @FXML
    private void onComplete()
    {
        if (checkCategory())
        {
            saveDetails();
            saveTicket();
            theMain.showERPConfirm(theTicket, null);
        }
    }

    @FXML
    private void onSiteCallRequired()
    {
        if (checkCategory() && checkTextArea(theAdditionalFindings))
        {
            saveDetails();
            saveTicket();
            theMain.showERPConfirm(theTicket, TicketStatus.OPEN_SITE_CALL_REQUIRED);
        }
    }

    private boolean checkCategory()
    {
        if (checkComboBox(theCategory))
        {
            String myCategoryStr = theCategory.getSelectionModel().getSelectedItem();
            if (myCategoryStr != null)
            {
                int myCategory = ProfessionalTicketCategory.lookup(myCategoryStr).getCode();
                if ((myCategory != 1 && checkTextArea(theReportAccuracyComments)) || myCategory == 1)
                {
                    return true;
                }
            }
        }
        return false;
    }
}
