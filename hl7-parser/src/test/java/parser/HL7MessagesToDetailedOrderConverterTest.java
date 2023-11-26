package parser;

import ca.uhn.hl7v2.*;
import ca.uhn.hl7v2.model.*;
import ca.uhn.hl7v2.parser.*;
import ca.uhn.hl7v2.validation.impl.*;
import com.google.common.collect.*;
import com.lakeland.ris.datamodel.*;
import com.lakeland.ris.ui.datamodel.*;
import org.junit.*;

import java.util.*;

import static org.fest.assertions.Assertions.assertThat;

public class HL7MessagesToDetailedOrderConverterTest
{
    @Test
    public void shouldConvertMessageToOrder() throws Exception
    {
        HL7MessagesToDetailedOrderConverter converter = new HL7MessagesToDetailedOrderConverter();
        DetailedOrder
                order =
                converter.convert(createMessages(), new DetailedOrderBuilder("test", OrderStatus.ASSIGNED, OrderPriority.Low, "server"));

        assertThat(order).isNotNull();
        assertThat(order.getOrderId()).isEqualTo("test");
        assertThat(order.getStatus()).isEqualTo(OrderStatus.ASSIGNED);
    }

    private Collection<Message> createMessages() throws Exception
    {
        List<Message> messages = Lists.newArrayList();
        String
                ORM =
                "MSH|^~\\&|IIM|MCH.LIVE|ITSORD.ERAD|eRAD|201311181125||ORM^O01|1064057101.1.364306.001|P|2.3|||AL||||\rPID|1||M000012345||LASTNAME^FIRSTNAME^MIDDLE||19700101|F||CA|1234 MAIN STREET^^ERIE^PA^16501||(814)555-1234^^^^^814^5551234|||S|NO|H00001234567|123-45-6789|||||||||||\rPD1||||HANDAN^HANSEN^DANIELLE^M. D.O.||||||||\rPV1|1|I|ACE^ACE11^1^MCH|EL|||FERJOH^FERRETTI^JOHN^M. D.O.||FIEVIN^FIERRO^VINCENT^S. D.O.^JR.|ACE||||CPO|||FERJOH^FERRETTI^JOHN^M. D.O.|IN||MAMC|||||||||||||||||||MCH||ADM IN|||201311151249||||||||HANDAN^HANSEN^DANIELLE^M. D.O.|\rORC|CA|364306.001|364306.001||CA||1^^^20131118^^R||201311181124|CMZM3023^Zalas^Christine||FERJOH^FERRETTI^JOHN^M. D.O.||||DUPLICATE ORDER||RADIOLOGY7|MESM3421^Stein^Megan|\rOBR|1|364306.001|364306.001|GENM^GASTRIC EMPTYING^NM|X|201311180916|201311180916|||||||||FERJOH^FERRETTI^JOHN^M. D.O.|||||||||||1^^^20131118^^R|\rOBX|1|TX|DIREAS^Reason for exam|1|NAUSEA||||||||||||\rOBX|2|TX|ITS.RAD247^Send Order to RAD 24x7|2|Y||||||||||||";
        String
                ADT =
                "MSH|^~\\&|MEDITECH|MILLCREEK|||201312021517||ADT^A08|ADT321047.1065280620|P|2.3|||||||EVN|A08|201312021517||||\r" +
                        "PID|1||9000123456||LASTNAME^FIRSTNAME^X||19700101|F||CA|123 MAIN ST^^ERIE^PA^16501||814)555-1234|(999)999-9999||S|NO|100001234567|123-45-6789|||||||||||\r" +
                        "PV1|1||RAD^^^MCH|EL|||BARRAN^BARAC^RANKO^D.O.|||||||CPO||||CLI||BCMC|||||||||||||||||||MCH||REG CLI|||201312021344||||||||\r" +
                        "NK1|1|LASTNAME^FIRSTNAME|OT|123 MAIN ST^^ERIE^PA^16501|(814)555-1234|(814)555-1234|||||||||||||||||||||||||||||||\r" +
                        "GT1|1||LASTNAME^FIRSTNAME||123 MAIN ST^^ERIE^PA^16501|(814)555-1234|||||OT|123-45-6789||||MILLCREEK COMMUNITY HOSPITAL|5515 PEACH STREET^^ERIE^PA^16509|(814)864-4031|||||||||||||||||||||||||||||||||||||\r" +
                        "DG1|1||||||||||||||||||\r" +
                        "IN1|1|BC PPO||BLUECROSS|PO BOX 358^^PITTSBURGH^PA^15230||(800)242-0514|012345678|||MILCRKHO|||||LASTNAME^FIRSTNAME|OT|||||||||||||||||||YYM123456789012|||||||||||||\r" +
                        "MSH|^~\\&|||MEDITECH|MILLCREEK|||ACK|20131202151701183|P|2.3\r" +
                        "MSA|AA|ADT321047.1065280620|";

        CanonicalModelClassFactory mcf = new CanonicalModelClassFactory("2.6");
        HapiContext context = new DefaultHapiContext();
        context.setValidationContext(new NoValidation());
        context.setModelClassFactory(mcf);
        PipeParser parser = context.getPipeParser();
        messages.add(parser.parse(ORM));
        messages.add(parser.parse(ADT));

        return messages;
    }

    @Test
    public void shouldConvertWARMC() throws Exception
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


        List<Message> messages = Lists.newArrayList();
        CanonicalModelClassFactory mcf = new CanonicalModelClassFactory("2.6");
        HapiContext context = new DefaultHapiContext();
        context.setValidationContext(new NoValidation());
        context.setModelClassFactory(mcf);
        PipeParser parser = context.getPipeParser();
        messages.add(parser.parse(msg));

