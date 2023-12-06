package web;

import com.peirs.datamodel.*;
import com.peirs.datamodel.dicom.*;
import com.peirs.datamodel.ticket.*;
import com.vaadin.data.*;
import com.vaadin.data.util.*;
import com.vaadin.ui.*;
import org.dcm4che2.data.*;
import org.jetbrains.annotations.*;

import java.util.*;

import static com.cqap.util.DicomStudyTagValueFinder.*;
import static web.ComponentFactory.*;

public class StudyDetailsView extends CssLayout
{
    private final User user;
    private final ComboBox institution;
    private final TextField institutionReadOnly;
    private final TextField submittedDate;
    private final TextField timeZone;
    private final TextField submittedBy;
    private final TextField patientName;
    private final TextField patientMRN;
    private final TextField patientDOB;
    private final TextField patientAge;
    private final TextField patientSex;
    private final TextField admittingDate;
    private final TextField admittingDiagnosisCode;
    private final TextField admittingDiagnosisDescription;
    private final TextField modality;
    private final TextField studyDescription;
    private final TextField accessionNumber;
    private final TextField studyDate;
    private final TextField cptCode;
    private final TextField sliceCount;
    private final TextField sliceThickness;
    private final TextField scanLength;
    private final TextField ctdiVolume;
    private final TextField manufacturer;
    private final TextField manufacturerModelName;
    private final TextArea patientHistory;
    private final TextField physicianName;
    private final TextField physicianPhone;
    private final TextField physicianAddress;
    private final TextField physicianSequenceID;
    private final TextField primaryInterpretingRadiologist;

    public StudyDetailsView(@NotNull User user, @Nullable Container institutionContainer)
    {
        this.user = user;
        institution = createFormComboBoxField("Institution");
        institutionReadOnly = createFormTextField("Institution");
        submittedDate = createFormTextField("Submitted Date");
        timeZone = createFormTextField("Timezone");
        submittedBy = createFormTextField("Submitted By");
        patientName = createFormTextField("Name");
        patientMRN = createFormTextField("MRN");
        patientDOB = createFormTextField("DOB");
        patientAge = createFormTextField("Age");
        patientSex = createFormTextField("Sex");
        admittingDate = createFormTextField("Admitting Date");
        admittingDiagnosisCode = createFormTextField("Diagnosis Code");
        admittingDiagnosisDescription = createFormTextField("Diagnosis Desc");
        modality = createFormTextField("Modality");
        studyDescription = createFormTextField("Exam Description");
        accessionNumber = createFormTextField("Accession");
        studyDate = createFormTextField("Exam Date");
        cptCode = createFormTextField("CPT Code");
        sliceCount = createFormTextField("Slice Count");
        sliceThickness = createFormTextField("Slice Thickness");
        scanLength = createFormTextField("Scan Length");
        ctdiVolume = createFormTextField("CTDI Volume");
        manufacturer = createFormTextField("Manufacturer");
        manufacturerModelName = createFormTextField("Model");
        patientHistory = createFormTextArea("History");
        physicianName = createFormTextField("Referring Physician");
        physicianPhone = createFormTextField("Phone");
        physicianAddress = createFormTextField("Address");
        physicianSequenceID = createFormTextField("ID Sequence");
        primaryInterpretingRadiologist = createFormTextField("PIR");

        if (institutionContainer != null)
        {
            institution.setContainerDataSource(institutionContainer);
        }

        initLayout();
    }

