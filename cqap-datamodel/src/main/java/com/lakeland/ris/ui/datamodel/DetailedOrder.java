package com.lakeland.ris.ui.datamodel;

import org.codehaus.jackson.annotate.*;
import org.jetbrains.annotations.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;
import java.util.*;

public class DetailedOrder
{
    @NotNull private String orderId;
    @NotNull private OrderStatus status;
    @NotNull private OrderPriority orderPriority;
    @NotNull private String assignedTo;
    @Nullable private String dicomStudyId;
    @Nullable private String patientFirstName;
    @Nullable private String patientMiddleName;
    @Nullable private String patientLastName;
    @Nullable private String patientId;
    @Nullable private Date patientBirthDate;
    @Nullable private String patientAge;
    @Nullable private String patientSex;
    @Nullable private String patientSuffix;
    @Nullable private String alternatePatientId;
    @Nullable private String patientAccountNumber;
    @Nullable private String patientAddressee;
    @Nullable private String patientAddressType;
    @Nullable private String patientStreetAddress;
    @Nullable private String patientStreetName;
    @Nullable private String patientAddressBuildingNumber;
    @Nullable private String patientAddressCity;
    @Nullable private String patientAddressState;
    @Nullable private String patientAddressCounty;
    @Nullable private String patientAddressZipcode;
    @Nullable private String patientAddressCountry;
    @Nullable private String patientAliasLastName;
    @Nullable private String patientAliasFirstName;
    @Nullable private String patientAliasMiddleName;
    @Nullable private String patientAlias;
    @Nullable private String patientSSN;
    @Nullable private String patientRace;
    @Nullable private String patientCitizenship;
    @Nullable private String maritalStatus;
    @Nullable private String patientEmail;
    @Nullable private String patientHomePhone;
    @Nullable private String patientWorkPhone;
    @Nullable private String patientFax;
    @Nullable private String patientMobile;
    @Nullable private String patientOtherPhone;
    @Nullable private String patientNotificationPreference;
    @Nullable private String patientEmployer;
    @Nullable private String patientEmployerStatus;
    @Nullable private String patientEmployerPhone;
    @Nullable private String patientStudentStatus;
    @Nullable private String patientSchool;
    @Nullable private String patientNoticeOfPrivacy;
    @Nullable private Date patientDateOfPrivacy;
    @Nullable private Date patientDateOfDeath;
    @Nullable private String patientCauseOfDeath;
    @Nullable private String patientEmergencyContactName;
    @Nullable private String patientEmergencyContactPhone;
    @Nullable private String patientPreferredLanguage;
    @Nullable private String patientSmokingStatus;
    @Nullable private String patientEthnicity;
    @Nullable private String patientBirthState;
    @Nullable private String patientBirthCountry;
    @Nullable private String patientBirthOrder;
    @Nullable private String patientMothersLastName;
    @Nullable private String patientMothersFirstName;
    @Nullable private String patientMothersMiddleName;
    @Nullable private String patientMothersMaidenName;
    @Nullable private String institutionName;
    @Nullable private String accessionNumber;
    @Nullable private String cPTCode;
    @Nullable private String cPTMnemonic;
    @Nullable private String modality;
    @Nullable private String studyDescription;
    @Nullable private String pregnant;
    @Nullable private String vipIndicator;
    @Nullable private Date admitDate;
    @Nullable private String admissionType;
    @Nullable private String patientLocationBed;
    @Nullable private String patientLocationBuilding;
    @Nullable private String patientLocationFacility;
    @Nullable private String patientLocationFloor;
    @Nullable private String patientLocationDescription;
    @Nullable private String patientLocationAssigningAuthority;
    @Nullable private String patientLocationComprehensiveDescription;
    @Nullable private String patientLocationStatus;
    @Nullable private String patientLocationType;
    @Nullable private String patientStation;
    @Nullable private String patientClass;
    @Nullable private String referringDoctorLastName;
    @Nullable private String referringDoctorFirstName;
    @Nullable private String referringDoctorDegree;
    @Nullable private String referringDoctorFullName;
    @Nullable private String orderingDoctorLastName;
    @Nullable private String orderingDoctorFirstName;
    @Nullable private String orderingDoctorDegree;
    @Nullable private String orderingDoctorFullName;
    @Nullable private String orderNumber;
    @Nullable private String sendingFacility;
    @Nullable private String techName;
    @Nullable private String authorizationNumber;
    @Nullable private String numberOfFilms;
    @Nullable private String filmType;
    @Nullable private Date effectiveDate;
    @Nullable private String findings;
    @Nullable private String approvalDate;
    @Nullable private String deliveryDate;
    @Nullable private String modifiers;
    @Nullable private String diagnosisCode;
    @Nullable private String reportId;
    @Nullable private String hl7;
    @Nullable private String coPayAmount;
    @Nullable private String feeAmount;
    @Nullable private String allowableAmount;
    @Nullable private String visitNumber;
    @Nullable private String deductibleAmount;
    @Nullable private String loggedAmount;
    @Nullable private String cardChequeNumber;
    @Nullable private String externalVisitId;
    @Nullable private String paymentMethod;
    @Nullable private Date expiryDate;
    @Nullable private String hospitalService;
    @Nullable private String procedureStartDate;
    @Nullable private String reasonForExam;
    @Nullable private String priority;
    @Nullable private String procedureCode;
    @Nullable private String procedureCodeScheme;
    @Nullable private String orderStatus;
    @Nullable private String laterality;
    @Nullable private String principalResultInterpreter;
    @Nullable private String responsibleObserver;
    @Nullable private String relevantClinicalInformation;
    @Nullable private Collection<Physician> physicians;
    @Nullable private String followUpCode;
    @Nullable private String guarantorName;
    @Nullable private String guarantorAddress;
    @Nullable private String guarantorPhone;
    @Nullable private Date guarantorDOB;
    @Nullable private String serviceType;
    @Nullable private Date dateOfService;
    @Nullable private String transportType;
    @Nullable private String inpatientLocation;
    @Nullable private String room;
    private boolean iV;
    private boolean o2;
    private boolean monitor;
    @Nullable private Date dischargeDate;
    @Nullable private String insuredName;
    @Nullable private String relationship;
    private boolean releaseSigned;
    @Nullable private String coPay;
    @Nullable private String deductible;
    @Nullable private Date dateSigned;
    @Nullable private String coInsurance;
    @Nullable private Collection<PatientInsurance> patientInsurances;
    @Nullable private Collection<VisitInsurance> visitInsurances;
    @Nullable private Collection<Allergy> allergies;
    @Nullable private Collection<Referral> referrals;
    @Nullable private Collection<Medication> medications;
    @Nullable private OrderReport report;
    @Nullable private String updatedBy;
    @Nullable private Date updateTime;
    @Nullable private String techNotes;
    private boolean critical;
    @Nullable private String studyDate;
    @Nullable private String studyTime;
    @Nullable private String arrivalDate;
    @Nullable private String arrivalTime;
    @Nullable private String additionalAccessions;
    @Nullable private UrgentExamType urgentExamType;
    @Nullable private String readingRadiologist;

    public DetailedOrder()
    {
        // empty
    }

