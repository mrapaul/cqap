package parser;

import ca.uhn.hl7v2.*;
import ca.uhn.hl7v2.validation.impl.*;
import com.google.common.base.*;
import org.junit.*;

import static org.fest.assertions.Assertions.assertThat;

public class HL7ContextSupplierTest
{
    @Test
    public void shouldSupplyHapiContext() throws Exception
    {
        Supplier<HapiContext> supplier = new HL7ContextSupplier();
        HapiContext context = supplier.get();

        assertThat(context).isNotNull();
        assertThat(context.getValidationContext()).isInstanceOf(NoValidation.class);
    }
}
