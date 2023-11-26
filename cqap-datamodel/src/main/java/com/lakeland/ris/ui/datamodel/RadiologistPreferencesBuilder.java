package com.lakeland.ris.ui.datamodel;

import org.jetbrains.annotations.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;
import java.util.*;

public class RadiologistPreferencesBuilder
{
    @NotNull private Collection<String> institutions;
    @NotNull private Collection<String> cPTCodes;
    @NotNull private Set<String> cPTPrimarySpecialities;
    @NotNull private Set<String> cPTSecondarySpecialities;
    @Nullable private UserLocation location;

    public RadiologistPreferencesBuilder(@NotNull Collection<String> institutions,
                                         @NotNull Collection<String> cPTCodes,
                                         @NotNull Set<String> cPTPrimarySpecialities,
                                         @NotNull Set<String> cPTSecondarySpecialities)
    {
        super();

        this.institutions = institutions;
        this.cPTCodes = cPTCodes;
        this.cPTPrimarySpecialities = cPTPrimarySpecialities;
        this.cPTSecondarySpecialities = cPTSecondarySpecialities;
    }


    @NotNull
    public RadiologistPreferencesBuilder setInstitutions(@NotNull Collection<String> institutions)
    {
        this.institutions = institutions;

        return self();
    }

    @NotNull
    public RadiologistPreferencesBuilder setCPTCodes(@NotNull Collection<String> cPTCodes)
    {
        this.cPTCodes = cPTCodes;

        return self();
    }

    @NotNull
    public RadiologistPreferencesBuilder setCPTPrimarySpecialities(@NotNull Set<String> cPTPrimarySpecialities)
    {
        this.cPTPrimarySpecialities = cPTPrimarySpecialities;

        return self();
    }

    @NotNull
    public RadiologistPreferencesBuilder setCPTSecondarySpecialities(@NotNull Set<String> cPTSecondarySpecialities)
    {
        this.cPTSecondarySpecialities = cPTSecondarySpecialities;

        return self();
    }

    @NotNull
    public RadiologistPreferencesBuilder setLocation(@Nullable UserLocation location)
    {
        this.location = location;

        return self();
    }

    @NotNull
    protected Collection<String> getInstitutions()
    {
        return institutions;
    }

    @NotNull
    protected Collection<String> getCPTCodes()
    {
        return cPTCodes;
    }

    @NotNull
    protected Set<String> getCPTPrimarySpecialities()
    {
        return cPTPrimarySpecialities;
    }

    @NotNull
    protected Set<String> getCPTSecondarySpecialities()
    {
        return cPTSecondarySpecialities;
    }

    @Nullable
    protected UserLocation getLocation()
    {
        return location;
    }

    @NotNull
    public RadiologistPreferences build()
    {
        return new RadiologistPreferences(getInstitutions(),
                                          getCPTCodes(),
                                          getCPTPrimarySpecialities(),
                                          getCPTSecondarySpecialities(),
                                          getLocation());
    }


    @NotNull
    protected RadiologistPreferencesBuilder self()
    {
        return this;
    }
}