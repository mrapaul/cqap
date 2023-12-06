package web;

import com.google.common.collect.*;
import com.google.common.eventbus.*;
import com.peirs.datamodel.*;
import com.vaadin.server.*;
import com.vaadin.shared.ui.label.*;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.*;
import org.vaadin.maddon.layouts.*;
import web.event.*;

import java.util.*;

@SuppressWarnings({"serial", "unchecked"})
public final class DashboardMenu extends HorizontalLayout
{

    public static final String ID = "dashboard-menu";
    public static final String REPORTS_BADGE_ID = "dashboard-menu-reports-badge";
    public static final String NOTIFICATIONS_BADGE_ID = "dashboard-menu-notifications-badge";
    private static final String STYLE_VISIBLE = "valo-menu-visible";
    private final User user;
    private Label notificationsBadge;
    private Label reportsBadge;
    private MenuBar.MenuItem settingsItem;

    public DashboardMenu(User user)
    {
        this.user = user;
        addStyleName("valo-menu");
        setId(ID);
        setSizeUndefined();

        // There's only one DashboardMenu per UI so this doesn't need to be
        // unregistered from the UI-scoped DashboardEventBus.
        DashboardEventBus.register(this);

        buildContent();
    }

    private void buildContent()
    {
        setMargin(true);
        setWidth("100%");
        Component component = buildMenuItems(user);
        addComponent(component);
        setComponentAlignment(component, Alignment.BOTTOM_CENTER);
        addStyleName("sidebar");
//        return new MHorizontalLayout(buildMenuItems(user)).withFullWidth();
    }

    private User getCurrentUser()
    {
        return (User) VaadinSession.getCurrent().getAttribute(User.class.getName());
    }

    private Component buildUserMenu()
    {
        final MenuBar settings = new MenuBar();
        settings.addStyleName("user-menu");
        final User user = getCurrentUser();
        settingsItem = settings.addItem("", new ThemeResource("img/profile-pic-300px.jpg"), null);
        updateUserName(null);
//        settingsItem.addItem("Edit Profile", new Command()
//        {
//            @Override
//            public void menuSelected(final MenuItem selectedItem)
//            {
//                ProfilePreferencesWindow.open(user, false);
//            }
//        });
//        settingsItem.addItem("Preferences", new Command()
//        {
//            @Override
//            public void menuSelected(final MenuItem selectedItem)
//            {
//                ProfilePreferencesWindow.open(user, true);
//            }
//        });
//        settingsItem.addSeparator();
        settingsItem.addItem("Sign Out", new MenuBar.Command()
        {
            @Override
            public void menuSelected(final MenuBar.MenuItem selectedItem)
            {
                DashboardEventBus.post(new DashboardEvent.UserLoggedOutEvent());
            }
        });
        return settings;
    }

//    private Component buildToggleButton()
//    {
//        Button valoMenuToggleButton = new Button("Menu", new Button.ClickListener()
//        {
//            @Override
//            public void buttonClick(final Button.ClickEvent event)
//            {
//                if (getCompositionRoot().getStyleName().contains(STYLE_VISIBLE))
//                {
//                    getCompositionRoot().removeStyleName(STYLE_VISIBLE);
//                }
//                else
//                {
//                    getCompositionRoot().addStyleName(STYLE_VISIBLE);
//                }
//            }
//        });
//        valoMenuToggleButton.setIcon(FontAwesome.LIST);
//        valoMenuToggleButton.addStyleName("valo-menu-toggle");
//        valoMenuToggleButton.addStyleName(ValoTheme.BUTTON_BORDERLESS);
//        valoMenuToggleButton.addStyleName(ValoTheme.BUTTON_SMALL);
//        return valoMenuToggleButton;
//    }

