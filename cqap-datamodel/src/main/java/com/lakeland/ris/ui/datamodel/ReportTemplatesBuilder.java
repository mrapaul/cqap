package com.lakeland.ris.ui.datamodel;


import java.util.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;
import java.util.*;

public class ReportTemplatesBuilder
{
    private Collection<ReportTemplate> templates;

    public ReportTemplatesBuilder(Collection<ReportTemplate> templates)
    {
        super();

        this.templates = templates;
    }


    
    public ReportTemplatesBuilder setTemplates(Collection<ReportTemplate> templates)
    {
        this.templates = templates;

        return self();
    }

    
    protected Collection<ReportTemplate> getTemplates()
    {
        return templates;
    }

    
    public ReportTemplates build()
    {
        return new ReportTemplates(getTemplates());
    }


    
    protected ReportTemplatesBuilder self()
    {
        return this;
    }
}