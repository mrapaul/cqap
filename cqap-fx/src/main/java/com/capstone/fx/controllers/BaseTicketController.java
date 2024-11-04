package com.capstone.fx.controllers;

import ch.lambdaj.function.convert.*;
import com.capstone.fx.components.*;
import com.capstone.fx.utils.*;
import com.cqap.util.*;
import com.google.common.base.*;
import com.google.common.collect.*;
import com.peirs.datamodel.*;
import com.peirs.datamodel.attachments.*;
import com.peirs.datamodel.dicom.*;
import com.peirs.datamodel.hl7.*;
import com.peirs.datamodel.ticket.*;
import javafx.application.Platform;
import javafx.beans.property.*;
import javafx.beans.value.*;
import javafx.collections.*;
import javafx.concurrent.*;
import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.scene.input.*;
import javafx.scene.text.*;
import javafx.util.*;
import org.dcm4che2.data.*;

import java.util.*;
import java.util.concurrent.*;

import static com.cqap.util.DicomStudyTagValueFinder.*;

public abstract class BaseTicketController extends BaseController
{
    protected static final String NA = "N/A";
    protected final ObservableList<InternalNote> theInternalNotesItems;
    protected final ObservableList<DicomTag> theTags;
    protected final ObservableList<DicomTag> theFilteredTags;
    protected final ObservableList<Attachment> theAttachmentItems;
    private final ExecutorService theService;
    private final Converter<ProfessionalTicket, TicketQueryResult> theQueryResultConverter;
    @FXML protected Label theInstitution;
    @FXML protected Label theTimeZone;
    @FXML protected Label theSubmittedDate;
    @FXML protected Label theSubmittedBy;
    @FXML protected Label thePatientName;
    @FXML protected Label thePatientMRN;
    @FXML protected Label thePatientDOB;
    @FXML protected Label thePatientAge;
    @FXML protected Label thePatientSex;
    @FXML protected Label theAdmittingDate;
    @FXML protected Label theAdmittingDiagnosisCode;
    @FXML protected Label theAdmittingDiagnosisDescription;
    @FXML protected Label theModality;
    @FXML protected Label theStudyDescription;
    @FXML protected Label theAccessionNumber;
    @FXML protected Label theStudyDate;
    @FXML protected Label theCPTCode;
    @FXML protected Label theImageCount;
    @FXML protected Label theSliceThickness;
    @FXML protected Label theScanLength;
    @FXML protected Label theCTDIVolume;
    @FXML protected Label theManufacturer;
    @FXML protected Label theManufacturerModel;
    @FXML protected TextArea thePatientHistory;
    @FXML protected Label theComparisonStudy;
    @FXML protected Label theReferringPhysicianName;
    @FXML protected Label theReferringPhysicianPhone;
    @FXML protected Label theReferringPhysicianAddress;
    @FXML protected Label theReferringPhysicianID;
    @FXML protected Label thePIR;
    @FXML protected Text theStatusLabel;
    @FXML protected TextArea thePatientReport;
    @FXML protected TableView<DicomTag> theReportFindingsTable;
    @FXML protected TableColumn<DicomTag, String> theFieldColumn;
    @FXML protected TableColumn<DicomTag, String> theValueColumn;
    @FXML protected TitledPane theAdditionalFactFindingsPanel;
    @FXML protected Accordion theDetails;
    @FXML protected TitledPane thePatientReportPane;
    @FXML protected TextField theFilterField;
    @FXML protected ListView<InternalNote> theInternalNotesList;
    @FXML protected ListView<Attachment> theAttachments;
    @FXML protected ProgressBar theAttachmentProgress;
    @FXML protected Label theERPAccuracyCommentsLabel;
    @FXML protected Label theERPScoreLabel;
    @FXML protected Label theERPQualityCommentsLabel;
    @FXML protected Label theCriteria1Text;
    @FXML protected Label theCriteria2Text;
    @FXML protected Label theCriteria3Text;
    @FXML protected Label theCriteria4Text;
    @FXML protected Label theCriteria5Text;
    @FXML protected Text theReportAccuracySectionLabel;
    @FXML protected Text theReportQualitySectionLabel;
    @FXML protected Button theAdditionalFactFindingsButton;
    @FXML protected Button theCorrespondingTicketButton;
    protected ProfessionalTicket theTicket;