        HL7MessagesToDetailedOrderConverter converter = new HL7MessagesToDetailedOrderConverter();
        DetailedOrder
                order =
                converter.convert(messages, new DetailedOrderBuilder("test", OrderStatus.ASSIGNED, OrderPriority.Low, "server"));

        assertThat(order).isNotNull();
        assertThat(order.getOrderId()).isEqualTo("test");
        assertThat(order.getStatus()).isEqualTo(OrderStatus.ASSIGNED);
    }

    @Test
    public void testCompare() throws Exception
    {
        String msg1 = "MSH|^~\\&|PATACCT|WARMC|MCKESSON|163|20150108215901||ORM^O01|74859292|P|2.3|74859292||||US|\n" +
                "EVN|O01|20150108215800|||KLS|\n" +
                "PID|1||367018||MICK^ZGIZGI||20100122|F||W|3475 MCCORMICK 208^^BULLHEAD CITY^AZ^86429|015|(442)666-0065||E    |S|N|1303152|999999999|||N^||||||\n" +
                "PD1||||88888^UNKNOWN^PRIMARY^CARE|||N||||N|N^N|\n" +
                "NK1|1|METZ^GENE|04^GRANDFATHER OR GRANDMOTHER||(928)201-7162||04^GRANDFATHER OR GRANDMOTHER|||||||||||||||||||||||||||||||\n" +
                "PV1|1|O|EOP||||3383^HARRIS^RICHARD|||EOP||||||N|3383^HARRIS^RICHARD|E||S||||||||||||||||||||||||20150108215800|||||||\n" +
                "PV2|||ARM INJURY|||||||||||||||||||N|||||\n" +
                "DG1|1|||ARM INJURY|||||||||||||\n" +
                "GT1|1|2165584|METZ^JEANETTE||3475 MCCORMICK 208^^BULLHEAD CITY^AZ^86429|(442)666-0065||19920524|F||32^MOTHER|623562133|||1|HARRAHS||(928)404-4073|||||||||||||||||||||||||||||||HOUSEKEEPING|||||||\n" +
                "ACC||\n" +
                "UB2|1||||||^|||||||||| \n" +
                "ZEM|^HARRAHS|(928)404-4073|UNEMPLOYED||\n" +
                "ORC|NW|100^ORDENT||||D|||20150108221900|3876||3876^HEALEY^ERIN|ER||20150108221900||0163|545713||\n" +
                "OBR|1|100^ORDENT||XRWR3>R^RIGHT WRIST 3 - 4 V^RAD|||20150108221900|20150108221900|||||||^^^|3876||0000100|RAD|13031520000100||||RAD|||\"\"^\"\"^\"\"^20150108221900^\"\"^S^\"\"^\"\"^\"\"^\"\"||||Pain with Trauma/Injury||||||\n" +
                "NTE|1|P|Bed Name: Bed18 |AI^Special Instructions|\n" +
                "NTE|2|P|Pain with Trauma/Injury|GI^CURRENT HX  :|\n";
        
        String msg2 = "MSH|^~\\&|PATACCT|WARMC|MCKESSON|163|20150108215901||ORM^O01|74859292|P|2.3|74859292||||US|\n" +
                "EVN|O01|20150108215800|||KLS|\n" +
                "PID|1||367018||MICK^ZGIZGI||20100122|F||W|3475 MCCORMICK 208^^BULLHEAD CITY^AZ^86429|015|(442)666-0065||E    |S|N|1303152|999999999|||N^||||||\n" +
                "PD1||||88888^UNKNOWN^PRIMARY^CARE|||N||||N|N^N|\n" +
                "NK1|1|METZ^GENE|04^GRANDFATHER OR GRANDMOTHER||(928)201-7162||04^GRANDFATHER OR GRANDMOTHER|||||||||||||||||||||||||||||||\n" +
                "PV1|1|O|EOP||||3383^HARRIS^RICHARD|||EOP||||||N|3383^HARRIS^RICHARD|E||S||||||||||||||||||||||||20150108215800|||||||\n" +
                "PV2|||ARM INJURY|||||||||||||||||||N|||||\n" +
                "DG1|1|||ARM INJURY|||||||||||||\n" +
                "GT1|1|2165584|METZ^JEANETTE||3475 MCCORMICK 208^^BULLHEAD CITY^AZ^86429|(442)666-0065||19920524|F||32^MOTHER|623562133|||1|HARRAHS||(928)404-4073|||||||||||||||||||||||||||||||HOUSEKEEPING|||||||\n" +
                "ACC||\n" +
                "UB2|1||||||^|||||||||| \n" +
                "ZEM|^HARRAHS|(928)404-4073|UNEMPLOYED||\n" +
                "ORC|SC|100^ORDENT|||P|D|||20150108223300|3876||3876^HEALEY^ERIN|ER||20150108221900||0163|545713||\n" +
                "OBR|1|100^ORDENT||XRWR3>R^RIGHT WRIST 3 - 4 V^RAD|||20150108221900|20150108221900|||||||^^^|3876||0000100|RAD|13031520000100|000367018|||RAD|||\"\"^\"\"^\"\"^20150108221900^\"\"^S^\"\"^\"\"^\"\"^\"\"||||Pain with Trauma/Injury||||||\n" +
                "NTE|1|P|Bed Name: Bed18 |AI^Special Instructions|\n" +
                "NTE|2|P|Pain with Trauma/Injury|GI^CURRENT HX  :|\n";

        assertThat(msg1).isNotEqualTo(msg2);

    }
}
