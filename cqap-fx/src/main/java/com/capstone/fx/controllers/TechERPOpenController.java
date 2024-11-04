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

public class TechERPOpenController extends BaseEditableTicketController
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
    @FXML private Button theCMOReviewRequestButton;
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
        thePendingButton.setDisable(true);
        theCategory.setItems(EnumItems.fromEnum(TechTicketCategory.values()));
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

        if (aTicket.getCorrespondingReviewViewId() != null)
        {
            theCMOReviewRequestButton.setVisible(false);
        }

        if (isOpenCMOReview())
        {
            theCMOReviewRequestButton.setText("Request Professional Review");
        }
    }

    private boolean isOpenCMOReview()
    {
        return theTicket.getStatus() == TicketStatus.TECH_OPEN_CMO_REVIEW;
    }

    private void setReport(ProfessionalTicket aTicket)
    {
        TechReport myReport = aTicket.getTechReport();
        if (myReport != null)
        {
            if (myReport.getCategory() != 0)
            {
                TechTicketCategory myCategory = TechTicketCategory.lookup(myReport.getCategory());
                theCategory.getSelectionModel().select(myCategory.getDescription());
                theReportAccuracyScore.setText(String.valueOf(myCategory.getScore()));
            }
            theReportAccuracyComments.setText(myReport.getMedicalImageQualityComments());
            theReportQualityComments.setText(myReport.getTechnicalImageQualityComments());
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
        TechReport myReport = theTicket.getTechReport() != null ? theTicket.getTechReport() : new TechReport();
        String myCategoryStr = theCategory.getSelectionModel().getSelectedItem();
        if (myCategoryStr != null)
        {
            myReport.setCategory(TechTicketCategory.lookup(myCategoryStr).getCode());
            myReport.setMedicalImageQualityComments(theReportAccuracyComments.getText());
            myReport.setCriteria1(theCriteria1.isSelected());
            myReport.setCriteria2(theCriteria2.isSelected());
            myReport.setCriteria3(theCriteria3.isSelected());
            myReport.setCriteria4(theCriteria4.isSelected());
            myReport.setCriteria5(theCriteria5.isSelected());
            myReport.setTechnicalImageQualityComments(theReportQualityComments.getText());
            myReport.setRecommendation(theRecommendations.getText());
            myReport.setReportQuality(calculateReportQuality(myReport));
            myReport.setERP(theUser);
            myReport.setReportCompletedTime(new Date());
            theTicket.setTechReport(myReport);
        }
    }

    @FXML
    private void onComplete()
    {
        if (checkCategory())
        {
            onSaveTicket();
            showConfirm(null);
        }
    }

    @FXML
    private void onRequestCMOReview()
    {
        if (!isOpenCMOReview())
        {
            if (checkCategory())
            {
                onSaveTicket();
                showConfirm(TicketStatus.TECH_OPEN_CMO_REVIEW);
            }
        }
        else
        {
            onSaveTicket();
            showConfirm(TicketStatus.OPEN_ERP_REVIEW);
        }
    }

    private void onSaveTicket()
    {
        saveDetails();
        saveTicket();
    }

    @Override
    protected void setPendingStatus()
    {
        theTicket.setStatus(TicketStatus.TECH_PENDING);
    }

    private void showConfirm(TicketStatus aStatus)
    {
        theMain.showTechERPConfirm(theTicket, aStatus);
    }

    private boolean checkCategory()
    {
        if (checkComboBox(theCategory))
        {
            String myCategoryStr = theCategory.getSelectionModel().getSelectedItem();
            if (myCategoryStr != null)
            {
                int myCategory = TechTicketCategory.lookup(myCategoryStr).getCode();
                if ((myCategory != 1 && checkTextArea(theReportAccuracyComments)) || myCategory == 1)
                {
                    return true;
                }
            }
        }
        return false;
    }
}
