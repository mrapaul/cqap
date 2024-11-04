package com.capstone.fx.controllers;

import com.capstone.fx.components.*;
import com.capstone.fx.model.*;
import com.capstone.fx.utils.*;
import com.peirs.datamodel.*;
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
import jfxtras.labs.scene.control.*;

import java.util.*;
import java.util.concurrent.*;

public class MyTicketController extends BaseController
{
    private final ExecutorService theService;
    @FXML protected TableView<TicketQueryResult> theTicketTable;
    @FXML protected HBox theSpacer;
    @FXML protected HBox theProgressBox;
    @FXML protected TextField theTicketId;
    @FXML protected ComboBox<String> theTicketPriority;
    @FXML protected ComboBox<String> theStatus;
    @FXML protected ComboBox<Group> theGroup;
    @FXML protected ComboBox<Institution> theInstitution;
    @FXML protected TextField thePatientFirstName;
    @FXML protected TextField thePatientLastName;
    @FXML protected TextField thePatientMRN;
    @FXML protected TextField theStudyDescription;
    @FXML protected TextField theAccessionNumber;
    @FXML protected TextField theCPTCode;
    @FXML protected TextField theStudyDate;
    @FXML protected ComboBox<String> theIIR;
    @FXML protected ComboBox<String> theSiteTechnologist;
    @FXML protected CalendarTextField theDateSubmittedFrom;
    @FXML protected CalendarTextField theDateSubmittedTo;
    @FXML protected TextField theSubmittedBy;
    @FXML protected TextField theERP;
    @FXML protected TableColumn<TicketQueryResult, String> theTicketIdColumn;
    @FXML protected TableColumn<TicketQueryResult, String> theStatusColumn;
    @FXML protected TableColumn<TicketQueryResult, String> thePatientNameColumn;
    @FXML protected TableColumn<TicketQueryResult, String> thePatientIDColumn;
    @FXML protected TableColumn<TicketQueryResult, String> theStudyDescriptionColumn;
    @FXML protected TableColumn<TicketQueryResult, String> theModalityColumn;
    @FXML protected TableColumn<TicketQueryResult, String> thePRTRColumn;
    @FXML protected TableColumn<TicketQueryResult, String> theERPColumn;
    @FXML protected TableColumn<TicketQueryResult, String> theCategoryColumn;
    @FXML protected TableColumn<TicketQueryResult, String> theStudyDateColumn;
    @FXML protected TableColumn<TicketQueryResult, String> theInstitutionColumn;
    @FXML protected ProgressIndicator theSearchProgress;
    @FXML protected Label theResultCountLabel;
    private Task theTask;

    public MyTicketController()
    {
        theService = Executors.newSingleThreadExecutor();
    }

