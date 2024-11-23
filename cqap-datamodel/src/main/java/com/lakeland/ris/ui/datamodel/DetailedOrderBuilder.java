package com.lakeland.ris.ui.datamodel;


import java.util.*;
import com.lakeland.ris.datamodel.*;
import java.util.*;

public class DetailedOrderBuilder
{
    private String orderId;
    private OrderStatus status;
    private OrderPriority orderPriority;
    private String assignedTo;
     private String dicomStudyId;
     private String patientFirstName;
     private String patientMiddleName;
     private String patientLastName;
     private String patientId;
     private Date patientBirthDate;
     private String patientAge;
     private String patientSex;
     private String patientSuffix;
     private String alternatePatientId;
     private String patientAccountNumber;
     private String patientAddressee;
     private String patientAddressType;
     private String patientStreetAddress;
     private String patientStreetName;
     private String patientAddressBuildingNumber;
     private String patientAddressCity;
     private String patientAddressState;
     private String patientAddressCounty;
     private String patientAddressZipcode;
     private String patientAddressCountry;
     private String patientAliasLastName;
     private String patientAliasFirstName;
     private String patientAliasMiddleName;
     private String patientAlias;
     private String patientSSN;
     private String patientRace;
     private String patientCitizenship;
     private String maritalStatus;
     private String patientEmail;
     private String patientHomePhone;
     private String patientWorkPhone;
     private String patientFax;
     private String patientMobile;
     private String patientOtherPhone;
     private String patientNotificationPreference;
     private String patientEmployer;
     private String patientEmployerStatus;
     private String patientEmployerPhone;
     private String patientStudentStatus;
     private String patientSchool;
     private String patientNoticeOfPrivacy;
     private Date patientDateOfPrivacy;
     private Date patientDateOfDeath;
     private String patientCauseOfDeath;
     private String patientEmergencyContactName;
     private String patientEmergencyContactPhone;
     private String patientPreferredLanguage;
     private String patientSmokingStatus;
     private String patientEthnicity;
     private String patientBirthState;
     private String patientBirthCountry;
     private String patientBirthOrder;
     private String patientMothersLastName;
     private String patientMothersFirstName;
     private String patientMothersMiddleName;
     private String patientMothersMaidenName;
     private String institutionName;
     private String accessionNumber;
     private String cPTCode;
     private String cPTMnemonic;
     private String modality;
     private String studyDescription;
     private String pregnant;
     private String vipIndicator;
     private Date admitDate;
     private String admissionType;
     private String patientLocationBed;
     private String patientLocationBuilding;
     private String patientLocationFacility;
     private String patientLocationFloor;
     private String patientLocationDescription;
     private String patientLocationAssigningAuthority;
     private String patientLocationComprehensiveDescription;
     private String patientLocationStatus;
     private String patientLocationType;
     private String patientStation;
     private String patientClass;
     private String referringDoctorLastName;
     private String referringDoctorFirstName;
     private String referringDoctorDegree;
     private String referringDoctorFullName;
     private String orderingDoctorLastName;
     private String orderingDoctorFirstName;
     private String orderingDoctorDegree;
     private String orderingDoctorFullName;
     private String orderNumber;
     private String sendingFacility;
     private String techName;
     private String authorizationNumber;
     private String numberOfFilms;
     private String filmType;
     private Date effectiveDate;
     private String findings;
     private String approvalDate;
     private String deliveryDate;
     private String modifiers;
     private String diagnosisCode;
     private String reportId;
     private String hl7;
     private String coPayAmount;
     private String feeAmount;
     private String allowableAmount;
     private String visitNumber;
     private String deductibleAmount;
     private String loggedAmount;
     private String cardChequeNumber;
     private String externalVisitId;
     private String paymentMethod;
     private Date expiryDate;
     private String hospitalService;
     private String procedureStartDate;
     private String reasonForExam;
     private String priority;
     private String procedureCode;
     private String procedureCodeScheme;
     private String orderStatus;
     private String laterality;
     private String principalResultInterpreter;
     private String responsibleObserver;
     private String relevantClinicalInformation;
     private Collection<Physician> physicians;
     private String followUpCode;
     private String guarantorName;
     private String guarantorAddress;
     private String guarantorPhone;
     private Date guarantorDOB;
     private String serviceType;
     private Date dateOfService;
     private String transportType;
     private String inpatientLocation;
     private String room;
    private boolean iV;
    private boolean o2;
    private boolean monitor;
     private Date dischargeDate;
     private String insuredName;
     private String relationship;
    private boolean releaseSigned;
     private String coPay;
     private String deductible;
     private Date dateSigned;
     private String coInsurance;
     private Collection<PatientInsurance> patientInsurances;
     private Collection<VisitInsurance> visitInsurances;
     private Collection<Allergy> allergies;
     private Collection<Referral> referrals;
     private Collection<Medication> medications;
     private OrderReport report;
     private String updatedBy;
     private Date updateTime;
     private String techNotes;
    private boolean critical;
     private String studyDate;
     private String studyTime;
     private String arrivalDate;
     private String arrivalTime;
     private String additionalAccessions;
     private UrgentExamType urgentExamType;
     private String readingRadiologist;

    public DetailedOrderBuilder(String orderId,
                                OrderStatus status,
                                OrderPriority orderPriority,
                                String assignedTo)
    {
        super();

        this.orderId = orderId;
        this.status = status;
        this.orderPriority = orderPriority;
        this.assignedTo = assignedTo;
    }



