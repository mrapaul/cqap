package com.capstone.fx.controllers;

import com.capstone.fx.components.*;
import com.capstone.fx.controllers.*;
import com.capstone.fx.model.*;
import com.capstone.fx.utils.*;
import com.peirs.datamodel.ticket.*;
import javafx.application.*;
import javafx.beans.property.*;
import javafx.beans.value.*;
import javafx.collections.*;
import javafx.concurrent.*;
import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.scene.control.cell.*;
import javafx.scene.input.*;
import javafx.scene.layout.*;
import javafx.util.*;

import java.util.*;
import java.util.concurrent.*;

public class TicketAdministrationController extends BaseEditableTicketController
{
    private final ScheduledExecutorService theService;
    private final ObservableList<TicketQueryResult> theFilteredTickets;
    @FXML private TextField theTicketFilterField;
    @FXML private TableView<TicketQueryResult> theTicketsTable;
    @FXML protected TableColumn<TicketQueryResult, String> theTicketIdColumn;
    @FXML protected TableColumn<TicketQueryResult, String> theStatusColumn;
    @FXML protected TableColumn<TicketQueryResult, String> thePatientNameColumn;
    @FXML protected ComboBox<TicketStatus> theTicketStatus;
    @FXML protected ComboBox<TicketPriority> theTicketPriority;
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
    @FXML private CheckBox theERPReportResend;
    @FXML private CheckBox theERPSiteCallResend;
    @FXML private CheckBox theCMOReportResend;
    @FXML private CheckBox theCMOSiteCallResend;
    @FXML private AnchorPane theTicketDetailsPane;
    private ProfessionalTicket theSelectedTicket;

    public TicketAdministrationController()
    {
        theFilteredTickets = FXCollections.observableArrayList();
        theService = Executors.newSingleThreadScheduledExecutor();
    }