    private void initLayout()
    {
        setSizeFull();

        patientHistory.addStyleName("report");
        timeZone.setNullRepresentation("N/A");
        patientDOB.setNullRepresentation("N/A");
        patientAge.setNullRepresentation("N/A");
        patientSex.setNullRepresentation("N/A");
        submittedDate.setNullRepresentation("N/A");
        submittedBy.setNullRepresentation("N/A");
        admittingDate.setNullRepresentation("N/A");
        admittingDiagnosisCode.setNullRepresentation("N/A");
        admittingDiagnosisDescription.setNullRepresentation("N/A");
        scanLength.setNullRepresentation("N/A");
        ctdiVolume.setNullRepresentation("N/A");
        sliceCount.setNullRepresentation("N/A");
        sliceThickness.setNullRepresentation("N/A");
        manufacturer.setNullRepresentation("N/A");
        manufacturerModelName.setNullRepresentation("N/A");
        physicianName.setNullRepresentation("N/A");
        physicianPhone.setNullRepresentation("N/A");
        physicianAddress.setNullRepresentation("N/A");
        physicianSequenceID.setNullRepresentation("N/A");
        primaryInterpretingRadiologist.setNullRepresentation("N/A");
        studyDate.setNullRepresentation("N/A");
        patientName.setNullRepresentation("N/A");
        patientMRN.setNullRepresentation("N/A");
        patientHistory.setNullRepresentation("N/A");
        accessionNumber.setNullRepresentation("N/A");
        modality.setNullRepresentation("N/A");
        studyDescription.setNullRepresentation("N/A");


        VerticalLayout column1 = fullWidthVerticalLayout(fullWidthHorizontalLayout(patientName, patientMRN),
                fullWidthHorizontalLayout(patientDOB, patientAge, patientSex),
                patientHistory);
        VerticalLayout
                column2 =
                fullWidthVerticalLayout(institution.getContainerDataSource() != null ?
                        institution :
                        institutionReadOnly,
                        fullWidthHorizontalLayout(timeZone, admittingDate),
                        fullWidthHorizontalLayout(submittedDate, submittedBy),
                        fullWidthHorizontalLayout(admittingDiagnosisCode, admittingDiagnosisDescription));
        VerticalLayout
                column3 =
                fullWidthVerticalLayout(fullWidthHorizontalLayout(studyDate, accessionNumber),
                        fullWidthHorizontalLayout(modality, studyDescription),
                        fullWidthHorizontalLayout(scanLength, ctdiVolume),
                        fullWidthHorizontalLayout(sliceCount, sliceThickness),
                        fullWidthHorizontalLayout(manufacturer, manufacturerModelName));

        VerticalLayout column4 = fullWidthVerticalLayout(physicianName,
                physicianPhone,
                physicianAddress,
                physicianSequenceID,
                primaryInterpretingRadiologist);

        column1.setMargin(true);
        column2.setMargin(true);
        column3.setMargin(true);
        column4.setMargin(true);
        Panel ticketDetailsPanel = new Panel("Patient", column1);
        Panel patientDetailsPanel = new Panel("Institution", column2);
        Panel studyDetailsPanel = new Panel("Exam", column3);
        Panel pirPanel = new Panel("Referring/PIR", column4);
        addComponent(fullWidthHorizontalLayout(ticketDetailsPanel, patientDetailsPanel, studyDetailsPanel, pirPanel));
    }

