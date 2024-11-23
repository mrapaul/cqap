package web;

import com.peirs.datamodel.*;
import com.vaadin.ui.*;

import org.tepi.filtertable.*;

public class UserPresenter implements UserView.UserViewListener
{
    private final UserModel model;
    private final UserView view;

    public UserPresenter(UserModel model, UserView view)
    {
        this.model = model;
        this.view = view;
        view.setListener(this);
        view.setContainers(model.getUsers(),
                model.getInstitutions(),
                model.getPrimaryCPTCodesContainer(),
                model.getSecondaryCPTCodesContainer(),
                model.getCountriesContainer(),
                model.getTimezonesContainer());
    }

    @Override public void viewEntered()
    {
        model.refresh();
    }

    @Override public void createOrUpdate(User user)
    {
        model.createOrUpdate(user);
    }

    @Override public void delete(User user)
    {
        model.delete(user);
    }

    @Override public void addUser()
    {
        if (model.addUser())
        {
            view.editNewUser("unassigned");
        }
    }

    @Override public void countrySelected(Country country)
    {
        model.countrySelected(country);
    }
}
