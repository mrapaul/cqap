package com.capstone.fx.controllers;

import com.peirs.datamodel.ticket.*;
import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.stage.*;
import org.slf4j.*;

import java.io.*;
import java.util.*;

import static com.capstone.fx.utils.FieldValidation.*;

public abstract class BaseEditableTicketController extends BaseTicketController
{
    private static final Logger LOGGER = LoggerFactory.getLogger(BaseEditableTicketController.class);
    @FXML protected TextArea theAdditionalFindings;
    @FXML protected TextArea theInternalNotes;
    @FXML protected Button theAddNoteButton;

    @FXML
    protected void initialize()
    {
        super.initialize();

        if (theAddNoteButton != null)
        {
            theAddNoteButton.setDisable(true);
        }
    }

    @FXML
    protected void onSave()
    {
        theTicket.setPreviousStatus(theTicket.getStatus());
        saveDetails();
        saveTicket();
        theMain.closeTicket();
    }

    @FXML
    protected void onPending()
    {
        if (internalNotesPresent())
        {
            saveDetails();
            theTicket.setPreviousStatus(theTicket.getStatus());
            setPendingStatus();
            saveTicket();
            theMain.closeTicket();
        }
        else
        {
            checkTextArea(theInternalNotes);
        }
    }

    protected void setPendingStatus()
    {
        theTicket.setStatus(TicketStatus.PENDING);
    }

    @FXML
    protected void onAdditionalFactFindings()
    {
        theDetails.setExpandedPane(theAdditionalFactFindingsPanel);
        theAdditionalFindings.requestFocus();
    }

    @FXML
    protected void onAddInternalNote()
    {
        String myInternalNoteText = theInternalNotes.getText();
        if (myInternalNoteText != null && !myInternalNoteText.isEmpty())
        {
            InternalNote myNote = new InternalNote(myInternalNoteText, new Date(), theUser);
            theTicket.addNote(myNote);
            theInternalNotesItems.add(myNote);
            theInternalNotes.clear();
            if (theAddNoteButton != null)
            {
                theAddNoteButton.setDisable(true);
            }
        }
    }

    @FXML
    protected void onAttach()
    {
        Stage myStage = theMain.getPrimaryStage();
        FileChooser myChooser = new FileChooser();
        myChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("PDF files (*.pdf)", "*.pdf"));
        myChooser.setTitle("Choose Attachments");
        try
        {
            List<File> myFiles = myChooser.showOpenMultipleDialog(myStage);
            for (File myFile : myFiles)
            {
                getClientService().addTicketAttachment(theTicket, myFile);
            }
            showAttachments();
        }
        catch (Exception aException)
        {
            LOGGER.error("Error uploading attachments", aException);
        }
    }

    protected int calculateReportQuality(ERPReport aReport)
    {
        return (aReport.isCriteria1() ? ProfessionalTicketQualityCriteria.CRITERIA1.getScore() : 0) +
                (aReport.isCriteria2() ? ProfessionalTicketQualityCriteria.CRITERIA2.getScore() : 0) +
                (aReport.isCriteria3() ? ProfessionalTicketQualityCriteria.CRITERIA3.getScore() : 0) +
                (aReport.isCriteria4() ? ProfessionalTicketQualityCriteria.CRITERIA4.getScore() : 0) +
                (aReport.isCriteria5() ? ProfessionalTicketQualityCriteria.CRITERIA5.getScore() : 0);
    }

    protected int calculateReportQuality(TechReport aReport)
    {
        return (aReport.isCriteria1() ? TechTicketQualityCriteria.CRITERIA1.getScore() : 0) +
                (aReport.isCriteria2() ? TechTicketQualityCriteria.CRITERIA2.getScore() : 0) +
                (aReport.isCriteria3() ? TechTicketQualityCriteria.CRITERIA3.getScore() : 0) +
                (aReport.isCriteria4() ? TechTicketQualityCriteria.CRITERIA4.getScore() : 0) +
                (aReport.isCriteria5() ? TechTicketQualityCriteria.CRITERIA5.getScore() : 0);
    }

    protected int calculateReportQuality(CMOReport aReport)
    {
        return (aReport.isCriteria1() ? ProfessionalTicketQualityCriteria.CRITERIA1.getScore() : 0) +
                (aReport.isCriteria2() ? ProfessionalTicketQualityCriteria.CRITERIA2.getScore() : 0) +
                (aReport.isCriteria3() ? ProfessionalTicketQualityCriteria.CRITERIA3.getScore() : 0) +
                (aReport.isCriteria4() ? ProfessionalTicketQualityCriteria.CRITERIA4.getScore() : 0) +
                (aReport.isCriteria5() ? ProfessionalTicketQualityCriteria.CRITERIA5.getScore() : 0);
    }

    protected boolean internalNotesPresent()
    {
        return theInternalNotes.getText() != null || (theTicket != null && !theTicket.getNotes().isEmpty());
    }
}
