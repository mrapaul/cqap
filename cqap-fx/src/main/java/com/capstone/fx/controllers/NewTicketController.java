package com.capstone.fx.controllers;

import com.capstone.fx.utils.*;
import com.cqap.client.*;
import com.cqap.util.*;
import com.google.common.base.*;
import com.google.common.collect.*;
import com.peirs.datamodel.*;
import com.peirs.datamodel.Modality;
import com.peirs.datamodel.dicom.*;
import com.peirs.datamodel.ticket.*;
import com.peirs.dicom.*;
import com.sun.javafx.binding.*;
import javafx.application.Platform;
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
import javafx.stage.*;
import javafx.util.*;
import jfxtras.labs.dialogs.*;
import org.apache.commons.io.*;
import org.apache.commons.lang.*;
import org.slf4j.*;

import java.io.*;
import java.util.*;
import java.util.concurrent.*;

import static ch.lambdaj.collection.LambdaCollections.*;

public class NewTicketController extends BaseController
{
    private static final Logger LOGGER = LoggerFactory.getLogger(NewTicketController.class);
    private final ObservableList<DicomStudyWrapper> theStudies;
    private final ObservableList<Group> theGroups;
    private final ObservableList<Institution> theInstitutions;
    private final ExecutorService theService;
    @FXML HBox theProgressBox;
    @FXML HBox theButtonBox;
    @FXML HBox theTopSpacer;
    @FXML CheckBox theProfessionalType;
    @FXML CheckBox theTechType;
    @FXML ProgressIndicator theProgress;
    @FXML private ComboBox<Group> theGroup;
    @FXML private ComboBox<Institution> theInstitution;
    @FXML private TextField thePatientLastName;
    @FXML private TextField thePatientFirstName;
    @FXML private TextField thePatientMRN;
    @FXML private ComboBox<String> theModality;
    @FXML private TextField theStudyDescription;
    @FXML private TextField theAccessionNumber;
    @FXML private TextField theStudyDate;
    @FXML private ComboBox<String> theIIR;
    @FXML private TextField theSiteTechnologist;
    @FXML private TableView<DicomStudyWrapper> theDicomStudyTable;
    @FXML private TableColumn<DicomStudyWrapper, Boolean> theImportColumn;
    @FXML private TableColumn<DicomStudyWrapper, String> theInstitutionColumn;
    @FXML private TableColumn<DicomStudyWrapper, String> thePatientNameColumn;
    @FXML private TableColumn<DicomStudyWrapper, String> thePatientIDColumn;
    @FXML private TableColumn<DicomStudyWrapper, String> theAccessionIDColumn;
    @FXML private TableColumn<DicomStudyWrapper, String> theStudyDescriptionColumn;
    @FXML private TableColumn<DicomStudyWrapper, String> theModalityColumn;
    @FXML private TableColumn<DicomStudyWrapper, Integer> theFileCountColumn;
    @FXML private TableColumn<DicomStudyWrapper, String> theStudyDateColumn;
    @FXML private TableColumn<DicomStudyWrapper, String> theTicketsColumn;
    @FXML private ToggleGroup theReviewType;
    @FXML private Label theResultCountLabel;
    @FXML private CheckBox theSubmittedVariance;
    @FXML private RadioButton theRTRTType;
    @FXML private RadioButton theRTRCType;
    @FXML private RadioButton theURType;
    @FXML private RadioButton theRRType;
    @FXML private RadioButton theTRType;
    private Task theTask;

    public NewTicketController()
    {
        theStudies = FXCollections.observableArrayList();
        theGroups = FXCollections.observableArrayList();
        theInstitutions = FXCollections.observableArrayList();
        theService = Executors.newSingleThreadExecutor();
    }

