package com.capstone.fx.utils;

import com.peirs.datamodel.ticket.*;
import javafx.scene.control.*;

import java.util.*;

public class TicketFilter
{
    public static void filter(List<TicketQueryResult> aTickets,
                       String aFilter,
                       List<TicketQueryResult> aResult,
                       TableView<TicketQueryResult> aTableView)
    {
        aResult.clear();

        for (TicketQueryResult myTicket : aTickets)
        {
            if (matchesFilter(myTicket, aFilter))
            {
                aResult.add(myTicket);
            }
        }
        reapplyTableSortOrder(aTableView);

    }

    public static boolean matchesFilter(TicketQueryResult aTicket, String aFilterText)
    {
        if (aFilterText == null || aFilterText.isEmpty())
        {
            return true;
        }

        String lowerCaseFilterString = aFilterText.toLowerCase();
        if (aTicket.getViewId().toLowerCase().contains(lowerCaseFilterString) ||
                aTicket.getStatus().name().toLowerCase().contains(lowerCaseFilterString) ||
                aTicket.getPatientName().toLowerCase().contains(lowerCaseFilterString))
        {
            return true;
        }

        return false;
    }

    private static void reapplyTableSortOrder(TableView<TicketQueryResult> aTableView)
    {
        ArrayList<TableColumn<TicketQueryResult, ?>> sortOrder = new ArrayList<>(aTableView.getSortOrder());
        aTableView.getSortOrder().clear();
        aTableView.getSortOrder().addAll(sortOrder);
    }

}
