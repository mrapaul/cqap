package web;

import com.cqap.client.*;
import com.google.common.collect.*;
import com.peirs.datamodel.*;
import com.vaadin.navigator.*;
import com.vaadin.ui.*;
import org.vaadin.googleanalytics.tracking.*;
import web.event.*;

import java.util.*;

@SuppressWarnings("serial")
public class DashboardNavigator extends Navigator
{

    // Provide a Google Analytics tracker id here
    private static final String TRACKER_ID = null;// "UA-658457-6";
    private static final DashboardViewType ERROR_VIEW = DashboardViewType.DASHBOARD;
    private final ClientRestService clientRestService;
    private final User user;
    private final EntityCache entityCache;
    private GoogleAnalyticsTracker tracker;
    private ViewProvider errorViewProvider;

    public DashboardNavigator(final ComponentContainer container, ClientRestService clientRestService, User user)
    {
        super(UI.getCurrent(), container);
        this.clientRestService = clientRestService;
        this.user = user;
        if (TRACKER_ID != null)
        {
            initGATracker(TRACKER_ID);
        }
        initViewChangeListener();
        initViewProviders();
        entityCache = new EntityCache(clientRestService);
        entityCache.initialize();
    }

    private void initGATracker(final String trackerId)
    {
        tracker = new GoogleAnalyticsTracker(trackerId, "none");

        // GoogleAnalyticsTracker is an extension add-on for UI so it is
        // initialized by calling .extend(UI)
        tracker.extend(UI.getCurrent());
    }

    private void initViewChangeListener()
    {
        addViewChangeListener(new ViewChangeListener()
        {

            @Override
            public boolean beforeViewChange(final ViewChangeEvent event)
            {
                // Since there's no conditions in switching between the views
                // we can always return true.
                return true;
            }

            @Override
            public void afterViewChange(final ViewChangeEvent event)
            {
                DashboardViewType view = DashboardViewType.getByViewName(event.getViewName());
                // Appropriate events get fired after the view is changed.
                DashboardEventBus.post(new DashboardEvent.PostViewChangeEvent(view));
                DashboardEventBus.post(new DashboardEvent.BrowserResizeEvent());
                DashboardEventBus.post(new DashboardEvent.CloseOpenWindowsEvent());

                if (tracker != null)
                {
                    // The view change is submitted as a pageview for GA tracker
                    tracker.trackPageview("/dashboard/" + event.getViewName());
                }
            }
        });
    }

    private void initViewProviders()
    {
        // A dedicated view provider is added for each separate view type
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


        for (final DashboardViewType viewType : viewTypes)
        {
            ViewProvider viewProvider = new ClassBasedViewProvider(viewType.getViewName(), viewType.getViewClass())
            {

                // This field caches an already initialized view instance if the
                // view should be cached (stateful views).
                private View cachedInstance;

                @Override
                public View getView(final String viewName)
                {
                    Role role = user.getRole();

                    View result = null;
                    if (viewType.getViewName().equals(viewName))
                    {
                        if (viewType.isStateful())
                        {
                            if (cachedInstance == null)
                            {
                                if (viewName.equals("users") && role == Role.QAD)
                                {
                                    UserModel model = new UserModel(clientRestService);
                                    UserView view = new UserViewImpl();
                                    new UserPresenter(model, view);

                                    cachedInstance = view;
                                }
                                else if (viewName.equals("institutions") && role == Role.QAD)
                                {
                                    InstitutionModel model = new InstitutionModel(clientRestService);
                                    InstitutionView view = new InstitutionViewImpl();
                                    new InstitutionPresenter(model, view);

                                    cachedInstance = view;
                                }
                                else if (viewName.equals("addticket") && role == Role.QAD)
                                {
                                    NewTicketModel
                                            model =
                                            new NewTicketModel(clientRestService, user, entityCache, UI.getCurrent());
                                    NewTicketView view = new NewTicketViewImpl(user);
                                    new NewTicketPresenter(model, view);

                                    cachedInstance = view;
                                }
                                else if (viewName.equals("archive"))
                                {
                                    ArchiveModel model = new ArchiveModel(user, clientRestService, entityCache, UI.getCurrent());
                                    ArchiveView view = new ArchiveViewImpl(user);
                                    new ArchivePresenter(model, view);

                                    cachedInstance = view;
                                }
                                else if (viewName.equals("worklist"))
                                {
                                    WorklistModel
                                            model =
                                            new WorklistModel(user, clientRestService, entityCache, UI.getCurrent());
                                    WorklistView view = new WorklistViewImpl(user);
                                    new WorklistPresenter(model, view);

                                    cachedInstance = view;
                                }
                                else if (viewName.equals("dashboard"))
                                {
                                    cachedInstance = new DashboardView(user, clientRestService);
                                }
                            }
                            result = cachedInstance;
                        }
                    }
                    return result;
                }
            };

            if (viewType == ERROR_VIEW)
            {
                errorViewProvider = viewProvider;
            }

            addProvider(viewProvider);
        }

        setErrorProvider(new ViewProvider()
        {
            @Override
            public String getViewName(final String viewAndParameters)
            {
                return ERROR_VIEW.getViewName();
            }

            @Override
            public View getView(final String viewName)
            {
                return errorViewProvider.getView(ERROR_VIEW.getViewName());
            }
        });
    }
}
