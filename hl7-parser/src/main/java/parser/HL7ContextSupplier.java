package parser;

import ca.uhn.hl7v2.*;
import ca.uhn.hl7v2.parser.*;
import ca.uhn.hl7v2.validation.impl.*;
import com.google.common.base.*;


public class HL7ContextSupplier implements Supplier<HapiContext>
{
    
    @Override
    public HapiContext get()
    {
        CanonicalModelClassFactory mcf = new CanonicalModelClassFactory(HL7Constants.VERSION);
        HapiContext context = new DefaultHapiContext();
        context.setValidationContext(new NoValidation());
        context.setModelClassFactory(mcf);

        return context;
    }
}