    public DetailedOrderBuilder setOrderId(String orderId)
    {
        this.orderId = orderId;

        return self();
    }


    public DetailedOrderBuilder setStatus(OrderStatus status)
    {
        this.status = status;

        return self();
    }


    public DetailedOrderBuilder setOrderPriority(OrderPriority orderPriority)
    {
        this.orderPriority = orderPriority;

        return self();
    }


    public DetailedOrderBuilder setAssignedTo(String assignedTo)
    {
        this.assignedTo = assignedTo;

        return self();
    }


    public DetailedOrderBuilder setDicomStudyId( String dicomStudyId)
    {
        this.dicomStudyId = dicomStudyId;

        return self();
    }


    public DetailedOrderBuilder setPatientFirstName( String patientFirstName)
    {
        this.patientFirstName = patientFirstName;

        return self();
    }


    public DetailedOrderBuilder setPatientMiddleName( String patientMiddleName)
    {
        this.patientMiddleName = patientMiddleName;

        return self();
    }


    public DetailedOrderBuilder setPatientLastName( String patientLastName)
    {
        this.patientLastName = patientLastName;

        return self();
    }


    public DetailedOrderBuilder setPatientId( String patientId)
    {
        this.patientId = patientId;

        return self();
    }


    public DetailedOrderBuilder setPatientBirthDate( Date patientBirthDate)
    {
        this.patientBirthDate = patientBirthDate;

        return self();
    }


    public DetailedOrderBuilder setPatientAge( String patientAge)
    {
        this.patientAge = patientAge;

        return self();
    }


    public DetailedOrderBuilder setPatientSex( String patientSex)
    {
        this.patientSex = patientSex;

        return self();
    }


    public DetailedOrderBuilder setPatientSuffix( String patientSuffix)
    {
        this.patientSuffix = patientSuffix;

        return self();
    }


    public DetailedOrderBuilder setAlternatePatientId( String alternatePatientId)
    {
        this.alternatePatientId = alternatePatientId;

        return self();
    }


    public DetailedOrderBuilder setPatientAccountNumber( String patientAccountNumber)
    {
        this.patientAccountNumber = patientAccountNumber;

        return self();
    }


    public DetailedOrderBuilder setPatientAddressee( String patientAddressee)
    {
        this.patientAddressee = patientAddressee;

        return self();
    }


    public DetailedOrderBuilder setPatientAddressType( String patientAddressType)
    {
        this.patientAddressType = patientAddressType;

        return self();
    }


    public DetailedOrderBuilder setPatientStreetAddress( String patientStreetAddress)
    {
        this.patientStreetAddress = patientStreetAddress;

        return self();
    }


    public DetailedOrderBuilder setPatientStreetName( String patientStreetName)
    {
        this.patientStreetName = patientStreetName;

        return self();
    }


    public DetailedOrderBuilder setPatientAddressBuildingNumber( String patientAddressBuildingNumber)
    {
        this.patientAddressBuildingNumber = patientAddressBuildingNumber;

        return self();
    }


    public DetailedOrderBuilder setPatientAddressCity( String patientAddressCity)
    {
        this.patientAddressCity = patientAddressCity;

        return self();
    }


    public DetailedOrderBuilder setPatientAddressState( String patientAddressState)
    {
        this.patientAddressState = patientAddressState;

        return self();
    }


    public DetailedOrderBuilder setPatientAddressCounty( String patientAddressCounty)
    {
        this.patientAddressCounty = patientAddressCounty;

        return self();
    }


    public DetailedOrderBuilder setPatientAddressZipcode( String patientAddressZipcode)
    {
        this.patientAddressZipcode = patientAddressZipcode;

        return self();
    }


    public DetailedOrderBuilder setPatientAddressCountry( String patientAddressCountry)
    {
        this.patientAddressCountry = patientAddressCountry;

        return self();
    }


    public DetailedOrderBuilder setPatientAliasLastName( String patientAliasLastName)
    {
        this.patientAliasLastName = patientAliasLastName;

        return self();
    }


    public DetailedOrderBuilder setPatientAliasFirstName( String patientAliasFirstName)
    {
        this.patientAliasFirstName = patientAliasFirstName;

        return self();
    }


    public DetailedOrderBuilder setPatientAliasMiddleName( String patientAliasMiddleName)
    {
        this.patientAliasMiddleName = patientAliasMiddleName;

        return self();
    }


    public DetailedOrderBuilder setPatientAlias( String patientAlias)
    {
        this.patientAlias = patientAlias;

        return self();
    }


    public DetailedOrderBuilder setPatientSSN( String patientSSN)
    {
        this.patientSSN = patientSSN;

        return self();
    }


    public DetailedOrderBuilder setPatientRace( String patientRace)
    {
        this.patientRace = patientRace;

        return self();
    }


    public DetailedOrderBuilder setPatientCitizenship( String patientCitizenship)
    {
        this.patientCitizenship = patientCitizenship;

        return self();
    }


    public DetailedOrderBuilder setMaritalStatus( String maritalStatus)
    {
        this.maritalStatus = maritalStatus;

        return self();
    }


    public DetailedOrderBuilder setPatientEmail( String patientEmail)
    {
        this.patientEmail = patientEmail;

        return self();
    }


    public DetailedOrderBuilder setPatientHomePhone( String patientHomePhone)
    {
        this.patientHomePhone = patientHomePhone;

        return self();
    }


    public DetailedOrderBuilder setPatientWorkPhone( String patientWorkPhone)
    {
        this.patientWorkPhone = patientWorkPhone;

        return self();
    }


