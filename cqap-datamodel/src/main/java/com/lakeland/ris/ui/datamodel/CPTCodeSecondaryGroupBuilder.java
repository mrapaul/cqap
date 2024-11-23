package com.lakeland.ris.ui.datamodel;


import java.util.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;
import java.util.*;

public class CPTCodeSecondaryGroupBuilder
{
    private String subspecialtySecondary;
    private Collection<String> codes;

    public CPTCodeSecondaryGroupBuilder(String subspecialtySecondary,
                                        Collection<String> codes)
    {
        super();

        this.subspecialtySecondary = subspecialtySecondary;
        this.codes = codes;
    }


    
    public CPTCodeSecondaryGroupBuilder setSubspecialtySecondary(String subspecialtySecondary)
    {
        this.subspecialtySecondary = subspecialtySecondary;

        return self();
    }

    
    public CPTCodeSecondaryGroupBuilder setCodes(Collection<String> codes)
    {
        this.codes = codes;

        return self();
    }

    
    protected String getSubspecialtySecondary()
    {
        return subspecialtySecondary;
    }

    
    protected Collection<String> getCodes()
    {
        return codes;
    }

    
    public CPTCodeSecondaryGroup build()
    {
        return new CPTCodeSecondaryGroup(getSubspecialtySecondary(),
                                         getCodes());
    }


    
    protected CPTCodeSecondaryGroupBuilder self()
    {
        return this;
    }
}