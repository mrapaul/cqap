package com.lakeland.ris.ui.datamodel;

import org.jetbrains.annotations.*;
import java.util.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;
import java.util.*;

public class CPTCodePrimaryGroupsBuilder
{
    @NotNull private Collection<CPTCodePrimaryGroup> groups;

    public CPTCodePrimaryGroupsBuilder(@NotNull Collection<CPTCodePrimaryGroup> groups)
    {
        super();

        this.groups = groups;
    }


    @NotNull
    public CPTCodePrimaryGroupsBuilder setGroups(@NotNull Collection<CPTCodePrimaryGroup> groups)
    {
        this.groups = groups;

        return self();
    }

    @NotNull
    protected Collection<CPTCodePrimaryGroup> getGroups()
    {
        return groups;
    }

    @NotNull
    public CPTCodePrimaryGroups build()
    {
        return new CPTCodePrimaryGroups(getGroups());
    }


    @NotNull
    protected CPTCodePrimaryGroupsBuilder self()
    {
        return this;
    }
}