    public DetailedOrderBuilder setPatientFax( String patientFax)
    {
        this.patientFax = patientFax;

        return self();
    }


    public DetailedOrderBuilder setPatientMobile( String patientMobile)
    {
        this.patientMobile = patientMobile;

        return self();
    }


    public DetailedOrderBuilder setPatientOtherPhone( String patientOtherPhone)
    {
        this.patientOtherPhone = patientOtherPhone;

        return self();
    }


    public DetailedOrderBuilder setPatientNotificationPreference( String patientNotificationPreference)
    {
        this.patientNotificationPreference = patientNotificationPreference;

        return self();
    }


    public DetailedOrderBuilder setPatientEmployer( String patientEmployer)
    {
        this.patientEmployer = patientEmployer;

        return self();
    }


    public DetailedOrderBuilder setPatientEmployerStatus( String patientEmployerStatus)
    {
        this.patientEmployerStatus = patientEmployerStatus;

        return self();
    }


    public DetailedOrderBuilder setPatientEmployerPhone( String patientEmployerPhone)
    {
        this.patientEmployerPhone = patientEmployerPhone;

        return self();
    }


    public DetailedOrderBuilder setPatientStudentStatus( String patientStudentStatus)
    {
        this.patientStudentStatus = patientStudentStatus;

        return self();
    }


    public DetailedOrderBuilder setPatientSchool( String patientSchool)
    {
        this.patientSchool = patientSchool;

        return self();
    }


    public DetailedOrderBuilder setPatientNoticeOfPrivacy( String patientNoticeOfPrivacy)
    {
        this.patientNoticeOfPrivacy = patientNoticeOfPrivacy;

        return self();
    }


    public DetailedOrderBuilder setPatientDateOfPrivacy( Date patientDateOfPrivacy)
    {
        this.patientDateOfPrivacy = patientDateOfPrivacy;

        return self();
    }


    public DetailedOrderBuilder setPatientDateOfDeath( Date patientDateOfDeath)
    {
        this.patientDateOfDeath = patientDateOfDeath;

        return self();
    }


    public DetailedOrderBuilder setPatientCauseOfDeath( String patientCauseOfDeath)
    {
        this.patientCauseOfDeath = patientCauseOfDeath;

        return self();
    }


    public DetailedOrderBuilder setPatientEmergencyContactName( String patientEmergencyContactName)
    {
        this.patientEmergencyContactName = patientEmergencyContactName;

        return self();
    }


    public DetailedOrderBuilder setPatientEmergencyContactPhone( String patientEmergencyContactPhone)
    {
        this.patientEmergencyContactPhone = patientEmergencyContactPhone;

        return self();
    }


    public DetailedOrderBuilder setPatientPreferredLanguage( String patientPreferredLanguage)
    {
        this.patientPreferredLanguage = patientPreferredLanguage;

        return self();
    }


    public DetailedOrderBuilder setPatientSmokingStatus( String patientSmokingStatus)
    {
        this.patientSmokingStatus = patientSmokingStatus;

        return self();
    }


    public DetailedOrderBuilder setPatientEthnicity( String patientEthnicity)
    {
        this.patientEthnicity = patientEthnicity;

        return self();
    }


    public DetailedOrderBuilder setPatientBirthState( String patientBirthState)
    {
        this.patientBirthState = patientBirthState;

        return self();
    }


    public DetailedOrderBuilder setPatientBirthCountry( String patientBirthCountry)
    {
        this.patientBirthCountry = patientBirthCountry;

        return self();
    }


    public DetailedOrderBuilder setPatientBirthOrder( String patientBirthOrder)
    {
        this.patientBirthOrder = patientBirthOrder;

        return self();
    }


    public DetailedOrderBuilder setPatientMothersLastName( String patientMothersLastName)
    {
        this.patientMothersLastName = patientMothersLastName;

        return self();
    }


    public DetailedOrderBuilder setPatientMothersFirstName( String patientMothersFirstName)
    {
        this.patientMothersFirstName = patientMothersFirstName;

        return self();
    }


    public DetailedOrderBuilder setPatientMothersMiddleName( String patientMothersMiddleName)
    {
        this.patientMothersMiddleName = patientMothersMiddleName;

        return self();
    }


    public DetailedOrderBuilder setPatientMothersMaidenName( String patientMothersMaidenName)
    {
        this.patientMothersMaidenName = patientMothersMaidenName;

        return self();
    }


    public DetailedOrderBuilder setInstitutionName( String institutionName)
    {
        this.institutionName = institutionName;

        return self();
    }


    public DetailedOrderBuilder setAccessionNumber( String accessionNumber)
    {
        this.accessionNumber = accessionNumber;

        return self();
    }


    public DetailedOrderBuilder setCPTCode( String cPTCode)
    {
        this.cPTCode = cPTCode;

        return self();
    }


    public DetailedOrderBuilder setCPTMnemonic( String cPTMnemonic)
    {
        this.cPTMnemonic = cPTMnemonic;

        return self();
    }


    public DetailedOrderBuilder setModality( String modality)
    {
        this.modality = modality;

        return self();
    }


    public DetailedOrderBuilder setStudyDescription( String studyDescription)
    {
        this.studyDescription = studyDescription;

        return self();
    }


    public DetailedOrderBuilder setPregnant( String pregnant)
    {
        this.pregnant = pregnant;

        return self();
    }


    public DetailedOrderBuilder setVipIndicator( String vipIndicator)
    {
        this.vipIndicator = vipIndicator;

        return self();
    }


