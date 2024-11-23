package com.lakeland.ris.ui.datamodel;


import java.util.*;
import com.lakeland.ris.datamodel.*;
import java.util.*;

public class RadiologistPreferencesBuilder
{
    private Collection<String> institutions;
    private Collection<String> cPTCodes;
    private Set<String> cPTPrimarySpecialities;
    private Set<String> cPTSecondarySpecialities;
     private UserLocation location;

    public RadiologistPreferencesBuilder(Collection<String> institutions,
                                         Collection<String> cPTCodes,
                                         Set<String> cPTPrimarySpecialities,
                                         Set<String> cPTSecondarySpecialities)
    {
        super();

        this.institutions = institutions;
        this.cPTCodes = cPTCodes;
        this.cPTPrimarySpecialities = cPTPrimarySpecialities;
        this.cPTSecondarySpecialities = cPTSecondarySpecialities;
    }


    
    public RadiologistPreferencesBuilder setInstitutions(Collection<String> institutions)
    {
        this.institutions = institutions;

        return self();
    }

    
    public RadiologistPreferencesBuilder setCPTCodes(Collection<String> cPTCodes)
    {
        this.cPTCodes = cPTCodes;

        return self();
    }

    
    public RadiologistPreferencesBuilder setCPTPrimarySpecialities(Set<String> cPTPrimarySpecialities)
    {
        this.cPTPrimarySpecialities = cPTPrimarySpecialities;

        return self();
    }

    
    public RadiologistPreferencesBuilder setCPTSecondarySpecialities(Set<String> cPTSecondarySpecialities)
    {
        this.cPTSecondarySpecialities = cPTSecondarySpecialities;

        return self();
    }

    
    public RadiologistPreferencesBuilder setLocation( UserLocation location)
    {
        this.location = location;

        return self();
    }

    
    protected Collection<String> getInstitutions()
    {
        return institutions;
    }

    
    protected Collection<String> getCPTCodes()
    {
        return cPTCodes;
    }

    
    protected Set<String> getCPTPrimarySpecialities()
    {
        return cPTPrimarySpecialities;
    }

    
    protected Set<String> getCPTSecondarySpecialities()
    {
        return cPTSecondarySpecialities;
    }

    
    protected UserLocation getLocation()
    {
        return location;
    }

    
    public RadiologistPreferences build()
    {
        return new RadiologistPreferences(getInstitutions(),
                                          getCPTCodes(),
                                          getCPTPrimarySpecialities(),
                                          getCPTSecondarySpecialities(),
                                          getLocation());
    }


    
    protected RadiologistPreferencesBuilder self()
    {
        return this;
    }
}