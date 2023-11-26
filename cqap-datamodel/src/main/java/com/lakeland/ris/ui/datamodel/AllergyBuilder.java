package com.lakeland.ris.ui.datamodel;

import org.jetbrains.annotations.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;


public class AllergyBuilder
{
    @Nullable private String name;
    @Nullable private String type;
    @Nullable private String description;
    @Nullable private String severity;
    @Nullable private String reaction;
    @Nullable private String identificationDate;

    public AllergyBuilder()
    {
        super();

    }


    @NotNull
    public AllergyBuilder setName(@Nullable String name)
    {
        this.name = name;

        return self();
    }

    @NotNull
    public AllergyBuilder setType(@Nullable String type)
    {
        this.type = type;

        return self();
    }

    @NotNull
    public AllergyBuilder setDescription(@Nullable String description)
    {
        this.description = description;

        return self();
    }

    @NotNull
    public AllergyBuilder setSeverity(@Nullable String severity)
    {
        this.severity = severity;

        return self();
    }

    @NotNull
    public AllergyBuilder setReaction(@Nullable String reaction)
    {
        this.reaction = reaction;

        return self();
    }

    @NotNull
    public AllergyBuilder setIdentificationDate(@Nullable String identificationDate)
    {
        this.identificationDate = identificationDate;

        return self();
    }

    @Nullable
    protected String getName()
    {
        return name;
    }

    @Nullable
    protected String getType()
    {
        return type;
    }

    @Nullable
    protected String getDescription()
    {
        return description;
    }

    @Nullable
    protected String getSeverity()
    {
        return severity;
    }

    @Nullable
    protected String getReaction()
    {
        return reaction;
    }

    @Nullable
    protected String getIdentificationDate()
    {
        return identificationDate;
    }

    @NotNull
    public Allergy build()
    {
        return new Allergy(getName(),
                           getType(),
                           getDescription(),
                           getSeverity(),
                           getReaction(),
                           getIdentificationDate());
    }


    @NotNull
    protected AllergyBuilder self()
    {
        return this;
    }
}