    public DetailedOrderBuilder setAdmitDate( Date admitDate)
    {
        this.admitDate = admitDate;

        return self();
    }


    public DetailedOrderBuilder setAdmissionType( String admissionType)
    {
        this.admissionType = admissionType;

        return self();
    }


    public DetailedOrderBuilder setPatientLocationBed( String patientLocationBed)
    {
        this.patientLocationBed = patientLocationBed;

        return self();
    }


    public DetailedOrderBuilder setPatientLocationBuilding( String patientLocationBuilding)
    {
        this.patientLocationBuilding = patientLocationBuilding;

        return self();
    }


    public DetailedOrderBuilder setPatientLocationFacility( String patientLocationFacility)
    {
        this.patientLocationFacility = patientLocationFacility;

        return self();
    }


    public DetailedOrderBuilder setPatientLocationFloor( String patientLocationFloor)
    {
        this.patientLocationFloor = patientLocationFloor;

        return self();
    }


    public DetailedOrderBuilder setPatientLocationDescription( String patientLocationDescription)
    {
        this.patientLocationDescription = patientLocationDescription;

        return self();
    }


    public DetailedOrderBuilder setPatientLocationAssigningAuthority( String patientLocationAssigningAuthority)
    {
        this.patientLocationAssigningAuthority = patientLocationAssigningAuthority;

        return self();
    }


    public DetailedOrderBuilder setPatientLocationComprehensiveDescription( String patientLocationComprehensiveDescription)
    {
        this.patientLocationComprehensiveDescription = patientLocationComprehensiveDescription;

        return self();
    }


    public DetailedOrderBuilder setPatientLocationStatus( String patientLocationStatus)
    {
        this.patientLocationStatus = patientLocationStatus;

        return self();
    }


    public DetailedOrderBuilder setPatientLocationType( String patientLocationType)
    {
        this.patientLocationType = patientLocationType;

        return self();
    }


    public DetailedOrderBuilder setPatientStation( String patientStation)
    {
        this.patientStation = patientStation;

        return self();
    }


    public DetailedOrderBuilder setPatientClass( String patientClass)
    {
        this.patientClass = patientClass;

        return self();
    }


    public DetailedOrderBuilder setReferringDoctorLastName( String referringDoctorLastName)
    {
        this.referringDoctorLastName = referringDoctorLastName;

        return self();
    }


    public DetailedOrderBuilder setReferringDoctorFirstName( String referringDoctorFirstName)
    {
        this.referringDoctorFirstName = referringDoctorFirstName;

        return self();
    }


    public DetailedOrderBuilder setReferringDoctorDegree( String referringDoctorDegree)
    {
        this.referringDoctorDegree = referringDoctorDegree;

        return self();
    }


    public DetailedOrderBuilder setReferringDoctorFullName( String referringDoctorFullName)
    {
        this.referringDoctorFullName = referringDoctorFullName;

        return self();
    }


    public DetailedOrderBuilder setOrderingDoctorLastName( String orderingDoctorLastName)
    {
        this.orderingDoctorLastName = orderingDoctorLastName;

        return self();
    }


    public DetailedOrderBuilder setOrderingDoctorFirstName( String orderingDoctorFirstName)
    {
        this.orderingDoctorFirstName = orderingDoctorFirstName;

        return self();
    }


    public DetailedOrderBuilder setOrderingDoctorDegree( String orderingDoctorDegree)
    {
        this.orderingDoctorDegree = orderingDoctorDegree;

        return self();
    }


    public DetailedOrderBuilder setOrderingDoctorFullName( String orderingDoctorFullName)
    {
        this.orderingDoctorFullName = orderingDoctorFullName;

        return self();
    }


    public DetailedOrderBuilder setOrderNumber( String orderNumber)
    {
        this.orderNumber = orderNumber;

        return self();
    }


    public DetailedOrderBuilder setSendingFacility( String sendingFacility)
    {
        this.sendingFacility = sendingFacility;

        return self();
    }


    public DetailedOrderBuilder setTechName( String techName)
    {
        this.techName = techName;

        return self();
    }


    public DetailedOrderBuilder setAuthorizationNumber( String authorizationNumber)
    {
        this.authorizationNumber = authorizationNumber;

        return self();
    }


    public DetailedOrderBuilder setNumberOfFilms( String numberOfFilms)
    {
        this.numberOfFilms = numberOfFilms;

        return self();
    }


    public DetailedOrderBuilder setFilmType( String filmType)
    {
        this.filmType = filmType;

        return self();
    }


    public DetailedOrderBuilder setEffectiveDate( Date effectiveDate)
    {
        this.effectiveDate = effectiveDate;

        return self();
    }


    public DetailedOrderBuilder setFindings( String findings)
    {
        this.findings = findings;

        return self();
    }


    public DetailedOrderBuilder setApprovalDate( String approvalDate)
    {
        this.approvalDate = approvalDate;

        return self();
    }


    public DetailedOrderBuilder setDeliveryDate( String deliveryDate)
    {
        this.deliveryDate = deliveryDate;

        return self();
    }


    public DetailedOrderBuilder setModifiers( String modifiers)
    {
        this.modifiers = modifiers;

        return self();
    }


    public DetailedOrderBuilder setDiagnosisCode( String diagnosisCode)
    {
        this.diagnosisCode = diagnosisCode;

        return self();
    }


    public DetailedOrderBuilder setReportId( String reportId)
    {
        this.reportId = reportId;

        return self();
    }


