package com.lakeland.ris.ui.datamodel;

import org.jetbrains.annotations.*;
import java.util.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;
import java.util.*;

public class CPTCodeSecondaryGroupBuilder
{
    @NotNull private String subspecialtySecondary;
    @NotNull private Collection<String> codes;

    public CPTCodeSecondaryGroupBuilder(@NotNull String subspecialtySecondary,
                                        @NotNull Collection<String> codes)
    {
        super();

        this.subspecialtySecondary = subspecialtySecondary;
        this.codes = codes;
    }


    @NotNull
    public CPTCodeSecondaryGroupBuilder setSubspecialtySecondary(@NotNull String subspecialtySecondary)
    {
        this.subspecialtySecondary = subspecialtySecondary;

        return self();
    }

    @NotNull
    public CPTCodeSecondaryGroupBuilder setCodes(@NotNull Collection<String> codes)
    {
        this.codes = codes;

        return self();
    }

    @NotNull
    protected String getSubspecialtySecondary()
    {
        return subspecialtySecondary;
    }

    @NotNull
    protected Collection<String> getCodes()
    {
        return codes;
    }

    @NotNull
    public CPTCodeSecondaryGroup build()
    {
        return new CPTCodeSecondaryGroup(getSubspecialtySecondary(),
                                         getCodes());
    }


    @NotNull
    protected CPTCodeSecondaryGroupBuilder self()
    {
        return this;
    }
}