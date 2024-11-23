package com.lakeland.ris.ui.datamodel;


import java.util.*;
import com.lakeland.ris.datamodel.*;


public class ReportMacroBuilder
{
     private String macroId;
    private String name;
    private String macro;

    public ReportMacroBuilder(String name,
                              String macro)
    {
        super();

        this.name = name;
        this.macro = macro;
    }



    public ReportMacroBuilder setMacroId( String macroId)
    {
        this.macroId = macroId;

        return self();
    }


    public ReportMacroBuilder setName(String name)
    {
        this.name = name;

        return self();
    }


    public ReportMacroBuilder setMacro(String macro)
    {
        this.macro = macro;

        return self();
    }

    
    protected String getMacroId()
    {
        return macroId;
    }


    protected String getName()
    {
        return name;
    }


    protected String getMacro()
    {
        return macro;
    }


    public ReportMacro build()
    {
        return new ReportMacro(getMacroId(),
                               getName(),
                               getMacro());
    }



    protected ReportMacroBuilder self()
    {
        return this;
    }
}