    public BaseTicketController()
    {
        theService = Executors.newSingleThreadExecutor();
        theTags = FXCollections.observableArrayList();
        theFilteredTags = FXCollections.observableArrayList();
        theInternalNotesItems = FXCollections.observableArrayList();
        theAttachmentItems = FXCollections.observableArrayList();
        theQueryResultConverter = new TicketQueryResultConverter();
    }

    @FXML
    protected void initialize()
    {
        theTags.addListener(new ListChangeListener<DicomTag>()
        {
            @Override
            public void onChanged(ListChangeListener.Change<? extends DicomTag> change)
            {
                DicomTagFilter.filter(theTags, theFilterField.getText(), theFilteredTags, theReportFindingsTable);
            }
        });
        theFieldColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<DicomTag, String>, ObservableValue<String>>()
        {
            public ObservableValue<String> call(TableColumn.CellDataFeatures<DicomTag, String> aFeatures)
            {
                return new ReadOnlyStringWrapper(aFeatures.getValue().getDicomTagName());
            }
        });
        theValueColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<DicomTag, String>, ObservableValue<String>>()
        {
            public ObservableValue<String> call(TableColumn.CellDataFeatures<DicomTag, String> aFeatures)
            {
                return new ReadOnlyStringWrapper(aFeatures.getValue().getValue());
            }
        });
        theFilterField.textProperty().addListener(new ChangeListener<String>()
        {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue)
            {
                DicomTagFilter.filter(theTags, theFilterField.getText(), theFilteredTags, theReportFindingsTable);
            }
        });
        theAttachments.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        theAttachments.setOnMouseClicked(new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent aEvent)
            {
                if (aEvent.getButton().equals(MouseButton.PRIMARY))
                {
                    if (aEvent.getClickCount() == 2)
                    {
                        Attachment myAttachment = theAttachments.getSelectionModel().getSelectedItem();

                        if (myAttachment != null)
                        {
                            AttachmentOpener.open(getClientService(), myAttachment);
                        }
                    }
                }
            }
        });
        theReportFindingsTable.setItems(theFilteredTags);
        theInternalNotesList.setItems(theInternalNotesItems);
        theInternalNotesList.setCellFactory(new InternalNotesCellFactory(theInternalNotesList));
        theAttachments.setItems(theAttachmentItems);
        theDetails.setExpandedPane(thePatientReportPane);
    }

    public void display(ProfessionalTicket aTicket)
    {
        theAttachments.setCellFactory(new AttachmentsCellFactory(theAttachments));
        theTicket = aTicket;
        DicomStudy myStudy = aTicket.getStudy();
        setTicketDetails(myStudy);
        setPatientAndStudyDetails(myStudy);
        showTicketStatus();
        showTags(myStudy);
        theInternalNotesItems.addAll(theTicket.getNotes());
        showAttachments();
        setPatientReport(myStudy);
        theDetails.setExpandedPane(thePatientReportPane);
        setCorrespondingTicket();
    }

    private void showTags(DicomStudy aStudy)
    {
        theReportFindingsTable.setItems(theFilteredTags);
        theTags.addAll(Collections2.filter(aStudy.getTags(), new Predicate<DicomTag>()
        {
            @Override public boolean apply(DicomTag aDicomTag)
            {
                return !aDicomTag.getDicomTagName().contains("?");
            }
        }));
    }

    private void setTicketDetails(DicomStudy aStudy)
    {
        Institution myInstitution = aStudy.getInstitution();
        if (myInstitution != null)
        {
            theInstitution.setText(myInstitution.getName());
            if (myInstitution.getAddress() != null)
            {
                theTimeZone.setText(myInstitution.getAddress().getTimeZone());
            }
        }
        theSubmittedDate.setText(new Date(theTicket.getSubmittedTime()).toString());
        if (theTicket.getSubmittedUser() != null)
        {
            theSubmittedBy.setText(theTicket.getSubmittedUser().getName());
        }
    }

    private void setPatientAndStudyDetails(DicomStudy aStudy)
    {
        thePatientName.setText(aStudy.getPatientName().replaceAll("^", ""));
        thePatientMRN.setText(aStudy.getPatientID());
        thePatientDOB.setText(getDOB(aStudy));
        thePatientAge.setText(getAge(aStudy));
        theAdmittingDate.setText(findValue(aStudy, Tag.AdmittingDate));
        theAdmittingDiagnosisCode.setText(findValue(aStudy, Tag.AdmittingDiagnosesCodeSequence));
        theAdmittingDiagnosisDescription.setText(findValue(aStudy, Tag.AdmittingDiagnosesDescription));
        theModality.setText(aStudy.getModality());
        theStudyDescription.setText(aStudy.getStudyDescription());
        theAccessionNumber.setText(aStudy.getAccessionNumber());
        theStudyDate.setText(getStudyDateToString(aStudy));
        theImageCount.setText(findValue(aStudy, Tag.NumberOfSlices));
        theSliceThickness.setText(findValue(aStudy, Tag.SliceThickness));
        theScanLength.setText(findValue(aStudy, Tag.ScanLength));
        theCTDIVolume.setText(findValue(aStudy, Tag.CTDIvol));
        theManufacturer.setText(findValue(aStudy, Tag.Manufacturer));
        theManufacturerModel.setText(findValue(aStudy, Tag.ManufacturerModelName));
        theReferringPhysicianName.setText(findValue(aStudy, Tag.ReferringPhysicianName));
        theReferringPhysicianID.setText(findValue(aStudy, Tag.ReferringPhysicianIdentificationSequence));
        theReferringPhysicianAddress.setText(findValue(aStudy, Tag.ReferringPhysicianAddress));
        theReferringPhysicianPhone.setText(findValue(aStudy, Tag.ReferringPhysicianTelephoneNumbers));
        theComparisonStudy.setText(findValue(aStudy, Tag.NumberOfPatientRelatedStudies));
        setPatientHistory(aStudy);
    }

    private void setPatientHistory(DicomStudy aStudy)
    {
        String myAdditionalPatientHistory = findValue(aStudy, Tag.AdditionalPatientHistory);
        String myReasonForStudy = findValue(aStudy, Tag.ReasonForStudy);
        String myHL7PatientHistory = HL7DataFinder.findPatientHistory(theTicket.getHL7Messages());
        String myHistory = myAdditionalPatientHistory.contains("N/A") ?
                (myReasonForStudy.contains("N/A") ?
                        (myHL7PatientHistory == null ? "N/A" : myHL7PatientHistory) :
                        myReasonForStudy) : myAdditionalPatientHistory;
        thePatientHistory.setText(myHistory);
    }

    private void showTicketStatus()
    {
        if (theStatusLabel != null)
        {
            theStatusLabel.setText(theTicket.getViewId() + " | " + theTicket.getStatus().getDescription());
            theStatusLabel.getStyleClass().add(theTicket.getPriority().name().toLowerCase());
        }
    }

    private void setPatientReport(DicomStudy aStudy)
    {
        String myPatientReport = aStudy.getPatientReport();
        List<HL7> myHL7Messages = theTicket.getHL7Messages();
        if (myPatientReport != null && !myPatientReport.isEmpty())
        {
            thePatientReport.setText(myPatientReport);
        }
        else
        {
            if (myHL7Messages != null)
            {
                String myReport = HL7DataFinder.findPatientReport(myHL7Messages);
                if (myReport != null && thePatientReport != null)
                {
                    thePatientReport.setText(myReport);
                }
            }
        }
        setPIR(aStudy, myHL7Messages);
        setCPTCode(aStudy, myHL7Messages);
    }

    private void setPIR(DicomStudy aStudy, List<HL7> aHL7Messages)
    {
        String myPIR = aHL7Messages != null ?
                HL7DataFinder.findPIR(aHL7Messages) : findValue(aStudy, Tag.InterpretationAuthor);
        if (myPIR != null && thePIR != null)
        {
            thePIR.setText(myPIR);
        }
    }

    private void setCPTCode(DicomStudy aStudy, List<HL7> aHL7Messages)
    {
        String myCPTCode = aHL7Messages != null ? HL7DataFinder.findCPTCode(aHL7Messages) : NA;
        theCPTCode.setText(myCPTCode);
    }

    private void setCorrespondingTicket()
    {
        if (theCorrespondingTicketButton != null)
        {
            if (theTicket.getCorrespondingReviewViewId() != null)
            {
                theCorrespondingTicketButton.setText(theTicket.getCorrespondingReviewViewId());
            }
            else
            {
                theCorrespondingTicketButton.setVisible(false);
            }
        }
    }

    @FXML
    protected void onCancel()
    {
        theMain.closeTicket();
    }

    @FXML
    protected void onOpenCorrespondingTicket()
    {
        saveDetails();
        saveTicket();
        theMain.showCorrespondingTicket(theTicket.getCorrespondingReviewViewId());
    }

    protected void showAttachments()
    {
        Task<List<Attachment>> myTask = new Task<List<Attachment>>()
        {
            @Override protected List<Attachment> call() throws Exception
            {
                updateProgress(ProgressIndicator.INDETERMINATE_PROGRESS, 1);
                updateMessage("Retrieving attachments ...");
                final List<Attachment> myAttachments = getClientService().getTicketAttachments(theTicket);
                try
                {
                    Platform.runLater(new Runnable()
                    {
                        @Override public void run()
                        {
                            theAttachmentItems.clear();
                            theAttachmentItems.addAll(myAttachments);
                        }
                    });
                }
                finally
                {
                    updateMessage("");
                    updateProgress(1, 1);
                }

                return myAttachments;
            }
        };

        theAttachmentProgress.progressProperty().bind(myTask.progressProperty());
        theService.execute(myTask);
    }

    protected void clearFields()
    {
        theInternalNotesItems.clear();
        theFilteredTags.clear();
        theTags.clear();
        theAttachmentItems.clear();
        theInstitution.setText(NA);
        theTimeZone.setText(NA);
        theSubmittedDate.setText(NA);
        theSubmittedBy.setText(NA);
        thePatientName.setText(NA);
        thePatientMRN.setText(NA);
        thePatientDOB.setText(NA);
        thePatientAge.setText(NA);
        thePatientSex.setText(NA);
        theAdmittingDate.setText(NA);
        theAdmittingDiagnosisCode.setText(NA);
        theAdmittingDiagnosisDescription.setText(NA);
        theModality.setText(NA);
        theStudyDescription.setText(NA);
        theAccessionNumber.setText(NA);
        theStudyDate.setText(NA);
        theCPTCode.setText(NA);
        theImageCount.setText(NA);
        theSliceThickness.setText(NA);
        theScanLength.setText(NA);
        theCTDIVolume.setText(NA);
        theManufacturer.setText(NA);
        theManufacturerModel.setText(NA);
        thePatientHistory.setText(NA);
        theComparisonStudy.setText(NA);
        theReferringPhysicianName.setText(NA);
        theReferringPhysicianPhone.setText(NA);
        theReferringPhysicianAddress.setText(NA);
        theReferringPhysicianID.setText(NA);
        thePIR.setText(NA);
        thePatientReport.clear();
        theFilterField.clear();
    }

    protected void saveTicket()
    {
        ObservableList<TicketQueryResult> myTickets = getEntityCache().getTickets();
        int myIndex = myTickets.indexOf(getEntityCache().getSelectedTicket());
        ProfessionalTicket myTicket = getClientService().createOrUpdateProfessionalTicket(theTicket, theUser);
        TicketQueryResult myConvert = theQueryResultConverter.convert(myTicket);
        myTickets.set(myIndex, myConvert);
        getEntityCache().setSelectedTicket(myConvert);
    }

    protected void generatePRERPResponseLetter()
    {
        getClientService().generateERPResponseLetter(theTicket, theUser);
    }

    protected void generatePRERPSiteCallLetter()
    {
        getClientService().generateERPSiteCallLetter(theTicket, theUser);
    }

    protected void generatePRCMOSiteCallLetter()
    {
        getClientService().generateCMOSiteCallLetter(theTicket, theUser);
    }

    protected void generatePRCMOResponseLetter()
    {
        getClientService().generateCMOResponseLetter(theTicket, theUser);
    }

    protected void generateTRERPResponseLetter()
    {
        getClientService().generateTechERPResponseLetter(theTicket, theUser);
    }

    @FXML
    protected void onView()
    {
        theMain.showViewer(theTicket.getStudy());
    }

    protected abstract void saveDetails();
}