    public DetailedOrderBuilder setHl7( String hl7)
    {
        this.hl7 = hl7;

        return self();
    }


    public DetailedOrderBuilder setCoPayAmount( String coPayAmount)
    {
        this.coPayAmount = coPayAmount;

        return self();
    }


    public DetailedOrderBuilder setFeeAmount( String feeAmount)
    {
        this.feeAmount = feeAmount;

        return self();
    }


    public DetailedOrderBuilder setAllowableAmount( String allowableAmount)
    {
        this.allowableAmount = allowableAmount;

        return self();
    }


    public DetailedOrderBuilder setVisitNumber( String visitNumber)
    {
        this.visitNumber = visitNumber;

        return self();
    }


    public DetailedOrderBuilder setDeductibleAmount( String deductibleAmount)
    {
        this.deductibleAmount = deductibleAmount;

        return self();
    }


    public DetailedOrderBuilder setLoggedAmount( String loggedAmount)
    {
        this.loggedAmount = loggedAmount;

        return self();
    }


    public DetailedOrderBuilder setCardChequeNumber( String cardChequeNumber)
    {
        this.cardChequeNumber = cardChequeNumber;

        return self();
    }


    public DetailedOrderBuilder setExternalVisitId( String externalVisitId)
    {
        this.externalVisitId = externalVisitId;

        return self();
    }


    public DetailedOrderBuilder setPaymentMethod( String paymentMethod)
    {
        this.paymentMethod = paymentMethod;

        return self();
    }


    public DetailedOrderBuilder setExpiryDate( Date expiryDate)
    {
        this.expiryDate = expiryDate;

        return self();
    }


    public DetailedOrderBuilder setHospitalService( String hospitalService)
    {
        this.hospitalService = hospitalService;

        return self();
    }


    public DetailedOrderBuilder setProcedureStartDate( String procedureStartDate)
    {
        this.procedureStartDate = procedureStartDate;

        return self();
    }


    public DetailedOrderBuilder setReasonForExam( String reasonForExam)
    {
        this.reasonForExam = reasonForExam;

        return self();
    }


    public DetailedOrderBuilder setPriority( String priority)
    {
        this.priority = priority;

        return self();
    }


    public DetailedOrderBuilder setProcedureCode( String procedureCode)
    {
        this.procedureCode = procedureCode;

        return self();
    }


    public DetailedOrderBuilder setProcedureCodeScheme( String procedureCodeScheme)
    {
        this.procedureCodeScheme = procedureCodeScheme;

        return self();
    }


    public DetailedOrderBuilder setOrderStatus( String orderStatus)
    {
        this.orderStatus = orderStatus;

        return self();
    }


    public DetailedOrderBuilder setLaterality( String laterality)
    {
        this.laterality = laterality;

        return self();
    }


    public DetailedOrderBuilder setPrincipalResultInterpreter( String principalResultInterpreter)
    {
        this.principalResultInterpreter = principalResultInterpreter;

        return self();
    }


    public DetailedOrderBuilder setResponsibleObserver( String responsibleObserver)
    {
        this.responsibleObserver = responsibleObserver;

        return self();
    }


    public DetailedOrderBuilder setRelevantClinicalInformation( String relevantClinicalInformation)
    {
        this.relevantClinicalInformation = relevantClinicalInformation;

        return self();
    }


    public DetailedOrderBuilder setPhysicians( Collection<Physician> physicians)
    {
        this.physicians = physicians;

        return self();
    }


    public DetailedOrderBuilder setFollowUpCode( String followUpCode)
    {
        this.followUpCode = followUpCode;

        return self();
    }


    public DetailedOrderBuilder setGuarantorName( String guarantorName)
    {
        this.guarantorName = guarantorName;

        return self();
    }


    public DetailedOrderBuilder setGuarantorAddress( String guarantorAddress)
    {
        this.guarantorAddress = guarantorAddress;

        return self();
    }


    public DetailedOrderBuilder setGuarantorPhone( String guarantorPhone)
    {
        this.guarantorPhone = guarantorPhone;

        return self();
    }


    public DetailedOrderBuilder setGuarantorDOB( Date guarantorDOB)
    {
        this.guarantorDOB = guarantorDOB;

        return self();
    }


    public DetailedOrderBuilder setServiceType( String serviceType)
    {
        this.serviceType = serviceType;

        return self();
    }


    public DetailedOrderBuilder setDateOfService( Date dateOfService)
    {
        this.dateOfService = dateOfService;

        return self();
    }


    public DetailedOrderBuilder setTransportType( String transportType)
    {
        this.transportType = transportType;

        return self();
    }


    public DetailedOrderBuilder setInpatientLocation( String inpatientLocation)
    {
        this.inpatientLocation = inpatientLocation;

        return self();
    }


    public DetailedOrderBuilder setRoom( String room)
    {
        this.room = room;

        return self();
    }


    public DetailedOrderBuilder setIV(boolean iV)
    {
        this.iV = iV;

        return self();
    }


    public DetailedOrderBuilder setO2(boolean o2)
    {
        this.o2 = o2;

        return self();
    }


    public DetailedOrderBuilder setMonitor(boolean monitor)
    {
        this.monitor = monitor;

        return self();
    }


    public DetailedOrderBuilder setDischargeDate( Date dischargeDate)
    {
        this.dischargeDate = dischargeDate;

        return self();
    }


    public DetailedOrderBuilder setInsuredName( String insuredName)
    {
        this.insuredName = insuredName;

        return self();
    }


    public DetailedOrderBuilder setRelationship( String relationship)
    {
        this.relationship = relationship;

        return self();
    }


