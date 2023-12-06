package web;

import com.vaadin.server.*;

import javax.servlet.*;

public class DashboardServlet extends VaadinServlet
{

    @Override
    protected final void servletInitialized() throws ServletException
    {
        super.servletInitialized();
        getService().addSessionInitListener(new DashboardSessionInitListener());
    }
}