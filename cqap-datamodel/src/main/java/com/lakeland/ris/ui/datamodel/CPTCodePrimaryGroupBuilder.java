package com.lakeland.ris.ui.datamodel;

import org.jetbrains.annotations.*;
import java.util.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;
import java.util.*;

public class CPTCodePrimaryGroupBuilder
{
    @NotNull private String subspecialtyPrimary;
    @NotNull private Collection<CPTCodeSecondaryGroup> secondaryGroups;

    public CPTCodePrimaryGroupBuilder(@NotNull String subspecialtyPrimary,
                                      @NotNull Collection<CPTCodeSecondaryGroup> secondaryGroups)
    {
        super();

        this.subspecialtyPrimary = subspecialtyPrimary;
        this.secondaryGroups = secondaryGroups;
    }


    @NotNull
    public CPTCodePrimaryGroupBuilder setSubspecialtyPrimary(@NotNull String subspecialtyPrimary)
    {
        this.subspecialtyPrimary = subspecialtyPrimary;

        return self();
    }

    @NotNull
    public CPTCodePrimaryGroupBuilder setSecondaryGroups(@NotNull Collection<CPTCodeSecondaryGroup> secondaryGroups)
    {
        this.secondaryGroups = secondaryGroups;

        return self();
    }

    @NotNull
    protected String getSubspecialtyPrimary()
    {
        return subspecialtyPrimary;
    }

    @NotNull
    protected Collection<CPTCodeSecondaryGroup> getSecondaryGroups()
    {
        return secondaryGroups;
    }

    @NotNull
    public CPTCodePrimaryGroup build()
    {
        return new CPTCodePrimaryGroup(getSubspecialtyPrimary(),
                                       getSecondaryGroups());
    }


    @NotNull
    protected CPTCodePrimaryGroupBuilder self()
    {
        return this;
    }
}