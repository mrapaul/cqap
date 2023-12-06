package web;

import com.cqap.client.*;
import com.vaadin.ui.*;

public class DashboardStatisticsView extends VerticalLayout
{

    private final ClientRestService clientService;

    public DashboardStatisticsView(ClientRestService clientService)
    {
        this.clientService = clientService;
    }
}
