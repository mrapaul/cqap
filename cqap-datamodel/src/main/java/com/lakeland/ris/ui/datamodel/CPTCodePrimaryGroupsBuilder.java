package com.lakeland.ris.ui.datamodel;


import java.util.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;
import java.util.*;

public class CPTCodePrimaryGroupsBuilder
{
    private Collection<CPTCodePrimaryGroup> groups;

    public CPTCodePrimaryGroupsBuilder(Collection<CPTCodePrimaryGroup> groups)
    {
        super();

        this.groups = groups;
    }



    public CPTCodePrimaryGroupsBuilder setGroups(Collection<CPTCodePrimaryGroup> groups)
    {
        this.groups = groups;

        return self();
    }


    protected Collection<CPTCodePrimaryGroup> getGroups()
    {
        return groups;
    }


    public CPTCodePrimaryGroups build()
    {
        return new CPTCodePrimaryGroups(getGroups());
    }



    protected CPTCodePrimaryGroupsBuilder self()
    {
        return this;
    }
}