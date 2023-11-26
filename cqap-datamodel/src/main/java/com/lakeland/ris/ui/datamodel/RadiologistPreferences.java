package com.lakeland.ris.ui.datamodel;

import org.codehaus.jackson.annotate.*;
import org.jetbrains.annotations.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;
import java.util.*;

public class RadiologistPreferences
{
    @NotNull private Collection<String> institutions;
    @NotNull private Collection<String> cPTCodes;
    @NotNull private Set<String> cPTPrimarySpecialities;
    @NotNull private Set<String> cPTSecondarySpecialities;
    @Nullable private UserLocation location;

    public RadiologistPreferences()
    {
        // empty
    }

    @JsonCreator
    public RadiologistPreferences(@NotNull Collection<String> institutions,
                                  @NotNull Collection<String> cPTCodes,
                                  @NotNull Set<String> cPTPrimarySpecialities,
                                  @NotNull Set<String> cPTSecondarySpecialities,
                                  @Nullable UserLocation location)
    {
        super();

        this.institutions = institutions;
        this.cPTCodes = cPTCodes;
        this.cPTPrimarySpecialities = cPTPrimarySpecialities;
        this.cPTSecondarySpecialities = cPTSecondarySpecialities;
        this.location = location;
    }

    @NotNull
    public Collection<String> getInstitutions()
    {
        return institutions;
    }

    @NotNull
    public Collection<String> getCPTCodes()
    {
        return cPTCodes;
    }

    @NotNull
    public Set<String> getCPTPrimarySpecialities()
    {
        return cPTPrimarySpecialities;
    }

    @NotNull
    public Set<String> getCPTSecondarySpecialities()
    {
        return cPTSecondarySpecialities;
    }

    @Nullable
    public UserLocation getLocation()
    {
        return location;
    }
    public void setInstitutions(@NotNull Collection<String> institutions)
    {
        this.institutions = institutions;
    }

    public void setCPTCodes(@NotNull Collection<String> cPTCodes)
    {
        this.cPTCodes = cPTCodes;
    }

    public void setCPTPrimarySpecialities(@NotNull Set<String> cPTPrimarySpecialities)
    {
        this.cPTPrimarySpecialities = cPTPrimarySpecialities;
    }

    public void setCPTSecondarySpecialities(@NotNull Set<String> cPTSecondarySpecialities)
    {
        this.cPTSecondarySpecialities = cPTSecondarySpecialities;
    }

    public void setLocation(@Nullable UserLocation location)
    {
        this.location = location;
    }

    @NotNull
    public String toString()
    {
        return "RadiologistPreferences(" +
            " institutions: " + getInstitutions() +
            " cPTCodes: " + getCPTCodes() +
            " cPTPrimarySpecialities: " + getCPTPrimarySpecialities() +
            " cPTSecondarySpecialities: " + getCPTSecondarySpecialities() +
            " location: " + getLocation() + ")";
    }

    @NotNull
    public RadiologistPreferencesBuilder toBuilder()
    {
        return new RadiologistPreferencesBuilder(getInstitutions(),
                                                 getCPTCodes(),
                                                 getCPTPrimarySpecialities(),
                                                 getCPTSecondarySpecialities()).setLocation(getLocation());
    }
}