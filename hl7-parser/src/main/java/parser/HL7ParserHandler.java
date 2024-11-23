package parser;

import com.lakeland.ris.ui.datamodel.*;


public interface HL7ParserHandler
{
    void onDisplayOrder(DisplayOrder order);

    void onDetailedOrder(DetailedOrder order);
}
