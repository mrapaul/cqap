package com.lakeland.ris.ui.datamodel;

import org.codehaus.jackson.annotate.*;
import org.jetbrains.annotations.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;


public class ReportMacro
{
    @Nullable private String macroId;
    @NotNull private String name;
    @NotNull private String macro;

    public ReportMacro()
    {
        // empty
    }

    @JsonCreator
    public ReportMacro(@Nullable String macroId,
                       @NotNull String name,
                       @NotNull String macro)
    {
        super();

        this.macroId = macroId;
        this.name = name;
        this.macro = macro;
    }

    @Nullable
    public String getMacroId()
    {
        return macroId;
    }

    @NotNull
    public String getName()
    {
        return name;
    }

    @NotNull
    public String getMacro()
    {
        return macro;
    }
    public void setMacroId(@Nullable String macroId)
    {
        this.macroId = macroId;
    }

    public void setName(@NotNull String name)
    {
        this.name = name;
    }

    public void setMacro(@NotNull String macro)
    {
        this.macro = macro;
    }

    @NotNull
    public String toString()
    {
        return "ReportMacro(" +
            " macroId: " + getMacroId() +
            " name: " + getName() +
            " macro: " + getMacro() + ")";
    }

    @NotNull
    public ReportMacroBuilder toBuilder()
    {
        return new ReportMacroBuilder(getName(),
                                      getMacro()).setMacroId(getMacroId())

    ;
    }
}