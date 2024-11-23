package com.lakeland.ris.ui.datamodel;


import java.util.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;
import java.util.*;

public class ReportMacrosBuilder
{
    private Collection<ReportMacro> macros;

    public ReportMacrosBuilder(Collection<ReportMacro> macros)
    {
        super();

        this.macros = macros;
    }



    public ReportMacrosBuilder setMacros(Collection<ReportMacro> macros)
    {
        this.macros = macros;

        return self();
    }


    protected Collection<ReportMacro> getMacros()
    {
        return macros;
    }


    public ReportMacros build()
    {
        return new ReportMacros(getMacros());
    }



    protected ReportMacrosBuilder self()
    {
        return this;
    }
}