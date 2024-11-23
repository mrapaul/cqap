package web;

import com.peirs.datamodel.*;
import com.vaadin.ui.*;

import org.tepi.filtertable.*;

public class InstitutionPresenter implements InstitutionView.InstitutionViewListener
{
    private final InstitutionModel model;
    private final InstitutionView view;

    public InstitutionPresenter(InstitutionModel model, InstitutionView view)
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

    @Override public void createOrUpdate(Institution institution)
    {
        model.createOrUpdate(institution);
    }

    @Override public void delete(Institution institution)
    {
        model.delete(institution);
    }

    @Override public void countrySelected(Country country)
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