    @JsonCreator
    public DetailedOrder(@NotNull String orderId,
                         @NotNull OrderStatus status,
                         @NotNull OrderPriority orderPriority,
                         @NotNull String assignedTo,
                         @Nullable String dicomStudyId,
                         @Nullable String patientFirstName,
                         @Nullable String patientMiddleName,
                         @Nullable String patientLastName,
                         @Nullable String patientId,
                         @Nullable Date patientBirthDate,
                         @Nullable String patientAge,
                         @Nullable String patientSex,
                         @Nullable String patientSuffix,
                         @Nullable String alternatePatientId,
                         @Nullable String patientAccountNumber,
                         @Nullable String patientAddressee,
                         @Nullable String patientAddressType,
                         @Nullable String patientStreetAddress,
                         @Nullable String patientStreetName,
                         @Nullable String patientAddressBuildingNumber,
                         @Nullable String patientAddressCity,
                         @Nullable String patientAddressState,
                         @Nullable String patientAddressCounty,
                         @Nullable String patientAddressZipcode,
                         @Nullable String patientAddressCountry,
                         @Nullable String patientAliasLastName,
                         @Nullable String patientAliasFirstName,
                         @Nullable String patientAliasMiddleName,
                         @Nullable String patientAlias,
                         @Nullable String patientSSN,
                         @Nullable String patientRace,
                         @Nullable String patientCitizenship,
                         @Nullable String maritalStatus,
                         @Nullable String patientEmail,
                         @Nullable String patientHomePhone,
                         @Nullable String patientWorkPhone,
                         @Nullable String patientFax,
                         @Nullable String patientMobile,
                         @Nullable String patientOtherPhone,
                         @Nullable String patientNotificationPreference,
                         @Nullable String patientEmployer,
                         @Nullable String patientEmployerStatus,
                         @Nullable String patientEmployerPhone,
                         @Nullable String patientStudentStatus,
                         @Nullable String patientSchool,
                         @Nullable String patientNoticeOfPrivacy,
                         @Nullable Date patientDateOfPrivacy,
                         @Nullable Date patientDateOfDeath,
                         @Nullable String patientCauseOfDeath,
                         @Nullable String patientEmergencyContactName,
                         @Nullable String patientEmergencyContactPhone,
                         @Nullable String patientPreferredLanguage,
                         @Nullable String patientSmokingStatus,
                         @Nullable String patientEthnicity,
                         @Nullable String patientBirthState,
                         @Nullable String patientBirthCountry,
                         @Nullable String patientBirthOrder,
                         @Nullable String patientMothersLastName,
                         @Nullable String patientMothersFirstName,
                         @Nullable String patientMothersMiddleName,
                         @Nullable String patientMothersMaidenName,
                         @Nullable String institutionName,
                         @Nullable String accessionNumber,
                         @Nullable String cPTCode,
                         @Nullable String cPTMnemonic,
                         @Nullable String modality,
                         @Nullable String studyDescription,
                         @Nullable String pregnant,
                         @Nullable String vipIndicator,
                         @Nullable Date admitDate,
                         @Nullable String admissionType,
                         @Nullable String patientLocationBed,
                         @Nullable String patientLocationBuilding,
                         @Nullable String patientLocationFacility,
                         @Nullable String patientLocationFloor,
                         @Nullable String patientLocationDescription,
                         @Nullable String patientLocationAssigningAuthority,
                         @Nullable String patientLocationComprehensiveDescription,
                         @Nullable String patientLocationStatus,
                         @Nullable String patientLocationType,
                         @Nullable String patientStation,
                         @Nullable String patientClass,
                         @Nullable String referringDoctorLastName,
                         @Nullable String referringDoctorFirstName,
                         @Nullable String referringDoctorDegree,
                         @Nullable String referringDoctorFullName,
                         @Nullable String orderingDoctorLastName,
                         @Nullable String orderingDoctorFirstName,
                         @Nullable String orderingDoctorDegree,
                         @Nullable String orderingDoctorFullName,
                         @Nullable String orderNumber,
                         @Nullable String sendingFacility,
                         @Nullable String techName,
                         @Nullable String authorizationNumber,
                         @Nullable String numberOfFilms,
                         @Nullable String filmType,
                         @Nullable Date effectiveDate,
                         @Nullable String findings,
                         @Nullable String approvalDate,
                         @Nullable String deliveryDate,
                         @Nullable String modifiers,
                         @Nullable String diagnosisCode,
                         @Nullable String reportId,
                         @Nullable String hl7,
                         @Nullable String coPayAmount,
                         @Nullable String feeAmount,
                         @Nullable String allowableAmount,
                         @Nullable String visitNumber,
                         @Nullable String deductibleAmount,
                         @Nullable String loggedAmount,
                         @Nullable String cardChequeNumber,
                         @Nullable String externalVisitId,
                         @Nullable String paymentMethod,
                         @Nullable Date expiryDate,
                         @Nullable String hospitalService,
                         @Nullable String procedureStartDate,
                         @Nullable String reasonForExam,
                         @Nullable String priority,
                         @Nullable String procedureCode,
                         @Nullable String procedureCodeScheme,
                         @Nullable String orderStatus,
                         @Nullable String laterality,
                         @Nullable String principalResultInterpreter,
                         @Nullable String responsibleObserver,
                         @Nullable String relevantClinicalInformation,
                         @Nullable Collection<Physician> physicians,
                         @Nullable String followUpCode,
                         @Nullable String guarantorName,
                         @Nullable String guarantorAddress,
                         @Nullable String guarantorPhone,
                         @Nullable Date guarantorDOB,
                         @Nullable String serviceType,
                         @Nullable Date dateOfService,
                         @Nullable String transportType,
                         @Nullable String inpatientLocation,
                         @Nullable String room,
                         boolean iV,
                         boolean o2,
                         boolean monitor,
                         @Nullable Date dischargeDate,
                         @Nullable String insuredName,
                         @Nullable String relationship,
                         boolean releaseSigned,
                         @Nullable String coPay,
                         @Nullable String deductible,
                         @Nullable Date dateSigned,
                         @Nullable String coInsurance,
                         @Nullable Collection<PatientInsurance> patientInsurances,
                         @Nullable Collection<VisitInsurance> visitInsurances,
                         @Nullable Collection<Allergy> allergies,
                         @Nullable Collection<Referral> referrals,
                         @Nullable Collection<Medication> medications,
                         @Nullable OrderReport report,
                         @Nullable String updatedBy,
                         @Nullable Date updateTime,
                         @Nullable String techNotes,
                         boolean critical,
                         @Nullable String studyDate,
                         @Nullable String studyTime,
                         @Nullable String arrivalDate,
                         @Nullable String arrivalTime,
                         @Nullable String additionalAccessions,
                         @Nullable UrgentExamType urgentExamType,
                         @Nullable String readingRadiologist)
    {
        super();

        this.orderId = orderId;
        this.status = status;
        this.orderPriority = orderPriority;
        this.assignedTo = assignedTo;
        this.dicomStudyId = dicomStudyId;
        this.patientFirstName = patientFirstName;
        this.patientMiddleName = patientMiddleName;
        this.patientLastName = patientLastName;
        this.patientId = patientId;
        this.patientBirthDate = patientBirthDate;
        this.patientAge = patientAge;
        this.patientSex = patientSex;
        this.patientSuffix = patientSuffix;
        this.alternatePatientId = alternatePatientId;
        this.patientAccountNumber = patientAccountNumber;
        this.patientAddressee = patientAddressee;
        this.patientAddressType = patientAddressType;
        this.patientStreetAddress = patientStreetAddress;
        this.patientStreetName = patientStreetName;
        this.patientAddressBuildingNumber = patientAddressBuildingNumber;
        this.patientAddressCity = patientAddressCity;
        this.patientAddressState = patientAddressState;
        this.patientAddressCounty = patientAddressCounty;
        this.patientAddressZipcode = patientAddressZipcode;
        this.patientAddressCountry = patientAddressCountry;
        this.patientAliasLastName = patientAliasLastName;
        this.patientAliasFirstName = patientAliasFirstName;
        this.patientAliasMiddleName = patientAliasMiddleName;
        this.patientAlias = patientAlias;
        this.patientSSN = patientSSN;
        this.patientRace = patientRace;
        this.patientCitizenship = patientCitizenship;
        this.maritalStatus = maritalStatus;
        this.patientEmail = patientEmail;
        this.patientHomePhone = patientHomePhone;
        this.patientWorkPhone = patientWorkPhone;
        this.patientFax = patientFax;
        this.patientMobile = patientMobile;
        this.patientOtherPhone = patientOtherPhone;
        this.patientNotificationPreference = patientNotificationPreference;
        this.patientEmployer = patientEmployer;
        this.patientEmployerStatus = patientEmployerStatus;
        this.patientEmployerPhone = patientEmployerPhone;
        this.patientStudentStatus = patientStudentStatus;
        this.patientSchool = patientSchool;
        this.patientNoticeOfPrivacy = patientNoticeOfPrivacy;
        this.patientDateOfPrivacy = patientDateOfPrivacy;
        this.patientDateOfDeath = patientDateOfDeath;
        this.patientCauseOfDeath = patientCauseOfDeath;
        this.patientEmergencyContactName = patientEmergencyContactName;
        this.patientEmergencyContactPhone = patientEmergencyContactPhone;
        this.patientPreferredLanguage = patientPreferredLanguage;
        this.patientSmokingStatus = patientSmokingStatus;
        this.patientEthnicity = patientEthnicity;
        this.patientBirthState = patientBirthState;
        this.patientBirthCountry = patientBirthCountry;
        this.patientBirthOrder = patientBirthOrder;
        this.patientMothersLastName = patientMothersLastName;
        this.patientMothersFirstName = patientMothersFirstName;
        this.patientMothersMiddleName = patientMothersMiddleName;
        this.patientMothersMaidenName = patientMothersMaidenName;
        this.institutionName = institutionName;
        this.accessionNumber = accessionNumber;
        this.cPTCode = cPTCode;
        this.cPTMnemonic = cPTMnemonic;
        this.modality = modality;
        this.studyDescription = studyDescription;
        this.pregnant = pregnant;
        this.vipIndicator = vipIndicator;
        this.admitDate = admitDate;
        this.admissionType = admissionType;
        this.patientLocationBed = patientLocationBed;
        this.patientLocationBuilding = patientLocationBuilding;
        this.patientLocationFacility = patientLocationFacility;
        this.patientLocationFloor = patientLocationFloor;
        this.patientLocationDescription = patientLocationDescription;
        this.patientLocationAssigningAuthority = patientLocationAssigningAuthority;
        this.patientLocationComprehensiveDescription = patientLocationComprehensiveDescription;
        this.patientLocationStatus = patientLocationStatus;
        this.patientLocationType = patientLocationType;
        this.patientStation = patientStation;
        this.patientClass = patientClass;
        this.referringDoctorLastName = referringDoctorLastName;
        this.referringDoctorFirstName = referringDoctorFirstName;
        this.referringDoctorDegree = referringDoctorDegree;
        this.referringDoctorFullName = referringDoctorFullName;
        this.orderingDoctorLastName = orderingDoctorLastName;
        this.orderingDoctorFirstName = orderingDoctorFirstName;
        this.orderingDoctorDegree = orderingDoctorDegree;
        this.orderingDoctorFullName = orderingDoctorFullName;
        this.orderNumber = orderNumber;
        this.sendingFacility = sendingFacility;
        this.techName = techName;
        this.authorizationNumber = authorizationNumber;
        this.numberOfFilms = numberOfFilms;
        this.filmType = filmType;
        this.effectiveDate = effectiveDate;
        this.findings = findings;
        this.approvalDate = approvalDate;
        this.deliveryDate = deliveryDate;
        this.modifiers = modifiers;
        this.diagnosisCode = diagnosisCode;
        this.reportId = reportId;
        this.hl7 = hl7;
        this.coPayAmount = coPayAmount;
        this.feeAmount = feeAmount;
        this.allowableAmount = allowableAmount;
        this.visitNumber = visitNumber;
        this.deductibleAmount = deductibleAmount;
        this.loggedAmount = loggedAmount;
        this.cardChequeNumber = cardChequeNumber;
        this.externalVisitId = externalVisitId;
        this.paymentMethod = paymentMethod;
        this.expiryDate = expiryDate;
        this.hospitalService = hospitalService;
        this.procedureStartDate = procedureStartDate;
        this.reasonForExam = reasonForExam;
        this.priority = priority;
        this.procedureCode = procedureCode;
        this.procedureCodeScheme = procedureCodeScheme;
        this.orderStatus = orderStatus;
        this.laterality = laterality;
        this.principalResultInterpreter = principalResultInterpreter;
        this.responsibleObserver = responsibleObserver;
        this.relevantClinicalInformation = relevantClinicalInformation;
        this.physicians = physicians;
        this.followUpCode = followUpCode;
        this.guarantorName = guarantorName;
        this.guarantorAddress = guarantorAddress;
        this.guarantorPhone = guarantorPhone;
        this.guarantorDOB = guarantorDOB;
        this.serviceType = serviceType;
        this.dateOfService = dateOfService;
        this.transportType = transportType;
        this.inpatientLocation = inpatientLocation;
        this.room = room;
        this.iV = iV;
        this.o2 = o2;
        this.monitor = monitor;
        this.dischargeDate = dischargeDate;
        this.insuredName = insuredName;
        this.relationship = relationship;
        this.releaseSigned = releaseSigned;
        this.coPay = coPay;
        this.deductible = deductible;
        this.dateSigned = dateSigned;
        this.coInsurance = coInsurance;
        this.patientInsurances = patientInsurances;
        this.visitInsurances = visitInsurances;
        this.allergies = allergies;
        this.referrals = referrals;
        this.medications = medications;
        this.report = report;
        this.updatedBy = updatedBy;
        this.updateTime = updateTime;
        this.techNotes = techNotes;
        this.critical = critical;
        this.studyDate = studyDate;
        this.studyTime = studyTime;
        this.arrivalDate = arrivalDate;
        this.arrivalTime = arrivalTime;
        this.additionalAccessions = additionalAccessions;
        this.urgentExamType = urgentExamType;
        this.readingRadiologist = readingRadiologist;
    }

