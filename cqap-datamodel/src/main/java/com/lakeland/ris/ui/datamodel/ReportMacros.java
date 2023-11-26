package com.lakeland.ris.ui.datamodel;

import org.codehaus.jackson.annotate.*;
import org.jetbrains.annotations.*;
import java.util.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;
import java.util.*;

public class ReportMacros
{
    @NotNull private Collection<ReportMacro> macros;

    public ReportMacros()
    {
        // empty
    }

    @JsonCreator
    public ReportMacros(@NotNull Collection<ReportMacro> macros)
    {
        super();

        this.macros = macros;
    }

    @NotNull
    public Collection<ReportMacro> getMacros()
    {
        return macros;
    }
    public void setMacros(@NotNull Collection<ReportMacro> macros)
    {
        this.macros = macros;
    }

    @NotNull
    public String toString()
    {
        return "ReportMacros(" +
            " macros: " + getMacros() + ")";
    }


    @Override
    public boolean equals(@Nullable Object aObject)
    {
          if (this == aObject)
          {
              return true;
          }

          if (aObject == null || getClass() != aObject.getClass())
          {
              return false;
          }

          final ReportMacros myObject = (ReportMacros) aObject;

          return Objects.equals(getMacros(), myObject.getMacros());
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(
                            getMacros());
    }

    @NotNull
    public ReportMacrosBuilder toBuilder()
    {
        return new ReportMacrosBuilder(getMacros());
    }
}