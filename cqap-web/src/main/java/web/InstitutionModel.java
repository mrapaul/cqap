package web;

import com.cqap.client.*;
import com.peirs.datamodel.*;
import com.vaadin.data.*;
import com.vaadin.data.util.*;
import com.vaadin.ui.*;


import java.util.*;

import static ch.lambdaj.Lambda.on;
import static ch.lambdaj.Lambda.sort;


public class InstitutionModel
{
    private static final String FNAME = "name";
    private final ClientRestService risRestApi;
    private final InstitutionContainer institutionContainer;
    private final IndexedContainer userContainer;
    private final BeanContainer<String, Country> countriesContainer;
    private final IndexedContainer timezonesContainer;

    public InstitutionModel(ClientRestService risRestApi)
    {
        this.risRestApi = risRestApi;

        userContainer = new IndexedContainer();
        institutionContainer = new InstitutionContainer();
        countriesContainer = new BeanContainer<String, Country>(Country.class);
        timezonesContainer = new IndexedContainer();
        countriesContainer.setBeanIdProperty("name");
        countriesContainer.addAll(risRestApi.findAllCountries());
    }

    public void refresh()
    {
        UI.getCurrent().access(new Runnable()
        {
            @Override public void run()
            {
                userContainer.removeAllItems();
                for (User user : risRestApi.findAllUsers())
                {
                    userContainer.addItem(user.getUsername());
                }
                institutionContainer.removeAllItems();
                Collection<Institution> institutions = risRestApi.findAllInstitutions();
                List<Institution> sorted = sort(institutions, on(Institution.class).getName());
                institutionContainer.addAll(sorted);
            }
        });
    }

    public boolean addInstitution()
    {
        institutionContainer.removeAllContainerFilters();
        if (!institutionContainer.containsId("unassigned"))
        {
            BeanItem<Institution> newInstitution = institutionContainer.addItemAt(0);
            newInstitution.getBean().setId("unassigned");

            return true;
        }
        else
        {
            Notification.show("Please finish creating the last 'newinstitution' before creating another one");
        }

        return false;
    }

    public void createOrUpdate(final Institution institution)
    {
        risRestApi.createOrUpdateInstitution(institution);
        refresh();
    }

    public void delete(final Institution institution)
    {
        risRestApi.deleteInstitution(institution);
        UI.getCurrent().access(new Runnable()
        {
            @Override public void run()
            {
                institutionContainer.removeItem(institution.getId());
            }
        });
    }

    public InstitutionContainer getInstitutionContainer()
    {
        return institutionContainer;
    }

    public IndexedContainer getUserContainer()
    {
        return userContainer;
    }

    public Container getCountriesContainer()
    {
        return countriesContainer;
    }

    public Container getTimezonesContainer()
    {
        return timezonesContainer;
    }

    public void countrySelected(Country country)
    {
        final Set<String> timezones = risRestApi.findTimezones(country);
        UI.getCurrent().access(new Runnable()
        {
            @Override public void run()
            {
                timezonesContainer.removeAllItems();
                for (String timezone : timezones)
                {
                    timezonesContainer.addItem(timezone);
                }
            }
        });
    }
}