    public DetailedOrderBuilder setReleaseSigned(boolean releaseSigned)
    {
        this.releaseSigned = releaseSigned;

        return self();
    }


    public DetailedOrderBuilder setCoPay( String coPay)
    {
        this.coPay = coPay;

        return self();
    }


    public DetailedOrderBuilder setDeductible( String deductible)
    {
        this.deductible = deductible;

        return self();
    }


    public DetailedOrderBuilder setDateSigned( Date dateSigned)
    {
        this.dateSigned = dateSigned;

        return self();
    }


    public DetailedOrderBuilder setCoInsurance( String coInsurance)
    {
        this.coInsurance = coInsurance;

        return self();
    }


    public DetailedOrderBuilder setPatientInsurances( Collection<PatientInsurance> patientInsurances)
    {
        this.patientInsurances = patientInsurances;

        return self();
    }


    public DetailedOrderBuilder setVisitInsurances( Collection<VisitInsurance> visitInsurances)
    {
        this.visitInsurances = visitInsurances;

        return self();
    }


    public DetailedOrderBuilder setAllergies( Collection<Allergy> allergies)
    {
        this.allergies = allergies;

        return self();
    }


    public DetailedOrderBuilder setReferrals( Collection<Referral> referrals)
    {
        this.referrals = referrals;

        return self();
    }


    public DetailedOrderBuilder setMedications( Collection<Medication> medications)
    {
        this.medications = medications;

        return self();
    }


    public DetailedOrderBuilder setReport( OrderReport report)
    {
        this.report = report;

        return self();
    }


    public DetailedOrderBuilder setUpdatedBy( String updatedBy)
    {
        this.updatedBy = updatedBy;

        return self();
    }


    public DetailedOrderBuilder setUpdateTime( Date updateTime)
    {
        this.updateTime = updateTime;

        return self();
    }


    public DetailedOrderBuilder setTechNotes( String techNotes)
    {
        this.techNotes = techNotes;

        return self();
    }


    public DetailedOrderBuilder setCritical(boolean critical)
    {
        this.critical = critical;

        return self();
    }


    public DetailedOrderBuilder setStudyDate( String studyDate)
    {
        this.studyDate = studyDate;

        return self();
    }


    public DetailedOrderBuilder setStudyTime( String studyTime)
    {
        this.studyTime = studyTime;

        return self();
    }


    public DetailedOrderBuilder setArrivalDate( String arrivalDate)
    {
        this.arrivalDate = arrivalDate;

        return self();
    }


    public DetailedOrderBuilder setArrivalTime( String arrivalTime)
    {
        this.arrivalTime = arrivalTime;

        return self();
    }


    public DetailedOrderBuilder setAdditionalAccessions( String additionalAccessions)
    {
        this.additionalAccessions = additionalAccessions;

        return self();
    }


    public DetailedOrderBuilder setUrgentExamType( UrgentExamType urgentExamType)
    {
        this.urgentExamType = urgentExamType;

        return self();
    }


    public DetailedOrderBuilder setReadingRadiologist( String readingRadiologist)
    {
        this.readingRadiologist = readingRadiologist;

        return self();
    }


    protected String getOrderId()
    {
        return orderId;
    }


    protected OrderStatus getStatus()
    {
        return status;
    }


    protected OrderPriority getOrderPriority()
    {
        return orderPriority;
    }