    @NotNull
    public String getOrderId()
    {
        return orderId;
    }

    @NotNull
    public OrderStatus getStatus()
    {
        return status;
    }

    @NotNull
    public OrderPriority getOrderPriority()
    {
        return orderPriority;
    }

    @NotNull
    public String getAssignedTo()
    {
        return assignedTo;
    }

    @Nullable
    public String getDicomStudyId()
    {
        return dicomStudyId;
    }

    @Nullable
    public String getPatientFirstName()
    {
        return patientFirstName;
    }

    @Nullable
    public String getPatientMiddleName()
    {
        return patientMiddleName;
    }

    @Nullable
    public String getPatientLastName()
    {
        return patientLastName;
    }

    @Nullable
    public String getPatientId()
    {
        return patientId;
    }

    @Nullable
    public Date getPatientBirthDate()
    {
        return patientBirthDate;
    }

    @Nullable
    public String getPatientAge()
    {
        return patientAge;
    }

    @Nullable
    public String getPatientSex()
    {
        return patientSex;
    }

    @Nullable
    public String getPatientSuffix()
    {
        return patientSuffix;
    }

    @Nullable
    public String getAlternatePatientId()
    {
        return alternatePatientId;
    }

    @Nullable
    public String getPatientAccountNumber()
    {
        return patientAccountNumber;
    }

    @Nullable
    public String getPatientAddressee()
    {
        return patientAddressee;
    }

    @Nullable
    public String getPatientAddressType()
    {
        return patientAddressType;
    }

    @Nullable
    public String getPatientStreetAddress()
    {
        return patientStreetAddress;
    }

    @Nullable
    public String getPatientStreetName()
    {
        return patientStreetName;
    }

    @Nullable
    public String getPatientAddressBuildingNumber()
    {
        return patientAddressBuildingNumber;
    }

    @Nullable
    public String getPatientAddressCity()
    {
        return patientAddressCity;
    }

    @Nullable
    public String getPatientAddressState()
    {
        return patientAddressState;
    }

    @Nullable
    public String getPatientAddressCounty()
    {
        return patientAddressCounty;
    }

    @Nullable
    public String getPatientAddressZipcode()
    {
        return patientAddressZipcode;
    }

    @Nullable
    public String getPatientAddressCountry()
    {
        return patientAddressCountry;
    }

    @Nullable
    public String getPatientAliasLastName()
    {
        return patientAliasLastName;
    }

    @Nullable
    public String getPatientAliasFirstName()
    {
        return patientAliasFirstName;
    }

    @Nullable
    public String getPatientAliasMiddleName()
    {
        return patientAliasMiddleName;
    }

    @Nullable
    public String getPatientAlias()
    {
        return patientAlias;
    }

    @Nullable
    public String getPatientSSN()
    {
        return patientSSN;
    }

    @Nullable
    public String getPatientRace()
    {
        return patientRace;
    }

    @Nullable
    public String getPatientCitizenship()
    {
        return patientCitizenship;
    }

    @Nullable
    public String getMaritalStatus()
    {
        return maritalStatus;
    }

    @Nullable
    public String getPatientEmail()
    {
        return patientEmail;
    }

    @Nullable
    public String getPatientHomePhone()
    {
        return patientHomePhone;
    }

    @Nullable
    public String getPatientWorkPhone()
    {
        return patientWorkPhone;
    }

    @Nullable
    public String getPatientFax()
    {
        return patientFax;
    }

    @Nullable
    public String getPatientMobile()
    {
        return patientMobile;
    }

    @Nullable
    public String getPatientOtherPhone()
    {
        return patientOtherPhone;
    }

    @Nullable
    public String getPatientNotificationPreference()
    {
        return patientNotificationPreference;
    }

    @Nullable
    public String getPatientEmployer()
    {
        return patientEmployer;
    }

    @Nullable
    public String getPatientEmployerStatus()
    {
        return patientEmployerStatus;
    }

    @Nullable
    public String getPatientEmployerPhone()
    {
        return patientEmployerPhone;
    }

    @Nullable
    public String getPatientStudentStatus()
    {
        return patientStudentStatus;
    }

    @Nullable
    public String getPatientSchool()
    {
        return patientSchool;
    }

    @Nullable
    public String getPatientNoticeOfPrivacy()
    {
        return patientNoticeOfPrivacy;
    }

    @Nullable
    public Date getPatientDateOfPrivacy()
    {
        return patientDateOfPrivacy;
    }

    @Nullable
    public Date getPatientDateOfDeath()
    {
        return patientDateOfDeath;
    }

    @Nullable
    public String getPatientCauseOfDeath()
    {
        return patientCauseOfDeath;
    }

    @Nullable
    public String getPatientEmergencyContactName()
    {
        return patientEmergencyContactName;
    }

    @Nullable
    public String getPatientEmergencyContactPhone()
    {
        return patientEmergencyContactPhone;
    }

    @Nullable
    public String getPatientPreferredLanguage()
    {
        return patientPreferredLanguage;
    }

    @Nullable
    public String getPatientSmokingStatus()
    {
        return patientSmokingStatus;
    }

    @Nullable
    public String getPatientEthnicity()
    {
        return patientEthnicity;
    }

    @Nullable
    public String getPatientBirthState()
    {
        return patientBirthState;
    }

    @Nullable
    public String getPatientBirthCountry()
    {
        return patientBirthCountry;
    }

    @Nullable
    public String getPatientBirthOrder()
    {
        return patientBirthOrder;
    }

    @Nullable
    public String getPatientMothersLastName()
    {
        return patientMothersLastName;
    }

    @Nullable
    public String getPatientMothersFirstName()
    {
        return patientMothersFirstName;
    }

    @Nullable
    public String getPatientMothersMiddleName()
    {
        return patientMothersMiddleName;
    }

    @Nullable
    public String getPatientMothersMaidenName()
    {
        return patientMothersMaidenName;
    }

    @Nullable
    public String getInstitutionName()
    {
        return institutionName;
    }

    @Nullable
    public String getAccessionNumber()
    {
        return accessionNumber;
    }

    @Nullable
    public String getCPTCode()
    {
        return cPTCode;
    }

    @Nullable
    public String getCPTMnemonic()
    {
        return cPTMnemonic;
    }

    @Nullable
    public String getModality()
    {
        return modality;
    }

    @Nullable
    public String getStudyDescription()
    {
        return studyDescription;
    }

    @Nullable
    public String getPregnant()
    {
        return pregnant;
    }

    @Nullable
    public String getVipIndicator()
    {
        return vipIndicator;
    }

    @Nullable
    public Date getAdmitDate()
    {
        return admitDate;
    }

    @Nullable
    public String getAdmissionType()
    {
        return admissionType;
    }

    @Nullable
    public String getPatientLocationBed()
    {
        return patientLocationBed;
    }

    @Nullable
    public String getPatientLocationBuilding()
    {
        return patientLocationBuilding;
    }

    @Nullable
    public String getPatientLocationFacility()
    {
        return patientLocationFacility;
    }

    @Nullable
    public String getPatientLocationFloor()
    {
        return patientLocationFloor;
    }

    @Nullable
    public String getPatientLocationDescription()
    {
        return patientLocationDescription;
    }

