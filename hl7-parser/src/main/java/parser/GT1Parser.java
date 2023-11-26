package parser;

import ca.uhn.hl7v2.*;
import ca.uhn.hl7v2.model.v26.datatype.*;
import ca.uhn.hl7v2.model.v26.segment.*;
import com.lakeland.ris.ui.datamodel.*;
import org.jetbrains.annotations.*;

import java.util.*;

public class GT1Parser implements MessageParser<List<GT1>>
{
    @Override public void convert(@NotNull List<GT1> gt1s,
                                  @NotNull DetailedOrderBuilder orderBuilder) throws HL7Exception
    {
        String guarantorName = "";
        String guarantorAddress = "";
        String guarantorPhone = "";
        for (GT1 gt1 : gt1s)
        {
            for (XPN xpn : gt1.getGuarantorName())
            {
                String lastName = xpn.getFamilyName().getSurname().getValue();
                String firstName = xpn.getGivenName().getValue();
                guarantorName += firstName + " " + lastName + ", ";
            }

            for (XAD xad : gt1.getGuarantorAddress())
            {
                String streetAddress = xad.getStreetAddress().getStreetOrMailingAddress().getValue() +
                        ", " +
                        xad.getStreetAddress().getDwellingNumber() +
                        ", " +
                        xad.getStreetAddress().getStreetName();
                String city = xad.getCity().getValue();
                String state = xad.getStateOrProvince().getValue();
                String postcode = xad.getZipOrPostalCode().getValue();

                guarantorAddress += streetAddress + ", " + city + ", " + state + ", " + postcode + " ";
            }

            for (XTN xtn : gt1.getGuarantorPhNumHome())
            {
                guarantorPhone += XTNParser.parseXTN(xtn);
            }

            for (XTN xtn : gt1.getGuarantorPhNumBusiness())
            {
                guarantorPhone += XTNParser.parseXTN(xtn);
            }

            orderBuilder.setGuarantorDOB(gt1.getGuarantorDateTimeOfBirth().getValueAsDate());
        }
        orderBuilder.setGuarantorName(guarantorName);
        orderBuilder.setGuarantorAddress(guarantorAddress);
        orderBuilder.setGuarantorPhone(guarantorPhone);
    }
}
