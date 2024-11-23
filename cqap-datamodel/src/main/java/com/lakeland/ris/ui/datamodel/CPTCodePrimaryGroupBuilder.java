package com.lakeland.ris.ui.datamodel;


import java.util.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;
import java.util.*;

public class CPTCodePrimaryGroupBuilder
{
    private String subspecialtyPrimary;
    private Collection<CPTCodeSecondaryGroup> secondaryGroups;

    public CPTCodePrimaryGroupBuilder(String subspecialtyPrimary,
                                      Collection<CPTCodeSecondaryGroup> secondaryGroups)
    {
        super();

        this.subspecialtyPrimary = subspecialtyPrimary;
        this.secondaryGroups = secondaryGroups;
    }



    public CPTCodePrimaryGroupBuilder setSubspecialtyPrimary(String subspecialtyPrimary)
    {
        this.subspecialtyPrimary = subspecialtyPrimary;

        return self();
    }


    public CPTCodePrimaryGroupBuilder setSecondaryGroups(Collection<CPTCodeSecondaryGroup> secondaryGroups)
    {
        this.secondaryGroups = secondaryGroups;

        return self();
    }


    protected String getSubspecialtyPrimary()
    {
        return subspecialtyPrimary;
    }


    protected Collection<CPTCodeSecondaryGroup> getSecondaryGroups()
    {
        return secondaryGroups;
    }


    public CPTCodePrimaryGroup build()
    {
        return new CPTCodePrimaryGroup(getSubspecialtyPrimary(),
                                       getSecondaryGroups());
    }



    protected CPTCodePrimaryGroupBuilder self()
    {
        return this;
    }
}