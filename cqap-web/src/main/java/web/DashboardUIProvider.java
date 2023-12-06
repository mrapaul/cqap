package web;

import com.vaadin.navigator.*;
import com.vaadin.ui.*;

public class DashboardUIProvider extends CustomComponent implements View
{
    public static final String NAME = "";
    private final Label text;
    private final Button logout;

    public DashboardUIProvider()
    {
        text = new Label();
        logout = new Button("Logout", new Button.ClickListener()
        {

            @Override
            public void buttonClick(Button.ClickEvent event)
            {

                // "Logout" the user
                getSession().setAttribute("user", null);

                // Refresh this view, should redirect to login view
                getUI().getNavigator().navigateTo(NAME);
            }
        });

        setCompositionRoot(new CssLayout(logout));

    }

    @Override public void enter(ViewChangeListener.ViewChangeEvent aViewChangeEvent)
    {

    }
}