package parser;

import ca.uhn.hl7v2.*;
import ca.uhn.hl7v2.model.*;
import ca.uhn.hl7v2.model.v26.message.*;
import ca.uhn.hl7v2.parser.*;
import ca.uhn.hl7v2.validation.impl.*;
import com.lakeland.hl7.datamodel.*;
import com.lakeland.ris.datamodel.*;
import com.lakeland.ris.ui.datamodel.*;
import org.junit.*;
import org.mockito.*;

import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class OMG_O19ParserTest
{

    @Mock private HL7Order hl7Order;
    @Mock private HL7ParserHandler handler;

    @Before
    public void setUp() throws Exception
    {
        MockitoAnnotations.initMocks(this);

    }

    @Test
    public void testParser() throws Exception
    {
        when(hl7Order.getOrderId()).thenReturn("ORDERID");
        when(hl7Order.getStatus()).thenReturn(OrderStatus.ORDERED);

        String message = "MSH|^~\\&|CPSI^1.3.6.1.4.1.27248.1.17^ISO|Colorado River Medical Center^Facility OID^ISO|Receiving App^Receiving App OID^ISO|Receiving Fac^Receiving Fac OID^ISO|20141208053748-0800||OMG^O19^OMG_O19|2014120805374842|P|2.5.1||\rSFT|CPSI|19|CPSI|1916.82||20141125\rEVN|O01|2014120805374779^YYYYMMDDHHMMSS.SS|20141204000000^YYYYMMDDHHMM|03|cu54884|2014120805374779^YYYYMMDDHHMMSS.SS|Colorado River Medical Center^1.3.6.1.4.1.27248.2.1273.1^ISO\rPID|1||00050035^^^CPSI&1.3.6.1.4.1.27248.2.1427.1&ISO^MR^Colorado River Medical Center&Facility OID&ISO~20014997^^^CPSI&1.3.6.1.4.1.27248.2.1427.1&ISO^VN^Colorado River Medical Center&Facility OID&ISO~00002775^^^CPSI&1.3.6.1.4.1.27248.2.1427.1&ISO^PN^Colorado River Medical Center&Facility OID&ISO~562882959^^^HL7&2.16.840.1.113883.4.1&ISO^SS^Colorado River Medical Center&Facility OID&ISO|00050035|CARRIGAN^CHESTER^R^^^^L|^^^^^^U|19540607^YYYYMMDD|M||W^WHITE^CPSI|212 CHESTNUT ST^^NEEDLES^CA^92363^USA^M^SAN BERNARDINO^136|136|7606780421^PRN^PH^^1^760^6780421|7603269260^WPN^PH^^1^760^3269260|English^^HL70296|S^^HL70002|NN^NONE^HL70006|20014997^^^CPSI&1.3.6.1.4.1.27248.2.1427.1&ISO^AN^Colorado River Medical Center&Facility OID&ISO|562882959^^^CPSI&1.3.6.1.4.1.27248.2.1427.1&ISO^SS^Colorado River Medical Center&Facility OID&ISO|||N^Not Hispanic or Latino^HL70189|^POMONA CA|||||W||N\rPD1|U|||600029^ANDERSON^DONOVAN^J||||||||Y|20130903000000||N|U\rNK1|1|CARRIGAN^KEVIN^M^^^^L|EMC|42977 BEDFORD DR^^NEWBERRY SPRINGS^CA^92365^USA|7602570945^PRN^PH^^1^760^2570945|7603265415^WPN^PH^^1^760^3265415|C^Emergency Contact^HL70131||||||||||||||||||||||Emergency\rNK1|\rPV1|1|I^I/P^00|010^1072^^Colorado River Medical Center&Facility OID&ISO|U|||600029^ANDERSON^DONOVAN^J^^DR^^^CPSI&1.3.6.1.4.1.27248.2.1427.1&ISO^L^^^FI^Colorado River Medical Center&Facility OID&ISO~A50917^^^^^^^^Centers for Medicare and Medicaid Services&2.16.840.1.113883.4.8&ISO^^^^UPIN~1356333058^^^^^^^^National Provider ID&2.16.840.1.113883.4.6&ISO^^^^NPI|^^^^^DR^^^CPSI&1.3.6.1.4.1.27248.2.1427.1&ISO^L^^^FI^Colorado River Medical Center&Facility OID&ISO|^^^^^DR^^^CPSI&1.3.6.1.4.1.27248.2.1427.1&ISO^L^^^FI^Colorado River Medical Center&Facility OID&ISO|MS^MED SURG|^^^^^^^^|||ER|||600029^ANDERSON^DONOVAN^J^^DR^^^CPSI&1.3.6.1.4.1.27248.2.1427.1&ISO^L^^^FI^Colorado River Medical Center&Facility OID&ISO~A50917^^^^^^^^Centers for Medicare and Medicaid Services&2.16.840.1.113883.4.8&ISO^^^^UPIN~1356333058^^^^^^^^National Provider ID&2.16.840.1.113883.4.6&ISO^^^^NPI|1^I/P^00|20014997^^^CPSI&1.3.6.1.4.1.27248.2.1427.1&ISO^AN^Colorado River Medical Center&Facility OID&ISO|XI|||||||||N|||||||^||Regular||||||20141204164500||    19804.12|    19804.12|         .00|0|00002775^^^CPSI&1.3.6.1.4.1.27248.2.1427.1&ISO^PN^Colorado River Medical Center&Facility OID&ISO|V\rPV2||S|RT PNEUMOTHORAX S/P FALL WITH CONTUSIONS||||F|20141204000000||||||||||||||N|||||||||||||||N||||||F|||N\rAL1|1|DA|00000193^PENICILLIN^MICROMEDEX|MO^MODERATE|ABD PAIN\rAL1|2|DA|00000386^CODEINE^MICROMEDEX|MO^MODERATE|ABD PAIN\rGT1|1||CARRIGAN^CHESTER^R||212 CHESTNUT ST^^NEEDLES^CA^92363^1|7606780421^PRN^PH^^1^760^6780421||19540607|M|||562882959|||1|SB COUNTY AGING SRVC|^^NEEDLES^CA^92363^1|7603269260^PRN^PH^^1^760^3269260|||||||||||999||||||||||||||||||||IHSSSC||SB COUNTY AGING SRVC\rIN1|1|^^CPSI|XI|MEDI-CAL IP^L^^^^CPSI&1.3.6.1.4.1.27248.2.1427.1&ISO^NII^Colorado River Medical Center&Facility OID&ISO^A^XI|PO BOX 15500^^SACRAMENTO^CA^95813^USA^L^^||8005415555^ASN^PH^^1^800^5415555||^L^^^^CPSI&1.3.6.1.4.1.27248.2.1427.1&ISO^NII^Colorado River Medical Center&Facility OID&ISO^L^|999^^^CPSI&1.3.6.1.4.1.27248.2.1427.1&ISO^EI^Colorado River Medical Center&Facility OID&ISO^|SB COUNTY AGING SRVC^L^^^^CPSI&1.3.6.1.4.1.27248.2.1427.1&ISO^EI^Colorado River Medical Center&Facility OID&ISO^L^|||^^||CARRIGAN^CHESTER^R^^^^L|18^^CPSI|19540607|212 CHESTNUT ST^^NEEDLES^CA^92363||||||||||20141204|||||||93178247E34275|     .00||000|     .00|||M|\rIN2||1|||||||||||||||||||     .00\rACC|201412041414|FALL^^CPSI|05|CA^^CPSI||||FALL\rORC|SC|281397720141208^CPSI^1.3.6.1.4.1.27248.1.17^ISO|^Filler App Name^Filler OID^ISO||CM||||201412080516|AF||600029^ANDERSON^DONOVAN^J^^DR^^^CPSI&1.3.6.1.4.1.27248.2.1427.1&ISO^L^^^FI^Colorado River Medical Center&Facility OID&ISO|010||||||||Colorado River Medical Center^^^^^Facility_Name&Facility_OID&ISO^XX^^^010|||1401 BAILY AVE&1402 BAILEY AVENUE^^NEEDLES^CA^92363^US^\rTQ1|1|001|||||||R\rOBR|1|281397720141208||2806551^CHEST 1 VIEW^L^^||201412080516|||||L||CHEST 1 VIEW~{REASON FOR CHEST:  TUBE PLACEMENT~{Transportation:  PORT                IV: Y  O2: N  Pregnancy: N~HX tob use: Y  HX CA: N  HX surg: N  HX Lung/Heart Diesase: N||^^^|600029^ANDERSON^DONOVAN^J||XR|20141208053700|||||RAD|P||001^^^20141208080000^^R|600029||||^^^|^^^|CU||||||||||71010\rSPM|1||||||||||P^Patient^HL70369|||||||\r";
        CanonicalModelClassFactory mcf = new CanonicalModelClassFactory("2.6");
        HapiContext context = new DefaultHapiContext();
        context.setValidationContext(new NoValidation());
        context.setModelClassFactory(mcf);
        PipeParser parser = context.getPipeParser();
        Message hapiMsg = parser.parse(message);

        assertThat(hapiMsg).isInstanceOf(OMG_O19.class);

        OMGParser oruParser = new OMGParser();
        DetailedOrderBuilder detailedOrderBuilder = new DetailedOrderBuilder("TEST", OrderStatus.ORDERED, OrderPriority.Low, "Server");
        oruParser.convert((OMG_O19) hapiMsg, detailedOrderBuilder);

        DetailedOrder order = detailedOrderBuilder.build();

        assertThat(order).isNotNull();

        HL7Parser hl7Parser = new HL7Parser();
        hl7Parser.parse(hapiMsg, handler);

        ArgumentCaptor<DisplayOrder> captor = ArgumentCaptor.forClass(DisplayOrder.class);
        verify(handler).onDisplayOrder(captor.capture());
        DisplayOrder displayOrder = captor.getValue();

        assertThat(displayOrder).isNotNull();
    }
}
