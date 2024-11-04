package com.capstone.fx.controllers;


import com.capstone.fx.model.*;
import com.capstone.fx.utils.*;
import com.cqap.util.*;
import com.google.common.base.*;
import com.google.common.collect.*;
import com.peirs.datamodel.*;
import com.peirs.datamodel.dicom.*;
import com.peirs.datamodel.hl7.*;
import javafx.beans.property.*;
import javafx.beans.value.*;
import javafx.collections.*;
import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.*;
import javafx.util.*;
import org.dcm4che2.data.*;
import org.slf4j.*;

import java.io.*;
import java.util.*;

import static ch.lambdaj.collection.LambdaCollections.*;
import static com.cqap.util.DicomStudyTagValueFinder.*;

public class EditStudyController extends BaseController
{
    private static final Logger LOGGER = LoggerFactory.getLogger(EditStudyController.class);
    protected final ObservableList<Institution> theInstitutions;
    protected final ObservableList<DicomTag> theTags;
    protected final ObservableList<DicomTag> theFilteredTags;
    protected final ObservableList<HL7> theHL7Messages;
    @FXML protected Label theInstitution;
    @FXML protected ComboBox<Institution> theSelectedInstitution;
    @FXML protected Label theTimeZone;
    @FXML protected Label theSubmittedDate;
    @FXML protected TextField thePatientName;
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
    @FXML protected Label theReferringPhysicianName;
    @FXML protected Label theReferringPhysicianPhone;
    @FXML protected Label theReferringPhysicianAddress;
    @FXML protected Label theReferringPhysicianID;
    @FXML protected TextArea thePatientReport;
    @FXML protected TableView<DicomTag> theReportFindingsTable;
    @FXML protected TableColumn<DicomTag, String> theFieldColumn;
    @FXML protected TableColumn<DicomTag, String> theValueColumn;
    @FXML protected TextField theFilterField;
    @FXML private HBox theSpacer;
    @FXML private ListView<HL7> theHL7MessagesList;
    @FXML private TextArea theHl7MessageDisplay;
    private DicomStudy theStudy;

    public EditStudyController()
    {
        theInstitutions = FXCollections.observableArrayList();
        theTags = FXCollections.observableArrayList();
        theFilteredTags = FXCollections.observableArrayList();
        theHL7Messages = FXCollections.observableArrayList();
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
        theReportFindingsTable.setItems(theFilteredTags);
        theHL7MessagesList.setItems(theHL7Messages);
        theHL7MessagesList.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<HL7>()
        {
            @Override public void changed(ObservableValue<? extends HL7> aObservableValue,
                                          HL7 aAttachment,
                                          HL7 aAttachment2)
            {
                if (aObservableValue != null && aObservableValue.getValue() != null)
                {
                    theHl7MessageDisplay.setText(aObservableValue.getValue().getMergeHL7Message());
                }
            }
        });
        theSelectedInstitution.setItems(theInstitutions);
        HBox.setHgrow(theSpacer, Priority.ALWAYS);
    }

    @Override public void setEntityCache(EntityCache aEntityCache)
    {
        super.setEntityCache(aEntityCache);

        theInstitutions.addAll(aEntityCache.getInstitutions());
    }

    public void display(DicomStudy aStudy, Collection<HL7> aHL7s)
    {
        theStudy = aStudy;
        Collection<String> myInstitutions = theStudy.getInstitutions();
        theInstitution.setText(with(myInstitutions).join("; "));
        String myPatientName = theStudy.getPatientName().replaceAll("^", "");
        thePatientName.setText(myPatientName);
        thePatientMRN.setText(theStudy.getPatientID());
        thePatientDOB.setText(getDOB(theStudy));
        thePatientAge.setText(getAge(theStudy));
        theAdmittingDate.setText(findValue(theStudy, Tag.AdmittingDate));
        theAdmittingDiagnosisCode.setText(findValue(theStudy, Tag.AdmittingDiagnosesCodeSequence));
        theAdmittingDiagnosisDescription.setText(findValue(theStudy, Tag.AdmittingDiagnosesDescription));
        theModality.setText(theStudy.getModality());
        theStudyDescription.setText(theStudy.getStudyDescription());
        theAccessionNumber.setText(theStudy.getAccessionNumber());
        theStudyDate.setText(getStudyDateToString(theStudy));
        theImageCount.setText(findValue(theStudy, Tag.NumberOfSlices));
        theSliceThickness.setText(findValue(theStudy, Tag.SliceThickness));
        theScanLength.setText(findValue(theStudy, Tag.ScanLength));
        theCTDIVolume.setText(findValue(theStudy, Tag.CTDIvol));
        theManufacturer.setText(findValue(theStudy, Tag.Manufacturer));
        theManufacturerModel.setText(findValue(theStudy, Tag.ManufacturerModelName));
        theReferringPhysicianName.setText(findValue(theStudy, Tag.ReferringPhysicianName));
        theReferringPhysicianID.setText(findValue(theStudy, Tag.ReferringPhysicianIdentificationSequence));
        theReferringPhysicianAddress.setText(findValue(theStudy, Tag.ReferringPhysicianAddress));
        theReferringPhysicianPhone.setText(findValue(theStudy, Tag.ReferringPhysicianTelephoneNumbers));
        theReportFindingsTable.setItems(theFilteredTags);
        thePatientReport.setText(aStudy.getPatientReport());
        theTags.addAll(Collections2.filter(theStudy.getTags(), new Predicate<DicomTag>()
        {
            @Override public boolean apply(DicomTag aDicomTag)
            {
                return !aDicomTag.getDicomTagName().contains("?");
            }
        }));
        theHL7Messages.addAll(aHL7s);
        Institution myInstitution = null;
        if (aStudy.getInstitution() != null)
        {
            myInstitution = aStudy.getInstitution();
        }
        else
        {
            myInstitution = InstitutionFinder.findInstitution(aStudy.getInstitutions(), aHL7s,
                    getEntityCache().getInstitutions());
        }
        theSelectedInstitution.getSelectionModel().select(myInstitution);
    }

    @FXML
    private void onSave()
    {
        theStudy.setPatientName(thePatientName.getText().trim());
        theStudy.setPatientReport(thePatientReport.getText() != null ? thePatientReport.getText().trim() : null);
        theStudy.setInstitution(theSelectedInstitution.getSelectionModel().getSelectedItem());
        getClientService().createOrUpdateDicomStudy(theStudy);
        close();
    }

    @FXML
    private void onCancel()
    {
        close();
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
                String myReport = getClientService().addDicomStudyPatientReport(theStudy, myFile);
                thePatientReport.setText(myReport);
            }
        }
        catch (Exception aException)
        {
            LOGGER.error("Error uploading attachments", aException);
        }
    }

    private void close()
    {
        theMain.closeTicket();
    }
}
