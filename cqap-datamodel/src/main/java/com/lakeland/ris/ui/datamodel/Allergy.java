package com.lakeland.ris.ui.datamodel;

import org.codehaus.jackson.annotate.*;

import java.util.*;
import com.lakeland.ris.datamodel.*;


public class Allergy
{
     private String name;
     private String type;
     private String description;
     private String severity;
     private String reaction;
     private String identificationDate;

    public Allergy()
    {
        // empty
    }

    @JsonCreator
    public Allergy( String name,
                    String type,
                    String description,
                    String severity,
                    String reaction,
                    String identificationDate)
    {
        super();

        this.name = name;
        this.type = type;
        this.description = description;
        this.severity = severity;
        this.reaction = reaction;
        this.identificationDate = identificationDate;
    }

    
    public String getName()
    {
        return name;
    }

    
    public String getType()
    {
        return type;
    }

    
    public String getDescription()
    {
        return description;
    }

    
    public String getSeverity()
    {
        return severity;
    }

    
    public String getReaction()
    {
        return reaction;
    }

    
    public String getIdentificationDate()
    {
        return identificationDate;
    }
    public void setName( String name)
    {
        this.name = name;
    }

    public void setType( String type)
    {
        this.type = type;
    }

    public void setDescription( String description)
    {
        this.description = description;
    }

    public void setSeverity( String severity)
    {
        this.severity = severity;
    }

    public void setReaction( String reaction)
    {
        this.reaction = reaction;
    }

    public void setIdentificationDate( String identificationDate)
    {
        this.identificationDate = identificationDate;
    }

    
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