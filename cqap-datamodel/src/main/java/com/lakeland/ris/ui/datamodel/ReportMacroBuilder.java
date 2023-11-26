package com.lakeland.ris.ui.datamodel;

import org.jetbrains.annotations.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;


public class ReportMacroBuilder
{
    @Nullable private String macroId;
    @NotNull private String name;
    @NotNull private String macro;

    public ReportMacroBuilder(@NotNull String name,
                              @NotNull String macro)
    {
        super();

        this.name = name;
        this.macro = macro;
    }


    @NotNull
    public ReportMacroBuilder setMacroId(@Nullable String macroId)
    {
        this.macroId = macroId;

        return self();
    }

    @NotNull
    public ReportMacroBuilder setName(@NotNull String name)
    {
        this.name = name;

        return self();
    }

    @NotNull
    public ReportMacroBuilder setMacro(@NotNull String macro)
    {
        this.macro = macro;

        return self();
    }

    @Nullable
    protected String getMacroId()
    {
        return macroId;
    }

    @NotNull
    protected String getName()
    {
        return name;
    }

    @NotNull
    protected String getMacro()
    {
        return macro;
    }

    @NotNull
    public ReportMacro build()
    {
        return new ReportMacro(getMacroId(),
                               getName(),
                               getMacro());
    }


    @NotNull
    protected ReportMacroBuilder self()
    {
        return this;
    }
}