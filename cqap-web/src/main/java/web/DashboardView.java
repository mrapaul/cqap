package web;

import com.cqap.client.*;
import com.google.common.eventbus.*;
import com.peirs.datamodel.*;
import com.vaadin.event.*;
import com.vaadin.navigator.*;
import com.vaadin.server.*;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.*;
import org.jetbrains.annotations.*;
import org.vaadin.maddon.layouts.*;
import web.charts.*;
import web.event.*;

import java.util.*;
import java.util.concurrent.*;

import static ch.lambdaj.Lambda.on;
import static ch.lambdaj.Lambda.sort;

public class DashboardView extends Panel implements View, DashboardEdit.DashboardEditListener
{

    public static final String EDIT_ID = "dashboard-edit";
    public static final String TITLE_ID = "dashboard-title";
    private final VerticalLayout root;
    private final ClientRestService clientRestService;
    private final User user;
    private final NotificationsButton notificationsButton;
    private Label titleLabel;
    private CssLayout dashboardPanels;
    private Window notificationsWindow;
    private final TextArea notes;

    public DashboardView(@NotNull User user, @NotNull ClientRestService clientRestService)
    {
        this.user = user;
        this.clientRestService = clientRestService;
        addStyleName(ValoTheme.PANEL_BORDERLESS);
        setSizeFull();
        DashboardEventBus.register(this);

        notificationsButton = buildNotificationsButton();
        root = new VerticalLayout();

        root.setSizeFull();
        root.setMargin(true);
        root.setImmediate(true);
        root.addStyleName("dashboard-view");
        setContent(root);
        Responsive.makeResponsive(root);

        root.addComponent(buildHeader());
        addCharts();

        // All the open sub-windows should be closed whenever the root layout
        // gets clicked.
        root.addLayoutClickListener(new LayoutEvents.LayoutClickListener()
        {
            @Override
            public void layoutClick(final LayoutEvents.LayoutClickEvent event)
            {
                DashboardEventBus.post(new DashboardEvent.CloseOpenWindowsEvent());
            }
        });
        notes = new TextArea("QA Contacts");
    }

    private void addCharts()
    {
        Executors.newSingleThreadExecutor().submit(new Runnable()
        {
            @Override public void run()
            {
                Component ticketTypeChart = TicketTypeChart.getChart(clientRestService);
                Component categoryModalityChart = CategoryModalityChart.getChart(clientRestService);
                Component notes = createPanel(buildNotes());
                final Component ticketsPerDayChart = TicketsPerDayChart.getChart(clientRestService);
                final MHorizontalLayout
                        components =
                        new MHorizontalLayout(ticketTypeChart, categoryModalityChart, notes)
                                .withFullHeight()
                                .withFullWidth()
                                .withSpacing(true);
                components.setImmediate(true);

                UI.getCurrent().access(new Runnable()
                {
                    @Override public void run()
                    {
                        root.addComponent(components);
                        root.addComponent(ticketsPerDayChart);
                        root.setExpandRatio(components, 1.0f);
                        root.setExpandRatio(ticketsPerDayChart, 1.0f);
                    }
                });
            }
        });
    }

    private Component buildHeader()
    {
        HorizontalLayout header = new HorizontalLayout();
        header.addStyleName("viewheader");
        header.setSpacing(true);
        header.setWidth("100%");

        titleLabel = new Label("Qualitas");
        titleLabel.setId(TITLE_ID);
        titleLabel.setSizeUndefined();
        titleLabel.addStyleName(ValoTheme.LABEL_H1);
        titleLabel.addStyleName(ValoTheme.LABEL_NO_MARGIN);
        header.addComponent(titleLabel);


//        HorizontalLayout tools = new HorizontalLayout(notificationsButton);
//        tools.setSpacing(true);
//        tools.addStyleName("toolbar");
//        header.addComponent(tools);
        header.setComponentAlignment(titleLabel, Alignment.BOTTOM_LEFT);
//        header.setComponentAlignment(tools, Alignment.TOP_RIGHT);

        return header;
    }

