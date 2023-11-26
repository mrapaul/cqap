package parser;

import com.lakeland.ris.ui.datamodel.*;
import org.jetbrains.annotations.*;

public interface HL7ParserHandler
{
    void onDisplayOrder(@NotNull DisplayOrder order);

    void onDetailedOrder(@NotNull DetailedOrder order);
}
