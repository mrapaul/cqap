package web;

import com.peirs.datamodel.*;
import com.vaadin.ui.*;
import org.jetbrains.annotations.*;
import org.tepi.filtertable.*;

public class InstitutionPresenter implements InstitutionView.InstitutionViewListener
{
    @NotNull private final InstitutionModel model;
    @NotNull private final InstitutionView view;

    public InstitutionPresenter(@NotNull InstitutionModel model, @NotNull InstitutionView view)
    {
        this.model = model;
        this.view = view;
        view.setListener(this);
        view.setContainers(model.getInstitutionContainer(),
                model.getUserContainer(),
                model.getCountriesContainer(),
                model.getTimezonesContainer());
    }

    @Override public void viewEntered()
    {
        model.refresh();
    }

    @Override public void createOrUpdate(@NotNull Institution institution)
    {
        model.createOrUpdate(institution);
    }

    @Override public void delete(@NotNull Institution institution)
    {
        model.delete(institution);
    }

    @Override public void countrySelected(@NotNull Country country)
    {
        model.countrySelected(country);
    }

    @Override public void addInstitution()
    {
        if (model.addInstitution())
        {
            view.editNewInstitution("unassigned");
        }
    }
}
