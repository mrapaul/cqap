package web;

import com.vaadin.event.*;
import com.vaadin.server.*;
import com.vaadin.shared.ui.*;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.*;
import web.event.*;

import static org.apache.commons.lang3.StringUtils.*;

public class LoginView extends VerticalLayout
{
    private final TextField userField;

    public LoginView()
    {
        userField = new TextField("Username");
        setSizeFull();

        Component loginForm = buildLoginForm();
        addComponent(loginForm);
        setComponentAlignment(loginForm, Alignment.MIDDLE_CENTER);
    }

    private Component buildLoginForm()
    {
        addStyleName("login-layout");

        userField.setWidth("250px");
        userField.setRequired(true);
        userField.setInvalidAllowed(false);

        // Create the password input field
        final PasswordField password = new PasswordField("Password:");
        password.setWidth("250px");
        password.setRequired(true);
        password.setValue("");
        password.setNullRepresentation("");

        // Create login button
        final Button loginButton = new Button("Login");
        loginButton.addStyleName("fq");
        loginButton.setClickShortcut(ShortcutAction.KeyCode.ENTER);

        // Add both to a panel
        Label label = new Label();
        label.setIcon(new ThemeResource("img/FortisQualitasGold2.png"));
        label.addStyleName("h1");
        HorizontalLayout fields = new HorizontalLayout(userField, password, loginButton);
        fields.setSpacing(true);
        fields.setMargin(new MarginInfo(true, true, true, false));
        fields.setSizeUndefined();
        fields.setComponentAlignment(loginButton, Alignment.BOTTOM_RIGHT);
//        fields.addStyleName("login-panel");
        VerticalLayout layout = new VerticalLayout(label, fields);
        layout.setComponentAlignment(label, Alignment.TOP_CENTER);
        layout.setSizeUndefined();

        // The view root layout
        VerticalLayout viewLayout = new VerticalLayout(layout);
        viewLayout.setSizeFull();
        viewLayout.setComponentAlignment(layout, Alignment.MIDDLE_CENTER);
        viewLayout.addStyleName("login-enclosure");

        loginButton.addClickListener(new Button.ClickListener()
        {
            @Override
            public void buttonClick(final Button.ClickEvent event)
            {
                String usernameValue = userField.getValue();
                String passwordValue = password.getValue();
                if (isNotEmpty(usernameValue))
                {
                    DashboardEventBus.post(new DashboardEvent.UserLoginRequestedEvent(usernameValue, passwordValue));
                }
                else
                {
                    Notification.show("Please enter a username", Notification.Type.ERROR_MESSAGE);
                }
            }
        });

        return viewLayout;
    }

    private Component buildLabels()
    {
        VerticalLayout labels = new VerticalLayout();
        labels.setWidth("100%");
        labels.addStyleName("labels");

        Label welcome = new Label();
        welcome.setSizeUndefined();
        welcome.setIcon(new ThemeResource("img/dr-logo.jpg"));
        welcome.addStyleName(ValoTheme.LABEL_COLORED);
        labels.addComponent(welcome);
        labels.setComponentAlignment(welcome, Alignment.BOTTOM_CENTER);

        return labels;
    }

    public void focusOnUsername()
    {
        userField.focus();
    }
}
