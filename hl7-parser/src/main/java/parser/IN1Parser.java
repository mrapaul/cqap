package parser;


import ca.uhn.hl7v2.*;
import ca.uhn.hl7v2.model.v26.datatype.*;
import ca.uhn.hl7v2.model.v26.group.*;
import ca.uhn.hl7v2.model.v26.segment.*;
import com.google.common.collect.*;
import com.lakeland.ris.ui.datamodel.*;


import java.util.*;

public class IN1Parser implements MessageParser<List<ADT_A01_INSURANCE>>
{
    @Override public void convert(List<ADT_A01_INSURANCE> insurances,
                                  DetailedOrderBuilder orderBuilder) throws HL7Exception
    {
        List<PatientInsurance> patientInsurances = Lists.newArrayList();
        for (ADT_A01_INSURANCE insurance : insurances)
        {
            IN1 in1 = insurance.getIN1();
            PatientInsuranceBuilder builder = new PatientInsuranceBuilder();
            String groupNumber = in1.getIn18_GroupNumber().getValue();
            String policyNumber = in1.getIn136_PolicyNumber().getValue();
            builder.setPolicyNumber(policyNumber).setGroupNumber(groupNumber);
            for (XTN xtn : in1.getIn17_InsuranceCoPhoneNumber())
            {
                builder.setPhone(XTNParser.parseXTN(xtn));
            }
            for (XON xon : in1.getIn14_InsuranceCompanyName())
            {
                builder.setCarrier(xon.getXon1_OrganizationName().getValue());
            }
            for (XAD xad : in1.getIn15_InsuranceCompanyAddress())
            {
                builder.setAddress(XADParser.getStreetAddress(xad));
                builder.setCity(XADParser.getCity(xad));
                builder.setState(XADParser.getState(xad));
                builder.setZipcode(XADParser.getZipcode(xad));
            }
            String insurancePlanId = in1.getIn12_InsurancePlanID().getCwe1_Identifier().getValue();
            builder.setPlan(insurancePlanId);
            patientInsurances.add(builder.build());
        }
        orderBuilder.setPatientInsurances(patientInsurances);
    }
}