    @Nullable
    public String getPatientLocationAssigningAuthority()
    {
        return patientLocationAssigningAuthority;
    }

    @Nullable
    public String getPatientLocationComprehensiveDescription()
    {
        return patientLocationComprehensiveDescription;
    }

    @Nullable
    public String getPatientLocationStatus()
    {
        return patientLocationStatus;
    }

    @Nullable
    public String getPatientLocationType()
    {
        return patientLocationType;
    }

    @Nullable
    public String getPatientStation()
    {
        return patientStation;
    }

    @Nullable
    public String getPatientClass()
    {
        return patientClass;
    }

    @Nullable
    public String getReferringDoctorLastName()
    {
        return referringDoctorLastName;
    }

    @Nullable
    public String getReferringDoctorFirstName()
    {
        return referringDoctorFirstName;
    }

    @Nullable
    public String getReferringDoctorDegree()
    {
        return referringDoctorDegree;
    }

    @Nullable
    public String getReferringDoctorFullName()
    {
        return referringDoctorFullName;
    }

    @Nullable
    public String getOrderingDoctorLastName()
    {
        return orderingDoctorLastName;
    }

    @Nullable
    public String getOrderingDoctorFirstName()
    {
        return orderingDoctorFirstName;
    }

    @Nullable
    public String getOrderingDoctorDegree()
    {
        return orderingDoctorDegree;
    }

    @Nullable
    public String getOrderingDoctorFullName()
    {
        return orderingDoctorFullName;
    }

    @Nullable
    public String getOrderNumber()
    {
        return orderNumber;
    }

    @Nullable
    public String getSendingFacility()
    {
        return sendingFacility;
    }

    @Nullable
    public String getTechName()
    {
        return techName;
    }

    @Nullable
    public String getAuthorizationNumber()
    {
        return authorizationNumber;
    }

    @Nullable
    public String getNumberOfFilms()
    {
        return numberOfFilms;
    }

    @Nullable
    public String getFilmType()
    {
        return filmType;
    }

    @Nullable
    public Date getEffectiveDate()
    {
        return effectiveDate;
    }

    @Nullable
    public String getFindings()
    {
        return findings;
    }

    @Nullable
    public String getApprovalDate()
    {
        return approvalDate;
    }

    @Nullable
    public String getDeliveryDate()
    {
        return deliveryDate;
    }

    @Nullable
    public String getModifiers()
    {
        return modifiers;
    }

    @Nullable
    public String getDiagnosisCode()
    {
        return diagnosisCode;
    }

    @Nullable
    public String getReportId()
    {
        return reportId;
    }

    @Nullable
    public String getHl7()
    {
        return hl7;
    }

    @Nullable
    public String getCoPayAmount()
    {
        return coPayAmount;
    }

    @Nullable
    public String getFeeAmount()
    {
        return feeAmount;
    }

    @Nullable
    public String getAllowableAmount()
    {
        return allowableAmount;
    }

    @Nullable
    public String getVisitNumber()
    {
        return visitNumber;
    }

    @Nullable
    public String getDeductibleAmount()
    {
        return deductibleAmount;
    }

    @Nullable
    public String getLoggedAmount()
    {
        return loggedAmount;
    }

    @Nullable
    public String getCardChequeNumber()
    {
        return cardChequeNumber;
    }

    @Nullable
    public String getExternalVisitId()
    {
        return externalVisitId;
    }

    @Nullable
    public String getPaymentMethod()
    {
        return paymentMethod;
    }

    @Nullable
    public Date getExpiryDate()
    {
        return expiryDate;
    }

    @Nullable
    public String getHospitalService()
    {
        return hospitalService;
    }

    @Nullable
    public String getProcedureStartDate()
    {
        return procedureStartDate;
    }

    @Nullable
    public String getReasonForExam()
    {
        return reasonForExam;
    }

    @Nullable
    public String getPriority()
    {
        return priority;
    }

    @Nullable
    public String getProcedureCode()
    {
        return procedureCode;
    }

    @Nullable
    public String getProcedureCodeScheme()
    {
        return procedureCodeScheme;
    }

    @Nullable
    public String getOrderStatus()
    {
        return orderStatus;
    }

    @Nullable
    public String getLaterality()
    {
        return laterality;
    }

    @Nullable
    public String getPrincipalResultInterpreter()
    {
        return principalResultInterpreter;
    }

    @Nullable
    public String getResponsibleObserver()
    {
        return responsibleObserver;
    }

    @Nullable
    public String getRelevantClinicalInformation()
    {
        return relevantClinicalInformation;
    }

    @Nullable
    public Collection<Physician> getPhysicians()
    {
        return physicians;
    }

    @Nullable
    public String getFollowUpCode()
    {
        return followUpCode;
    }

    @Nullable
    public String getGuarantorName()
    {
        return guarantorName;
    }

    @Nullable
    public String getGuarantorAddress()
    {
        return guarantorAddress;
    }

    @Nullable
    public String getGuarantorPhone()
    {
        return guarantorPhone;
    }

    @Nullable
    public Date getGuarantorDOB()
    {
        return guarantorDOB;
    }

    @Nullable
    public String getServiceType()
    {
        return serviceType;
    }

    @Nullable
    public Date getDateOfService()
    {
        return dateOfService;
    }

    @Nullable
    public String getTransportType()
    {
        return transportType;
    }

    @Nullable
    public String getInpatientLocation()
    {
        return inpatientLocation;
    }

    @Nullable
    public String getRoom()
    {
        return room;
    }

    public boolean isIV()
    {
        return iV;
    }

    public boolean isO2()
    {
        return o2;
    }

    public boolean isMonitor()
    {
        return monitor;
    }

    @Nullable
    public Date getDischargeDate()
    {
        return dischargeDate;
    }

    @Nullable
    public String getInsuredName()
    {
        return insuredName;
    }

    @Nullable
    public String getRelationship()
    {
        return relationship;
    }

    public boolean isReleaseSigned()
    {
        return releaseSigned;
    }

    @Nullable
    public String getCoPay()
    {
        return coPay;
    }

    @Nullable
    public String getDeductible()
    {
        return deductible;
    }

    @Nullable
    public Date getDateSigned()
    {
        return dateSigned;
    }

    @Nullable
    public String getCoInsurance()
    {
        return coInsurance;
    }

    @Nullable
    public Collection<PatientInsurance> getPatientInsurances()
    {
        return patientInsurances;
    }

    @Nullable
    public Collection<VisitInsurance> getVisitInsurances()
    {
        return visitInsurances;
    }

    @Nullable
    public Collection<Allergy> getAllergies()
    {
        return allergies;
    }

    @Nullable
    public Collection<Referral> getReferrals()
    {
        return referrals;
    }

    @Nullable
    public Collection<Medication> getMedications()
    {
        return medications;
    }

    @Nullable
    public OrderReport getReport()
    {
        return report;
    }

    @Nullable
    public String getUpdatedBy()
    {
        return updatedBy;
    }

    @Nullable
    public Date getUpdateTime()
    {
        return updateTime;
    }

    @Nullable
    public String getTechNotes()
    {
        return techNotes;
    }

    public boolean isCritical()
    {
        return critical;
    }

    @Nullable
    public String getStudyDate()
    {
        return studyDate;
    }

    @Nullable
    public String getStudyTime()
    {
        return studyTime;
    }

    @Nullable
    public String getArrivalDate()
    {
        return arrivalDate;
    }

    @Nullable
    public String getArrivalTime()
    {
        return arrivalTime;
    }

    @Nullable
    public String getAdditionalAccessions()
    {
        return additionalAccessions;
    }

    @Nullable
    public UrgentExamType getUrgentExamType()
    {
        return urgentExamType;
    }

    @Nullable
    public String getReadingRadiologist()
    {
        return readingRadiologist;
    }
    public void setOrderId(@NotNull String orderId)
    {
        this.orderId = orderId;
    }

    public void setStatus(@NotNull OrderStatus status)
    {
        this.status = status;
    }

    public void setOrderPriority(@NotNull OrderPriority orderPriority)
    {
        this.orderPriority = orderPriority;
    }

    public void setAssignedTo(@NotNull String assignedTo)
    {
        this.assignedTo = assignedTo;
    }

    public void setDicomStudyId(@Nullable String dicomStudyId)
    {
        this.dicomStudyId = dicomStudyId;
    }

    public void setPatientFirstName(@Nullable String patientFirstName)
    {
        this.patientFirstName = patientFirstName;
    }

    public void setPatientMiddleName(@Nullable String patientMiddleName)
    {
        this.patientMiddleName = patientMiddleName;
    }

    public void setPatientLastName(@Nullable String patientLastName)
    {
        this.patientLastName = patientLastName;
    }

    public void setPatientId(@Nullable String patientId)
    {
        this.patientId = patientId;
    }

    public void setPatientBirthDate(@Nullable Date patientBirthDate)
    {
        this.patientBirthDate = patientBirthDate;
    }

    public void setPatientAge(@Nullable String patientAge)
    {
        this.patientAge = patientAge;
    }

    public void setPatientSex(@Nullable String patientSex)
    {
        this.patientSex = patientSex;
    }

    public void setPatientSuffix(@Nullable String patientSuffix)
    {
        this.patientSuffix = patientSuffix;
    }

    public void setAlternatePatientId(@Nullable String alternatePatientId)
    {
        this.alternatePatientId = alternatePatientId;
    }

    public void setPatientAccountNumber(@Nullable String patientAccountNumber)
    {
        this.patientAccountNumber = patientAccountNumber;
    }