    private Component buildMenuItems(User user)
    {
        DashboardViewType[] values = DashboardViewType.values();
        List<DashboardViewType> viewTypes = Lists.newArrayList();

        if (user.getRole() != Role.QAD)
        {
            viewTypes.add(DashboardViewType.DASHBOARD);
        }
        else
        {
            for (DashboardViewType value : values)
            {
                viewTypes.add(value);
            }
        }

        HorizontalLayout menuItemsLayout = new MHorizontalLayout().withSpacing(true).withFullHeight();
//        CssLayout menuItemsLayout = new CssLayout();
//        menuItemsLayout.addStyleName("valo-menuitems");
//        menuItemsLayout.setHeight(100.0f, Unit.PERCENTAGE);

        for (final DashboardViewType view : viewTypes)
        {
            Component menuItemComponent = new ValoMenuItemButton(view);

//            if (view == DashboardViewType.DASHBOARD)
//            {
//                notificationsBadge = new Label();
//                notificationsBadge.setId(NOTIFICATIONS_BADGE_ID);
//                menuItemComponent = buildBadgeWrapper(menuItemComponent, notificationsBadge);
//            }
//
//            menuItemsLayout.addComponent(menuItemComponent);
            menuItemsLayout.addComponent(menuItemComponent);
        }
        Button signOutButton = new Button();
        signOutButton.setIcon(FontAwesome.SIGN_OUT);
        signOutButton.addStyleName("fq");
        signOutButton.addClickListener(new Button.ClickListener()
        {
            @Override public void buttonClick(Button.ClickEvent event)
            {
                DashboardEventBus.post(new DashboardEvent.UserLoggedOutEvent());
            }
        });
        menuItemsLayout.addComponent(signOutButton);

        return menuItemsLayout;

    }

    private Component buildBadgeWrapper(final Component menuItemButton, final Component badgeLabel)
    {
        CssLayout dashboardWrapper = new CssLayout(menuItemButton);
        dashboardWrapper.addStyleName("badgewrapper");
        dashboardWrapper.addStyleName(ValoTheme.MENU_ITEM);
        dashboardWrapper.setWidth(100.0f, Unit.PERCENTAGE);
        badgeLabel.addStyleName(ValoTheme.MENU_BADGE);
        badgeLabel.setWidthUndefined();
        badgeLabel.setVisible(false);
        dashboardWrapper.addComponent(badgeLabel);
        return dashboardWrapper;
    }

    @Override
    public void attach()
    {
        super.attach();
        updateNotificationsCount(null);
    }

    @Subscribe
    public void postViewChange(final DashboardEvent.PostViewChangeEvent event)
    {
        // After a successful view change the menu can be hidden in mobile view.
//        getCompositionRoot().removeStyleName(STYLE_VISIBLE);
    }

    @Subscribe
    public void updateNotificationsCount(final DashboardEvent.NotificationsCountUpdatedEvent event)
    {

    }

    @Subscribe
    public void updateReportsCount(final DashboardEvent.ReportsCountUpdatedEvent event)
    {
        reportsBadge.setValue(String.valueOf(event.getCount()));
        reportsBadge.setVisible(event.getCount() > 0);
    }

    @Subscribe
    public void updateUserName(final DashboardEvent.ProfileUpdatedEvent event)
    {
        User user = getCurrentUser();
        settingsItem.setText(user.getName());
    }

    public final class ValoMenuItemButton extends Button
    {

        private static final String STYLE_SELECTED = "selected";
        private final DashboardViewType view;

        public ValoMenuItemButton(final DashboardViewType view)
        {
            this.view = view;
            addStyleName("fq");
            setIcon(view.getIcon());
//            setCaption(view.getViewName().substring(0, 1).toUpperCase() + view.getViewName().substring(1));
            DashboardEventBus.register(this);
            addClickListener(new ClickListener()
            {
                @Override
                public void buttonClick(final ClickEvent event)
                {
                    UI.getCurrent().getNavigator().navigateTo(view.getViewName());
                }
            });

        }

        @Subscribe
        public void postViewChange(final DashboardEvent.PostViewChangeEvent event)
        {
            removeStyleName(STYLE_SELECTED);
            if (event.getView() == view)
            {
                addStyleName(STYLE_SELECTED);
            }
        }
    }
}