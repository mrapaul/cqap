package web;

import com.cqap.client.*;
import com.google.common.collect.*;
import com.lakeland.ris.ui.datamodel.*;
import com.peirs.datamodel.*;
import com.vaadin.data.*;
import com.vaadin.data.util.*;
import com.vaadin.ui.*;
import org.jetbrains.annotations.*;

import java.util.*;

import static ch.lambdaj.Lambda.*;
import static ch.lambdaj.collection.LambdaCollections.*;

public class UserModel
{
    @NotNull private final ClientRestService risRestApi;
    @NotNull private final CPTCodeService cptCodeService;
    @NotNull private final UserContainer userContainer;
    @NotNull private final InstitutionContainer institutionContainer;
    @NotNull private final Collection<CPTCodePrimaryGroup> cptCodes;
    @NotNull private final IndexedContainer primaryCPTCodesContainer;
    @NotNull private final IndexedContainer secondaryCPTCodesContainer;
    @NotNull private final BeanContainer<String, Country> countriesContainer;
    @NotNull private final IndexedContainer timezonesContainer;

    public UserModel(@NotNull ClientRestService risRestApi)
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

    public void createOrUpdate(@NotNull final User user)
    {
        risRestApi.createOrUpdateUser(user);
        refresh();
    }

    public void delete(@NotNull final User user)
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

    @NotNull public UserContainer getUsers()
    {
        return userContainer;
    }

    @NotNull public IndexedContainer getPrimaryCPTCodesContainer()
    {
        return primaryCPTCodesContainer;
    }

    @NotNull public IndexedContainer getSecondaryCPTCodesContainer()
    {
        return secondaryCPTCodesContainer;
    }

    @NotNull public BeanContainer<String, Country> getCountriesContainer()
    {
        return countriesContainer;
    }

    @NotNull public IndexedContainer getTimezonesContainer()
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
