package com.capstone.fx.components;

import com.peirs.datamodel.ticket.*;
import javafx.scene.control.*;
import javafx.util.*;

public class TicketRowFactory implements Callback<TableView<TicketQueryResult>, TableRow<TicketQueryResult>>
{
    @Override public TableRow<TicketQueryResult> call(TableView<TicketQueryResult> aProfessionalTicketTableView)
    {
        return new TableRow<TicketQueryResult>()
        {
            @Override protected void updateItem(TicketQueryResult aTicket, boolean aEmpty)
            {
                super.updateItem(aTicket, aEmpty);

                if (aTicket != null)
                {
                    String myId = aTicket.getPriority().name().toLowerCase();
                    if (getId() != null)
                    {
                        getStyleClass().remove(getId());
                    }
                    setId(myId);
                    getStyleClass().add(myId);
                }
            }
        };
    }
}
