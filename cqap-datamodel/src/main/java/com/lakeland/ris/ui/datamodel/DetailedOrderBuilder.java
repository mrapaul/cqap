package com.lakeland.ris.ui.datamodel;

import org.jetbrains.annotations.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;
import java.util.*;

public class DetailedOrderBuilder
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

    public DetailedOrderBuilder(@NotNull String orderId,
                                @NotNull OrderStatus status,
                                @NotNull OrderPriority orderPriority,
                                @NotNull String assignedTo)
    {
        super();

        this.orderId = orderId;
        this.status = status;
        this.orderPriority = orderPriority;
        this.assignedTo = assignedTo;
    }


    @NotNull
    public DetailedOrderBuilder setOrderId(@NotNull String orderId)
    {
        this.orderId = orderId;

        return self();
    }

    @NotNull
    public DetailedOrderBuilder setStatus(@NotNull OrderStatus status)
    {
        this.status = status;

        return self();
    }

    @NotNull
    public DetailedOrderBuilder setOrderPriority(@NotNull OrderPriority orderPriority)
    {
        this.orderPriority = orderPriority;

        return self();
    }

    @NotNull
    public DetailedOrderBuilder setAssignedTo(@NotNull String assignedTo)
    {
        this.assignedTo = assignedTo;

        return self();
    }

    @NotNull
    public DetailedOrderBuilder setDicomStudyId(@Nullable String dicomStudyId)
    {
        this.dicomStudyId = dicomStudyId;

        return self();
    }

    @NotNull
    public DetailedOrderBuilder setPatientFirstName(@Nullable String patientFirstName)
    {
        this.patientFirstName = patientFirstName;

        return self();
    }

    @NotNull
    public DetailedOrderBuilder setPatientMiddleName(@Nullable String patientMiddleName)
    {
        this.patientMiddleName = patientMiddleName;

        return self();
    }

    @NotNull
    public DetailedOrderBuilder setPatientLastName(@Nullable String patientLastName)
    {
        this.patientLastName = patientLastName;

        return self();
    }

    @NotNull
    public DetailedOrderBuilder setPatientId(@Nullable String patientId)
    {
        this.patientId = patientId;

        return self();
    }

    @NotNull
    public DetailedOrderBuilder setPatientBirthDate(@Nullable Date patientBirthDate)
    {
        this.patientBirthDate = patientBirthDate;

        return self();
    }

    @NotNull
    public DetailedOrderBuilder setPatientAge(@Nullable String patientAge)
    {
        this.patientAge = patientAge;

        return self();
    }

    @NotNull
    public DetailedOrderBuilder setPatientSex(@Nullable String patientSex)
    {
        this.patientSex = patientSex;

        return self();
    }

    @NotNull
    public DetailedOrderBuilder setPatientSuffix(@Nullable String patientSuffix)
    {
        this.patientSuffix = patientSuffix;

        return self();
    }

    @NotNull
    public DetailedOrderBuilder setAlternatePatientId(@Nullable String alternatePatientId)
    {
        this.alternatePatientId = alternatePatientId;

        return self();
    }

    @NotNull
    public DetailedOrderBuilder setPatientAccountNumber(@Nullable String patientAccountNumber)
    {
        this.patientAccountNumber = patientAccountNumber;

        return self();
    }

    @NotNull
    public DetailedOrderBuilder setPatientAddressee(@Nullable String patientAddressee)
    {
        this.patientAddressee = patientAddressee;

        return self();
    }

    @NotNull
    public DetailedOrderBuilder setPatientAddressType(@Nullable String patientAddressType)
    {
        this.patientAddressType = patientAddressType;

        return self();
    }

    @NotNull
    public DetailedOrderBuilder setPatientStreetAddress(@Nullable String patientStreetAddress)
    {
        this.patientStreetAddress = patientStreetAddress;

        return self();
    }

    @NotNull
    public DetailedOrderBuilder setPatientStreetName(@Nullable String patientStreetName)
    {
        this.patientStreetName = patientStreetName;

        return self();
    }

    @NotNull
    public DetailedOrderBuilder setPatientAddressBuildingNumber(@Nullable String patientAddressBuildingNumber)
    {
        this.patientAddressBuildingNumber = patientAddressBuildingNumber;

        return self();
    }

    @NotNull
    public DetailedOrderBuilder setPatientAddressCity(@Nullable String patientAddressCity)
    {
        this.patientAddressCity = patientAddressCity;

        return self();
    }

    @NotNull
    public DetailedOrderBuilder setPatientAddressState(@Nullable String patientAddressState)
    {
        this.patientAddressState = patientAddressState;

        return self();
    }

    @NotNull
    public DetailedOrderBuilder setPatientAddressCounty(@Nullable String patientAddressCounty)
    {
        this.patientAddressCounty = patientAddressCounty;

        return self();
    }

    @NotNull
    public DetailedOrderBuilder setPatientAddressZipcode(@Nullable String patientAddressZipcode)
    {
        this.patientAddressZipcode = patientAddressZipcode;

        return self();
    }

    @NotNull
    public DetailedOrderBuilder setPatientAddressCountry(@Nullable String patientAddressCountry)
    {
        this.patientAddressCountry = patientAddressCountry;

        return self();
    }

    @NotNull
    public DetailedOrderBuilder setPatientAliasLastName(@Nullable String patientAliasLastName)
    {
        this.patientAliasLastName = patientAliasLastName;

        return self();
    }

    @NotNull
    public DetailedOrderBuilder setPatientAliasFirstName(@Nullable String patientAliasFirstName)
    {
        this.patientAliasFirstName = patientAliasFirstName;

        return self();
    }

    @NotNull
    public DetailedOrderBuilder setPatientAliasMiddleName(@Nullable String patientAliasMiddleName)
    {
        this.patientAliasMiddleName = patientAliasMiddleName;

        return self();
    }

    @NotNull
    public DetailedOrderBuilder setPatientAlias(@Nullable String patientAlias)
    {
        this.patientAlias = patientAlias;

        return self();
    }

    @NotNull
    public DetailedOrderBuilder setPatientSSN(@Nullable String patientSSN)
    {
        this.patientSSN = patientSSN;

        return self();
    }

    @NotNull
    public DetailedOrderBuilder setPatientRace(@Nullable String patientRace)
    {
        this.patientRace = patientRace;

        return self();
    }

    @NotNull
    public DetailedOrderBuilder setPatientCitizenship(@Nullable String patientCitizenship)
    {
        this.patientCitizenship = patientCitizenship;

        return self();
    }

    @NotNull
    public DetailedOrderBuilder setMaritalStatus(@Nullable String maritalStatus)
    {
        this.maritalStatus = maritalStatus;

        return self();
    }

    @NotNull
    public DetailedOrderBuilder setPatientEmail(@Nullable String patientEmail)
    {
        this.patientEmail = patientEmail;

        return self();
    }

    @NotNull
    public DetailedOrderBuilder setPatientHomePhone(@Nullable String patientHomePhone)
    {
        this.patientHomePhone = patientHomePhone;

        return self();
    }

    @NotNull
    public DetailedOrderBuilder setPatientWorkPhone(@Nullable String patientWorkPhone)
    {
        this.patientWorkPhone = patientWorkPhone;

        return self();
    }

    @NotNull
    public DetailedOrderBuilder setPatientFax(@Nullable String patientFax)
    {
        this.patientFax = patientFax;

        return self();
    }

    @NotNull
    public DetailedOrderBuilder setPatientMobile(@Nullable String patientMobile)
    {
        this.patientMobile = patientMobile;

        return self();
    }

    @NotNull
    public DetailedOrderBuilder setPatientOtherPhone(@Nullable String patientOtherPhone)
    {
        this.patientOtherPhone = patientOtherPhone;

        return self();
    }

    @NotNull
    public DetailedOrderBuilder setPatientNotificationPreference(@Nullable String patientNotificationPreference)
    {
        this.patientNotificationPreference = patientNotificationPreference;

        return self();
    }

    @NotNull
    public DetailedOrderBuilder setPatientEmployer(@Nullable String patientEmployer)
    {
        this.patientEmployer = patientEmployer;

        return self();
    }

    @NotNull
    public DetailedOrderBuilder setPatientEmployerStatus(@Nullable String patientEmployerStatus)
    {
        this.patientEmployerStatus = patientEmployerStatus;

        return self();
    }

    @NotNull
    public DetailedOrderBuilder setPatientEmployerPhone(@Nullable String patientEmployerPhone)
    {
        this.patientEmployerPhone = patientEmployerPhone;

        return self();
    }

    @NotNull
    public DetailedOrderBuilder setPatientStudentStatus(@Nullable String patientStudentStatus)
    {
        this.patientStudentStatus = patientStudentStatus;

        return self();
    }

    @NotNull
    public DetailedOrderBuilder setPatientSchool(@Nullable String patientSchool)
    {
        this.patientSchool = patientSchool;

        return self();
    }

    @NotNull
    public DetailedOrderBuilder setPatientNoticeOfPrivacy(@Nullable String patientNoticeOfPrivacy)
    {
        this.patientNoticeOfPrivacy = patientNoticeOfPrivacy;

        return self();
    }

    @NotNull
    public DetailedOrderBuilder setPatientDateOfPrivacy(@Nullable Date patientDateOfPrivacy)
    {
        this.patientDateOfPrivacy = patientDateOfPrivacy;

        return self();
    }

    @NotNull
    public DetailedOrderBuilder setPatientDateOfDeath(@Nullable Date patientDateOfDeath)
    {
        this.patientDateOfDeath = patientDateOfDeath;

        return self();
    }

    @NotNull
    public DetailedOrderBuilder setPatientCauseOfDeath(@Nullable String patientCauseOfDeath)
    {
        this.patientCauseOfDeath = patientCauseOfDeath;

        return self();
    }

    @NotNull
    public DetailedOrderBuilder setPatientEmergencyContactName(@Nullable String patientEmergencyContactName)
    {
        this.patientEmergencyContactName = patientEmergencyContactName;

        return self();
    }

    @NotNull
    public DetailedOrderBuilder setPatientEmergencyContactPhone(@Nullable String patientEmergencyContactPhone)
    {
        this.patientEmergencyContactPhone = patientEmergencyContactPhone;

        return self();
    }

    @NotNull
    public DetailedOrderBuilder setPatientPreferredLanguage(@Nullable String patientPreferredLanguage)
    {
        this.patientPreferredLanguage = patientPreferredLanguage;

        return self();
    }

    @NotNull
    public DetailedOrderBuilder setPatientSmokingStatus(@Nullable String patientSmokingStatus)
    {
        this.patientSmokingStatus = patientSmokingStatus;

        return self();
    }

    @NotNull
    public DetailedOrderBuilder setPatientEthnicity(@Nullable String patientEthnicity)
    {
        this.patientEthnicity = patientEthnicity;

        return self();
    }

    @NotNull
    public DetailedOrderBuilder setPatientBirthState(@Nullable String patientBirthState)
    {
        this.patientBirthState = patientBirthState;

        return self();
    }

    @NotNull
    public DetailedOrderBuilder setPatientBirthCountry(@Nullable String patientBirthCountry)
    {
        this.patientBirthCountry = patientBirthCountry;

        return self();
    }

    @NotNull
    public DetailedOrderBuilder setPatientBirthOrder(@Nullable String patientBirthOrder)
    {
        this.patientBirthOrder = patientBirthOrder;

        return self();
    }

    @NotNull
    public DetailedOrderBuilder setPatientMothersLastName(@Nullable String patientMothersLastName)
    {
        this.patientMothersLastName = patientMothersLastName;

        return self();
    }

    @NotNull
    public DetailedOrderBuilder setPatientMothersFirstName(@Nullable String patientMothersFirstName)
    {
        this.patientMothersFirstName = patientMothersFirstName;

        return self();
    }

    @NotNull
    public DetailedOrderBuilder setPatientMothersMiddleName(@Nullable String patientMothersMiddleName)
    {
        this.patientMothersMiddleName = patientMothersMiddleName;

        return self();
    }

    @NotNull
    public DetailedOrderBuilder setPatientMothersMaidenName(@Nullable String patientMothersMaidenName)
    {
        this.patientMothersMaidenName = patientMothersMaidenName;

        return self();
    }

    @NotNull
    public DetailedOrderBuilder setInstitutionName(@Nullable String institutionName)
    {
        this.institutionName = institutionName;

        return self();
    }

    @NotNull
    public DetailedOrderBuilder setAccessionNumber(@Nullable String accessionNumber)
    {
        this.accessionNumber = accessionNumber;

        return self();
    }

    @NotNull
    public DetailedOrderBuilder setCPTCode(@Nullable String cPTCode)
    {
        this.cPTCode = cPTCode;

        return self();
    }

    @NotNull
    public DetailedOrderBuilder setCPTMnemonic(@Nullable String cPTMnemonic)
    {
        this.cPTMnemonic = cPTMnemonic;

        return self();
    }

    @NotNull
    public DetailedOrderBuilder setModality(@Nullable String modality)
    {
        this.modality = modality;

        return self();
    }

    @NotNull
    public DetailedOrderBuilder setStudyDescription(@Nullable String studyDescription)
    {
        this.studyDescription = studyDescription;

        return self();
    }

    @NotNull
    public DetailedOrderBuilder setPregnant(@Nullable String pregnant)
    {
        this.pregnant = pregnant;

        return self();
    }

    @NotNull
    public DetailedOrderBuilder setVipIndicator(@Nullable String vipIndicator)
    {
        this.vipIndicator = vipIndicator;

        return self();
    }

    @NotNull
    public DetailedOrderBuilder setAdmitDate(@Nullable Date admitDate)
    {
        this.admitDate = admitDate;

        return self();
    }

    @NotNull
    public DetailedOrderBuilder setAdmissionType(@Nullable String admissionType)
    {
        this.admissionType = admissionType;

        return self();
    }

    @NotNull
    public DetailedOrderBuilder setPatientLocationBed(@Nullable String patientLocationBed)
    {
        this.patientLocationBed = patientLocationBed;

        return self();
    }

    @NotNull
    public DetailedOrderBuilder setPatientLocationBuilding(@Nullable String patientLocationBuilding)
    {
        this.patientLocationBuilding = patientLocationBuilding;

        return self();
    }

    @NotNull
    public DetailedOrderBuilder setPatientLocationFacility(@Nullable String patientLocationFacility)
    {
        this.patientLocationFacility = patientLocationFacility;

        return self();
    }

    @NotNull
    public DetailedOrderBuilder setPatientLocationFloor(@Nullable String patientLocationFloor)
    {
        this.patientLocationFloor = patientLocationFloor;

        return self();
    }

    @NotNull
    public DetailedOrderBuilder setPatientLocationDescription(@Nullable String patientLocationDescription)
    {
        this.patientLocationDescription = patientLocationDescription;

        return self();
    }

    @NotNull
    public DetailedOrderBuilder setPatientLocationAssigningAuthority(@Nullable String patientLocationAssigningAuthority)
    {
        this.patientLocationAssigningAuthority = patientLocationAssigningAuthority;

        return self();
    }

    @NotNull
    public DetailedOrderBuilder setPatientLocationComprehensiveDescription(@Nullable String patientLocationComprehensiveDescription)
    {
        this.patientLocationComprehensiveDescription = patientLocationComprehensiveDescription;

        return self();
    }

    @NotNull
    public DetailedOrderBuilder setPatientLocationStatus(@Nullable String patientLocationStatus)
    {
        this.patientLocationStatus = patientLocationStatus;

        return self();
    }

    @NotNull
    public DetailedOrderBuilder setPatientLocationType(@Nullable String patientLocationType)
    {
        this.patientLocationType = patientLocationType;

        return self();
    }

    @NotNull
    public DetailedOrderBuilder setPatientStation(@Nullable String patientStation)
    {
        this.patientStation = patientStation;

        return self();
    }

    @NotNull
    public DetailedOrderBuilder setPatientClass(@Nullable String patientClass)
    {
        this.patientClass = patientClass;

        return self();
    }

    @NotNull
    public DetailedOrderBuilder setReferringDoctorLastName(@Nullable String referringDoctorLastName)
    {
        this.referringDoctorLastName = referringDoctorLastName;

        return self();
    }

    @NotNull
    public DetailedOrderBuilder setReferringDoctorFirstName(@Nullable String referringDoctorFirstName)
    {
        this.referringDoctorFirstName = referringDoctorFirstName;

        return self();
    }

    @NotNull
    public DetailedOrderBuilder setReferringDoctorDegree(@Nullable String referringDoctorDegree)
    {
        this.referringDoctorDegree = referringDoctorDegree;

        return self();
    }

    @NotNull
    public DetailedOrderBuilder setReferringDoctorFullName(@Nullable String referringDoctorFullName)
    {
        this.referringDoctorFullName = referringDoctorFullName;

        return self();
    }

    @NotNull
    public DetailedOrderBuilder setOrderingDoctorLastName(@Nullable String orderingDoctorLastName)
    {
        this.orderingDoctorLastName = orderingDoctorLastName;

        return self();
    }

    @NotNull
    public DetailedOrderBuilder setOrderingDoctorFirstName(@Nullable String orderingDoctorFirstName)
    {
        this.orderingDoctorFirstName = orderingDoctorFirstName;

        return self();
    }

    @NotNull
    public DetailedOrderBuilder setOrderingDoctorDegree(@Nullable String orderingDoctorDegree)
    {
        this.orderingDoctorDegree = orderingDoctorDegree;

        return self();
    }

    @NotNull
    public DetailedOrderBuilder setOrderingDoctorFullName(@Nullable String orderingDoctorFullName)
    {
        this.orderingDoctorFullName = orderingDoctorFullName;

        return self();
    }

    @NotNull
    public DetailedOrderBuilder setOrderNumber(@Nullable String orderNumber)
    {
        this.orderNumber = orderNumber;

        return self();
    }

    @NotNull
    public DetailedOrderBuilder setSendingFacility(@Nullable String sendingFacility)
    {
        this.sendingFacility = sendingFacility;

        return self();
    }

    @NotNull
    public DetailedOrderBuilder setTechName(@Nullable String techName)
    {
        this.techName = techName;

        return self();
    }

    @NotNull
    public DetailedOrderBuilder setAuthorizationNumber(@Nullable String authorizationNumber)
    {
        this.authorizationNumber = authorizationNumber;

        return self();
    }

    @NotNull
    public DetailedOrderBuilder setNumberOfFilms(@Nullable String numberOfFilms)
    {
        this.numberOfFilms = numberOfFilms;

        return self();
    }

    @NotNull
    public DetailedOrderBuilder setFilmType(@Nullable String filmType)
    {
        this.filmType = filmType;

        return self();
    }

    @NotNull
    public DetailedOrderBuilder setEffectiveDate(@Nullable Date effectiveDate)
    {
        this.effectiveDate = effectiveDate;

        return self();
    }

    @NotNull
    public DetailedOrderBuilder setFindings(@Nullable String findings)
    {
        this.findings = findings;

        return self();
    }

    @NotNull
    public DetailedOrderBuilder setApprovalDate(@Nullable String approvalDate)
    {
        this.approvalDate = approvalDate;

        return self();
    }

    @NotNull
    public DetailedOrderBuilder setDeliveryDate(@Nullable String deliveryDate)
    {
        this.deliveryDate = deliveryDate;

        return self();
    }

    @NotNull
    public DetailedOrderBuilder setModifiers(@Nullable String modifiers)
    {
        this.modifiers = modifiers;

        return self();
    }

    @NotNull
    public DetailedOrderBuilder setDiagnosisCode(@Nullable String diagnosisCode)
    {
        this.diagnosisCode = diagnosisCode;

        return self();
    }

    @NotNull
    public DetailedOrderBuilder setReportId(@Nullable String reportId)
    {
        this.reportId = reportId;

        return self();
    }

    @NotNull
    public DetailedOrderBuilder setHl7(@Nullable String hl7)
    {
        this.hl7 = hl7;

        return self();
    }

    @NotNull
    public DetailedOrderBuilder setCoPayAmount(@Nullable String coPayAmount)
    {
        this.coPayAmount = coPayAmount;

        return self();
    }

    @NotNull
    public DetailedOrderBuilder setFeeAmount(@Nullable String feeAmount)
    {
        this.feeAmount = feeAmount;

        return self();
    }

    @NotNull
    public DetailedOrderBuilder setAllowableAmount(@Nullable String allowableAmount)
    {
        this.allowableAmount = allowableAmount;

        return self();
    }

    @NotNull
    public DetailedOrderBuilder setVisitNumber(@Nullable String visitNumber)
    {
        this.visitNumber = visitNumber;

        return self();
    }

    @NotNull
    public DetailedOrderBuilder setDeductibleAmount(@Nullable String deductibleAmount)
    {
        this.deductibleAmount = deductibleAmount;

        return self();
    }

    @NotNull
    public DetailedOrderBuilder setLoggedAmount(@Nullable String loggedAmount)
    {
        this.loggedAmount = loggedAmount;

        return self();
    }

    @NotNull
    public DetailedOrderBuilder setCardChequeNumber(@Nullable String cardChequeNumber)
    {
        this.cardChequeNumber = cardChequeNumber;

        return self();
    }

    @NotNull
    public DetailedOrderBuilder setExternalVisitId(@Nullable String externalVisitId)
    {
        this.externalVisitId = externalVisitId;

        return self();
    }

    @NotNull
    public DetailedOrderBuilder setPaymentMethod(@Nullable String paymentMethod)
    {
        this.paymentMethod = paymentMethod;

        return self();
    }

    @NotNull
    public DetailedOrderBuilder setExpiryDate(@Nullable Date expiryDate)
    {
        this.expiryDate = expiryDate;

        return self();
    }

    @NotNull
    public DetailedOrderBuilder setHospitalService(@Nullable String hospitalService)
    {
        this.hospitalService = hospitalService;

        return self();
    }

    @NotNull
    public DetailedOrderBuilder setProcedureStartDate(@Nullable String procedureStartDate)
    {
        this.procedureStartDate = procedureStartDate;

        return self();
    }

    @NotNull
    public DetailedOrderBuilder setReasonForExam(@Nullable String reasonForExam)
    {
        this.reasonForExam = reasonForExam;

        return self();
    }

    @NotNull
    public DetailedOrderBuilder setPriority(@Nullable String priority)
    {
        this.priority = priority;

        return self();
    }

    @NotNull
    public DetailedOrderBuilder setProcedureCode(@Nullable String procedureCode)
    {
        this.procedureCode = procedureCode;

        return self();
    }

    @NotNull
    public DetailedOrderBuilder setProcedureCodeScheme(@Nullable String procedureCodeScheme)
    {
        this.procedureCodeScheme = procedureCodeScheme;

        return self();
    }

    @NotNull
    public DetailedOrderBuilder setOrderStatus(@Nullable String orderStatus)
    {
        this.orderStatus = orderStatus;

        return self();
    }

    @NotNull
    public DetailedOrderBuilder setLaterality(@Nullable String laterality)
    {
        this.laterality = laterality;

        return self();
    }

    @NotNull
    public DetailedOrderBuilder setPrincipalResultInterpreter(@Nullable String principalResultInterpreter)
    {
        this.principalResultInterpreter = principalResultInterpreter;

        return self();
    }

    @NotNull
    public DetailedOrderBuilder setResponsibleObserver(@Nullable String responsibleObserver)
    {
        this.responsibleObserver = responsibleObserver;

        return self();
    }

    @NotNull
    public DetailedOrderBuilder setRelevantClinicalInformation(@Nullable String relevantClinicalInformation)
    {
        this.relevantClinicalInformation = relevantClinicalInformation;

        return self();
    }

    @NotNull
    public DetailedOrderBuilder setPhysicians(@Nullable Collection<Physician> physicians)
    {
        this.physicians = physicians;

        return self();
    }

    @NotNull
    public DetailedOrderBuilder setFollowUpCode(@Nullable String followUpCode)
    {
        this.followUpCode = followUpCode;

        return self();
    }

    @NotNull
    public DetailedOrderBuilder setGuarantorName(@Nullable String guarantorName)
    {
        this.guarantorName = guarantorName;

        return self();
    }

    @NotNull
    public DetailedOrderBuilder setGuarantorAddress(@Nullable String guarantorAddress)
    {
        this.guarantorAddress = guarantorAddress;

        return self();
    }

    @NotNull
    public DetailedOrderBuilder setGuarantorPhone(@Nullable String guarantorPhone)
    {
        this.guarantorPhone = guarantorPhone;

        return self();
    }

    @NotNull
    public DetailedOrderBuilder setGuarantorDOB(@Nullable Date guarantorDOB)
    {
        this.guarantorDOB = guarantorDOB;

        return self();
    }

    @NotNull
    public DetailedOrderBuilder setServiceType(@Nullable String serviceType)
    {
        this.serviceType = serviceType;

        return self();
    }

    @NotNull
    public DetailedOrderBuilder setDateOfService(@Nullable Date dateOfService)
    {
        this.dateOfService = dateOfService;

        return self();
    }

    @NotNull
    public DetailedOrderBuilder setTransportType(@Nullable String transportType)
    {
        this.transportType = transportType;

        return self();
    }

    @NotNull
    public DetailedOrderBuilder setInpatientLocation(@Nullable String inpatientLocation)
    {
        this.inpatientLocation = inpatientLocation;

        return self();
    }

    @NotNull
    public DetailedOrderBuilder setRoom(@Nullable String room)
    {
        this.room = room;

        return self();
    }

    @NotNull
    public DetailedOrderBuilder setIV(boolean iV)
    {
        this.iV = iV;

        return self();
    }

    @NotNull
    public DetailedOrderBuilder setO2(boolean o2)
    {
        this.o2 = o2;

        return self();
    }

    @NotNull
    public DetailedOrderBuilder setMonitor(boolean monitor)
    {
        this.monitor = monitor;

        return self();
    }

    @NotNull
    public DetailedOrderBuilder setDischargeDate(@Nullable Date dischargeDate)
    {
        this.dischargeDate = dischargeDate;

        return self();
    }

    @NotNull
    public DetailedOrderBuilder setInsuredName(@Nullable String insuredName)
    {
        this.insuredName = insuredName;

        return self();
    }

    @NotNull
    public DetailedOrderBuilder setRelationship(@Nullable String relationship)
    {
        this.relationship = relationship;

        return self();
    }

    @NotNull
    public DetailedOrderBuilder setReleaseSigned(boolean releaseSigned)
    {
        this.releaseSigned = releaseSigned;

        return self();
    }

    @NotNull
    public DetailedOrderBuilder setCoPay(@Nullable String coPay)
    {
        this.coPay = coPay;

        return self();
    }

    @NotNull
    public DetailedOrderBuilder setDeductible(@Nullable String deductible)
    {
        this.deductible = deductible;

        return self();
    }

    @NotNull
    public DetailedOrderBuilder setDateSigned(@Nullable Date dateSigned)
    {
        this.dateSigned = dateSigned;

        return self();
    }

    @NotNull
    public DetailedOrderBuilder setCoInsurance(@Nullable String coInsurance)
    {
        this.coInsurance = coInsurance;

        return self();
    }

    @NotNull
    public DetailedOrderBuilder setPatientInsurances(@Nullable Collection<PatientInsurance> patientInsurances)
    {
        this.patientInsurances = patientInsurances;

        return self();
    }

    @NotNull
    public DetailedOrderBuilder setVisitInsurances(@Nullable Collection<VisitInsurance> visitInsurances)
    {
        this.visitInsurances = visitInsurances;

        return self();
    }

    @NotNull
    public DetailedOrderBuilder setAllergies(@Nullable Collection<Allergy> allergies)
    {
        this.allergies = allergies;

        return self();
    }

    @NotNull
    public DetailedOrderBuilder setReferrals(@Nullable Collection<Referral> referrals)
    {
        this.referrals = referrals;

        return self();
    }

    @NotNull
    public DetailedOrderBuilder setMedications(@Nullable Collection<Medication> medications)
    {
        this.medications = medications;

        return self();
    }

    @NotNull
    public DetailedOrderBuilder setReport(@Nullable OrderReport report)
    {
        this.report = report;

        return self();
    }

    @NotNull
    public DetailedOrderBuilder setUpdatedBy(@Nullable String updatedBy)
    {
        this.updatedBy = updatedBy;

        return self();
    }

    @NotNull
    public DetailedOrderBuilder setUpdateTime(@Nullable Date updateTime)
    {
        this.updateTime = updateTime;

        return self();
    }

    @NotNull
    public DetailedOrderBuilder setTechNotes(@Nullable String techNotes)
    {
        this.techNotes = techNotes;

        return self();
    }

    @NotNull
    public DetailedOrderBuilder setCritical(boolean critical)
    {
        this.critical = critical;

        return self();
    }

    @NotNull
    public DetailedOrderBuilder setStudyDate(@Nullable String studyDate)
    {
        this.studyDate = studyDate;

        return self();
    }

    @NotNull
    public DetailedOrderBuilder setStudyTime(@Nullable String studyTime)
    {
        this.studyTime = studyTime;

        return self();
    }

    @NotNull
    public DetailedOrderBuilder setArrivalDate(@Nullable String arrivalDate)
    {
        this.arrivalDate = arrivalDate;

        return self();
    }

    @NotNull
    public DetailedOrderBuilder setArrivalTime(@Nullable String arrivalTime)
    {
        this.arrivalTime = arrivalTime;

        return self();
    }

    @NotNull
    public DetailedOrderBuilder setAdditionalAccessions(@Nullable String additionalAccessions)
    {
        this.additionalAccessions = additionalAccessions;

        return self();
    }

    @NotNull
    public DetailedOrderBuilder setUrgentExamType(@Nullable UrgentExamType urgentExamType)
    {
        this.urgentExamType = urgentExamType;

        return self();
    }

    @NotNull
    public DetailedOrderBuilder setReadingRadiologist(@Nullable String readingRadiologist)
    {
        this.readingRadiologist = readingRadiologist;

        return self();
    }

    @NotNull
    protected String getOrderId()
    {
        return orderId;
    }

    @NotNull
    protected OrderStatus getStatus()
    {
        return status;
    }

    @NotNull
    protected OrderPriority getOrderPriority()
    {
        return orderPriority;
    }

    @NotNull
    protected String getAssignedTo()
    {
        return assignedTo;
    }

    @Nullable
    protected String getDicomStudyId()
    {
        return dicomStudyId;
    }

    @Nullable
    protected String getPatientFirstName()
    {
        return patientFirstName;
    }

    @Nullable
    protected String getPatientMiddleName()
    {
        return patientMiddleName;
    }

    @Nullable
    protected String getPatientLastName()
    {
        return patientLastName;
    }

    @Nullable
    protected String getPatientId()
    {
        return patientId;
    }

    @Nullable
    protected Date getPatientBirthDate()
    {
        return patientBirthDate;
    }

    @Nullable
    protected String getPatientAge()
    {
        return patientAge;
    }

    @Nullable
    protected String getPatientSex()
    {
        return patientSex;
    }

    @Nullable
    protected String getPatientSuffix()
    {
        return patientSuffix;
    }

    @Nullable
    protected String getAlternatePatientId()
    {
        return alternatePatientId;
    }

    @Nullable
    protected String getPatientAccountNumber()
    {
        return patientAccountNumber;
    }

    @Nullable
    protected String getPatientAddressee()
    {
        return patientAddressee;
    }

    @Nullable
    protected String getPatientAddressType()
    {
        return patientAddressType;
    }

    @Nullable
    protected String getPatientStreetAddress()
    {
        return patientStreetAddress;
    }

    @Nullable
    protected String getPatientStreetName()
    {
        return patientStreetName;
    }

    @Nullable
    protected String getPatientAddressBuildingNumber()
    {
        return patientAddressBuildingNumber;
    }

    @Nullable
    protected String getPatientAddressCity()
    {
        return patientAddressCity;
    }

    @Nullable
    protected String getPatientAddressState()
    {
        return patientAddressState;
    }

    @Nullable
    protected String getPatientAddressCounty()
    {
        return patientAddressCounty;
    }

    @Nullable
    protected String getPatientAddressZipcode()
    {
        return patientAddressZipcode;
    }

    @Nullable
    protected String getPatientAddressCountry()
    {
        return patientAddressCountry;
    }

    @Nullable
    protected String getPatientAliasLastName()
    {
        return patientAliasLastName;
    }

    @Nullable
    protected String getPatientAliasFirstName()
    {
        return patientAliasFirstName;
    }

    @Nullable
    protected String getPatientAliasMiddleName()
    {
        return patientAliasMiddleName;
    }

    @Nullable
    protected String getPatientAlias()
    {
        return patientAlias;
    }

    @Nullable
    protected String getPatientSSN()
    {
        return patientSSN;
    }

    @Nullable
    protected String getPatientRace()
    {
        return patientRace;
    }

    @Nullable
    protected String getPatientCitizenship()
    {
        return patientCitizenship;
    }

    @Nullable
    protected String getMaritalStatus()
    {
        return maritalStatus;
    }

    @Nullable
    protected String getPatientEmail()
    {
        return patientEmail;
    }

    @Nullable
    protected String getPatientHomePhone()
    {
        return patientHomePhone;
    }

    @Nullable
    protected String getPatientWorkPhone()
    {
        return patientWorkPhone;
    }

    @Nullable
    protected String getPatientFax()
    {
        return patientFax;
    }

    @Nullable
    protected String getPatientMobile()
    {
        return patientMobile;
    }

    @Nullable
    protected String getPatientOtherPhone()
    {
        return patientOtherPhone;
    }

    @Nullable
    protected String getPatientNotificationPreference()
    {
        return patientNotificationPreference;
    }

    @Nullable
    protected String getPatientEmployer()
    {
        return patientEmployer;
    }

    @Nullable
    protected String getPatientEmployerStatus()
    {
        return patientEmployerStatus;
    }

    @Nullable
    protected String getPatientEmployerPhone()
    {
        return patientEmployerPhone;
    }

    @Nullable
    protected String getPatientStudentStatus()
    {
        return patientStudentStatus;
    }

    @Nullable
    protected String getPatientSchool()
    {
        return patientSchool;
    }

    @Nullable
    protected String getPatientNoticeOfPrivacy()
    {
        return patientNoticeOfPrivacy;
    }

    @Nullable
    protected Date getPatientDateOfPrivacy()
    {
        return patientDateOfPrivacy;
    }

    @Nullable
    protected Date getPatientDateOfDeath()
    {
        return patientDateOfDeath;
    }

    @Nullable
    protected String getPatientCauseOfDeath()
    {
        return patientCauseOfDeath;
    }

    @Nullable
    protected String getPatientEmergencyContactName()
    {
        return patientEmergencyContactName;
    }

    @Nullable
    protected String getPatientEmergencyContactPhone()
    {
        return patientEmergencyContactPhone;
    }

    @Nullable
    protected String getPatientPreferredLanguage()
    {
        return patientPreferredLanguage;
    }

    @Nullable
    protected String getPatientSmokingStatus()
    {
        return patientSmokingStatus;
    }

    @Nullable
    protected String getPatientEthnicity()
    {
        return patientEthnicity;
    }

    @Nullable
    protected String getPatientBirthState()
    {
        return patientBirthState;
    }

    @Nullable
    protected String getPatientBirthCountry()
    {
        return patientBirthCountry;
    }

    @Nullable
    protected String getPatientBirthOrder()
    {
        return patientBirthOrder;
    }

    @Nullable
    protected String getPatientMothersLastName()
    {
        return patientMothersLastName;
    }

    @Nullable
    protected String getPatientMothersFirstName()
    {
        return patientMothersFirstName;
    }

    @Nullable
    protected String getPatientMothersMiddleName()
    {
        return patientMothersMiddleName;
    }

    @Nullable
    protected String getPatientMothersMaidenName()
    {
        return patientMothersMaidenName;
    }

    @Nullable
    protected String getInstitutionName()
    {
        return institutionName;
    }

    @Nullable
    protected String getAccessionNumber()
    {
        return accessionNumber;
    }

    @Nullable
    protected String getCPTCode()
    {
        return cPTCode;
    }

    @Nullable
    protected String getCPTMnemonic()
    {
        return cPTMnemonic;
    }

    @Nullable
    protected String getModality()
    {
        return modality;
    }

    @Nullable
    protected String getStudyDescription()
    {
        return studyDescription;
    }

    @Nullable
    protected String getPregnant()
    {
        return pregnant;
    }

    @Nullable
    protected String getVipIndicator()
    {
        return vipIndicator;
    }

    @Nullable
    protected Date getAdmitDate()
    {
        return admitDate;
    }

    @Nullable
    protected String getAdmissionType()
    {
        return admissionType;
    }

    @Nullable
    protected String getPatientLocationBed()
    {
        return patientLocationBed;
    }

    @Nullable
    protected String getPatientLocationBuilding()
    {
        return patientLocationBuilding;
    }

    @Nullable
    protected String getPatientLocationFacility()
    {
        return patientLocationFacility;
    }

    @Nullable
    protected String getPatientLocationFloor()
    {
        return patientLocationFloor;
    }

    @Nullable
    protected String getPatientLocationDescription()
    {
        return patientLocationDescription;
    }

    @Nullable
    protected String getPatientLocationAssigningAuthority()
    {
        return patientLocationAssigningAuthority;
    }

    @Nullable
    protected String getPatientLocationComprehensiveDescription()
    {
        return patientLocationComprehensiveDescription;
    }

    @Nullable
    protected String getPatientLocationStatus()
    {
        return patientLocationStatus;
    }

    @Nullable
    protected String getPatientLocationType()
    {
        return patientLocationType;
    }

    @Nullable
    protected String getPatientStation()
    {
        return patientStation;
    }

    @Nullable
    protected String getPatientClass()
    {
        return patientClass;
    }

    @Nullable
    protected String getReferringDoctorLastName()
    {
        return referringDoctorLastName;
    }

    @Nullable
    protected String getReferringDoctorFirstName()
    {
        return referringDoctorFirstName;
    }

    @Nullable
    protected String getReferringDoctorDegree()
    {
        return referringDoctorDegree;
    }

    @Nullable
    protected String getReferringDoctorFullName()
    {
        return referringDoctorFullName;
    }

    @Nullable
    protected String getOrderingDoctorLastName()
    {
        return orderingDoctorLastName;
    }

    @Nullable
    protected String getOrderingDoctorFirstName()
    {
        return orderingDoctorFirstName;
    }

    @Nullable
    protected String getOrderingDoctorDegree()
    {
        return orderingDoctorDegree;
    }

    @Nullable
    protected String getOrderingDoctorFullName()
    {
        return orderingDoctorFullName;
    }

    @Nullable
    protected String getOrderNumber()
    {
        return orderNumber;
    }

    @Nullable
    protected String getSendingFacility()
    {
        return sendingFacility;
    }

    @Nullable
    protected String getTechName()
    {
        return techName;
    }

    @Nullable
    protected String getAuthorizationNumber()
    {
        return authorizationNumber;
    }

    @Nullable
    protected String getNumberOfFilms()
    {
        return numberOfFilms;
    }

    @Nullable
    protected String getFilmType()
    {
        return filmType;
    }

    @Nullable
    protected Date getEffectiveDate()
    {
        return effectiveDate;
    }

    @Nullable
    protected String getFindings()
    {
        return findings;
    }

    @Nullable
    protected String getApprovalDate()
    {
        return approvalDate;
    }

    @Nullable
    protected String getDeliveryDate()
    {
        return deliveryDate;
    }

    @Nullable
    protected String getModifiers()
    {
        return modifiers;
    }

    @Nullable
    protected String getDiagnosisCode()
    {
        return diagnosisCode;
    }

    @Nullable
    protected String getReportId()
    {
        return reportId;
    }

    @Nullable
    protected String getHl7()
    {
        return hl7;
    }

    @Nullable
    protected String getCoPayAmount()
    {
        return coPayAmount;
    }

    @Nullable
    protected String getFeeAmount()
    {
        return feeAmount;
    }

    @Nullable
    protected String getAllowableAmount()
    {
        return allowableAmount;
    }

    @Nullable
    protected String getVisitNumber()
    {
        return visitNumber;
    }

    @Nullable
    protected String getDeductibleAmount()
    {
        return deductibleAmount;
    }

    @Nullable
    protected String getLoggedAmount()
    {
        return loggedAmount;
    }

    @Nullable
    protected String getCardChequeNumber()
    {
        return cardChequeNumber;
    }

    @Nullable
    protected String getExternalVisitId()
    {
        return externalVisitId;
    }

    @Nullable
    protected String getPaymentMethod()
    {
        return paymentMethod;
    }

    @Nullable
    protected Date getExpiryDate()
    {
        return expiryDate;
    }

    @Nullable
    protected String getHospitalService()
    {
        return hospitalService;
    }

    @Nullable
    protected String getProcedureStartDate()
    {
        return procedureStartDate;
    }

    @Nullable
    protected String getReasonForExam()
    {
        return reasonForExam;
    }

    @Nullable
    protected String getPriority()
    {
        return priority;
    }

    @Nullable
    protected String getProcedureCode()
    {
        return procedureCode;
    }

    @Nullable
    protected String getProcedureCodeScheme()
    {
        return procedureCodeScheme;
    }

    @Nullable
    protected String getOrderStatus()
    {
        return orderStatus;
    }

    @Nullable
    protected String getLaterality()
    {
        return laterality;
    }

    @Nullable
    protected String getPrincipalResultInterpreter()
    {
        return principalResultInterpreter;
    }

    @Nullable
    protected String getResponsibleObserver()
    {
        return responsibleObserver;
    }

    @Nullable
    protected String getRelevantClinicalInformation()
    {
        return relevantClinicalInformation;
    }

    @Nullable
    protected Collection<Physician> getPhysicians()
    {
        return physicians;
    }

    @Nullable
    protected String getFollowUpCode()
    {
        return followUpCode;
    }

    @Nullable
    protected String getGuarantorName()
    {
        return guarantorName;
    }

    @Nullable
    protected String getGuarantorAddress()
    {
        return guarantorAddress;
    }

    @Nullable
    protected String getGuarantorPhone()
    {
        return guarantorPhone;
    }

    @Nullable
    protected Date getGuarantorDOB()
    {
        return guarantorDOB;
    }

    @Nullable
    protected String getServiceType()
    {
        return serviceType;
    }

    @Nullable
    protected Date getDateOfService()
    {
        return dateOfService;
    }

    @Nullable
    protected String getTransportType()
    {
        return transportType;
    }

    @Nullable
    protected String getInpatientLocation()
    {
        return inpatientLocation;
    }

    @Nullable
    protected String getRoom()
    {
        return room;
    }

    protected boolean isIV()
    {
        return iV;
    }

    protected boolean isO2()
    {
        return o2;
    }

    protected boolean isMonitor()
    {
        return monitor;
    }

    @Nullable
    protected Date getDischargeDate()
    {
        return dischargeDate;
    }

    @Nullable
    protected String getInsuredName()
    {
        return insuredName;
    }

    @Nullable
    protected String getRelationship()
    {
        return relationship;
    }

    protected boolean isReleaseSigned()
    {
        return releaseSigned;
    }

    @Nullable
    protected String getCoPay()
    {
        return coPay;
    }

    @Nullable
    protected String getDeductible()
    {
        return deductible;
    }

    @Nullable
    protected Date getDateSigned()
    {
        return dateSigned;
    }

    @Nullable
    protected String getCoInsurance()
    {
        return coInsurance;
    }

    @Nullable
    protected Collection<PatientInsurance> getPatientInsurances()
    {
        return patientInsurances;
    }

    @Nullable
    protected Collection<VisitInsurance> getVisitInsurances()
    {
        return visitInsurances;
    }

    @Nullable
    protected Collection<Allergy> getAllergies()
    {
        return allergies;
    }

    @Nullable
    protected Collection<Referral> getReferrals()
    {
        return referrals;
    }

    @Nullable
    protected Collection<Medication> getMedications()
    {
        return medications;
    }

    @Nullable
    protected OrderReport getReport()
    {
        return report;
    }

    @Nullable
    protected String getUpdatedBy()
    {
        return updatedBy;
    }

    @Nullable
    protected Date getUpdateTime()
    {
        return updateTime;
    }

    @Nullable
    protected String getTechNotes()
    {
        return techNotes;
    }

    protected boolean isCritical()
    {
        return critical;
    }

    @Nullable
    protected String getStudyDate()
    {
        return studyDate;
    }

    @Nullable
    protected String getStudyTime()
    {
        return studyTime;
    }

    @Nullable
    protected String getArrivalDate()
    {
        return arrivalDate;
    }

    @Nullable
    protected String getArrivalTime()
    {
        return arrivalTime;
    }

    @Nullable
    protected String getAdditionalAccessions()
    {
        return additionalAccessions;
    }

    @Nullable
    protected UrgentExamType getUrgentExamType()
    {
        return urgentExamType;
    }

    @Nullable
    protected String getReadingRadiologist()
    {
        return readingRadiologist;
    }

    @NotNull
    public DetailedOrder build()
    {
        return new DetailedOrder(getOrderId(),
                                 getStatus(),
                                 getOrderPriority(),
                                 getAssignedTo(),
                                 getDicomStudyId(),
                                 getPatientFirstName(),
                                 getPatientMiddleName(),
                                 getPatientLastName(),
                                 getPatientId(),
                                 getPatientBirthDate(),
                                 getPatientAge(),
                                 getPatientSex(),
                                 getPatientSuffix(),
                                 getAlternatePatientId(),
                                 getPatientAccountNumber(),
                                 getPatientAddressee(),
                                 getPatientAddressType(),
                                 getPatientStreetAddress(),
                                 getPatientStreetName(),
                                 getPatientAddressBuildingNumber(),
                                 getPatientAddressCity(),
                                 getPatientAddressState(),
                                 getPatientAddressCounty(),
                                 getPatientAddressZipcode(),
                                 getPatientAddressCountry(),
                                 getPatientAliasLastName(),
                                 getPatientAliasFirstName(),
                                 getPatientAliasMiddleName(),
                                 getPatientAlias(),
                                 getPatientSSN(),
                                 getPatientRace(),
                                 getPatientCitizenship(),
                                 getMaritalStatus(),
                                 getPatientEmail(),
                                 getPatientHomePhone(),
                                 getPatientWorkPhone(),
                                 getPatientFax(),
                                 getPatientMobile(),
                                 getPatientOtherPhone(),
                                 getPatientNotificationPreference(),
                                 getPatientEmployer(),
                                 getPatientEmployerStatus(),
                                 getPatientEmployerPhone(),
                                 getPatientStudentStatus(),
                                 getPatientSchool(),
                                 getPatientNoticeOfPrivacy(),
                                 getPatientDateOfPrivacy(),
                                 getPatientDateOfDeath(),
                                 getPatientCauseOfDeath(),
                                 getPatientEmergencyContactName(),
                                 getPatientEmergencyContactPhone(),
                                 getPatientPreferredLanguage(),
                                 getPatientSmokingStatus(),
                                 getPatientEthnicity(),
                                 getPatientBirthState(),
                                 getPatientBirthCountry(),
                                 getPatientBirthOrder(),
                                 getPatientMothersLastName(),
                                 getPatientMothersFirstName(),
                                 getPatientMothersMiddleName(),
                                 getPatientMothersMaidenName(),
                                 getInstitutionName(),
                                 getAccessionNumber(),
                                 getCPTCode(),
                                 getCPTMnemonic(),
                                 getModality(),
                                 getStudyDescription(),
                                 getPregnant(),
                                 getVipIndicator(),
                                 getAdmitDate(),
                                 getAdmissionType(),
                                 getPatientLocationBed(),
                                 getPatientLocationBuilding(),
                                 getPatientLocationFacility(),
                                 getPatientLocationFloor(),
                                 getPatientLocationDescription(),
                                 getPatientLocationAssigningAuthority(),
                                 getPatientLocationComprehensiveDescription(),
                                 getPatientLocationStatus(),
                                 getPatientLocationType(),
                                 getPatientStation(),
                                 getPatientClass(),
                                 getReferringDoctorLastName(),
                                 getReferringDoctorFirstName(),
                                 getReferringDoctorDegree(),
                                 getReferringDoctorFullName(),
                                 getOrderingDoctorLastName(),
                                 getOrderingDoctorFirstName(),
                                 getOrderingDoctorDegree(),
                                 getOrderingDoctorFullName(),
                                 getOrderNumber(),
                                 getSendingFacility(),
                                 getTechName(),
                                 getAuthorizationNumber(),
                                 getNumberOfFilms(),
                                 getFilmType(),
                                 getEffectiveDate(),
                                 getFindings(),
                                 getApprovalDate(),
                                 getDeliveryDate(),
                                 getModifiers(),
                                 getDiagnosisCode(),
                                 getReportId(),
                                 getHl7(),
                                 getCoPayAmount(),
                                 getFeeAmount(),
                                 getAllowableAmount(),
                                 getVisitNumber(),
                                 getDeductibleAmount(),
                                 getLoggedAmount(),
                                 getCardChequeNumber(),
                                 getExternalVisitId(),
                                 getPaymentMethod(),
                                 getExpiryDate(),
                                 getHospitalService(),
                                 getProcedureStartDate(),
                                 getReasonForExam(),
                                 getPriority(),
                                 getProcedureCode(),
                                 getProcedureCodeScheme(),
                                 getOrderStatus(),
                                 getLaterality(),
                                 getPrincipalResultInterpreter(),
                                 getResponsibleObserver(),
                                 getRelevantClinicalInformation(),
                                 getPhysicians(),
                                 getFollowUpCode(),
                                 getGuarantorName(),
                                 getGuarantorAddress(),
                                 getGuarantorPhone(),
                                 getGuarantorDOB(),
                                 getServiceType(),
                                 getDateOfService(),
                                 getTransportType(),
                                 getInpatientLocation(),
                                 getRoom(),
                                 isIV(),
                                 isO2(),
                                 isMonitor(),
                                 getDischargeDate(),
                                 getInsuredName(),
                                 getRelationship(),
                                 isReleaseSigned(),
                                 getCoPay(),
                                 getDeductible(),
                                 getDateSigned(),
                                 getCoInsurance(),
                                 getPatientInsurances(),
                                 getVisitInsurances(),
                                 getAllergies(),
                                 getReferrals(),
                                 getMedications(),
                                 getReport(),
                                 getUpdatedBy(),
                                 getUpdateTime(),
                                 getTechNotes(),
                                 isCritical(),
                                 getStudyDate(),
                                 getStudyTime(),
                                 getArrivalDate(),
                                 getArrivalTime(),
                                 getAdditionalAccessions(),
                                 getUrgentExamType(),
                                 getReadingRadiologist());
    }


    @NotNull
    protected DetailedOrderBuilder self()
    {
        return this;
    }
}