    protected String getAssignedTo()
    {
        return assignedTo;
    }

    
    protected String getDicomStudyId()
    {
        return dicomStudyId;
    }

    
    protected String getPatientFirstName()
    {
        return patientFirstName;
    }

    
    protected String getPatientMiddleName()
    {
        return patientMiddleName;
    }

    
    protected String getPatientLastName()
    {
        return patientLastName;
    }

    
    protected String getPatientId()
    {
        return patientId;
    }

    
    protected Date getPatientBirthDate()
    {
        return patientBirthDate;
    }

    
    protected String getPatientAge()
    {
        return patientAge;
    }

    
    protected String getPatientSex()
    {
        return patientSex;
    }

    
    protected String getPatientSuffix()
    {
        return patientSuffix;
    }

    
    protected String getAlternatePatientId()
    {
        return alternatePatientId;
    }

    
    protected String getPatientAccountNumber()
    {
        return patientAccountNumber;
    }

    
    protected String getPatientAddressee()
    {
        return patientAddressee;
    }

    
    protected String getPatientAddressType()
    {
        return patientAddressType;
    }

    
    protected String getPatientStreetAddress()
    {
        return patientStreetAddress;
    }

    
    protected String getPatientStreetName()
    {
        return patientStreetName;
    }

    
    protected String getPatientAddressBuildingNumber()
    {
        return patientAddressBuildingNumber;
    }

    
    protected String getPatientAddressCity()
    {
        return patientAddressCity;
    }

    
    protected String getPatientAddressState()
    {
        return patientAddressState;
    }

    
    protected String getPatientAddressCounty()
    {
        return patientAddressCounty;
    }

    
    protected String getPatientAddressZipcode()
    {
        return patientAddressZipcode;
    }

    
    protected String getPatientAddressCountry()
    {
        return patientAddressCountry;
    }

    
    protected String getPatientAliasLastName()
    {
        return patientAliasLastName;
    }

    
    protected String getPatientAliasFirstName()
    {
        return patientAliasFirstName;
    }

    
    protected String getPatientAliasMiddleName()
    {
        return patientAliasMiddleName;
    }

    
    protected String getPatientAlias()
    {
        return patientAlias;
    }

    
    protected String getPatientSSN()
    {
        return patientSSN;
    }

    
    protected String getPatientRace()
    {
        return patientRace;
    }

    
    protected String getPatientCitizenship()
    {
        return patientCitizenship;
    }

    
    protected String getMaritalStatus()
    {
        return maritalStatus;
    }

    
    protected String getPatientEmail()
    {
        return patientEmail;
    }

    
    protected String getPatientHomePhone()
    {
        return patientHomePhone;
    }

    
    protected String getPatientWorkPhone()
    {
        return patientWorkPhone;
    }

    
    protected String getPatientFax()
    {
        return patientFax;
    }

    
    protected String getPatientMobile()
    {
        return patientMobile;
    }

    
    protected String getPatientOtherPhone()
    {
        return patientOtherPhone;
    }

    
    protected String getPatientNotificationPreference()
    {
        return patientNotificationPreference;
    }

    
    protected String getPatientEmployer()
    {
        return patientEmployer;
    }

    
    protected String getPatientEmployerStatus()
    {
        return patientEmployerStatus;
    }

    
    protected String getPatientEmployerPhone()
    {
        return patientEmployerPhone;
    }

    
    protected String getPatientStudentStatus()
    {
        return patientStudentStatus;
    }

    
    protected String getPatientSchool()
    {
        return patientSchool;
    }

    
    protected String getPatientNoticeOfPrivacy()
    {
        return patientNoticeOfPrivacy;
    }

    
    protected Date getPatientDateOfPrivacy()
    {
        return patientDateOfPrivacy;
    }

    
    protected Date getPatientDateOfDeath()
    {
        return patientDateOfDeath;
    }

    
    protected String getPatientCauseOfDeath()
    {
        return patientCauseOfDeath;
    }

    
    protected String getPatientEmergencyContactName()
    {
        return patientEmergencyContactName;
    }

    
    protected String getPatientEmergencyContactPhone()
    {
        return patientEmergencyContactPhone;
    }

    
    protected String getPatientPreferredLanguage()
    {
        return patientPreferredLanguage;
    }

    
    protected String getPatientSmokingStatus()
    {
        return patientSmokingStatus;
    }

    
    protected String getPatientEthnicity()
    {
        return patientEthnicity;
    }

    
    protected String getPatientBirthState()
    {
        return patientBirthState;
    }

    
    protected String getPatientBirthCountry()
    {
        return patientBirthCountry;
    }

    
    protected String getPatientBirthOrder()
    {
        return patientBirthOrder;
    }

    
    protected String getPatientMothersLastName()
    {
        return patientMothersLastName;
    }

    
    protected String getPatientMothersFirstName()
    {
        return patientMothersFirstName;
    }

    
    protected String getPatientMothersMiddleName()
    {
        return patientMothersMiddleName;
    }

    
    protected String getPatientMothersMaidenName()
    {
        return patientMothersMaidenName;
    }

    
    protected String getInstitutionName()
    {
        return institutionName;
    }

    
    protected String getAccessionNumber()
    {
        return accessionNumber;
    }

    
    protected String getCPTCode()
    {
        return cPTCode;
    }

    
    protected String getCPTMnemonic()
    {
        return cPTMnemonic;
    }

    
    protected String getModality()
    {
        return modality;
    }

    
    protected String getStudyDescription()
    {
        return studyDescription;
    }

    
    protected String getPregnant()
    {
        return pregnant;
    }

    
    protected String getVipIndicator()
    {
        return vipIndicator;
    }

    
    protected Date getAdmitDate()
    {
        return admitDate;
    }

    
    protected String getAdmissionType()
    {
        return admissionType;
    }

    
    protected String getPatientLocationBed()
    {
        return patientLocationBed;
    }

    
    protected String getPatientLocationBuilding()
    {
        return patientLocationBuilding;
    }

    
    protected String getPatientLocationFacility()
    {
        return patientLocationFacility;
    }

    
    protected String getPatientLocationFloor()
    {
        return patientLocationFloor;
    }

    
    protected String getPatientLocationDescription()
    {
        return patientLocationDescription;
    }

    
    protected String getPatientLocationAssigningAuthority()
    {
        return patientLocationAssigningAuthority;
    }

    
    protected String getPatientLocationComprehensiveDescription()
    {
        return patientLocationComprehensiveDescription;
    }

    
    protected String getPatientLocationStatus()
    {
        return patientLocationStatus;
    }

    
    protected String getPatientLocationType()
    {
        return patientLocationType;
    }

    
    protected String getPatientStation()
    {
        return patientStation;
    }

    
    protected String getPatientClass()
    {
        return patientClass;
    }

    
    protected String getReferringDoctorLastName()
    {
        return referringDoctorLastName;
    }

    
    protected String getReferringDoctorFirstName()
    {
        return referringDoctorFirstName;
    }

    
    protected String getReferringDoctorDegree()
    {
        return referringDoctorDegree;
    }

    
    protected String getReferringDoctorFullName()
    {
        return referringDoctorFullName;
    }

    
    protected String getOrderingDoctorLastName()
    {
        return orderingDoctorLastName;
    }

    
    protected String getOrderingDoctorFirstName()
    {
        return orderingDoctorFirstName;
    }

    
    protected String getOrderingDoctorDegree()
    {
        return orderingDoctorDegree;
    }

    
    protected String getOrderingDoctorFullName()
    {
        return orderingDoctorFullName;
    }

    
    protected String getOrderNumber()
    {
        return orderNumber;
    }

    
    protected String getSendingFacility()
    {
        return sendingFacility;
    }

    
    protected String getTechName()
    {
        return techName;
    }

    
    protected String getAuthorizationNumber()
    {
        return authorizationNumber;
    }

    
    protected String getNumberOfFilms()
    {
        return numberOfFilms;
    }

    
    protected String getFilmType()
    {
        return filmType;
    }

    
    protected Date getEffectiveDate()
    {
        return effectiveDate;
    }

    
    protected String getFindings()
    {
        return findings;
    }

    
    protected String getApprovalDate()
    {
        return approvalDate;
    }

    
    protected String getDeliveryDate()
    {
        return deliveryDate;
    }

    
    protected String getModifiers()
    {
        return modifiers;
    }

    
    protected String getDiagnosisCode()
    {
        return diagnosisCode;
    }

    
    protected String getReportId()
    {
        return reportId;
    }

    
    protected String getHl7()
    {
        return hl7;
    }

    
    protected String getCoPayAmount()
    {
        return coPayAmount;
    }

    
    protected String getFeeAmount()
    {
        return feeAmount;
    }

    
    protected String getAllowableAmount()
    {
        return allowableAmount;
    }

    
    protected String getVisitNumber()
    {
        return visitNumber;
    }

    
    protected String getDeductibleAmount()
    {
        return deductibleAmount;
    }

    
    protected String getLoggedAmount()
    {
        return loggedAmount;
    }

    
    protected String getCardChequeNumber()
    {
        return cardChequeNumber;
    }

    
    protected String getExternalVisitId()
    {
        return externalVisitId;
    }

    
    protected String getPaymentMethod()
    {
        return paymentMethod;
    }

    
    protected Date getExpiryDate()
    {
        return expiryDate;
    }

    
    protected String getHospitalService()
    {
        return hospitalService;
    }

    
    protected String getProcedureStartDate()
    {
        return procedureStartDate;
    }

    
    protected String getReasonForExam()
    {
        return reasonForExam;
    }

    
    protected String getPriority()
    {
        return priority;
    }

    
    protected String getProcedureCode()
    {
        return procedureCode;
    }

    
    protected String getProcedureCodeScheme()
    {
        return procedureCodeScheme;
    }

    
    protected String getOrderStatus()
    {
        return orderStatus;
    }

    
    protected String getLaterality()
    {
        return laterality;
    }

    
    protected String getPrincipalResultInterpreter()
    {
        return principalResultInterpreter;
    }

    
    protected String getResponsibleObserver()
    {
        return responsibleObserver;
    }

    
    protected String getRelevantClinicalInformation()
    {
        return relevantClinicalInformation;
    }

    
    protected Collection<Physician> getPhysicians()
    {
        return physicians;
    }

    
    protected String getFollowUpCode()
    {
        return followUpCode;
    }

    
    protected String getGuarantorName()
    {
        return guarantorName;
    }

    
    protected String getGuarantorAddress()
    {
        return guarantorAddress;
    }

    
    protected String getGuarantorPhone()
    {
        return guarantorPhone;
    }

    
    protected Date getGuarantorDOB()
    {
        return guarantorDOB;
    }

    
    protected String getServiceType()
    {
        return serviceType;
    }

    
    protected Date getDateOfService()
    {
        return dateOfService;
    }

    
    protected String getTransportType()
    {
        return transportType;
    }

    
    protected String getInpatientLocation()
    {
        return inpatientLocation;
    }

    
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

    
    protected Date getDischargeDate()
    {
        return dischargeDate;
    }

    
    protected String getInsuredName()
    {
        return insuredName;
    }

    
    protected String getRelationship()
    {
        return relationship;
    }