    private NotificationsButton buildNotificationsButton()
    {
        NotificationsButton result = new NotificationsButton();
        result.addClickListener(new Button.ClickListener()
        {
            @Override
            public void buttonClick(final Button.ClickEvent event)
            {
                openNotificationsPopup(event);
            }
        });
        return result;
    }

    private Component buildEditButton()
    {
        Button result = new Button();
        result.setId(EDIT_ID);
        result.setIcon(FontAwesome.EDIT);
        result.addStyleName("icon-edit");
        result.addStyleName(ValoTheme.BUTTON_ICON_ONLY);
        result.setDescription("Edit Dashboard");
        result.addClickListener(new Button.ClickListener()
        {
            @Override
            public void buttonClick(final Button.ClickEvent event)
            {
                getUI().addWindow(new DashboardEdit(DashboardView.this, titleLabel.getValue()));
            }
        });
        return result;
    }

    private Component buildNotes()
    {
        notes.setSizeFull();
        notes.addStyleName("notes");
        notes.addStyleName(ValoTheme.TEXTAREA_LARGE);

        return notes;
    }

    private Component createContentWrapper(final Component content)
    {
        final CssLayout slot = new CssLayout();
        slot.setSizeFull();
        slot.addStyleName("dashboard-panel-slot");

        CssLayout card = new CssLayout();
        card.setSizeFull();
        card.addStyleName(ValoTheme.LAYOUT_CARD);

        HorizontalLayout toolbar = new HorizontalLayout();
        toolbar.addStyleName("dashboard-panel-toolbar");
        toolbar.setWidth("100%");

        Label caption = new Label(content.getCaption());
        caption.addStyleName(ValoTheme.LABEL_H4);
        caption.addStyleName(ValoTheme.LABEL_COLORED);
        caption.addStyleName(ValoTheme.LABEL_NO_MARGIN);
        content.setCaption(null);


        toolbar.addComponents(caption);
        toolbar.setExpandRatio(caption, 1);
        toolbar.setComponentAlignment(caption, Alignment.MIDDLE_LEFT);

        card.addComponents(toolbar, content);
        slot.addComponent(card);
        return slot;
    }

    private CssLayout createPanel(Component content)
    {
        CssLayout panel = new CssLayout();
        panel.addStyleName("layout-panel");
        panel.setSizeFull();

//        Button configure = new Button();
//        configure.addStyleName("configure");
//        configure.addStyleName("icon-cog");
//        configure.addStyleName("icon-only");
//        configure.addStyleName("borderless");
//        configure.setDescription("Configure");
//        configure.addStyleName("small");
//        configure.addClickListener(new ClickListener()
//        {
//            @Override
//            public void buttonClick(ClickEvent event)
//            {
//                Notification.show("Not implemented in this demo");
//            }
//        });
//        panel.addComponent(configure);
        panel.addComponent(content);
        return panel;
    }

