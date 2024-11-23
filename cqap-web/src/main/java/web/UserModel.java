package web;

import com.cqap.client.*;
import com.google.common.collect.*;
import com.lakeland.ris.ui.datamodel.*;
import com.peirs.datamodel.*;
import com.vaadin.data.*;
import com.vaadin.data.util.*;
import com.vaadin.ui.*;


import java.util.*;

import static ch.lambdaj.Lambda.*;
import static ch.lambdaj.collection.LambdaCollections.*;

public class UserModel
{
    private final ClientRestService risRestApi;
    private final CPTCodeService cptCodeService;
    private final UserContainer userContainer;
    private final InstitutionContainer institutionContainer;
    private final Collection<CPTCodePrimaryGroup> cptCodes;
    private final IndexedContainer primaryCPTCodesContainer;
    private final IndexedContainer secondaryCPTCodesContainer;
    private final BeanContainer<String, Country> countriesContainer;
    private final IndexedContainer timezonesContainer;

    public UserModel(ClientRestService risRestApi)
    {
        this.risRestApi = risRestApi;
        userContainer = new UserContainer();
        institutionContainer = new InstitutionContainer();
        cptCodeService = new CPTCodeService(risRestApi);
        cptCodes = Lists.newArrayList();
        primaryCPTCodesContainer = new IndexedContainer();
        secondaryCPTCodesContainer = new IndexedContainer();
        countriesContainer = new BeanContainer<String, Country>(Country.class);
        timezonesContainer = new IndexedContainer();
        countriesContainer.setBeanIdProperty("name");
        countriesContainer.addAll(risRestApi.findAllCountries());
        institutionContainer.setBeanIdProperty("name");
    }

    public void refresh()
    {
        cptCodes.clear();
        cptCodes.addAll(cptCodeService.getMapped());
        final Collection<User> allUsers = risRestApi.findAllUsers();
        final List<Institution> allInstitutions = risRestApi.findAllInstitutions();
        UI.getCurrent().access(new Runnable()
        {
            @Override public void run()
            {
                userContainer.removeAllContainerFilters();
                userContainer.removeAllItems();
                userContainer.addAll(allUsers);
                userContainer.sort(new Object[]{"username"}, new boolean[]{true});

                institutionContainer.removeAllContainerFilters();
                institutionContainer.removeAllItems();
                institutionContainer.addAll(allInstitutions);
                institutionContainer.sort(new Object[]{"name"}, new boolean[]{true});

                primaryCPTCodesContainer.removeAllItems();
                secondaryCPTCodesContainer.removeAllItems();
                for (String primary : with(cptCodes).extract(on(CPTCodePrimaryGroup.class).getSubspecialtyPrimary()))
                {
                    primaryCPTCodesContainer.addItem(primary);
                }
                for (CPTCodePrimaryGroup cptCode : cptCodes)
                {
                    for (String secondary : with(cptCode.getSecondaryGroups()).extract(on(CPTCodeSecondaryGroup.class).getSubspecialtySecondary()))
                    {
                        secondaryCPTCodesContainer.addItem(secondary);
                    }
                }
            }
        });
    }

    public void createOrUpdate(final User user)
    {
        risRestApi.createOrUpdateUser(user);
        refresh();
    }

    public void delete(final User user)
    {
        risRestApi.deleteUser(user);
        UI.getCurrent().access(new Runnable()
        {
            @Override public void run()
            {
                userContainer.removeItem(user.getId());
            }
        });
    }

    public boolean addUser()
    {
        userContainer.removeAllContainerFilters();
        if (!userContainer.containsId("unassigned"))
        {
            BeanItem<User> newUser = userContainer.addItemAt(0);
            newUser.getBean().setId("unassigned");

            return true;
        }
        else
        {
            Notification.show("Please finish creating the last 'newuser' before creating another one");
        }

        return false;
    }

    public UserContainer getUsers()
    {
        return userContainer;
    }

    public IndexedContainer getPrimaryCPTCodesContainer()
    {
        return primaryCPTCodesContainer;
    }

    public IndexedContainer getSecondaryCPTCodesContainer()
    {
        return secondaryCPTCodesContainer;
    }

    public BeanContainer<String, Country> getCountriesContainer()
    {
        return countriesContainer;
    }

    public IndexedContainer getTimezonesContainer()
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

    public Container getInstitutions()
    {
        return institutionContainer;
    }
}