    public void setPatientAddressee(@Nullable String patientAddressee)
    {
        this.patientAddressee = patientAddressee;
    }

    public void setPatientAddressType(@Nullable String patientAddressType)
    {
        this.patientAddressType = patientAddressType;
    }

    public void setPatientStreetAddress(@Nullable String patientStreetAddress)
    {
        this.patientStreetAddress = patientStreetAddress;
    }

    public void setPatientStreetName(@Nullable String patientStreetName)
    {
        this.patientStreetName = patientStreetName;
    }

    public void setPatientAddressBuildingNumber(@Nullable String patientAddressBuildingNumber)
    {
        this.patientAddressBuildingNumber = patientAddressBuildingNumber;
    }

    public void setPatientAddressCity(@Nullable String patientAddressCity)
    {
        this.patientAddressCity = patientAddressCity;
    }

    public void setPatientAddressState(@Nullable String patientAddressState)
    {
        this.patientAddressState = patientAddressState;
    }

    public void setPatientAddressCounty(@Nullable String patientAddressCounty)
    {
        this.patientAddressCounty = patientAddressCounty;
    }

    public void setPatientAddressZipcode(@Nullable String patientAddressZipcode)
    {
        this.patientAddressZipcode = patientAddressZipcode;
    }

    public void setPatientAddressCountry(@Nullable String patientAddressCountry)
    {
        this.patientAddressCountry = patientAddressCountry;
    }

    public void setPatientAliasLastName(@Nullable String patientAliasLastName)
    {
        this.patientAliasLastName = patientAliasLastName;
    }

    public void setPatientAliasFirstName(@Nullable String patientAliasFirstName)
    {
        this.patientAliasFirstName = patientAliasFirstName;
    }

    public void setPatientAliasMiddleName(@Nullable String patientAliasMiddleName)
    {
        this.patientAliasMiddleName = patientAliasMiddleName;
    }

    public void setPatientAlias(@Nullable String patientAlias)
    {
        this.patientAlias = patientAlias;
    }

    public void setPatientSSN(@Nullable String patientSSN)
    {
        this.patientSSN = patientSSN;
    }

    public void setPatientRace(@Nullable String patientRace)
    {
        this.patientRace = patientRace;
    }

    public void setPatientCitizenship(@Nullable String patientCitizenship)
    {
        this.patientCitizenship = patientCitizenship;
    }

    public void setMaritalStatus(@Nullable String maritalStatus)
    {
        this.maritalStatus = maritalStatus;
    }

    public void setPatientEmail(@Nullable String patientEmail)
    {
        this.patientEmail = patientEmail;
    }

    public void setPatientHomePhone(@Nullable String patientHomePhone)
    {
        this.patientHomePhone = patientHomePhone;
    }

    public void setPatientWorkPhone(@Nullable String patientWorkPhone)
    {
        this.patientWorkPhone = patientWorkPhone;
    }

    public void setPatientFax(@Nullable String patientFax)
    {
        this.patientFax = patientFax;
    }

    public void setPatientMobile(@Nullable String patientMobile)
    {
        this.patientMobile = patientMobile;
    }

    public void setPatientOtherPhone(@Nullable String patientOtherPhone)
    {
        this.patientOtherPhone = patientOtherPhone;
    }

    public void setPatientNotificationPreference(@Nullable String patientNotificationPreference)
    {
        this.patientNotificationPreference = patientNotificationPreference;
    }

    public void setPatientEmployer(@Nullable String patientEmployer)
    {
        this.patientEmployer = patientEmployer;
    }

    public void setPatientEmployerStatus(@Nullable String patientEmployerStatus)
    {
        this.patientEmployerStatus = patientEmployerStatus;
    }

    public void setPatientEmployerPhone(@Nullable String patientEmployerPhone)
    {
        this.patientEmployerPhone = patientEmployerPhone;
    }

    public void setPatientStudentStatus(@Nullable String patientStudentStatus)
    {
        this.patientStudentStatus = patientStudentStatus;
    }

    public void setPatientSchool(@Nullable String patientSchool)
    {
        this.patientSchool = patientSchool;
    }

    public void setPatientNoticeOfPrivacy(@Nullable String patientNoticeOfPrivacy)
    {
        this.patientNoticeOfPrivacy = patientNoticeOfPrivacy;
    }

    public void setPatientDateOfPrivacy(@Nullable Date patientDateOfPrivacy)
    {
        this.patientDateOfPrivacy = patientDateOfPrivacy;
    }

    public void setPatientDateOfDeath(@Nullable Date patientDateOfDeath)
    {
        this.patientDateOfDeath = patientDateOfDeath;
    }

    public void setPatientCauseOfDeath(@Nullable String patientCauseOfDeath)
    {
        this.patientCauseOfDeath = patientCauseOfDeath;
    }

    public void setPatientEmergencyContactName(@Nullable String patientEmergencyContactName)
    {
        this.patientEmergencyContactName = patientEmergencyContactName;
    }

    public void setPatientEmergencyContactPhone(@Nullable String patientEmergencyContactPhone)
    {
        this.patientEmergencyContactPhone = patientEmergencyContactPhone;
    }

    public void setPatientPreferredLanguage(@Nullable String patientPreferredLanguage)
    {
        this.patientPreferredLanguage = patientPreferredLanguage;
    }

    public void setPatientSmokingStatus(@Nullable String patientSmokingStatus)
    {
        this.patientSmokingStatus = patientSmokingStatus;
    }

    public void setPatientEthnicity(@Nullable String patientEthnicity)
    {
        this.patientEthnicity = patientEthnicity;
    }

    public void setPatientBirthState(@Nullable String patientBirthState)
    {
        this.patientBirthState = patientBirthState;
    }

    public void setPatientBirthCountry(@Nullable String patientBirthCountry)
    {
        this.patientBirthCountry = patientBirthCountry;
    }

    public void setPatientBirthOrder(@Nullable String patientBirthOrder)
    {
        this.patientBirthOrder = patientBirthOrder;
    }

    public void setPatientMothersLastName(@Nullable String patientMothersLastName)
    {
        this.patientMothersLastName = patientMothersLastName;
    }

    public void setPatientMothersFirstName(@Nullable String patientMothersFirstName)
    {
        this.patientMothersFirstName = patientMothersFirstName;
    }

    public void setPatientMothersMiddleName(@Nullable String patientMothersMiddleName)
    {
        this.patientMothersMiddleName = patientMothersMiddleName;
    }

    public void setPatientMothersMaidenName(@Nullable String patientMothersMaidenName)
    {
        this.patientMothersMaidenName = patientMothersMaidenName;
    }

    public void setInstitutionName(@Nullable String institutionName)
    {
        this.institutionName = institutionName;
    }

    public void setAccessionNumber(@Nullable String accessionNumber)
    {
        this.accessionNumber = accessionNumber;
    }

    public void setCPTCode(@Nullable String cPTCode)
    {
        this.cPTCode = cPTCode;
    }

    public void setCPTMnemonic(@Nullable String cPTMnemonic)
    {
        this.cPTMnemonic = cPTMnemonic;
    }

    public void setModality(@Nullable String modality)
    {
        this.modality = modality;
    }

    public void setStudyDescription(@Nullable String studyDescription)
    {
        this.studyDescription = studyDescription;
    }

    public void setPregnant(@Nullable String pregnant)
    {
        this.pregnant = pregnant;
    }

    public void setVipIndicator(@Nullable String vipIndicator)
    {
        this.vipIndicator = vipIndicator;
    }

    public void setAdmitDate(@Nullable Date admitDate)
    {
        this.admitDate = admitDate;
    }

    public void setAdmissionType(@Nullable String admissionType)
    {
        this.admissionType = admissionType;
    }

    public void setPatientLocationBed(@Nullable String patientLocationBed)
    {
        this.patientLocationBed = patientLocationBed;
    }

    public void setPatientLocationBuilding(@Nullable String patientLocationBuilding)
    {
        this.patientLocationBuilding = patientLocationBuilding;
    }

    public void setPatientLocationFacility(@Nullable String patientLocationFacility)
    {
        this.patientLocationFacility = patientLocationFacility;
    }

    public void setPatientLocationFloor(@Nullable String patientLocationFloor)
    {
        this.patientLocationFloor = patientLocationFloor;
    }

    public void setPatientLocationDescription(@Nullable String patientLocationDescription)
    {
        this.patientLocationDescription = patientLocationDescription;
    }

    public void setPatientLocationAssigningAuthority(@Nullable String patientLocationAssigningAuthority)
    {
        this.patientLocationAssigningAuthority = patientLocationAssigningAuthority;
    }

    public void setPatientLocationComprehensiveDescription(@Nullable String patientLocationComprehensiveDescription)
    {
        this.patientLocationComprehensiveDescription = patientLocationComprehensiveDescription;
    }

    public void setPatientLocationStatus(@Nullable String patientLocationStatus)
    {
        this.patientLocationStatus = patientLocationStatus;
    }

    public void setPatientLocationType(@Nullable String patientLocationType)
    {
        this.patientLocationType = patientLocationType;
    }

    public void setPatientStation(@Nullable String patientStation)
    {
        this.patientStation = patientStation;
    }

    public void setPatientClass(@Nullable String patientClass)
    {
        this.patientClass = patientClass;
    }

    public void setReferringDoctorLastName(@Nullable String referringDoctorLastName)
    {
        this.referringDoctorLastName = referringDoctorLastName;
    }

    public void setReferringDoctorFirstName(@Nullable String referringDoctorFirstName)
    {
        this.referringDoctorFirstName = referringDoctorFirstName;
    }