    public void setDetails(@NotNull final DicomStudy study, @Nullable ProfessionalTicket ticket)
    {
        if (study.getStudyInstitution() != null)
        {
            institution.select(study.getStudyInstitution().getName());
        }
        institutionReadOnly.setPropertyDataSource(new NestedMethodProperty(study, "studyInstitution.name"));
        timeZone.setPropertyDataSource(new NestedMethodProperty(study, "studyInstitution.address.timeZone"));
        patientName.setPropertyDataSource(new MethodProperty(study, "patientName"));
        patientMRN.setPropertyDataSource(new MethodProperty(study, "patientID"));
        modality.setPropertyDataSource(new MethodProperty(study, "modality"));
        studyDescription.setPropertyDataSource(new MethodProperty(study, "studyDescription"));
        accessionNumber.setPropertyDataSource(new MethodProperty(study, "accessionNumber"));;
        patientDOB.setValue(getDOB(study));
        patientAge.setValue(calculateAge(study));
        patientSex.setValue(study.getPatientSex());
        admittingDate.setValue(findValue(study, Tag.AdmittingDate));
        admittingDiagnosisCode.setValue(findValue(study, Tag.AdmittingDiagnosesCodeSequence));
        admittingDiagnosisDescription.setValue(findValue(study, Tag.AdmittingDiagnosesDescription));
        studyDate.setValue(getStudyDateToString(study));
//        imageCount.setText(findValue(study, Tag.NumberOfSlices));
        sliceThickness.setValue(findValue(study, Tag.SliceThickness));
        scanLength.setValue(findValue(study, Tag.ScanLength));
        ctdiVolume.setValue(findValue(study, Tag.CTDIvol));
        manufacturer.setValue(findValue(study, Tag.Manufacturer));
        manufacturerModelName.setValue(findValue(study, Tag.ManufacturerModelName));


        if (ticket != null)
        {
            submittedDate.setValue(new Date(ticket.getSubmittedTime()).toString());
            if (ticket.getSubmittedUser() != null)
            {
                submittedBy.setValue(ticket.getSubmittedUser().getName());
            }
        }
        else
        {
            submittedBy.setVisible(false);
            submittedDate.setVisible(false);
        }

        physicianName.setValue(findValue(study, Tag.ReferringPhysicianName));
        physicianAddress.setValue(findValue(study, Tag.ReferringPhysicianAddress));
        physicianPhone.setValue(findValue(study, Tag.ReferringPhysicianTelephoneNumbers));
        physicianSequenceID.setValue(findValue(study, Tag.ReferringPhysicianIdentificationSequence));

        String pirValue = findValue(study, Tag.InterpretationAuthor);
        if (pirValue != null)
        {
            primaryInterpretingRadiologist.setValue(pirValue);
        }

        setPatientHistory(study);
        setFieldPermissions(study, ticket);

        institution.addValueChangeListener(new Property.ValueChangeListener()
        {
            @Override public void valueChange(Property.ValueChangeEvent event)
            {
                Object value = institution.getValue();
                if (value != null)
                {
                    Item item = institution.getContainerDataSource().getItem(value);
                    if (item != null)
                    {
                        Institution
                                selectedInstitution =
                                ((BeanItem<Institution>) item).getBean();
                        if (selectedInstitution != null)
                        {
                            study.setStudyInstitution(selectedInstitution);
                            if (selectedInstitution.getAddress() != null)
                            {
                                timeZone.setValue(selectedInstitution.getAddress().getTimeZone());
                            }
                        }
                    }
                }
            }
        });
    }

    private void setFieldPermissions(@NotNull final DicomStudy study, @Nullable ProfessionalTicket ticket)
    {
        timeZone.setReadOnly(true);
        patientDOB.setReadOnly(true);
        patientAge.setReadOnly(true);
        patientSex.setReadOnly(true);
        submittedDate.setReadOnly(true);
        submittedBy.setReadOnly(true);
        admittingDate.setReadOnly(true);
        admittingDiagnosisCode.setReadOnly(true);
        admittingDiagnosisDescription.setReadOnly(true);
        scanLength.setReadOnly(true);
        ctdiVolume.setReadOnly(true);
        sliceCount.setReadOnly(true);
        sliceThickness.setReadOnly(true);
        manufacturer.setReadOnly(true);
        manufacturerModelName.setReadOnly(true);
        physicianName.setReadOnly(true);
        physicianPhone.setReadOnly(true);
        physicianAddress.setReadOnly(true);
        physicianSequenceID.setReadOnly(true);
        primaryInterpretingRadiologist.setReadOnly(true);
        studyDate.setReadOnly(true);

        if (user.getRole() != Role.QAD)
        {
            setEditableFieldsToReadOnly();
        }

        if (ticket != null &&
                (ticket.getStatus() == TicketStatus.COMPLETED || ticket.getStatus() == TicketStatus.TECH_COMPLETED))
        {
            setEditableFieldsToReadOnly();
        }
    }

    private void setEditableFieldsToReadOnly()
    {
        patientName.setReadOnly(true);
        patientMRN.setReadOnly(true);
        patientHistory.setReadOnly(true);
        accessionNumber.setReadOnly(true);
        modality.setReadOnly(true);
        studyDescription.setReadOnly(true);
        institution.setReadOnly(true);
    }

    private void setPatientHistory(DicomStudy study)
    {
        if (study.getPatientHistory() == null)
        {
            String myAdditionalPatientHistory = findValue(study, Tag.AdditionalPatientHistory);
            String myReasonForStudy = findValue(study, Tag.ReasonForStudy);
            String
                    myHistory =
                    myAdditionalPatientHistory.contains("N/A") ? myReasonForStudy : myAdditionalPatientHistory;
            study.setPatientHistory(myHistory);
        }

        patientHistory.setPropertyDataSource(new MethodProperty(study, "patientHistory"));
    }
}