    @FXML
    protected void initialize()
    {
        theTicketTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        theTicketIdColumn.setCellValueFactory(new PropertyValueFactory<TicketQueryResult, String>("ticketId"));
        theStatusColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<TicketQueryResult, String>, ObservableValue<String>>()
        {
            public ObservableValue<String> call(TableColumn.CellDataFeatures<TicketQueryResult, String> aFeatures)
            {
                return new ReadOnlyStringWrapper(aFeatures.getValue().getStatus().getDescription());
            }
        });
        theCategoryColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<TicketQueryResult, String>, ObservableValue<String>>()
        {
            public ObservableValue<String> call(TableColumn.CellDataFeatures<TicketQueryResult, String> aFeatures)
            {
                TicketQueryResult myTicket = aFeatures.getValue();
                return new ReadOnlyStringWrapper(String.valueOf(myTicket.getCategory()));
            }
        });
        theTicketIdColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<TicketQueryResult, String>, ObservableValue<String>>()
        {
            public ObservableValue<String> call(TableColumn.CellDataFeatures<TicketQueryResult, String> aFeatures)
            {
                return new ReadOnlyStringWrapper(aFeatures.getValue().getViewId());
            }
        });
        thePatientNameColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<TicketQueryResult, String>, ObservableValue<String>>()
        {
            public ObservableValue<String> call(TableColumn.CellDataFeatures<TicketQueryResult, String> aFeatures)
            {
                return new ReadOnlyStringWrapper(aFeatures.getValue().getPatientName());
            }
        });
        thePatientIDColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<TicketQueryResult, String>, ObservableValue<String>>()
        {
            public ObservableValue<String> call(TableColumn.CellDataFeatures<TicketQueryResult, String> aFeatures)
            {
                return new ReadOnlyStringWrapper(aFeatures.getValue().getPatientID());
            }
        });
        theStudyDescriptionColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<TicketQueryResult, String>, ObservableValue<String>>()
        {
            public ObservableValue<String> call(TableColumn.CellDataFeatures<TicketQueryResult, String> aFeatures)
            {
                return new ReadOnlyStringWrapper(aFeatures.getValue().getStudyDescription());
            }
        });
        theModalityColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<TicketQueryResult, String>, ObservableValue<String>>()
        {
            public ObservableValue<String> call(TableColumn.CellDataFeatures<TicketQueryResult, String> aFeatures)
            {
                return new ReadOnlyStringWrapper(aFeatures.getValue().getModality());
            }
        });
        theStudyDateColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<TicketQueryResult, String>, ObservableValue<String>>()
        {
            public ObservableValue<String> call(TableColumn.CellDataFeatures<TicketQueryResult, String> aFeatures)
            {
                return new ReadOnlyStringWrapper(aFeatures.getValue().getStudyDate());
            }
        });
        theERPColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<TicketQueryResult, String>, ObservableValue<String>>()
        {
            public ObservableValue<String> call(TableColumn.CellDataFeatures<TicketQueryResult, String> aFeatures)
            {
                return new ReadOnlyStringWrapper(aFeatures.getValue().getERP());
            }
        });
        theInstitutionColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<TicketQueryResult, String>, ObservableValue<String>>()
        {
            public ObservableValue<String> call(TableColumn.CellDataFeatures<TicketQueryResult, String> aFeatures)
            {
                return new ReadOnlyStringWrapper(aFeatures.getValue().getInstitutionName());
            }
        });
        theStudyDateColumn.setComparator(new StudyDateComparator());
        theTicketPriority.setItems(EnumItems.fromEnum(TicketPriority.values()));
        theTicketTable.setOnMouseClicked(new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent aEvent)
            {
                if (aEvent.getClickCount() > 1)
                {
                    TicketQueryResult myResult = theTicketTable.getSelectionModel().getSelectedItem();
                    getEntityCache().setSelectedTicket(myResult);
                    if (myResult != null)
                    {
                        theMain.showTicket(myResult);
                    }
                }
            }
        });
        theTicketTable.setRowFactory(new TicketRowFactory());
        resetDateFields();
        theStudyDate.clear();
        HBox.setHgrow(theSpacer, Priority.ALWAYS);
        HBox.setHgrow(theProgressBox, Priority.ALWAYS);
        onTicketSearchReset();
    }

    @Override public void setEntityCache(EntityCache aEntityCache)
    {
        super.setEntityCache(aEntityCache);

        theGroup.setItems(getEntityCache().getGroups());
        theInstitution.setItems(getEntityCache().getInstitutions());
        theIIR.setItems(getEntityCache().getPIRs());
        theSiteTechnologist.setItems(getEntityCache().getSTs());
        theTicketTable.setItems(getEntityCache().getTickets());
    }

    @FXML
    public void onTicketSearch()
    {
        cancelTaskIfRunning();
        theTask = new Task()
        {
            @Override protected Object call() throws Exception
            {
                theSearchProgress.setVisible(true);
                ObservableList<TicketQueryResult> myProfessionalTickets = getEntityCache().getTickets();
                TicketQueryBuilder myBuilder = buildQuery();
                myProfessionalTickets.clear();
                final long myStartTime = System.currentTimeMillis();
                final List<TicketQueryResult> myTickets = getClientService().findProfessionalTickets(myBuilder.build());
                final long myEndTime = System.currentTimeMillis();
                myProfessionalTickets.addAll(myTickets);

                Platform.runLater(new Runnable()
                {
                    @Override public void run()
                    {
                        long myTime = TimeUnit.SECONDS.convert(myEndTime - myStartTime, TimeUnit.MILLISECONDS);
                        theResultCountLabel.setText(myTickets.size() +
                                " tickets found in " +
                                myTime +
                                " seconds");
                    }
                });
                theSearchProgress.setVisible(false);
                theSearchProgress.progressProperty().unbind();
                return myTickets;
            }
        };
        theSearchProgress.progressProperty().bind(theTask.progressProperty());
        theService.execute(theTask);
    }

    protected TicketQueryBuilder buildQuery()
    {
        String myTicketId = theTicketId.getText().trim();
        String myTicketPriority = theTicketPriority.getSelectionModel().getSelectedItem();
        String myTicketStatus = theStatus.getSelectionModel().getSelectedItem();
        Group myGroup = theGroup.getSelectionModel().getSelectedItem();
        Institution myInstitution = theInstitution.getSelectionModel().getSelectedItem();
        String myPatientLastName = thePatientLastName.getText().trim();
        String myPatientFirstName = thePatientFirstName.getText().trim();
        String myPatientMRN = thePatientMRN.getText().trim();
        String myStudyDescription = theStudyDescription.getText().trim();
        String myAccessionNumber = theAccessionNumber.getText().trim();
        String myCPTCode = theCPTCode.getText().trim();
        String myIIR = theIIR.getSelectionModel().getSelectedItem();
        String mySiteTechnologist = theSiteTechnologist.getSelectionModel().getSelectedItem();
        String mySubmittedBy = theSubmittedBy.getText().trim();
        String myERP = theERP.getText().trim();

        TicketQueryBuilder myBuilder = new TicketQueryBuilder()
                .setTicketId(myTicketId)
                .setTicketPriority(myTicketPriority)
                .setTicketStatus(myTicketStatus)
                .setGroup(myGroup)
                .setInstitution(myInstitution)
                .setPatientLastName(myPatientLastName)
                .setPatientFirstName(myPatientFirstName)
                .setPatientID(myPatientMRN)
                .setStudyDescription(myStudyDescription)
                .setAccessionNumber(myAccessionNumber)
                .setCPTCode(myCPTCode)
                .setIIR(myIIR)
                .setSiteTechnologist(mySiteTechnologist)
                .setSubmittedBy(mySubmittedBy)
                .setERP(myERP)
                .setDeleted(false);

        myBuilder.setStudyDate(theStudyDate.getText());
        GregorianCalendar myCalendar = new GregorianCalendar();
        myCalendar.setTimeInMillis(theDateSubmittedTo.getValue().getTimeInMillis());
        myCalendar.set(Calendar.HOUR, 23);
        myCalendar.set(Calendar.MINUTE, 59);
        myCalendar.set(Calendar.SECOND, 59);
        myBuilder.setDateSubmittedFrom(theDateSubmittedFrom.getValue().getTimeInMillis());
        myBuilder.setDateSubmittedTo(myCalendar.getTimeInMillis());
        return myBuilder;
    }

    @FXML
    protected void onTicketSearchReset()
    {
        theTicketId.clear();
        theTicketPriority.getSelectionModel().clearSelection();
        theStatus.getSelectionModel().clearSelection();
        theGroup.getSelectionModel().clearSelection();
        theInstitution.getSelectionModel().clearSelection();
        thePatientFirstName.clear();
        thePatientLastName.clear();
        thePatientMRN.clear();
        theStudyDescription.clear();
        theAccessionNumber.clear();
        theCPTCode.clear();
        theIIR.getSelectionModel().clearSelection();
        theSiteTechnologist.getSelectionModel().clearSelection();
        theSubmittedBy.clear();
        theERP.clear();
        theStudyDate.clear();
        theResultCountLabel.setText(null);
        theDateSubmittedFrom.getStyleClass().remove("selected");
        theStatus.setItems(EnumItems.fromEnum(TicketStatus.values()));
        resetDateFields();
        if (getEntityCache() != null)
        {
            getEntityCache().getTickets().clear();
        }
    }

    private void resetDateFields()
    {
        theDateSubmittedFrom.setValue(new GregorianCalendar(2013, 0, 1));
        theDateSubmittedTo.setValue(new GregorianCalendar());
    }

    @Override
    public void onHome()
    {
        cancelTaskIfRunning();
        theService.shutdown();

        super.onHome();
    }

    private void cancelTaskIfRunning()
    {
        if (theTask != null && theTask.isRunning())
        {
            theTask.cancel();
        }
    }
}
