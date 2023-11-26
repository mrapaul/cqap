package parser;

import ca.uhn.hl7v2.*;
import ca.uhn.hl7v2.model.v26.datatype.*;
import ca.uhn.hl7v2.model.v26.segment.*;
import com.lakeland.ris.ui.datamodel.*;
import org.jetbrains.annotations.*;

import java.util.*;

public class PIDParser implements MessageParser<PID>
{
    @Override public void convert(@NotNull PID pid, @NotNull DetailedOrderBuilder detailedOrderBuilder) throws HL7Exception
    {
        XPN[] patientName = pid.getPatientName();
        CX[] cx = pid.getPatientIdentifierList();

        for (XPN xpn : patientName)
        {
            String firstName = xpn.getGivenName().getValue();
            String middleName = xpn.getSecondAndFurtherGivenNamesOrInitialsThereof().getValue();
            String lastName = xpn.getFamilyName().getFn1_Surname().getValue();
            String suffix = xpn.getSuffixEgJRorIII().getValue();
            detailedOrderBuilder.setPatientFirstName(firstName)
                    .setPatientMiddleName(middleName)
                    .setPatientLastName(lastName)
                    .setPatientSuffix(suffix);
        }

        Date dateOfBirth = pid.getDateTimeOfBirth().getValueAsDate();
        String gender = pid.getAdministrativeSex().getValue();
        for (CX cx1 : cx)
        {
            String patientId = cx1.getIDNumber().getValue();
            if (patientId != null)
            {
                detailedOrderBuilder.setPatientId(patientId);
                break;
            }
        }
        for (CX cx1 : pid.getAlternatePatientIDPID())
        {
            String alternatePatientId = cx1.getIDNumber().getValue();
            detailedOrderBuilder.setAlternatePatientId(alternatePatientId);
        }
        String patientAccountNumber = pid.getPid18_PatientAccountNumber().getIDNumber().getValue();
        for (XAD xad : pid.getPid11_PatientAddress())
        {
            String patientAddressee = xad.getAddressee().getValue();
            String patientAddressType = xad.getAddressType().getValue();
            SAD streetAddress = xad.getStreetAddress();
            String patientAddressStreetAddress = streetAddress.getSad1_StreetOrMailingAddress().getValue();
            String patientAddressStreetName = streetAddress.getSad2_StreetName().getValue();
            String patientAddressBuildingNumber = streetAddress.getSad3_DwellingNumber().getValue();
            String patientAddressCity = xad.getCity().getValue();
            String patientAddressState = xad.getStateOrProvince().getValue();
            String patientAddressZipcode = xad.getZipOrPostalCode().getValue();
            String patientAddressCounty = xad.getCountyParishCode().getValue();
            String patientAddressCountry = xad.getCountry().getValue();
            detailedOrderBuilder.setPatientAddressee(patientAddressee)
                    .setPatientAddressType(patientAddressType)
                    .setPatientStreetAddress(patientAddressStreetAddress)
                    .setPatientStreetName(patientAddressStreetName)
                    .setPatientAddressBuildingNumber(patientAddressBuildingNumber)
                    .setPatientAddressCity(patientAddressCity)
                    .setPatientAddressState(patientAddressState)
                    .setPatientAddressZipcode(patientAddressZipcode)
                    .setPatientAddressCounty(patientAddressCounty)
                    .setPatientAddressCountry(patientAddressCountry);

        }
        String homePhone = "";
        for (XTN xtn : pid.getPhoneNumberHome())
        {
            homePhone += XTNParser.parseXTN(xtn);
        }
        detailedOrderBuilder.setPatientHomePhone(homePhone);

        String workPhone = "";
        for (XTN xtn : pid.getPhoneNumberBusiness())
        {
            workPhone += XTNParser.parseXTN(xtn);
        }
        detailedOrderBuilder.setPatientWorkPhone(workPhone);

        for (CWE cwe : pid.getCitizenship())
        {
            String citizenship = cwe.getIdentifier().getValue();
            detailedOrderBuilder.setPatientCitizenship(citizenship);
        }

        for (XPN alias : pid.getPatientAlias())
        {
            String patientAliasLastName = alias.getFamilyName().getSurname().getValue();
            String patientAliasFirstName = alias.getGivenName().getValue();
            String patientMiddleName = alias.getSecondAndFurtherGivenNamesOrInitialsThereof().getValue();
            detailedOrderBuilder.setPatientAliasLastName(patientAliasLastName)
                    .setPatientAliasFirstName(patientAliasFirstName)
                    .setPatientAliasMiddleName(patientMiddleName);
        }
        String patientSSN = pid.getSSNNumberPatient().getValue();
        detailedOrderBuilder.setPatientBirthDate(dateOfBirth)
                .setPatientSex(gender)
                .setPatientAccountNumber(patientAccountNumber)
                .setPatientSSN(patientSSN);
    }
}
