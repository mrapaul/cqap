package com.lakeland.ris.ui.datamodel;

import org.codehaus.jackson.annotate.*;

import java.util.*;
import com.lakeland.ris.datamodel.*;
import java.util.*;

public class RadiologistPreferences
{
    private Collection<String> institutions;
    private Collection<String> cPTCodes;
    private Set<String> cPTPrimarySpecialities;
    private Set<String> cPTSecondarySpecialities;
     private UserLocation location;

    public RadiologistPreferences()
    {
        // empty
    }

    @JsonCreator
    public RadiologistPreferences(Collection<String> institutions,
                                  Collection<String> cPTCodes,
                                  Set<String> cPTPrimarySpecialities,
                                  Set<String> cPTSecondarySpecialities,
                                   UserLocation location)
    {
        super();

        this.institutions = institutions;
        this.cPTCodes = cPTCodes;
        this.cPTPrimarySpecialities = cPTPrimarySpecialities;
        this.cPTSecondarySpecialities = cPTSecondarySpecialities;
        this.location = location;
    }

    
    public Collection<String> getInstitutions()
    {
        return institutions;
    }

    
    public Collection<String> getCPTCodes()
    {
        return cPTCodes;
    }

    
    public Set<String> getCPTPrimarySpecialities()
    {
        return cPTPrimarySpecialities;
    }

    
    public Set<String> getCPTSecondarySpecialities()
    {
        return cPTSecondarySpecialities;
    }

    
    public UserLocation getLocation()
    {
        return location;
    }
    public void setInstitutions(Collection<String> institutions)
    {
        this.institutions = institutions;
    }

    public void setCPTCodes(Collection<String> cPTCodes)
    {
        this.cPTCodes = cPTCodes;
    }

    public void setCPTPrimarySpecialities(Set<String> cPTPrimarySpecialities)
    {
        this.cPTPrimarySpecialities = cPTPrimarySpecialities;
    }

    public void setCPTSecondarySpecialities(Set<String> cPTSecondarySpecialities)
    {
        this.cPTSecondarySpecialities = cPTSecondarySpecialities;
    }

    public void setLocation( UserLocation location)
    {
        this.location = location;
    }

    
    public String toString()
    {
        return "RadiologistPreferences(" +
            " institutions: " + getInstitutions() +
            " cPTCodes: " + getCPTCodes() +
            " cPTPrimarySpecialities: " + getCPTPrimarySpecialities() +
            " cPTSecondarySpecialities: " + getCPTSecondarySpecialities() +
            " location: " + getLocation() + ")";
    }

    
    public RadiologistPreferencesBuilder toBuilder()
    {
        return new RadiologistPreferencesBuilder(getInstitutions(),
                                                 getCPTCodes(),
                                                 getCPTPrimarySpecialities(),
                                                 getCPTSecondarySpecialities()).setLocation(getLocation());
    }
}