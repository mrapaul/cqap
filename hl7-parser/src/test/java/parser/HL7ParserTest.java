package parser;

import ca.uhn.hl7v2.*;
import ca.uhn.hl7v2.model.*;
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

public class HL7ParserTest
{
    @Mock private HL7Order hl7Order;
    @Mock private HL7ParserHandler handler;

    @Before
    public void setUp() throws Exception
    {
        MockitoAnnotations.initMocks(this);

    }

    @Test
    public void shouldParseORMMessageToOrder() throws Exception
    {
        when(hl7Order.getOrderId()).thenReturn("ORDERID");
        when(hl7Order.getStatus()).thenReturn(OrderStatus.ORDERED);

        String msg =
                "MSH|^~\\&|IIM|MCH.LIVE|ITSORD.ERAD|eRAD|201311181125||ORM^O01|1064057101.1.364306.001|P|2.3|||AL||||\rPID|1||M000012345||LASTNAME^FIRSTNAME^MIDDLE||19700101|F||CA|1234 MAIN STREET^^ERIE^PA^16501||(814)555-1234^^^^^814^5551234|||S|NO|H00001234567|123-45-6789|||||||||||\rPD1||||HANDAN^HANSEN^DANIELLE^M. D.O.||||||||\rPV1|1|I|ACE^ACE11^1^MCH|EL|||FERJOH^FERRETTI^JOHN^M. D.O.||FIEVIN^FIERRO^VINCENT^S. D.O.^JR.|ACE||||CPO|||FERJOH^FERRETTI^JOHN^M. D.O.|IN||MAMC|||||||||||||||||||MCH||ADM IN|||201311151249||||||||HANDAN^HANSEN^DANIELLE^M. D.O.|\rORC|CA|364306.001|364306.001||CA||1^^^20131118^^R||201311181124|CMZM3023^Zalas^Christine||FERJOH^FERRETTI^JOHN^M. D.O.||||DUPLICATE ORDER||RADIOLOGY7|MESM3421^Stein^Megan|\rOBR|1|364306.001|364306.001|GENM^GASTRIC EMPTYING^NM|X|201311180916|201311180916|||||||||FERJOH^FERRETTI^JOHN^M. D.O.|||||||||||1^^^20131118^^R|\rOBX|1|TX|DIREAS^Reason for exam|1|NAUSEA||||||||||||\rOBX|2|TX|ITS.RAD247^Send Order to RAD 24x7|2|Y||||||||||||";
        CanonicalModelClassFactory mcf = new CanonicalModelClassFactory("2.6");
        HapiContext context = new DefaultHapiContext();
        context.setValidationContext(new NoValidation());
        context.setModelClassFactory(mcf);
        PipeParser parser = context.getPipeParser();
        Message hapiMsg = parser.parse(msg);

        HL7Parser hl7Parser = new HL7Parser();
        hl7Parser.parse(hapiMsg, handler);

        ArgumentCaptor<DisplayOrder> captor = ArgumentCaptor.forClass(DisplayOrder.class);
        verify(handler).onDisplayOrder(captor.capture());
        DisplayOrder order = captor.getValue();

        assertThat(order).isNotNull();
    }

    @Test
    public void testWeirdWARMC() throws Exception
    {
        String msg = "MSH|^~\\&|PATACCT|WARMC|MCKESSON|163|20141230103510||ORM^O01|74484522|P|2.3|74484522||||US|\r" +
                "EVN|O01|20141230103510|||KCO|\r" +
                "PID|1||219049||HERNANDEZ^MARTIN||19680117|M||W|2103 LONESTAR DR^^MOHAVE VALLEY^AZ^86440|015|(928)514-5129||E    |M|C|1301365|601787236|||2^NOT HISPANIC OR LATINO|MEXICO|||||\r" +
                "PD1||||287^ZEHRI^WAHEED|||N||||N|N^N|\r" +
                "NK1|1|PAYNE^CARLOS|21^UNKNOWN||(928)768-4580||21^UNKNOWN|||||||||||||||||||||||||||||||\r" +
                "PV1|1|O|IOP|3|||7352^CID^RODRIGO^MARAMBA|||IOP||||1||N|7352^CID^RODRIGO^MARAMBA|E||M||||||||||||||||01^DISCHARGED HOME/SELF CARE||||||||20141230103000|20141230103000||||||\r" +
                "PV2|||CHRONIC COUGH|||||||||||20140114||||||||N||||20140114|\r" +
                "DG1|1|||CHRONIC COUGH|||||||||||||\r" +
                "GT1|1|2023130|HERNANDEZ^MARTIN||2103 LONESTAR DR^^MOHAVE VALLEY^AZ^86440|(928)514-5129||19680117|M||18^SELF|601787236|||1|AKAKAWAME|||||||||||||||||||||||||||||||||MECHANIC|||||W||\r" +
                "IN1|1|2|980|MEDICARE MUTUAL OF OMAHA|PO BOX 1602^^OMAHA^NE^68101||(866)734-6656||||AKAKAWAME|||NAR|M|HERNANDEZ^MARTIN|18^SELF|19680117||Y|CO|1|||||Y|||||||||601787236A||||||6|M||Y||3|||\r" +
                "IN2||||||||||||||||||||||||||||||||||||||||||||||DISABLED|\r" +
                "ACC|20090501|18|\r" +
                "UB2|1||||||18^20090501|||||||||| \r" +
                "ZEM|0027132^AKAKAWAME||(000)-|DISABLED||\r" +
                "ORC|NW|100^ORDENT||||D|||20141230104500|EWINGC||7352^CID^RODRIGO^MARAMBA|IOP||20141230104500||0163|221342||\r" +
                "OBR|1|100^ORDENT||HRCHEST2^CHEST 2 VW^IOP||||20141230104500|||||||^^^|7352||0000100|IOP|13013650000100|000219049|||IOP|||\"\"^\"\"^\"\"^20141230104500^\"\"^R^\"\"^\"\"^\"\"^\"\"||||||||||\r" +
                "NTE|1|P|CHRONIC COUGH|GI^Current HX  :|\r";

        CanonicalModelClassFactory mcf = new CanonicalModelClassFactory("2.6");
        HapiContext context = new DefaultHapiContext();
        context.setValidationContext(new NoValidation());
        context.setModelClassFactory(mcf);
        PipeParser parser = context.getPipeParser();
        Message hapiMsg = parser.parse(msg);

        HL7Parser hl7Parser = new HL7Parser();
        hl7Parser.parse(hapiMsg, handler);

        ArgumentCaptor<DisplayOrder> captor = ArgumentCaptor.forClass(DisplayOrder.class);
        verify(handler).onDisplayOrder(captor.capture());
        DisplayOrder order = captor.getValue();

        assertThat(order).isNotNull();

    }
}
