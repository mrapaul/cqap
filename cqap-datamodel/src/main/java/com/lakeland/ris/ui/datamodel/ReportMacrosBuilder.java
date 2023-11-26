package com.lakeland.ris.ui.datamodel;

import org.jetbrains.annotations.*;
import java.util.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;
import java.util.*;

public class ReportMacrosBuilder
{
    @NotNull private Collection<ReportMacro> macros;

    public ReportMacrosBuilder(@NotNull Collection<ReportMacro> macros)
    {
        super();

        this.macros = macros;
    }


    @NotNull
    public ReportMacrosBuilder setMacros(@NotNull Collection<ReportMacro> macros)
    {
        this.macros = macros;

        return self();
    }

    @NotNull
    protected Collection<ReportMacro> getMacros()
    {
        return macros;
    }

    @NotNull
    public ReportMacros build()
    {
        return new ReportMacros(getMacros());
    }


    @NotNull
    protected ReportMacrosBuilder self()
    {
        return this;
    }
}