    public void setReferringDoctorDegree(@Nullable String referringDoctorDegree)
    {
        this.referringDoctorDegree = referringDoctorDegree;
    }

    public void setReferringDoctorFullName(@Nullable String referringDoctorFullName)
    {
        this.referringDoctorFullName = referringDoctorFullName;
    }

    public void setOrderingDoctorLastName(@Nullable String orderingDoctorLastName)
    {
        this.orderingDoctorLastName = orderingDoctorLastName;
    }

    public void setOrderingDoctorFirstName(@Nullable String orderingDoctorFirstName)
    {
        this.orderingDoctorFirstName = orderingDoctorFirstName;
    }

    public void setOrderingDoctorDegree(@Nullable String orderingDoctorDegree)
    {
        this.orderingDoctorDegree = orderingDoctorDegree;
    }

    public void setOrderingDoctorFullName(@Nullable String orderingDoctorFullName)
    {
        this.orderingDoctorFullName = orderingDoctorFullName;
    }

    public void setOrderNumber(@Nullable String orderNumber)
    {
        this.orderNumber = orderNumber;
    }

    public void setSendingFacility(@Nullable String sendingFacility)
    {
        this.sendingFacility = sendingFacility;
    }

    public void setTechName(@Nullable String techName)
    {
        this.techName = techName;
    }

    public void setAuthorizationNumber(@Nullable String authorizationNumber)
    {
        this.authorizationNumber = authorizationNumber;
    }

    public void setNumberOfFilms(@Nullable String numberOfFilms)
    {
        this.numberOfFilms = numberOfFilms;
    }

    public void setFilmType(@Nullable String filmType)
    {
        this.filmType = filmType;
    }

    public void setEffectiveDate(@Nullable Date effectiveDate)
    {
        this.effectiveDate = effectiveDate;
    }

    public void setFindings(@Nullable String findings)
    {
        this.findings = findings;
    }

    public void setApprovalDate(@Nullable String approvalDate)
    {
        this.approvalDate = approvalDate;
    }

    public void setDeliveryDate(@Nullable String deliveryDate)
    {
        this.deliveryDate = deliveryDate;
    }

    public void setModifiers(@Nullable String modifiers)
    {
        this.modifiers = modifiers;
    }

    public void setDiagnosisCode(@Nullable String diagnosisCode)
    {
        this.diagnosisCode = diagnosisCode;
    }

    public void setReportId(@Nullable String reportId)
    {
        this.reportId = reportId;
    }

    public void setHl7(@Nullable String hl7)
    {
        this.hl7 = hl7;
    }

    public void setCoPayAmount(@Nullable String coPayAmount)
    {
        this.coPayAmount = coPayAmount;
    }

    public void setFeeAmount(@Nullable String feeAmount)
    {
        this.feeAmount = feeAmount;
    }

    public void setAllowableAmount(@Nullable String allowableAmount)
    {
        this.allowableAmount = allowableAmount;
    }

    public void setVisitNumber(@Nullable String visitNumber)
    {
        this.visitNumber = visitNumber;
    }

    public void setDeductibleAmount(@Nullable String deductibleAmount)
    {
        this.deductibleAmount = deductibleAmount;
    }

    public void setLoggedAmount(@Nullable String loggedAmount)
    {
        this.loggedAmount = loggedAmount;
    }

    public void setCardChequeNumber(@Nullable String cardChequeNumber)
    {
        this.cardChequeNumber = cardChequeNumber;
    }

    public void setExternalVisitId(@Nullable String externalVisitId)
    {
        this.externalVisitId = externalVisitId;
    }

    public void setPaymentMethod(@Nullable String paymentMethod)
    {
        this.paymentMethod = paymentMethod;
    }

    public void setExpiryDate(@Nullable Date expiryDate)
    {
        this.expiryDate = expiryDate;
    }

    public void setHospitalService(@Nullable String hospitalService)
    {
        this.hospitalService = hospitalService;
    }

    public void setProcedureStartDate(@Nullable String procedureStartDate)
    {
        this.procedureStartDate = procedureStartDate;
    }

    public void setReasonForExam(@Nullable String reasonForExam)
    {
        this.reasonForExam = reasonForExam;
    }

    public void setPriority(@Nullable String priority)
    {
        this.priority = priority;
    }

    public void setProcedureCode(@Nullable String procedureCode)
    {
        this.procedureCode = procedureCode;
    }

    public void setProcedureCodeScheme(@Nullable String procedureCodeScheme)
    {
        this.procedureCodeScheme = procedureCodeScheme;
    }

    public void setOrderStatus(@Nullable String orderStatus)
    {
        this.orderStatus = orderStatus;
    }

    public void setLaterality(@Nullable String laterality)
    {
        this.laterality = laterality;
    }

    public void setPrincipalResultInterpreter(@Nullable String principalResultInterpreter)
    {
        this.principalResultInterpreter = principalResultInterpreter;
    }

    public void setResponsibleObserver(@Nullable String responsibleObserver)
    {
        this.responsibleObserver = responsibleObserver;
    }

    public void setRelevantClinicalInformation(@Nullable String relevantClinicalInformation)
    {
        this.relevantClinicalInformation = relevantClinicalInformation;
    }

    public void setPhysicians(@Nullable Collection<Physician> physicians)
    {
        this.physicians = physicians;
    }

    public void setFollowUpCode(@Nullable String followUpCode)
    {
        this.followUpCode = followUpCode;
    }

    public void setGuarantorName(@Nullable String guarantorName)
    {
        this.guarantorName = guarantorName;
    }

    public void setGuarantorAddress(@Nullable String guarantorAddress)
    {
        this.guarantorAddress = guarantorAddress;
    }

    public void setGuarantorPhone(@Nullable String guarantorPhone)
    {
        this.guarantorPhone = guarantorPhone;
    }

    public void setGuarantorDOB(@Nullable Date guarantorDOB)
    {
        this.guarantorDOB = guarantorDOB;
    }

    public void setServiceType(@Nullable String serviceType)
    {
        this.serviceType = serviceType;
    }

    public void setDateOfService(@Nullable Date dateOfService)
    {
        this.dateOfService = dateOfService;
    }

    public void setTransportType(@Nullable String transportType)
    {
        this.transportType = transportType;
    }

    public void setInpatientLocation(@Nullable String inpatientLocation)
    {
        this.inpatientLocation = inpatientLocation;
    }

    public void setRoom(@Nullable String room)
    {
        this.room = room;
    }

    public void setIV(boolean iV)
    {
        this.iV = iV;
    }

    public void setO2(boolean o2)
    {
        this.o2 = o2;
    }

    public void setMonitor(boolean monitor)
    {
        this.monitor = monitor;
    }

    public void setDischargeDate(@Nullable Date dischargeDate)
    {
        this.dischargeDate = dischargeDate;
    }

    public void setInsuredName(@Nullable String insuredName)
    {
        this.insuredName = insuredName;
    }

    public void setRelationship(@Nullable String relationship)
    {
        this.relationship = relationship;
    }

    public void setReleaseSigned(boolean releaseSigned)
    {
        this.releaseSigned = releaseSigned;
    }

    public void setCoPay(@Nullable String coPay)
    {
        this.coPay = coPay;
    }

    public void setDeductible(@Nullable String deductible)
    {
        this.deductible = deductible;
    }

    public void setDateSigned(@Nullable Date dateSigned)
    {
        this.dateSigned = dateSigned;
    }

    public void setCoInsurance(@Nullable String coInsurance)
    {
        this.coInsurance = coInsurance;
    }

    public void setPatientInsurances(@Nullable Collection<PatientInsurance> patientInsurances)
    {
        this.patientInsurances = patientInsurances;
    }

    public void setVisitInsurances(@Nullable Collection<VisitInsurance> visitInsurances)
    {
        this.visitInsurances = visitInsurances;
    }

    public void setAllergies(@Nullable Collection<Allergy> allergies)
    {
        this.allergies = allergies;
    }

    public void setReferrals(@Nullable Collection<Referral> referrals)
    {
        this.referrals = referrals;
    }

    public void setMedications(@Nullable Collection<Medication> medications)
    {
        this.medications = medications;
    }

    public void setReport(@Nullable OrderReport report)
    {
        this.report = report;
    }

    public void setUpdatedBy(@Nullable String updatedBy)
    {
        this.updatedBy = updatedBy;
    }

    public void setUpdateTime(@Nullable Date updateTime)
    {
        this.updateTime = updateTime;
    }

    public void setTechNotes(@Nullable String techNotes)
    {
        this.techNotes = techNotes;
    }

    public void setCritical(boolean critical)
    {
        this.critical = critical;
    }

    public void setStudyDate(@Nullable String studyDate)
    {
        this.studyDate = studyDate;
    }

    public void setStudyTime(@Nullable String studyTime)
    {
        this.studyTime = studyTime;
    }

    public void setArrivalDate(@Nullable String arrivalDate)
    {
        this.arrivalDate = arrivalDate;
    }

    public void setArrivalTime(@Nullable String arrivalTime)
    {
        this.arrivalTime = arrivalTime;
    }

    public void setAdditionalAccessions(@Nullable String additionalAccessions)
    {
        this.additionalAccessions = additionalAccessions;
    }

    public void setUrgentExamType(@Nullable UrgentExamType urgentExamType)
    {
        this.urgentExamType = urgentExamType;
    }

    public void setReadingRadiologist(@Nullable String readingRadiologist)
    {
        this.readingRadiologist = readingRadiologist;
    }

