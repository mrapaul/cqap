//import com.cqap.merge.*;
//import com.peirs.datamodel.hl7.*;
//import org.junit.*;
//
///**
// * Created with IntelliJ IDEA.
// * User: apaul
// * Date: 11/20/13
// * Time: 9:06 PM
// * To change this template use File | Settings | File Templates.
// */
//public class ParseTest
//{
//    @Test
//    public void test()
//    {
//        MergeRegistration.registerToolkit();
//        MergeHL7Parser myParser = new MergeHL7Parser();
//        HL7 myParse = myParser.parse("MSH|^~\\&|FLUENCY|WARMC|MERGE RIS|LAKELAND|20131118123404||ORU^R01|20131118123404.4396|P|2.3||15012\rPID|1|WAWARMC3581|WA230683|WAWARMC3581|BOCCIO^GRACE^M||19520619|F||||||||||1226338\rPV1|||Western Arizona Regional Medical Center^^^^^^^^Western Arizona Regional Medical Center||||||||||||||||19.1713|||||||||||||||||||||||||||||||1226338\rORC|RE||WA12263380000100||||||20131118123404\rOBR|1|00013474|WA12263380000100|HDIGSCNB^DIG MAMMO SCREEN BILAT W CAD|||20131118123404||||||||||||||||||F||||||^SCREENING MAMMOGRAM|3864^Engeler^Claudia|^^|||20131118081500\rOBX|1|FT|||EXAM DESCRIPTION:  SCREENING BILATERAL MAMMOGRAPHY.~~DATE TIME OF EXAMINATION: 11/18/2013 9:18 AM~~INDICATIONS:  SCREENING MAMMOGRAMPatient is asymptomatic.~~COMPARISON:  7/6/ 2011, 11/17/2009, 04/15/2008~~TECHNIQUE:  Bilateral full field digital mammography was obtained with Computer Aided Detection (CAD).~~FINDINGS:  BREAST DENSITY: Breast tissue is almost entirely fatty replaced with less than 25 percent fibroglandular tissue.~~RIGHT BREAST: There are no suspicious masses, suspicious microcalcifications or areas of architectural distortion.~~LEFT BREAST:  There are no suspicious masses, suspicious microcalcifications or areas of architectural distortion.~~IMPRESSION:  BI - RADS ASSESSMENT CATEGORY 1. ASSESSMENT COMPLETE.~~NEGATIVE STUDY.~~Recommendations: Routine annual screening mammography (for women over age 40).~~CPT: G0202. Screening   mammography, producing direct digital image, bilateral, all views.~||||||F|||||3864\r");
//        myParser.parse("MSH|^~\\&|Merge RIS|Lakeland Healthcare Group|PACS||20131118091803||ORM^O01|1311180918031200|P|2.3.1||17005\rPID|1|7568|WA230683|WAWARMC3581|BOCCIO^GRACE^M||19520619|F||2131-1|PO BOX 22260^^BULLHEAD CITY^AZ^86439^US||(928)754-4975|||M||1226338|110-44-2866\rPV1|1|O|Western Arizona Regional Medical Center^^^^^^^^Western Arizona Regional Medical Center|||||440^London^Theodore^D^MD|||||||||||19.1713|||||||||||||||||||||||||||||||1226338\rORC|NW|00013474|12263380000100||CM||^^^201311180815^^R||20131118091803|interface^Interface^Interface||440^London^Theodore^D^MD|^^^^^^^^Western Arizona Regional Medical Center|(928)704-2229^(928)704-2255||SCREENING MAMMOGRAM|440^DESERT PALMS MEDICAL ASSOCIATES INC-3015|||||||3003 HWY 95 SUITE No 31^^BULLHEAD CITY^AZ^86442^9287042229^9287042255^9287042255\rOBR|1|00013474|WA12263380000100|HDIGSCNB^DIG MAMMO SCREEN BILAT W CAD^^G0202^MG DIGITAL SCREENING MAMMOGRAM BILAT||20131118081500|20131118081500||||||(**IOP**)~SCREENING MAMMOGRAM|||440^London^Theodore^D^MD|(928)704-2229^(928)704-2255||CR^MG||WARMCMOD|||MG|||^^^20131118081500^^R||||SCREENING MAMMOGRAM^SCREENING MAMMOGRAM|||||20131118081500\r");
//        System.out.println(myParse);
//    }
//}
