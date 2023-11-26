package parser;

import ca.uhn.hl7v2.*;
import ca.uhn.hl7v2.model.*;
import ca.uhn.hl7v2.model.v26.datatype.*;
import ca.uhn.hl7v2.model.v26.group.*;
import ca.uhn.hl7v2.model.v26.message.*;
import ca.uhn.hl7v2.model.v26.segment.*;
import ca.uhn.hl7v2.parser.*;
import ca.uhn.hl7v2.validation.impl.*;
import org.junit.*;
import org.nule.lighthl7lib.hl7.*;

import static org.fest.assertions.Assertions.*;

//@Ignore
public class MessageParserTest
{
    @Test
    public void parseConformingMessage() throws Exception
    {
        String
                msg =
                "MSH|^~\\&|Merge RIS|Lakeland Healthcare Group|PACS||20131118091803||ORM^O01|1311180918031200|P|2.3.1||17005\rPID|1|7568|WA230683|WAWARMC3581|BOCCIO^GRACE^M||19520619|F||2131-1|PO BOX 22260^^BULLHEAD CITY^AZ^86439^US||(928)754-4975|||M||1226338|110-44-2866\rPV1|1|O|Western Arizona Regional Medical Center^^^^^^^^Western Arizona Regional Medical Center|||||440^London^Theodore^D^MD|||||||||||19.1713|||||||||||||||||||||||||||||||1226338\rORC|NW|00013474|12263380000100||CM||^^^201311180815^^R||20131118091803|interface^Interface^Interface||440^London^Theodore^D^MD|^^^^^^^^Western Arizona Regional Medical Center|(928)704-2229^(928)704-2255||SCREENING MAMMOGRAM|440^DESERT PALMS MEDICAL ASSOCIATES INC-3015|||||||3003 HWY 95 SUITE No 31^^BULLHEAD CITY^AZ^86442^9287042229^9287042255^9287042255\rOBR|1|00013474|WA12263380000100|HDIGSCNB^DIG MAMMO SCREEN BILAT W CAD^^G0202^MG DIGITAL SCREENING MAMMOGRAM BILAT||20131118081500|20131118081500||||||(**IOP**)~SCREENING MAMMOGRAM|||440^London^Theodore^D^MD|(928)704-2229^(928)704-2255||CR^MG||WARMCMOD|||MG|||^^^20131118081500^^R||||SCREENING MAMMOGRAM^SCREENING MAMMOGRAM|||||20131118081500\r";
        HapiContext context = new DefaultHapiContext();
        Parser p = context.getGenericParser();
        Message hapiMsg = p.parse(msg);

        assertThat(msg).isEqualToIgnoringCase(hapiMsg.toString());

    }

    @Test
    public void parseNonConformingMessage() throws Exception
    {
        String
                msg =
                "MSH|^~\\&|FLUENCY|WARMC|MERGE RIS|LAKELAND|20131118123404||ORU^R01|20131118123404.4396|P|2.3||15012\rPID|1|WAWARMC3581|WA230683|WAWARMC3581|BOCCIO^GRACE^M||19520619|F||||||||||1226338\rPV1|||Western Arizona Regional Medical Center^^^^^^^^Western Arizona Regional Medical Center||||||||||||||||19.1713|||||||||||||||||||||||||||||||1226338\rORC|RE||WA12263380000100||||||20131118123404\rOBR|1|00013474|WA12263380000100|HDIGSCNB^DIG MAMMO SCREEN BILAT W CAD|||20131118123404||||||||||||||||||F||||||^SCREENING MAMMOGRAM|3864^Engeler^Claudia|^^|||20131118081500\rOBX|1|FT|||EXAM DESCRIPTION:  SCREENING BILATERAL MAMMOGRAPHY.~~DATE TIME OF EXAMINATION: 11/18/2013 9:18 AM~~INDICATIONS:  SCREENING MAMMOGRAMPatient is asymptomatic.~~COMPARISON:  7/6/ 2011, 11/17/2009, 04/15/2008~~TECHNIQUE:  Bilateral full field digital mammography was obtained with Computer Aided Detection (CAD).~~FINDINGS:  BREAST DENSITY: Breast tissue is almost entirely fatty replaced with less than 25 percent fibroglandular tissue.~~RIGHT BREAST: There are no suspicious masses, suspicious microcalcifications or areas of architectural distortion.~~LEFT BREAST:  There are no suspicious masses, suspicious microcalcifications or areas of architectural distortion.~~IMPRESSION:  BI - RADS ASSESSMENT CATEGORY 1. ASSESSMENT COMPLETE.~~NEGATIVE STUDY.~~Recommendations: Routine annual screening mammography (for women over age 40).~~CPT: G0202. Screening   mammography, producing direct digital image, bilateral, all views.~||||||F|||||3864\r";

        HapiContext context = new DefaultHapiContext();
        context.setValidationContext(new NoValidation());
        Parser p = context.getPipeParser();
        Message hapiMsg = p.parse(msg);

        assertThat(msg).isNotEqualTo(hapiMsg.toString());
    }

