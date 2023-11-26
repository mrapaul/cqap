package parser;

import ca.uhn.hl7v2.*;
import ca.uhn.hl7v2.model.*;
import ca.uhn.hl7v2.model.v26.message.*;
import ca.uhn.hl7v2.parser.*;
import ca.uhn.hl7v2.validation.impl.*;
import com.lakeland.ris.datamodel.*;
import com.lakeland.ris.ui.datamodel.*;
import org.junit.*;

import static org.fest.assertions.Assertions.assertThat;

public class ORU_R01ParserTest
{
    @Test
    public void parse_ORU_R01() throws Exception
    {
        String message = "MSH|^~\\&|MEDXT|Lakeland Health Care Group|Lakeland Health Care Group|WARMC|20140917072452.323+0000||ORU^R01|124401|T|2.3\rPID|1|278933|278933|278933|WRIGHT^SAMANTHA^J||19700415|F||||||||||1280959\rPV1||I|||||1396783155^Levey^Richard^M.^M.D.|^CHOUDHRY^IHTISHAM|^CHOUDHRY^IHTISHAM||||||||||||||||||||||||||||||1\rOBR|1|12809590008400|131061|^DX|||20140917020110|20140917020110||||||20140917021907|||||||||||F|||||||1396783155^Levey^Richard^M.\rOBX|0|TX|||Observation\rOBX|1|TX|||\rOBX|2|TX|||Examination: Left hand\rOBX|3|TX|||\rOBX|4|TX|||Indication: Pain.\rOBX|5|TX|||\rOBX|6|TX|||Comparison: None.\rOBX|7|TX|||\rOBX|8|TX|||Technique: 3 views.\rOBX|9|TX|||\rOBX|10|TX|||Findings: No erosions are appreciated. There is no fracture or dislocation. Soft tissue swelling is seen over the dorsum of the hand. Wrist shows an old ununited ulnar styloid fracture.\rOBX|11|TX|||\rOBX|12|TX|||Impression:\rOBX|13|TX|||\rOBX|14|TX|||1. Nonspecific soft tissue swelling.\rOBX|15|TX|||\rOBX|16|TX|||2. Negative for acute fracture.\rOBX|17|TX|||\rOBX|18|TX|||3. No bony erosive changes.\rOBX|19|TX|||\rOBX|20|TX|||4. Old ununited ulnar styloid fracture.\rOBX|21|TX|||\rOBX|22|TX|||\rOBX|23|TX|||\r";

        CanonicalModelClassFactory mcf = new CanonicalModelClassFactory("2.6");
        HapiContext context = new DefaultHapiContext();
        context.setValidationContext(new NoValidation());
        context.setModelClassFactory(mcf);
        PipeParser parser = context.getPipeParser();
        Message hapiMsg = parser.parse(message);

        assertThat(hapiMsg).isInstanceOf(ORU_R01.class);

        ORU_R01Parser oruParser = new ORU_R01Parser();
        oruParser.parseReport((ORU_R01) hapiMsg);
    }
}
