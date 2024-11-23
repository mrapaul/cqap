package com.lakeland.ris.ui.datamodel;

import org.codehaus.jackson.annotate.*;

import java.util.*;
import com.lakeland.ris.datamodel.*;


public class ReportMacro
{
     private String macroId;
    private String name;
    private String macro;

    public ReportMacro()
    {
        // empty
    }

    @JsonCreator
    public ReportMacro( String macroId,
                       String name,
                       String macro)
    {
        super();

        this.macroId = macroId;
        this.name = name;
        this.macro = macro;
    }

    
    public String getMacroId()
    {
        return macroId;
    }

    
    public String getName()
    {
        return name;
    }

    
    public String getMacro()
    {
        return macro;
    }
    public void setMacroId( String macroId)
    {
        this.macroId = macroId;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setMacro(String macro)
    {
        this.macro = macro;
    }

    
    public String toString()
    {
        return "ReportMacro(" +
            " macroId: " + getMacroId() +
            " name: " + getName() +
            " macro: " + getMacro() + ")";
    }

    
    public ReportMacroBuilder toBuilder()
    {
        return new ReportMacroBuilder(getName(),
                                      getMacro()).setMacroId(getMacroId())

    ;
    }
}