package web.event;

import com.peirs.datamodel.*;
import web.*;

public abstract class DashboardEvent
{

    public static final class UserLoginRequestedEvent
    {
        private final String userName, password;

        public UserLoginRequestedEvent(final String userName,
                                       final String password)
        {
            this.userName = userName;
            this.password = password;
        }

        public String getUserName()
        {
            return userName;
        }

        public String getPassword()
        {
            return password;
        }
    }

    public static class BrowserResizeEvent
    {

    }

    public static class UserLoggedOutEvent
    {

    }

    public static class NotificationsCountUpdatedEvent
    {
    }

    public static final class ReportsCountUpdatedEvent
    {
        private final int count;

        public ReportsCountUpdatedEvent(final int count)
        {
            this.count = count;
        }

        public int getCount()
        {
            return count;
        }

    }

    public static final class PostViewChangeEvent
    {
        private final DashboardViewType view;

        public PostViewChangeEvent(final DashboardViewType view)
        {
            this.view = view;
        }

        public DashboardViewType getView()
        {
            return view;
        }
    }

    public static class CloseOpenWindowsEvent
    {
    }

    public static class ProfileUpdatedEvent
    {
    }

    public static final class HIPAAComplianceEvent
    {
        private final User user;
        private boolean agreed;

        public HIPAAComplianceEvent(User user, boolean agreed)
        {
            this.user = user;
            this.agreed = agreed;
        }

        public User getUser()
        {
            return user;
        }

        public boolean isAgreed()
        {
            return agreed;
        }
    }
}