    private void openNotificationsPopup(final Button.ClickEvent event)
    {
        VerticalLayout notificationsLayout = new VerticalLayout();
        notificationsLayout.setMargin(true);
        notificationsLayout.setSpacing(true);

        Label title = new Label("Notifications");
        title.addStyleName(ValoTheme.LABEL_H3);
        title.addStyleName(ValoTheme.LABEL_NO_MARGIN);
        notificationsLayout.addComponent(title);


        HorizontalLayout footer = new HorizontalLayout();
        footer.addStyleName(ValoTheme.WINDOW_BOTTOM_TOOLBAR);
        footer.setWidth("100%");
        Button showAll = new Button("View All Notifications", new Button.ClickListener()
        {
            @Override
            public void buttonClick(final Button.ClickEvent event)
            {
                Notification.show("Not implemented in this demo");
            }
        });
        showAll.addStyleName(ValoTheme.BUTTON_BORDERLESS_COLORED);
        showAll.addStyleName(ValoTheme.BUTTON_SMALL);
        footer.addComponent(showAll);
        footer.setComponentAlignment(showAll, Alignment.TOP_CENTER);
        notificationsLayout.addComponent(footer);

        if (notificationsWindow == null)
        {
            notificationsWindow = new Window();
            notificationsWindow.setWidth(300.0f, Unit.PIXELS);
            notificationsWindow.addStyleName("notifications");
            notificationsWindow.setClosable(false);
            notificationsWindow.setResizable(false);
            notificationsWindow.setDraggable(false);
            notificationsWindow.setCloseShortcut(ShortcutAction.KeyCode.ESCAPE, null);
            notificationsWindow.setContent(notificationsLayout);
        }

        if (!notificationsWindow.isAttached())
        {
            notificationsWindow.setPositionY(event.getClientY() - event.getRelativeY() + 40);
            getUI().addWindow(notificationsWindow);
            notificationsWindow.focus();
        }
        else
        {
            notificationsWindow.close();
        }
    }

    @Override
    public void enter(final ViewChangeListener.ViewChangeEvent event)
    {
        notificationsButton.updateNotificationsCount(null);

        notes.setReadOnly(false);
        Role role = user.getRole();
        if (role == Role.QAD || role == Role.CMO || role == Role.ERP)
        {
            List<Institution>
                    institutions =
                    role == Role.QAD ? clientRestService.findAllInstitutions() : user.getInstitutions();

            List<Institution> sortedInstitutions = sort(institutions, on(Institution.class).getName());
            StringBuilder notesText = new StringBuilder();
            for (Institution institution : sortedInstitutions)
            {
                notesText.append(institution.getName())
                        .append("\n")
                        .append("Primary QA Contact : ")
                        .append(institution.getBillingContactName() != null ?
                                institution.getBillingContactName() :
                                "N/A")
                        .append("\n")
                        .append("Primary QA Phone : ")
                        .append(institution.getBillingPhone() != null ?
                                institution.getBillingPhone().getNumber() :
                                "N/A")
                        .append("\n\n");
            }
            notes.setValue(notesText.toString());
            notes.setReadOnly(true);
        }
    }

    @Override
    public void dashboardNameEdited(final String name)
    {
        titleLabel.setValue(name);
    }

    private void toggleMaximized(final Component panel, final boolean maximized)
    {
        for (Iterator<Component> it = root.iterator(); it.hasNext(); )
        {
            it.next().setVisible(!maximized);
        }
        dashboardPanels.setVisible(true);

        for (Iterator<Component> it = dashboardPanels.iterator(); it.hasNext(); )
        {
            Component c = it.next();
            c.setVisible(!maximized);
        }

        if (maximized)
        {
            panel.setVisible(true);
            panel.addStyleName("max");
        }
        else
        {
            panel.removeStyleName("max");
        }
    }

    public static final class NotificationsButton extends Button
    {
        public static final String ID = "dashboard-notifications";
        private static final String STYLE_UNREAD = "unread";

        public NotificationsButton()
        {
            setIcon(FontAwesome.BELL);
            setId(ID);
            addStyleName("notifications");
            addStyleName(ValoTheme.BUTTON_ICON_ONLY);
            DashboardEventBus.register(this);
        }

        @Subscribe
        public void updateNotificationsCount(final DashboardEvent.NotificationsCountUpdatedEvent event)
        {
        }

        public void setUnreadCount(final int count)
        {
            setCaption(String.valueOf(count));

            String description = "Notifications";
            if (count > 0)
            {
                addStyleName(STYLE_UNREAD);
                description += " (" + count + " unread)";
            }
            else
            {
                removeStyleName(STYLE_UNREAD);
            }
            setDescription(description);
        }
    }

}
