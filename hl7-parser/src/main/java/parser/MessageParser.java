package parser;
import ca.uhn.hl7v2.*;
import com.lakeland.ris.ui.datamodel.*;


public interface MessageParser<T>
{
    void convert(T message, DetailedOrderBuilder orderBuilder) throws HL7Exception;
}