    protected boolean isReleaseSigned()
    {
        return releaseSigned;
    }

    
    protected String getCoPay()
    {
        return coPay;
    }

    
    protected String getDeductible()
    {
        return deductible;
    }

    
    protected Date getDateSigned()
    {
        return dateSigned;
    }

    
    protected String getCoInsurance()
    {
        return coInsurance;
    }

    
    protected Collection<PatientInsurance> getPatientInsurances()
    {
        return patientInsurances;
    }

    
    protected Collection<VisitInsurance> getVisitInsurances()
    {
        return visitInsurances;
    }

    
    protected Collection<Allergy> getAllergies()
    {
        return allergies;
    }

    
    protected Collection<Referral> getReferrals()
    {
        return referrals;
    }

    
    protected Collection<Medication> getMedications()
    {
        return medications;
    }

    
    protected OrderReport getReport()
    {
        return report;
    }

    
    protected String getUpdatedBy()
    {
        return updatedBy;
    }

    
    protected Date getUpdateTime()
    {
        return updateTime;
    }

    
    protected String getTechNotes()
    {
        return techNotes;
    }

    protected boolean isCritical()
    {
        return critical;
    }

    
    protected String getStudyDate()
    {
        return studyDate;
    }

    
    protected String getStudyTime()
    {
        return studyTime;
    }

    
    protected String getArrivalDate()
    {
        return arrivalDate;
    }

    
    protected String getArrivalTime()
    {
        return arrivalTime;
    }

    
    protected String getAdditionalAccessions()
    {
        return additionalAccessions;
    }

    
    protected UrgentExamType getUrgentExamType()
    {
        return urgentExamType;
    }

    
    protected String getReadingRadiologist()
    {
        return readingRadiologist;
    }


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



    protected DetailedOrderBuilder self()
    {
        return this;
    }
}