    @NotNull
    public String toString()
    {
        return "DetailedOrder(" +
            " orderId: " + getOrderId() +
            " status: " + getStatus() +
            " orderPriority: " + getOrderPriority() +
            " assignedTo: " + getAssignedTo() +
            " dicomStudyId: " + getDicomStudyId() +
            " patientFirstName: " + getPatientFirstName() +
            " patientMiddleName: " + getPatientMiddleName() +
            " patientLastName: " + getPatientLastName() +
            " patientId: " + getPatientId() +
            " patientBirthDate: " + getPatientBirthDate() +
            " patientAge: " + getPatientAge() +
            " patientSex: " + getPatientSex() +
            " patientSuffix: " + getPatientSuffix() +
            " alternatePatientId: " + getAlternatePatientId() +
            " patientAccountNumber: " + getPatientAccountNumber() +
            " patientAddressee: " + getPatientAddressee() +
            " patientAddressType: " + getPatientAddressType() +
            " patientStreetAddress: " + getPatientStreetAddress() +
            " patientStreetName: " + getPatientStreetName() +
            " patientAddressBuildingNumber: " + getPatientAddressBuildingNumber() +
            " patientAddressCity: " + getPatientAddressCity() +
            " patientAddressState: " + getPatientAddressState() +
            " patientAddressCounty: " + getPatientAddressCounty() +
            " patientAddressZipcode: " + getPatientAddressZipcode() +
            " patientAddressCountry: " + getPatientAddressCountry() +
            " patientAliasLastName: " + getPatientAliasLastName() +
            " patientAliasFirstName: " + getPatientAliasFirstName() +
            " patientAliasMiddleName: " + getPatientAliasMiddleName() +
            " patientAlias: " + getPatientAlias() +
            " patientSSN: " + getPatientSSN() +
            " patientRace: " + getPatientRace() +
            " patientCitizenship: " + getPatientCitizenship() +
            " maritalStatus: " + getMaritalStatus() +
            " patientEmail: " + getPatientEmail() +
            " patientHomePhone: " + getPatientHomePhone() +
            " patientWorkPhone: " + getPatientWorkPhone() +
            " patientFax: " + getPatientFax() +
            " patientMobile: " + getPatientMobile() +
            " patientOtherPhone: " + getPatientOtherPhone() +
            " patientNotificationPreference: " + getPatientNotificationPreference() +
            " patientEmployer: " + getPatientEmployer() +
            " patientEmployerStatus: " + getPatientEmployerStatus() +
            " patientEmployerPhone: " + getPatientEmployerPhone() +
            " patientStudentStatus: " + getPatientStudentStatus() +
            " patientSchool: " + getPatientSchool() +
            " patientNoticeOfPrivacy: " + getPatientNoticeOfPrivacy() +
            " patientDateOfPrivacy: " + getPatientDateOfPrivacy() +
            " patientDateOfDeath: " + getPatientDateOfDeath() +
            " patientCauseOfDeath: " + getPatientCauseOfDeath() +
            " patientEmergencyContactName: " + getPatientEmergencyContactName() +
            " patientEmergencyContactPhone: " + getPatientEmergencyContactPhone() +
            " patientPreferredLanguage: " + getPatientPreferredLanguage() +
            " patientSmokingStatus: " + getPatientSmokingStatus() +
            " patientEthnicity: " + getPatientEthnicity() +
            " patientBirthState: " + getPatientBirthState() +
            " patientBirthCountry: " + getPatientBirthCountry() +
            " patientBirthOrder: " + getPatientBirthOrder() +
            " patientMothersLastName: " + getPatientMothersLastName() +
            " patientMothersFirstName: " + getPatientMothersFirstName() +
            " patientMothersMiddleName: " + getPatientMothersMiddleName() +
            " patientMothersMaidenName: " + getPatientMothersMaidenName() +
            " institutionName: " + getInstitutionName() +
            " accessionNumber: " + getAccessionNumber() +
            " cPTCode: " + getCPTCode() +
            " cPTMnemonic: " + getCPTMnemonic() +
            " modality: " + getModality() +
            " studyDescription: " + getStudyDescription() +
            " pregnant: " + getPregnant() +
            " vipIndicator: " + getVipIndicator() +
            " admitDate: " + getAdmitDate() +
            " admissionType: " + getAdmissionType() +
            " patientLocationBed: " + getPatientLocationBed() +
            " patientLocationBuilding: " + getPatientLocationBuilding() +
            " patientLocationFacility: " + getPatientLocationFacility() +
            " patientLocationFloor: " + getPatientLocationFloor() +
            " patientLocationDescription: " + getPatientLocationDescription() +
            " patientLocationAssigningAuthority: " + getPatientLocationAssigningAuthority() +
            " patientLocationComprehensiveDescription: " + getPatientLocationComprehensiveDescription() +
            " patientLocationStatus: " + getPatientLocationStatus() +
            " patientLocationType: " + getPatientLocationType() +
            " patientStation: " + getPatientStation() +
            " patientClass: " + getPatientClass() +
            " referringDoctorLastName: " + getReferringDoctorLastName() +
            " referringDoctorFirstName: " + getReferringDoctorFirstName() +
            " referringDoctorDegree: " + getReferringDoctorDegree() +
            " referringDoctorFullName: " + getReferringDoctorFullName() +
            " orderingDoctorLastName: " + getOrderingDoctorLastName() +
            " orderingDoctorFirstName: " + getOrderingDoctorFirstName() +
            " orderingDoctorDegree: " + getOrderingDoctorDegree() +
            " orderingDoctorFullName: " + getOrderingDoctorFullName() +
            " orderNumber: " + getOrderNumber() +
            " sendingFacility: " + getSendingFacility() +
            " techName: " + getTechName() +
            " authorizationNumber: " + getAuthorizationNumber() +
            " numberOfFilms: " + getNumberOfFilms() +
            " filmType: " + getFilmType() +
            " effectiveDate: " + getEffectiveDate() +
            " findings: " + getFindings() +
            " approvalDate: " + getApprovalDate() +
            " deliveryDate: " + getDeliveryDate() +
            " modifiers: " + getModifiers() +
            " diagnosisCode: " + getDiagnosisCode() +
            " reportId: " + getReportId() +
            " hl7: " + getHl7() +
            " coPayAmount: " + getCoPayAmount() +
            " feeAmount: " + getFeeAmount() +
            " allowableAmount: " + getAllowableAmount() +
            " visitNumber: " + getVisitNumber() +
            " deductibleAmount: " + getDeductibleAmount() +
            " loggedAmount: " + getLoggedAmount() +
            " cardChequeNumber: " + getCardChequeNumber() +
            " externalVisitId: " + getExternalVisitId() +
            " paymentMethod: " + getPaymentMethod() +
            " expiryDate: " + getExpiryDate() +
            " hospitalService: " + getHospitalService() +
            " procedureStartDate: " + getProcedureStartDate() +
            " reasonForExam: " + getReasonForExam() +
            " priority: " + getPriority() +
            " procedureCode: " + getProcedureCode() +
            " procedureCodeScheme: " + getProcedureCodeScheme() +
            " orderStatus: " + getOrderStatus() +
            " laterality: " + getLaterality() +
            " principalResultInterpreter: " + getPrincipalResultInterpreter() +
            " responsibleObserver: " + getResponsibleObserver() +
            " relevantClinicalInformation: " + getRelevantClinicalInformation() +
            " physicians: " + getPhysicians() +
            " followUpCode: " + getFollowUpCode() +
            " guarantorName: " + getGuarantorName() +
            " guarantorAddress: " + getGuarantorAddress() +
            " guarantorPhone: " + getGuarantorPhone() +
            " guarantorDOB: " + getGuarantorDOB() +
            " serviceType: " + getServiceType() +
            " dateOfService: " + getDateOfService() +
            " transportType: " + getTransportType() +
            " inpatientLocation: " + getInpatientLocation() +
            " room: " + getRoom() +
            " iV: " + isIV() +
            " o2: " + isO2() +
            " monitor: " + isMonitor() +
            " dischargeDate: " + getDischargeDate() +
            " insuredName: " + getInsuredName() +
            " relationship: " + getRelationship() +
            " releaseSigned: " + isReleaseSigned() +
            " coPay: " + getCoPay() +
            " deductible: " + getDeductible() +
            " dateSigned: " + getDateSigned() +
            " coInsurance: " + getCoInsurance() +
            " patientInsurances: " + getPatientInsurances() +
            " visitInsurances: " + getVisitInsurances() +
            " allergies: " + getAllergies() +
            " referrals: " + getReferrals() +
            " medications: " + getMedications() +
            " report: " + getReport() +
            " updatedBy: " + getUpdatedBy() +
            " updateTime: " + getUpdateTime() +
            " techNotes: " + getTechNotes() +
            " critical: " + isCritical() +
            " studyDate: " + getStudyDate() +
            " studyTime: " + getStudyTime() +
            " arrivalDate: " + getArrivalDate() +
            " arrivalTime: " + getArrivalTime() +
            " additionalAccessions: " + getAdditionalAccessions() +
            " urgentExamType: " + getUrgentExamType() +
            " readingRadiologist: " + getReadingRadiologist() + ")";
    }