    @Test
    public void parseToKeyValueMap() throws Exception
    {
        String
                msg =
                "MSH|^~\\&|IIM|MCH.LIVE|ITSORD.ERAD|eRAD|201311181125||ORM^O01|1064057101.1.364306.001|P|2.3|||AL||||\rPID|1||M000012345||LASTNAME^FIRSTNAME^MIDDLE||19700101|F||CA|1234 MAIN STREET^^ERIE^PA^16501||(814)555-1234^^^^^814^5551234|||S|NO|H00001234567|123-45-6789|||||||||||\rPD1||||HANDAN^HANSEN^DANIELLE^M. D.O.||||||||\rPV1|1|I|ACE^ACE11^1^MCH|EL|||FERJOH^FERRETTI^JOHN^M. D.O.||FIEVIN^FIERRO^VINCENT^S. D.O.^JR.|ACE||||CPO|||FERJOH^FERRETTI^JOHN^M. D.O.|IN||MAMC|||||||||||||||||||MCH||ADM IN|||201311151249||||||||HANDAN^HANSEN^DANIELLE^M. D.O.|\\rORC|CA|364306.001|364306.001||CA||1^^^20131118^^R||201311181124|CMZM3023^Zalas^Christine||FERJOH^FERRETTI^JOHN^M. D.O.||||DUPLICATE ORDER||RADIOLOGY7|MESM3421^Stein^Megan|\\rOBR|1|364306.001|364306.001|GENM^GASTRIC EMPTYING^NM|X|201311180916|201311180916|||||||||FERJOH^FERRETTI^JOHN^M. D.O.|||||||||||1^^^20131118^^R|\rOBX|1|TX|DIREAS^Reason for exam|1|NAUSEA||||||||||||\rOBX|2|TX|ITS.RAD247^Send Order to RAD 24x7|2|Y||||||||||||";
        CanonicalModelClassFactory mcf = new CanonicalModelClassFactory("2.6");
        HapiContext context = new DefaultHapiContext();
        context.setValidationContext(new NoValidation());
        context.setModelClassFactory(mcf);
        PipeParser parser = context.getPipeParser();
        Message hapiMsg = parser.parse(msg);

        MSH msh = (MSH) hapiMsg.get("MSH");
        ST fieldSeparator = msh.getFieldSeparator();
        String sendingNetworkAddress = msh.getSendingNetworkAddress().getUniversalID().getValue();
        MSG messageType = msh.getMessageType();
        String version = msh.getVersionID().getVersionID().getVersion();
        System.out.println(messageType);
//        DTM dateTimeOfMessage = msh.getDateTimeOfMessage();
//        Date dateTimeOfMessageValueAsDate = dateTimeOfMessage.getValueAsDate();
//        int gmtOffset = dateTimeOfMessage.getGMTOffset();
//        String messageControlID = msh.getMessageControlID().getValue();

        ORM_O01 orm = (ORM_O01) hapiMsg;
        ORM_O01_PATIENT patient = orm.getPATIENT();
        ORM_O01_ORDER order = orm.getORDER();
        ORC orc = order.getORC();
        String status = orc.getOrderStatus().getValue();
        PID pid = patient.getPID();
        XPN[] patientName = pid.getPatientName();
        XPN xpn = patientName[0];
        String givenName = xpn.getGivenName().getValue();
        String familyName = xpn.getFamilyName().getSurname().getValue();
        XAD[] patientAddress = pid.getPatientAddress();
        ORM_O01_ORDER_DETAIL order_detail = order.getORDER_DETAIL();

        Hl7Record record = new Hl7Record(msg);
        for (Hl7Segment hl7Segment : record.getAll())
        {
            String id = hl7Segment.getId();
            int i=1;
            for (Hl7Field hl7Field : hl7Segment.fieldAll())
            {
                System.out.println(id+"-"+i + " = " +hl7Field);
                i++;
            }
        }
    }

    @Test
    public void parseMillCreekADT() throws Exception
    {
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

    }
}
