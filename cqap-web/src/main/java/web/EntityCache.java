package web;

import com.cqap.client.*;
import com.google.common.collect.*;
import com.peirs.datamodel.*;

import java.util.*;

public class EntityCache
{
    private final ClientRestService clientService;
    private final Set<String> pirs;
    private final Set<String> sts;
    private final Set<Group> groups;
    private final Set<Institution> institutions;
    private final Set<Country> countries;

    public EntityCache(ClientRestService aClientService)
    {
        clientService = aClientService;
        pirs = Sets.newHashSet();
        sts = Sets.newHashSet();
        groups = Sets.newHashSet();
        institutions = Sets.newHashSet();
        countries = Sets.newHashSet();
    }

    public void initialize()
    {
        pirs.addAll(clientService.findUsersForRole(Role.PIR));
        sts.addAll(clientService.findUsersForRole(Role.ST));
        groups.addAll(clientService.findAllGroups());
        institutions.addAll(clientService.findAllInstitutions());
        countries.addAll(clientService.findAllCountries());
    }

    public Set<String> getPirs()
    {
        return pirs;
    }

    public Set<String> getSts()
    {
        return sts;
    }

    public Set<Group> getGroups()
    {
        return groups;
    }

    public Set<Institution> getInstitutions()
    {
        return institutions;
    }

    public Set<Country> getCountries()
    {
        return countries;
    }
}
