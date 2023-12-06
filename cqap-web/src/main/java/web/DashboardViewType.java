package web;


import com.vaadin.navigator.*;
import com.vaadin.server.*;

public enum DashboardViewType
{
    DASHBOARD("dashboard", DashboardView.class, FontAwesome.HOME, true),
    NEW_STUDY("addticket", NewTicketViewImpl.class, FontAwesome.PLUS, true),
    WORKLIST("worklist", WorklistViewImpl.class, FontAwesome.LIST, true),
    TICKET_ARCHIVE("archive", ArchiveViewImpl.class, FontAwesome.ARCHIVE, true),
    USERS("users", UserViewImpl.class, FontAwesome.USERS, true),
    INSTITUTIONS("institutions", InstitutionViewImpl.class, FontAwesome.HOSPITAL_O, true);
    private final String viewName;
    private final Class<? extends View> viewClass;
    private final Resource icon;
    private final boolean stateful;

    private DashboardViewType(final String viewName,
                              final Class<? extends View> viewClass,
                              final Resource icon,
                              final boolean stateful)
    {
        this.viewName = viewName;
        this.viewClass = viewClass;
        this.icon = icon;
        this.stateful = stateful;
    }

    public static DashboardViewType getByViewName(final String viewName)
    {
        DashboardViewType result = null;
        for (DashboardViewType viewType : values())
        {
            if (viewType.getViewName().equals(viewName))
            {
                result = viewType;
                break;
            }
        }
        return result;
    }

    public boolean isStateful()
    {
        return stateful;
    }

    public String getViewName()
    {
        return viewName;
    }

    public Class<? extends View> getViewClass()
    {
        return viewClass;
    }

    public Resource getIcon()
    {
        return icon;
    }

}