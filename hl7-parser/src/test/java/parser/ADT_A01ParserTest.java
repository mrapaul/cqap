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

public class ADT_A01ParserTest
{
    @Test
    public void parseADT_A08() throws Exception
    {
        String message = "MSH|^~\\&|RAMSOFT|SENDING FACILITY|RAMSOFT|RECEIVING FACILITY|20101223202939-0400||ADT^A08|101|P|2.3.1|||||||| \rEVN|A08|20101223202939-0400|||| \rPID||P12345^^^ISSUER|P12345^^^ISSUER||PATIENT^TEST^M||19741018|M|||10808 FOOTHILL BLVD^^RANCHO CUCAMONGA^CA^91730^US||(909)481-5872^^^sales@ramsoft.com|(909)481-5800x1||M||12345|286-50-9510\rPV1||O\rAL1|1||^PORK\rAL1|2||^PENICILLIN\r";

        CanonicalModelClassFactory mcf = new CanonicalModelClassFactory("2.6");
        HapiContext context = new DefaultHapiContext();
        context.setValidationContext(new NoValidation());
        context.setModelClassFactory(mcf);
        PipeParser parser = context.getPipeParser();
        Message hapiMsg = parser.parse(message);

        assertThat(hapiMsg).isInstanceOf(ADT_A01.class);

        ADT_A01Parser adtParser = new ADT_A01Parser();
        DetailedOrderBuilder orderBuilder = new DetailedOrderBuilder("TEST", OrderStatus.ORDERED, OrderPriority.Low, "server");
        adtParser.convert((ADT_A01)hapiMsg, orderBuilder);
    }
}