    @Override public void setEntityCache(EntityCache aEntityCache)
    {
        super.setEntityCache(aEntityCache);

        final ObservableList<TicketQueryResult> myTickets = getEntityCache().getTickets();
        myTickets.addListener(new ListChangeListener<TicketQueryResult>()
        {
            @Override
            public void onChanged(ListChangeListener.Change<? extends TicketQueryResult> change)
            {
                TicketFilter.filter(myTickets, theTicketFilterField.getText(), theFilteredTickets, theTicketsTable);
            }
        });
        theTicketFilterField.textProperty().addListener(new ChangeListener<String>()
        {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue)
            {
                TicketFilter.filter(myTickets, theTicketFilterField.getText(), theFilteredTickets, theTicketsTable);
            }
        });
    }

    @FXML
    protected void initialize()
    {
        super.initialize();
        theTicketsTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        theTicketIdColumn.setCellValueFactory(new PropertyValueFactory<TicketQueryResult, String>("viewId"));
        theStatusColumn.setCellValueFactory(new PropertyValueFactory<TicketQueryResult, String>("status"));
        thePatientNameColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<TicketQueryResult, String>, ObservableValue<String>>()
        {
            public ObservableValue<String> call(TableColumn.CellDataFeatures<TicketQueryResult, String> aFeatures)
            {
                return new ReadOnlyStringWrapper(aFeatures.getValue().getPatientName());
            }
        });
        theTicketPriority.setItems(FXCollections.observableArrayList(TicketPriority.values()));
        theTicketStatus.setItems(FXCollections.observableArrayList(TicketStatus.values()));
        theTicketsTable.setItems(theFilteredTickets);
        theTicketsTable.setRowFactory(new TicketRowFactory());
        theTicketsTable.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<TicketQueryResult>()
        {
            @Override public void changed(ObservableValue<? extends TicketQueryResult> aObservableValue,
                                          TicketQueryResult aAttachment,
                                          TicketQueryResult aAttachment2)
            {
                clearFields();
                if (aObservableValue != null && aObservableValue.getValue() != null)
                {
                    TicketQueryResult myQueryResult = aObservableValue.getValue();
                    getEntityCache().setSelectedTicket(myQueryResult);
                    theSelectedTicket = getClientService().findProfessionalTicket(myQueryResult);
                    setTicketValues();
                }
            }
        });
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
        theCategory.setItems(EnumItems.fromEnum(ProfessionalTicketCategory.values()));
        theCMOCategory.setItems(EnumItems.fromEnum(ProfessionalTicketCategory.values()));

    }

    private void setTicketValues()
    {
        display(theSelectedTicket);
        theTicketStatus.setItems(getStatuses(theSelectedTicket.getType()));
        if (theSelectedTicket.getType() == TicketType.PR)
        {
            theTicketPriority.setItems(FXCollections.observableArrayList(TicketPriority.values()));
        }
        else
        {
            theTicketPriority.setItems(FXCollections.observableArrayList(TicketPriority.TR, TicketPriority.RR));
        }
        theTicketStatus.getSelectionModel().select(theSelectedTicket.getStatus());
        theTicketPriority.getSelectionModel().select(theSelectedTicket.getPriority());
        setERPReport(theSelectedTicket);
        setIIRReport(theSelectedTicket);
        setCMOReport(theSelectedTicket);
    }

    private ObservableList<TicketStatus> getStatuses(TicketType aType)
    {
        ObservableList<TicketStatus> myStatusList = FXCollections.observableArrayList();

        for (TicketStatus myStatus : TicketStatus.values())
        {
            if (myStatus.getTicketType() == aType)
            {
                myStatusList.add(myStatus);
            }
        }

        return myStatusList;
    }

    private void setERPReport(ProfessionalTicket aTicket)
    {
        ERPReport myERPReport = aTicket.getERPReport();
        if (myERPReport != null)
        {
            ProfessionalTicketCategory myCategory = ProfessionalTicketCategory.lookup(myERPReport.getCategory());
            if (myCategory != null)
            {
                theCategory.getSelectionModel().select(myCategory.getDescription());
                theReportAccuracyScore.setText(String.valueOf(myCategory.getScore()));
            }
            theReportAccuracyComments.setText(myERPReport.getReportAccuracyComments());
            theReportQualityComments.setText(myERPReport.getReportQualityComments());
            theAdditionalFindings.setText(myERPReport.getAdditionalFactFindings());
            theRecommendations.setText(myERPReport.getRecommendation());
            theCriteria1.setSelected(myERPReport.isCriteria1());
            theCriteria2.setSelected(myERPReport.isCriteria2());
            theCriteria3.setSelected(myERPReport.isCriteria3());
            theCriteria4.setSelected(myERPReport.isCriteria4());
            theCriteria5.setSelected(myERPReport.isCriteria5());
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

    @FXML
    protected void onSave()
    {
        if (theSelectedTicket == null)
        {
            return;
        }

        TicketStatus mySelectedStatus = theTicketStatus.getSelectionModel().getSelectedItem();
        if (mySelectedStatus != null && theSelectedTicket.getStatus() != mySelectedStatus)
        {
            theSelectedTicket.addNote(new InternalNote("Ticket status changed from " +
                    theSelectedTicket.getStatus().name() +
                    " to " +
                    mySelectedStatus, new Date(), theUser));
            theSelectedTicket.setStatus(mySelectedStatus);
        }

        TicketPriority myTicketPriority = theTicketPriority.getSelectionModel().getSelectedItem();
        if (myTicketPriority != null && theSelectedTicket.getPriority() != myTicketPriority)
        {
            theSelectedTicket.addNote(new InternalNote("Ticket priority changed from " +
                    theSelectedTicket.getPriority().name() +
                    " to " +
                    myTicketPriority, new Date(), theUser));
            theSelectedTicket.setPriority(myTicketPriority);
        }
        saveDetails();
        saveTicket();
        clearFields();
        showTickets();
    }

    @Override
    protected void saveDetails()
    {
        saveTicketDetails();
    }

    private void saveTicketDetails()
    {
        theSelectedTicket.setPriority(theTicketPriority.getSelectionModel().getSelectedItem());
        theSelectedTicket.setStatus(theTicketStatus.getSelectionModel().getSelectedItem());
        ERPReport myReport = theTicket.getERPReport();
        String myCategoryStr = theCategory.getSelectionModel().getSelectedItem();
        if (myReport != null && myCategoryStr != null)
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
            theTicket.setERPReport(myReport);
        }

        CMOReport myCMOReport = theTicket.getCMOReport();
        String myCMOCategory = theCMOCategory.getSelectionModel().getSelectedItem();
        if (myCMOReport != null && myCMOCategory != null)
        {
            myCMOReport.setCategory(ProfessionalTicketCategory.lookup(myCMOCategory).getCode());
            myCMOReport.setReportAccuracyComments(theCMOReportAccuracyComments.getText());
            myCMOReport.setCriteria1(theCMOCriteria1.isSelected());
            myCMOReport.setCriteria2(theCMOCriteria2.isSelected());
            myCMOReport.setCriteria3(theCMOCriteria3.isSelected());
            myCMOReport.setCriteria4(theCMOCriteria4.isSelected());
            myCMOReport.setCriteria5(theCMOCriteria5.isSelected());
            myCMOReport.setReportQualityComments(theCMOReportQualityComments.getText());
            myCMOReport.setRecommendation(theCMORecommendations.getText());
            myCMOReport.setReportQuality(calculateReportQuality(myCMOReport));
            if (theCMOAdditionalFindings.getText() != null)
            {
                myCMOReport.setAdditionalFactFindings(theCMOAdditionalFindings.getText().trim());
            }
            theTicket.setCMOReport(myCMOReport);
        }
    }

    @FXML
    private void onDelete()
    {
        if (theSelectedTicket == null)
        {
            return;
        }

        getClientService().deleteProfessionalTicket(theSelectedTicket, theUser);
        clearFields();
        showTickets();
    }

    protected void clearFields()
    {
        super.clearFields();
        theTicketStatus.getSelectionModel().clearSelection();
        theTicketPriority.getSelectionModel().clearSelection();
        theCategory.getSelectionModel().clearSelection();
        theReportAccuracyComments.clear();
        theReportAccuracyScore.setText("0");
        theCriteria1.setSelected(false);
        theCriteria2.setSelected(false);
        theCriteria3.setSelected(false);
        theCriteria4.setSelected(false);
        theCriteria5.setSelected(false);
        theReportQualityComments.clear();
        theRecommendations.clear();
        theIIRDecision.setText(NA);
        theDisagreeComments.clear();
        theCMOAdditionalFindings.clear();
        theReportQuality.setText(NA);
        theCMOCategory.getSelectionModel().clearSelection();
        theCMOReportAccuracyComments.clear();
        theCMOReportAccuracyScore.setText("0");
        theCMOReportQualityScore.setText("0");
        theCMOCriteria1.setSelected(false);
        theCMOCriteria2.setSelected(false);
        theCMOCriteria3.setSelected(false);
        theCMOCriteria4.setSelected(false);
        theCMOCriteria5.setSelected(false);
        theCMOReportQualityComments.clear();
        theCMORecommendations.clear();
        theERPReportResend.setSelected(false);
        theERPSiteCallResend.setSelected(false);
        theCMOReportResend.setSelected(false);
        theCMOSiteCallResend.setSelected(false);
        theSelectedTicket = null;
    }

    @FXML
    public void showTickets()
    {
        Task<List<TicketQueryResult>> myTask = new Task<List<TicketQueryResult>>()
        {
            @Override protected List<TicketQueryResult> call() throws Exception
            {
                updateProgress(ProgressIndicator.INDETERMINATE_PROGRESS, 1);

                Calendar myCalendar = new GregorianCalendar(1970, 1, 1);
                TicketQuery myQuery =
                        new TicketQueryBuilder().setDateSubmittedFrom(myCalendar.getTimeInMillis())
                                .setDateSubmittedTo(new Date().getTime())
                                .setDeleted(false)
                                .build();
                List<TicketQueryResult> myList = getClientService().findProfessionalTickets(myQuery);
                displayTickets(myList);
                updateMessage("");
                updateProgress(1, 1);

                return myList;
            }

            private void displayTickets(final List<TicketQueryResult> aTickets)
            {
                Platform.runLater(new Runnable()
                {
                    @Override public void run()
                    {
                        ObservableList<TicketQueryResult> myTickets = getEntityCache().getTickets();
                        int mySelectedIndex = theTicketsTable.getSelectionModel().getSelectedIndex();
                        theTicketDetailsPane.setVisible(false);
                        theDetails.setVisible(false);
                        myTickets.clear();
                        theFilteredTickets.clear();
                        myTickets.addAll(aTickets);
                        theTicketsTable.getSelectionModel().select(mySelectedIndex);
                        theTicketDetailsPane.setVisible(true);
                        theDetails.setVisible(true);
                    }
                });
            }
        };
        theService.submit(myTask);
    }

    @FXML
    @Override
    protected void onCancel()
    {
        super.onCancel();
        theTicketsTable.getSelectionModel().clearSelection();
        clearFields();
    }

    @FXML
    private void onResendReport()
    {
        saveTicketDetails();
        if (theERPReportResend.isSelected())
        {
            if (theTicket.getType() == TicketType.PR && theSelectedTicket.getERPReport() != null)
            {
                getClientService().generateERPResponseLetter(theSelectedTicket,
                        theSelectedTicket.getERPReport().getERP());
            }
            else if (theTicket.getType() == TicketType.TR && theSelectedTicket.getTechReport() != null)
            {
                getClientService().generateTechERPResponseLetter(theSelectedTicket,
                        theSelectedTicket.getTechReport().getERP());
            }
        }

        if (theERPSiteCallResend.isSelected() &&
                theSelectedTicket.getERPReport() != null &&
                theSelectedTicket.getERPReport().getSiteCallReport() != null)
        {
            getClientService().generateERPSiteCallLetter(theTicket,
                    theSelectedTicket.getERPReport().getSiteCallReport().getUser());
        }

        if (theCMOReportResend.isSelected() && theSelectedTicket.getCMOReport() != null)
        {
            getClientService().generateCMOResponseLetter(theSelectedTicket, theSelectedTicket.getCMOReport().getCMO());
        }

        if (theCMOSiteCallResend.isSelected() &&
                theSelectedTicket.getCMOReport() != null &&
                theSelectedTicket.getCMOReport().getSiteCallReport() != null)
        {
            getClientService().generateCMOSiteCallLetter(theSelectedTicket,
                    theSelectedTicket.getCMOReport().getSiteCallReport().getUser());
        }
        clearFields();
    }
}
