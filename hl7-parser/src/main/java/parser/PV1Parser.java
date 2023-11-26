package parser;

import ca.uhn.hl7v2.model.*;
import ca.uhn.hl7v2.model.v26.datatype.*;
import ca.uhn.hl7v2.model.v26.segment.*;
import com.lakeland.ris.ui.datamodel.*;
import org.jetbrains.annotations.*;

import java.util.*;

public class PV1Parser implements MessageParser<PV1>
{
    @Override public void convert(@NotNull PV1 pv1, @NotNull DetailedOrderBuilder detailedOrderBuilder) throws DataTypeException
    {
        for (IS is : pv1.getPv115_AmbulatoryStatus())
        {
            detailedOrderBuilder.setPregnant(is.getValue());
        }
        String vipIndicator = pv1.getVIPIndicator().getValue();
        String admissionType = pv1.getAdmissionType().getValue();
        Date admitDate = pv1.getAdmitDateTime().getValueAsDate();
        PL assignedPatientLocation1 = pv1.getAssignedPatientLocation();
        String bed = assignedPatientLocation1.getBed().getValue();
        String building = assignedPatientLocation1.getBuilding().getValue();
        String facility = assignedPatientLocation1.getFacility().getHd1_NamespaceID().getValue();
        String floor = assignedPatientLocation1.getFloor().getValue();
        String locationDescription = assignedPatientLocation1.getLocationDescription().getValue();
        String assigningAuthority =
                assignedPatientLocation1.getAssigningAuthorityForLocation().getUniversalID().getValue();
        String assignedPatientLocationComprehensive =
                assignedPatientLocation1.getComprehensiveLocationIdentifier().getEntityIdentifier().getValue();
        String locationStatus = assignedPatientLocation1.getLocationStatus().getValue();
        String locationType = assignedPatientLocation1.getPersonLocationType().getValue();
        String patientClass = pv1.getPatientClass().getValue();
//        for (XCN xcn : pv1.getReferringDoctor())
//        {
//            String referringDoctorLastName = xcn.getFamilyName().getSurname().getValue();
//            String referringDoctorFirstName = xcn.getGivenName().getValue();
//            String referringDoctorDegree = xcn.getDegreeEgMD().getValue();
//            detailedOrderBuilder.setReferringDoctorLastName(referringDoctorLastName)
//                    .setReferringDoctorFirstName(referringDoctorFirstName)
//                    .setReferringDoctorDegree(referringDoctorDegree)
//                    .setReferringDoctorFullName(referringDoctorFirstName + " " + referringDoctorLastName + " " + referringDoctorDegree);
//        }
        for (XCN xcn : pv1.getAttendingDoctor())
        {
            String referringDoctorLastName = xcn.getFamilyName().getSurname().getValue();
            String referringDoctorFirstName = xcn.getGivenName().getValue();
            String referringDoctorDegree = xcn.getDegreeEgMD().getValue();
            detailedOrderBuilder.setReferringDoctorLastName(referringDoctorLastName)
                    .setReferringDoctorFirstName(referringDoctorFirstName)
                    .setReferringDoctorDegree(referringDoctorDegree);

            String referringName = (referringDoctorFirstName != null ? (referringDoctorFirstName + " ") : "") +
                    (referringDoctorLastName != null ? (referringDoctorLastName + " ") : "") +
                    (referringDoctorDegree != null ? (referringDoctorDegree + " ") : "");
            detailedOrderBuilder.setReferringDoctorFullName(referringName);
        }
        String visitNumber = pv1.getVisitNumber().getIDNumber().getValue();
        String hospitalService = pv1.getHospitalService().getValue();

        detailedOrderBuilder.setVipIndicator(vipIndicator)
                .setAdmissionType(admissionType)
                .setAdmitDate(admitDate)
                .setPatientLocationBed(bed)
                .setPatientLocationBuilding(building)
                .setPatientLocationFloor(floor)
                .setPatientLocationFacility(facility)
                .setPatientLocationDescription(locationDescription)
                .setPatientLocationAssigningAuthority(assigningAuthority)
                .setPatientLocationComprehensiveDescription(assignedPatientLocationComprehensive)
                .setPatientLocationStatus(locationStatus)
                .setPatientLocationType(locationType)
                .setPatientClass(patientClass)
                .setVisitNumber(visitNumber)
                .setHospitalService(hospitalService);
    }
}
