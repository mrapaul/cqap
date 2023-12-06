package web;

import com.cqap.client.*;
import com.peirs.datamodel.*;
import com.vaadin.data.*;
import com.vaadin.data.util.*;
import com.vaadin.ui.*;
import org.jetbrains.annotations.*;

import java.util.*;

import static ch.lambdaj.Lambda.on;
import static ch.lambdaj.Lambda.sort;


public class InstitutionModel
{
    private static final String FNAME = "name";
    @NotNull private final ClientRestService risRestApi;
    @NotNull private final InstitutionContainer institutionContainer;
    @NotNull private final IndexedContainer userContainer;
    @NotNull private final BeanContainer<String, Country> countriesContainer;
    @NotNull private final IndexedContainer timezonesContainer;

    public InstitutionModel(@NotNull ClientRestService risRestApi)
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

    @NotNull public InstitutionContainer getInstitutionContainer()
    {
        return institutionContainer;
    }

    @NotNull public IndexedContainer getUserContainer()
    {
        return userContainer;
    }

    @NotNull public Container getCountriesContainer()
    {
        return countriesContainer;
    }

    @NotNull public Container getTimezonesContainer()
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

