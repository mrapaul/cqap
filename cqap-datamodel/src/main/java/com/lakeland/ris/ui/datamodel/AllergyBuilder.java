package com.lakeland.ris.ui.datamodel;


import java.util.*;
import com.lakeland.ris.datamodel.*;


public class AllergyBuilder
{
     private String name;
     private String type;
     private String description;
     private String severity;
     private String reaction;
     private String identificationDate;

    public AllergyBuilder()
    {
        super();

    }


    
    public AllergyBuilder setName( String name)
    {
        this.name = name;

        return self();
    }

    
    public AllergyBuilder setType( String type)
    {
        this.type = type;

        return self();
    }

    
    public AllergyBuilder setDescription( String description)
    {
        this.description = description;

        return self();
    }

    
    public AllergyBuilder setSeverity( String severity)
    {
        this.severity = severity;

        return self();
    }

    
    public AllergyBuilder setReaction( String reaction)
    {
        this.reaction = reaction;

        return self();
    }

    
    public AllergyBuilder setIdentificationDate( String identificationDate)
    {
        this.identificationDate = identificationDate;

        return self();
    }

    
    protected String getName()
    {
        return name;
    }

    
    protected String getType()
    {
        return type;
    }

    
    protected String getDescription()
    {
        return description;
    }

    
    protected String getSeverity()
    {
        return severity;
    }

    
    protected String getReaction()
    {
        return reaction;
    }

    
    protected String getIdentificationDate()
    {
        return identificationDate;
    }

    
    public Allergy build()
    {
        return new Allergy(getName(),
                           getType(),
                           getDescription(),
                           getSeverity(),
                           getReaction(),
                           getIdentificationDate());
    }


    
    protected AllergyBuilder self()
    {
        return this;
    }
}