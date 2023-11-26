package parser;
import ca.uhn.hl7v2.*;
import com.lakeland.ris.ui.datamodel.*;
import org.jetbrains.annotations.*;

public interface MessageParser<T>
{
    void convert(@NotNull T message, @NotNull DetailedOrderBuilder orderBuilder) throws HL7Exception;
}
