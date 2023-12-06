package web;

import com.cqap.client.*;
import com.google.common.eventbus.*;
import com.peirs.datamodel.*;
import com.vaadin.annotations.*;
import com.vaadin.server.*;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.*;
import org.jasypt.util.password.*;
import web.event.*;

import java.util.*;

import static org.apache.commons.lang3.StringUtils.isEmpty;
import static org.apache.commons.lang3.StringUtils.isNotEmpty;


@Theme("dashboard")
@Widgetset("web.DashboardWidgetSet")
@Title("Qualitas")
@Push
@SuppressWarnings("serial")
public final class DashboardUI extends UI
{

    /*
     * This field stores an access to the dummy backend layer. In real
     * applications you most likely gain access to your beans trough lookup or
     * injection; and not in the UI but somewhere closer to where they're
     * actually accessed.
     */
    private final DashboardEventBus dashboardEventbus = new DashboardEventBus();
    private ClientRestService clientRestService;

    public static DashboardEventBus getDashboardEventbus()
    {
        return ((DashboardUI) getCurrent()).dashboardEventbus;
    }

    @Override
    protected void init(final VaadinRequest request)
    {
        setLocale(Locale.US);

        DashboardEventBus.register(this);
        Responsive.makeResponsive(this);

        clientRestService = new ClientRestServiceSupplier().get();

        updateContent();

        // Some views need to be aware of browser resize events so a
        // BrowserResizeEvent gets fired to the event but on every occasion.
        Page.getCurrent().addBrowserWindowResizeListener(new Page.BrowserWindowResizeListener()
        {
            @Override
            public void browserWindowResized(final Page.BrowserWindowResizeEvent event)
            {
                DashboardEventBus.post(new DashboardEvent.BrowserResizeEvent());
            }
        });

        UI.getCurrent().setErrorHandler(new ErrorHandler()
        {
            @Override public void error(com.vaadin.server.ErrorEvent event)
            {
                Notification.show("Error " + event.getThrowable().getMessage(), Notification.Type.TRAY_NOTIFICATION);
            }
        });
    }

    /**
     * Updates the correct content for this UI based on the current user status.
     * If the user is logged in with appropriate privileges, main view is shown.
     * Otherwise login view is shown.
     */
    private void updateContent()
    {
        User user = (User) VaadinSession.getCurrent().getAttribute(User.class.getName());
        if (user != null)
        {
            // Authenticated user
            if (user.getHIPAACompliance() == null)
            {
                UI.getCurrent().addWindow(new HIPAAView(user));
            }
            else
            {
                showMainView(user);
            }
        }
        else
        {
            showLoginView();
        }
    }

    private void showLoginView()
    {
        LoginView content = new LoginView();
        setContent(content);
        content.focusOnUsername();
        addStyleName("loginview");
    }

    private void showMainView(User user)
    {
        setContent(new MainView(clientRestService, user));
        removeStyleName("loginview");
        getNavigator().navigateTo(getNavigator().getState());
    }

    @Subscribe
    public void hippaCompliance(final DashboardEvent.HIPAAComplianceEvent event)
    {
        if (event.isAgreed())
        {
            User user = event.getUser();
            HIPAACompliance hipaaCompliance = new HIPAACompliance();
            hipaaCompliance.setDateAgreed(new Date());
            user.setHIPAACompliance(hipaaCompliance);
            clientRestService.createOrUpdateUser(user);
            VaadinSession.getCurrent().setAttribute(User.class.getName(), user);

            updateContent();
        }
        else
        {
            showLoginView();
        }
    }

    @Subscribe
    public void userLoginRequested(final DashboardEvent.UserLoginRequestedEvent event)
    {
        String userName = event.getUserName();
        String inputPassword = event.getPassword();

        final User user = clientRestService.loginUser(userName);
        final StrongPasswordEncryptor passwordEncryptor = new StrongPasswordEncryptor();
        if (user != null)
        {
            String savedPassword = user.getPassword();
            if (isNotEmpty(inputPassword) && isNotEmpty(savedPassword))
            {
                if (passwordEncryptor.checkPassword(inputPassword, savedPassword))
                {
                    VaadinSession.getCurrent().setAttribute(User.class.getName(), user);
                    updateContent();
                }
                else
                {
                    Notification.show("Incorrect password. Please try again or ask your administrator to reset your " +
                            "password.", Notification.Type.ERROR_MESSAGE);
                }
            }
            else
            {
                if (isNotEmpty(inputPassword) && isEmpty(savedPassword))
                {
                    // dodgy situation
                }
                else if (isNotEmpty(savedPassword) && isEmpty(inputPassword))
                {
                    Notification.show("Please enter a password", Notification.Type.ERROR_MESSAGE);
                }
                else if (isEmpty(inputPassword) && isEmpty(savedPassword))
                {
                    final PasswordField passwordField = new PasswordField("Enter new password");
                    Button saveButton = new Button("Save");
                    saveButton.addStyleName(ValoTheme.BUTTON_PRIMARY);
                    VerticalLayout layout = new VerticalLayout(passwordField, saveButton);
                    layout.setComponentAlignment(saveButton, Alignment.BOTTOM_CENTER);
                    layout.setMargin(true);
                    layout.setSpacing(true);
                    layout.addStyleName("sidebar");
                    final Window window = new Window("Reset password", layout);
                    saveButton.addClickListener(new Button.ClickListener()
                    {
                        @Override public void buttonClick(Button.ClickEvent event)
                        {
                            String value = passwordField.getValue();
                            if (isNotEmpty(value))
                            {
                                user.setPassword(passwordEncryptor.encryptPassword(value));
                                clientRestService.createOrUpdateUser(user);
                                Notification.show("Password saved successfully. Please login");
                                window.close();
                            }
                            else
                            {
                                Notification.show("No password entered.");
                            }
                        }
                    });
                    window.setModal(true);
                    UI.getCurrent().addWindow(window);
                }
            }
        }
        else
        {
            Notification.show("User for username " + userName + " not found.", Notification.Type.ERROR_MESSAGE);
        }
    }

    @Subscribe
    public void userLoggedOut(final DashboardEvent.UserLoggedOutEvent event)
    {
        // When the user logs out, current VaadinSession gets closed and the
        // page gets reloaded on the login screen. Do notice the this doesn't
        // invalidate the current HttpSession.
        VaadinSession.getCurrent().close();
        Page.getCurrent().reload();
    }

    @Subscribe
    public void closeOpenWindows(final DashboardEvent.CloseOpenWindowsEvent event)
    {
        for (Window window : getWindows())
        {
            window.close();
        }
    }
}
