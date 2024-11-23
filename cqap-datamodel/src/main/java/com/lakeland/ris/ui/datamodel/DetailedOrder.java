package com.lakeland.ris.ui.datamodel;

import org.codehaus.jackson.annotate.*;

import java.util.*;
import com.lakeland.ris.datamodel.*;
import java.util.*;

public class DetailedOrder
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

    public DetailedOrder()
    {
        // empty
    }

    @JsonCreator
    public DetailedOrder(String orderId,
                         OrderStatus status,
                         OrderPriority orderPriority,
                         String assignedTo,
                          String dicomStudyId,
                          String patientFirstName,
                          String patientMiddleName,
                          String patientLastName,
                          String patientId,
                          Date patientBirthDate,
                          String patientAge,
                          String patientSex,
                          String patientSuffix,
                          String alternatePatientId,
                          String patientAccountNumber,
                          String patientAddressee,
                          String patientAddressType,
                          String patientStreetAddress,
                          String patientStreetName,
                          String patientAddressBuildingNumber,
                          String patientAddressCity,
                          String patientAddressState,
                          String patientAddressCounty,
                          String patientAddressZipcode,
                          String patientAddressCountry,
                          String patientAliasLastName,
                          String patientAliasFirstName,
                          String patientAliasMiddleName,
                          String patientAlias,
                          String patientSSN,
                          String patientRace,
                          String patientCitizenship,
                          String maritalStatus,
                          String patientEmail,
                          String patientHomePhone,
                          String patientWorkPhone,
                          String patientFax,
                          String patientMobile,
                          String patientOtherPhone,
                          String patientNotificationPreference,
                          String patientEmployer,
                          String patientEmployerStatus,
                          String patientEmployerPhone,
                          String patientStudentStatus,
                          String patientSchool,
                          String patientNoticeOfPrivacy,
                          Date patientDateOfPrivacy,
                          Date patientDateOfDeath,
                          String patientCauseOfDeath,
                          String patientEmergencyContactName,
                          String patientEmergencyContactPhone,
                          String patientPreferredLanguage,
                          String patientSmokingStatus,
                          String patientEthnicity,
                          String patientBirthState,
                          String patientBirthCountry,
                          String patientBirthOrder,
                          String patientMothersLastName,
                          String patientMothersFirstName,
                          String patientMothersMiddleName,
                          String patientMothersMaidenName,
                          String institutionName,
                          String accessionNumber,
                          String cPTCode,
                          String cPTMnemonic,
                          String modality,
                          String studyDescription,
                          String pregnant,
                          String vipIndicator,
                          Date admitDate,
                          String admissionType,
                          String patientLocationBed,
                          String patientLocationBuilding,
                          String patientLocationFacility,
                          String patientLocationFloor,
                          String patientLocationDescription,
                          String patientLocationAssigningAuthority,
                          String patientLocationComprehensiveDescription,
                          String patientLocationStatus,
                          String patientLocationType,
                          String patientStation,
                          String patientClass,
                          String referringDoctorLastName,
                          String referringDoctorFirstName,
                          String referringDoctorDegree,
                          String referringDoctorFullName,
                          String orderingDoctorLastName,
                          String orderingDoctorFirstName,
                          String orderingDoctorDegree,
                          String orderingDoctorFullName,
                          String orderNumber,
                          String sendingFacility,
                          String techName,
                          String authorizationNumber,
                          String numberOfFilms,
                          String filmType,
                          Date effectiveDate,
                          String findings,
                          String approvalDate,
                          String deliveryDate,
                          String modifiers,
                          String diagnosisCode,
                          String reportId,
                          String hl7,
                          String coPayAmount,
                          String feeAmount,
                          String allowableAmount,
                          String visitNumber,
                          String deductibleAmount,
                          String loggedAmount,
                          String cardChequeNumber,
                          String externalVisitId,
                          String paymentMethod,
                          Date expiryDate,
                          String hospitalService,
                          String procedureStartDate,
                          String reasonForExam,
                          String priority,
                          String procedureCode,
                          String procedureCodeScheme,
                          String orderStatus,
                          String laterality,
                          String principalResultInterpreter,
                          String responsibleObserver,
                          String relevantClinicalInformation,
                          Collection<Physician> physicians,
                          String followUpCode,
                          String guarantorName,
                          String guarantorAddress,
                          String guarantorPhone,
                          Date guarantorDOB,
                          String serviceType,
                          Date dateOfService,
                          String transportType,
                          String inpatientLocation,
                          String room,
                         boolean iV,
                         boolean o2,
                         boolean monitor,
                          Date dischargeDate,
                          String insuredName,
                          String relationship,
                         boolean releaseSigned,
                          String coPay,
                          String deductible,
                          Date dateSigned,
                          String coInsurance,
                          Collection<PatientInsurance> patientInsurances,
                          Collection<VisitInsurance> visitInsurances,
                          Collection<Allergy> allergies,
                          Collection<Referral> referrals,
                          Collection<Medication> medications,
                          OrderReport report,
                          String updatedBy,
                          Date updateTime,
                          String techNotes,
                         boolean critical,
                          String studyDate,
                          String studyTime,
                          String arrivalDate,
                          String arrivalTime,
                          String additionalAccessions,
                          UrgentExamType urgentExamType,
                          String readingRadiologist)
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


    public String getOrderId()
    {
        return orderId;
    }


    public OrderStatus getStatus()
    {
        return status;
    }


    public OrderPriority getOrderPriority()
    {
        return orderPriority;
    }


    public String getAssignedTo()
    {
        return assignedTo;
    }

    
    public String getDicomStudyId()
    {
        return dicomStudyId;
    }

    
    public String getPatientFirstName()
    {
        return patientFirstName;
    }

    
    public String getPatientMiddleName()
    {
        return patientMiddleName;
    }

    
    public String getPatientLastName()
    {
        return patientLastName;
    }

    
    public String getPatientId()
    {
        return patientId;
    }

    
    public Date getPatientBirthDate()
    {
        return patientBirthDate;
    }

    
    public String getPatientAge()
    {
        return patientAge;
    }

    
    public String getPatientSex()
    {
        return patientSex;
    }

    
    public String getPatientSuffix()
    {
        return patientSuffix;
    }

    
    public String getAlternatePatientId()
    {
        return alternatePatientId;
    }

    
    public String getPatientAccountNumber()
    {
        return patientAccountNumber;
    }

    
    public String getPatientAddressee()
    {
        return patientAddressee;
    }

    
    public String getPatientAddressType()
    {
        return patientAddressType;
    }

    
    public String getPatientStreetAddress()
    {
        return patientStreetAddress;
    }

    
    public String getPatientStreetName()
    {
        return patientStreetName;
    }

    
    public String getPatientAddressBuildingNumber()
    {
        return patientAddressBuildingNumber;
    }

    
    public String getPatientAddressCity()
    {
        return patientAddressCity;
    }

    
    public String getPatientAddressState()
    {
        return patientAddressState;
    }

    
    public String getPatientAddressCounty()
    {
        return patientAddressCounty;
    }

    
    public String getPatientAddressZipcode()
    {
        return patientAddressZipcode;
    }

    
    public String getPatientAddressCountry()
    {
        return patientAddressCountry;
    }

    
    public String getPatientAliasLastName()
    {
        return patientAliasLastName;
    }

    
    public String getPatientAliasFirstName()
    {
        return patientAliasFirstName;
    }

    
    public String getPatientAliasMiddleName()
    {
        return patientAliasMiddleName;
    }

    
    public String getPatientAlias()
    {
        return patientAlias;
    }

    
    public String getPatientSSN()
    {
        return patientSSN;
    }

    
    public String getPatientRace()
    {
        return patientRace;
    }

    
    public String getPatientCitizenship()
    {
        return patientCitizenship;
    }

    
    public String getMaritalStatus()
    {
        return maritalStatus;
    }

    
    public String getPatientEmail()
    {
        return patientEmail;
    }

    
    public String getPatientHomePhone()
    {
        return patientHomePhone;
    }

    
    public String getPatientWorkPhone()
    {
        return patientWorkPhone;
    }

    
    public String getPatientFax()
    {
        return patientFax;
    }

    
    public String getPatientMobile()
    {
        return patientMobile;
    }

    
    public String getPatientOtherPhone()
    {
        return patientOtherPhone;
    }

    
    public String getPatientNotificationPreference()
    {
        return patientNotificationPreference;
    }

    
    public String getPatientEmployer()
    {
        return patientEmployer;
    }

    
    public String getPatientEmployerStatus()
    {
        return patientEmployerStatus;
    }

    
    public String getPatientEmployerPhone()
    {
        return patientEmployerPhone;
    }

    
    public String getPatientStudentStatus()
    {
        return patientStudentStatus;
    }

    
    public String getPatientSchool()
    {
        return patientSchool;
    }

    
    public String getPatientNoticeOfPrivacy()
    {
        return patientNoticeOfPrivacy;
    }

    
    public Date getPatientDateOfPrivacy()
    {
        return patientDateOfPrivacy;
    }

    
    public Date getPatientDateOfDeath()
    {
        return patientDateOfDeath;
    }

    
    public String getPatientCauseOfDeath()
    {
        return patientCauseOfDeath;
    }

    
    public String getPatientEmergencyContactName()
    {
        return patientEmergencyContactName;
    }

    
    public String getPatientEmergencyContactPhone()
    {
        return patientEmergencyContactPhone;
    }

    
    public String getPatientPreferredLanguage()
    {
        return patientPreferredLanguage;
    }

    
    public String getPatientSmokingStatus()
    {
        return patientSmokingStatus;
    }

    
    public String getPatientEthnicity()
    {
        return patientEthnicity;
    }

    
    public String getPatientBirthState()
    {
        return patientBirthState;
    }

    
    public String getPatientBirthCountry()
    {
        return patientBirthCountry;
    }

    
    public String getPatientBirthOrder()
    {
        return patientBirthOrder;
    }

    
    public String getPatientMothersLastName()
    {
        return patientMothersLastName;
    }

    
    public String getPatientMothersFirstName()
    {
        return patientMothersFirstName;
    }

    
    public String getPatientMothersMiddleName()
    {
        return patientMothersMiddleName;
    }

    
    public String getPatientMothersMaidenName()
    {
        return patientMothersMaidenName;
    }

    
    public String getInstitutionName()
    {
        return institutionName;
    }

    
    public String getAccessionNumber()
    {
        return accessionNumber;
    }

    
    public String getCPTCode()
    {
        return cPTCode;
    }

    
    public String getCPTMnemonic()
    {
        return cPTMnemonic;
    }

    
    public String getModality()
    {
        return modality;
    }

    
    public String getStudyDescription()
    {
        return studyDescription;
    }

    
    public String getPregnant()
    {
        return pregnant;
    }

    
    public String getVipIndicator()
    {
        return vipIndicator;
    }

    
    public Date getAdmitDate()
    {
        return admitDate;
    }

    
    public String getAdmissionType()
    {
        return admissionType;
    }

    
    public String getPatientLocationBed()
    {
        return patientLocationBed;
    }

    
    public String getPatientLocationBuilding()
    {
        return patientLocationBuilding;
    }

    
    public String getPatientLocationFacility()
    {
        return patientLocationFacility;
    }

    
    public String getPatientLocationFloor()
    {
        return patientLocationFloor;
    }

    
    public String getPatientLocationDescription()
    {
        return patientLocationDescription;
    }

    
    public String getPatientLocationAssigningAuthority()
    {
        return patientLocationAssigningAuthority;
    }

    
    public String getPatientLocationComprehensiveDescription()
    {
        return patientLocationComprehensiveDescription;
    }

    
    public String getPatientLocationStatus()
    {
        return patientLocationStatus;
    }

    
    public String getPatientLocationType()
    {
        return patientLocationType;
    }

    
    public String getPatientStation()
    {
        return patientStation;
    }

    
    public String getPatientClass()
    {
        return patientClass;
    }

    
    public String getReferringDoctorLastName()
    {
        return referringDoctorLastName;
    }

    
    public String getReferringDoctorFirstName()
    {
        return referringDoctorFirstName;
    }

    
    public String getReferringDoctorDegree()
    {
        return referringDoctorDegree;
    }

    
    public String getReferringDoctorFullName()
    {
        return referringDoctorFullName;
    }

    
    public String getOrderingDoctorLastName()
    {
        return orderingDoctorLastName;
    }

    
    public String getOrderingDoctorFirstName()
    {
        return orderingDoctorFirstName;
    }

    
    public String getOrderingDoctorDegree()
    {
        return orderingDoctorDegree;
    }

    
    public String getOrderingDoctorFullName()
    {
        return orderingDoctorFullName;
    }

    
    public String getOrderNumber()
    {
        return orderNumber;
    }

    
    public String getSendingFacility()
    {
        return sendingFacility;
    }

    
    public String getTechName()
    {
        return techName;
    }

    
    public String getAuthorizationNumber()
    {
        return authorizationNumber;
    }

    
    public String getNumberOfFilms()
    {
        return numberOfFilms;
    }

    
    public String getFilmType()
    {
        return filmType;
    }

    
    public Date getEffectiveDate()
    {
        return effectiveDate;
    }

    
    public String getFindings()
    {
        return findings;
    }

    
    public String getApprovalDate()
    {
        return approvalDate;
    }

    
    public String getDeliveryDate()
    {
        return deliveryDate;
    }

    
    public String getModifiers()
    {
        return modifiers;
    }

    
    public String getDiagnosisCode()
    {
        return diagnosisCode;
    }

    
    public String getReportId()
    {
        return reportId;
    }

    
    public String getHl7()
    {
        return hl7;
    }

    
    public String getCoPayAmount()
    {
        return coPayAmount;
    }

    
    public String getFeeAmount()
    {
        return feeAmount;
    }

    
    public String getAllowableAmount()
    {
        return allowableAmount;
    }

    
    public String getVisitNumber()
    {
        return visitNumber;
    }

    
    public String getDeductibleAmount()
    {
        return deductibleAmount;
    }

    
    public String getLoggedAmount()
    {
        return loggedAmount;
    }

    
    public String getCardChequeNumber()
    {
        return cardChequeNumber;
    }

    
    public String getExternalVisitId()
    {
        return externalVisitId;
    }

    
    public String getPaymentMethod()
    {
        return paymentMethod;
    }

    
    public Date getExpiryDate()
    {
        return expiryDate;
    }

    
    public String getHospitalService()
    {
        return hospitalService;
    }

    
    public String getProcedureStartDate()
    {
        return procedureStartDate;
    }

    
    public String getReasonForExam()
    {
        return reasonForExam;
    }

    
    public String getPriority()
    {
        return priority;
    }

    
    public String getProcedureCode()
    {
        return procedureCode;
    }

    
    public String getProcedureCodeScheme()
    {
        return procedureCodeScheme;
    }

    
    public String getOrderStatus()
    {
        return orderStatus;
    }

    
    public String getLaterality()
    {
        return laterality;
    }

    
    public String getPrincipalResultInterpreter()
    {
        return principalResultInterpreter;
    }

    
    public String getResponsibleObserver()
    {
        return responsibleObserver;
    }

    
    public String getRelevantClinicalInformation()
    {
        return relevantClinicalInformation;
    }

    
    public Collection<Physician> getPhysicians()
    {
        return physicians;
    }

    
    public String getFollowUpCode()
    {
        return followUpCode;
    }

    
    public String getGuarantorName()
    {
        return guarantorName;
    }

    
    public String getGuarantorAddress()
    {
        return guarantorAddress;
    }

    
    public String getGuarantorPhone()
    {
        return guarantorPhone;
    }

    
    public Date getGuarantorDOB()
    {
        return guarantorDOB;
    }

    
    public String getServiceType()
    {
        return serviceType;
    }

    
    public Date getDateOfService()
    {
        return dateOfService;
    }

    
    public String getTransportType()
    {
        return transportType;
    }

    
    public String getInpatientLocation()
    {
        return inpatientLocation;
    }

    
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

    
    public Date getDischargeDate()
    {
        return dischargeDate;
    }

    
    public String getInsuredName()
    {
        return insuredName;
    }

    
    public String getRelationship()
    {
        return relationship;
    }

    public boolean isReleaseSigned()
    {
        return releaseSigned;
    }

    
    public String getCoPay()
    {
        return coPay;
    }

    
    public String getDeductible()
    {
        return deductible;
    }

    
    public Date getDateSigned()
    {
        return dateSigned;
    }

    
    public String getCoInsurance()
    {
        return coInsurance;
    }

    
    public Collection<PatientInsurance> getPatientInsurances()
    {
        return patientInsurances;
    }

    
    public Collection<VisitInsurance> getVisitInsurances()
    {
        return visitInsurances;
    }

    
    public Collection<Allergy> getAllergies()
    {
        return allergies;
    }

    
    public Collection<Referral> getReferrals()
    {
        return referrals;
    }

    
    public Collection<Medication> getMedications()
    {
        return medications;
    }

    
    public OrderReport getReport()
    {
        return report;
    }

    
    public String getUpdatedBy()
    {
        return updatedBy;
    }

    
    public Date getUpdateTime()
    {
        return updateTime;
    }

    
    public String getTechNotes()
    {
        return techNotes;
    }

    public boolean isCritical()
    {
        return critical;
    }

    
    public String getStudyDate()
    {
        return studyDate;
    }

    
    public String getStudyTime()
    {
        return studyTime;
    }

    
    public String getArrivalDate()
    {
        return arrivalDate;
    }

    
    public String getArrivalTime()
    {
        return arrivalTime;
    }

    
    public String getAdditionalAccessions()
    {
        return additionalAccessions;
    }

    
    public UrgentExamType getUrgentExamType()
    {
        return urgentExamType;
    }

    
    public String getReadingRadiologist()
    {
        return readingRadiologist;
    }
    public void setOrderId(String orderId)
    {
        this.orderId = orderId;
    }

    public void setStatus(OrderStatus status)
    {
        this.status = status;
    }

    public void setOrderPriority(OrderPriority orderPriority)
    {
        this.orderPriority = orderPriority;
    }

    public void setAssignedTo(String assignedTo)
    {
        this.assignedTo = assignedTo;
    }

    public void setDicomStudyId( String dicomStudyId)
    {
        this.dicomStudyId = dicomStudyId;
    }

    public void setPatientFirstName( String patientFirstName)
    {
        this.patientFirstName = patientFirstName;
    }

    public void setPatientMiddleName( String patientMiddleName)
    {
        this.patientMiddleName = patientMiddleName;
    }

    public void setPatientLastName( String patientLastName)
    {
        this.patientLastName = patientLastName;
    }

    public void setPatientId( String patientId)
    {
        this.patientId = patientId;
    }

    public void setPatientBirthDate( Date patientBirthDate)
    {
        this.patientBirthDate = patientBirthDate;
    }

    public void setPatientAge( String patientAge)
    {
        this.patientAge = patientAge;
    }

    public void setPatientSex( String patientSex)
    {
        this.patientSex = patientSex;
    }

    public void setPatientSuffix( String patientSuffix)
    {
        this.patientSuffix = patientSuffix;
    }

    public void setAlternatePatientId( String alternatePatientId)
    {
        this.alternatePatientId = alternatePatientId;
    }

    public void setPatientAccountNumber( String patientAccountNumber)
    {
        this.patientAccountNumber = patientAccountNumber;
    }

    public void setPatientAddressee( String patientAddressee)
    {
        this.patientAddressee = patientAddressee;
    }

    public void setPatientAddressType( String patientAddressType)
    {
        this.patientAddressType = patientAddressType;
    }

    public void setPatientStreetAddress( String patientStreetAddress)
    {
        this.patientStreetAddress = patientStreetAddress;
    }

    public void setPatientStreetName( String patientStreetName)
    {
        this.patientStreetName = patientStreetName;
    }

    public void setPatientAddressBuildingNumber( String patientAddressBuildingNumber)
    {
        this.patientAddressBuildingNumber = patientAddressBuildingNumber;
    }

    public void setPatientAddressCity( String patientAddressCity)
    {
        this.patientAddressCity = patientAddressCity;
    }

    public void setPatientAddressState( String patientAddressState)
    {
        this.patientAddressState = patientAddressState;
    }

    public void setPatientAddressCounty( String patientAddressCounty)
    {
        this.patientAddressCounty = patientAddressCounty;
    }

    public void setPatientAddressZipcode( String patientAddressZipcode)
    {
        this.patientAddressZipcode = patientAddressZipcode;
    }

    public void setPatientAddressCountry( String patientAddressCountry)
    {
        this.patientAddressCountry = patientAddressCountry;
    }

    public void setPatientAliasLastName( String patientAliasLastName)
    {
        this.patientAliasLastName = patientAliasLastName;
    }

    public void setPatientAliasFirstName( String patientAliasFirstName)
    {
        this.patientAliasFirstName = patientAliasFirstName;
    }

    public void setPatientAliasMiddleName( String patientAliasMiddleName)
    {
        this.patientAliasMiddleName = patientAliasMiddleName;
    }

    public void setPatientAlias( String patientAlias)
    {
        this.patientAlias = patientAlias;
    }

    public void setPatientSSN( String patientSSN)
    {
        this.patientSSN = patientSSN;
    }

    public void setPatientRace( String patientRace)
    {
        this.patientRace = patientRace;
    }

    public void setPatientCitizenship( String patientCitizenship)
    {
        this.patientCitizenship = patientCitizenship;
    }

    public void setMaritalStatus( String maritalStatus)
    {
        this.maritalStatus = maritalStatus;
    }

    public void setPatientEmail( String patientEmail)
    {
        this.patientEmail = patientEmail;
    }

    public void setPatientHomePhone( String patientHomePhone)
    {
        this.patientHomePhone = patientHomePhone;
    }

    public void setPatientWorkPhone( String patientWorkPhone)
    {
        this.patientWorkPhone = patientWorkPhone;
    }

    public void setPatientFax( String patientFax)
    {
        this.patientFax = patientFax;
    }

    public void setPatientMobile( String patientMobile)
    {
        this.patientMobile = patientMobile;
    }

    public void setPatientOtherPhone( String patientOtherPhone)
    {
        this.patientOtherPhone = patientOtherPhone;
    }

    public void setPatientNotificationPreference( String patientNotificationPreference)
    {
        this.patientNotificationPreference = patientNotificationPreference;
    }

    public void setPatientEmployer( String patientEmployer)
    {
        this.patientEmployer = patientEmployer;
    }

    public void setPatientEmployerStatus( String patientEmployerStatus)
    {
        this.patientEmployerStatus = patientEmployerStatus;
    }

    public void setPatientEmployerPhone( String patientEmployerPhone)
    {
        this.patientEmployerPhone = patientEmployerPhone;
    }

    public void setPatientStudentStatus( String patientStudentStatus)
    {
        this.patientStudentStatus = patientStudentStatus;
    }

    public void setPatientSchool( String patientSchool)
    {
        this.patientSchool = patientSchool;
    }

    public void setPatientNoticeOfPrivacy( String patientNoticeOfPrivacy)
    {
        this.patientNoticeOfPrivacy = patientNoticeOfPrivacy;
    }

    public void setPatientDateOfPrivacy( Date patientDateOfPrivacy)
    {
        this.patientDateOfPrivacy = patientDateOfPrivacy;
    }

    public void setPatientDateOfDeath( Date patientDateOfDeath)
    {
        this.patientDateOfDeath = patientDateOfDeath;
    }

    public void setPatientCauseOfDeath( String patientCauseOfDeath)
    {
        this.patientCauseOfDeath = patientCauseOfDeath;
    }

    public void setPatientEmergencyContactName( String patientEmergencyContactName)
    {
        this.patientEmergencyContactName = patientEmergencyContactName;
    }

    public void setPatientEmergencyContactPhone( String patientEmergencyContactPhone)
    {
        this.patientEmergencyContactPhone = patientEmergencyContactPhone;
    }

    public void setPatientPreferredLanguage( String patientPreferredLanguage)
    {
        this.patientPreferredLanguage = patientPreferredLanguage;
    }

    public void setPatientSmokingStatus( String patientSmokingStatus)
    {
        this.patientSmokingStatus = patientSmokingStatus;
    }

    public void setPatientEthnicity( String patientEthnicity)
    {
        this.patientEthnicity = patientEthnicity;
    }

    public void setPatientBirthState( String patientBirthState)
    {
        this.patientBirthState = patientBirthState;
    }

    public void setPatientBirthCountry( String patientBirthCountry)
    {
        this.patientBirthCountry = patientBirthCountry;
    }

    public void setPatientBirthOrder( String patientBirthOrder)
    {
        this.patientBirthOrder = patientBirthOrder;
    }

    public void setPatientMothersLastName( String patientMothersLastName)
    {
        this.patientMothersLastName = patientMothersLastName;
    }

    public void setPatientMothersFirstName( String patientMothersFirstName)
    {
        this.patientMothersFirstName = patientMothersFirstName;
    }

    public void setPatientMothersMiddleName( String patientMothersMiddleName)
    {
        this.patientMothersMiddleName = patientMothersMiddleName;
    }

    public void setPatientMothersMaidenName( String patientMothersMaidenName)
    {
        this.patientMothersMaidenName = patientMothersMaidenName;
    }

    public void setInstitutionName( String institutionName)
    {
        this.institutionName = institutionName;
    }

    public void setAccessionNumber( String accessionNumber)
    {
        this.accessionNumber = accessionNumber;
    }

    public void setCPTCode( String cPTCode)
    {
        this.cPTCode = cPTCode;
    }

    public void setCPTMnemonic( String cPTMnemonic)
    {
        this.cPTMnemonic = cPTMnemonic;
    }

    public void setModality( String modality)
    {
        this.modality = modality;
    }

    public void setStudyDescription( String studyDescription)
    {
        this.studyDescription = studyDescription;
    }

    public void setPregnant( String pregnant)
    {
        this.pregnant = pregnant;
    }

    public void setVipIndicator( String vipIndicator)
    {
        this.vipIndicator = vipIndicator;
    }

    public void setAdmitDate( Date admitDate)
    {
        this.admitDate = admitDate;
    }

    public void setAdmissionType( String admissionType)
    {
        this.admissionType = admissionType;
    }

    public void setPatientLocationBed( String patientLocationBed)
    {
        this.patientLocationBed = patientLocationBed;
    }

    public void setPatientLocationBuilding( String patientLocationBuilding)
    {
        this.patientLocationBuilding = patientLocationBuilding;
    }

    public void setPatientLocationFacility( String patientLocationFacility)
    {
        this.patientLocationFacility = patientLocationFacility;
    }

    public void setPatientLocationFloor( String patientLocationFloor)
    {
        this.patientLocationFloor = patientLocationFloor;
    }

    public void setPatientLocationDescription( String patientLocationDescription)
    {
        this.patientLocationDescription = patientLocationDescription;
    }

    public void setPatientLocationAssigningAuthority( String patientLocationAssigningAuthority)
    {
        this.patientLocationAssigningAuthority = patientLocationAssigningAuthority;
    }

    public void setPatientLocationComprehensiveDescription( String patientLocationComprehensiveDescription)
    {
        this.patientLocationComprehensiveDescription = patientLocationComprehensiveDescription;
    }

    public void setPatientLocationStatus( String patientLocationStatus)
    {
        this.patientLocationStatus = patientLocationStatus;
    }

    public void setPatientLocationType( String patientLocationType)
    {
        this.patientLocationType = patientLocationType;
    }

    public void setPatientStation( String patientStation)
    {
        this.patientStation = patientStation;
    }

    public void setPatientClass( String patientClass)
    {
        this.patientClass = patientClass;
    }

    public void setReferringDoctorLastName( String referringDoctorLastName)
    {
        this.referringDoctorLastName = referringDoctorLastName;
    }

    public void setReferringDoctorFirstName( String referringDoctorFirstName)
    {
        this.referringDoctorFirstName = referringDoctorFirstName;
    }

    public void setReferringDoctorDegree( String referringDoctorDegree)
    {
        this.referringDoctorDegree = referringDoctorDegree;
    }

    public void setReferringDoctorFullName( String referringDoctorFullName)
    {
        this.referringDoctorFullName = referringDoctorFullName;
    }

    public void setOrderingDoctorLastName( String orderingDoctorLastName)
    {
        this.orderingDoctorLastName = orderingDoctorLastName;
    }

    public void setOrderingDoctorFirstName( String orderingDoctorFirstName)
    {
        this.orderingDoctorFirstName = orderingDoctorFirstName;
    }

    public void setOrderingDoctorDegree( String orderingDoctorDegree)
    {
        this.orderingDoctorDegree = orderingDoctorDegree;
    }

    public void setOrderingDoctorFullName( String orderingDoctorFullName)
    {
        this.orderingDoctorFullName = orderingDoctorFullName;
    }

    public void setOrderNumber( String orderNumber)
    {
        this.orderNumber = orderNumber;
    }

    public void setSendingFacility( String sendingFacility)
    {
        this.sendingFacility = sendingFacility;
    }

    public void setTechName( String techName)
    {
        this.techName = techName;
    }

    public void setAuthorizationNumber( String authorizationNumber)
    {
        this.authorizationNumber = authorizationNumber;
    }

    public void setNumberOfFilms( String numberOfFilms)
    {
        this.numberOfFilms = numberOfFilms;
    }

    public void setFilmType( String filmType)
    {
        this.filmType = filmType;
    }

    public void setEffectiveDate( Date effectiveDate)
    {
        this.effectiveDate = effectiveDate;
    }

    public void setFindings( String findings)
    {
        this.findings = findings;
    }

    public void setApprovalDate( String approvalDate)
    {
        this.approvalDate = approvalDate;
    }

    public void setDeliveryDate( String deliveryDate)
    {
        this.deliveryDate = deliveryDate;
    }

    public void setModifiers( String modifiers)
    {
        this.modifiers = modifiers;
    }

    public void setDiagnosisCode( String diagnosisCode)
    {
        this.diagnosisCode = diagnosisCode;
    }

    public void setReportId( String reportId)
    {
        this.reportId = reportId;
    }

    public void setHl7( String hl7)
    {
        this.hl7 = hl7;
    }

    public void setCoPayAmount( String coPayAmount)
    {
        this.coPayAmount = coPayAmount;
    }

    public void setFeeAmount( String feeAmount)
    {
        this.feeAmount = feeAmount;
    }

    public void setAllowableAmount( String allowableAmount)
    {
        this.allowableAmount = allowableAmount;
    }

    public void setVisitNumber( String visitNumber)
    {
        this.visitNumber = visitNumber;
    }

    public void setDeductibleAmount( String deductibleAmount)
    {
        this.deductibleAmount = deductibleAmount;
    }

    public void setLoggedAmount( String loggedAmount)
    {
        this.loggedAmount = loggedAmount;
    }

    public void setCardChequeNumber( String cardChequeNumber)
    {
        this.cardChequeNumber = cardChequeNumber;
    }

    public void setExternalVisitId( String externalVisitId)
    {
        this.externalVisitId = externalVisitId;
    }

    public void setPaymentMethod( String paymentMethod)
    {
        this.paymentMethod = paymentMethod;
    }

    public void setExpiryDate( Date expiryDate)
    {
        this.expiryDate = expiryDate;
    }

    public void setHospitalService( String hospitalService)
    {
        this.hospitalService = hospitalService;
    }

    public void setProcedureStartDate( String procedureStartDate)
    {
        this.procedureStartDate = procedureStartDate;
    }

    public void setReasonForExam( String reasonForExam)
    {
        this.reasonForExam = reasonForExam;
    }

    public void setPriority( String priority)
    {
        this.priority = priority;
    }

    public void setProcedureCode( String procedureCode)
    {
        this.procedureCode = procedureCode;
    }

    public void setProcedureCodeScheme( String procedureCodeScheme)
    {
        this.procedureCodeScheme = procedureCodeScheme;
    }

    public void setOrderStatus( String orderStatus)
    {
        this.orderStatus = orderStatus;
    }

    public void setLaterality( String laterality)
    {
        this.laterality = laterality;
    }

    public void setPrincipalResultInterpreter( String principalResultInterpreter)
    {
        this.principalResultInterpreter = principalResultInterpreter;
    }

    public void setResponsibleObserver( String responsibleObserver)
    {
        this.responsibleObserver = responsibleObserver;
    }

    public void setRelevantClinicalInformation( String relevantClinicalInformation)
    {
        this.relevantClinicalInformation = relevantClinicalInformation;
    }

    public void setPhysicians( Collection<Physician> physicians)
    {
        this.physicians = physicians;
    }

    public void setFollowUpCode( String followUpCode)
    {
        this.followUpCode = followUpCode;
    }

    public void setGuarantorName( String guarantorName)
    {
        this.guarantorName = guarantorName;
    }

    public void setGuarantorAddress( String guarantorAddress)
    {
        this.guarantorAddress = guarantorAddress;
    }

    public void setGuarantorPhone( String guarantorPhone)
    {
        this.guarantorPhone = guarantorPhone;
    }

    public void setGuarantorDOB( Date guarantorDOB)
    {
        this.guarantorDOB = guarantorDOB;
    }

    public void setServiceType( String serviceType)
    {
        this.serviceType = serviceType;
    }

    public void setDateOfService( Date dateOfService)
    {
        this.dateOfService = dateOfService;
    }

    public void setTransportType( String transportType)
    {
        this.transportType = transportType;
    }

    public void setInpatientLocation( String inpatientLocation)
    {
        this.inpatientLocation = inpatientLocation;
    }

    public void setRoom( String room)
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

    public void setDischargeDate( Date dischargeDate)
    {
        this.dischargeDate = dischargeDate;
    }

    public void setInsuredName( String insuredName)
    {
        this.insuredName = insuredName;
    }

    public void setRelationship( String relationship)
    {
        this.relationship = relationship;
    }

    public void setReleaseSigned(boolean releaseSigned)
    {
        this.releaseSigned = releaseSigned;
    }

    public void setCoPay( String coPay)
    {
        this.coPay = coPay;
    }

    public void setDeductible( String deductible)
    {
        this.deductible = deductible;
    }

    public void setDateSigned( Date dateSigned)
    {
        this.dateSigned = dateSigned;
    }

    public void setCoInsurance( String coInsurance)
    {
        this.coInsurance = coInsurance;
    }

    public void setPatientInsurances( Collection<PatientInsurance> patientInsurances)
    {
        this.patientInsurances = patientInsurances;
    }

    public void setVisitInsurances( Collection<VisitInsurance> visitInsurances)
    {
        this.visitInsurances = visitInsurances;
    }

    public void setAllergies( Collection<Allergy> allergies)
    {
        this.allergies = allergies;
    }

    public void setReferrals( Collection<Referral> referrals)
    {
        this.referrals = referrals;
    }

    public void setMedications( Collection<Medication> medications)
    {
        this.medications = medications;
    }

    public void setReport( OrderReport report)
    {
        this.report = report;
    }

    public void setUpdatedBy( String updatedBy)
    {
        this.updatedBy = updatedBy;
    }

    public void setUpdateTime( Date updateTime)
    {
        this.updateTime = updateTime;
    }

    public void setTechNotes( String techNotes)
    {
        this.techNotes = techNotes;
    }

    public void setCritical(boolean critical)
    {
        this.critical = critical;
    }

    public void setStudyDate( String studyDate)
    {
        this.studyDate = studyDate;
    }

    public void setStudyTime( String studyTime)
    {
        this.studyTime = studyTime;
    }

    public void setArrivalDate( String arrivalDate)
    {
        this.arrivalDate = arrivalDate;
    }

    public void setArrivalTime( String arrivalTime)
    {
        this.arrivalTime = arrivalTime;
    }

    public void setAdditionalAccessions( String additionalAccessions)
    {
        this.additionalAccessions = additionalAccessions;
    }

    public void setUrgentExamType( UrgentExamType urgentExamType)
    {
        this.urgentExamType = urgentExamType;
    }

    public void setReadingRadiologist( String readingRadiologist)
    {
        this.readingRadiologist = readingRadiologist;
    }


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