    @FXML
    private void initialize()
    {
        theDicomStudyTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        thePatientNameColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<DicomStudyWrapper, String>, ObservableValue<String>>()
        {
            public ObservableValue<String> call(TableColumn.CellDataFeatures<DicomStudyWrapper, String> aFeatures)
            {
                return new ReadOnlyStringWrapper(aFeatures.getValue().getStudy().getPatientName().trim());
            }
        });
        thePatientIDColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<DicomStudyWrapper, String>, ObservableValue<String>>()
        {
            public ObservableValue<String> call(TableColumn.CellDataFeatures<DicomStudyWrapper, String> aFeatures)
            {
                return new ReadOnlyStringWrapper(aFeatures.getValue().getStudy().getPatientID());
            }
        });
        theAccessionIDColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<DicomStudyWrapper, String>, ObservableValue<String>>()
        {
            public ObservableValue<String> call(TableColumn.CellDataFeatures<DicomStudyWrapper, String> aFeatures)
            {
                return new ReadOnlyStringWrapper(aFeatures.getValue().getStudy().getAccessionNumber());
            }
        });
        theStudyDescriptionColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<DicomStudyWrapper, String>, ObservableValue<String>>()
        {
            public ObservableValue<String> call(TableColumn.CellDataFeatures<DicomStudyWrapper, String> aFeatures)
            {
                return new ReadOnlyStringWrapper(aFeatures.getValue().getStudy().getStudyDescription());
            }
        });
        theModalityColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<DicomStudyWrapper, String>, ObservableValue<String>>()
        {
            public ObservableValue<String> call(TableColumn.CellDataFeatures<DicomStudyWrapper, String> aFeatures)
            {
                return new ReadOnlyStringWrapper(aFeatures.getValue().getStudy().getModality());
            }
        });
        theFileCountColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<DicomStudyWrapper, Integer>, ObservableValue<Integer>>()
        {
            public ObservableValue call(TableColumn.CellDataFeatures<DicomStudyWrapper, Integer> aFeatures)
            {
                return IntegerConstant.valueOf(aFeatures.getValue().getStudy().getImageCount());
            }
        });
        theImportColumn.setCellValueFactory(new PropertyValueFactory<DicomStudyWrapper, Boolean>("selected"));
        theDicomStudyTable.setOnMouseClicked(new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent aEvent)
            {
                if (aEvent.getClickCount() > 1)
                {
                    DicomStudyWrapper myResult = theDicomStudyTable.getSelectionModel().getSelectedItem();
                    if (myResult != null)
                    {
                        DicomStudy myStudy = myResult.getStudy();
                        theMain.showStudy(getClientService().findDicomStudy(myStudy.getId()),
                                getClientService().findMergeHL7Messages(myStudy));
                    }
                }
            }
        });
        theStudyDateColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<DicomStudyWrapper, String>, ObservableValue<String>>()
        {
            public ObservableValue<String> call(TableColumn.CellDataFeatures<DicomStudyWrapper, String> aFeatures)
            {
                return new ReadOnlyStringWrapper(String.valueOf(DicomStudyTagValueFinder.getStudyDateToString(aFeatures.getValue()
                        .getStudy())));
            }
        });
        theInstitutionColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<DicomStudyWrapper, String>, ObservableValue<String>>()
        {
            public ObservableValue<String> call(TableColumn.CellDataFeatures<DicomStudyWrapper, String> aFeatures)
            {
                return new ReadOnlyStringWrapper(StringUtils.join(aFeatures.getValue().getStudy().getInstitutions(),
                        ", "));
            }
        });
        theTicketsColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<DicomStudyWrapper, String>, ObservableValue<String>>()
        {
            public ObservableValue<String> call(TableColumn.CellDataFeatures<DicomStudyWrapper, String> aFeatures)
            {
                return new ReadOnlyStringWrapper(with(aFeatures.getValue().getTicketIds()).join(","));
            }
        });
        theStudyDateColumn.setComparator(new StudyDateComparator());
        theImportColumn.setCellFactory(CheckBoxTableCell.forTableColumn(theImportColumn));
        theModality.setItems(EnumItems.fromEnum(Modality.values()));
        resetDateFields();
        theImportColumn.setEditable(true);
        theDicomStudyTable.setEditable(true);
        theDicomStudyTable.setItems(theStudies);
        theInstitution.setItems(theInstitutions);
        theGroup.setItems(theGroups);
        theTechType.selectedProperty().addListener(new ChangeListener<Boolean>()
        {
            @Override public void changed(ObservableValue<? extends Boolean> aObservableValue,
                                          Boolean aBoolean,
                                          Boolean aBoolean2)
            {
                Boolean myIsTechSelected = aObservableValue.getValue();
                theRTRTType.selectedProperty().setValue(false);
                theRTRCType.selectedProperty().setValue(false);
                theURType.selectedProperty().setValue(false);
                theRTRTType.setDisable(myIsTechSelected);
                theRTRCType.setDisable(myIsTechSelected);
                theURType.setDisable(myIsTechSelected);
            }
        });
        HBox.setHgrow(theProgressBox, Priority.ALWAYS);
        HBox.setHgrow(theButtonBox, Priority.ALWAYS);
        HBox.setHgrow(theTopSpacer, Priority.ALWAYS);
        onImageSearchReset();
    }

    @Override public void setClientService(ClientRestService aClientService)
    {
        super.setClientService(aClientService);

        setGroupsAndInstitutions();
    }

    private void setGroupsAndInstitutions()
    {
        Platform.runLater(new Runnable()
        {
            @Override public void run()
            {
                theGroups.clear();
                theInstitutions.clear();
                theGroups.addAll(getEntityCache().getGroups());
                theInstitutions.addAll(getEntityCache().getInstitutions());
                theIIR.setItems(getEntityCache().getPIRs());
            }
        });
    }

    @FXML
    private void onImageSearch()
    {
        cancelTaskIfRunning();
        theTask = new Task()
        {
            @Override protected Object call() throws Exception
            {
                theProgress.setVisible(true);
                Group myGroup = theGroup.getSelectionModel().getSelectedItem();
                Institution myInstitution = theInstitution.getSelectionModel().getSelectedItem();
                String myPatientLastName = thePatientLastName.getText();
                String myPatientFirstName = thePatientFirstName.getText();
                String myPatientMRN = thePatientMRN.getText();
                String myModality = theModality.getSelectionModel().getSelectedItem();
                String myStudyDescription = theStudyDescription.getText();
                String myAccessionNumber = theAccessionNumber.getText();
                String myIIR = theIIR.getSelectionModel().getSelectedItem();
                String mySiteTechnologist = theSiteTechnologist.getText();

                final DicomStudyQueryBuilder myBuilder = new DicomStudyQueryBuilder()
                        .setGroup(myGroup)
                        .setInstitutionAlias(myInstitution != null ? myInstitution.getAlias() : null)
                        .setPatientLastName(myPatientLastName)
                        .setPatientFirstName(myPatientFirstName)
                        .setPatientID(myPatientMRN)
                        .setStudyDescription(myStudyDescription)
                        .setAccessionNumber(myAccessionNumber)
                        .setIIR(myIIR)
                        .setSiteTechnologist(mySiteTechnologist);

                if (myModality != null)
                {
                    myBuilder.setModalities(Arrays.asList(myModality));
                }
                String myStudyDate = theStudyDate.getText();
                if (!StringUtils.isEmpty(myStudyDate))
                {
                    myBuilder.setStudyDate(myStudyDate);
                }

                final long myStartTime = System.currentTimeMillis();
                final List<DicomStudyQueryResult> myStudies = getClientService().findDicomStudies(myBuilder.build());
                final long myEndTime = System.currentTimeMillis();
                try
                {
                    Platform.runLater(new Runnable()
                    {
                        @Override public void run()
                        {
                            try
                            {
                                clearLists();
                                theStudies.addAll(wrap(myStudies));
                                long
                                        myTime =
                                        TimeUnit.SECONDS.convert(myEndTime - myStartTime, TimeUnit.MILLISECONDS);
                                theResultCountLabel.setText(myStudies.size() +
                                        " studies found in " +
                                        myTime +
                                        " seconds");
                            }
                            catch (Exception e)
                            {
                                LOGGER.error("Error adding studies to list");
                            }
                        }
                    });
                }
                catch (Exception e)
                {
                    LOGGER.error("Error getting HL7 messages");
                }
                theProgress.progressProperty().unbind();
                theProgress.setVisible(false);
                return theStudies;
            }
        };

        theProgress.progressProperty().bind(theTask.progressProperty());
        theService.execute(theTask);
    }

    private void cancelTaskIfRunning()
    {
        if (theTask != null && theTask.isRunning())
        {
            theTask.cancel();
        }
    }

    private List<DicomStudyWrapper> wrap(List<DicomStudyQueryResult> aStudies)
    {
        List<DicomStudyWrapper> myWrappers = new ArrayList<>();
        for (DicomStudyQueryResult myStudy : aStudies)
        {
            myWrappers.add(new DicomStudyWrapper(myStudy));
        }
        return myWrappers;
    }

    @FXML
    private void onImageSearchReset()
    {
        clearLists();
        theGroup.getSelectionModel().clearSelection();
        theInstitution.getSelectionModel().clearSelection();
        thePatientLastName.clear();
        thePatientFirstName.clear();
        thePatientMRN.clear();
        theModality.getSelectionModel().clearSelection();
        theStudyDescription.clear();
        theAccessionNumber.clear();
        theIIR.getSelectionModel().clearSelection();
        theSiteTechnologist.clear();
        theResultCountLabel.setText(null);
        resetTicketCreateOptions();
        resetDateFields();
        setGroupsAndInstitutions();
    }

    private void resetTicketCreateOptions()
    {
        theRTRTType.selectedProperty().setValue(false);
        theRTRCType.selectedProperty().setValue(false);
        theURType.selectedProperty().setValue(false);
        theTRType.selectedProperty().setValue(false);
        theRRType.selectedProperty().setValue(false);
        theProfessionalType.selectedProperty().setValue(false);
        theTechType.selectedProperty().setValue(false);
        theSubmittedVariance.selectedProperty().setValue(false);
    }

    @FXML
    private void onNewTicketSubmit()
    {
        Toggle myToggle = theReviewType.getSelectedToggle();
        boolean myProfessionalReview = theProfessionalType.isSelected();
        boolean myTechReview = theTechType.isSelected();
        Iterable<DicomStudyWrapper> mySelectedStudies = getSelectedStudies();

        if (Iterables.isEmpty(mySelectedStudies) || (!myProfessionalReview && !myTechReview) || myToggle == null)
        {
            List<String> myErrors = Lists.newArrayList();
            if (Iterables.isEmpty(mySelectedStudies))
            {
                myErrors.add("No studies selected");
            }

            if (!myProfessionalReview && !myTechReview)
            {
                myErrors.add("Ticket type not selected");
            }

            if (myToggle == null)
            {
                myErrors.add("Ticket priority not selected");
            }

            String myError = with(myErrors).join(", ");
            MonologFXButton mlb = MonologFXButtonBuilder.create()
                    .defaultButton(true)
                    .type(MonologFXButton.Type.OK)
                    .build();

            MonologFXBuilder.create()
                    .modal(true)
                    .type(MonologFX.Type.ERROR)
                    .message("Please fill in fields : " + myError)
                    .titleText("Missing input")
                    .button(mlb)
                    .buttonAlignment(MonologFX.ButtonAlignment.RIGHT)
                    .build().showDialog();

            return;
        }

        List<CreateTicketRequest> myRequests = new ArrayList<>();
        TicketPriority myTicketPriority = TicketPriority.valueOf(((RadioButton) myToggle).getText());
        List<TicketType> myRequestedTypes = new ArrayList<>();
        if (myProfessionalReview)
        {
            myRequestedTypes.add(TicketType.PR);
        }
        if (myTechReview)
        {
            myRequestedTypes.add(TicketType.TR);
        }
        for (DicomStudyWrapper mySelectedStudy : mySelectedStudies)
        {
            myRequests.add(new CreateTicketRequest(mySelectedStudy.getStudy().getId(),
                    myTicketPriority,
                    myRequestedTypes,
                    theSubmittedVariance.isSelected(),
                    mySelectedStudy.getTicketIds(),
                    mySelectedStudy.getTicketTypes()));
        }
        String myTickets = getClientService().createProfessionalTickets(new CreateTicketRequests(myRequests, theUser));

        resetTicketCreateOptions();
        onImageSearch();
        MonologFXButton mlb = MonologFXButtonBuilder.create()
                .defaultButton(true)
                .type(MonologFXButton.Type.OK)
                .build();

        MonologFXBuilder.create()
                .modal(true)
                .type(MonologFX.Type.INFO)
                .message("Added " + (!myTickets.isEmpty() ? myTickets : "no") + " tickets for studies")
                .titleText("Tickets Added")
                .button(mlb)
                .buttonAlignment(MonologFX.ButtonAlignment.RIGHT)
                .build().showDialog();

    }

    @FXML
    public void onUpload()
    {
        StringBuilder myReportBuilder = new StringBuilder("Upload report : ").append("\n\n");
        Stage myStage = theMain.getPrimaryStage();
        DirectoryChooser myChooser = new DirectoryChooser();
        myChooser.setTitle("Choose Image Folder");
        File myDirectory = myChooser.showDialog(myStage);
        try
        {
            Collection<File> myFiles = FileUtils.listFiles(myDirectory, null, true);
            Collection<DicomImage> myImages = Lists.newArrayList();
            for (File myFile : myFiles)
            {
                myReportBuilder.append(myFile.getAbsolutePath()).append("\n");
                try
                {
                    DicomParser myParser = new DicomParser();
                    DicomImage myImage = myParser.parse(myFile);
                    if (myImage != null)
                    {
                        myReportBuilder.append("Patient mame : ")
                                .append(myImage.getPatientName())
                                .append("\n")
                                .append(" StudyInstanceUID : ")
                                .append(myImage.getSeriesInstanceUID())
                                .append("\n")
                                .append(" Tags : ")
                                .append(myImage.getTags().size())
                                .append("\n\n");
                        myImages.add(myImage);
                    }
                    else
                    {
                        myReportBuilder.append("File could not be parsed").append("\n");
                    }
                }
                catch (Exception e)
                {
                    myReportBuilder.append(e.getMessage()).append("\n");
                    LOGGER.error("Error parsing dicom image " + myFile.getPath(), e);
                }
            }

            myReportBuilder.append("\n\n").append("Studies : ").append("\n\n");
            if (!myImages.isEmpty())
            {
                List<DicomStudy> myDicomStudies = toStudies(myImages);
                for (DicomStudy myDicomStudy : myDicomStudies)
                {
                    if (myDicomStudy.getTags() != null && !myDicomStudy.getTags().isEmpty())
                    {
                        myReportBuilder.append("Created study with StudyInstanceUID : ")
                                .append(myDicomStudy.getStudyInstanceUID())
                                .append(" with ")
                                .append(myDicomStudy.getImageCount())
                                .append(" images")
                                .append("\n");
                        List<DicomStudy> myStudies =
                                getClientService().findDicomStudiesByStudyInstanceUID(myDicomStudy.getStudyInstanceUID());
                        if (!myStudies.isEmpty())
                        {
                            updateExistingStudy(myDicomStudy, myStudies);
                        }
                        else
                        {
                            getClientService().createOrUpdateDicomStudy(myDicomStudy);
                        }
                    }
                    else
                    {
                        myReportBuilder.append("Study with StudyInstanceUID :")
                                .append(myDicomStudy.getStudyInstanceUID())
                                .append(" contains no tags and was not persisted")
                                .append("\n");
                        LOGGER.error("Dicom study has no tags, skipping");
                    }
                }
            }
        }
        catch (Exception aException)
        {
            String myErrorStr = "Error parsing images";
            myReportBuilder.append(myErrorStr).append(" : ").append(aException.getMessage()).append("\n");
            LOGGER.error(myErrorStr, aException);
        }

        theMain.showReport(myReportBuilder.toString());
    }

    private void updateExistingStudy(DicomStudy aStudy, List<DicomStudy> aStudies)
    {
        for (DicomStudy myStudy : aStudies)
        {
            LOGGER.info("Updating study with UID {}", myStudy.getStudyInstanceUID());
            if (aStudy.getTags().size() != myStudy.getTags().size())
            {
                myStudy.setTags(getUniqueTags(aStudy, myStudy));
            }
            Set<String> mySeriesInstanceUIDs = aStudy.getSeriesInstanceUIDs();
            if (!myStudy.getSeriesInstanceUIDs().containsAll(mySeriesInstanceUIDs))
            {
                myStudy.setSeriesInstanceUIDs(Sets.symmetricDifference(mySeriesInstanceUIDs,
                        myStudy.getSeriesInstanceUIDs()));
                myStudy.setImageCount(myStudy.getImageCount() + aStudy.getImageCount());
            }
            getClientService().createOrUpdateDicomStudy(myStudy);
        }
    }

    private Sets.SetView<DicomTag> getUniqueTags(DicomStudy aExistingStudy, DicomStudy myStudy)
    {
        return Sets.symmetricDifference(Sets.newHashSet(aExistingStudy.getTags()), Sets.newHashSet(myStudy.getTags()));
    }

    private List<DicomStudy> toStudies(Collection<DicomImage> aImages)
    {
        List<DicomStudy> myStudies = Lists.newArrayList();
        Multimap<String, DicomImage> myImages = HashMultimap.create();

        for (DicomImage myImage : aImages)
        {
            String myStudyInstanceUID = myImage.getStudyInstanceUID();
            if (myImage.getTags().size() > 1 && myStudyInstanceUID != null)
            {
                myImages.put(myStudyInstanceUID, myImage);
            }
            else
            {
                LOGGER.error("No StudyInstanceUID tag found for image for patient : " + myImage.getPatientName());
            }
        }

        for (String myStudyId : myImages.keySet())
        {
            DicomStudy myStudy = new DicomStudy();
            myStudy.setImages(myImages.get(myStudyId));
            myStudies.add(myStudy);
        }

        return myStudies;
    }

    @FXML
    private void onView()
    {
        DicomStudy myStudy = theDicomStudyTable.getSelectionModel().getSelectedItem().getStudy();
        if (myStudy != null)
        {
            theMain.showViewer(myStudy);
        }
    }

    private Iterable<DicomStudyWrapper> getSelectedStudies()
    {
        return Iterables.filter(theDicomStudyTable.getItems(), new Predicate<DicomStudyWrapper>()
        {
            @Override public boolean apply(DicomStudyWrapper aStudy)
            {
                return aStudy.getSelected();
            }
        });
    }

    private void clearLists()
    {
        theDicomStudyTable.getItems().clear();
    }

    private void resetDateFields()
    {
        theStudyDate.clear();
    }

    public class DicomStudyWrapper
    {
        private final DicomStudy theStudy;
        private final List<String> theTicketIds;
        private final List<TicketType> theTicketTypes;
        private BooleanProperty theSelected;

        public DicomStudyWrapper(DicomStudyQueryResult aQueryResult)
        {
            theStudy = aQueryResult.getStudy();
            theTicketIds = aQueryResult.getTickets();
            theTicketTypes = aQueryResult.getTicketTypes();
            theSelected = new SimpleBooleanProperty();
        }

        public DicomStudy getStudy()
        {
            return theStudy;
        }

        public boolean getSelected()
        {
            return theSelected.get();
        }

        public BooleanProperty selectedProperty()
        {
            return theSelected;
        }

        public void setSelected(boolean aSelected)
        {
            theSelected.set(aSelected);
        }

        public List<TicketType> getTicketTypes()
        {
            return theTicketTypes;
        }

        public List<String> getTicketIds()
        {
            return theTicketIds;
        }
    }
}
