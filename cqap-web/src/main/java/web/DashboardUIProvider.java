package web;

import com.vaadin.navigator.*;
import com.vaadin.ui.*;

public class DashboardUIProvider extends CustomComponent implements View
{

    public static final String NAME = "";

    Label text = new Label();

    Button logout = new Button("Logout", new Button.ClickListener()
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

    public DashboardUIProvider()
    {
        setCompositionRoot(new CssLayout(text, logout));
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event)
    {
        // Get the user name from the session
        String username = String.valueOf(getSession().getAttribute("user"));

        // And show the username
        text.setValue("Hello " + username);
    }
}