    @NotNull
    public DetailedOrderBuilder toBuilder()
    {
        return new DetailedOrderBuilder(getOrderId(),
                                        getStatus(),
                                        getOrderPriority(),
                                        getAssignedTo()).setDicomStudyId(getDicomStudyId())
                                                         .setPatientFirstName(getPatientFirstName())
                                                         .setPatientMiddleName(getPatientMiddleName())
                                                         .setPatientLastName(getPatientLastName())
                                                         .setPatientId(getPatientId())
                                                         .setPatientBirthDate(getPatientBirthDate())
                                                         .setPatientAge(getPatientAge())
                                                         .setPatientSex(getPatientSex())
                                                         .setPatientSuffix(getPatientSuffix())
                                                         .setAlternatePatientId(getAlternatePatientId())
                                                         .setPatientAccountNumber(getPatientAccountNumber())
                                                         .setPatientAddressee(getPatientAddressee())
                                                         .setPatientAddressType(getPatientAddressType())
                                                         .setPatientStreetAddress(getPatientStreetAddress())
                                                         .setPatientStreetName(getPatientStreetName())
                                                         .setPatientAddressBuildingNumber(getPatientAddressBuildingNumber())
                                                         .setPatientAddressCity(getPatientAddressCity())
                                                         .setPatientAddressState(getPatientAddressState())
                                                         .setPatientAddressCounty(getPatientAddressCounty())
                                                         .setPatientAddressZipcode(getPatientAddressZipcode())
                                                         .setPatientAddressCountry(getPatientAddressCountry())
                                                         .setPatientAliasLastName(getPatientAliasLastName())
                                                         .setPatientAliasFirstName(getPatientAliasFirstName())
                                                         .setPatientAliasMiddleName(getPatientAliasMiddleName())
                                                         .setPatientAlias(getPatientAlias())
                                                         .setPatientSSN(getPatientSSN())
                                                         .setPatientRace(getPatientRace())
                                                         .setPatientCitizenship(getPatientCitizenship())
                                                         .setMaritalStatus(getMaritalStatus())
                                                         .setPatientEmail(getPatientEmail())
                                                         .setPatientHomePhone(getPatientHomePhone())
                                                         .setPatientWorkPhone(getPatientWorkPhone())
                                                         .setPatientFax(getPatientFax())
                                                         .setPatientMobile(getPatientMobile())
                                                         .setPatientOtherPhone(getPatientOtherPhone())
                                                         .setPatientNotificationPreference(getPatientNotificationPreference())
                                                         .setPatientEmployer(getPatientEmployer())
                                                         .setPatientEmployerStatus(getPatientEmployerStatus())
                                                         .setPatientEmployerPhone(getPatientEmployerPhone())
                                                         .setPatientStudentStatus(getPatientStudentStatus())
                                                         .setPatientSchool(getPatientSchool())
                                                         .setPatientNoticeOfPrivacy(getPatientNoticeOfPrivacy())
                                                         .setPatientDateOfPrivacy(getPatientDateOfPrivacy())
                                                         .setPatientDateOfDeath(getPatientDateOfDeath())
                                                         .setPatientCauseOfDeath(getPatientCauseOfDeath())
                                                         .setPatientEmergencyContactName(getPatientEmergencyContactName())
                                                         .setPatientEmergencyContactPhone(getPatientEmergencyContactPhone())
                                                         .setPatientPreferredLanguage(getPatientPreferredLanguage())
                                                         .setPatientSmokingStatus(getPatientSmokingStatus())
                                                         .setPatientEthnicity(getPatientEthnicity())
                                                         .setPatientBirthState(getPatientBirthState())
                                                         .setPatientBirthCountry(getPatientBirthCountry())
                                                         .setPatientBirthOrder(getPatientBirthOrder())
                                                         .setPatientMothersLastName(getPatientMothersLastName())
                                                         .setPatientMothersFirstName(getPatientMothersFirstName())
                                                         .setPatientMothersMiddleName(getPatientMothersMiddleName())
                                                         .setPatientMothersMaidenName(getPatientMothersMaidenName())
                                                         .setInstitutionName(getInstitutionName())
                                                         .setAccessionNumber(getAccessionNumber())
                                                         .setCPTCode(getCPTCode())
                                                         .setCPTMnemonic(getCPTMnemonic())
                                                         .setModality(getModality())
                                                         .setStudyDescription(getStudyDescription())
                                                         .setPregnant(getPregnant())
                                                         .setVipIndicator(getVipIndicator())
                                                         .setAdmitDate(getAdmitDate())
                                                         .setAdmissionType(getAdmissionType())
                                                         .setPatientLocationBed(getPatientLocationBed())
                                                         .setPatientLocationBuilding(getPatientLocationBuilding())
                                                         .setPatientLocationFacility(getPatientLocationFacility())
                                                         .setPatientLocationFloor(getPatientLocationFloor())
                                                         .setPatientLocationDescription(getPatientLocationDescription())
                                                         .setPatientLocationAssigningAuthority(getPatientLocationAssigningAuthority())
                                                         .setPatientLocationComprehensiveDescription(getPatientLocationComprehensiveDescription())
                                                         .setPatientLocationStatus(getPatientLocationStatus())
                                                         .setPatientLocationType(getPatientLocationType())
                                                         .setPatientStation(getPatientStation())
                                                         .setPatientClass(getPatientClass())
                                                         .setReferringDoctorLastName(getReferringDoctorLastName())
                                                         .setReferringDoctorFirstName(getReferringDoctorFirstName())
                                                         .setReferringDoctorDegree(getReferringDoctorDegree())
                                                         .setReferringDoctorFullName(getReferringDoctorFullName())
                                                         .setOrderingDoctorLastName(getOrderingDoctorLastName())
                                                         .setOrderingDoctorFirstName(getOrderingDoctorFirstName())
                                                         .setOrderingDoctorDegree(getOrderingDoctorDegree())
                                                         .setOrderingDoctorFullName(getOrderingDoctorFullName())
                                                         .setOrderNumber(getOrderNumber())
                                                         .setSendingFacility(getSendingFacility())
                                                         .setTechName(getTechName())
                                                         .setAuthorizationNumber(getAuthorizationNumber())
                                                         .setNumberOfFilms(getNumberOfFilms())
                                                         .setFilmType(getFilmType())
                                                         .setEffectiveDate(getEffectiveDate())
                                                         .setFindings(getFindings())
                                                         .setApprovalDate(getApprovalDate())
                                                         .setDeliveryDate(getDeliveryDate())
                                                         .setModifiers(getModifiers())
                                                         .setDiagnosisCode(getDiagnosisCode())
                                                         .setReportId(getReportId())
                                                         .setHl7(getHl7())
                                                         .setCoPayAmount(getCoPayAmount())
                                                         .setFeeAmount(getFeeAmount())
                                                         .setAllowableAmount(getAllowableAmount())
                                                         .setVisitNumber(getVisitNumber())
                                                         .setDeductibleAmount(getDeductibleAmount())
                                                         .setLoggedAmount(getLoggedAmount())
                                                         .setCardChequeNumber(getCardChequeNumber())
                                                         .setExternalVisitId(getExternalVisitId())
                                                         .setPaymentMethod(getPaymentMethod())
                                                         .setExpiryDate(getExpiryDate())
                                                         .setHospitalService(getHospitalService())
                                                         .setProcedureStartDate(getProcedureStartDate())
                                                         .setReasonForExam(getReasonForExam())
                                                         .setPriority(getPriority())
                                                         .setProcedureCode(getProcedureCode())
                                                         .setProcedureCodeScheme(getProcedureCodeScheme())
                                                         .setOrderStatus(getOrderStatus())
                                                         .setLaterality(getLaterality())
                                                         .setPrincipalResultInterpreter(getPrincipalResultInterpreter())
                                                         .setResponsibleObserver(getResponsibleObserver())
                                                         .setRelevantClinicalInformation(getRelevantClinicalInformation())
                                                         .setPhysicians(getPhysicians())
                                                         .setFollowUpCode(getFollowUpCode())
                                                         .setGuarantorName(getGuarantorName())
                                                         .setGuarantorAddress(getGuarantorAddress())
                                                         .setGuarantorPhone(getGuarantorPhone())
                                                         .setGuarantorDOB(getGuarantorDOB())
                                                         .setServiceType(getServiceType())
                                                         .setDateOfService(getDateOfService())
                                                         .setTransportType(getTransportType())
                                                         .setInpatientLocation(getInpatientLocation())
                                                         .setRoom(getRoom())
                                                         .setIV(isIV())
                                                         .setO2(isO2())
                                                         .setMonitor(isMonitor())
                                                         .setDischargeDate(getDischargeDate())
                                                         .setInsuredName(getInsuredName())
                                                         .setRelationship(getRelationship())
                                                         .setReleaseSigned(isReleaseSigned())
                                                         .setCoPay(getCoPay())
                                                         .setDeductible(getDeductible())
                                                         .setDateSigned(getDateSigned())
                                                         .setCoInsurance(getCoInsurance())
                                                         .setPatientInsurances(getPatientInsurances())
                                                         .setVisitInsurances(getVisitInsurances())
                                                         .setAllergies(getAllergies())
                                                         .setReferrals(getReferrals())
                                                         .setMedications(getMedications())
                                                         .setReport(getReport())
                                                         .setUpdatedBy(getUpdatedBy())
                                                         .setUpdateTime(getUpdateTime())
                                                         .setTechNotes(getTechNotes())
                                                         .setCritical(isCritical())
                                                         .setStudyDate(getStudyDate())
                                                         .setStudyTime(getStudyTime())
                                                         .setArrivalDate(getArrivalDate())
                                                         .setArrivalTime(getArrivalTime())
                                                         .setAdditionalAccessions(getAdditionalAccessions())
                                                         .setUrgentExamType(getUrgentExamType())
                                                         .setReadingRadiologist(getReadingRadiologist());
    }
}