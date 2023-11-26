package com.lakeland.ris.ui.datamodel;

import org.codehaus.jackson.annotate.*;
import org.jetbrains.annotations.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;


public class Allergy
{
    @Nullable private String name;
    @Nullable private String type;
    @Nullable private String description;
    @Nullable private String severity;
    @Nullable private String reaction;
    @Nullable private String identificationDate;

    public Allergy()
    {
        // empty
    }

    @JsonCreator
    public Allergy(@Nullable String name,
                   @Nullable String type,
                   @Nullable String description,
                   @Nullable String severity,
                   @Nullable String reaction,
                   @Nullable String identificationDate)
    {
        super();

        this.name = name;
        this.type = type;
        this.description = description;
        this.severity = severity;
        this.reaction = reaction;
        this.identificationDate = identificationDate;
    }

    @Nullable
    public String getName()
    {
        return name;
    }

    @Nullable
    public String getType()
    {
        return type;
    }

    @Nullable
    public String getDescription()
    {
        return description;
    }

    @Nullable
    public String getSeverity()
    {
        return severity;
    }

    @Nullable
    public String getReaction()
    {
        return reaction;
    }

    @Nullable
    public String getIdentificationDate()
    {
        return identificationDate;
    }
    public void setName(@Nullable String name)
    {
        this.name = name;
    }

    public void setType(@Nullable String type)
    {
        this.type = type;
    }

    public void setDescription(@Nullable String description)
    {
        this.description = description;
    }

    public void setSeverity(@Nullable String severity)
    {
        this.severity = severity;
    }

    public void setReaction(@Nullable String reaction)
    {
        this.reaction = reaction;
    }

    public void setIdentificationDate(@Nullable String identificationDate)
    {
        this.identificationDate = identificationDate;
    }

    @NotNull
    public String toString()
    {
        return "Allergy(" +
            " name: " + getName() +
            " type: " + getType() +
            " description: " + getDescription() +
            " severity: " + getSeverity() +
            " reaction: " + getReaction() +
            " identificationDate: " + getIdentificationDate() + ")";
    }

    @NotNull
    public AllergyBuilder toBuilder()
    {
        return new AllergyBuilder().setName(getName())
                                   .setType(getType())
                                   .setDescription(getDescription())
                                   .setSeverity(getSeverity())
                                   .setReaction(getReaction())
                                   .setIdentificationDate(getIdentificationDate());
    }
}