package web;

import com.peirs.datamodel.*;
import com.vaadin.ui.*;
import org.jetbrains.annotations.*;
import org.tepi.filtertable.*;

public class UserPresenter implements UserView.UserViewListener
{
    private final UserModel model;
    private final UserView view;

    public UserPresenter(@NotNull UserModel model, @NotNull UserView view)
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

    @Override public void createOrUpdate(@NotNull User user)
    {
        model.createOrUpdate(user);
    }

    @Override public void delete(@NotNull User user)
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

    @Override public void countrySelected(@NotNull Country country)
    {
        model.countrySelected(country);
    }
}
