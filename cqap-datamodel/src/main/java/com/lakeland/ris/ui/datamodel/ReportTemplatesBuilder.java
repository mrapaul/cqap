package com.lakeland.ris.ui.datamodel;

import org.jetbrains.annotations.*;
import java.util.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;
import java.util.*;

public class ReportTemplatesBuilder
{
    @NotNull private Collection<ReportTemplate> templates;

    public ReportTemplatesBuilder(@NotNull Collection<ReportTemplate> templates)
    {
        super();

        this.templates = templates;
    }


    @NotNull
    public ReportTemplatesBuilder setTemplates(@NotNull Collection<ReportTemplate> templates)
    {
        this.templates = templates;

        return self();
    }

    @NotNull
    protected Collection<ReportTemplate> getTemplates()
    {
        return templates;
    }

    @NotNull
    public ReportTemplates build()
    {
        return new ReportTemplates(getTemplates());
    }


    @NotNull
    protected ReportTemplatesBuilder self()
    {
        return this;
    }
}