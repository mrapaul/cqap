package web;

import com.cqap.client.*;
import com.peirs.datamodel.*;
import com.vaadin.ui.*;

@SuppressWarnings("serial")
public class MainView extends VerticalLayout
{
    public MainView(ClientRestService restService, User user)
    {
        setSizeFull();
//        addStyleName("mainview");


        ComponentContainer content = new CssLayout();
//        content.addStyleName("view-content");
        content.setSizeFull();
        addComponent(content);
        setExpandRatio(content, 1.0f);
        addComponent(new DashboardMenu(user));

        new DashboardNavigator(content, restService, user);
    }
}